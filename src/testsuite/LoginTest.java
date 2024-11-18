package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {

    String baseUrl = "https://www.saucedemo.com/";


    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValid(){
        //Enter “standard_user” for the username
        driver.findElement(By.xpath("//input [@type = 'text']")).sendKeys("standard_user");
        //Enter “secret_sauce” for the password
        driver.findElement(By.xpath("//input [@type = 'password']")).sendKeys("secret_sauce");
        //Click on the ‘Login’ button
        driver.findElement(By.xpath("//input [@type = 'submit']")).click();
        //Verify the text “Products”
        String expectedMessage = "Products";
        String actualMessage = driver.findElement(By.xpath("//span [@class = 'title']")).getText();
        Assert.assertEquals("Products", expectedMessage, actualMessage);









    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //Enter “standard_user” for the username
        driver.findElement(By.xpath("//input [@type = 'text']")).sendKeys("standard_user");
        //Enter “secret_sauce” for the password
        driver.findElement(By.xpath("//input [@type = 'password']")).sendKeys("secret_sauce");
        //Click on the ‘Login’ button
        driver.findElement(By.xpath("//input [@type = 'submit']")).click();
        //Verify that six products are displayed on page
        List<WebElement> productsList = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        int expectedNoOfProduct = 6;
        Assert.assertEquals("6 products does not display", expectedNoOfProduct, productsList.size());


    }

    @After
    public void tearDown(){
        closeBrowser();

    }
}
