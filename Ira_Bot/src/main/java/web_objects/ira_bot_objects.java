package main.java.web_objects;

public interface ira_bot_objects {
    String iraAvatar_xpath = "//a[@class='avm-bot-avatar']";
    String welcomeText_xpath = "//div[@class='welcome-message']";
    String getStartedText_xpath = "//a[text()='Get Started']";
    String iraBotChatAreaIframe_xpath = "//iframe[@title='Chat area']";
    String menuButton_xpath = "//button[@aria-label='Toggle Menu']";
    String iraCancelButton_xpath = "//div[@aria-label='Test agent - IRA']";
    String menuCloseToggle_xpath = "//button[@aria-label='Close Menu']";
    String menuStartOver_xpath = "//a[text()='Start Over']";
    String downloadMotorPolicy_xpath = "//a[text()='Download Motor Policy']";
    String downloadHealthPolicy_xpath = "//a[text()='Download Health Policy']";
    String renewMotorPolicy_xpath = "//a[text()='Renew Motor Policy']";
    String buyPolicy_xpath = "//a[text()='Buy Policy']";
    String othersPolicyInfo_xpath = "//a[text()='Others']";
    String policyDownloadForAll_xpath = "//a[text()='Download']";
    String renewYesButton_xpath = "//a[text()='Yes']";
    String renewNoButton_xpath = "//a[text()='No']";
    String renewConfirmedText_xpath = "//h1[text()='Test agent - IRA']/following::p[contains(text(),'Your policy will be renewed')]";
    String menuTestBot_xpath = "//a[text()='Test Bot']";
    String menuHelp_xpath = "//a[text()='Help']";
    String menuContactUs_xpath = "//a[text()='Contact us']";
    String enterQueryText_xpath = "//textarea[@id='queryTextbox']";
    String sendButton_xpath = "//button[@aria-label= 'Send']";
    String responseChat_xpath = "//h1[text()='Test agent - IRA']/following::p[2]";
    String testGoogle_xpath = "//a[text()='Google']";
    String testGoogleClose_xpath = "//button[@aria-label='close webview popup']";
    String testCall_xpath = "//a[text()='Call']";
    String testBotFullName_xpath = "//input[@type='text']";
    String testBotAddress_xpath = "//textarea[@class='textbox avm_accessible_txt_box_helper']";
    String testBotMale_xpath = "//span[@aria-label='Male']";
    String testBotFemale_xpath = "//span[@aria-label='Female']";
    String testBotSelection_xpath = "//input[contains(@aria-label,'selection')]";
    String testBotFrequent_xpath = "//ul[@class='list picklist']/li[1]";
    String testBotRarely_xpath = "//ul[@class='list picklist']/li[2]";
    String testBotRating_5_xpath = "//label[contains(@aria-label, 'rating')][1]";
    String testBotRating_4_xpath = "//label[contains(@aria-label, 'rating')][2]";
    String testBotRating_3_xpath = "//label[contains(@aria-label, 'rating')][3]";
    String testBotRating_2_xpath = "//label[contains(@aria-label, 'rating')][4]";
    String testBotRating_1_xpath = "//label[contains(@aria-label, 'rating')][5]";
    String testBotSubmit_xpath = "//button[@aria-label='Submit']";
    String testBotThumbsUp_xpath = "//button[@class='thumbs-up']";
    String testBotThumbsDown_xpath = "//button[@class='thumbs-down']";
    String testBotSubmitSuccess_xpath = "//button[contains(@class, 'submit success')]";


}
