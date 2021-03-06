package com.example.calculator_project;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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

    String text;    //???????????? ??????
    String[] HistoryStore = new String[50];
    int HistroyCount = 0;

    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("????????? ????????????");

        edit = (EditText) findViewById(R.id.edit);
        TextResult = (TextView) findViewById(R.id.TextResult);
//      ????????????
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnMinus = (Button)findViewById(R.id.btnMinus);
        btnDiv = (Button)findViewById(R.id.btnDiv);
        btnMul = (Button)findViewById(R.id.btnMul);

//      ????????? + ?????? ??????
        btnMod = (Button)findViewById(R.id.btnMod);
        btnAnd = (Button)findViewById(R.id.btnAnd);
        btnOr = (Button)findViewById(R.id.btnOr);
        btnXor = (Button)findViewById(R.id.btnXor);
        btnNot = (Button)findViewById(R.id.btnNot);

//      ???+ ??????
        btnDot = (Button)findViewById(R.id.btnDot);
        btnLeft = (Button)findViewById(R.id.btnLeft);
        btnRight = (Button)findViewById(R.id.btnRight);

//      =, File, history
        btnFileOutput = (Button)findViewById(R.id.btnFileOutput);
        btnResult = (Button)findViewById(R.id.btnResult);
        btnHistory = (Button)findViewById(R.id.btnHistory);

//      ?????????
        for(i=0; i<numBtnIDs.length;i++){
            numButtons[i] = (Button)findViewById(numBtnIDs[i]);
        }

        for(i=0; i<numRadiobtnIds.length;i++){
            numRadioButtons[i] = (RadioButton) findViewById(numRadiobtnIds[i]);
        }
/*---------------------------- ?????? ?????? ????????? ?????????--------------------------------------*/

        //?????? ?????? ?????? ???
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

        //?????? ??????
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

        // ??? , ??????
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
        
        // ?????? ??????
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

        //?????????
        btnMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = edit.getText().toString() + btnMod.getText().toString();
                edit.setText(text);
            }
        });

        //?????? ??????(?????? ?????? and ????????? ????????????)
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = edit.getText().toString();

                String LineWord[] = text.split("");
                Deque<String> ResultLine = new LinkedList<>();         //????????? Deque??? ?????? LinkedList??? ????????? ??????
                String number="";

                boolean DotFlag = false;
                int LeftCount = 0;      //?????? check

                for(String ch : LineWord){
                    //?????? ???????????? ?????? ??????
                    if(isNumber(ch)){
                        number = number + ch;
                        continue;
                    }
                    //??? ??????
                    else if(ch.equals(".") ){
                        if(!DotFlag){
                            number = number + ch;
                            DotFlag = true;
                            continue;
                        }
                        //??? ?????? ?????? 2??? ?????? ??? ??? ??????
                        else{
                            DotFlag = false;
                            init();
                            Toast.makeText(getApplicationContext(), " . ????????? ??? ??? ???????????????. ?????? ??????????????????",Toast.LENGTH_SHORT).show();
                            break;
                        }
                    }

                    //????????? ??? ??? +++ ???????????? ?????? ??? ?????? ?????? ?????? ??? ???????????????
                    else if(isOperator(ch)){
                        // ???????????? number ???????????????
                        if(!number.equals("")) {
                            ResultLine.add(number);
                            DotFlag = false;            //DotFlag??? ?????????
                            number="";
                        }
                        // ???????????? ??? ?????? ??? ??? && ???????????? ???????????? ??? ???
                        if(ResultLine.isEmpty() | isOperator(ResultLine.peekLast())){
                            init();
                            Toast.makeText(getApplicationContext(), "????????? ????????? ??? ??? ???????????????. ?????? ??????????????????",Toast.LENGTH_SHORT).show();
                        }
                        else
                            ResultLine.add(ch);
                    }

                    // ?????? ??? ???(??????)
                    else if(ch.equals("(")){
                        // ???????????? number ???????????????
                        if(!number.equals("")) {
                            ResultLine.add(number);
                            DotFlag = false;            //DotFlag??? ?????????
                            number="";
                        }

                        ResultLine.add(ch);
                        LeftCount++;
                    }
                    // ????????? ?????? ??? ???
                    else if(ch.equals(")")){
                        if(LeftCount>0) {
                            // ???????????? number ???????????????
                            if(!number.equals("")) {
                                ResultLine.add(number);
                                DotFlag = false;            //DotFlag??? ?????????
                                number="";
                            }

                            ResultLine.add(ch);
                            LeftCount--;
                        }
                        else{
                            init();
                            Toast.makeText(getApplicationContext(), "?????? ????????? ??? ??? ???????????????. ?????? ??????????????????",Toast.LENGTH_SHORT).show();
                        }
                    }
                    //??? ?????? ?????? ????????? ??????????????? ??????
                    else{
                        init();
                        Toast.makeText(getApplicationContext(), "?????? ????????? ??? ??? ???????????????. ?????? ??????????????????",Toast.LENGTH_SHORT).show();
                    }
                }
                // for ??? ??????
                if(!number.equals(""))
                    ResultLine.add(number);
                //????????? ??? ???????????????
                if(LeftCount>0){
                    init();
                    Toast.makeText(getApplicationContext(), "????????? ???????????????. ?????? ??????????????????",Toast.LENGTH_SHORT).show();
                }

                //ResultLine : ????????? type : Deque History??? ??????
                if(HistroyCount==50)
                    HistroyCount=0;

                String str = "";
                for(String a : ResultLine)
                    str=str+a;
                //History ?????? ????????? update
                //?????? 50??? ??????
                HistoryStore[HistroyCount++] = str;


                // ?????? : 1. ??????????????? 2. ??????????????? ??????
                ArrayList<String> tempList = new ArrayList<>();
                Double result = PostfixResult(ChangePostfix(ResultLine));

                init();
                TextResult.setText(str+" = "+result.toString());
            }
        });

        //?????????(????????? ????????? ?????? ??????)
        btnFileOutput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //????????? ?????? ?????? ?????? ??????
                    //Mode_private : ?????? ??????, Mode_append : ?????? ??????
                    FileOutputStream outFs = openFileOutput("History.txt", Context.MODE_PRIVATE);
//                    FileOutputStream outFs = new FileOutputStream("/?????? ?????????/Download/calculator/history.txt");
                    for(i=0;i<HistoryStore.length;i++){
                        if(HistoryStore[i]==null)
                            break;
                        outFs.write(HistoryStore[i].getBytes());
                        outFs.write(13);
                    }

                    outFs.close();
//                    File file = new File("/data/user/0/com.example.calculator_project/files/History.txt");
                    Toast.makeText(getApplicationContext(),"History.txt ??? ????????? ?????? ??????",Toast.LENGTH_SHORT).show();
                }catch (IOException e){}
            }
        });

        //??????
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),historyActivity.class);

                intent.putExtra("Historystore",HistoryStore);   //????????? ????????? ?????? ??????

                startActivityForResult(intent,0);
            }
        });

    }

    //outIntent
    //startActivityForResult??? ????????? ??????????????? ???????????? ??????
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            String txt = data.getStringExtra("Copyhistiory");
            edit.setText(txt);
        }
    }

    //??????????????? ??????
    Double PostfixResult(ArrayList<String> postfixLine){
        Double result = 0.0;
        Stack<String> stack = new Stack<>();

        for(String str : postfixLine){
            //??????????????? ??????
            if(isNumber(str))
                stack.push(str);
            //???????????? ??????
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

    //????????? ??????
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
    //?????????????????? ?????????????????????
    ArrayList ChangePostfix(Deque<String> LineList){
        ArrayList<String> Postfix = new ArrayList<>();

        Stack<String> stack = new Stack<String>();
        String temp;
        while(!LineList.isEmpty()){
            temp = LineList.poll();

            //????????????
            if(isNumber(temp))
                Postfix.add(temp);

            //"(" ????????? ????????? push
            else if(temp.equals("(")){
                stack.push(temp);
            }
            //")" "("??? ?????? ??? ?????? pop
            else if(temp.equals(")")){
                String str;
                while(!stack.isEmpty()){
                    str = stack.pop();
                    if(str.equals("("))
                        break;

                    Postfix.add(str);
                }
            }
            //????????? ??? ???
            else{
                //????????? ??????????????? ??? ????????? ( ??? ???
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
    // ?????????
    void init(){
        text = "";
        edit.setText("");
    }
    // ?????? ??????
    boolean isNumber(String str) {
        boolean result = true;
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException e) {
            result = false;
        }
        return result;
    }

    //????????? ???????????? ??????
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
    
    //????????? ??????
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