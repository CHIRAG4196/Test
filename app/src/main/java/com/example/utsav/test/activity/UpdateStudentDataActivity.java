package com.example.utsav.test.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.RadioGroup;

import com.example.utsav.test.R;

public class UpdateStudentDataActivity extends AppCompatActivity {
    private AppCompatEditText etName, etEmail, etMobile;
    private AppCompatButton btnUpdate;
    private AppCompatSpinner spnBatch;
    private RadioGroup rgGender;
    private AppCompatRadioButton rbGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_student_data);

        etEmail = (AppCompatEditText) findViewById(R.id.et_email);
        etMobile = (AppCompatEditText) findViewById(R.id.et_number);
        etName = (AppCompatEditText) findViewById(R.id.et_user);
        btnUpdate = (AppCompatButton) findViewById(R.id.btn_update);
        spnBatch = (AppCompatSpinner) findViewById(R.id.spn_batch);
        rgGender = (RadioGroup) findViewById(R.id.rg_gender);
        int selectedid = rgGender.getCheckedRadioButtonId();
        rbGender = (AppCompatRadioButton) findViewById(selectedid);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
