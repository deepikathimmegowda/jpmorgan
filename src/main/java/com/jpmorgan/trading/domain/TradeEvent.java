package com.jpmorgan.trading.domain;

public class TradeEvent {
	private int tradeID;
	private int version;
	private String securityIdentifier;
	private int tradeQuantity;
	private TradeDirection tradeDirection;
	private String account;
	private TradeOperation tradeOperation;

	public int getTradeID() {
		return tradeID;
	}

	public void setTradeID(int tradeID) {
		this.tradeID = tradeID;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getSecurityIdentifier() {
		return securityIdentifier;
	}

	public void setSecurityIdentifier(String securityIdentifier) {
		this.securityIdentifier = securityIdentifier;
	}

	public int getTradeQuantity() {
		return tradeQuantity;
	}

	public void setTradeQuantity(int tradeQuantity) {
		this.tradeQuantity = tradeQuantity;
	}

	public TradeDirection getTradeDirection() {
		return tradeDirection;
	}

	public void setTradeDirection(TradeDirection tradeDirection) {
		this.tradeDirection = tradeDirection;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public TradeOperation getTradeOperation() {
		return tradeOperation;
	}

	public void setTradeOperation(TradeOperation tradeOperation) {
		this.tradeOperation = tradeOperation;
	}

}
