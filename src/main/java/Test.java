
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase {
    WebDriver driver;


    @AfterTest
    public void tearDown(){
        // driver.close();
        // driver.quit();
    }

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver","drivers/chrome/chromedriver.exe");
        driver = new ChromeDriver();
    }


    @Test
    public void verifyUserCanMoveToStep2Page() throws InterruptedException {
        String url = "https://insurancewebsitedemo.com/personal-insurance/car-insurance";
        driver.get(url);
        String expectedTitle = "Auto, Automobile, Car, Vehicle Insurance in Las Vegas Nevada - Demo Insurance Agency,";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        driver.findElement(By.id("notice-close")).click();

        WebElement quoteRequestLink = driver.findElement(By.linkText("Auto Insurance Quote Request"));
        quoteRequestLink.click();

        //validate we are in quote from page
        WebElement headerText = driver.findElement(By.id("title_div"));
        String actualHeaderText = headerText.getText();
        String expectedHeaderText = "Secure Auto Insurance Quote Request Form";
        Assert.assertEquals(actualHeaderText, expectedHeaderText);

        // fillout form

        // first name
        WebElement firstName = driver.findElement(By.id("fname"));
        String firstNameVal = "Imran";
        firstName.sendKeys(firstNameVal);

        // last name
        WebElement lastName = driver.findElement(By.id("lname"));
        String lastNameVal = "Hossain";
        lastName.sendKeys(lastNameVal);

        // email
        WebElement email = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        String emailAddress = "tester.awesome@testmail.com";
        email.sendKeys(emailAddress);

        // phone number
        WebElement phone = driver.findElement(By.id("phone"));
        String phoneNumber = "4445556666";
        phone.sendKeys(phoneNumber);

        // zip code
        WebElement zip = driver.findElement(By.id("zip"));
        String zipCode = "11102";
        zip.sendKeys(zipCode);

        // click button
        WebElement continueBtn = driver.findElement(By.className("btn-success"));
        continueBtn.click();


        // assertion
        WebElement progressStatus = driver.findElement(By.id("progress_id"));
        String progressStatusActualResult = progressStatus.getText();
        String expectProgressStatusResult = "Step 1 of 4";
        Assert.assertEquals(progressStatusActualResult, expectProgressStatusResult);

        // Assert first name
        WebElement firstNameProgressPage = driver.findElement(By.id("fname"));
        String actualFirstNameVal = firstNameProgressPage.getAttribute("value");
        String expectFirstNameVal = firstNameVal;
        Assert.assertEquals(actualFirstNameVal, expectFirstNameVal);

        /*
        we are pushing this in git to show newchanges
        and the pull request process
         */

    }
}