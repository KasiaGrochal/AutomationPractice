import model.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.WebElement;
import pages.commons.TopMenuPage;
import pages.commons.ProductBoxPage;
import pages.commons.ProductDetailsPopUpPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@Execution(ExecutionMode.CONCURRENT)
public class ProductImagesTest extends TestBase {


    @Test
    @Tag("productImages")
    @Tag("regression")
    void validateIfBigPictureDisplaysProperImage(){
        TopMenuPage topMenuPage = new TopMenuPage(webdriver);
        ProductBoxPage productBox = new ProductBoxPage(webdriver);
        ProductDetailsPopUpPage productDetailsPage = new ProductDetailsPopUpPage(webdriver);

        topMenuPage.
                moveMouseToWomenCategory().
                clickOnBlouses();
        productBox.
                moveMouseToProductImage().
                mouseClickOnQuickViewButton().
                switchToProductDetailsPopUp();

        for (WebElement picture: productDetailsPage.getListOfSmallPictures()){
            productDetailsPage.
                    moveMouseTo(picture);
            assertThat(productDetailsPage.
                    getBigPictureSrc(),containsString(productDetailsPage.getPictureHref(picture)));
        }
    }
}
