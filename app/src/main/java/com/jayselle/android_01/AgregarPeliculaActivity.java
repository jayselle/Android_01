package com.jayselle.android_01;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.jayselle.validator.OwnException;
import com.jayselle.validator.Validator;

import java.util.ArrayList;
import java.util.List;

public class AgregarPeliculaActivity extends AppCompatActivity {

    private static final String TAG = "TAG";

    EditText edtId;
    EditText edtNombre;
    EditText edtAño;
    Button btnGuardar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregarpeli_layout);

        setTitle("Agregar");

        edtId = findViewById(R.id.edtId);
        edtNombre = findViewById(R.id.edtNombre);
        edtAño = findViewById(R.id.edtAño);
        btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<EditText> campos = new ArrayList<>();
                campos.add(edtId);
                campos.add(edtNombre);
                campos.add(edtAño);
                try {
                    Validator.validarCamposVacios(campos);
                    Validator.validarNumeric(edtId);
                    Validator.validarNumeric(edtAño);
                    Intent intento = new Intent();
                    intento.putExtra("id",edtId.getText().toString());
                    intento.putExtra("nombre",edtNombre.getText().toString());
                    intento.putExtra("año",edtAño.getText().toString());
                    setResult(-1,intento);
                    finish();
                } catch (OwnException oe){
                    Log.e(TAG,oe.getMsj());
                    Toast.makeText(getApplicationContext(),oe.getMsj(),Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
