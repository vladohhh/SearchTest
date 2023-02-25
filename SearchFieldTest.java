package Lection15_SearchField;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchFieldTest {
    public static final String PASSWORD = "11ec634f";
    public static final String USERNAME = "vpetkov@abv.bg";
    private WebDriver driver;
    private SearchFieldPage searchFieldPage;

    public SearchFieldTest() {
    }

    @BeforeSuite
    protected final void setupTestSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    protected final void setUpTest() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20L));
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
        this.searchFieldPage = new SearchFieldPage(driver);
    }

    @AfterMethod
    protected final void tearDown() {
        this.searchFieldPage.close();
    }

    @Test
    public void testSearchField() {
        this.driver.get("http://training.skillo-bg.com:4200/posts/all");

        searchFieldPage.navigateToLoginPage();
        searchFieldPage.enterLoginCredentials(USERNAME, PASSWORD);

        searchFieldPage.searchForUser("TestUserUserUserUser");
        searchFieldPage.selectUser("TestUserUserUserUser");
    }
}
