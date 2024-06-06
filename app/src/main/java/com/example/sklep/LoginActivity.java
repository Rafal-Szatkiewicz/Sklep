package com.example.sklep;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
    }

    // Metoda obsługująca logowanie
    public void login(View view) {
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        // Sprawdź dane logowania (dla przykładu, sprawdzenie statyczne)
        if (username.equals("admin") && password.equals("admin")) {
            Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
            // Przejdź do głównej aktywności po udanym logowaniu
            startActivity(new Intent(this, MainActivity.class));
            finish();
        } else {
            Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show();
        }
    }

    // Metoda obsługująca rejestrację (przykład)
    public void register(View view) {
        // Przejdź do aktywności rejestracji
        startActivity(new Intent(this, RegisterActivity.class));
    }
}
