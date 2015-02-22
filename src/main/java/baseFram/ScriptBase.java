package baseFram;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class ScriptBase {
	
	protected WebDriver driver;
	private AberCrombicApplication abercrombi;
	
	
	@Parameters({"browser"})
	@BeforeClass
	public void beforeclass(@Optional("ff")String browser) throws Exception {
		//startRecording();	
		
		if(browser.contentEquals("ff")){
			driver = new FirefoxDriver();
			
			//File profileDirectory = new File(System.getProperty("user.dir") + "/profile/");
			//FirefoxProfile profile = new FirefoxProfile(profileDirectory);
			//profile.setEnableNativeEvents(true);
			
			//profile.setPreference("browser.cache.disk.enable", false);
			//driver = new FirefoxDriver(profile);
		}
		else if (browser.contentEquals("ch"))
		{
			File chromeDriverFile = new File(System.getProperty("user.dir") +  "/driver/32/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", chromeDriverFile.getAbsolutePath());
			driver = new ChromeDriver();
		} 
		else if(browser.contentEquals("ie")){
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setJavascriptEnabled(true);
			capabilities.setBrowserName("internet explorer");
			capabilities.setCapability("requireWindowFocus",true);
			//capabilities.setCapability("platform", "WIN8.0");
			//capabilities.setCapability("version", "10");

			//File driverFile = new File("C:/MyDevelopments/EclipseRepository/SeleniumWebDriver05/drivers/IEDriverServer.exe");
			File driverFile = new File(System.getProperty("user.dir") +  "/driver/32/IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", driverFile.getAbsolutePath());
			driver = new InternetExplorerDriver(capabilities);
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to("http://www.abercrombie.com/shop/us");
		driver.manage().window().maximize();
		
	}

	@BeforeMethod
	public void beforMethod(){
		
	}
	
	@AfterMethod
	public void afterMethod(){

	}
	
	@AfterClass
	  public void afterclass() {
			driver.close();
			driver.quit();
			/*driver = null;
			abercrombi = null;*/
	  }
	
	public void myAfterMethod(){
		// this aftermehtod is a method
		// for only data driven test
		// to log out for browser reset purpose
		abercrombi().util().hoverOnHEY(abercrombi().log().heyLink());
		abercrombi().log().logoutLink().click();
		abercrombi().log().VerifyLogout();
	}
    
	public AberCrombicApplication abercrombi(){

		if(abercrombi == null){
			abercrombi = new AberCrombicApplication(driver);
			}	
		return abercrombi;
			}
			
	
	
		
} // end of class
