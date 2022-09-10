package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.internal.TextWatcherAdapter;

public class MainActivity extends AppCompatActivity {
    EditText etAmount;
    TextView tvpercent;
    SeekBar sbpercent;
    TextView tvtip;
    TextView tvtotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etAmount= findViewById(R.id.et_amount);
        tvpercent=findViewById(R.id.tv_percent);
        sbpercent=findViewById(R.id.sb_percent);
        tvtip=findViewById(R.id.tv_tip);
        tvtotal=findViewById(R.id.tv_total);




        sbpercent.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                int percent = progress;
                tvpercent.setText(String.valueOf(percent)+"%");
                calculate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        etAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                calculate();

            }
        });

    }
    private void calculate(){
        if (etAmount.length()==0){
            etAmount.requestFocus();
            etAmount.setError("Enter Amount");
        }else {
            double amount=Double.parseDouble(etAmount.getText().toString());
            int percent = sbpercent.getProgress();
            double tip = amount*percent/100.0;
            double total=amount+tip;
            tvtip.setText(String.valueOf(tip));
            tvtotal.setText(String.valueOf(total));
        }
    }
}