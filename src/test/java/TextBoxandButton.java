import org.checkerframework.checker.units.qual.N;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TextBoxandButton {
    ChromeDriver driver;
    @BeforeTest
    public void openUrl() {
        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/login");
    }
@Test
    public void loginscreen() {
    WebElement txtUsername = driver.findElement(By.id("username"));
    WebElement txtPassword=driver.findElement(By.id("password"));
    WebElement btn=driver.findElement(By.className("radius"));

    txtUsername.clear();
    txtUsername.sendKeys("tomsmith");

    txtPassword.clear();
    txtPassword.sendKeys("SuperSecretPassword!");

    btn.click();
    WebElement successNotification =driver.findElement(By.id("flash"));
    System.out.println(successNotification.getText());
    Assert.assertTrue(successNotification.getText().contains("secure area")); //msh = 3aiza kelma wa7da

    WebElement Noti =driver.findElement(By.className("subheader"));
    System.out.println(Noti.getText());
     Assert.assertTrue(Noti.getText().contains("Welcome to"));
    }


}

