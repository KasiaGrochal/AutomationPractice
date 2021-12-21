package pages;

import configuration.WebListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.internal.EventFiringMouse;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;


public abstract class BasePage {
    Logger logger = LoggerFactory.getLogger(BasePage.class);
    protected WebDriver driver;
    protected WebDriverWait webDriverwait;
    private EventFiringMouse eventFiringMouse;
    private WebListener webListener = new WebListener();


    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.webDriverwait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(System.getProperty("wait"))));
        PageFactory.initElements(driver, this);
    }


    public void mouseHover(WebElement webElement) {
        waitForWebElementToBeVisable(webElement);
        eventFiringMouse = new EventFiringMouse(driver, webListener);
        Locatable item = (Locatable) webElement;
        Coordinates coordinates = item.getCoordinates();
        eventFiringMouse.mouseMove(coordinates);
        logger.info("MouseHover on webelement: {}", webElement.getText());
    }

    public void mouseClick(WebElement webElement) {
        String webElementText = webElement.getText();
        eventFiringMouse = new EventFiringMouse(driver, webListener);
        Locatable item = (Locatable) webElement;
        Coordinates coordinates = item.getCoordinates();
        eventFiringMouse.click(coordinates);
        logger.info("MouseClick on webelement: {}", webElementText);
    }

    public void waitForWebElementToBeClickable(WebElement webElement) {
        logger.info("Start waiting for WebElement to be clickable- Timeout set to {} seconds", System.getProperty("wait"));
        webDriverwait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void waitForWebElementToBeVisable(WebElement webElement) {
        logger.info("Start waiting for WebElement to be visible- Timeout set to {} seconds", System.getProperty("wait"));
        webDriverwait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void clickOnButton(WebElement webElement) {
        String webElementText = webElement.getText();
        waitForWebElementToBeClickable(webElement);
        webElement.click();
        logger.info("Clicked on webelement: {}", webElementText);
    }

    public void sendKeysToObject(WebElement webElement, String text) {
        waitForWebElementToBeVisable(webElement);
        webElement.clear();
        webElement.sendKeys(text);
        logger.info("Typed text '{}' to webelement: {}", text, webElement.getAttribute("class"));
    }

    public String getTextFromObject(WebElement webElement) {
        waitForWebElementToBeVisable(webElement);
        String webElementText = webElement.getText();
        logger.info("Displayed text from webelement: {}", webElementText);
        return webElementText;
    }


}
