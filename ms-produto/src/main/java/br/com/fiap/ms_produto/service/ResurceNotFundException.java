package br.com.fiap.ms_produto.service;

public class ResurceNotFundException extends RuntimeException {

    public  ResurceNotFundException(String message){
        super(message);
    }
}
