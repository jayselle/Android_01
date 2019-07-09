package com.jayselle.android_01;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.jayselle.android_01.R;

public class CalculadoraFragment extends Fragment {

    EditText edtValor1;
    EditText edtValor2;
    Button btnSumar;
    Button btnResta;
    Button btnMultiplicacion;
    Button btnDivision;
    TextView txtResultado;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.calculadora_layout,container,false);
        getActivity().setTitle("Calculadora");
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        edtValor1 = view.findViewById(R.id.edtValor1);
        edtValor2 = view.findViewById(R.id.edtValor2);
        btnSumar = view.findViewById(R.id.btnSumar);
        btnResta = view.findViewById(R.id.btnResta);
        btnMultiplicacion = view.findViewById(R.id.btnMultiplicacion);
        btnDivision = view.findViewById(R.id.btnDivision);
        txtResultado = view.findViewById(R.id.txtResultado);

        btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Float valor1 = Float.parseFloat(edtValor1.getText().toString());
                    Float valor2 = Float.parseFloat(edtValor2.getText().toString());
                    Float resultado = valor1 + valor2;
                    txtResultado.setText(resultado.toString());
                } catch (Exception e){
                    Toast.makeText(getActivity().getApplicationContext(),"Error",Toast.LENGTH_LONG);
                }
            }
        });

        btnResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Float valor1 = Float.parseFloat(edtValor1.getText().toString());
                    Float valor2 = Float.parseFloat(edtValor2.getText().toString());
                    Float resultado = valor1 - valor2;
                    txtResultado.setText(resultado.toString());
                } catch (Exception e){
                    Toast.makeText(getActivity().getApplicationContext(),"Error",Toast.LENGTH_LONG);
                }
            }
        });

        btnMultiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Float valor1 = Float.parseFloat(edtValor1.getText().toString());
                    Float valor2 = Float.parseFloat(edtValor2.getText().toString());
                    Float resultado = valor1 * valor2;
                    txtResultado.setText(resultado.toString());
                } catch (Exception e){
                    Toast.makeText(getActivity().getApplicationContext(),"Error",Toast.LENGTH_LONG);
                }
            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Float valor1 = Float.parseFloat(edtValor1.getText().toString());
                    Float valor2 = Float.parseFloat(edtValor2.getText().toString());
                    Float resultado = valor1 / valor2;
                    txtResultado.setText(resultado.toString());
                } catch (Exception e){
                    Toast.makeText(getActivity().getApplicationContext(),"Error",Toast.LENGTH_LONG);
                }
            }
        });
    }

}
