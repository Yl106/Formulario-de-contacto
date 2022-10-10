package com.yq.formular;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class Confirmar extends AppCompatActivity {

    protected TextView tvEjemploN, tvEjemploD, tvEjemploT, tvEjemploC, tvEjemploDes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar);

        TextView tvEjemploN = findViewById(R.id.tvEjemploN);
        TextView tvEjemploD = findViewById(R.id.tvEjemploD);
        TextView tvEjemploT = findViewById(R.id.tvEjemploT);
        TextView tvEjemploC = findViewById(R.id.tvEjemploC);
        TextView tvEjemploDes = findViewById(R.id.tvEjemploDes);

        String datosobtenidos1 = getIntent().getStringExtra("pasardatos1");
        String datosobtenidos2 = getIntent().getStringExtra("pasardatos2");
        String datosobtenidos3 = getIntent().getStringExtra("pasardatos3");
        String datosobtenidos4 = getIntent().getStringExtra("pasardatos4");
        String datosobtenidos5 = getIntent().getStringExtra("pasardatos5");

        tvEjemploN.setText(datosobtenidos1);
        tvEjemploD.setText(datosobtenidos2);
        tvEjemploT.setText(datosobtenidos3);
        tvEjemploC.setText(datosobtenidos4);
        tvEjemploDes.setText(datosobtenidos5);
    }

    //Botón anterior
    public void Anterior(View View){
        Intent anterior = new Intent(Confirmar.this, MainActivity.class);
        startActivity(anterior);
        onResume();
    }

    //Confirmación
    public void Aceptar(View v){
        Snackbar.make(v, getResources().getString(R.string.mensaje),Snackbar.LENGTH_LONG)
                .setAction(getResources().getString(R.string.texto_accion), new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.i("SNACKBAR", "Click en Snackbar");
                    }
                })
                .setActionTextColor(getResources().getColor(R.color.blue_200))
                .show();
    }
}