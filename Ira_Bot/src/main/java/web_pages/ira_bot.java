package main.java.web_pages;
import main.java.utilities.element_locators;
import main.java.web_objects.ira_bot_objects;
import org.testng.Assert;
import test.java.testbase;

import java.util.Iterator;
import java.util.Set;

import static test.java.testbase.*;

public class ira_bot {
    //Method to click on Notification, get that text and get into the bot.
    public void clickOnIraAvatar() throws InterruptedException {
        element_locators locators = new element_locators();
        testbase.logging.info("Clicking on Ira bot avatar");
        locators.getElementLocator("Xpath", ira_bot_objects.iraAvatar_xpath).click();
        Thread.sleep(2000);
    }
    //Method to read the welcome message and get started with chat bot
    public void verifyWelcomeText() throws InterruptedException {
        element_locators locators = new element_locators();
        Assert.assertTrue(locators.getElementLocator("Xpath", ira_bot_objects.welcomeText_xpath).getText().contains("Hello"), "Ira Bot Welcome text is not displayed");
        testbase.logging.info("Welcome text is displayed");
        locators.getElementLocator("Xpath", ira_bot_objects.getStartedText_xpath).click();
        testbase.logging.info("Getting Started with the bot");
        Thread.sleep(2000);
    }
    //Method to send chat and read the responses from the bot
    public void readingBotResponses() throws InterruptedException {
        element_locators locators = new element_locators();
        testbase.driver.switchTo().frame(locators.getElementLocator("Xpath", ira_bot_objects.iraBotChatAreaIframe_xpath));
        if(locators.getElementLocator("Xpath", ira_bot_objects.menuCloseToggle_xpath).isDisplayed()){
            locators.getElementLocator("Xpath", ira_bot_objects.menuCloseToggle_xpath).click();

        }
        locators.getElementLocator("Xpath", ira_bot_objects.enterQueryText_xpath).sendKeys(chat);
        locators.getElementLocator("Xpath", ira_bot_objects.sendButton_xpath).click();
        testbase.logging.info("User sent greetings to bot :  " + chat);
        Thread.sleep(3000);
        String responseChat = locators.getElementLocator("Xpath", ira_bot_objects.responseChat_xpath).getText();
        testbase.logging.info("User received response from bot :  " + responseChat);

    }
    //Method to reset the chat context
    public void resetChatContext() throws InterruptedException {
        element_locators locators = new element_locators();
        if(locators.getElementLocator("Xpath", ira_bot_objects.menuCloseToggle_xpath).isDisplayed()){
            locators.getElementLocator("Xpath", ira_bot_objects.menuCloseToggle_xpath).click();

        }
        locators.getElementLocator("Xpath", ira_bot_objects.enterQueryText_xpath).sendKeys("reset");
        locators.getElementLocator("Xpath", ira_bot_objects.sendButton_xpath).click();
        Thread.sleep(2000);
        testbase.logging.info("Chat context is reset");


    }
    //Method to download and renew motor policy and others
    public void policyDownload(String policyName) throws InterruptedException {
        element_locators locators = new element_locators();
        testbase.driver.switchTo().frame(locators.getElementLocator("Xpath", ira_bot_objects.iraBotChatAreaIframe_xpath));
        switch (policyName) {
            case "DownloadMotorPolicy" -> {
                locators.getElementLocator("Xpath", ira_bot_objects.downloadMotorPolicy_xpath).click();
                locators.getElementLocator("Xpath", ira_bot_objects.policyDownloadForAll_xpath).click();
                testbase.logging.info("Motor Policy downloaded successfully");
            }
            case "DownloadHealthPolicy" -> {
                locators.getElementLocator("Xpath", ira_bot_objects.downloadHealthPolicy_xpath).click();
                locators.getElementLocator("Xpath", ira_bot_objects.policyDownloadForAll_xpath).click();
                testbase.logging.info("Health Policy downloaded successfully");
            }
            case "RenewMotorPolicy" -> {
                locators.getElementLocator("Xpath", ira_bot_objects.renewMotorPolicy_xpath).click();
                if (locators.getElementLocator("Xpath", ira_bot_objects.menuCloseToggle_xpath).isDisplayed()) {
                    locators.getElementLocator("Xpath", ira_bot_objects.menuCloseToggle_xpath).click();

                }
                Thread.sleep(1000);
                locators.getElementLocator("Xpath", ira_bot_objects.enterQueryText_xpath).sendKeys(Policy_Num1);
                locators.getElementLocator("Xpath", ira_bot_objects.sendButton_xpath).click();
                Thread.sleep(1000);
                locators.getElementLocator("Xpath", ira_bot_objects.enterQueryText_xpath).sendKeys(Vehicle_RC);
                locators.getElementLocator("Xpath", ira_bot_objects.sendButton_xpath).click();
                Thread.sleep(1000);
                locators.getElementLocator("Xpath", ira_bot_objects.enterQueryText_xpath).sendKeys(Mobile_Num);
                locators.getElementLocator("Xpath", ira_bot_objects.sendButton_xpath).click();
                Thread.sleep(1000);
                locators.getElementLocator("Xpath", ira_bot_objects.enterQueryText_xpath).sendKeys(Email_ID);
                locators.getElementLocator("Xpath", ira_bot_objects.sendButton_xpath).click();
                locators.getElementLocator("Xpath", ira_bot_objects.renewYesButton_xpath).click();
                Assert.assertTrue(locators.getElementLocator("Xpath", ira_bot_objects.renewConfirmedText_xpath).isDisplayed(), "Motor policy renew process failed");
                testbase.logging.info("Motor policy renew process is successful");
            }
            case "BuyPolicy" -> locators.getElementLocator("Xpath", ira_bot_objects.buyPolicy_xpath).click(); //yet to develop the script
            case "OthersPolicy" -> locators.getElementLocator("Xpath", ira_bot_objects.othersPolicyInfo_xpath).click(); //yet to develop the script
        }
    }
    //Method to fill Test Bot form
    public void testBot() throws InterruptedException {
        element_locators locators = new element_locators();
        testbase.driver.switchTo().frame(locators.getElementLocator("Xpath", ira_bot_objects.iraBotChatAreaIframe_xpath));
        locators.getElementLocator("Xpath", ira_bot_objects.menuTestBot_xpath).click();
        Thread.sleep(1000);
        testbase.logging.info("Entered Test Bot");
        locators.getElementLocator("Xpath", ira_bot_objects.testBotFullName_xpath).sendKeys(Full_Name);
        locators.getElementLocator("Xpath", ira_bot_objects.testBotAddress_xpath).sendKeys(Address);
        locators.getElementLocator("Xpath", ira_bot_objects.testBotFemale_xpath).click();
        locators.getElementLocator("Xpath", ira_bot_objects.testBotSelection_xpath).click();
        locators.getElementLocator("Xpath", ira_bot_objects.testBotRarely_xpath).click();
        locators.getElementLocator("Xpath", ira_bot_objects.testBotRating_5_xpath).click();
        locators.getElementLocator("Xpath", ira_bot_objects.testBotThumbsUp_xpath).click();
        locators.getElementLocator("Xpath", ira_bot_objects.testBotSubmit_xpath).click();
        Assert.assertTrue(locators.getElementLocator("Xpath", ira_bot_objects.testBotSubmitSuccess_xpath).isDisplayed(),"Test Bot form submission failed");
        testbase.logging.info("Test Bot form is successfully submitted");
    }
    //Method for New Test for bot
    public void newTest() throws InterruptedException {
        element_locators locators = new element_locators();
        testbase.driver.switchTo().frame(locators.getElementLocator("Xpath", ira_bot_objects.iraBotChatAreaIframe_xpath));
        if(locators.getElementLocator("Xpath", ira_bot_objects.menuCloseToggle_xpath).isDisplayed()){
            locators.getElementLocator("Xpath", ira_bot_objects.menuCloseToggle_xpath).click();

        }
        locators.getElementLocator("Xpath", ira_bot_objects.enterQueryText_xpath).sendKeys("New Test");
        locators.getElementLocator("Xpath", ira_bot_objects.sendButton_xpath).click();
        Thread.sleep(1000);
        testbase.logging.info("Entered New Test");
        locators.getElementLocator("Xpath", ira_bot_objects.testGoogle_xpath).click();
        locators.getElementLocator("Xpath", ira_bot_objects.testGoogleClose_xpath).click();
        testbase.logging.info("New Test - Google is completed");
        String parentwindow = testbase.driver.getWindowHandle();
        locators.getElementLocator("Xpath", ira_bot_objects.testCall_xpath).click();
        Set<String> ws = locators.webHandles();
        Iterator<String> iT = ws.iterator();
        while(iT.hasNext()){
            String childwindow = iT.next();
            if(!parentwindow.equalsIgnoreCase(childwindow)){
                testbase.driver.switchTo().window(childwindow);
                Thread.sleep(2000);
                testbase.driver.close();
            }
        }
        testbase.driver.switchTo().window(parentwindow);
        testbase.driver.switchTo().frame(locators.getElementLocator("Xpath", ira_bot_objects.iraBotChatAreaIframe_xpath));
        testbase.logging.info("New Test - Call is completed");
    }

}

