package com.jpmorgan.trading.domain;

public class TradeEvent {
	 private int _tradeID;
	 private int _version;
	 private String _securityVersion;
	 private int _tradeQuantity;
	 private TradingDirection _tradeDirection;
	 private String _account;
	 private TradingOperation _operation;
	 
	 public int tradeID() {
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
	 
	 public String securityVersion() {
		 return _securityVersion;
	 }
	 
	 public void securityVersion(String value) {
		 _securityVersion = value;
	 }
	 
	 public int tradeQuantity() {
		 return _tradeQuantity;
	 }
	 
	 public void tradeQuantity(int value) {
		 _tradeQuantity = value;
	 }
	 
	 public TradingDirection tradeDirection() {
		 return _tradeDirection;
	 }
	 
	 public void tradeDirection(TradingDirection value) {
		 _tradeDirection = value;
	 }
	 
	 public String account() {
		 return _account;
	 }
	 
	 public void account(String value) {
		 _account = value;
	 }
	 
	 public TradingOperation operation() {
		 return _operation;
	 }
	 
	 public void operation(TradingOperation value) {
		 _operation = value;
	 }
}
