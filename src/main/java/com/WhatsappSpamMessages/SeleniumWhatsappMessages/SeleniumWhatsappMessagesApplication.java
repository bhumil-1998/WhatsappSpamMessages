package com.WhatsappSpamMessages.SeleniumWhatsappMessages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SeleniumWhatsappMessagesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeleniumWhatsappMessagesApplication.class, args);
		seleniumTest();
	}

	public static void seleniumTest() {
		System.setProperty("webdriver.chrome.driver", "/home/bhumil/Desktop/Spam-WhatsApp-Contacts/chromedriver");

		//Initiating your chromedriver
		WebDriver driver=new ChromeDriver();

	
		//maximize window
		driver.manage().window().maximize();

		//open browser with desried URL
		driver.get("https://web.whatsapp.com");
		WebDriverWait wait = new WebDriverWait(driver , 600);
		
		String target = "Akashi";
		
		String msg = "System Generated Message";
		
		// wait until the whatsapp has the desired element 
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[contains(@title,'" + target + "')]")));
		
		// select the group name from the list of contacts and open it
		driver.findElement(By.xpath("//span[contains(@title,'" + target + "')]")).click();
		
		WebElement textBox = driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div[2]/div/div[2]"));
		
		for (int i = 0 ; i < 1 ; i++) {
			textBox.sendKeys(msg + Keys.ENTER);			
		}

		driver.close();
	}
}
