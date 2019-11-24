package io.proximax.escrow.document;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Field;

public class XPXTransaction {
	@Field(value = "Transaction_Id")
	private String transactionId;

	@Field(value = "Transaction_Date")
	private Date transactionDate;

	@Field(value = "XPX_Sender")
	private String xpxSender;

	@Field(value = "XPX_Amount")
	private Double xpxAmount;		
	
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	
	public void setXpxAmount(Double xpxAmount) {
		this.xpxAmount = xpxAmount;
	}
	
	public Double getXpxAmount() {
		return xpxAmount;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setXpxSender(String xpxSender) {
		this.xpxSender = xpxSender;
	}

	public String getXpxSender() {
		return xpxSender;
	}


}
