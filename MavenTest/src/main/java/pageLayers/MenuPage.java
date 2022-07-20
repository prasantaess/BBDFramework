package pageLayers;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MenuPage {
	
	double PL;
	private WebDriver driver;
	private By MenuBus= By.xpath("//a[text()=' BUSES ']");
	private By TrainM= By.xpath("//li[@class='menu-list header-icon-menu']//strong[text()='TRAINS']");
	private By priceList=By.xpath("//div[@class='inventory_item_price']");
	private By addtocurt=By.xpath("//*[contains(text(),'"+PL+"')]/following-sibling::button");
	public MenuPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public List<String> MenuList() {
		List<WebElement> ls= driver.findElements(By.xpath("//nav[@class='nav-bar hidden-xs text-right']//ul[@class='menu']"));
		List<String> Menu= new ArrayList<String>();
		int ListSize = ls.size();
		System.out.println(ListSize);
		for(WebElement e: ls) {
			String X= e.getText();
			Menu.add(X);
			//System.out.println(X.toString());
		}
		return Menu;
		
	}
	
	public void setdriver(String arg1) throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\paull\\eclipse-workspace\\MavenTest\\chromedriver.exe");
	   // WebDriver driver= new ChromeDriver();
		
		// driver.manage().deleteAllCookies(); driver.manage().window().maximize();
		 //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		 driver.get(arg1);
		 
	    System.out.println(arg1);
	    System.out.println("Launching The URL");
	    Thread.sleep(6000);
	}
	public void priceList() throws InterruptedException {
		
		List<WebElement> Pricelist= driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		int size= Pricelist.size();
		System.out.println(size);
		
		PL= Pricelist.stream().mapToDouble(e->Double.parseDouble(e.getText().trim().replace("$", " "))).max().getAsDouble();
		System.out.println(PL);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[normalize-space()='$"+PL+"')]/following-sibling::button")).click();
		Thread.sleep(5000);
		System.out.println("Click on the Add button");
		
		
	}
	
	

}
