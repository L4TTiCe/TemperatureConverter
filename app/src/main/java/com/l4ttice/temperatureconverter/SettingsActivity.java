package com.l4ttice.temperatureconverter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SettingsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void onButtonPress(View view){
        Intent intent = getIntent();

        EditText text=(EditText)findViewById(R.id.editText3);
        try {
            MainActivity.accurac=Integer.parseInt(text.getText().toString())+1;
        }
        catch (NumberFormatException e){
            MainActivity.accurac=3;
            //Toast.makeText(this, "Using 2 as Accuracy parameter",Toast.LENGTH_LONG).show();
        }
        finally {
            Toast.makeText(this, "Using "+(MainActivity.accurac-1)+" as Accuracy parameter",Toast.LENGTH_LONG).show();
        }

        Intent intent0 = new Intent(this,MainActivity.class);
        startActivity(intent0);
    }
}
