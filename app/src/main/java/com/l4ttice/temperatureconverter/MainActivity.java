package com.l4ttice.temperatureconverter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static int accurac=3;
    public static String trimmer(float input){
        String inp=String.valueOf(input);
        String output="";int accu = accurac; boolean flag=false;
        for (int i=0;i<inp.length();i++){
            if (inp.charAt(i)=='.')
                flag=true;
            if (!flag)
                output=output+inp.charAt(i);
            else{
                if (accu>0){
                    output=output+inp.charAt(i);
                    accu=accu-1;
                }
                else
                    return output;
            }
        }
        return postProcessing(output);
    }
    public static String postProcessing(String input){
        String output="";boolean flag=true;
        for (int i=0;i<input.length();i++){
            char ch=input.charAt(i);
            if(ch!='.'){
                output=output+ch;
            }
            else{
                if (flag){
                    flag=false;
                    output=output+ch;
                }
            }
        }
        if (output.charAt(output.length()-1)=='.'){
            return output.substring(0,output.length()-1);
        }
        else
            return output;
    }

    public void SendMessage(View view){
        EditText Celsius=(EditText) findViewById(R.id.editText);
        EditText Fahrenheit=(EditText) findViewById(R.id.editText2);

        TextView text=(TextView) findViewById(R.id.textView);

        String FahrenheitSt=Fahrenheit.getText().toString().trim();
        String CelsiusSt=Celsius.getText().toString().trim();

        if (FahrenheitSt.equals(CelsiusSt)){
            Toast.makeText(this, "Please enter a Number",Toast.LENGTH_LONG).show();
        }
        else if(CelsiusSt.isEmpty() || CelsiusSt.length() == 0 || CelsiusSt.equals("") || CelsiusSt == null)
        {
            //EditText is empty
            float temp=(Float.valueOf(Fahrenheit.getText().toString()) - 32) * 5 / 9;
            text.setText(Fahrenheit.getText()+"°F is "+trimmer(temp)+"°C");
            Fahrenheit.setText("");
            Celsius.setText("");

        }
        else
        {
            //EditText is not empty
            float temp=((Float.valueOf(Celsius.getText().toString()) * 9) / 5) + 32;
            text.setText(Celsius.getText()+"°C  is  "+trimmer(temp)+"°F");
            Celsius.setText("");
            Fahrenheit.setText("");
        }
    }

    public void Settings(View view){
        Intent intent = new Intent(this,SettingsActivity.class);
        startActivity(intent);
    }
}
