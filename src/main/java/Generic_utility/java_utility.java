package Generic_utility;

import java.util.Random;
/**
 * This is for used to avoid duplicate values
 * @author Rajesh
 *
 */
public class java_utility {
  public int getRandom()
  {   Random r = new Random();
     int ran = r.nextInt(1000);
     return ran;
  }
}
