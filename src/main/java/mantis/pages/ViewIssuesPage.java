package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class ViewIssuesPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    //определяем локатор элемента
    @FindBy(css = "td.column-id")
    private List<WebElement> issuesNumber;

    //инициализация полей класса
    public ViewIssuesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 500);
        PageFactory.initElements(driver, this);
    }
    //метод для вычисления размера списка
    public int getIssuesNumber() {
        return issuesNumber.size();
    }
}
