package com.jayselle.android_01;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.*;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.jayselle.android_01.AgregarPeliculaActivity;
import com.jayselle.android_01.R;
import com.jayselle.entities.Pelicula;
import com.jayselle.helper.DBHelper;
import com.jayselle.validator.OwnException;

import java.util.List;

public class ListadoPeliculasFragment extends Fragment {

    private static final String TAG = "TAG";

    DBHelper dbHelper;
    ListView listadoView;
    List<Pelicula> listadoPelicula;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.listapelis_layout,container,false);
        getActivity().setTitle("Listado de Pelis");
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dbHelper = new DBHelper(getActivity().getApplicationContext());
        listadoView = getView().findViewById(R.id.listadoView);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_pelis,menu);
        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(getContext(), AgregarPeliculaActivity.class);
        startActivityForResult(intent,123);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();
        try {
            listadoPelicula = dbHelper.obtenerPeliculas();
            if (listadoPelicula.size()!=0){
                ArrayAdapter<Pelicula> arrayAdapter = new ArrayAdapter<>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, listadoPelicula);
                listadoView.setAdapter(arrayAdapter);
            } else {
                Toast.makeText(getActivity().getApplicationContext(),"No hay peliculas",Toast.LENGTH_SHORT).show();
            }
        } catch (OwnException oe){
            Log.e("TAG",oe.getMsj());
            Toast.makeText(getActivity().getApplicationContext(),oe.getMsj(),Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if (requestCode == 123){
            if (resultCode == -1){
                Integer id = Integer.parseInt(data.getStringExtra("id"));
                String nombre = data.getStringExtra("nombre");
                Integer año = Integer.parseInt(data.getStringExtra("año"));
                try {
                    dbHelper.insertPelicula(id,nombre,año);
                    Toast.makeText(getActivity().getApplicationContext(),"¡Éxito!",Toast.LENGTH_SHORT).show();
                } catch (OwnException oe){
                    Log.e(TAG,oe.getMsj());
                    Toast.makeText(getActivity().getApplicationContext(),oe.getMsj(),Toast.LENGTH_LONG).show();
                }
            }

        }

    }

}
