package com.example.room_learning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnSaveMain = findViewById(R.id.main_save_btn);
        Button btnShowMain = findViewById(R.id.main_show_btn);

        btnSaveMain.setOnClickListener(v -> {
            User user = new User();
            user.uid = 2;
            user.firstName = "ali";
            user.lastName = "doran";
            AppDatabase.getInstance(this).userDao().insertAll(user);
        });

            btnShowMain.setOnClickListener(v -> {
                List<User> userList =AppDatabase.getInstance(this).userDao().getAll();
                     Toast.makeText(MainActivity.this, userList.get(0).firstName
                            + userList.get(0).lastName
                            + userList.get(0).uid, Toast.LENGTH_SHORT);
            });
        }
    }