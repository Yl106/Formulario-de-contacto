package com.yq.formular;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText txt_campo1, txt_campo2, txt_campo3,
            txt_email, txt_Descripcion;
    protected TextView tvSeleccionar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_campo1 = findViewById(R.id.txt_campo1);
        txt_campo2 = findViewById(R.id.txt_campo2);
        txt_campo3 = findViewById(R.id.txt_campo3);
        txt_email = findViewById(R.id.txt_email);
        txt_Descripcion = findViewById(R.id.txt_Descripcion);
        tvSeleccionar = findViewById(R.id.tvSeleccionar);

        final Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        txt_campo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month +1;
                        String date = dayOfMonth + "/"+month+"/"+year;
                        txt_campo2.setText(date);
                    }
                }, year, month, day);
                dialog.show();
            }
        });
        tvSeleccionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month +1;
                        String date = dayOfMonth + "/"+month+"/"+year;
                        txt_campo2.setText(date);
                    }
                }, year, month, day);
                dialog.show();
            }
        });

    }
    //Botón siguiente
    public void Siguiente(View View){
        if (txt_campo1.getText().toString().isEmpty() || txt_campo2.getText().toString().isEmpty()
                || txt_campo3.getText().toString().isEmpty()|| txt_email.getText().toString().isEmpty()
                || txt_Descripcion.getText().toString().isEmpty()) {
            Toast.makeText(this, "Ingresa la información requerida", Toast.LENGTH_SHORT).show();
        }else{
            Intent siguiente = new Intent(MainActivity.this, Confirmar.class);
            siguiente.putExtra("pasardatos1",txt_campo1.getText().toString());
            siguiente.putExtra("pasardatos2",txt_campo2.getText().toString());
            siguiente.putExtra("pasardatos3",txt_campo3.getText().toString());
            siguiente.putExtra("pasardatos4",txt_email.getText().toString());
            siguiente.putExtra("pasardatos5",txt_Descripcion.getText().toString());
            startActivity(siguiente);
            onResume();
        }
    }

}
