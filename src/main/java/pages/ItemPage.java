package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemPage {
    private WebDriver driver;

    public ItemPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getName() {
        WebElement h2 = driver.findElement(By.tagName("h2"));
        return h2.getText();
    }

    public String getPrice() {
        WebElement h3 = driver.findElement(By.tagName("h3"));
        return h3.getText();
    }

    public String getDescription() {
        WebElement myTabContent = driver.findElement(By.id("myTabContent"));
        return myTabContent.findElement(By.tagName("p")).getText();
    }

    public String addToCart() {
        WebElement a = driver.findElement(By.xpath("//a[text()='Add to cart']"));
        a.click();
        String text = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return text;
    }
}
