package com.jpmorgan.trading.services;

import java.util.List;

import com.jpmorgan.trading.domain.TradeEvent;
import com.jpmorgan.trading.domain.TradeOutcome;

public interface TradingService {
	boolean createTradeEvents(List<TradeEvent> tradeEvents);

	List<TradeEvent> getTradeEvents();

	List<TradeOutcome> computeTradeOutcome();

	boolean clearTradeEvents();

	boolean clearTradeOutcomes();

	boolean clearAll();
}
