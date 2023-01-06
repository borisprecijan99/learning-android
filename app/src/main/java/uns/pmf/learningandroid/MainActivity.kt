package uns.pmf.learningandroid

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationCompat.Action
import uns.pmf.learningandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    private var notificationManager: NotificationManager? = null
    private val channelId = "uns.pmf.learningandroid.channel1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        createNotificationChannel(channelId, "Channel Name", "Channel Description")

        activityMainBinding.showNotificationButton.setOnClickListener {
            showNotification()
        }
    }

    private fun showNotification() {
        val newActivityIntent = Intent(this, NewActivity::class.java)
        val pendingIntent: PendingIntent =
            PendingIntent.getActivity(this, 0, newActivityIntent, PendingIntent.FLAG_IMMUTABLE)
        val action: Action = Action.Builder(0, "Action", pendingIntent).build()
        val notification = NotificationCompat.Builder(this, channelId)
            .setContentTitle("Title")
            .setContentText("Text")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            //.setContentIntent(pendingIntent)
            .addAction(action)
            .build()
        notificationManager?.notify(2023, notification)
    }

    private fun createNotificationChannel(id: String, name: String, description: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_HIGH
            val notificationChannel = NotificationChannel(id, name, importance)
            notificationChannel.description = description
            notificationManager?.createNotificationChannel(notificationChannel)
        }
    }
}