package com.saucedemo;

import com.cucumber.listener.Reporter;
import com.saucedemo.propertyread.PropertyReader;
import com.saucedemo.my_utility.MyUtility;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.io.IOException;

public class Hooks extends MyUtility {

    @Before
    public void setUP() {
        selectBrowser(PropertyReader.getInstance().getProperty("browser"));
    }

    @After
    public void tearDown(Scenario scenario) {
        if(scenario.isFailed()){
            String screenshotPath= MyUtility.getScreenshot(driver, scenario.getName().replace(" ", "_"));
            try {
                Reporter.addScreenCaptureFromPath(screenshotPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        closeBrowser();
    }
}
