import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LinkText {

    ChromeDriver driver;
    @BeforeTest
    public void openUrl() {
        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/login");
    }

    @Test
     public void testLinkText() {
        WebElement SeleniumLink = driver.findElement(By.linkText("Elemental Selenium"));
        System.out.println(SeleniumLink.getAttribute("href"));
    }
    @Test
    public void testLinkPartialText() {
        WebElement SeleniumLink = driver.findElement(By.partialLinkText(" Selenium"));
        System.out.println(SeleniumLink.getAttribute("href"));
    }

    }


