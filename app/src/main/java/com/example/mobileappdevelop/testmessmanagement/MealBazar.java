package com.example.mobileappdevelop.testmessmanagement;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_LONG;

public class MealBazar extends AppCompatActivity {
    ListView mealBazarLV;
    ArrayList<Member>members;
    MealBazarCustomAdapter mealBazarCustomAdapter;

    Button datePickerButton;  // Date picker part start
    int year_x, month_x, day_x;
    static final int DIALOG_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_bazar);


        mealBazarLV = (ListView) findViewById(R.id.mealBazarListView);
        Member member = new Member();
        members = member.allMember();

        mealBazarCustomAdapter = new MealBazarCustomAdapter(this,members);
        mealBazarLV.setAdapter(mealBazarCustomAdapter);

        showDialog(); // Date picker part
    }

    public void showDialog(){ // Date picker part
        datePickerButton = (Button) findViewById(R.id.ExamDateButton);
        datePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DIALOG_ID);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id){
        if(id == DIALOG_ID)
            return new DatePickerDialog(this, dpickerListener, year_x, month_x, day_x);
        return null;
    }

    private DatePickerDialog.OnDateSetListener dpickerListener
            = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            year_x = i;
            month_x = i1;
            day_x = i2;
            Toast.makeText(MealBazar.this,year_x+"/ "+month_x+"/ "+day_x, LENGTH_LONG).show();
        }
    };
}
