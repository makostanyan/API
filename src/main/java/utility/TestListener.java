package utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestContext;

public class TestListener implements ITestListener {

    public static Logger log = LogManager.getLogger(TestListener.class);

    @Override
    public void onStart(ITestContext result) {
        log.info("Hello" + result.getName());

    }

}
