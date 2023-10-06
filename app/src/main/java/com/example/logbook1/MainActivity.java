package com.example.logbook1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView screen;
    private Button clear, div, mul, add, sub, one, two, three, four, five, six, seven, eight, nine, zero;

    private String input, answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = findViewById(R.id.inputValue);
        clear= findViewById(R.id.buttonClear);
        div= findViewById(R.id.buttonDivide);
        mul= findViewById(R.id.buttonMultiply);
        add= findViewById(R.id.buttonPlus);
        sub= findViewById(R.id.buttonSub);
        one= findViewById(R.id.button1);
        two= findViewById(R.id.button2);
        three= findViewById(R.id.button3);
        four= findViewById(R.id.button4);
        five= findViewById(R.id.button5);
        six= findViewById(R.id.button6);
        seven= findViewById(R.id.button7);
        eight= findViewById(R.id.button8);
        nine= findViewById(R.id.button9);
        zero= findViewById(R.id.button0);
    }
    public void ButtonClick(View view){
        Button button = (Button) view;
        String data = button.getText().toString();
        switch (data){
            case "C":
                input="";
                break;
            case "answer":
                input+= answer;
                break;
            case "x":
                input+="*";
                break;
            case "=":
                solve();
                answer = input;
                break;
//            case "-":
//                String newText = input.substring(0, input.length()-1);
//                input=newText;
//                break;
            default:
                if (input==null){
                    input="";
                }
                if (data.equals("+") || data.equals("/") || data.equals("-")){
                    solve();

                }
                input += data;
        }
        screen.setText(input);
        
    }

    private void solve() {
        if (input.split("\\*").length==2){
            String[] number =input.split("\\*");
            try {
                double mul = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                input = mul + "";
            }
            catch (Exception e){

            }
        }
        else if (input.split("\\/").length==2) {
            String number[] = input.split("\\/");
            try {
                double div = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                input = div + "";
            } catch (Exception e) {

            }
        }
        else if (input.split("\\+").length==2) {
            String number[] = input.split("\\+");
            try {
                double sum = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                input = sum + "";
            } catch (Exception e) {

            }
        }
        else if (input.split("\\-").length>1) {
            String number[] = input.split("\\-");
            if (number[0]=="" && number.length==2){
                number[0]=0+"";
            }
            try {
                double sub = 0;
                if (number.length==2){
                    sub = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                }
                else if (number.length==3){
                    sub =  - Double.parseDouble(number[1]) - Double.parseDouble(number[2]);
                }
                input = sub+"";
            } catch (Exception e) {

            }
        }

        String[] n =input.split("\\.");
        if (n.length>1){
            if (n[1].equals("0")){
                input=n[0];
            }
        }
        screen.setText(input);
    }

}