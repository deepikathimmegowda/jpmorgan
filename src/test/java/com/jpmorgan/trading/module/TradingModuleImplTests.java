package com.jpmorgan.trading.module;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.jpmorgan.trading.domain.TradeDirection;
import com.jpmorgan.trading.domain.TradeEvent;
import com.jpmorgan.trading.domain.TradeOperation;
import com.jpmorgan.trading.domain.TradeOutcome;
import com.jpmorgan.trading.module.TradingModuleImpl;

@RunWith(MockitoJUnitRunner.class)
public class TradingModuleImplTests {

	private TradingModuleImpl tradingModule;

	private List<TradeEvent> tradeEvents;
	private List<TradeOutcome> tradeOutcomes;
	TradeEvent event1;
	TradeEvent event2;
	TradeEvent event3;
	TradeEvent event4;
	TradeEvent event5;

	TradeOutcome outcome1;
	TradeOutcome outcome2;
	TradeOutcome outcome3;
	TradeOutcome outcome4;

	@Before
	public void setup() {
		tradingModule = new TradingModuleImpl();

		event1 = new TradeEvent();
		event2 = new TradeEvent();
		event3 = new TradeEvent();
		event4 = new TradeEvent();
		event5 = new TradeEvent();

		event1.setTradeID(1234);
		event1.setVersion(1);
		event1.setSecurityIdentifier("XYZ");
		event1.setTradeQuantity(100);
		event1.setTradeDirection(TradeDirection.BUY);
		event1.setAccount("ACC-1234");
		event1.setTradeOperation(TradeOperation.NEW);

		event2.setTradeID(1234);
		event2.setVersion(2);
		event2.setSecurityIdentifier("XYZ");
		event2.setTradeQuantity(150);
		event2.setTradeDirection(TradeDirection.BUY);
		event2.setAccount("ACC-1234");
		event2.setTradeOperation(TradeOperation.AMEND);

		event3.setTradeID(5678);
		event3.setVersion(1);
		event3.setSecurityIdentifier("QED");
		event3.setTradeQuantity(200);
		event3.setTradeDirection(TradeDirection.BUY);
		event3.setAccount("ACC-2345");
		event3.setTradeOperation(TradeOperation.NEW);

		event4.setTradeID(5678);
		event4.setVersion(2);
		event4.setSecurityIdentifier("QED");
		event4.setTradeQuantity(0);
		event4.setTradeDirection(TradeDirection.BUY);
		event4.setAccount("ACC-2345");
		event4.setTradeOperation(TradeOperation.CANCEL);

		event5.setTradeID(2233);
		event5.setVersion(1);
		event5.setSecurityIdentifier("RET");
		event5.setTradeQuantity(100);
		event5.setTradeDirection(TradeDirection.SELL);
		event5.setAccount("ACC-3456");
		event5.setTradeOperation(TradeOperation.NEW);

		outcome1 = new TradeOutcome();
		outcome2 = new TradeOutcome();

		outcome1.setAccount("ACC-1234");
		outcome1.setId("ACC-1234XYZ");
		outcome1.setInstrument("XYZ");
		outcome1.addTradeID(1234);
		outcome1.setTradeQuantity(150);
		outcome1.setVersion(2);

		outcome2.setAccount("ACC-2345");
		outcome2.setId("ACC-2345QED");
		outcome2.setInstrument("QED");
		outcome2.addTradeID(5678);
		outcome2.setTradeQuantity(0);
		outcome2.setVersion(2);
	}

	@Test
	public void testAddTradeEvents() {
		tradeEvents = new ArrayList<TradeEvent>();
		tradeEvents.add(event1);
		boolean isAdded = tradingModule.addTradeEvents(tradeEvents);
		Assert.assertTrue(isAdded);
	}

	@Test
	public void testAddAndGetTradeEvents() {
		tradeEvents = new ArrayList<TradeEvent>();
		tradeEvents.add(event1);
		tradeEvents.add(event2);
		tradingModule.addTradeEvents(tradeEvents);
		List<TradeEvent> addedEvents = tradingModule.getTradeEvents();
		Assert.assertTrue(addedEvents.size() == 2);
	}

	@Test
	public void testAddTradeOutcomes() {
		tradeOutcomes = new ArrayList<TradeOutcome>();
		tradeOutcomes.add(outcome1);
		tradeOutcomes.add(outcome2);
		boolean isAdded = tradingModule.setTradeOutcomes(tradeOutcomes);
		Assert.assertTrue(isAdded);
	}

	@Test
	public void testSetandGetTradeOutcomes() {
		tradeOutcomes = new ArrayList<TradeOutcome>();
		tradeOutcomes.add(outcome1);
		tradeOutcomes.add(outcome2);
		tradingModule.setTradeOutcomes(tradeOutcomes);
		List<TradeOutcome> addedOutcomes = tradingModule.getTradeOutcomes();
		Assert.assertTrue(addedOutcomes.size() == 2);
	}

	@Test
	public void testResetTradeEvents() {
		tradeEvents = new ArrayList<TradeEvent>();
		tradeEvents.add(event1);
		tradeEvents.add(event2);
		tradingModule.addTradeEvents(tradeEvents);
		boolean isCleared = tradingModule.resetTradeEvents();
		Assert.assertTrue(isCleared);
	}

	@Test
	public void testResetTradeOutcomes() {
		tradeOutcomes = new ArrayList<TradeOutcome>();
		tradeOutcomes.add(outcome1);
		tradeOutcomes.add(outcome1);
		tradingModule.setTradeOutcomes(tradeOutcomes);
		boolean isCleared = tradingModule.resetTradeOutcomes();
		Assert.assertTrue(isCleared);
	}

	@Test
	public void testResetAll() {
		tradeEvents = new ArrayList<TradeEvent>();
		tradeEvents.add(event1);
		tradeEvents.add(event2);
		tradingModule.addTradeEvents(tradeEvents);

		tradeOutcomes = new ArrayList<TradeOutcome>();
		tradeOutcomes.add(outcome1);
		tradeOutcomes.add(outcome1);

		tradingModule.addTradeEvents(tradeEvents);
		tradingModule.setTradeOutcomes(tradeOutcomes);

		boolean isCleared = tradingModule.resetAll();
		Assert.assertTrue(isCleared);
	}
}
