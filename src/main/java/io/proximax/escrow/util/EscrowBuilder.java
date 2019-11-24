package io.proximax.escrow.util;

import java.util.Date;
import java.util.UUID;

import io.proximax.escrow.document.Escrow;
import java.math.BigInteger;
import org.bitcoinj.core.Address;
import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.LegacyAddress;
import org.bitcoinj.core.NetworkParameters;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;
import org.web3j.crypto.Wallet;
import org.web3j.crypto.WalletFile;

public class EscrowBuilder {

    private long maxId;
    private String email;
    private String fullName;
    private String tokenName;
    private Double tokenAmount;
    private Double xpxAmount;
    private String xpxAddress;

    public EscrowBuilder() {
    }

    public Escrow build() {
        Escrow row = new Escrow();
        row.setId(maxId + 1);
        row.setRegisterDate(new Date());
        row.setTradingCode(generateTradingCode());
        row.setEmail(email);
        row.setFullName(fullName);
        row.setXpxAmount(xpxAmount);
        row.setXpxPrice(TransactionHelper.getTokenPrice("xpx"));
        row.setXpxAddress(xpxAddress);
        row.setTokenName(tokenName);
        row.setTokenPrice(TransactionHelper.getTokenPrice(tokenName));
        tokenAmount = (row.getXpxPrice() * row.getXpxAmount()) / row.getTokenPrice();
        row.setTokenAmount(tokenAmount);
        row.setStatus(CONSTS.STATUS_WAITING_PAY);
        if (tokenName.equalsIgnoreCase("eth")) {
            try {
                String seed = UUID.randomUUID().toString();
                ECKeyPair ecKeyPair = Keys.createEcKeyPair();
                WalletFile wallet = Wallet.createLight(seed, ecKeyPair);
                row.setTokenPrivateKey(ecKeyPair.getPrivateKey().toString(16));
                row.setTokenPublicKey(ecKeyPair.getPublicKey().toString(16));
                row.setTokenSeed(seed);
                row.setTokenAddress(wallet.getAddress());
                //BigInteger privateKeyInDec = ecKeyPair.getPrivateKey();            
                //String sPrivatekeyInHex = privateKeyInDec.toString(16);
                //String sAddress = aWallet.getAddress();
                //System.out.println("Key: " + sPrivatekeyInHex);
                //System.out.println("Seed: " + seed);
                //System.out.println("address: " + sAddress);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (tokenName.equalsIgnoreCase("btc")) {
            String seed = UUID.randomUUID().toString();
            NetworkParameters netParams = NetworkParameters.fromID(NetworkParameters.ID_MAINNET);
            // create a new EC Key ...
            ECKey key = new ECKey();
            // ... and look at the key pair
            System.out.println("We created key:\n" + key);
            // get valid Bitcoin address from public key
            Address addressFromKey = LegacyAddress.fromKey(netParams, key);
            row.setTokenPrivateKey(key.getPrivateKeyAsHex());
            row.setTokenPublicKey(key.getPublicKeyAsHex());            
            row.setTokenAddress(addressFromKey.toString());
            row.setTokenSeed(seed);
        }
        return row;
    }

    public EscrowBuilder addMaxId(long id) {
        this.maxId = id;
        return this;
    }

    public EscrowBuilder addEmail(String email) {
        this.email = email;
        return this;
    }

    public EscrowBuilder addFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public EscrowBuilder addTokenName(String tokenName) {
        this.tokenName = tokenName;
        return this;
    }

    public EscrowBuilder addTokenAmount(Double tokenAmount) {
        this.tokenAmount = tokenAmount;
        return this;
    }

    public EscrowBuilder addXPXAmount(Double xpxAmount) {
        this.xpxAmount = xpxAmount;
        return this;
    }

    public EscrowBuilder addXPXAddress(String xpxAddress) {
        this.xpxAddress = xpxAddress;
        return this;
    }

    public static String generateTradingCode() {
        String code = UUID.randomUUID().toString();
        return code.replaceAll("-", "");
    }
}
