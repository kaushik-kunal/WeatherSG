# WeatherSG

#Pre-requisites:
To setup in an IDE, Maven and TestNG Plug-ins are required

#Setup
In order to setup the project, please clone the project in Eclipse, IntelliJ, or any other IDE. Once the pre-requisites are met, please update the Maven dependecies, using IDE/Terminal/Command Line

#Execution through IDE:
Please Right click the testNG.xml and on Run As menu select as TestNG Suite

#Execution through Command Line:
Use the following command
java -cp "path-tojars/testng.jar:path_to_TestScriptTask2_TestClass" org.testng.TestNG testng.xml

#DataFeed
Config.Properties file under Src folder holds essential details like Browser Name, URLs to be passed etc

#TestScript
All the Test flow control is designed using TestNG and can be found under package com.weathersg.haf.action

#ObjectRepository/Page
Per UI screen pages are maintained to modularize the code as max as possible. And this can be found under com.weathersg.haf.page

#Setup
In order to setup the project, please clone the project in Eclipse, IntelliJ, or any other IDE. Once the pre-requisites are met, please update the Maven dependecies, using IDE/Terminal/Command Line
