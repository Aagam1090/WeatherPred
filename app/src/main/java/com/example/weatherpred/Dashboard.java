package com.example.weatherpred;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {
    private EditText location;
    public static String loc;
    public static TextView tempString,tempValue;
    public static ImageView tempIcon ;
    private Button Submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        initializeUiComponent();
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loc = location.getText().toString().trim();
                fetchData process = new fetchData();
                process.execute();
                show();
            }
        });
    }
    protected void initializeUiComponent()
    {
        Submit = (Button)findViewById(R.id.Submit);
        location = (EditText)findViewById(R.id.Location);
        tempString = (TextView)findViewById(R.id.tempString);
        tempValue = (TextView)findViewById(R.id.tempValue);
        tempIcon = (ImageView)findViewById(R.id.tempIcon);
        hide();
    }
    public void hide(){
        tempString.setVisibility(View.INVISIBLE);
        tempValue.setVisibility(View.INVISIBLE);
        tempIcon.setVisibility(View.INVISIBLE);
    }

    public void show(){
        tempString.setVisibility(View.VISIBLE);
        tempValue.setVisibility(View.VISIBLE);
        tempIcon.setVisibility(View.VISIBLE);
    }
}
