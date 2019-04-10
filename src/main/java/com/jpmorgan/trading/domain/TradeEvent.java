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
	 
	 /*public int tradeID() {
		 return _tradeID;
	 }
	 
	 public void tradeID(int value) {
		 _tradeID = value;
	 }
	 
	 public int version() {
		 return _version;
	 }
	 
	 public void version(int value) {
		 _version = value;
	 }
	 
	 public String securityIdentifier() {
		 return _securityIdentifier;
	 }
	 
	 public void securityIdentifier(String value) {
		 _securityIdentifier = value;
	 }
	 
	 public int tradeQuantity() {
		 return _tradeQuantity;
	 }
	 
	 public void tradeQuantity(int value) {
		 _tradeQuantity = value;
	 }
	 
	 public TradeDirection tradeDirection() {
		 return _tradeDirection;
	 }
	 
	 public void tradeDirection(TradeDirection value) {
		 _tradeDirection = value;
	 }
	 
	 public String account() {
		 return _account;
	 }
	 
	 public void account(String value) {
		 _account = value;
	 }
	 
	 public TradeOperation tradeOperation() {
		 return _tradeOperation;
	 }
	 
	 public void tradeOperation(TradeOperation value) {
		 _tradeOperation = value;
	 }*/
}
