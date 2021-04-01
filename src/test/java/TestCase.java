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

        //Assert last Name
        WebElement lastNameProgressPage = driver.findElement(By.id("lname"));
       String actualLastNameVal = lastNameProgressPage.getAttribute("value");
       String expectedLastNameVal = lastNameVal;
       Assert.assertEquals(actualLastNameVal, expectedLastNameVal);

        //Assert email
        WebElement emailAddressInfo = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        String actualEmailAddress = emailAddressInfo.getAttribute("value");
        String expectedEmailAddress = emailAddress;
        Assert.assertEquals(actualEmailAddress, expectedEmailAddress);

        //Assert phone number
        WebElement phoneNumberInfo = driver.findElement(By.id("phone"));
        String actualPhoneNumber = phoneNumberInfo.getAttribute("value");
        String expectedPhoneNumber = phoneNumber;
        Assert.assertEquals(actualEmailAddress, expectedEmailAddress);

        //Assert Zip Code
        WebElement zipCodeInfo = driver.findElement(By.id("zip"));
        String actualZipCode = zipCodeInfo.getAttribute("value");
        String expectedZipCode = zipCode;
        Assert.assertEquals(actualZipCode, expectedZipCode);


        Thread.sleep(2000);

        // Enter address
        WebElement address = driver.findElement(By.id("address"));
        address.sendKeys("1234 Broadway St");


        // Drop Down

        //Date Of Birth Month
        Select month = new Select(driver.findElement(By.name("form_data[applicant_info][_crypt_date_DOB][month]")));
        month.selectByIndex(4);

        //Date Of Birth Day
        Select day = new Select(driver.findElement(By.name("form_data[applicant_info][_crypt_date_DOB][day]")));
        day.selectByValue("27");

        //Date Of Birth Year
        Select year = new Select(driver.findElement(By.xpath("//*[@id=\"form_div\"]/form/fieldset/div[8]/div[2]/select[3]")));
        year.selectByVisibleText("1950");

        //Occupation
        Select occupation = new Select(driver.findElement(By.name("form_data[applicant_info][occupation]")));
        occupation.selectByVisibleText("Auditor");

        //Education
        Select education = new Select(driver.findElement(By.name("form_data[applicant_info][education]")));
        education.selectByVisibleText("Masters Degree");

        //Residence
        Select residence = new Select(driver.findElement(By.name("form_data[applicant_info][residence_type]")));
        residence.selectByVisibleText("House");

        //Residence Ownership
        Select ownership = new Select(driver.findElement(By.name("form_data[applicant_info][home_ownership]")));
        ownership.selectByVisibleText("Own With Mortgage");

        //Gender
        Select gender = new Select(driver.findElement(By.id("gender")));
        gender.selectByVisibleText("Male");

        //Marital Status
        Select maritalStatus = new Select(driver.findElement(By.xpath("//*[@id=\"form_div\"]/form/fieldset/div[17]/div[2]/select")));
        maritalStatus.selectByVisibleText("Married");


        //continueToPage2

       WebElement continueToPage2 = driver.findElement(By.className("btn-success"));
       continueToPage2.click();

       Thread.sleep(1000);


       //Assert step 2
        WebElement vehicleInformationText = driver.findElement(By.id("progress_id"));
        String actualVehicleInformationText = vehicleInformationText.getText();
        String expectedVehicleInformationText = "Step 2 of 4";
        Assert.assertEquals(actualVehicleInformationText, expectedVehicleInformationText);

       //Number of Vehicles
        Select numberOfVehicles = new Select(driver.findElement(By.id("Number_of_Vehicles")));
        numberOfVehicles.selectByVisibleText("1");

        //Vehicle 1 Model
        WebElement vehicleModel = driver.findElement(By.name("form_data[vehicle_info][model_1]"));
        vehicleModel.sendKeys("Toyota");

        //Body Type
        Select bodyType = new Select(driver.findElement(By.name("form_data[vehicle_info][body_type_1]")));
        bodyType.selectByVisibleText("Sedan");

        // Vehicle VIN
        WebElement vehicleVin = driver.findElement(By.name("form_data[vehicle_info][VIN_1]"));
        vehicleVin.sendKeys( "JF1GE6B6XBH518969");

        //Ownership
        Select ownerShip = new Select(driver.findElement(By.name("form_data[vehicle_info][ownership_1]")));
        ownerShip.selectByVisibleText("Owned");

        //Name on Title
        WebElement title = driver.findElement(By.name("form_data[vehicle_info][titled_to_1]"));
        title.sendKeys( "Imran Hossain");

        //Days Driven Per Week
        WebElement daysDrivenPerWeek = driver.findElement(By.name("form_data[vehicle_info][days_driven_per_week_1]"));
        daysDrivenPerWeek.sendKeys( "6 Days");

        //Distance One Way
        WebElement distanceOneWay = driver.findElement(By.name("form_data[vehicle_info][distance_one_way_1]"));
         distanceOneWay.sendKeys( "10 Miles");

         //Primary Use
        Select primaryUse = new Select(driver.findElement(By.name("form_data[vehicle_info][use_1]")));
        primaryUse.selectByVisibleText("To/From Work");

        //Location Parked at Night
        Select locationParkedAtNight = new Select(driver.findElement(By.name("form_data[vehicle_info][garaging_1]")));
        locationParkedAtNight.selectByVisibleText("Garage");

        //Anti-Lock Brakes
        Select antiLockBrakes = new Select(driver.findElement(By.name("form_data[vehicle_info][Anti-Lock_brakes_1]")));
        antiLockBrakes.selectByVisibleText("Yes");

        //Daytime Running Lights
        Select daytimeRunningLights = new Select(driver.findElement(By.name("form_data[vehicle_info][daytime_running_lights_1]")));
        daytimeRunningLights.selectByVisibleText("Yes");

        //Any Prior Damage to Vehicle
        Select priorDamageToVehicle = new Select(driver.findElement(By.name("form_data[vehicle_info][prior_damage_1]")));
        priorDamageToVehicle.selectByVisibleText("No");

        //Vehicle Ever Used for Deliveries
        Select vehicleEverUsedForDeliveries = new Select(driver.findElement(By.name("form_data[vehicle_info][used_for_delivery_1]")));
        vehicleEverUsedForDeliveries.selectByVisibleText("No");

        //Collision Deductible
        Select collisionDeductible = new Select(driver.findElement(By.name("form_data[vehicle_info][collision_deductible_1]")));
        collisionDeductible.selectByVisibleText("1000");

        //Comprehensive Deductible
        Select comprehensiveDeductible = new Select(driver.findElement(By.name("form_data[vehicle_info][comprehensive_deductible_1]")));
        comprehensiveDeductible.selectByVisibleText("500");

        //Towing/Roadside Coverage
        Select roadSideCoverage = new Select(driver.findElement(By.name("form_data[vehicle_info][towing_or_roadside_1]")));
        roadSideCoverage.selectByVisibleText("100");

        //Rental Reimbursement
        Select rentalReimbursement = new Select(driver.findElement(By.name("form_data[vehicle_info][rental_1]")));
        rentalReimbursement.selectByVisibleText("40");

        //Full Glass Coverage
        Select fullGlassCoverage = new Select(driver.findElement(By.name("form_data[vehicle_info][full_glass_1]")));
        fullGlassCoverage.selectByVisibleText("No");


        //Proceed To Step 3
        WebElement proceedToStep3 = driver.findElement(By.name("next"));
        proceedToStep3.click();

        Thread.sleep(2000);

        //Assertion page 3
        WebElement progressPage3 = driver.findElement(By.id("progress_id"));
        String actualProgressResult = progressPage3.getText();
        String expectedProgressResult = "Step 3 of 4";
        Assert.assertEquals(actualProgressResult, expectedProgressResult);

        //Occupation
        Select Occupation = new Select(driver.findElement(By.name("form_data[driver_info][occupation_1]")));
        Occupation.selectByVisibleText("Actuary");

        //Do you drive for a ride share company
        Select driveRideShareCompany = new Select(driver.findElement(By.name("form_data[driver_info][ride_share_company]")));
        driveRideShareCompany.selectByVisibleText("No");

       //Age Licensed
        WebElement ageLicensed = driver.findElement(By.name("form_data[driver_info][age_licensed_1]"));
        ageLicensed.sendKeys("32");

        // SR22 Filing
        Select SR22 = new Select(driver.findElement(By.name("form_data[driver_info][SR22_filing_1]")));
        SR22.selectByVisibleText("Yes");

        //Eligible For Good Student Discount
        Select studentDiscount = new Select(driver.findElement(By.name("form_data[driver_info][good_student_1]")));
        studentDiscount.selectByVisibleText("No");

        //Eligible For Defensive Driver Discount
        Select defenciveDriverDiscount = new Select(driver.findElement(By.name("form_data[driver_info][defensive_driver_1]")));
        defenciveDriverDiscount.selectByVisibleText("Yes");

        //Eligible For Drivers Ed Discount
        Select EdDiscount = new Select(driver.findElement(By.name("form_data[driver_info][drivers_ed_1]")));
        EdDiscount.selectByVisibleText("No");

        //Proceed To Step 4
        WebElement proceedToStep4 = driver.findElement(By.name("next"));
        proceedToStep4.click();

        Thread.sleep(3000);



        //Underinsured Motorist
        Select underinsuredMotorist = new Select(driver.findElement(By.name("form_data[coverage_info][underinsured]")));
        underinsuredMotorist.selectByVisibleText("None/Reject");

        //Medical Payments
        Select medicalPayments = new Select(driver.findElement(By.name("form_data[coverage_info][medical_payments]")));
        medicalPayments.selectByVisibleText("Reject");

        //Prior Policy Information
        //Auto Insurance
        Select autoInsurance = new Select(driver.findElement(By.name("form_data[prior_policy][currently_insured]")));
        autoInsurance.selectByVisibleText("Yes");

        //Previous (or Current) Carrier
        Select Carrier = new Select(driver.findElement(By.name("form_data[prior_policy][prior_carrier]")));
        Carrier.selectByVisibleText("American Family");

        //Current Policy Premium
        WebElement currentPolicy = driver.findElement(By.name("form_data[prior_policy][current_policy_premium]"));
        currentPolicy.sendKeys("3000");

        // Home Insured
        Select homeInsured = new Select(driver.findElement(By.name("form_data[prior_policy][home_and_auto_combined]")));
        homeInsured.selectByVisibleText("Yes");

        //Current Policy Expiration

        Select expirationMonth = new Select(driver.findElement(By.name("form_data[prior_policy][_date_current_policy_expiration][month]")));
        expirationMonth.selectByValue("08");


        Select expirationDay = new Select(driver.findElement(By.name("form_data[prior_policy][_date_current_policy_expiration][day]")));
        expirationDay.selectByValue("04");


        Select expirationYear = new Select(driver.findElement(By.name("form_data[prior_policy][_date_current_policy_expiration][year]")));
        expirationYear.selectByVisibleText("2020");

        //Years With Previous (or Current) Insuror
        WebElement previousInsuror = driver.findElement(By.name("form_data[prior_policy][years_with_prior]"));
        previousInsuror.sendKeys("5");

        //Years Of Continuous Coverage
        WebElement continuousCoverage = driver.findElement(By.name("form_data[prior_policy][years_with_continuous]"));
        continuousCoverage.sendKeys("3 years");

        //Additional Information
        //How Did You Hear About Us
        Select hearAbout = new Select(driver.findElement(By.name("form_data[additional_information][referral]")));
        hearAbout.selectByVisibleText("Google");

        //Preferred Contact Method
        Select contactMethod = new Select(driver.findElement(By.name("form_data[additional_information][preferred_contact]")));
        contactMethod.selectByValue("Text Message");

        //Additional Comments
        WebElement Comments = driver.findElement(By.name("form_data[additional_information][notes]"));
        Comments.sendKeys("My First End To End Test Case Done");

        //Assertion page 4
        WebElement progressPage4 = driver.findElement(By.id("progress_id"));
        String actualProgressPage4Result = progressPage4.getText();
        String expectedProgressPage4Result = "Step 4 of 4";
        Assert.assertEquals(actualProgressPage4Result, expectedProgressPage4Result);

       // Finish Button
        WebElement done = driver.findElement(By.name("finish"));
        done.click();

        // close Notification
        WebElement closeBtn = driver.findElement(By.id("notice-close"));
        closeBtn.click();


























    }


}
