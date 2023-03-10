package org.tunisianet.pageObjects;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LandingPage {


    final static Duration LANDING_PAGE_TIMEOUT = Duration.ofSeconds((10));
    static String SMARTPHONE_SUB_CATEGORY_ID = "596";



    // HTML Elements

    static String CATEGORIES_SELECT_ID = "search_category";
    static String SEARCH_INPUT_ID = "search_query_top";
    static String SEARCH_BUTTON_XPATH = "//*[@id=\"sp-btn-search\"]/button";

    public static void choosePhoneSubCategoryByModel(WebDriver webdriver, String phoneModel ) {
        WebDriverWait webDriverWait = new WebDriverWait(webdriver, LANDING_PAGE_TIMEOUT);
        Select categoriesSelect = new Select(webdriver.findElement(By.id(CATEGORIES_SELECT_ID)));
        categoriesSelect.selectByValue(SMARTPHONE_SUB_CATEGORY_ID);
        WebElement rechercherPhone = webdriver.findElement(By.id(SEARCH_INPUT_ID));
        rechercherPhone.sendKeys(phoneModel);
        WebElement rechercherBouton = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(SEARCH_BUTTON_XPATH)));
        rechercherBouton.click();
    }




}

