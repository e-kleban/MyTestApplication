package by.kleban.myapplication.homework9

import android.app.Notification
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import by.kleban.myapplication.R


class MyForegroundService : Service() {

    companion object {
        const val EXTRA_STRING = "extra string"
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val intentService = Intent(this, MysteryFinalActivity::class.java).
         putExtra(MysteryFinalActivity.EXTRA_FINAL_STRING,intent?.extras?.getString(EXTRA_STRING))

        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intentService, PendingIntent.FLAG_CANCEL_CURRENT
        )

        val notification = NotificationCompat.Builder(this, MyApp.CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_compost_24)
            .setContentTitle("Advice")
            .setContentText("You have new message")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setCategory(Notification.CATEGORY_SERVICE)
            .setStyle(NotificationCompat.BigTextStyle())
            .setContentIntent(pendingIntent)
            .addAction(R.drawable.ic_baseline_compost_24,"open",pendingIntent)
            .build()

        startForeground(1, notification)
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}

