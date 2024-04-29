package com.peerlender.lendingengine.domain.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(long userId){
        super("User with userId" + userId + "not found");
    }
}
