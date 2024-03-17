import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Addtoitem {
    ChromeDriver driver;
    void addItemToCart(String item) {
        String oldLocator = "//div[@class=\"inventory_item_name \"and text()=\"%s\"]/parent::a/parent::div/following-sibling::div/button[@class=\"btn btn_primary btn_small btn_inventory \"]";
        String newLocator = String.format(oldLocator, item);

        By newLocators = By.xpath(newLocator);
        WebElement newLocater = driver.findElement(newLocators);
        newLocater.click();
    }

        void search (String item){
            String oldLocator="//div[@class=\"inventory_item_name\"and text()=\"%s\"]";
            String newLocator = String.format(oldLocator,item);
            Assert.assertEquals(driver.findElement(By.xpath(newLocator)).getText().contains(item),true);
        }


    @BeforeTest
    public void openUrl() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

        @Test
        public void testDemo () {

        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement btn= driver.findElement(By.id("login-button"));
        btn.click();

            String item = "Sauce Labs Backpack";
            addItemToCart(item);

            WebElement cart1= driver.findElement(By.id("shopping_cart_container"));
            cart1.click();

            search (item);

        }
    }