package db_practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.generic.BaseClass;
@Listeners(com.crm.comcast.generic.ListnerImplementation.class)
public class TakeScreenshot extends BaseClass
{

	
    @Test
	public void test()
	{
		
		
		Assert.fail();
		

	}

}
