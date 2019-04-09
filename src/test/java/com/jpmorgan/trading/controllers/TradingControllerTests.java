package com.jpmorgan.trading.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.jpmorgan.trading.services.TradingService;

@RunWith(MockitoJUnitRunner.class)
public class TradingControllerTests {

	private TradingController tradingController;
	private TradingService tradingService;
	
	@Before
	public void setup() {
		tradingService = Mockito.mock(TradingService.class);
		
		tradingController = new TradingController() { 
			@Override
			protected TradingService getTradingService() {
				return tradingService;
		}};
	}
	
	@Test
	public void testgetTrading() {
		Mockito.when(tradingService.getTrading()).thenReturn("Deepika");
		String returnString = tradingController.getTrading();
		assertEquals("Deepika1",returnString);
	}
}
