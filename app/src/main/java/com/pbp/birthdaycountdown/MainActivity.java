package com.pbp.birthdaycountdown;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.widget.DatePicker;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText name, date;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.nama);
        DatePicker bdtime = (DatePicker) findViewById(R.id.datePicker);

        btn = (Button) findViewById(R.id.save);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //For Displaying data after Submit input
                    String nama = name.getText().toString();
                    int day = bdtime.getDayOfMonth();
                    int month = bdtime.getMonth();
                    int year = bdtime.getYear();
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(year, month, day);
                    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/");
                    String nowtime = sdf.format(new Date()) + year;
                    SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
                    String datehbd = format.format(calendar.getTime());
                    Date date1;
                    Date date2;
                    date2 = format.parse(nowtime);
                    date1 = format.parse(datehbd);
                    long difference = (date1.getTime() - date2.getTime());
                    long differenceDates;
                    if (difference <0){
                        differenceDates = 365 + (difference / (24 * 60 * 60 * 1000));
                    }
                    else {
                        differenceDates = difference / (24 * 60 * 60 * 1000);
                    }
                    String dayDifference = Long.toString(differenceDates);
                    String str = "Hai " +nama+ ", Ultahmu Kurang "+dayDifference+"  Hari Lagi";
                    Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                    intent.putExtra("message_key", str);
                    startActivity(intent);
                }
                catch(Exception exception) {
                    Toast.makeText(getApplicationContext(), "Hai , Ultahmu Kurang 100 Hari Lagi", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}