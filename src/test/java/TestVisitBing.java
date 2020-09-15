import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TestVisitBing {

    public String cutString(String link) {
        if (link.contains("https://")) {
            link = link.substring(8).split("/")[0];
        } else if (link.contains("http://")){
            link = link.substring(7).split("/")[0];
        } else {
            link = link.split("/")[0];
        }
        System.out.println("-------link-----------: " + link);
        return link;
    }

    @Test
    public void visitbing () {
        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://cn.bing.com/");
            driver.findElement(By.name("q")).sendKeys("Bing" + Keys.ENTER);
            driver.findElement(By.linkText("2")).click();
            List<WebElement> titles = driver.findElements(By.xpath("//li[@class='b_algo']//h2/a"));
            List<WebElement> links = driver.findElements(By.xpath("//li[@class='b_algo']//cite"));
            for (int i = 0; i < titles.size(); i++) {
                System.out.println("result: " + titles.get(i).getText() + " --> " + links.get(i).getText());
                cutString(links.get(i).getText());
            }
        } finally {
            driver.quit();
        }
    }
}
