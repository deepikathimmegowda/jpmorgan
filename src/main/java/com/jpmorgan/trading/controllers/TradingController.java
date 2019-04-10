package com.jpmorgan.trading.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpmorgan.trading.domain.TradeEvent;
import com.jpmorgan.trading.domain.TradeOutcome;
import com.jpmorgan.trading.services.TradingService;
import com.jpmorgan.trading.services.TradingServiceImpl;

@RestController
public class TradingController 
{
	//@Autowired(required=true)
	//public TradingService tradingService;
	
	@GetMapping("/test")
	public String test() {
		return "Test API";
	}
	 
	@GetMapping("/tradeEvents")
    public List<TradeEvent> getTradeEvents() {
        return getTradingService().getTradeEvents(); 
    }
	
	@PostMapping("/tradeEvents")
    public boolean addTradeEvents(@RequestBody List<TradeEvent> tradeEvents) {
		return getTradingService().createTradeEvents(tradeEvents);
	}
	
	@GetMapping("/tradeOutcomes")
    public List<TradeOutcome> getTradeOutcomes() {
		return getTradingService().computeTradeOutcome();
    }
	
	@GetMapping("/clearEvents")
    public boolean clearEvents() {
		return getTradingService().clearTradeEvents();
    }
	
	@GetMapping("/clearOutcomes")
    public boolean clearOutcomes() {
		return getTradingService().clearTradeOutcomes();
    }
	
	@GetMapping("/clearAll")
    public boolean clearAll() {
		return getTradingService().clearAll();
    }
	
	protected TradingService getTradingService() {
		return new TradingServiceImpl();
	}
}
