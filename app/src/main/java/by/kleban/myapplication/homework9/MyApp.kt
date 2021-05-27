package by.kleban.myapplication.homework9

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.core.app.NotificationManagerCompat


class MyApp : Application() {

    companion object {
        const val CHANNEL_ID = "ForegroundServiceId"
        const val CHANNEL_NAME = "ForegroundService Kotlin name"
    }

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = NotificationManagerCompat.from(this)
            manager.createNotificationChannel(channel)
        }
    }
}