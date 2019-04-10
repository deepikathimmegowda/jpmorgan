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

	 /*public String id() {
		 return _id;
	 }
	 
	 public void id(String value) {
		 _id = value;
	 }
	 
	 public String account() {
		 return _account;
	 }
	 
	 public void account(String value) {
		 _account = value;
	 }
	 
	 public String instrument() {
		 return _instrument;
	 }
	 
	 public void instrument(String value) {
		 _instrument = value;
	 }
	 
	 public int tradeQuantity() {
		 return _tradeQuantity;
	 }
	 
	 public void tradeQuantity(int value) {
		 _tradeQuantity = value;
	 }
	 
	 public int version() {
		 return _version;
	 }
	 
	 public void version(int value) {
		 _version = value;
	 }
	 
	 public List<Integer> tradeID() {
		 return _tradeID;
	 }
	 
	 public void tradeID(int value) {
		 _tradeID.add(value);
	 }*/
	
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
		if(tradeID == null) tradeID = new ArrayList<Integer>();
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
