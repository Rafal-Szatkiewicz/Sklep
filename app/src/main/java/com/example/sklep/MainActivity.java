package com.example.sklep;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.new_order:
                startActivity(new Intent(this, OrderActivity.class));
                return true;
            case R.id.order_list:
                startActivity(new Intent(this, OrderListActivity.class));
                return true;
            case R.id.login:
                startActivity(new Intent(this, LoginActivity.class));
                return true;
            case R.id.info:
                // Display info about the author
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
