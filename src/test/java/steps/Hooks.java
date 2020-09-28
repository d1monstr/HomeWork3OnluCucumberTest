package steps;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.appline.frameworks.sberbank.managers.DriverManager;
import ru.appline.frameworks.sberbank.managers.InitManager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hooks {

    @Before
    public void beforeEach(){
        InitManager.initFramework();
    }


    @After
    public void afterEach() {
        byte[] screenShot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
        Allure.getLifecycle().addAttachment(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yy_hh:mm:ss")), "image/png", "png", screenShot);
        InitManager.quitFramework();
    }

}
