package TestCase;

//import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import Utilities.Apache_poi_utility;

public class Test1 extends BaseClass {
	
Apache_poi_utility poi= new Apache_poi_utility();
@Test
void TestCase() throws Exception
{
	poi.File_Method();
	logger1.info("testing in second test");
	}
}
