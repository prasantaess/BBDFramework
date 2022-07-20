package pageLayers;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.factory.DriverFactory;
import com.qa.util.ElementUtil;

public class CoWinPage {
	
	private WebDriver driver;
	private WebDriverWait wait_element;
	private ElementUtil Util= new ElementUtil(DriverFactory.getDriver());
	private By State= By.xpath("//mat-select[@id='mat-select-4']");
	private By District= By.xpath("//mat-select[@id='mat-select-6']");
	private By StateList= By.xpath("//div[@id='mat-select-4-panel']/mat-option");
	private By DistrictList= By.xpath("//div[@id='mat-select-6-panel']/mat-option");
	private By Search= By.xpath("//button[text()='Search']");
	private By LinkLogin= By.xpath("//div[@class='mat-tab-label-content']//label[text()='By District']");
	private By tableList= By.xpath("//div[@class='mat-main-field center-main-field']/div/div/div");
	private By DashboardCount= By.xpath("//*[@id=\"skip_to_main\"]/app-new-main-dashboard/div/div[1]/div/div/div/div/div");
	// for SVG Graph
	private By SvgGraph =By.xpath("//*[local-name()='canvas' and @id='realtimemonth']");
	private By btnByDose = By.xpath("//button[text()=' By Doses ']");
	private By last30Days = By.xpath("//*[@id=\"skip_to_main\"]/app-new-main-dashboard/div/section/div/div[2]/section/div/div[2]/div/div[2]/ul/li[2]/button");
	
	// for Google 
	
	private By SvgGraphG = By.xpath("//*[local-name()='svg']//*[name()='g']/*[name()='rect']");
	private By GoogleSearch = By.xpath("//*[@name='q']");
	private By GoogleSearchbtn = By.xpath("");
	private By GoogleSearchSVGToolTip = By.xpath("//div[@class='ahjcie PZPZlf']/div[@class='ExnoTd']");
	
	
	JavascriptExecutor js= (JavascriptExecutor)driver;
	public CoWinPage(WebDriver driver) {
		//The this keyword refers to the current object in a method or constructor
		this.driver=driver;
	}
	
	public String getLoginpageTitle() {
		return driver.getTitle();
	}
	
	public String getLoginpageURL() {
		return driver.getCurrentUrl();
		
	}
	
	public void ScrolIntoViewM() throws InterruptedException {
		Thread.sleep(1000);
		//driver.manage().window().setSize(new Dimension(1440, 900));
		WebDriverWait wait_element = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement LinkVerify= wait_element.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='mat-tab-label-content']//label[text()='By District']")));
		//WebElement LinkVerify= driver.findElement(LinkLogin);
		System.out.println(LinkVerify);
		JavascriptExecutor js1= (JavascriptExecutor)driver;
		js1.executeScript("arguments[0].scrollIntoView();", LinkVerify);
		Thread.sleep(2000);
	}
	
	public void SelectState() throws InterruptedException {
		
		WebElement State1=driver.findElement(State);
		JavascriptExecutor js= (JavascriptExecutor)driver;
		//js.executeScript("arguments[0].scrollIntoView(true);", State1);
		Thread.sleep(1000);
		js.executeScript("arguments[0].click()", State1);
		Thread.sleep(2000);
		System.out.println("Click on the State DD");
		
		
		//Print all the Element
		
		List<WebElement> DL= driver.findElements(StateList);
		List<String> LDL = new ArrayList<String>();
		int ListSizeState= DL.size();
		System.out.println(ListSizeState);
		/*for(WebElement e:DL) {
			String Value= e.getText();
			LDL.add(Value);
			System.out.println(LDL);
		}*/
		for(int i=0;i<ListSizeState;i++) {
			System.out.println(DL.get(i).getText());
			if(DL.get(i).getText().contains("West Bengal")) {
				System.out.println(DL.get(i).getText());
				WebElement Click= DL.get(i);
				js.executeScript("arguments[0].click()",Click);
				System.out.println("Found the Value...");
				Thread.sleep(2000);
				break;
			}
		}
	}
		public void SelectDistrict() throws InterruptedException {
			WebElement Dist1=driver.findElement(District);
			JavascriptExecutor js= (JavascriptExecutor)driver;
			//js.executeScript("arguments[0].scrollIntoView(true);",Dist1 );
			Thread.sleep(2000);
			js.executeScript("arguments[0].click()", Dist1);
			Thread.sleep(2000);
			System.out.println("Click on the District DD");
			//Print all the Element
			
			List<WebElement> DDL= driver.findElements(DistrictList);
			List<String> DLDL = new ArrayList<String>();
			int ListSizeDist= DDL.size();
			System.out.println(ListSizeDist);
			/*for(WebElement e:DDL) {
				String Value= e.getText();
				DLDL.add(Value);
				System.out.println(DLDL);
			}*/
			for(int i=0;i<ListSizeDist;i++) {
				System.out.println(DDL.get(i).getText());
				if(DDL.get(i).getText().contains("West Bardhaman")) {
					WebElement Click= DDL.get(i);
					js.executeScript("arguments[0].click()",Click);
					System.out.println("Found the Value...");
					Thread.sleep(2000);
					break;
				}
			}
	
	}
		
  public void ClickSearch() throws InterruptedException {
	 // js.executeScript("arguments[0].scrollIntoView(true);",Search );
	  Thread.sleep(2000);
	  WebElement ClickSearch=driver.findElement(Search);
	  JavascriptExecutor js2= (JavascriptExecutor)driver;
	  js2.executeScript("arguments[0].click()", ClickSearch);
	  System.out.println("Click on the Search");
	  Thread.sleep(2000);
	  
  }
  
  public void verifyWebTable() throws InterruptedException {
	  Thread.sleep(2000);
	   List<WebElement> WColumn= driver.findElements(tableList);
	   int tablesize = WColumn.size();
	   System.out.println(tablesize);
	   List<String> tableValue = new ArrayList<String>();
	   Iterator<WebElement> I= WColumn.iterator();
	   while(I.hasNext()) {
		   WebElement value= I.next();
		   tableValue.add(value.getText());
		   System.out.println(tableValue);
	   }
	  
  }
  
  public void printTheCorrespondingData() throws InterruptedException {
	  Thread.sleep(2000);
		/*
		 * List<WebElement> Value= driver.findElements(DashboardCount); List<String>
		 * Count = new ArrayList<String>(); int countitems= Value.size(); for(WebElement
		 * e: Value) { String V= e.getText(); Count.add(V); System.out.println(Count); }
		 */
	  Util.DivValue(DashboardCount);
	  
  }
  
  public void iterateLast30Days() throws InterruptedException {
	  Thread.sleep(2000);
	 
	  Util.JavaScriptScrollIntoView(btnByDose);
	 // Click on the By Doses
	  Thread.sleep(1000);
	  Util.JavaScriptClick(btnByDose);
	  Thread.sleep(1000);
	 
	// Click on the By Doses
	  Thread.sleep(1000);
	  Util.JavaScriptClick(last30Days);
	  Thread.sleep(5000);
/*	  
	WebElement ele= driver.findElement(SvgGraph) ;
	int getTopLeftY = (ele.getSize().getHeight()/2)-(ele.getSize().getHeight());
	int getTopLeftX = (ele.getSize().getWidth()/2)-(ele.getSize().getWidth());
	
	System.out.println(getTopLeftY);
	System.out.println(getTopLeftX);
	
	for(int i=0;i<100;i++) {
		Actions act= new Actions(driver);
		act.moveToElement(ele,getTopLeftX+i,getTopLeftY).perform();
		String Value = driver.findElement(SvgGraph).getText();
		System.out.println(Value);
	}
*/
	  
	  List<WebElement> canvas= driver.findElements(SvgGraph);
	  int Size= canvas.size();
	  System.out.println(Size);
}
  
 public void googleSvgAutomate() throws InterruptedException {
	 Thread.sleep(1000);
	 driver.get("https://www.google.com/");
	 Thread.sleep(1000);
	 driver.findElement(GoogleSearch).sendKeys("covid cases in india today");
	 Thread.sleep(2000);
	 driver.findElement(GoogleSearch).sendKeys(Keys.ENTER);
	 Thread.sleep(2000);
	 Util.JavaScriptScrollIntoView(SvgGraphG);
	 List<WebElement> GraphSvg = driver.findElements(SvgGraphG);
	 int count= GraphSvg.size();
	 System.out.println(count);
	 Actions Act = new Actions(driver);
	 for(WebElement e:GraphSvg) {
		 Act.moveToElement(e).perform();
		 Thread.sleep(500);
		 String toolTipValue=  driver.findElement(GoogleSearchSVGToolTip).getText();
		 System.out.println(toolTipValue);
	 }
	 
 }
  
  
  
  }


