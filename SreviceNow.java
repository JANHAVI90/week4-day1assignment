package Week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SreviceNow {

	
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://dev113545.service-now.com/");
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("w6hnF2FRhwLC");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		WebElement webEle1 = driver.findElement(By.id("filter"));
		webEle1.sendKeys("incident");
		webEle1.click();
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		WebElement webEle2 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(webEle2);
		driver.findElement(By.xpath("//button[text()='New']")).click();
		String incidentNum = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
		System.out.println("Incident Number"+incidentNum);
		driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']")).click();
		Set<String> windowHandlesSet = driver.getWindowHandles();
		List<String>windowHandlesList= new ArrayList<String>(windowHandlesSet);
		driver.switchTo().window(windowHandlesList.get(1));
		driver.findElement(By.xpath("//a[@class='glide_ref_item_link']")).click();
		driver.switchTo().window(windowHandlesList.get(0));
		driver.switchTo().frame(webEle2);
		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("Short Description");
		driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();
		WebElement selectWebElememt = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select drpdwn1 = new Select(selectWebElememt);
		drpdwn1.selectByValue("number");
		WebElement incidentSearchElement = driver.findElement(By.xpath("//input[@class='form-control']"));
		incidentSearchElement.sendKeys(incidentNum);
		incidentSearchElement.sendKeys(Keys.ENTER);
		WebElement ssWebElement = driver.findElement(By.xpath("//div[@class='vcr_controls']//span"));
		String rowNumber = ssWebElement.getText();
		System.out.println("Incident displayed after searching :" + rowNumber);
		if (rowNumber.contains("Showing rows 1 ")) {
			System.out.println("Incident created successfully");
		} else
			System.out.println("Incident not created");
		File src1 = driver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./snap/ServiceNow.png");
		FileUtils.copyFile(src1, dst);
		
	}

		
		
		
		
		
		
		
		// TODO Auto-generated method stub

	}


