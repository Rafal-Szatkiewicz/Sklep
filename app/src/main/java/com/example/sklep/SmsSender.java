package com.example.sklep;

import android.content.Context;
import android.telephony.SmsManager;
import android.widget.Toast;

public class SmsSender {
    public static void sendSms(Context context, String phoneNumber, String message) {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber, null, message, null, null);
            Toast.makeText(context, "SMS Sent", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(context, "SMS Failed", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}
