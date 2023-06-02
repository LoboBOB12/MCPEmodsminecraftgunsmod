package uz.akbarali.fashion.ui.service

import android.app.*
import android.content.BroadcastReceiver
import android.content.Intent
import android.os.Build
import android.os.CountDownTimer
import android.os.IBinder
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat


class BroadcastService : Service() {
    val CHANNEL_ID = "ForegroundServiceChannel"
    private val TAG = "BroadcastService"
    val COUNTDOWN_BR = "uz.akbarali.fashion.ui.service"
    var bi = Intent(COUNTDOWN_BR)

    var cdt: CountDownTimer? = null

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onCreate() {
        super.onCreate()
        cdt = object : CountDownTimer(1800000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                Log.i(TAG, "Countdown seconds remaining: " + millisUntilFinished / 1000)
                bi.putExtra("countdown", millisUntilFinished)
                bi.putExtra("countdownTimerRunning", true)
                bi.putExtra("countdownTimerFinished", false)
                sendBroadcast(bi)
            }

            override fun onFinish() {
                Log.i(TAG, "Timer finished")
                bi.putExtra("countdownTimerFinished", true)
                sendBroadcast(bi)
                stopForeground(true)
                stopSelf()
            }
        }
        (cdt as CountDownTimer).start()
    }

    override fun onDestroy() {
        cdt!!.cancel()
        Log.i(TAG, "Timer cancelled")
        bi.putExtra("countdownTimerRunning", false)
        sendBroadcast(bi)
        super.onDestroy()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        /* Notification */
        val input = intent.getStringExtra("inputExtra")
        createNotificationChannel()
        val notificationIntent = Intent(this, BroadcastReceiver::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this,
            0, notificationIntent, PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )
        /* NotificationBuilder */
        val notification: Notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Foreground Service")
            .setContentText(input)
            .setSmallIcon(uz.akbarali.fashion.R.drawable.icon_logo1)
            .setContentIntent(pendingIntent)
            .build()
        startForeground(1, notification)
        return START_NOT_STICKY
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(
                CHANNEL_ID,
                "Foreground Service Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = getSystemService(
                NotificationManager::class.java
            )
            manager.createNotificationChannel(serviceChannel)
        }
    }
}