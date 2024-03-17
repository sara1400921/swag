import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Motazznabel {

    ChromeDriver driver;
    @BeforeTest
    public void openUrl() {
        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/");
    }
    @Test
    public void testFindElements(){
        List<WebElement> links=driver.findElements(By.tagName("a"));
        System.out.println(links.size());

    }
}
