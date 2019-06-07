# Sprint-Challenge--Building-Java-Web-APIs-gdp

A student that completes this project shows that they can
* build a REST service using Maven, Spring Boot and other Spring projects
* implement server sided routing and rendering for a Spring REST service
* implement industry standard exception handling including user friendly exception messages
* troubleshoot running services using both system and programmatically generated logs
* deploy a full RESTful Web Services application with a JAR using Maven, Spring including Spring Boot, and Tomcat


# Introduction


The top 100 economies in the world are provided below. The data includes the country's name its Country in millions. They are arranged in a way where they can be copy and pasted into a data seed class assuming that the model is crafted correctly. Taking this data, develop an application to help display it.


# Instructions


Expose the following end-points
* /names - return using the JSON format all of the countries alphabetized by name
* /economy - return using the JSON format all of the countries sorted from most to least Country
* /country/{id} - return using the JSON format a single country and Country based off of its id number
* /country/stats/median - return using the JSON the country and its Country with the median Country. For odd number list, return the the country in the middle. For even number list you may return either one of the countries found in the middle.

Create server side rendering pages using Thymeleaf to
* /economy/table - display a table list all countries sorted from most to least Country

Add appropriate exception handling routines. This is the standard exception handling covered in class. Required exceptions to handle are when
* a resource is not found
* the wrong data type is used for a path variable
* a non-handled endpoint is accessed (a URL not found exception)

Add appropriate logging routines. This is the standard logging covered in class. Required logging include
* Activating actuator endpoints
* Tomcat logging routed to a separate log file
Custom logging under each Get endpoint saying the endpoint has been accessed
* should only go to console
* for example when a client calls /names log should say "/names accessed"
  * in the log entry include any parameters that were sent to the endpoint
  * in the log entry include the date and timestamp of the access of the endpoint
* You are not to log access to the server side rendering pages.

Note: put the log files under the directory /tmp/var/logs/lambdajx Feel free to create and necessary subdirectories.

Finally, deploy the application in a JAR file to Heroku. For the application name use <GitHub username>-gdp

## Stretch Goals  

Expose the following end-point  
* /total - return the sum of all Countrys using the JSON format with country name being returned as Total

Create the server side html pages 
* /names/{start letter}/{end letter} - display a table listing all countries in alphabetical order that begin with letters between start and end letter inclusive.
* /gdp/list/{start gdp}/{end gdp} - display a table listing all countries order by Country from least to greatest where the country's Country lies between start gdp and end gdp inclusive.


## the data

When reading in the Country, best practice would be to convert it to a long datatype using something like Long.parseLong(Country)

countryList.add(new Country("United States","20513000"));  
countryList.add(new Country("China","13457267"));  
countryList.add(new Country("Japan","5070626"));  
countryList.add(new Country("Germany","4029140"));  
countryList.add(new Country("United Kingdom","2808899"));  
countryList.add(new Country("France","2794696"));  
countryList.add(new Country("India","2689992"));  
countryList.add(new Country("Italy","2086911"));  
countryList.add(new Country("Brazil","1909386"));  
countryList.add(new Country("Canada","1733706"));  
countryList.add(new Country("South Korea","1655608"));  
countryList.add(new Country("Russia","1576488"));  
countryList.add(new Country("Spain","1437047"));  
countryList.add(new Country("Australia","1427767"));  
countryList.add(new Country("Mexico","1199264"));  
countryList.add(new Country("Indonesia","1005268"));  
countryList.add(new Country("Netherlands","909887"));  
countryList.add(new Country("Saudi Arabia","769878"));  
countryList.add(new Country("Turkey","713513"));  
countryList.add(new Country("Switzerland","709118"));  
countryList.add(new Country("Taiwan","602678"));  
countryList.add(new Country("Sweden","554659"));  
countryList.add(new Country("Poland","549478"));  
countryList.add(new Country("Belgium","536055"));  
countryList.add(new Country("Thailand","490120"));  
countryList.add(new Country("Argentina","475429"));  
countryList.add(new Country("Austria","459401"));  
countryList.add(new Country("Norway","441439"));  
countryList.add(new Country("United Arab Emirates","432612"));  
countryList.add(new Country("Iran","430082"));  
countryList.add(new Country("Nigeria","397472"));  
countryList.add(new Country("South Africa","376679"));  
countryList.add(new Country("Ireland","366448"));  
countryList.add(new Country("Israel","365599"));  
countryList.add(new Country("Hong Kong","360315"));  
countryList.add(new Country("Denmark","354683"));  
countryList.add(new Country("Malaysia","347290"));  
countryList.add(new Country("Singapore","346621"));  
countryList.add(new Country("Colombia","336940"));  
countryList.add(new Country("Philippines","331678"));  
countryList.add(new Country("Pakistan","306987"));  
countryList.add(new Country("Chile","299887"));  
countryList.add(new Country("Bangladesh","286275"));  
countryList.add(new Country("Finland","276553"));  
countryList.add(new Country("Egypt","249471"));  
countryList.add(new Country("Czech Republic","244540"));  
countryList.add(new Country("Vietnam","241434"));  
countryList.add(new Country("Romania","239440"));  
countryList.add(new Country("Portugal","237962"));  
countryList.add(new Country("Iraq","230911"));  
countryList.add(new Country("Peru","228944"));  
countryList.add(new Country("Greece","218057"));  
countryList.add(new Country("New Zealand","205997"));  
countryList.add(new Country("Algeria","188342"));  
countryList.add(new Country("Qatar","188295"));  
countryList.add(new Country("Kazakhstan","184209"));  
countryList.add(new Country("Hungary","156393"));  
countryList.add(new Country("Kuwait","144523"));  
countryList.add(new Country("Ukraine","126390"));  
countryList.add(new Country("Morocco","118178"));  
countryList.add(new Country("Angola","114504"));  
countryList.add(new Country("Ecuador","107266"));  
countryList.add(new Country("Slovakia","106940"));  
countryList.add(new Country("Puerto Rico","104557"));  
countryList.add(new Country("Venezuela","96328"));  
countryList.add(new Country("Sri Lanka","92504"));  
countryList.add(new Country("Kenya","89591"));  
countryList.add(new Country("Ethiopia","83836"));  
countryList.add(new Country("Oman","81682"));  
countryList.add(new Country("Dominican Republic","81103"));  
countryList.add(new Country("Guatemala","79109"));  
countryList.add(new Country("Syria","77460"));  
countryList.add(new Country("Myanmar","71543"));  
countryList.add(new Country("Luxembourg","68993"));  
countryList.add(new Country("Panama","66031"));  
countryList.add(new Country("Bulgaria","63651"));  
countryList.add(new Country("Uruguay","60933"));  
countryList.add(new Country("Costa Rica","60816"));  
countryList.add(new Country("Croatia","59971"));  
countryList.add(new Country("Belarus","56934"));  
countryList.add(new Country("Lebanon","56709"));  
countryList.add(new Country("Tanzania","55645"));  
countryList.add(new Country("Slovenia","54969"));  
countryList.add(new Country("Macau","53961"));  
countryList.add(new Country("Lithuania","52468"));  
countryList.add(new Country("Ghana","51815"));  
countryList.add(new Country("Serbia","47564"));  
countryList.add(new Country("Cote d'Ivoire","45875"));  
countryList.add(new Country("Azerbaijan","45592"));  
countryList.add(new Country("Uzbekistan","43303"));  
countryList.add(new Country("Libya","43236"));  
countryList.add(new Country("Democratic Republic of the Congo","42692"));  
countryList.add(new Country("Turkmenistan","42764"));  
countryList.add(new Country("Jordan","41869"));  
countryList.add(new Country("Paraguay","41851"));  
countryList.add(new Country("Bolivia","41833"));  
countryList.add(new Country("Tunisia","41662"));  
countryList.add(new Country("Bahrain","39300"));  
countryList.add(new Country("Cameroon","38445"));  
countryList.add(new Country("Latvia","34286"));  
countryList.add(new Country("Sudan","33249"));  
