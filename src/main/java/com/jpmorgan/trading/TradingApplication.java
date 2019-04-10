package com.jpmorgan.trading;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TradingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradingApplication.class, args);

		// Use below method if required to initialize app on load, for app manual system
		// testing
		Initialize.InitializeTradeEventsForApp();
	}
}
