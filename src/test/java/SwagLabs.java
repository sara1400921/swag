import  org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;


public class SwagLabs {

    private WebDriver driver;
    void addItemToCart(String item) {
        String oldLocator="//div[@class=\"inventory_item_name \"and text()=\"%s\"]/parent::a/parent::div/following-sibling::div/button[@class=\"btn btn_primary btn_small btn_inventory \"]";
        String newLocator = String.format(oldLocator,item);

        By newLocator1=By.xpath(newLocator);
        WebElement newLocatorr =driver.findElement(newLocator1);
        newLocatorr.click();

    }

    void search(String item){
        String oldLocator="//div[@class=\"inventory_item_name\"and text()=\"%s\"]";
        String newLocator = String.format(oldLocator,item);
        Assert.assertEquals(driver.findElement(By.xpath(newLocator)).getText().contains(item),true);
    }
    @org.testng.annotations.Test
    public void testDemo() {

        //WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        By loginPageHeaderSelector = By.className("login_logo");
        WebElement loginPageHeader = driver.findElement(loginPageHeaderSelector);
// System.out.println(loginPageHeader.getText());
        Assert.assertEquals(loginPageHeader.getText(), "Swag Labs", "login page header does not match requirement");
        // Assert.assertEquals(driver.findElement( By.className("login_logo")).getText(),"Swag Labs","login page header does not match requirement");

        By userNameSelector = By.id("user-name");
        WebElement username = driver.findElement(userNameSelector);
        username.sendKeys("standard_user");

        By passwordSelector = By.id("password");
        WebElement password = driver.findElement(passwordSelector);
        password.sendKeys("secret_sauce");

        By loginSelector = By.id("login-button");
        WebElement login = driver.findElement(loginSelector);
        login.click();

        String item = "Sauce Labs Backpack";
        addItemToCart(item);

        By cartSelector = By.id("shopping_cart_container");
        WebElement cart = driver.findElement(cartSelector);
        cart.click();

//put xpath
        // Assert.assertEquals(driver.findElement(By.cssSelector(".inventory_item_name")).getText().contains(item),true);
        search(item);



    }
}