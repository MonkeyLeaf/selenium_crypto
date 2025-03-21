package TestJava.src;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static Properties loadConfig(String filePath) {
        Properties properties = new Properties();

        try (FileInputStream input = new FileInputStream(filePath)) {
            // Tải nội dung file vào Properties
            properties.load(input);
            System.out.println("Đã tải file cấu hình: " + filePath);
        } catch (IOException e) {
            System.err.println("Không thể đọc file config.properties: " + e.getMessage());
            // Trả về Properties rỗng nếu có lỗi
            return new Properties();
        }

        return properties;
    }

    public static void main(String[] args){
        String configFilePath = "config.properties";

        // Gọi hàm loadConfig để đọc file
        Properties config = loadConfig(configFilePath);

        String profilePath = config.getProperty("cnf.profilePath");
        String profileName = config.getProperty("cnf.profileName");

        WebDriverManager.chromedriver().driverVersion("131.0.6778.86").clearDriverCache().setup();
        ChromeDriver driver = getChromeDriver(profilePath, profileName);
        driver.quit();
    }

    @NotNull
    private static ChromeDriver getChromeDriver(String profilePath, String profileName) {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--remote-debugging-pipe");

//        options.addArguments("--no-sandbox"); // Bỏ qua sandbox để tránh hạn chế
//        options.addArguments("--disable-dev-shm-usage"); // Giảm thiểu việc sử dụng shared memory
//        options.addArguments("--disable-gpu"); // Tắt GPU (trong môi trường không có đồ họa)
//        options.addArguments("--headless"); // Chạy trong chế độ không giao diện (nếu cần)


        options.addArguments("user-data-dir=" + profilePath);
        options.addArguments("profile-directory=" + profileName);

        ChromeDriver driver=new ChromeDriver(options);

        driver.get("https://demo.guru99.com/");
//        driver.get("https://demo.guru99.com/");
//        WebElement element=driver.findElement(By.xpath("//input[@name='emailid']"));
//        element.sendKeys("abc@gmail.com");
//
//        WebElement button=driver.findElement(By.xpath("//input[@name='btnLogin']"));
//        button.click();

        driver.get("https://demo.guru99.com/");
        return driver;
    }
}