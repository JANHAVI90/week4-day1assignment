package Week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		Set<String> windowHandlesSet = driver.getWindowHandles();
		List<String> windowHandleList = new ArrayList<String>(windowHandlesSet);
		driver.switchTo().window(windowHandleList.get(1));
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//a[text()='12759']")).click();
		driver.switchTo().window(windowHandleList.get(0));
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> windowHandlesSet1 = driver.getWindowHandles();
		List<String> windowHandleList1 = new ArrayList<String>(windowHandlesSet1);
		driver.switchTo().window(windowHandleList1.get(1));
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']")).click();
		driver.switchTo().window(windowHandleList1.get(0));
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		System.out.println("Title of the Page:"+driver.getTitle());
		
		
		
		
		
		// TODO Auto-generated method stub

	}

}
