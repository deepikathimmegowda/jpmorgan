package com.jpmorgan.trading.domain;

import java.util.ArrayList;
import java.util.List;

public class TradeOutcome {
	private String id;
	private String account;
	private String instrument;
	private int tradeQuantity;
	private int version;
	private List<Integer> tradeID;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getInstrument() {
		return instrument;
	}

	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}

	public int getTradeQuantity() {
		return tradeQuantity;
	}

	public void setTradeQuantity(int tradeQuantity) {
		this.tradeQuantity = tradeQuantity;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public List<Integer> getTradeID() {
		return tradeID;
	}

	public void setTradeID(List<Integer> tradeID) {
		this.tradeID = tradeID;
	}

	public void addTradeID(int value) {
		if (tradeID == null)
			tradeID = new ArrayList<Integer>();
		tradeID.add(value);
	}

	public boolean tradeIDContains(int value) {
		return tradeID.contains(value);
	}

	public void tradeIDClear() {
		tradeID.clear();
	}

	public TradeOutcome() {
		tradeID = new ArrayList<Integer>();
	}
}
