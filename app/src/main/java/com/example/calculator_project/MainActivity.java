package com.example.calculator_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import javax.xml.transform.Result;

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
    Double Nubmerresult;

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
            index =i;

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
        
        // 비트 연산
        btnAnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = edit.getText().toString() + "&";
                edit.setText(text);
            }
        });
        btnOr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = edit.getText().toString() + "|";
                edit.setText(text);
            }
        });
        btnXor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = edit.getText().toString() + "^";
                edit.setText(text);
            }
        });
        btnNot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = edit.getText().toString() + "~";
                edit.setText(text);
            }
        });

        //나머지
        btnMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = edit.getText().toString() + btnMod.getText().toString();
                edit.setText(text);
            }
        });

        //결과 버튼(에러 체크 and 문자별 슬라이스)
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = edit.getText().toString();

                String LineWord[] = text.split("");
                ArrayList<String> ResultLine = new ArrayList<>();

                String number="";

                boolean DotFlag = false;
                int LeftCount = 0;      //괄호 check

                for(String ch : LineWord){
                    //연자 오는것이 숫자 일때
                    if(isNumber(ch)){
                        number = number + ch;
                        continue;
                    }
                    //점 일때
                    else if(ch.equals(".") ){
                        if(!DotFlag){
                            number = number + ch;
                            DotFlag = true;
                            continue;
                        }
                        //한 수에 점이 2개 이상 올 때 에러
                        else{
                            DotFlag = false;
                            init();
                            Toast.makeText(getApplicationContext(), " . 입력이 잘 못 되었습니다. 다시 입력해주세요",Toast.LENGTH_SHORT).show();
                            break;
                        }
                    }

                    //연산자 일 때 +++ 연산자가 왔을 때 예외 처리 사항 더 추가해야함
                    else if(isOperator(ch)){
                        // 저장해둔 number 추가해주기
                        if(!number.equals("")) {
                            ResultLine.add(number);
                            DotFlag = false;            //DotFlag도 초기화
                            number="";
                        }
                        // 연산자가 맨 앞에 올 때 && 연속으로 연산자가 올 때
                        if(ResultLine.isEmpty() && isOperator(ResultLine.get(ResultLine.size()-1))){
                            init();
                            Toast.makeText(getApplicationContext(), "연산자 입력이 잘 못 되었습니다. 다시 입력해주세요",Toast.LENGTH_SHORT).show();
                            break;
                        }
                        else
                            ResultLine.add(ch);
                    }

                    // 괄호 일 때(왼쪽)
                    else if(ch.equals("(")){
                        // 저장해둔 number 추가해주기
                        if(!number.equals("")) {
                            ResultLine.add(number);
                            DotFlag = false;            //DotFlag도 초기화
                            number="";
                        }

                        ResultLine.add(ch);
                        LeftCount++;
                    }
                    // 오른쪽 괄호 일 때
                    else if(ch.equals(")")){
                        if(LeftCount>0) {
                            // 저장해둔 number 추가해주기
                            if(!number.equals("")) {
                                ResultLine.add(number);
                                DotFlag = false;            //DotFlag도 초기화
                                number="";
                            }

                            ResultLine.add(ch);
                            LeftCount--;
                        }
                        else{
                            init();
                            Toast.makeText(getApplicationContext(), "괄호 입력이 잘 못 되었습니다. 다시 입력해주세요",Toast.LENGTH_SHORT).show();
                            break;
                        }
                    }
                    //그 외에 다른 문자가 입력되어진 경우
                    else{
                        init();
                        Toast.makeText(getApplicationContext(), "문자 입력이 잘 못 되었습니다. 다시 입력해주세요",Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
                // for 문 종료
                if(!number.equals(""))
                    ResultLine.add(number);

                String a = "";
                for(String y : ResultLine)
                    a= a+y;

                init();
                TextResult.setText(a);
            }
        });

        //파일로
        btnFileOutput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = edit.getText().toString() + "~";
                edit.setText(text);
            }
        });
    }

    // 초기화
    void init(){
        text = "";
        edit.setText("");
    }
    // 숫자 판별
    boolean isNumber(String str) {
        boolean result = true;
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException e) {
            result = false;
        }
        return result;
    }

    //연산자 판별
    boolean isOperator(String str){
        boolean result = false;
        switch (str){
            case "+" :
                result = true;
                break;
            case "-" :
                result = true;
                break;
            case "x" :
                result = true;
                break;
            case "/" :
                result = true;
                break;
            case "%" :
                result = true;
                break;
            case "&" :
                result = true;
                break;
            case "^" :
                result = true;
                break;
            case "~" :
                result = true;
                break;
            case "|" :
                result = true;
                break;
        }

        return result;
    }
}