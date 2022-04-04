package main.java.utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import test.java.testbase;
import java.util.List;
import java.util.Set;

public class element_locators {
    public WebElement getElementLocator(String locatorType, String locatorValue) {
        switch (locatorType) {
            case "ID":
                return testbase.driver.findElement(By.id(locatorValue));
            case "Xpath":
                return testbase.driver.findElement(By.xpath(locatorValue));
            case "CSS":
                return testbase.driver.findElement(By.cssSelector(locatorValue));
            case "TagName":
                return testbase.driver.findElement(By.tagName(locatorValue));
            case "ClassName":
                return testbase.driver.findElement(By.className(locatorValue));
            case "Name":
                return testbase.driver.findElement(By.name(locatorValue));
            case "LinkText":
                return testbase.driver.findElement(By.linkText(locatorValue));
            case "PartialLinkText":
                return testbase.driver.findElement(By.partialLinkText(locatorValue));
            default:
                return null;
        }

    }
    public List<WebElement> getElementLocatorsList(String locatorType, String locatorValue ){
        switch (locatorType) {
            case "ID":
                return testbase.driver.findElements(By.id(locatorValue));
            case "Xpath":
                return testbase.driver.findElements(By.xpath(locatorValue));
            case "CSS":
                return testbase.driver.findElements(By.cssSelector(locatorValue));
            case "iFrame":
                return testbase.driver.findElements(By.tagName(locatorValue));
            default:
                return null;
        }
    }
    public Set<String> webHandles() {
        return testbase.driver.getWindowHandles();

    }
    public void selectDropDownItem(WebElement dropDownLocator, String dropDownItemType, String dropDownItemValue) {
        Select s = new Select(dropDownLocator);
        switch (dropDownItemType) {
            case "Value":
                s.selectByValue(dropDownItemValue);
                break;
            case "VisibleText":
                s.selectByVisibleText(dropDownItemValue);
                break;

        }
    }
}
