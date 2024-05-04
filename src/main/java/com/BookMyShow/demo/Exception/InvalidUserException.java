package com.BookMyShow.demo.Exception;

public class InvalidUserException extends RuntimeException{

    public InvalidUserException(String Message)
    {
        super(Message);
    }

}
