package com.jayselle.android_01;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.jayselle.android_01.R;

public class CompartirFragment extends Fragment {

    private static final String TAG = "TAG";

    EditText edtTextoCompartir;
    Button btnCompartir;
    ReceptorEstadoRed receptorEstadoRed;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.compartir_layout,container,false);
        getActivity().setTitle("Envio");
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        edtTextoCompartir = view.findViewById(R.id.edtTextoCompartir);
        btnCompartir = view.findViewById(R.id.btnCompartir);
        receptorEstadoRed = new ReceptorEstadoRed();

        btnCompartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto = edtTextoCompartir.getText().toString();
                if (!texto.isEmpty()){
                    Intent intentoEnviar = new Intent();
                    intentoEnviar.setAction(Intent.ACTION_SEND);
                    intentoEnviar.putExtra(Intent.EXTRA_TEXT,texto);
                    intentoEnviar.setType("text/plain");
                    startActivity(intentoEnviar);
                } else {
                    Toast.makeText(getActivity().getApplicationContext(),"Escribir algo",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
        Activity act = getActivity();
        act.registerReceiver(receptorEstadoRed,intentFilter);
        Toast.makeText(getContext(),"AirPlaneReceiver Actived",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPause() {
        super.onPause();
        getActivity().unregisterReceiver(receptorEstadoRed);
        Toast.makeText(getContext(),"AirPlaneReceiver Desactived",Toast.LENGTH_SHORT).show();
    }
}
