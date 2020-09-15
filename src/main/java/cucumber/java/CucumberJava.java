package cucumber.java;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class CucumberJava {
    WebDriver driver = null;

    @Given("^I have open the browser$")
    public void openBrowser() {
        driver = new ChromeDriver();
    }

    @When("^I open Templates Jinshuju website$")
    public void goToFacebook() {
        driver.navigate().to("https://templates.jinshuju.net/detail/Dv9JPD");
    }

    @Then("^Other choice option name$")
    public void otherChoiceOptionName() {
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//span[@class='label-item']"));
        if(driver.findElement(By.xpath("//span[@class='label-item']")).isEnabled()) {
            driver.findElement(By.xpath("//span[contains(text(),'连续生产/开工类企事业单位 ')]")).click();
            TakesScreenshot scrShot = ((TakesScreenshot) driver);
            File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(SrcFile, new File("./src/main/resources/srceenshot/firstpage.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Step 1 Pass");
        } else {
            System.out.println("Step 1 Fail");
        }
        driver.switchTo().defaultContent();
    }

    @Then("^Next page$")
    public void nextPage() {
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//div[@class='published-form__footer ']//button[@type='button']")).click();
        driver.switchTo().defaultContent();
//        driver.switchTo().frame(0);
//        driver.findElement(By.xpath("//span[@class='label-item']"));
//        if(driver.findElement(By.xpath("//span[@class='label-item']")).isEnabled()) {
//            driver.findElement(By.xpath("//div[@class='published-form__footer ']//button[@type='button']")).click();
//            System.out.println("Next Page Pass");
//        } else {
//            System.out.println("Next Page Fail");
//        }
    }

    @Then("^Login button should exits$")
    public void loginButton() {
        if(driver.findElement(By.id("u_0_b")).isEnabled()) {
            System.out.println("Test 1 Pass");
        } else {
            System.out.println("Test 1 Fail");
        }
        driver.close();
    }
}
