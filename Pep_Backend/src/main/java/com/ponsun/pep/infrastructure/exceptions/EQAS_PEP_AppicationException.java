package com.ponsun.pep.infrastructure.exceptions;

public class EQAS_PEP_AppicationException extends AbstractPlatformException{

    public EQAS_PEP_AppicationException(String message){
        super("error.msg.generic",message);
    }
}
