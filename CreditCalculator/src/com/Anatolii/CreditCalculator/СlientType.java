package com.Anatolii.CreditCalculator;

public enum СlientType {

    human("Human"), business("Business");

    String clientType;

    private СlientType(String clientType) {
        this.clientType = clientType;
    }

    public String getСlientType() {
        return clientType;
    }

}
