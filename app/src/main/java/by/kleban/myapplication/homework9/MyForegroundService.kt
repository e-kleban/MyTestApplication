package by.kleban.myapplication.homework9

import android.app.Notification
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import by.kleban.myapplication.R


class MyForegroundService : Service() {

    companion object {
        const val EXTRA_STRING = "extra string"
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val intentService = Intent(this, MysteryFinalActivity::class.java)
        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intentService, 0)

        val notification = NotificationCompat.Builder(this, MyApp.CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_compost_24)
            .setContentTitle("Advice")
            .setContentText(intent?.getStringExtra(EXTRA_STRING))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setCategory(Notification.CATEGORY_SERVICE)
            .setStyle(NotificationCompat.BigTextStyle())
            .setContentIntent(pendingIntent)
            .build()

        startForeground(1, notification)
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}

