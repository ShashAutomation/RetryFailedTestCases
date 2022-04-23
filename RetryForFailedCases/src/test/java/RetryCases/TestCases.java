package RetryCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCases {

		WebDriver driver;
		@BeforeMethod
		public void chromeLaunch()
		{
			System.setProperty("webdriver.chrome.driver", "E:\\lib\\Chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("https://www.google.com/");
			
		}
	
	@Test
	public void Titletest()
	{
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Google In","title not matched");
	}
	@Test
	
		public void Click()
		{
			driver.findElement(By.linkText("Gmail")).click();
		}
	@Test
	public void displayTest()
	{
		boolean b=driver.findElement(By.xpath("//a[@class='gb_d']")).isDisplayed();
		Assert.assertTrue(b);
	}
	@Test
	public void enableTest() throws InterruptedException
	{
		driver.navigate().to("https://www.instagram.com/?hl=en");
		Thread.sleep(2000);
		boolean d=driver.findElement(By.xpath("//button[contains(@class,'sqdOP  L3NKy   y3zKF     ')]")).isEnabled();
		Assert.assertTrue(d);
	}
@AfterMethod
public void close()
{
	driver.quit();
}
}
