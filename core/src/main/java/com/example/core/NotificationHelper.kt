package com.example.core

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.AudioAttributes
import android.net.Uri
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.net.toUri


object NotificationHelper {

    private const val CHANNEL_ID = "sultanin_kanalinin_idsi"


    fun showNotification(context: Context, title: String, subTitle: String, startPoint: Intent) {

        val pendingIntent: PendingIntent = PendingIntent.getActivity(
            context,
            0, startPoint, PendingIntent.FLAG_IMMUTABLE
        )
        val soundAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_NOTIFICATION)
            .build()
        val sound = "android.resources://" + context.packageName + "/" + R.raw.budilnik
        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle(title)
            .setContentText(subTitle)
            .setSound(sound.toUri())
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_HIGH)

        var notificationManager: NotificationManager? = null
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Mesaj"
            val descriptionText = "Sultanin Kanali"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val mChannel = NotificationChannel(CHANNEL_ID, name, importance)
            mChannel.setSound(sound.toUri(), soundAttributes)
            mChannel.description = descriptionText
            notificationManager = getSystemService(context, NotificationManager::class.java)
            notificationManager?.createNotificationChannel(mChannel)
            builder.setChannelId(CHANNEL_ID)
        }
        notificationManager?.notify(1234, builder.build())
    }


}