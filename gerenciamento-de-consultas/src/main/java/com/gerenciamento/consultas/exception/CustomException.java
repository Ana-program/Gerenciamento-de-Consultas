package com.gerenciamento.consultas.exception;

import com.gerenciamento.consultas.enumError.EnumError;

public class CustomException extends RuntimeException {

    private final EnumError error;

    public CustomException(EnumError error) {
        super(error.getMessage());
        this.error = error;
    }

    public EnumError getError() {
        return error;
    }

}
