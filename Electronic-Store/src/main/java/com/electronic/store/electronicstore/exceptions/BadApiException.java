package com.electronic.store.electronicstore.exceptions;

public class BadApiException extends RuntimeException{

    public BadApiException(){
        super("Bad Api exception occured");
    }

    public BadApiException(String ex){
        super(ex);
    }

}
