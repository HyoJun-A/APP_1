package com.example.app_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        Button btnR = (Button) findViewById(R.id.btnPage);
        EditText ed1 = (EditText) findViewById(R.id.edt10);
        ImageView v1 = (ImageView) findViewById(R.id.vw);
        ImageView v2 = (ImageView) findViewById(R.id.vw1);
        ImageView v3 = (ImageView) findViewById(R.id.vw2);
        

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s3 = ed1.getText().toString();
                float num = Float.parseFloat(s3);
                if (num == 1){
                    v1.setVisibility(View.VISIBLE);
                    v2.setVisibility(View.INVISIBLE);
                    v3.setVisibility(View.INVISIBLE);
                }
                else if (num == 2){
                    v1.setVisibility(View.INVISIBLE);
                    v2.setVisibility(View.VISIBLE);
                    v3.setVisibility(View.INVISIBLE);
                }
                else if (num == 3){
                    v1.setVisibility(View.INVISIBLE);
                    v2.setVisibility(View.INVISIBLE);
                    v3.setVisibility(View.VISIBLE);
                }

            }
        });
    }
}
