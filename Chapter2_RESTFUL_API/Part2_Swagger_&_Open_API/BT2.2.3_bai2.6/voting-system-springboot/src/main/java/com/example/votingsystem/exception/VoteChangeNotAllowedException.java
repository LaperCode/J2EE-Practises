package com.example.votingsystem.exception;

public class VoteChangeNotAllowedException extends BusinessException {
    public VoteChangeNotAllowedException(String message) {
        super(message);
    }
}
