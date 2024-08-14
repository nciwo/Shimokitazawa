package com.renia.shimokitazawa;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        if (Build.VERSION.SDK_INT >= 23) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // parameter를 하나만 받는 getColor() 메소드는 deprecated라서 getTheme()을 통해 테마를 가져와야 함
//            window.setStatusBarColor(this.getResources().getColor(R.color.primaryColor));
            window.setStatusBarColor(this.getResources().getColor(R.color.primaryColor, getTheme()));
        }



        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < 100; ++i) {
            list.add(String.format("TRIP %d", i));
        }

        RecyclerView recyclerView = findViewById(R.id.trip_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        TripListAdapter adapter = new TripListAdapter(list);
        recyclerView.setAdapter(adapter);

    }
}