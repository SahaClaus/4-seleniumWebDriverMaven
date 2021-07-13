package mantis.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    //поиск элемента поле ввода на странице
    @FindBy(css = "#username")
    private WebElement loginField;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 500);
        PageFactory.initElements(driver, this);
    }

    //Метод ввода логина
    public void login(String login) {
        //переход на страницу ввода логина
        driver.get("https://academ-it.ru/mantisbt/login_page.php");
        //ввод логина
        loginField.sendKeys(login);
        //нажатие клавиши Enter
        loginField.sendKeys(Keys.ENTER);
    }
}
