package test.java;
import main.java.web_pages.ira_bot;
import org.testng.annotations.Test;

public class testscripts extends testbase {

    @Test(priority = 1)
    public void enterIraChatBot() throws InterruptedException {
        ira_bot ira_bot = new ira_bot();
        ira_bot.clickOnIraAvatar();
        ira_bot.verifyWelcomeText();

    }
    @Test(priority = 2)
    public void chatWithBot() throws InterruptedException {
        ira_bot ira_bot = new ira_bot();
        ira_bot.clickOnIraAvatar();
        ira_bot.verifyWelcomeText();
        ira_bot.readingBotResponses();
        ira_bot.resetChatContext();
    }
    @Test(priority = 3)
    public void downloadMotorpolicy() throws InterruptedException {
        ira_bot ira_bot = new ira_bot();
        ira_bot.clickOnIraAvatar();
        ira_bot.verifyWelcomeText();
        ira_bot.policyDownload("DownloadMotorPolicy");
        ira_bot.resetChatContext();
    }
    @Test(priority = 4)
    public void renewMotorpolicy() throws InterruptedException {
        ira_bot ira_bot = new ira_bot();
        ira_bot.clickOnIraAvatar();
        ira_bot.verifyWelcomeText();
        ira_bot.policyDownload("RenewMotorPolicy");
        Thread.sleep(2000);
        ira_bot.resetChatContext();
    }
    @Test(priority = 5)
    public void testBotFormFilling() throws InterruptedException {
        ira_bot ira_bot = new ira_bot();
        ira_bot.clickOnIraAvatar();
        ira_bot.verifyWelcomeText();
        ira_bot.testBot();
        Thread.sleep(2000);
        ira_bot.resetChatContext();
    }
    @Test(priority = 6)
    public void newTestGoogleCall() throws InterruptedException {
        ira_bot ira_bot = new ira_bot();
        ira_bot.clickOnIraAvatar();
        ira_bot.verifyWelcomeText();
        ira_bot.newTest();
        Thread.sleep(2000);
        ira_bot.resetChatContext();
    }

}
