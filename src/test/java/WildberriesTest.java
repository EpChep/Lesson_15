import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WildberriesTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Инициализация ожидания
    }

    @Test
    public void testAddToCart() {
        driver.get("https://www.wildberries.ru/");

        // Явное ожидание загрузки элемента
        WebElement product1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[2]/div/div[2]/div/article[3]/div/div[3]/p[3]/a")));
        product1.click();

        // Выбор товара 2
        WebElement product2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[2]/div/div[2]/div/article[4]/div/div[3]/p[3]/a")));
        product2.click();

        // Выбор товара 3
        WebElement product3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[2]/div/div[2]/div/article[5]/div/div[3]/p[3]/a")));
        product3.click();
    }

    @Test(dependsOnMethods = "testAddToCart")
    public void testGoToCart() {
        // Переход в корзину
        WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"basketContent\"]/div[3]/a")));
        cartButton.click();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
