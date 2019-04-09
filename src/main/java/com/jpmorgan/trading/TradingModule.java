package com.jpmorgan.trading;

import java.util.List;

import com.jpmorgan.trading.domain.TradeEvent;

public interface TradingModule {
	boolean addTradeEvents(List<TradeEvent> tradingEvents);
}
