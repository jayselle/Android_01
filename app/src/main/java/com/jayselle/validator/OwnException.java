package com.jayselle.validator;

public class OwnException extends Exception{

    private String mensaje;

    public OwnException(String msj){
        this.mensaje = msj;
    }

    public String getMsj() {
        return mensaje;
    }
}
