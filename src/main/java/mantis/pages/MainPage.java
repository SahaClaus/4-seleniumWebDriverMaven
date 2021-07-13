package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    //определение локатора залогиненности
    @FindBy(css = "span.user-info")
    private WebElement userName;

    //определение локатора кнопки ViewIssue
    @FindBy(css = "a[href='/mantisbt/view_all_bug_page.php']")
    private WebElement viewIssuePageButton;

    //инициализация полей класса
    public MainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 2000);
        PageFactory.initElements(driver, this);
    }

    //метод для получения имени пользователя из вебэлемента
    public String getUserName() {
        return userName.getText();
    }
    //метод для перехода на страницу ViewIssue
    public void goToViewIssuePage() {
        viewIssuePageButton.click();
    }
}
