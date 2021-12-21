package pages.commons;

import helpers.FormatTextHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

import java.util.List;

public class ProductDetailsPopUpPage extends BasePage {

    Logger logger = LoggerFactory.getLogger(ProductDetailsPopUpPage.class);

    public ProductDetailsPopUpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#bigpic")
    private WebElement bigPreviewPicture;

    @FindBy(css = "#thumbs_list_frame>li>a")
    private List<WebElement> listOfSmallPictures;

    public List<WebElement> getListOfSmallPictures() {
        return listOfSmallPictures;
    }

    public String getBigPictureSrc() {
        String src = bigPreviewPicture.getAttribute("src");
        logger.info("Big picture attribute src: {}", src);
        return src;
    }

    public String getPictureHref(WebElement picture) {
        String href = FormatTextHelper.getImageId(picture.getAttribute("href"));
        logger.info("Picture href: {}", href);
        return href;
    }

    public ProductDetailsPopUpPage moveMouseTo(WebElement webElement) {
        mouseHover(webElement);
        return this;
    }


}
