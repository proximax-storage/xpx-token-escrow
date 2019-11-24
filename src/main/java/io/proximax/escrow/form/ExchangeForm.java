package io.proximax.escrow.form;

public class ExchangeForm {

    private String fullName;
    private String email;
    private String tokenName;
    private Double tokenAmount;
    private double xpxAmount;
    private String xpxAddress;

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setTokenAmount(Double tokenAmount) {
        this.tokenAmount = tokenAmount;
    }

    public Double getTokenAmount() {
        return tokenAmount;
    }

    public void setTokenName(String tokenName) {
        this.tokenName = tokenName;
    }

    public String getTokenName() {
        return tokenName;
    }

    public void setXpxAddress(String xpxAddress) {
        this.xpxAddress = xpxAddress;
    }

    public String getXpxAddress() {
        return xpxAddress;
    }

    public void setXpxAmount(double xpxAmount) {
        this.xpxAmount = xpxAmount;
    }

    public double getXpxAmount() {
        return xpxAmount;
    }

    public String getFullName() {
        return fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

}
