package com.jpmorgan.trading.module;

import java.util.List;

import com.jpmorgan.trading.domain.TradeEvent;
import com.jpmorgan.trading.domain.TradeOutcome;

public interface TradingModule {
	boolean addTradeEvents(List<TradeEvent> tradingEvents);
	List<TradeEvent> getTradeEvents();
	boolean setTradeOutcomes(List<TradeOutcome> outcomes);
	List<TradeOutcome>  getTradeOutcomes();
	boolean resetTradeEvents();
	boolean resetTradeOutcomes();
	boolean resetAll();
}
