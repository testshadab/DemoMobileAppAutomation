# Digital Automation Mobile Framework
## Execution Instruction

The Mobile Automation scripts can be executed for local real devices, emulator, and perfecto mobile through Command Line Interface(CLI)
Also, the Script can be customized by the following parameters ("," separated for each device)

	1. Banner banner property can be set to any banner to be tested on the selected device. This property is combined with mobileDevice property to install and test banner app on selected device. Same banner can be selected more than once for testing the same banner on multiple devices. Example: -Dbanner=safeway,vons,randalls

	2. Mobile Device: Each mobile device’s parameters are saved in a properties file in /src/test/resources/MobileDevices directory. The file name is the same as the parameter value in mobileDevice Property. For each device, set safewaydevice property to be either local or cloud. Example: -DmobileDevice=ipad,nexus,iphonex

	3. Environment: mobileEnv property is used to select the mobile app and test environment. This property can be set to qa or production environment. Below is an example for setting the test app environment to qa2. Exmaple: -DmobileEnv=qa2
	
	4. Test groups: Test cases can be executed in groups by using tags and features. If not select any tag or feature, all test cases in the whole test suite will be executed.
	
	
	
	
**Example for running test using tags: -Dcucumber.filter.tags="@smoke,@P1"**

**Example for running test using features: -Dcucumber.features="{resources path}/features/sign_in.feature"**




## Command Line Examples
1. Run smoke tests on one device – ipad, and one banner – safeway, in qa2 environment
		`mvn test -Dtest=MobileRunner -Dbanner=safeway -DmobileDevice=ipad -DmobileEnv=qa2 -Dcucumber.filter.tags="@smoke"`
2. Run P1 tests on 5 devices – ipad, nexus, emulator, iphonex, samsungs8, and 5 banner – safeway, vons, albertsons, randalls, jewelosco, in production environment
    `mvn test -Dtest=CustomizeRunner -Dbanner= safeway, vons, albertsons, randalls, jewelosco -DmobileDevice= ipad, nexus, emulator, iphonex, samsungs8 
		-DmobileEnv=prod Dcucumber.filter.tags="@P1"`
