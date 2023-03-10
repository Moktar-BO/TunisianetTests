package org.tunisianet.stepsDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.tunisianet.pageObjects.CustomerAccountPage;
import org.tunisianet.pageObjects.ItemDisplayPage;
import org.tunisianet.pageObjects.LandingPage;
import org.tunisianet.pageObjects.ResultsPage;

public class BuyPhoneSteps {


    public static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
    public static final String CHROMEDRIVER_PATH = "/Applications/chromedriver";
    public static final String TUNISIANET_HOME_PAGE = "https://www.tunisianet.com.tn/";
    static String IPHONE = "iphone";
    static String SAMSUNG = "Samsung";
    static String HUAWEI = "huawei";
    WebDriver webdriver;

    @Given("A user searches for an {string} Tunisianet")
    public void aUserBrowseAvailablePhonesInTunisianet(String phoneModel) throws Exception {
        LandingPage.choosePhoneSubCategoryByModel(webdriver, phoneModel);
        ResultsPage.chooseIphonePhone(webdriver);
    }

    @When("She selects an {string} model")
    public void sheSelectsAnModel(String phoneModel) {
        ItemDisplayPage.orderItemIphone(webdriver);
    }

    @And("She provides personal information")
    public void sheProvidesPersonalInformation() throws InterruptedException {
        CustomerAccountPage.fillCustomerInformationPhone(webdriver);
    }

    @Then("She is prompted to add address information")
    public void sheIsPromptedToAddAddressInformation() {
        //todo: check Page URL or Payment box is visible
    }


    @Before
    public void setup() {
        System.setProperty(WEBDRIVER_CHROME_DRIVER, CHROMEDRIVER_PATH);
        webdriver = new ChromeDriver();
        webdriver.get(TUNISIANET_HOME_PAGE);
        webdriver.manage().window().maximize();
    }

    @After
    public void teardown(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());
        this.webdriver.quit();
    }
}
