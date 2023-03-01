import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GooglePageTest {

    private String Url;
    private WebDriver driver;

    @Before
    public void before(){
        //setup web drivers
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
        Url = "https://www.google.com/";
        driver = new ChromeDriver();
        driver.get(Url);
    }

    @Test
    public void AboutButtonClick(){
        WebElement AboutButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/a[1]"));
        Assert.assertEquals(AboutButton.isDisplayed(), true);
        AboutButton.click();
        Assert.assertEquals(driver.getTitle(),"Google - About Google, Our Culture & Company News");
    }

    @Test public void StoreButtonClick(){
        WebElement StoreButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/a[2]"));
        Assert.assertEquals(StoreButton.isDisplayed(), true);
        StoreButton.click();
        Assert.assertEquals(driver.getTitle(),"Google Store for Google Made Devices & Accessories");
    }

    @Test public void GmailButtonClick(){
        WebElement GmailButton = driver.findElement(By.xpath("//*[@id=\"gb\"]/div/div[1]/div/div[1]/a"));
        Assert.assertEquals(GmailButton.isDisplayed(), true);
        GmailButton.click();
        Assert.assertEquals(driver.getTitle(),"Gmail: Private and secure email at no cost | Google Workspace");
    }

    @Test public void ImageButtonClick(){
        WebElement ImageButton = driver.findElement(By.xpath("//*[@id=\"gb\"]/div/div[1]/div/div[2]/a"));
        Assert.assertEquals(ImageButton.isDisplayed(), true);
        ImageButton.click();
        Assert.assertEquals(driver.getTitle(),"Google Images");
    }

    @Test
    public void GoogleAppsClick(){
        WebElement GoogleApps = driver.findElement(By.xpath("//*[@id=\"gbwa\"]/div/a"));
        Assert.assertEquals(GoogleApps.isDisplayed(), true);
        GoogleApps.click();
        Assert.assertEquals(GoogleApps.isEnabled(), true);
    }

    @Test
    public void SignInButtonClick(){
        WebElement SignInButton = driver.findElement(By.xpath("//*[@id=\"gb\"]/div/div[2]/a/span"));
        Assert.assertEquals(SignInButton.isDisplayed(), true);
        SignInButton.click();
        Assert.assertEquals(driver.getTitle(),"Sign in - Google Accounts");
    }

    @Test
    public void ImFeelingLuckClick() throws InterruptedException{
        WebElement ImFeelingLuckButton = driver.findElement(By.xpath("//*[@id=\"gbqfbb\"]"));

        Actions action = new Actions(driver);
        action.moveToElement(ImFeelingLuckButton).perform();
        Thread.sleep(2000);
        action.click().perform();
        Thread.sleep(2000);
        Assert.assertNotEquals(driver.getTitle(),"Google");
    }

    @Test
    public void searchTest() {
        WebElement textbox = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
        Assert.assertEquals(textbox.isDisplayed(), true);

        WebElement searchButton = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]"));
        Assert.assertEquals(searchButton.isDisplayed(), true);

        textbox.sendKeys("Hello world", Keys.TAB);

        searchButton.click();
        Assert.assertEquals(driver.getTitle(), "Hello world - Google Search");
    }

    @After
    public void teardown() throws IOException{
        driver.quit();
    }
}
