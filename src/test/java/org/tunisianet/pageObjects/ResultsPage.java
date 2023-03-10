package org.tunisianet.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ResultsPage {


    final static Duration RESULTS_PAGE_TIMEOUT = Duration.ofSeconds((15));

    static String ORDER_BY_BUTTON_XPATH = "//*[@id=\"js-product-list-top\"]/div[3]/div/div/button";
    static String HIGHEST_PRICE_CHOICE_XPATH = "//*[@id=\"js-product-list-top\"]/div[3]/div/div/div/a[6]";
    static String PHONE_CATEGORY_ID = "c-376";
    static String SELECTED_ITEM_SAMSUNG_XPATH = "//*[@id=\"js-product-list\"]/div/div[4]/article/div/div[2]/h2/a";
    static String SELECTED_ITEM_IPHONE_XPATH = "//*[@id=\"js-product-list\"]/div/div[16]/article/div/div[2]/h2/a";
    static String SELECTED_ITEM_HUAWEI_MATE_XPATH = "//*[@id=\"js-product-list\"]/div/div[1]/article/div/div[2]/h2/a";

    static String IPHONE = "iphone";

    public static void chooseIphonePhone(WebDriver webdriver) throws Exception {
        WebDriverWait webDriverWait = new WebDriverWait(webdriver, RESULTS_PAGE_TIMEOUT);
        chooseHighestPriceItem(webDriverWait, IPHONE);
    }

    public static void choosePhone(WebDriver webdriver, String phoneModel) throws Exception {
        WebDriverWait webDriverWait = new WebDriverWait(webdriver, RESULTS_PAGE_TIMEOUT);
        WebElement phoneCategory = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id(PHONE_CATEGORY_ID)));
        phoneCategory.click();
        Thread.sleep(5000);
        chooseHighestPriceItem(webDriverWait, phoneModel);
    }
    private static void chooseHighestPriceItem(WebDriverWait webDriverWait, String phoneModel) throws Exception {

        WebElement orderByButton = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(ORDER_BY_BUTTON_XPATH)));
        orderByButton.click();
        WebElement highestPriceChoice = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(HIGHEST_PRICE_CHOICE_XPATH)));
        highestPriceChoice.click();
        Thread.sleep(5000);
        WebElement mobilePhone;
        switch (phoneModel.toLowerCase()) {
            case "samsung":
                mobilePhone = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(SELECTED_ITEM_SAMSUNG_XPATH)));
                break;
            case "iphone":
                mobilePhone = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(SELECTED_ITEM_IPHONE_XPATH)));
                break;
            case "huawei":
                mobilePhone = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(SELECTED_ITEM_HUAWEI_MATE_XPATH)));
                break;
            default:
                throw new Exception("Unknown phone model");
        }
        mobilePhone.click();
    }

}

