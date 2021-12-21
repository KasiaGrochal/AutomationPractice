package pages.commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class ProductBoxPage extends BasePage {
    Logger logger = LoggerFactory.getLogger(ProductBoxPage.class);

    public ProductBoxPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".quick-view")
    private WebElement quickViewButton;

    @FindBy(css = ".product_img_link")
    private WebElement productImage;

    @FindBy(css = "[id^='fancybox-frame']")
    private WebElement popUpIframe;

    public ProductBoxPage mouseHoverProductImage() {
        mouseHover(productImage);
        return this;
    }

    public ProductBoxPage mouseClickOnQuickViewButton() {
        mouseClick(quickViewButton);
        return this;
    }

    public ProductDetailsPopUpPage switchToProductDetailsPopUp() {
        webDriverwait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(popUpIframe));
        logger.info("Switched to Product Details PopUp");
        return new ProductDetailsPopUpPage(driver);
    }
}
