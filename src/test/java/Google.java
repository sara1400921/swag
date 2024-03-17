import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Google {


        ChromeDriver driver;
       WebElement txtSearch;
    @BeforeTest
        public void openUrl() {
            driver = new ChromeDriver();
            driver.navigate().to("http://www.google.com");

        }
        @Test
     public void textSubmit (){
            txtSearch = driver.findElement(By.id("APjFqb"));
             txtSearch.sendKeys("selenium webdriver");
             txtSearch.submit();

            txtSearch = driver.findElement(By.id("APjFqb"));
             txtSearch.clear();
             txtSearch.sendKeys("python");
             txtSearch.submit();
        }


}
