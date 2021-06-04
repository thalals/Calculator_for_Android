package com.example.calculator_project;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {

    EditText edit;
    Button[] numButtons = new Button[10];
    Integer[] numBtnIDs = {
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5,
            R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
    };

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

    Button btnDot, btnLeft, btnRight;
    Button btnAdd, btnMinus, btnMul, btnDiv, btnAnd, btnOr, btnXor, btnNot, btnMod, btnFileOutput, btnHistory, btnResult;
    TextView TextResult;

    String text;    //입력받은 문장
    String[] HistoryStore = new String[50];
    int HistroyCount = 0;

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

        for(i=0; i<numRadiobtnIds.length;i++){
            numRadioButtons[i] = (RadioButton) findViewById(numRadiobtnIds[i]);
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
                Deque<String> ResultLine = new LinkedList<>();         //연산식 Deque에 저장 LinkedList를 이용해 구현
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
                        if(ResultLine.isEmpty() | isOperator(ResultLine.peekLast())){
                            init();
                            Toast.makeText(getApplicationContext(), "연산자 입력이 잘 못 되었습니다. 다시 입력해주세요",Toast.LENGTH_SHORT).show();
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
                        }
                    }
                    //그 외에 다른 문자가 입력되어진 경우
                    else{
                        init();
                        Toast.makeText(getApplicationContext(), "문자 입력이 잘 못 되었습니다. 다시 입력해주세요",Toast.LENGTH_SHORT).show();
                    }
                }
                // for 문 종료
                if(!number.equals(""))
                    ResultLine.add(number);
                //괄호가 다 안닫혔을때
                if(LeftCount>0){
                    init();
                    Toast.makeText(getApplicationContext(), "괄호를 닫아주세요. 다시 입력해주세요",Toast.LENGTH_SHORT).show();
                }

                //ResultLine : 계산식 type : Deque History에 저장
                if(HistroyCount==50)
                    HistroyCount=0;

                String str = "";
                for(String a : ResultLine)
                    str=str+a;
                //History 메뉴 계산식 update
                //최근 50개 저장
                HistoryStore[HistroyCount++] = str;


                // 계산 : 1. 후위표기식 2. 후위표기식 계산
                ArrayList<String> tempList = new ArrayList<>();
                Double result = PostfixResult(ChangePostfix(ResultLine));

                init();
                TextResult.setText(result.toString());
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

        //기록
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),historyActivity.class);

                intent.putExtra("Historystore",HistoryStore);   //저장된 계산식 배열 전송

                startActivityForResult(intent,0);
            }
        });

    }

    //outIntent
    //startActivityForResult로 실행한 액티비티가 종료되면 호출
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            String txt = data.getStringExtra("Copyhistiory");
            edit.setText(txt);
        }
    }

    //후위표기식 계산
    Double PostfixResult(ArrayList<String> postfixLine){
        Double result = 0.0;
        Stack<String> stack = new Stack<>();

        for(String str : postfixLine){
            //피연산자일 경우
            if(isNumber(str))
                stack.push(str);
            //연산자일 경우
            else{
                String two = stack.pop();
                String one = stack.pop();
                Double temp = Calculator(one,two,str);
                stack.push(temp.toString());
            }
        }
        result = Double.parseDouble(stack.pop());
        return result;
    }

    //연산자 계산
    Double Calculator(String num1, String num2, String Operator){
        Double result = 0.0;

        Double one = Double.parseDouble(num1);
        Double two = Double.parseDouble(num2);

        int intone = (int) Math.round(one);
        int inttwo = (int) Math.round(two);

        switch(Operator){
            case "+":
                result = one + two;
                break;
            case "-":
                result = one - two;
                break;
            case "x":
                result = one * two;
                break;
            case "/":
                result = one / two;
                break;
            case "%":
                result = one % two;
                break;
            case "&":
                result = (intone&inttwo) + 0.0;
                break;
            case "~":
                result = (~inttwo) + 0.0;
                break;
            case "^":
                result = (intone^inttwo) + 0.0;
                break;
            case "|":
                result = (intone|inttwo) + 0.0;
                break;
        }

        return result;
    }
    //중위표기식을 후위표기식으로
    ArrayList ChangePostfix(Deque<String> LineList){
        ArrayList<String> Postfix = new ArrayList<>();

        Stack<String> stack = new Stack<String>();
        String temp;
        while(!LineList.isEmpty()){
            temp = LineList.poll();

            //연산자는
            if(isNumber(temp))
                Postfix.add(temp);

            //"(" 무조건 스택에 push
            else if(temp.equals("(")){
                stack.push(temp);
            }
            //")" "("를 만날 때 까지 pop
            else if(temp.equals(")")){
                String str;
                while(!stack.isEmpty()){
                    str = stack.pop();
                    if(str.equals("("))
                        break;

                    Postfix.add(str);
                }
            }
            //연산자 일 때
            else{
                //스택이 비어있거나 최 상단이 ( 일 때
                if(stack.isEmpty())
                    stack.push(temp);

                else if(stack.peek().equals("("))
                    stack.push(temp);

                else if(PriOperator(temp) <= PriOperator(stack.peek())){
                    Postfix.add(stack.pop());
                }
                else
                    stack.push(temp);
            }
        }

        while(!stack.isEmpty())
            Postfix.add(stack.pop());

        return Postfix;
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

    //연산자 우선순위 반환
    int PriOperator(String str){
        int result = -1;
        switch (str){
            case "+" :
            case "-" :
                result = 3;
            case "x" :
            case "/" :
            case "%" :
                result = 2;
                break;
            case "&" :
                result = 4;
                break;
            case "^" :
                result = 5;
                break;
            case "~" :
                result = 1;
                break;
            case "|" :
                result = 6;
                break;
        }

        return result;
    }
    
    //연산자 판별
    boolean isOperator(String str){
        boolean result = false;
        switch (str){
            case "+" :
            case "-" :
            case "x" :
            case "/" :
            case "%" :
            case "&" :
            case "^" :
            case "~" :
            case "|" :
                result = true;
                break;
        }

        return result;
    }
}