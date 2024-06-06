package com.example.sklep;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class EmailSender {
    public static void sendEmail(Context context, String subject, String message, String to) {
        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
        email.putExtra(Intent.EXTRA_SUBJECT, subject);
        email.putExtra(Intent.EXTRA_TEXT, message);
        email.setType("message/rfc822");
        context.startActivity(Intent.createChooser(email, "Choose an Email client:"));
    }
}
