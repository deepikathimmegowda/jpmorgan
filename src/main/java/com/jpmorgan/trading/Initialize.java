package com.jpmorgan.trading;

import java.util.ArrayList;
import java.util.List;

import com.jpmorgan.trading.controllers.TradingController;
import com.jpmorgan.trading.domain.TradeDirection;
import com.jpmorgan.trading.domain.TradeEvent;
import com.jpmorgan.trading.domain.TradeOperation;

public class Initialize {
	
	public static void InitializeTradeEventsForApp() {
		
		TradeEvent event1 = new TradeEvent();
		TradeEvent event2 = new TradeEvent();
		TradeEvent event3 = new TradeEvent();
		TradeEvent event4 = new TradeEvent();
		TradeEvent event5 = new TradeEvent();
		TradeEvent event6 = new TradeEvent();
		TradeEvent event7 = new TradeEvent();
		TradeEvent event8 = new TradeEvent();
		TradeEvent event9 = new TradeEvent();
		TradeEvent event10 = new TradeEvent();
		TradeEvent event11 = new TradeEvent();
		TradeEvent event12 = new TradeEvent();
		TradeEvent event13 = new TradeEvent();
		TradeEvent event14 = new TradeEvent();
		TradeEvent event15 = new TradeEvent();
		TradeEvent event16 = new TradeEvent();
		TradeEvent event17 = new TradeEvent();
		TradeEvent event18 = new TradeEvent();
		TradeEvent event19 = new TradeEvent();
		TradeEvent event20 = new TradeEvent();
		TradeEvent event21 = new TradeEvent();
		TradeEvent event22 = new TradeEvent();
		TradeEvent event23 = new TradeEvent();
		TradeEvent event24 = new TradeEvent();
		TradeEvent event25 = new TradeEvent();
		TradeEvent event26 = new TradeEvent();		
		
		
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

		event6.setTradeID(2233);
		event6.setVersion(2);
		event6.setSecurityIdentifier("RET");
		event6.setTradeQuantity(400);
		event6.setTradeDirection(TradeDirection.SELL);
		event6.setAccount("ACC-3456");
		event6.setTradeOperation(TradeOperation.AMEND);

		event7.setTradeID(2233);
		event7.setVersion(3);
		event7.setSecurityIdentifier("RET");
		event7.setTradeQuantity(0);
		event7.setTradeDirection(TradeDirection.SELL);
		event7.setAccount("ACC-3456");
		event7.setTradeOperation(TradeOperation.CANCEL);

		event8.setTradeID(8896);
		event8.setVersion(1);
		event8.setSecurityIdentifier("YUI");
		event8.setTradeQuantity(300);
		event8.setTradeDirection(TradeDirection.BUY);
		event8.setAccount("ACC-4567");
		event8.setTradeOperation(TradeOperation.NEW);

		event9.setTradeID(6638);
		event9.setVersion(1);
		event9.setSecurityIdentifier("YUI");
		event9.setTradeQuantity(100);
		event9.setTradeDirection(TradeDirection.SELL);
		event9.setAccount("ACC-4567");
		event9.setTradeOperation(TradeOperation.NEW);

		event10.setTradeID(6363);
		event10.setVersion(1);
		event10.setSecurityIdentifier("HJK");
		event10.setTradeQuantity(200);
		event10.setTradeDirection(TradeDirection.BUY);
		event10.setAccount("ACC-5678");
		event10.setTradeOperation(TradeOperation.NEW);

		event11.setTradeID(7666);
		event11.setVersion(1);
		event11.setSecurityIdentifier("HJK");
		event11.setTradeQuantity(200);
		event11.setTradeDirection(TradeDirection.BUY);
		event11.setAccount("ACC-5678");
		event11.setTradeOperation(TradeOperation.NEW);

		event12.setTradeID(6363);
		event12.setVersion(2);
		event12.setSecurityIdentifier("HJK");
		event12.setTradeQuantity(100);
		event12.setTradeDirection(TradeDirection.BUY);
		event12.setAccount("ACC-5678");
		event12.setTradeOperation(TradeOperation.AMEND);

		event13.setTradeID(7666);
		event13.setVersion(2);
		event13.setSecurityIdentifier("HJK");
		event13.setTradeQuantity(50);
		event13.setTradeDirection(TradeDirection.SELL);
		event13.setAccount("ACC-5678");
		event13.setTradeOperation(TradeOperation.AMEND);

		event14.setTradeID(8686);
		event14.setVersion(1);
		event14.setSecurityIdentifier("FVB");
		event14.setTradeQuantity(100);
		event14.setTradeDirection(TradeDirection.BUY);
		event14.setAccount("ACC-6789");
		event14.setTradeOperation(TradeOperation.NEW);

		event15.setTradeID(8686);
		event15.setVersion(2);
		event15.setSecurityIdentifier("GBN");
		event15.setTradeQuantity(100);
		event15.setTradeDirection(TradeDirection.BUY);
		event15.setAccount("ACC-6789");
		event15.setTradeOperation(TradeOperation.AMEND);

		event16.setTradeID(9654);
		event16.setVersion(1);
		event16.setSecurityIdentifier("FVB");
		event16.setTradeQuantity(200);
		event16.setTradeDirection(TradeDirection.BUY);
		event16.setAccount("ACC-6789");
		event16.setTradeOperation(TradeOperation.NEW);

		event17.setTradeID(1025);
		event17.setVersion(1);
		event17.setSecurityIdentifier("JKL");
		event17.setTradeQuantity(100);
		event17.setTradeDirection(TradeDirection.BUY);
		event17.setAccount("ACC-7789");
		event17.setTradeOperation(TradeOperation.NEW);

		event18.setTradeID(1036);
		event18.setVersion(1);
		event18.setSecurityIdentifier("JKL");
		event18.setTradeQuantity(100);
		event18.setTradeDirection(TradeDirection.BUY);
		event18.setAccount("ACC-7789");
		event18.setTradeOperation(TradeOperation.NEW);

		event19.setTradeID(1025);
		event19.setVersion(2);
		event19.setSecurityIdentifier("JKL");
		event19.setTradeQuantity(100);
		event19.setTradeDirection(TradeDirection.SELL);
		event19.setAccount("ACC-8877");
		event19.setTradeOperation(TradeOperation.AMEND);

		event20.setTradeID(1122);
		event20.setVersion(1);
		event20.setSecurityIdentifier("KLO");
		event20.setTradeQuantity(100);
		event20.setTradeDirection(TradeDirection.BUY);
		event20.setAccount("ACC-9045");
		event20.setTradeOperation(TradeOperation.NEW);

		event21.setTradeID(1122);
		event21.setVersion(2);
		event21.setSecurityIdentifier("HJK");
		event21.setTradeQuantity(100);
		event21.setTradeDirection(TradeDirection.SELL);
		event21.setAccount("ACC-9045");
		event21.setTradeOperation(TradeOperation.AMEND);

		event22.setTradeID(1122);
		event22.setVersion(3);
		event22.setSecurityIdentifier("KLO");
		event22.setTradeQuantity(100);
		event22.setTradeDirection(TradeDirection.SELL);
		event22.setAccount("ACC-9045");
		event22.setTradeOperation(TradeOperation.AMEND);

		event23.setTradeID(1144);
		event23.setVersion(1);
		event23.setSecurityIdentifier("KLO");
		event23.setTradeQuantity(300);
		event23.setTradeDirection(TradeDirection.BUY);
		event23.setAccount("ACC-9045");
		event23.setTradeOperation(TradeOperation.NEW);


		event24.setTradeID(1144);
		event24.setVersion(2);
		event24.setSecurityIdentifier("KLO");
		event24.setTradeQuantity(400);
		event24.setTradeDirection(TradeDirection.BUY);
		event24.setAccount("ACC-9045");
		event24.setTradeOperation(TradeOperation.AMEND);

		event25.setTradeID(1155);
		event25.setVersion(1);
		event25.setSecurityIdentifier("KLO");
		event25.setTradeQuantity(600);
		event25.setTradeDirection(TradeDirection.SELL);
		event25.setAccount("ACC-9045");
		event25.setTradeOperation(TradeOperation.NEW);

		event26.setTradeID(1155);
		event26.setVersion(2);
		event26.setSecurityIdentifier("KLO");
		event26.setTradeQuantity(0);
		event26.setTradeDirection(TradeDirection.BUY);
		event26.setAccount("ACC-9045");
		event26.setTradeOperation(TradeOperation.CANCEL);

		
		List<TradeEvent> tradeEvents = new ArrayList<TradeEvent>();
		tradeEvents.add(event1);
		tradeEvents.add(event2);
		tradeEvents.add(event3);
		tradeEvents.add(event4);
		tradeEvents.add(event5);
		tradeEvents.add(event6);
		tradeEvents.add(event7);
		tradeEvents.add(event8);
		tradeEvents.add(event9);
		tradeEvents.add(event10);
		tradeEvents.add(event11);
		tradeEvents.add(event12);
		tradeEvents.add(event13);
		tradeEvents.add(event14);
		tradeEvents.add(event15);
		tradeEvents.add(event16);
		tradeEvents.add(event17);
		tradeEvents.add(event18);
		tradeEvents.add(event19);
		tradeEvents.add(event20);
		tradeEvents.add(event21);
		tradeEvents.add(event22);
		tradeEvents.add(event23);
		tradeEvents.add(event24);
		tradeEvents.add(event25);
		tradeEvents.add(event26);
		
		new TradingController().addTradeEvents(tradeEvents);
	}
}
