import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageTest extends BaseTests {

    @Test
    public void testCategoryTest() {
        homePage.changeCategory("Laptop");
        assertEquals(homePage.getItems().size(), 6);
    }

    @Test
    public void testselectItemPage() {
        assertEquals(homePage.selectItem("Samsung galaxy s6").getName(), "Samsung galaxy s6");
    }
}
