package com.saucedemo.saucelabs_pages;

import com.saucedemo.my_utility.MyUtility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompleteCheckoutPage extends MyUtility {

    private static final Logger log = LogManager.getLogger(CompleteCheckoutPage.class.getName());
    public CompleteCheckoutPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".complete-header")
    WebElement thanksMessage;

    public String verifyMessage(){
        log.info("Getting confirmation text to confirm Order "+thanksMessage.toString());
        return thanksMessage.getText();
    }
}


