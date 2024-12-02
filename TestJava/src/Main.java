import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {
    public static void main(String[] args){
        String profilePath = "C:\\Users\\CaoTuan\\AppData\\Local\\Google\\Chrome\\User Data";
        String profileNameClone = "Profile 1";
        String profileNameMain = "Default";

        WebDriverManager.chromedriver().driverVersion("131.0.6778.86").clearDriverCache().setup();
        ChromeDriver driver = getChromeDriver(profilePath, profileNameClone);
        driver.quit();

//        driver.get("https://demo.guru99.com/");
//        WebElement element=driver.findElement(By.xpath("//input[@name='emailid']"));
//        element.sendKeys("abc@gmail.com");
//
//        WebElement button=driver.findElement(By.xpath("//input[@name='btnLogin']"));
//        button.click();
    }

    @NotNull
    private static ChromeDriver getChromeDriver(String profilePath, String profileNameClone) {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--no-sandbox"); // Bỏ qua sandbox để tránh hạn chế
        options.addArguments("--disable-dev-shm-usage"); // Giảm thiểu việc sử dụng shared memory
        options.addArguments("--disable-gpu"); // Tắt GPU (trong môi trường không có đồ họa)
        options.addArguments("--headless"); // Chạy trong chế độ không giao diện (nếu cần)


        options.addArguments("user-data-dir=" + profilePath);
        options.addArguments("profile-directory=" + profileNameClone);

        ChromeDriver driver=new ChromeDriver(options);

        driver.get("https://demo.guru99.com/");
        return driver;
    }
}