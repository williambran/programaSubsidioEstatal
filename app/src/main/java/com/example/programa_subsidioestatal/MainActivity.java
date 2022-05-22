package com.example.programa_subsidioestatal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etNumeroHijos,etHijosEscolar;
    private TextView tvTotalHijos,tvHijosEscolar,tvViudez,tvSubsidio;
    private RadioButton radioViudez;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumeroHijos = findViewById(R.id.et_NumHijos);
        etHijosEscolar=findViewById(R.id.et_NumHijosEdadEscolar);

        tvTotalHijos=findViewById(R.id.tv_totalHijos);
        tvHijosEscolar=findViewById(R.id.tv_hijosEscolares);
        tvViudez=findViewById(R.id.tv_viudez);
        tvSubsidio=findViewById(R.id.tv_subsidio);

        radioViudez=findViewById(R.id.rb_viudad);

        btnCalcular=findViewById(R.id.btn_process);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                procesar_subsidio();
            }
        });

    }

    public void procesar_subsidio() {
        int numHijos, numEsc;
        double subNum, subNumEsc, subViudes = 0,subTotal;
        String numHijosString = etNumeroHijos.getText().toString();
        String numHijosEscString = etHijosEscolar.getText().toString();

        numHijos = Integer.parseInt(numHijosString);
        numEsc = Integer.parseInt(numHijosEscString);


        if(numHijos <= 2){
            subNum = 1700.0;
        }else if(numHijos <= 5)  {
            subNum = 1900;
        }else {
            subNum = 1200;
        }
        subNumEsc = numEsc * 200;

        if(radioViudez.isChecked() ){
            subViudes = 800;
        }

        subTotal = subViudes + subNumEsc +subNum;

        String subNumString = "", subNumEscString ="", subViudesString ="", total = "";

        subNumString = "El monto del Subsidio por numero de hijos  :" + subNum + "\n";
        subNumEscString = "El subsidio por hijos en edad Escolar :" + subNumEsc + "\n";
        subViudesString = "El subsidio por viudez es   :" + subViudes + "\n";
        total = "El monto del Subsidio total acumulado es :" + subTotal + "\n";


        tvTotalHijos.setText(subNumString);
        tvHijosEscolar.setText(subNumEscString);
        tvViudez.setText(subViudesString);
        tvSubsidio.setText(total);



    }



}