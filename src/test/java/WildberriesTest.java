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
import org.testng.Assert;

public class WildberriesTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testAddToCart() {
        driver.get("https://www.wildberries.ru/");


        WebElement product1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[2]/div/div[2]/div/article[3]/div/div[3]/p[3]/a")));
        product1.click();


        WebElement product2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[2]/div/div[2]/div/article[4]/div/div[3]/p[3]/a")));
        product2.click();


        WebElement product3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[2]/div/div[2]/div/article[5]/div/div[3]/p[3]/a")));
        product3.click();
    }

    @Test(dependsOnMethods = "testAddToCart")
    public void testGoToCart() {
        // Переход в корзину
        WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"basketContent\"]/div[3]/a")));
        cartButton.click();

        WebElement product1Title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[4]/div/div[1]/form/div[1]/div[1]/div[2]/div/div[2]/div/div/div[1]/div/div[1]/div/a/span[1]")));
        String product1Name = product1Title.getText();
        System.out.println("Название товара 1: " + product1Name);

        WebElement product2Title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[4]/div/div[1]/form/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/a/span[1]")));
        String product2Name = product2Title.getText();
        System.out.println("Название товара 2: " + product2Name);

        WebElement product3Title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[4]/div/div[1]/form/div[1]/div[1]/div[2]/div/div[2]/div/div/div[3]/div/div[1]/div/a/span[1]")));
        String product3Name = product3Title.getText();
        System.out.println("Название товара 3: " + product3Name);
    }

   // @AfterTest
    //public void tearDown() {
      //  driver.quit();
    //}
}
