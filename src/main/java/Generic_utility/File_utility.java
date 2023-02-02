package Generic_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class File_utility {
	/**
	 * This method used for Property file
	 * @param key
	 * @return
	 * @throws Exception
	 * @ Rajesh
	 * 
	 */
	public String getKeyandValue(String key) throws Exception
	{ FileInputStream fi = new FileInputStream("./src/test/resources/vtiger.properties");
      Properties po = new Properties();
      po.load(fi);
      String value =    po.getProperty(key);
	  return value;
	}

}
