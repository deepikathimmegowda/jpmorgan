package com.jpmorgan.trading.services;

import java.util.ArrayList;
import java.util.List;

import com.jpmorgan.trading.module.TradingModule;
import com.jpmorgan.trading.module.TradingModuleImpl;
import com.jpmorgan.trading.domain.TradeDirection;
import com.jpmorgan.trading.domain.TradeEvent;
import com.jpmorgan.trading.domain.TradeOperation;
import com.jpmorgan.trading.domain.TradeOutcome;

public class TradingServiceImpl implements TradingService{
	
	public boolean createTradeEvents(List<TradeEvent> tradeEvents) {
		return getTradingModule().addTradeEvents(tradeEvents);
	}

	public List<TradeOutcome> computeTradeOutcome() {
		
		List<TradeEvent> events = getTradingModule().getTradeEvents();
		List<TradeOutcome> outcomes = new ArrayList<TradeOutcome>();
		
		for(TradeEvent event: events ) {
			
			String id = event.getAccount().concat(event.getSecurityIdentifier());
			TradeOutcome existingOutcome = outcomes.stream()
												.filter(ele ->  ele.getId().equals(id))
												.findFirst()
												.orElse(null);
			
			if(existingOutcome ==  null)  //1
			{
				TradeOutcome newOutcome = new TradeOutcome();
				getNewTradeOutcome(newOutcome, event);
				newOutcome.setId(id);
				outcomes.add(newOutcome);	
			}
			else {
				//to handle last "KLO" edge case, keep version list and check
				if(existingOutcome.tradeIDContains(event.getTradeID()) 
				  && existingOutcome.getVersion() < event.getVersion()) 
				{
					existingOutcome.tradeIDClear();
					existingOutcome.addTradeID(event.getTradeID());
					existingOutcome.setVersion(event.getVersion());
					existingOutcome.setTradeQuantity(event.getTradeQuantity());
				}
				else if(!existingOutcome.tradeIDContains(event.getTradeID()))//|| existingOutcome.version() <= event.version())		   
				{
					existingOutcome.addTradeID(event.getTradeID());
					
					if(isProductQuantityIncrement(event))
						existingOutcome.setTradeQuantity(existingOutcome.getTradeQuantity() + event.getTradeQuantity());
					else if(isProductQuantityDecrement(event))
						existingOutcome.setTradeQuantity(existingOutcome.getTradeQuantity() - event.getTradeQuantity());
				}
			}
		}
		getTradingModule().setTradeOutcomes(outcomes);
		return outcomes;
	}
	
	public List<TradeEvent> getTradeEvents(){
		return getTradingModule().getTradeEvents();
	}
	
	public boolean clearTradeEvents()
	{
		return getTradingModule().resetTradeEvents();
	}
	
	public boolean clearTradeOutcomes()
	{
		return getTradingModule().resetTradeOutcomes();
	}
	
	public boolean clearAll() {
		return getTradingModule().resetAll();
	}
	
	protected TradingModule getTradingModule() {
		return new TradingModuleImpl();
	}
	
	protected void getNewTradeOutcome(TradeOutcome newOutcome, TradeEvent event)
	{
		newOutcome.setAccount(event.getAccount());
		newOutcome.setInstrument(event.getSecurityIdentifier());
		newOutcome.setVersion(event.getVersion());
		newOutcome.addTradeID(event.getTradeID());
		
		if(isProductQuantityIncrement(event))
			newOutcome.setTradeQuantity(event.getTradeQuantity());
		else if(isProductQuantityDecrement(event))
			newOutcome.setTradeQuantity(0 - event.getTradeQuantity());
	}
	
	protected boolean isProductQuantityIncrement(TradeEvent event) {
		if(event.getTradeDirection() == TradeDirection.BUY 
				&& (event.getTradeOperation() == TradeOperation.NEW || event.getTradeOperation() == TradeOperation.AMEND)
	    ||(event.getTradeDirection() == TradeDirection.SELL && event.getTradeOperation() == TradeOperation.CANCEL )) 
		{
			return true;
		}
		return false;
	}
	
	protected boolean isProductQuantityDecrement(TradeEvent event) {
		if((event.getTradeDirection() == TradeDirection.SELL 
				&& (event.getTradeOperation() == TradeOperation.NEW || event.getTradeOperation() == TradeOperation.AMEND))
		  || (event.getTradeDirection() == TradeDirection.BUY && event.getTradeOperation() == TradeOperation.CANCEL)) 
		{
			return true;
		}
		return false;
	}
}

