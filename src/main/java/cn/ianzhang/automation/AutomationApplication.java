package cn.ianzhang.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class AutomationApplication {

	public static void main(String[] args) {

		SpringApplication.run(AutomationApplication.class, args);

		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver");
		WebDriver driver = new ChromeDriver();
//        WebDriverWait wait = new WebDriverWait(driver);
		try {
			driver.get("https://cn.bing.com/");
			driver.findElement(By.name("q")).sendKeys("Bing" + Keys.ENTER);
			driver.findElement(By.xpath("//li[@class='b_pag']//li[2]")).click();
			List<WebElement> searchList = driver.findElements(By.xpath("//li[@class='b_algo']"));
			for(int i=0;i<searchList.size();i++){
				System.out.println(searchList.get(i).findElement(By.xpath("//li[@class='b_algo']/h2/a")).getText());
			}
//            WebElement firstResult = wait.until(presenceOfElementLocated(By.cssSelector("h3>div")));
//            System.out.println(firstResult.getAttribute("textContent"));
		} finally {
//            driver.quit();
		}
	}

}
