package com.jayselle.validator;

import android.widget.EditText;

import java.util.Iterator;
import java.util.List;

public class Validator {

    public static void validarCamposVacios(List<EditText> campos) throws OwnException{
        Iterator<EditText> iter = campos.iterator();
        while (iter.hasNext()){
            if (iter.next().getText().toString().isEmpty()){
                throw new OwnException("Completar todos los campos");
            }
        }

    }

    public static void validarNumeric(EditText campo) throws OwnException{
        try{
            Integer.parseInt(campo.getText().toString());
        } catch (Exception e){
            throw new OwnException("Ver formato");
        }
    }

}
