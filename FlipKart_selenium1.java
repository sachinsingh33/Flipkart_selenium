package javaPackage;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FlipKart_selenium1 {

	public static void main(String[] args) throws InterruptedException {
		
		/*try {
			PrintWriter pw = new PrintWriter(new File("D:\\Software\\Screenshot"));
			StringBuilder sb = new StringBuilder();
			
			sb.append("Device Details");
			sb.append("Price");
			sb.append("Ratings");
			
			pw.write(sb.toString());
			pw.close();
			
			System.out.println("Finished");
		}
		catch(Exception e) {}*/

		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver_win32\\chromedriver.exe");//setting the property of Chrome driver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");

		
		
		driver.findElement(By.xpath("//button[@class ='_2KpZ6l _2doB4z']")).click();//will click on cancel button 

		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys("iphone mobiles");//send keys to the search input box

		driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();//click on search button

		//variable price stores the value of dropdown 
		WebElement price = driver.findElement(By.xpath("//body/div[@id='container']/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[4]/div[3]/select[1]"));
		
		//variable -as- will click on price low to high
		WebElement as = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div[1]/div/div/div[2]/div[3]"));

		//select class to handle the dropdown
		Select bm = new Select(price);
		bm.selectByIndex(8);
		as.click();

		List<WebElement> model = driver.findElements(By.className("_4rR01T"));//variable model will store the model name of all iphones on the page
		List<WebElement> ratings = driver.findElements(By.xpath("//span[@class='_2_R_DZ']"));//variable ratings will store the ratings  of all iphones on the page
		List<WebElement> cost = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));//variable cost will store the price of all iphones on the page
		int i = model.size();
		//System.out.println(i);
		int j = ratings.size();
		//System.out.println(j);
		int k = cost.size();
		//System.out.println(k);
		int a;
		
		System.out.println("Device Details , Price , Ratings");
		
		for(a=0;a<=i-1;a++) {
			
			try {
			System.out.println(model.get(a).getText() + " , " + cost.get(a).getText() +" , " +ratings.get(a).getText());
			}
			catch(StaleElementReferenceException e) {
				
				 model = driver.findElements(By.className("_4rR01T"));
				 ratings = driver.findElements(By.xpath("//span[@class='_2_R_DZ']"));
				 cost = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
				System.out.println(model.get(a).getText() + " , " + cost.get(a).getText() +" , " +ratings.get(a).getText());
			}
			}
			
		// List<WebElement> cost =
		// driver.findElements(By.xpath("//div[@class='_30jeq3_1_WHN1']"));

		
		driver.close();
		

	}

}
