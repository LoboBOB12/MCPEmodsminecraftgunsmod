package uz.akbarali.fashion
import com.onesignal.OneSignal


class Application : android.app.Application() {
    override fun onCreate() {
        super.onCreate()

            // Enable verbose OneSignal logging to debug issues if needed.
            OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

            // OneSignal Initialization
            OneSignal.initWithContext(this);
        val ONESIGNAL_APP_ID ="2bbf4e73-84ad-4ee7-8a1d-182556324553"
        OneSignal.setAppId(ONESIGNAL_APP_ID);

            // promptForPushNotifications will show the native Android notification permission prompt.
            // We recommend removing the following code and instead using an In-App Message to prompt for notification permission (See step 7)
            OneSignal.promptForPushNotifications();

        }

    }
