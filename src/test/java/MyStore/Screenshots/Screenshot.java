package MyStore.Screenshots;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.PageSnapshot;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Capturing a screenshot and saving it to the provided path steps:
 * 1. Convert web driver object to TakeScreenshot
 * 2. Call getScreenshotAs method to create image file
 * 3. Create a Path object from the provided file path
 * 3. Move image file to new destination
 * 4. Copy file at destination
 */

public class Screenshot {

    public static void takeVisibleSegmentScreenshot(WebDriver webdriver, String screenshotPath, String fileName) {

        File screenshotFile =((TakesScreenshot)webdriver).getScreenshotAs(OutputType.FILE);
        Path destinationPath = Paths.get(screenshotPath, fileName);

        try {
            Files.move(screenshotFile.toPath(), destinationPath);
        } catch (IOException e) {
            System.err.println("Error occurred while saving the screenshot: " + e.getMessage());
        }
    }

    public static void takeFullPageScreenshot(WebDriver webdriver, String screenshotPath, String fileName) {
        PageSnapshot takeScr = Shutterbug.shootPage(webdriver, Capture.FULL_SCROLL);
        takeScr.save(screenshotPath + "\\" + fileName);
    }
}
