package mantis.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import mantis.pages.MantisSite;
import mantis.pages.ViewIssuesPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MantisTests {
    private WebDriver driver;
    private MantisSite mantisSite;

    @BeforeEach
    public void setUp() {
        //определение пути до драйвера
        WebDriverManager.chromedriver().setup();
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        //ссылка на страницу входа
        driver.get("https://academ-it.ru/mantisbt/login_page.php");
        //окно на полный экран
        driver.manage().window().maximize();

    }


    @Test
    public void loginUrlTest() {
        //переходим на страницу
        String currentUrl = driver.getCurrentUrl();
        //сравниваем введеный url с ожидаемым
        Assertions.assertEquals("https://academ-it.ru/mantisbt/login_page.php", currentUrl);
    }

    @Test
    public void loginTitleTest() {
        String currentTitle = driver.getTitle();

        //сравнивем title открывшейся страницы с ожидаемым
        Assertions.assertEquals("MantisBT", currentTitle);
    }

    @Test
    public void successfulLoginTest() throws InterruptedException {
        mantisSite = new MantisSite(driver);
        mantisSite.login("admin", "admin20");

        String currentUserName = mantisSite.getMainPage().getUserName();
        //сравниваем введенный логин с ожидаемым
        Assertions.assertEquals("admin", currentUserName);
        Thread.sleep(5000);
    }

    @Test
    public void numberIssuesTest() throws InterruptedException {
        mantisSite = new MantisSite(driver);
        mantisSite.login("admin", "admin20");
        mantisSite.getMainPage().goToViewIssuePage();

        int curIssueNumber = mantisSite.getViewIssuesPage().getIssuesNumber();
        //сравниваем полученный размер списка с ожидаемым
        Assertions.assertEquals(50, curIssueNumber);
        Thread.sleep(5000);



   }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
