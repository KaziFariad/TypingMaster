import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class TypingMaster {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            driver.get("https://10fastfingers.com/typing-test/english");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("row1")));
            WebElement line = driver.findElement(By.id("row1"));
            WebElement inputField = driver.findElement(By.id("inputfield"));
            
//            inputField.sendKeys(line.getAttribute("textContent"));
//            inputField.sendKeys(" ");

            String lines = line.getAttribute("textContent");
            String[] words = lines.split(" ");
            long startTime = System.currentTimeMillis();

                for (String word : words) {
                    // to stop before the timer ends
                    if((System.currentTimeMillis()-startTime)>60000){
                        break;
                    }

                    // to enter words character by character with a small delay
                    for (int i = 0; i < word.length(); i++) {
                        char c = word.charAt(i);
                        String s = String.valueOf(c);
                        inputField.sendKeys(s);
                        Thread.sleep(40);
                    }
                    // to enter space after the last word
                    inputField.sendKeys(" ");
                }
            }

        catch(Exception e){
            System.out.println("Caught exception: " + e.getMessage());
        }
    }

}
