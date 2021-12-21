package helpers;

import java.io.File;

public class FormatTextHelper {

    public static String getImageId(String string) {
        String firstReplace = string.replace("http://automationpractice.com/","");
        return firstReplace.replace("thickbox_default.jpg","");
    }
}
