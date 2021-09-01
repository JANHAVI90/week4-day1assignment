package Week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesExample {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get(" https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		WebElement topic = driver.findElement(By.xpath("//iframe[@id='frame1']"));
		driver.switchTo().frame(topic);
		driver.findElement(By.xpath("//b[@id='topic']/following::input")).sendKeys("Frames");
		WebElement chkBox = driver.findElement(By.xpath("//iframe[@id='frame3']"));
	    driver.switchTo().frame(chkBox);
	    driver.findElement(By.xpath("//input[@id='a']")).click();
	    driver.switchTo().defaultContent();
	    WebElement animals = driver.findElement(By.xpath("//iframe[@id='frame2']"));
	    driver.switchTo().frame(animals);
	    WebElement webEle1 = driver.findElement(By.xpath("//select[@id='animals']"));
	    Select drpDwn= new Select(webEle1);
	    drpDwn.selectByValue("avatar");
	}
	    
	    
		
		
		// TODO Auto-generated method stub

	}


