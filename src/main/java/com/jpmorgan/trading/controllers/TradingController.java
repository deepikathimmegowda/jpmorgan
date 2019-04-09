package com.jpmorgan.trading.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpmorgan.trading.TradingModuleImpl;
import com.jpmorgan.trading.domain.TradeEvent;
import com.jpmorgan.trading.services.TradingService;
import com.jpmorgan.trading.services.TradingServiceImpl;

@Controller
public class TradingController {
	
	@GetMapping("/sayHello")
	public String sayHello() {
		return "Deepika";
	}
	 
	@GetMapping("/trading")
    public String getTrading() {
        return getTradingService().getTrading();
    }
	
	@PostMapping("/tradings")
    @ResponseBody
    public void addTradeEvents(@RequestBody List<TradeEvent> tradeEvents) {
		//TradingModuleImpl tradingModuleObj = TradingModuleImpl.getInstance();
		//tradingModuleObj.addTradeEvents(tradeEvents);
		
	}
	
	protected TradingService getTradingService() {
		return new TradingServiceImpl();
	}
}
