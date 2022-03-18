import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;

public class LoginClass {

    public void makeLogin() {

        System.setProperty("webdriver.gecko.driver","C:\\selenium\\webdriver\\firefox\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();                    //initialise the WebDriver

        driver.get("https://bitq.it/v2/login"); //define the url

        String pageTitle = driver.getTitle();		//get the title of the webpage
        System.out.println("The title of this page is ===> " +pageTitle);
        Assert.assertEquals("BitQ", pageTitle);	//verify the title of the webpage

        driver.findElement(By.name("username")).clear();//clear the input field before entering any value
        driver.findElement(By.name("username")).sendKeys("prestitaliadmin");//enter the value of username
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("prestitaliadmin");//enter the value of password
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        buttons.get(1).click();//click Login button
        System.out.println("Successfully logged in");

        driver.get("https://bitq.it/v2/showcase/prestigioitalia?pp=9312");
        driver.quit();
    }
}
