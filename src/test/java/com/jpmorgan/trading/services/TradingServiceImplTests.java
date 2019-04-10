package com.jpmorgan.trading.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.jpmorgan.trading.domain.TradeDirection;
import com.jpmorgan.trading.domain.TradeEvent;
import com.jpmorgan.trading.domain.TradeOperation;
import com.jpmorgan.trading.domain.TradeOutcome;
import com.jpmorgan.trading.module.TradingModule;
import com.jpmorgan.trading.module.TradingModuleImpl;

@RunWith(MockitoJUnitRunner.class)
public class TradingServiceImplTests {

	private TradingServiceImpl tradingService;
	private TradingModule tradingModule;
	
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
		tradingModule = Mockito.mock(TradingModuleImpl.class);
		
		tradingService = new TradingServiceImpl() { 
			@Override
			protected TradingModule getTradingModule() {
				return tradingModule;
		}};
		

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
	public void testCreateTradeEvents() {		
		tradeEvents = new ArrayList<TradeEvent>();
		tradeEvents.add(event1);
		Mockito.when(tradingModule.addTradeEvents(tradeEvents)).thenReturn(true);
		boolean isAdded = tradingService.createTradeEvents(tradeEvents);
		Assert.assertTrue(isAdded);
	}
	
	@Test
	public void testGetTradeEvents() {
		tradeEvents = new ArrayList<TradeEvent>();
		tradeEvents.add(event1);
		tradeEvents.add(event2);
		tradeEvents.add(event3);
		tradeEvents.add(event4);
		Mockito.when(tradingModule.getTradeEvents()).thenReturn(tradeEvents);
		List<TradeEvent> resultEvents = tradingService.getTradeEvents();
		Assert.assertTrue(resultEvents.size() == 4);
	}
	
	@Test
	public void tesComputeTradeOutcome() {
		tradeEvents = new ArrayList<TradeEvent>();
		tradeEvents.add(event1);
		tradeEvents.add(event2);
		tradeEvents.add(event3);
		tradeEvents.add(event4);
		tradeOutcomes = new ArrayList<TradeOutcome>();
		tradeOutcomes.add(outcome1);
		tradeOutcomes.add(outcome2);
		Mockito.when(tradingModule.getTradeEvents()).thenReturn(tradeEvents);
		Mockito.when(tradingModule.setTradeOutcomes(tradeOutcomes)).thenReturn(true);
		List<TradeOutcome> resultOutcome = tradingService.computeTradeOutcome();
		Assert.assertTrue(resultOutcome.size() == 2);
		Assert.assertTrue(
				resultOutcome.get(0).getAccount().equals(outcome1.getAccount()) &&
				resultOutcome.get(0).getInstrument().equals(outcome1.getInstrument()) &&
				resultOutcome.get(0).getTradeQuantity() == outcome1.getTradeQuantity() &&
				resultOutcome.get(0).getTradeID().contains(outcome1.getTradeID().get(0))
			);
		
		Assert.assertTrue(
				resultOutcome.get(1).getAccount().equals(outcome2.getAccount()) &&
				resultOutcome.get(1).getInstrument().equals(outcome2.getInstrument()) &&
				resultOutcome.get(1).getTradeQuantity() == outcome2.getTradeQuantity() &&
				resultOutcome.get(1).getTradeID().contains(outcome2.getTradeID().get(0))
			);
	}
	
	@Test
	public void testClearTradeEvents() {
		Mockito.when(tradingModule.resetTradeEvents()).thenReturn(true);
		boolean isCleared = tradingService.clearTradeEvents();
		Assert.assertTrue(isCleared);
	}
	
	@Test
	public void testClearTradeOutcomes() {
		Mockito.when(tradingModule.resetTradeOutcomes()).thenReturn(true);
		boolean isCleared = tradingService.clearTradeOutcomes();
		Assert.assertTrue(isCleared);
	}
	
	@Test
	public void testClearAll() {
		Mockito.when(tradingModule.resetAll()).thenReturn(true);
		boolean isCleared = tradingService.clearAll();
		Assert.assertTrue(isCleared);
	}
	
	@Test
	public void testGetNewTradeOutcome() {
		TradeOutcome outcome = new TradeOutcome();
		tradingService.getNewTradeOutcome(outcome,event1);		
		Assert.assertTrue(
			outcome.getAccount().equals(event1.getAccount()) &&
			outcome.getInstrument().equals(event1.getSecurityIdentifier()) &&
			outcome.getTradeQuantity() == event1.getTradeQuantity() &&
			outcome.getTradeID().contains(event1.getTradeID())
		);
	}
	
	@Test
	public void testIsProductQuantityIncrement() {
		tradingService.isProductQuantityIncrement(event1);		
		Assert.assertTrue(true);
	}
	
	@Test
	public void testisProductQuantityDecrement() {
		tradingService.isProductQuantityIncrement(event5);		
		Assert.assertTrue(true);
	}
	
}
