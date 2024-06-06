package com.example.sklep;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    private EditText registerUsernameEditText;
    private EditText registerPasswordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerUsernameEditText = findViewById(R.id.register_username);
        registerPasswordEditText = findViewById(R.id.register_password);
    }

    public void registerUser(View view) {
        String username = registerUsernameEditText.getText().toString();
        String password = registerPasswordEditText.getText().toString();

        // Logika rejestracji użytkownika (dla przykładu, wyświetlenie Toast)
        Toast.makeText(this, "User registered: " + username, Toast.LENGTH_SHORT).show();

        // Powrót do LoginActivity po rejestracji
        finish();
    }
}
