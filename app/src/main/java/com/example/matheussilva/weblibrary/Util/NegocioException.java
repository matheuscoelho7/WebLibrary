package com.example.matheussilva.weblibrary.Util;

/**
 * Created by matheus.silva on 24/11/2017.
 */

public class NegocioException extends Exception {
    public NegocioException(){
        super();
    }

    public NegocioException(Exception e)
    {
        super(e.getMessage());
    }

    public NegocioException(String mensagem)
    {
        super(mensagem);
    }
}
