package e2e;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {
    protected static ApplicationManager app = new ApplicationManager();
    protected static Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void setupTest() {
        app.init();
    }

    @BeforeMethod
    public void startTest(Method m, Object[] p) {
        logger.info("Start test " + m.getName() + " with data: " + Arrays.asList(p));
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }

    @AfterMethod
    public void stopTest(ITestResult result) {
        if (result.isSuccess()) {
            logger.info("PASSES =) " + result.getMethod().getMethodName());
        } else {
            logger.info("FAILED =( " + result.getMethod().getMethodName());
        }
        logger.info("========================================================");
    }
}
