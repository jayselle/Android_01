package com.jayselle.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.jayselle.entities.Pelicula;
import com.jayselle.validator.OwnException;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    private static final String TAG = "TAG";

    private static final String DB_NAME = "mydb";
    private static final Integer DB_VERSION = 1;

    private static final String TABLE_PELICULAS = "peliculas";
    private static final String ID = "_id";
    private static final String NOMBRE = "nombre";
    private static final String AÑO = "año";

    SQLiteDatabase myDB;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE " + TABLE_PELICULAS + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NOMBRE + " TEXT, " +
                AÑO + " TEXT) ;";

        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertPelicula(Integer id, String nombre, Integer año) throws OwnException {

        try {
            ContentValues values = new ContentValues();
            values.put(ID,id);
            values.put(NOMBRE,nombre);
            values.put(AÑO,año);
            myDB = getWritableDatabase();
            Long resultado = myDB.insert(TABLE_PELICULAS, null, values);
            if (resultado == -1) {
                throw new OwnException("Error de BD");
            }
        } catch (Exception e) {
                throw new OwnException("Error de BD");
        } finally {
            if (myDB.isOpen()){
                myDB.close();
            }
        }
    }

    public List<Pelicula> obtenerPeliculas() throws OwnException{

        try {

            myDB = getWritableDatabase();

            String cols[] = {ID, NOMBRE, AÑO};

            Cursor cursor = myDB.query(TABLE_PELICULAS, cols, null, null, null, null, null);
            cursor.moveToFirst();

            List<Pelicula> listadoPelicula = new ArrayList<>();

            while (!cursor.isAfterLast()) {
                Pelicula p = new Pelicula(cursor.getInt(0), cursor.getString(1), cursor.getInt(2));
                listadoPelicula.add(p);
                cursor.moveToNext();
            }

            return listadoPelicula;

        } catch (Exception e){
            throw new OwnException("Error al cargar pelis");
        } finally {
            if (myDB.isOpen()){
                myDB.close();
            }
        }

    }

}
