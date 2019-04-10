# jpmorgan Trading Test

As an investment bank we have a requirement to maintain the total quantity of a traded security held at any point in time, this is referred to as a real time position.

### Implementation details

To display real time trading data, the front end should interact with backend restAPIs. 
This code project only includes backend APIs and do not include front end. The app can be extended to display real time data on UI by implementing front end.

**The APIs exposed are**

1. GET method  : /tradeEvents   - this API returns all the tradeEvents added in trading module
1. POST method : /tradeEvents   - this API accepts json array and stored trade events in trading module
1. GET method  : /tradeOutcomes - this API computes trading Outcome from Tradeevents preent in trading module and returns Outcomes json array
1. GET method  : /clearEvents   - this API resets trade Events added so far in trading modules
1. GET method  : /clearOutcomes - this API resets trade Outcomes added so far in trading modules
1. GET method  : /clearAll      - this API clears both trade events and trade outcomes in trading module
1. GET method  : /test          - to test health check


**Usage of APIs**

1. When a new trade is made, User will insert trade events (can be list of trade Events) from front end. 
1. From frontend on periodic basis or when a new trade event is added, can invoke /tradeOutcomes GET to fetch updated outcomes
1. All the trade events and outcomes will be stored in TradingModule.
1. As this application do not use any Database or cache server or session objects to persist trade events and its trade outcomes, to storing `tradeEvents` and `tradeOutcome` as static object in TradingModule class ( this is small scale implementation )
1. Any number of trade events can be added
1. When /tradeOutcomese GET API is invoked, trade outcome is computed and returned
1. User can use /clearEvents, /clearOutcomes, /clearAll as cleanup job


**project package details**

_**/src/main/java**_

1. com.jpmorgan.trading 
     * TradingApplication - main class
     * Initialize class -> InitializeTradeEventsForApp - **solemnly for testing purpos
2. com.jpmorgan.trading.controllers
     * TradingController - controller method, having all action methos
3. com.jpmorgan.trading.domain 
     * TradeEvents    - Trade events model class
     * TradeOutcome   - Trade outcomes model class
     * TradeDirection - Enum for Trade Direction
     * TradeOperation - Enum for Trade Operation
4. com.jpmorgan.trading.module
     * TradingModule     - interface class
     * TradingModuleImpl - implementation for TradingModule. As methioned earlier, this acts like a store for events and outcomes
5. com.jpmorgan.trading.services
     * TradingService     - interface class
     * TradingServiceImpl - implementation of TradingService, this holds business logic
   
 _**/src/test/java**_ - containes Unit tests
 
1. com.jpmorgan.trading.controllers
     *  TradingControllerTests
2. com.jpmorgan.trading.module
     *  TradingModuleImplTests
3. com.jpmorgan.trading.services
     *  TradingServiceImplTests


**Unit test report**

https://github.com/deepikathimmegowda/jpmorgan/blob/master/Unit_test_report.xml

Enchancments: TODO** 

1. Add exception Handling
1. Add required logging
1. Add validation for input post data
1. Using IoC library
1. Check Code coverage and add more TCs
1. Validation https headers for APIs request

Knows Issues:

1. *Multiple versions of a trade with the same trade ID can be processed, however, only the trade with the highest version should remain part of the aggregated position record*
 only one edge case is missed : scenarion SecurityIdentifier -> KLO -  To solve: create version list and keep track of version while considering higher version trade
