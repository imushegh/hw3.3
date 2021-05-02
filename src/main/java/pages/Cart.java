package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Cart {
    WebDriver driver;

    public Cart(WebDriver driver) {
        this.driver = driver;
    }

    public List<Hashtable<String, String>> getProducts() {
        List<Hashtable<String, String>> prodList = new ArrayList<Hashtable<String, String>>();
        List<WebElement> products = driver.findElements(By.className("success"));
        for(WebElement element : products) {
            Hashtable<String, String> prod = new Hashtable<String, String>();
            prod.put("title", element.findElements(By.tagName("td")).get(1).getText());
            prod.put("price", element.findElements(By.tagName("td")).get(2).getText());
            prodList.add(prod);
        }
        return prodList;
    }

    public int getTotal() {
        WebElement totalp = driver.findElement(By.id("totalp"));
        return Integer.parseInt(totalp.getText());
    }

    public Cart deleteProduct(int id) {
        List<WebElement> as = driver.findElements(By.xpath("//a[text()='Delete']"));
        as.get(id).click();
        return new Cart(driver);
    }
}
