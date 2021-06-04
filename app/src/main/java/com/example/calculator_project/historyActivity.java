package com.example.calculator_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class historyActivity extends Activity {
    Button btnback,btncopy;
    RadioGroup RadioHistroryValue;
    TextView ResultTxt;
    RadioButton[] numRadioButtons = new RadioButton[50];
    Integer[] numRadiobtnIds = {
            R.id.RadioCheck1, R.id.RadioCheck2,R.id.RadioCheck3,R.id.RadioCheck4,R.id.RadioCheck5,R.id.RadioCheck6,
            R.id.RadioCheck7,R.id.RadioCheck8,R.id.RadioCheck9,R.id.RadioCheck10,R.id.RadioCheck11,R.id.RadioCheck12,
            R.id.RadioCheck13,R.id.RadioCheck14,R.id.RadioCheck15,R.id.RadioCheck16,R.id.RadioCheck17,
            R.id.RadioCheck18,R.id.RadioCheck19,R.id.RadioCheck20,R.id.RadioCheck21,R.id.RadioCheck22,R.id.RadioCheck23,
            R.id.RadioCheck24,R.id.RadioCheck25,R.id.RadioCheck26,R.id.RadioCheck27,R.id.RadioCheck28,R.id.RadioCheck29,
            R.id.RadioCheck30,R.id.RadioCheck31,R.id.RadioCheck32,R.id.RadioCheck33,R.id.RadioCheck34,R.id.RadioCheck35,
            R.id.RadioCheck36,R.id.RadioCheck37,R.id.RadioCheck38,R.id.RadioCheck39,R.id.RadioCheck40,R.id.RadioCheck41,
            R.id.RadioCheck42,R.id.RadioCheck43,R.id.RadioCheck44,R.id.RadioCheck45,R.id.RadioCheck46,R.id.RadioCheck47,
            R.id.RadioCheck48,R.id.RadioCheck49,R.id.RadioCheck50
    };
    
    String Copyhistiory;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);       //history.xml 연동

        btnback = (Button)findViewById(R.id.btnback);
        btncopy = (Button)findViewById(R.id.btncopy);
        RadioHistroryValue = (RadioGroup)findViewById(R.id.RadioHistroryValue);
        


        Intent intent = getIntent();    //데이터 받아오기
        String getHistoryStore[] = intent.getStringArrayExtra("Historystore");  //저장되어있는 계산식

        //라디오 버튼 객체 생성
        //저장된 계산식 불러오기
        for(int i=0; i<numRadiobtnIds.length;i++){
            if(getHistoryStore[i]==null)
                break;
            numRadioButtons[i] = (RadioButton) findViewById(numRadiobtnIds[i]);
            numRadioButtons[i].setText(getHistoryStore[i]);
        }

        //돌아가기 버튼
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //복사 버튼
        btncopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(RadioHistroryValue.getCheckedRadioButtonId()!=-1) {

                    RadioButton rbtn = (RadioButton)findViewById(RadioHistroryValue.getCheckedRadioButtonId());

                    Copyhistiory = rbtn.getText().toString();

                    Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
                    outIntent.putExtra("Copyhistiory", Copyhistiory);   //Type(string) : Copyhistory : 복사할 계산식
                    setResult(RESULT_OK, outIntent);
                    finish();
                }
                finish();
            }
        });
    }
}
