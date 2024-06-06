package com.example.sklep;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import androidx.appcompat.app.AppCompatActivity;

public class OrderListActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);

        try {
            myDb = new DatabaseHelper(this);
            listView = findViewById(R.id.listView);

            if (myDb == null) {
                throw new NullPointerException("DatabaseHelper is null");
            }
            if (listView == null) {
                throw new NullPointerException("ListView is null");
            }

            Cursor cursor = myDb.getAllData();
            if (cursor == null) {
                throw new NullPointerException("Cursor is null");
            }

            String[] from = new String[] {
                    DatabaseHelper.COL_2,
                    DatabaseHelper.COL_3,
                    DatabaseHelper.COL_4,
                    DatabaseHelper.COL_5,
                    DatabaseHelper.COL_6,
                    DatabaseHelper.COL_7,
                    DatabaseHelper.COL_8
            };
            int[] to = new int[] {
                    R.id.computer,
                    R.id.keyboard,
                    R.id.mouse,
                    R.id.other,
                    R.id.price,
                    R.id.date,
                    R.id.name
            };

            SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                    this, R.layout.order_item, cursor, from, to, 0);
            listView.setAdapter(adapter);
        } catch (Exception e) {
            Log.e("OrderListActivity", "Error in onCreate", e);
        }
    }
}
