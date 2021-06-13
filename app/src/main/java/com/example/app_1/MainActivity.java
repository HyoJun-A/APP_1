package com.example.app_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edt1, edt2;
    TextView result;
    String calculation,resultBMI;
    int result1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = (EditText) findViewById(R.id.edt1);  // 키를 입력받을 값
        edt2 = (EditText) findViewById(R.id.edt2); //  무게를 입력 받을 값
        result = (TextView) findViewById(R.id.result); //bmi지수를 계산하고 결과를 알려주는 값

        Button btnNewActivity = (Button) findViewById(R.id.btn2);

        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("result", result1);
                startActivity(intent);
            }
        });
    }

    public void calculationBMI(View view) {
        String s1 = edt1.getText().toString();  //키의 값을 입력받아 저장
        String s2 = edt2.getText().toString();  //무게의 값을 입력받아 저장

        float height = Float.parseFloat(s1);     //실수로 입력을 받음
        float weigt = Float.parseFloat(s2);

        float bmi = weigt / ((height /100)*(height /100));        //bim 계산식

        if(bmi < 18.5){                     //bmi계산식을 받아서 정해줌
            resultBMI = "저체중 입니다.";
            result1 = 0;
            result.setTextColor(Color.GRAY);

        }
        else if (bmi >= 18.5 && bmi < 23){
            resultBMI = "정상 입니다.";
            result1 = 1;
            result.setTextColor(Color.BLACK);

        }
        else if(bmi >= 23 && bmi <25){
            resultBMI = "과체중 입니다.";
            result1 = 2;
            result.setTextColor(Color.BLUE);

        }
        else if(bmi >=25 && bmi <30){
            resultBMI = "비만 입니다.";
            result1 = 3;
            result.setTextColor(Color.MAGENTA);

        }
        else{
            resultBMI = "고도비만 입니다";
            result1 = 4;
            result.setTextColor(Color.RED);

        }

        
        calculation =  "검사결과:\n"+"bmi지수:" + bmi + "\n" + resultBMI; // bmi값

        result.setText(calculation);        //bmi의 값을 result값에 넣어줌
    }
}