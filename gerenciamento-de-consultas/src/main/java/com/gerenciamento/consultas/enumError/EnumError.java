package com.gerenciamento.consultas.enumError;

public enum EnumError {

    DOCTOR_NOT_FOUND("Doctor Not Found",404),
    PATIENT_NOT_FOUND("Patient Not Found", 404);

    private final String message;
    private final int statusCode;

       EnumError(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
        }

        public String getMessage() {
             return message;
        }

        public int getStatusCode() {
            return statusCode;

    }
}


