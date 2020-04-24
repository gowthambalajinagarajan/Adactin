package Demo;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Adactin 123456{

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\acer\\Desktop\\Java\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.adactin.com/HotelApp/index.php");
		driver.manage().window().maximize();
		
		WebElement user=driver.findElement(By.id("username"));
		user.sendKeys("gowthambala");
		
		WebElement pass=driver.findElement(By.id("password"));
		pass.sendKeys("balaji18");
		
		driver.findElement(By.id("login")).click();
		
		WebElement Location=driver.findElement(By.id("location"));
		Select a=new Select(Location);
		a.selectByValue("Brisbane");
		
		/*List<WebElement> list=a.getOptions();
		for(WebElement listLocation:list) {
			System.out.println(listLocation.getText());
		}*/
		
		WebElement Hotels=driver.findElement(By.id("hotels"));
		Select b=new Select(Hotels);
		b.selectByValue("Hotel Sunshine");
		
		/*List<WebElement> listA=b.getOptions();
		for(WebElement HotelList:listA) {
			System.out.println(HotelList.getText());
		}*/
		
		WebElement RoomType=driver.findElement(By.id("room_type"));
		Select c=new Select(RoomType);
		c.selectByValue("Deluxe");
		
		WebElement Roomnos=driver.findElement(By.id("room_nos"));
		Select d=new Select(Roomnos);
		d.selectByValue("4");
		
		WebElement CheckIn=driver.findElement(By.id("datepick_in"));
		CheckIn.clear();
		CheckIn.sendKeys("07/04/2020");
		
		WebElement CheckOut=driver.findElement(By.id("datepick_out"));
		CheckOut.clear();
		CheckOut.sendKeys("10/04/2020");
		
		WebElement AdultRoom=driver.findElement(By.id("adult_room"));
		Select e=new Select(AdultRoom);
		e.selectByValue("3");
		
		WebElement ChildRoom=driver.findElement(By.id("child_room"));
		Select f=new Select(ChildRoom);
		f.selectByValue("1");
		
		driver.findElement(By.id("Submit")).click();
		driver.findElement(By.id("radiobutton_0")).click();
		driver.findElement(By.id("continue")).click();
		
		WebElement FirstName=driver.findElement(By.id("first_name"));
		FirstName.sendKeys("Gowtham");
		
		WebElement LastName=driver.findElement(By.id("last_name"));
		LastName.sendKeys("Balaji");
		
		WebElement Address=driver.findElement(By.id("address"));
		Address.sendKeys("Chennai");
		
		WebElement cc_num=driver.findElement(By.id("cc_num"));
		cc_num.sendKeys("1234567890123456");
		
		WebElement cc_type=driver.findElement(By.id("cc_type"));
		Select g=new Select(cc_type);
		g.selectByValue("VISA");
		
		WebElement cc_exp_month=driver.findElement(By.id("cc_exp_month"));
		Select h=new Select(cc_exp_month);
		h.selectByValue("3");
		
		WebElement cc_exp_year=driver.findElement(By.id("cc_exp_year"));
		Select i=new Select(cc_exp_year);
		i.selectByValue("2022");
		
		WebElement cc_cvv=driver.findElement(By.id("cc_cvv"));
		cc_cvv.sendKeys("123");
		
		driver.findElement(By.id("book_now")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("order_no")));
		
		String OrderNo=driver.findElement(By.id("order_no")).getAttribute("value");
		System.out.println("OrderNo : "+OrderNo);
		
		driver.findElement(By.id("my_itinerary")).click();
		
		String input=OrderNo;
		
		WebElement table=driver.findElement(By.xpath("(//table)[5]"));
		List<WebElement> tablerow=table.findElements(By.xpath((".//tbody//tr")));
		for(int j=1;j<tablerow.size();j++){
			String OrderID=tablerow.get(j).findElement(By.xpath(".//td[2]/input")).getAttribute("value");
			//System.out.println(OrderID);
			if(OrderID.equals(input)) {
				tablerow.get(j).findElement(By.xpath(".//td[3]/input")).click();
				Alert al=driver.switchTo().alert();
				al.accept();
			}
		}
		
		String Cancel=driver.findElement(By.id("search_result_error")).getText();
		System.out.println(OrderNo +"-"+ Cancel);
	}
}
