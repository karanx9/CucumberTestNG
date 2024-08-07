package Steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Secondopinion {
	WebDriver driver;
	
	@Given("open the browser, enter the sparsh hospital url")
	public void open_the_browser_enter_the_sparsh_hospital_url() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.sparshhospital.com/book-an-appointment/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   
	}

	@Given("click the hospital dropdown")
	public void click_the_hospital_dropdown() {
		
		driver.findElement(By.xpath("(//a[@role=\"button\"])[3]")).click();
	   
	}

	@Given("select the hospital yashwantpur")
	public void select_the_hospital_yashwantpur() {
	    
		driver.findElement(By.xpath("(//a[@href=\"https://www.sparshhospital.com/hospitals/sparsh-hospital-yeswanthpur/\"])[1]")).click();
		
		
	}

	@When("click on secondopinion link")
	public void click_on_secondopinion_link() throws InterruptedException {
		Thread.sleep(5);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		
		jsExecutor.executeScript("arguments[0].click()", driver.findElement(By.xpath("(//a[@href='https://www.sparshhospital.com/second-opinion/'])[1]")));

	}

	@When("user enters the firstname lastname phoneno email")
	public void user_enters_the_firstname_lastname_phoneno_email() {
	    
		driver.findElement(By.cssSelector("input[id=\"secondopinion_first_name\"]")).sendKeys("Karan");
		driver.findElement(By.cssSelector("input[id=\"secondopinion_last_name\"]")).sendKeys("Soni");
		driver.findElement(By.cssSelector("input[id=\"secondopinion_phone\"]")).sendKeys("9403343224");
		driver.findElement(By.cssSelector("input[id=\"secondopinion_email\"]")).sendKeys("bussiness@gmail.com");
		
		
	}

	@When("upload the report")
	public void upload_the_report() {
		
		driver.findElement(By.id("secondopinion_reports")).sendKeys("C:\\Users\\Karan Soni\\Downloads\\Masai Doc-20240730T043746Z-001\\Masai Doc");
		
		
	}

	@When("enter the message")
	public void enter_the_message() {
		driver.findElement(By.id("secondopinion_message")).sendKeys("Just for testing purpose");

	
	}

	@Then("click on send button")
	public void click_on_send_button() {
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click()", driver.findElement(By.id("secondopinion_submit")));
        driver.findElement(By.cssSelector("button[id=\"secondopinion_submit\"]")).click();
			
	}

	@Then("validate the message")
	public void validate_the_message() {
		String Text = driver.findElement(By.xpath("//h1[@class='font-700 mb-4']")).getText();
		String textExpectedString = "Thank you";
		org.testng.Assert.assertEquals(Text, textExpectedString);
        driver.close();


	}
}
