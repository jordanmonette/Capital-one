package com.example.leuhd.watchapp;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.text.ParseException;


public class MyActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "7XBgSdJXFHS58rxO8gDps6Gqi8Xr0hnjlxn8wM4A", "nLnWfK1edV7mnaPiRXeCh34X6S2mHXmM6OZhR5L5");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);



         Log.i("OnCreate", "Creating complete");
        //Button startBtn = (Button) findViewById(R.id.bottom);
        //startBtn.setOnClickListener();

    }
    public void displayNotification(View view) {
        send_parse_data();
        Log.i("displayNotification","Entered display notification");
        int notificationId = 001;
        int eventId = 1;
        // Build intent for notification content
        Intent viewIntent = new Intent(this, MyActivity.class);
        viewIntent.putExtra("EXTRA_EVENT_ID", eventId);
        PendingIntent viewPendingIntent =
                PendingIntent.getActivity(this, 0, viewIntent, 0);
        Log.i("dislayLocation","Inside display notifications...building intent compete");
        CharSequence eventTitle = "Balance Notification";
        CharSequence eventLocation = "Your balance is $500 ";
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.common_signin_btn_icon_dark)
                        .setContentTitle(eventTitle)
                        .setContentText(eventLocation)
                        .setContentIntent(viewPendingIntent);
// Get an instance of the NotificationManager service
        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(this);
// Build the notification and issues it with notification manager.
        notificationManager.notify(notificationId, notificationBuilder.build());
    }
    public void displayNotification2(View view) {
        Log.i("displayNotification","Entered display notification");
        int notificationId = 002;
        int eventId = 1;
        // Build intent for notification content
        Intent viewIntent = new Intent(this, MyActivity.class);
        viewIntent.putExtra("EXTRA_EVENT_ID", eventId);
        PendingIntent viewPendingIntent =
                PendingIntent.getActivity(this, 0, viewIntent, 0);
        Log.i("dislayLocation","Inside display notifications...building intent compete");
        CharSequence eventTitle = "Fraud Notification";
        CharSequence eventLocation = "Fraud detected ";
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.common_signin_btn_icon_disabled_dark)
                        .setContentTitle(eventTitle)
                        .setContentText(eventLocation)
                        .setContentIntent(viewPendingIntent);
// Get an instance of the NotificationManager service
        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(this);
// Build the notification and issues it with notification manager.
        notificationManager.notify(notificationId, notificationBuilder.build());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void send_parse_data() {
        ParseObject testObject = new ParseObject("User_info");
        testObject.put("username", "dhuel_fisher");
        testObject.put("bank_balance", "500");
        testObject.put("bank_location", "Jamaica");
       // Log.i("OnCreate", "Creating completeXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        testObject.saveInBackground();

        //code for getting data
//        ParseQuery<ParseObject> query = ParseQuery.getQuery("TestObject");
//           query.getInBackground("4NPsbose2l", new GetCallback<ParseObject>() {
//         public void done(ParseObject object, ParseException e) {
//            if (e == null) {
//          // object will be your game score
//        } else {
//          // something went wrong
//        }
//         }
//});

    }
}
