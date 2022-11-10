package base;

import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;
import utility.TestListener;

@Listeners(TestListener.class)
public class BaseTest {
    public static SoftAssert softAssert = new SoftAssert();


}
