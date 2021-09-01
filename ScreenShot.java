package Week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShot {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		WebElement frame1= driver.findElement(By.xpath("//iframe[@src='default.html']"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//button[@id='Click']")).click();
		File src1 = driver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./snap/ServiceNow.png");
		FileUtils.copyFile(src1, dst);
		driver.switchTo().defaultContent();
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@src='page.html']"));
		driver.switchTo().frame(frame2);
		WebElement frame3 = driver.findElement(By.xpath("//iframe[@id='frame2']"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("//button[@id='Click1']")).click();
		driver.switchTo().defaultContent();
		List<WebElement> sizeFrame = driver.findElements(By.tagName("iframe"));
		System.out.println("The total no.of frame:"+sizeFrame.size());
		
		
		
		
		// TODO Auto-generated method stub

	}

}
