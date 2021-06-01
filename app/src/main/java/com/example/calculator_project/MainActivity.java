package com.example.calculator_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText edit;
    Button[] numButtons = new Button[10];
    Integer[] numBtnIDs = {
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5,
            R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
    };

    Button btnDot, btnLeft, btnRight;
    Button btnAdd, btnMinus, btnMul, btnDiv, btnAnd, btnOr, btnXor, btnNot, btnMod, btnFileOutput, btnHistory, btnResult;
    TextView TextResult;

    String text;    //입력받은 문장
    Double result;

    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("계산기 프로그램");

        edit = (EditText) findViewById(R.id.edit);
        TextResult = (TextView) findViewById(R.id.TextResult);
//      사칙연산
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnMinus = (Button)findViewById(R.id.btnMinus);
        btnDiv = (Button)findViewById(R.id.btnDiv);
        btnMul = (Button)findViewById(R.id.btnMul);

//      나머지 + 비트 연산
        btnMod = (Button)findViewById(R.id.btnMod);
        btnAnd = (Button)findViewById(R.id.btnAnd);
        btnOr = (Button)findViewById(R.id.btnOr);
        btnXor = (Button)findViewById(R.id.btnXor);
        btnNot = (Button)findViewById(R.id.btnNot);

//      점+ 괄호
        btnDot = (Button)findViewById(R.id.btnDot);
        btnLeft = (Button)findViewById(R.id.btnLeft);
        btnRight = (Button)findViewById(R.id.btnRight);

//      =, File, history
        btnFileOutput = (Button)findViewById(R.id.btnFileOutput);
        btnResult = (Button)findViewById(R.id.btnResult);
        btnHistory = (Button)findViewById(R.id.btnHistory);

//      숫자들
        for(i=0; i<numBtnIDs.length;i++){
            numButtons[i] = (Button)findViewById(numBtnIDs[i]);
        }

/*---------------------------- 버튼 클릭 이벤트 리스너--------------------------------------*/

        //숫자 버튼 클릭 시
        for(i=0; i<numBtnIDs.length; i++){
            final int index;
            index =1;

            numButtons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    text = edit.getText().toString() + numButtons[index].getText().toString();
                    edit.setText(text);
                }
            });
        }

        //사칙 연산
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = edit.getText().toString() + btnAdd.getText().toString();
                edit.setText(text);
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = edit.getText().toString() + btnMinus.getText().toString();
                edit.setText(text);
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = edit.getText().toString() + btnDiv.getText().toString();
                edit.setText(text);
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = edit.getText().toString() + btnMul.getText().toString();
                edit.setText(text);
            }
        });

        // 점 , 괄호
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = edit.getText().toString() + btnDot.getText().toString();
                edit.setText(text);
            }
        });

        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = edit.getText().toString() + btnLeft.getText().toString();
                edit.setText(text);
            }
        });

        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = edit.getText().toString() + btnRight.getText().toString();
                edit.setText(text);
            }
        });
        
        // 마지막 두번째 줄 어케할 지 고민 ㄱㄱ
    }
}