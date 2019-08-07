package com.example.manage;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    TextInputEditText TextInputEditText_Player, TextInputEditText_Date, TextInputEditText_PW;
    Button button_enjoy;
    String Password = "1920";
    String inputPassword = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        TextInputEditText_Player    = findViewById(R.id.TextInputEditText_Player);
        TextInputEditText_Date      = findViewById(R.id.TextInputEditText_Date);
        TextInputEditText_PW        = findViewById(R.id.TextInputEditText_PW);
        button_enjoy                = findViewById(R.id.button_enjoy);

        button_enjoy.setClickable(false);
        TextInputEditText_PW.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence != null){
                    Log.d("SENTI",charSequence.toString());
                    inputPassword = charSequence.toString();
                    button_enjoy.setEnabled(validation());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });





        button_enjoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("SENTI","onClick");

                String date = TextInputEditText_Date.getText().toString();
                String player = TextInputEditText_Player.getText().toString();

                Intent intent = new Intent(MainActivity.this, Second.class);
                intent.putExtra("date", date);
                intent.putExtra("player", player);
                startActivity(intent);


            }
        });
    }
    public boolean validation() {
        Log.d("SENTI",  inputPassword + " / "  + (inputPassword.equals(Password)));
        return inputPassword.equals(Password);
    }
}
