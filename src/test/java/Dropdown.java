import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Dropdown {

    ChromeDriver driver;

    @BeforeTest
    public void openUrl() {
        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");
    }

    @Test

    public void testDropDownList() throws InterruptedException {


        WebElement options = driver.findElement(By.id("dropdown"));
        Select selectOptions = new Select(options);

        Assert.assertFalse(selectOptions.isMultiple());
        Assert.assertEquals(3,selectOptions.getOptions().size()); //tala3 error lama makatbtsh size
        //selectOptions.selectByValue("1");
        //selectOptions.selectByIndex(3);
        //ask a question here
        selectOptions.selectByVisibleText("Option 1");
        Assert.assertEquals("Option 1",selectOptions.getFirstSelectedOption().getText());
        Thread.sleep(2000);


    }
}