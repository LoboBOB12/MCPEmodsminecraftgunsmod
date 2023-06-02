package uz.akbarali.fashion

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class SingleInstallBroadcastReceiver : Activity() {

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
    }

    override fun onStart() {
        super.onStart()
        val intent = intent
        if (intent != null) {
            val referrer = intent.getStringExtra("referrer")
            if (referrer != null) {
                // Process the referrer data here
            }
        }
        finish()
    }
}