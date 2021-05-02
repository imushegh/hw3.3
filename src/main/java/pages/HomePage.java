package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void changeCategory(String category) {
        new WebDriverWait(driver, 5000).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        if(category.equals("Laptop")) {
            driver.findElement(By.xpath("/html/body/div[5]/div/div[1]/div/a[3]")).click();
        }
    }

    public ItemPage selectItem(String name) {
        new WebDriverWait(driver, 5000).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        clickLink(name);
        return new ItemPage(driver);
    }

    public List<String> getItems() {
        new WebDriverWait(driver, 5000).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        List<WebElement> items = driver.findElements(By.className("hrefch"));
        List<String> itemNames = new ArrayList<String>();
        for(WebElement item : items) {
            itemNames.add(item.getText());
        }
        System.out.println(itemNames);
        return itemNames;
    }

    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }
}
