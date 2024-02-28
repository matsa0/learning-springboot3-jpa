package com.learningjspring.course.services.exceptions;

public class ResourceNotFoundException extends RuntimeException { 
    /*
    RuntimeException(unchecked exception)

    o compilador não exige que os métodos que lançam essa exceção sejam explicitamente tratados usando try-catch ou que a assinatura do 
    método inclua a cláusula throws para indicar que a exceção pode ser propagada.
    */
    public ResourceNotFoundException(Object id) {
        super("Resource not Found for ID > " + id);
    }
}
