package com.example.manage;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputEditText;


public class Second extends AppCompatActivity {

    TextView TextView_get;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView_get = findViewById(R.id.TextView_get);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        String date = bundle.getString("date");
        String player = bundle.getString("player");
        TextView_get.setText("날짜:" + date + '/'+ player + "명");

        int n = Integer.parseInt(player);
        int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, getResources().getDisplayMetrics());

        LinearLayout myLayout = findViewById(R.id.mylayout1);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                width,
                android.widget.LinearLayout.LayoutParams.WRAP_CONTENT);
        for(int i=0;i<n;i++){
            EditText name = new EditText(this);
            name.setId(i);
            name.setLayoutParams(params);
            name.setInputType(0x00000061);
            myLayout.addView(name);
        }


    }
}
