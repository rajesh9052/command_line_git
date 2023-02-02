package practise;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class softasser {
	@Test()
	public void soft()
	{
		System.out.println("st1");
		System.out.println("st2");
		System.out.println("st3");
		
		SoftAssert so = new SoftAssert();
		 so.assertEquals(false , true);
		  System.out.println("st4");
		  System.out.println("st5");
		  System.out.println("st6");
		  so.assertAll();
	}

}
