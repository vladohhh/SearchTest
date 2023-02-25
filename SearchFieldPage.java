package Lection15_SearchField;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchFieldPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public SearchFieldPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
    }

    public void navigateToLoginPage() {
        WebElement loginLink = driver.findElement(By.id("nav-link-login"));
        loginLink.click();
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4200/users/login"));
    }

    public void enterLoginCredentials(String username, String password) {
        WebElement userNameField = driver.findElement(By.id("defaultLoginFormUsername"));
        userNameField.sendKeys(username);

        WebElement passwordField = driver.findElement(By.id("defaultLoginFormPassword"));
        passwordField.sendKeys(password);

        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-in-button")));
        signInButton.click();
    }

    public void searchForUser(String searchText) {
        WebElement searchField = driver.findElement(By.id("search-bar"));
        searchField.sendKeys(searchText);

        WebElement searchIcon = driver.findElement(By.cssSelector("#navbarColor01 > form > i"));
        searchIcon.click();

        wait.until(ExpectedConditions.visibilityOf(searchField));
    }

    public void selectUser(String userName) {
        WebElement searchField = driver.findElement(By.id("search-bar"));
        searchField.sendKeys(userName);

        WebElement dropDownUser = driver.findElement(By.xpath("//*[text()='" + userName + "']"));
        dropDownUser.click();

        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4200/users/31"));
    }

    public void close() {
        driver.close();
    }
}
