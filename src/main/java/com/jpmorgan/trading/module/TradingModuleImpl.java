package com.jpmorgan.trading.module;

import java.util.ArrayList;
import java.util.List;

import com.jpmorgan.trading.domain.TradeEvent;
import com.jpmorgan.trading.domain.TradeOutcome;

public class TradingModuleImpl implements TradingModule {

	public static List<TradeEvent> tradeEvents;
	public static List<TradeOutcome> tradeOutcome;

	public boolean addTradeEvents(List<TradeEvent> newTradingEvents) {
		if (tradeEvents == null)
			tradeEvents = new ArrayList<TradeEvent>();
		return tradeEvents.addAll(newTradingEvents);
	}

	public List<TradeEvent> getTradeEvents() {
		if (tradeEvents == null)
			tradeEvents = new ArrayList<TradeEvent>();
		return tradeEvents;
	}

	public boolean setTradeOutcomes(List<TradeOutcome> outcomes) {
		tradeOutcome = new ArrayList<TradeOutcome>();
		return tradeOutcome.addAll(outcomes);
	}

	public List<TradeOutcome> getTradeOutcomes() {
		if (tradeOutcome == null)
			tradeOutcome = new ArrayList<TradeOutcome>();
		return tradeOutcome;
	}

	public boolean resetTradeEvents() {
		tradeEvents.clear();
		return true;
	}

	public boolean resetTradeOutcomes() {
		tradeOutcome.clear();
		return true;
	}

	public boolean resetAll() {
		tradeOutcome.clear();
		tradeEvents.clear();
		return true;
	}
}
