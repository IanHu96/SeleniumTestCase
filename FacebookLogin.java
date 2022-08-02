package TestPackage;
import java.util.HashMap;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class FacebookLogin {
//Chrome options more of handling alerts; ChromeOptions class is a class for ChromeDriver which has methods for enabling various ChromeDriver capabilities. 
//One such capability is to disable the notifications that we get while logging into some of the commercial websites
//HashMap with keys and values as String and Object; put() function for overriding the default setting of the browser.
//setExperimentalOption() method to set  preferences for the browser.
	
	
          @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        HashMap<String, Object>map = new HashMap<String, Object>();
        map.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", map);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com");
        WebElement element = driver.findElement(By.xpath("//*[@id = 'email']"));
        element.sendKeys("");
        WebElement element2 = driver.findElement(By.xpath("//*[@id = 'pass']"));
        element2.sendKeys("");
        element2.submit();
        
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
        System.out.println("Verifying the page title has started");
        System.out.println(driver.getTitle());
        //ActualTitle = driver.getTitle();
        String ExpectedTitle = "Facebook";
        //Assert.assertEquals(ExpectedTitle, ActualTitle,"Page title doesnt match");
        Assert.assertEquals(driver.getTitle(), ExpectedTitle);
        System.out.println("The page title has been successfully verified");
        System.out.println("User logged in successfully");
        //System.out.println(driver.getTitle());

		//asset 
		//quit browser
		driver.quit();
    }
          
}


