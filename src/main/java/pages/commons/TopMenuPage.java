package pages.commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;


public class TopMenuPage extends BasePage {

    public TopMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".sf-menu>li:nth-of-type(1)>a")
    private WebElement categoryWomen;

    @FindBy(css = ".submenu-container>li:nth-of-type(1)>ul>li:nth-child(2)>a")
    private WebElement subCategoryBlouses;


    public TopMenuPage clickOnBlouses() {
        clickOnButton(subCategoryBlouses);
        return this;
    }

    public TopMenuPage moveHoverToWomen() {
        mouseHover(categoryWomen);
        return this;
    }


}
