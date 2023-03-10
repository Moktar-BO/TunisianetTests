package org.tunisianet.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerAccountPage {
    final static Duration RESULT_PAGE_TIMEOUT = Duration.ofSeconds((10));
    static String FIRST_NAME = "MORTAR";
    static String NAME = "BEN OUANES";
    static String E_MAIL = "moktar.benouanes@esprit.tn";
    static String PASSWORD = "22581156_";
    static String DATE_OF_BIRTH = "10/01/1989";



    static String ADDRESS = "Rue iben roched";
    static String ZIP_CODE = "5000";
    static String CITY = "Monastir";
    static String TELEPHONE = "22443394";


    // HTML Elements
    static String NEW_CUSTOMER_BUTTON_XPATH = "//*[@id=\"checkout-personal-information-step\"]/div/ul/li[3]/a";
    static String CUSTOMER_SEX_XPATH = "//*[@id=\"customer-form\"]/section/div[1]/div[1]/label[1]/span/input";
    static String  FIRST_NAME_XPATH = "//*[@id=\"customer-form\"]/section/div[2]/div[1]/input";
    static String NAME_XPATH = "//*[@id=\"customer-form\"]/section/div[3]/div[1]/input";
    static String E_MAIL_XPATH = "//*[@id=\"customer-form\"]/section/div[4]/div[1]/input";
    static String PASSWORD_XPATH = "//*[@id=\"customer-form\"]/section/div[5]/div[1]/div/input";
    static String DATE_OF_BIRTH_XPATH = "//*[@id=\"customer-form\"]/section/div[6]/div[1]/input";
    static String CONTINUED_BUTTON_XPATH = "//*[@id=\"customer-form\"]/footer/button";



    static String ADDRESS_XPATH = "//*[@id=\"delivery-address\"]/div/section/div[5]/div[1]/input";
    static String ZIP_CODE_XPATH = "//*[@id=\"delivery-address\"]/div/section/div[7]/div[1]/input";
    static String CITY_XPATH = "//*[@id=\"delivery-address\"]/div/section/div[8]/div[1]/input";
    static String TELEPHONE_XPATH = "//*[@id=\"delivery-address\"]/div/section/div[9]/div[1]/input";
    static String CONTINUED2_BUTTON_XPATH = "//*[@id=\"delivery-address\"]/div/footer/button";


    /**
     * Fill the information form with the customers personal data
     * @param webdriver Selenium WebDriver
     * @throws InterruptedException
     */
    public static void fillCustomerInformationPhone(WebDriver webdriver) throws InterruptedException {
        WebDriverWait webDriverWait = new WebDriverWait(webdriver, RESULT_PAGE_TIMEOUT);
        WebElement nouveauClient = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(NEW_CUSTOMER_BUTTON_XPATH)));
        nouveauClient.click();
        Thread.sleep(3000);
        WebElement sex = webdriver.findElement(By.xpath(CUSTOMER_SEX_XPATH));
        sex.click();
        WebElement Prenom = webdriver.findElement(By.xpath(FIRST_NAME_XPATH));
        Prenom.sendKeys(FIRST_NAME);
        WebElement nom = webdriver.findElement(By.xpath(NAME_XPATH));
        nom.sendKeys(NAME);
        WebElement email = webdriver.findElement(By.xpath(E_MAIL_XPATH));
        email.sendKeys(E_MAIL);
        WebElement pswd = webdriver.findElement(By.xpath(PASSWORD_XPATH));
        pswd.sendKeys(PASSWORD);
        WebElement dateDeNaissance = webdriver.findElement(By.xpath(DATE_OF_BIRTH_XPATH));
        dateDeNaissance.sendKeys(DATE_OF_BIRTH);
        WebElement continuer = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(CONTINUED_BUTTON_XPATH)));
        continuer.click();
    }




        /*WebElement adresse = webdriver.findElement(By.xpath(ADDRESS_XPATH));
        adresse.sendKeys(ADDRESS);
        Thread.sleep(3000);
        WebElement codePostale = webdriver.findElement(By.xpath(ZIP_CODE_XPATH));
        codePostale.sendKeys(ZIP_CODE);
        Thread.sleep(3000);
        WebElement ville = webdriver.findElement(By.xpath(CITY_XPATH));
        ville.sendKeys(CITY);
        Thread.sleep(3000);
        WebElement telephone = webdriver.findElement(By.xpath(TELEPHONE_XPATH));
        telephone.sendKeys(TELEPHONE);
        Thread.sleep(3000);
        WebElement continuer2 = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(CONTINUED2_BUTTON_XPATH)));
        continuer2.click();

       Thread.sleep(3000);*/
}
