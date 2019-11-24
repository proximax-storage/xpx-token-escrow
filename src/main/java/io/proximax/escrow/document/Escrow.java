package io.proximax.escrow.document;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Escrow")
public class Escrow {

    @Id
    private Long id;

    @Field(value = "Full_Name")
    private String fullName;

    @Field(value = "Email")
    private String email;

    @Field(value = "Register_Date")
    private Date registerDate;

    @Field(value = "Token_Name")
    private String tokenName;

    @Field(value = "Token_Price")
    private Double tokenPrice;

    @Field(value = "Token_Amount")
    private Double tokenAmount;

    @Field(value = "Token_Seed")
    private String tokenSeed;

    @Field(value = "Token_PrivateKey")
    private String tokenPrivateKey;

    @Field(value = "Token_PublicKey")
    private String tokenPublicKey;

    @Field(value = "Token_Address")
    private String tokenAddress;

    @Field(value = "XPX_Price")
    private Double xpxPrice;

    @Field(value = "XPX_Amount")
    private Double xpxAmount;

    @Field(value = "XPX_Address")
    private String xpxAddress;

    @Field(value = "Expired_Date")
    private Date expiredDate;

    @Field(value = "Status")
    private Integer status;

    @Field(value = "XPX_Transaction")
    private XPXTransaction transaction;

    @Field(value = "Trading_Code")
    private String tradingCode;

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public void setXpxPrice(Double xpxPrice) {
        this.xpxPrice = xpxPrice;
    }

    public Double getXpxPrice() {
        return xpxPrice;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setTokenAddress(String tokenAddress) {
        this.tokenAddress = tokenAddress;
    }

    public String getTokenAddress() {
        return tokenAddress;
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

    public void setTokenPrice(Double tokenPrice) {
        this.tokenPrice = tokenPrice;
    }

    public Double getTokenPrice() {
        return tokenPrice;
    }

    public void setTokenPrivateKey(String tokenPrivateKey) {
        this.tokenPrivateKey = tokenPrivateKey;
    }

    public String getTokenPrivateKey() {
        return tokenPrivateKey;
    }

    public void setTokenPublicKey(String tokenPublicKey) {
        this.tokenPublicKey = tokenPublicKey;
    }

    public void setXpxAddress(String xpxAddress) {
        this.xpxAddress = xpxAddress;
    }

    public String getTokenPublicKey() {
        return tokenPublicKey;
    }

    public void setXpxAmount(Double xpxAmount) {
        this.xpxAmount = xpxAmount;
    }

    public String getXpxAddress() {
        return xpxAddress;
    }

    public Double getXpxAmount() {
        return xpxAmount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setTokenSeed(String tokenSeed) {
        this.tokenSeed = tokenSeed;
    }

    public String getTokenSeed() {
        return tokenSeed;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setTransaction(XPXTransaction transaction) {
        this.transaction = transaction;
    }

    public XPXTransaction getTransaction() {
        return transaction;
    }

    public void setTradingCode(String tradingCode) {
        this.tradingCode = tradingCode;
    }

    public String getTradingCode() {
        return tradingCode;
    }

}
