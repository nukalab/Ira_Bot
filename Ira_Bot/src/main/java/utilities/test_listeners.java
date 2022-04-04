package main.java.utilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import test.java.testbase;
import java.io.File;
import java.io.IOException;

public class test_listeners implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        String methodname = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + result.getMethod().getMethodName();
        File f = ((TakesScreenshot) testbase.driver).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(f, new File(methodname + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
