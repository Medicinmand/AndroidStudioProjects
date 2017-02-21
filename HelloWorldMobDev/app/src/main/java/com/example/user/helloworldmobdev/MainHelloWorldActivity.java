package com.example.user.helloworldmobdev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;

public class MainHelloWorldActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_hello_world);
        Button hitMeButton = (Button) findViewById(R.id.buttonHitMe);
        final TextView hitMETextView = (TextView) findViewById(R.id.textView2);
        hitMETextView.setVisibility(View.GONE);

        hitMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitMETextView.setVisibility(View.VISIBLE);
                Log.d("TestHitMeLog","This is a debug statement on HitMeButton");
            }
        });
    }
}
