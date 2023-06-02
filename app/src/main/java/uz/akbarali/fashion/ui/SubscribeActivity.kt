package uz.akbarali.fashion.ui

import android.content.*
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.android.billingclient.api.*
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import uz.akbarali.fashion.R
import uz.akbarali.fashion.databinding.ActivitySubscribeBinding
import uz.akbarali.fashion.ui.service.BroadcastService
// Создаем имя файла для SharedPreferences
private val SHARED_PREFS_NAME = "my_prefs"

// Создаем ключ для параметра, который мы будем сохранять
private val PARAMETER_KEY = "my_parameter"

// Объявляем переменную SharedPreferences
private lateinit var sharedPreferences: SharedPreferences


class SubscribeActivity : AppCompatActivity(), PurchasesUpdatedListener {
    lateinit var binding: ActivitySubscribeBinding
    private val TAG = "CountdownTimer"
    var tvTimer: TextView? = null
    var tvTimerRunningState: TextView? = null
    var tvTimerFinishedState: TextView? = null
    private lateinit var billingClient: BillingClient
    private lateinit var buttonSubscribe: Button
    private lateinit var skuDetails: SkuDetails


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubscribeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handleStartTimer(binding.root)





        // Инициализация AppsFlyer SDK
        val appsFlyerConversionListener = object : AppsFlyerConversionListener {
            override fun onConversionDataSuccess(conversionData: MutableMap<String, Any>?) {
                // Обработка успешного получения данных о конверсии
            }

            override fun onConversionDataFail(errorMessage: String?) {
                // Обработка ошибки получения данных о конверсии
            }

            override fun onAppOpenAttribution(conversionData: MutableMap<String, String>?) {
                // Обработка данных о привлечении приложения из фона
            }

            override fun onAttributionFailure(errorMessage: String?) {
                // Обработка ошибки получения данных о привлечении
            }
        }

        AppsFlyerLib.getInstance().init("Y9Ehkv8UMQqwtTwUgw6Bg", appsFlyerConversionListener, this)
        AppsFlyerLib.getInstance().start(this)



















        // Инициализируем SharedPreferences
        sharedPreferences = getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

        binding.imageView.setOnClickListener {

            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }



        binding.layout2.setOnClickListener {

            subscribe()



        }
        setupBillingClient()


    }




    private fun setupBillingClient() {
        billingClient = BillingClient.newBuilder(this)
            .setListener(this)
            .enablePendingPurchases()
            .build()

        billingClient.startConnection(object : BillingClientStateListener {
            override fun onBillingSetupFinished(billingResult: BillingResult) {
                if (billingResult.responseCode == BillingClient.BillingResponseCode.OK) {
                    loadSkuDetails()
                }
            }

            override fun onBillingServiceDisconnected() {
                setupBillingClient()
            }
        })
    }

    private fun loadSkuDetails() {
        val skuList = ArrayList<String>()

        //подписочный ключ
        skuList.add("subnew.bulling")

        val params = SkuDetailsParams.newBuilder()
            .setSkusList(skuList)
            .setType(BillingClient.SkuType.SUBS)
            .build()

        billingClient.querySkuDetailsAsync(params) { billingResult, skuDetailsList ->
            if (billingResult.responseCode == BillingClient.BillingResponseCode.OK && skuDetailsList != null) {
                skuDetails = skuDetailsList[0]
            }
        }
    }

    private fun subscribe() {
        if (::skuDetails.isInitialized) {
            val flowParams = BillingFlowParams.newBuilder()
                .setSkuDetails(skuDetails)
                .build()

            billingClient.launchBillingFlow(this, flowParams)
        } else {
            Toast.makeText(this, "Информация о подписке недоступна", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onPurchasesUpdated(billingResult: BillingResult, purchases: MutableList<Purchase>?) {
        if (billingResult.responseCode == BillingClient.BillingResponseCode.OK && purchases != null) {
            for (purchase in purchases) {
                handlePurchase(purchase)
            }
        } else if (billingResult.responseCode == BillingClient.BillingResponseCode.USER_CANCELED) {
            Log.d("MainActivity", "Purchase cancelled")
        } else {
            Log.e("MainActivity", "Error purchasing: ${billingResult.debugMessage}")
        }
    }

    private fun handlePurchase(purchase: Purchase) {

        // Сохраняем параметр в SharedPreferences
        val editor = sharedPreferences.edit()
        editor.putInt(PARAMETER_KEY, 1)
        editor.apply()



        startActivity(Intent(this, MainActivity::class.java))
        finish()

    }



























    private fun Timer() {
        object : CountDownTimer((1800000).toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val second = millisUntilFinished / 1000 % 60
                val minutes = millisUntilFinished / (1000 * 60) % 60
                binding.timer.setText("$minutes:$second")
            }

            override fun onFinish() {
//                tvCountdown.setText("Fin")
//                btnCountdown.setEnabled(true)
            }
        }.start()
    }

    private fun handleStartTimer(view: View?) {
        val intent = Intent(this, BroadcastService::class.java)
        intent.putExtra("inputExtra", "")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            ContextCompat.startForegroundService(this, intent)
        } else {
            startService(intent)
        }
        Log.i(TAG, "timerStarted")
    }

    fun handleCancelTimer(view: View?) {
        val intent = Intent(this, BroadcastService::class.java)
        stopService(intent)
    }

    /* CountDown */
    private val broadcastReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            intent?.let { updateGUI(it) }
        }
    }

    override fun onResume() {
        super.onResume()
        registerReceiver(broadcastReceiver, IntentFilter(BroadcastService().COUNTDOWN_BR))
        Log.i(TAG, "Registered broadcast receiver")
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(broadcastReceiver)
        Log.i(TAG, "Unregistered broadcast receiver")
    }

    override fun onStop() {
        try {
            unregisterReceiver(broadcastReceiver)
        } catch (e: Exception) {
            // Receiver was probably already stopped in onPause()
        }
        super.onStop()
    }

    private fun updateGUI(intent: Intent) {
        if (intent.extras != null) {
            val millisUntilFinished = intent.getLongExtra("countdown", 0)
            val seconds = millisUntilFinished / 1000 % 60
            val minutes = millisUntilFinished / (1000 * 60) % 60
            val time = "$minutes : $seconds"
            if (seconds == 0L && minutes == 0L) {
                handleCancelTimer(binding.root.rootView)
            }
            binding.timer.text = time
            val countdownTimerRunning = intent.getBooleanExtra("countdownTimerRunning", false)
//            tvTimerRunningState = findViewById<View>(R.id.tvTimerRunningState)
//            if (countdownTimerRunning) {
//                tvTimerRunningState.setText("CountdownTimerRunning")
//            } else {
//                tvTimer.setText("0 : 0 : 0")
//                tvTimerRunningState.setText("CountdownTimerNotRunning")
//            }
//            val countdownTimerFinished = intent.getBooleanExtra("countdownTimerFinished", false)
//            tvTimerFinishedState = findViewById<View>(R.id.tvTimerFinishedState)
//            if (countdownTimerFinished) {
//                tvTimerFinishedState.setText("Finished")
//            } else {
//                tvTimerFinishedState.setText("Unfinished")
//            }
        }
    }
}