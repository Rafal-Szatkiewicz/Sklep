package com.example.sklep;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class OrderActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    Spinner spinnerComputer, spinnerKeyboard, spinnerMouse, spinnerOther;
    EditText editPrice, editName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        myDb = new DatabaseHelper(this);

        spinnerComputer = findViewById(R.id.spinnerComputer);
        spinnerKeyboard = findViewById(R.id.spinnerKeyboard);
        spinnerMouse = findViewById(R.id.spinnerMouse);
        spinnerOther = findViewById(R.id.spinnerOther);
        editPrice = findViewById(R.id.editPrice);
        editName = findViewById(R.id.editName);

        List<Device> computerDevices = new ArrayList<>();
        computerDevices.add(new Device(R.drawable.ic_launcher_background, "Computer A"));
        computerDevices.add(new Device(R.drawable.ic_launcher_background, "Computer B"));
        computerDevices.add(new Device(R.drawable.ic_launcher_background, "Computer C"));

        List<Device> keyboardDevices = new ArrayList<>();
        keyboardDevices.add(new Device(R.drawable.ic_launcher_background, "Keyboard A"));
        keyboardDevices.add(new Device(R.drawable.ic_launcher_background, "Keyboard B"));
        keyboardDevices.add(new Device(R.drawable.ic_launcher_background, "Keyboard C"));

        List<Device> mouseDevices = new ArrayList<>();
        mouseDevices.add(new Device(R.drawable.ic_launcher_background, "Mouse A"));
        mouseDevices.add(new Device(R.drawable.ic_launcher_background, "Mouse B"));
        mouseDevices.add(new Device(R.drawable.ic_launcher_background, "Mouse C"));

        List<Device> otherDevices = new ArrayList<>();
        otherDevices.add(new Device(R.drawable.ic_launcher_background, "Camera"));
        otherDevices.add(new Device(R.drawable.ic_launcher_background, "Monitor"));

        DeviceAdapter computerAdapter = new DeviceAdapter(this, computerDevices);
        spinnerComputer.setAdapter(computerAdapter);

        DeviceAdapter keyboardAdapter = new DeviceAdapter(this, keyboardDevices);
        spinnerKeyboard.setAdapter(keyboardAdapter);

        DeviceAdapter mouseAdapter = new DeviceAdapter(this, mouseDevices);
        spinnerMouse.setAdapter(mouseAdapter);

        DeviceAdapter otherAdapter = new DeviceAdapter(this, otherDevices);
        spinnerOther.setAdapter(otherAdapter);
    }

    public void saveOrder(View view) {
        String computer = ((Device) spinnerComputer.getSelectedItem()).getDescription();
        String keyboard = ((Device) spinnerKeyboard.getSelectedItem()).getDescription();
        String mouse = ((Device) spinnerMouse.getSelectedItem()).getDescription();
        String other = ((Device) spinnerOther.getSelectedItem()).getDescription();
        String price = editPrice.getText().toString();
        String name = editName.getText().toString();
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());

        if (name.isEmpty()) {
            Toast.makeText(this, "Name cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean isInserted = myDb.insertData(computer, keyboard, mouse, other, price, date, name, "");

        if (isInserted) {
            Toast.makeText(this, "Order Saved", Toast.LENGTH_SHORT).show();
            editPrice.setText("");
        } else {
            Toast.makeText(this, "Order not Saved", Toast.LENGTH_SHORT).show();
        }
    }
}
