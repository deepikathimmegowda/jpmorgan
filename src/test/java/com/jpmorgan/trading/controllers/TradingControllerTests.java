package com.jpmorgan.trading.controllers;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.jpmorgan.trading.services.TradingService;
import com.jpmorgan.trading.domain.TradeDirection;
import com.jpmorgan.trading.domain.TradeEvent;
import com.jpmorgan.trading.domain.TradeOperation;
import com.jpmorgan.trading.domain.TradeOutcome;

@RunWith(MockitoJUnitRunner.class)
public class TradingControllerTests {

	private TradingController tradingController;
	private TradingService tradingService;
	private List<TradeEvent> tradeEvents;
	private List<TradeOutcome> tradeOutcomes;
	TradeEvent event1;
	TradeEvent event2;
	TradeEvent event3;
	TradeEvent event4;

	TradeOutcome outcome1;
	TradeOutcome outcome2;
	TradeOutcome outcome3;
	TradeOutcome outcome4;

	@Before
	public void setup() {
		tradingService = Mockito.mock(TradingService.class);

		tradingController = new TradingController() {
			@Override
			protected TradingService getTradingService() {
				return tradingService;
			}
		};

		event1 = new TradeEvent();
		event2 = new TradeEvent();
		event3 = new TradeEvent();
		event4 = new TradeEvent();

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
	public void testgetTradeEvents() {
		tradeEvents = new ArrayList<TradeEvent>();
		tradeEvents.add(event1);
		tradeEvents.add(event2);
		tradeEvents.add(event3);
		Mockito.when(tradingService.getTradeEvents()).thenReturn(tradeEvents);
		List<TradeEvent> result = tradingController.getTradeEvents();
		Assert.assertTrue(result.size() == 3);
	}

	@Test
	public void testAddTradeEvents() {
		tradeEvents = new ArrayList<TradeEvent>();
		tradeEvents.add(event1);
		tradeEvents.add(event2);
		tradeEvents.add(event3);
		Mockito.when(tradingService.createTradeEvents(tradeEvents)).thenReturn(true);
		boolean isAdded = tradingController.addTradeEvents(tradeEvents);
		Assert.assertTrue(isAdded);
	}

	@Test
	public void testGetTradeOutcomes() {
		tradeOutcomes = new ArrayList<TradeOutcome>();
		tradeOutcomes.add(outcome1);
		tradeOutcomes.add(outcome2);
		Mockito.when(tradingService.computeTradeOutcome()).thenReturn(tradeOutcomes);
		List<TradeOutcome> resultOutcomes = tradingController.getTradeOutcomes();
		Assert.assertTrue(resultOutcomes.size() == 2);
	}

	@Test
	public void testClearEvents() {
		Mockito.when(tradingService.clearTradeEvents()).thenReturn(true);
		boolean isCleared = tradingController.clearEvents();
		Assert.assertTrue(isCleared);
	}

	@Test
	public void testclearOutcomes() {
		Mockito.when(tradingService.clearTradeOutcomes()).thenReturn(true);
		boolean isCleared = tradingController.clearOutcomes();
		Assert.assertTrue(isCleared);
	}

	@Test
	public void testClearAll() {
		Mockito.when(tradingService.clearAll()).thenReturn(true);
		boolean isCleared = tradingController.clearAll();
		Assert.assertTrue(isCleared);
	}
}
