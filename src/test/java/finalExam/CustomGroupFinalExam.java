package finalExam;




import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;




public class CustomGroupFinalExam {
	static WebDriver driver;
	
	@Before
	public void setUp()	{
		System.setProperty("webdriver.chrome.driver", "D:\\QA9\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("http://shop.pragmatic.bg/admin");
	}
	
	@Test
	public void loginBackedn() {
		WebElement usernameTbx=driver.findElement(By.name("username"));
		WebElement passwordTbx=driver.findElement(By.name("password"));
		WebElement loginBtn = driver.findElement(By.cssSelector("button.btn.btn-primary"));
		
		usernameTbx.sendKeys("admin2");
		passwordTbx.sendKeys("parola123!");
		loginBtn.click();
		
				

	}
	
	@Test
	public void creatingCustomGroup() {
		loginBackedn();
		WebElement customersMenu = driver.findElement(By.xpath(" //*[@id='menu-customer']/a" ));
		customersMenu.click();
		WebElement customerGroupsMenu = driver.findElement(By.xpath(" //*[@id='collapse33']/li[2]/a" ));
		customerGroupsMenu.click();
		WebElement addNewGroup = driver.findElement(By.xpath(" //*[@id='content']/div[1]/div/div/a/i" ));
		addNewGroup.click();
		WebElement customGroupNameField = driver.findElement(By.xpath("//*[@id='form-customer-group']/div[1]/div/div/input"));
		customGroupNameField.sendKeys(" Denitsa ");
		WebElement saveButton = driver.findElement(By.xpath("//*[@id='content']/div[1]/div/div/button"));
		saveButton.click();
		WebElement successfulLoginMessage = driver.findElement(By.cssSelector(".alert-success"));
		assertTrue("Wrong error message!", successfulLoginMessage.getText().contains("Success: You have modified customer groups!"));

		}
	


}
