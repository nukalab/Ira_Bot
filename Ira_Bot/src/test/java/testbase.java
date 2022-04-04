package test.java;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class testbase {

    public static WebDriver driver;
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports reports;
    public static ExtentTest logging;
    public static String url;
    public static String chat;
    public static String Policy_Num1;
    public static String Policy_Num2;
    public static String Vehicle_RC;
    public static String Mobile_Num;
    public static String Email_ID;
    public static String Full_Name;
    public static String Address;

    public void driverSetup(String browser){
        if(browser.equalsIgnoreCase(("chrome"))){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "browser_drivers" + File.separator + "chromedriver_win.exe" );
            //For Mac\Linux machines to run this automation, kindly comment the above line and uncomment the respective below lines.
            //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "browser_drivers" + File.separator + "chromedriver_mac.exe" );
            //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "browser_drivers" + File.separator + "chromedriver_linux.exe" );
            driver = new ChromeDriver();
        }
        else{
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "browser_drivers" + File.separator + "chromedriver_win.exe" );
            driver = new ChromeDriver();
        }
    }
    @BeforeSuite
    public void config_setup() throws IOException {
        FileInputStream properties = new FileInputStream(System.getProperty("user.dir")+ File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "config.properties");
        Properties prop = new Properties();
        prop.load(properties);
        url = prop.getProperty("url");
        chat = prop.getProperty("chat");
        Policy_Num1 = prop.getProperty("Policy_Num1");
        Policy_Num2 = prop.getProperty("Policy_Num2");
        Vehicle_RC = prop.getProperty("Vehicle_RC");
        Mobile_Num = prop.getProperty("Mobile_Num");
        Email_ID = prop.getProperty("Email_ID");
        Full_Name = prop.getProperty("Full_Name");
        Address = prop.getProperty("Address");

    }
    @BeforeTest
    public static void beforeTest(){
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+ File.separator + "reports" + File.separator + "AutomationReports.html");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle("Ira Bot Automation Report");
        htmlReporter.config().setReportName("Automation Test Results");
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);
        reports.setSystemInfo("Automation Test Engineer", "Divya Swarupa");

    }
    @BeforeMethod
    @Parameters(value={"browsername"})
    public void beforeMethod(String browsername, Method testMethod) throws IOException {
        logging = reports.createTest(testMethod.getName());
        driverSetup(browsername);
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void afterMethod(ITestResult result){
        if(result.getStatus() == ITestResult.SUCCESS){
                String methodname = result.getMethod().getMethodName();
                String logmessage = "Test Case :  " + methodname + "  :  Passed";
                Markup mk = MarkupHelper.createLabel(logmessage, ExtentColor.GREEN);
                logging.log(Status.PASS, mk);
        }
        else if(result.getStatus() == ITestResult.FAILURE){
            String methodname = result.getMethod().getMethodName();
            String logmessage = "Test Case :  " + methodname + "  :  Failed";
            Markup mk = MarkupHelper.createLabel(logmessage, ExtentColor.RED);
            logging.log(Status.FAIL, mk);
        }
        else if(result.getStatus() == ITestResult.SKIP){
            String methodname = result.getMethod().getMethodName();
            String logmessage = "Test Case :  " + methodname + "  :  Skipped";
            Markup mk = MarkupHelper.createLabel(logmessage, ExtentColor.YELLOW);
            logging.log(Status.SKIP, mk);
        }
       driver.quit();
    }
    @AfterTest
    public void afterTest(){
        reports.flush();

    }
}
