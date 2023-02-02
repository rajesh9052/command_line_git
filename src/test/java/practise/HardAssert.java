package practise;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert {
//	@Test()
//	
//	public void assrt()
//	{
//		System.out.println("statement 1");
//		System.out.println("Statement 2");
//		
//		Assert.assertEquals(false, true);
//		//                  (actual, expect);
//		
//		System.out.println("statement 3");
//		System.out.println("statement 4");
//	}
//	
//	@Test()
//	
//	public void modify()
//	{
//		System.out.println("statement 5")
//		System.err.println("Statement 6");
//	}
     @Test()
	public void valid()
	{
		String expec = "Rajesh";
		String actual = "Rajesh";
		
		Assert.assertEquals(actual, expec);
		
	}
     
     public void contain()
     {
    	 String expec = "Tummapudi";
    	 String actual = "Rajesh Tummapudi";
    	 
    	 Assert.assertTrue(actual.contains(expec));
     }
}
