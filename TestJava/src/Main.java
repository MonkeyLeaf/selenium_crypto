import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {
    public static void main(String[] args){
        String profilePath = "C:\\Users\\CaoTuan\\AppData\\Local\\Google\\Chrome\\User Data";
        String profileNameClone = "Profile 1";
        String profileNameMain = "Default";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + profilePath);
        options.addArguments("profile-directory=" + profileNameMain);

        ChromeDriver driver=new ChromeDriver(options);

        driver.get("https://demo.guru99.com/");
        driver.quit();

//        driver.get("https://demo.guru99.com/");
//        WebElement element=driver.findElement(By.xpath("//input[@name='emailid']"));
//        element.sendKeys("abc@gmail.com");
//
//        WebElement button=driver.findElement(By.xpath("//input[@name='btnLogin']"));
//        button.click();
    }
}