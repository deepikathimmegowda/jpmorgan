package com.jpmorgan.trading.domain;

import java.util.ArrayList;
import java.util.List;

public class TradeOutcome {
	 private String _id;
	 private String _account;
	 private String _instrument;
	 private int _tradeQuantity;
	 private List<Integer> _tradeID;
	 
	 public String id() {
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
	 
	 public List<Integer> tradeID() {
		 return _tradeID;
	 }
	 
	 public void tradeID(int value) {
		 _tradeID.add(value);
	 }
	 
	 public TradeOutcome() {
		 _tradeID = new ArrayList<Integer>();
	 }
}
