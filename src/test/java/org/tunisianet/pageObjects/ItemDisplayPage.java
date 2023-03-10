package org.tunisianet.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ItemDisplayPage {

    final static Duration ITEM_DISPLAY_PAGE_TIMEOUT = Duration.ofSeconds((15));
    static String ADD_TO_CART_BUTTON_XPATH = "//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button";
    static String ORDER_BUTTON_POPUP_XPATH = "//*[@id=\"blockcart-modal\"]/div/div/div/div[2]/div/div/a";
    static String ORDER_BUTTON__XPATH = "//*[@id=\"main\"]/div/div/div[3]/div/a";



    public static void orderItemIphone(WebDriver webdriver) {

        WebDriverWait webDriverWait = new WebDriverWait(webdriver, ITEM_DISPLAY_PAGE_TIMEOUT);
        WebElement ajouterAuPanier = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(ADD_TO_CART_BUTTON_XPATH)));
        ajouterAuPanier.click();
        WebElement commanderPopup = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(ORDER_BUTTON_POPUP_XPATH)));
        commanderPopup.click();
        WebElement commander = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(ORDER_BUTTON__XPATH)));
        commander.click();
    }
}

