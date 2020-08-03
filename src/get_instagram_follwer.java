import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class get_instagram_follwer {
	
	    private WebDriver driver;
	    private WebElement element;
	    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	    public static final String WEB_DRIVER_PATH = "chromedriver.exe";
	    
	    
	    private String base_url;
	    
	    public get_instagram_follwer() {
	        super();
	        //System Property SetUp
	        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
	        driver = new ChromeDriver();
	        base_url = "https://www.instagram.com/";
	    }
	 
	   void update_url(String url)
	   {
		   base_url += url;
		   base_url +="/";
	   }
	   
	    public void get_follwer() {
	        try {
	            driver.get(base_url);
	            
	            //System.out.println(driver.getPageSource());
	            Document doc = Jsoup.parse(driver.getPageSource());
	    		Elements follower = doc.select(".g47SY");
	    		String data = follower.get(1).outerHtml();
	    		int num = data.indexOf("title");
	    		String result = data.substring(num,(data.substring(num).indexOf(">")+num));
	    		System.out.println(result.replaceAll("[^0-9]", ""));
	        } catch (Exception e) {
	            
	            e.printStackTrace();
	        
	        } finally {
	        	driver.close();
		        driver.quit();
	        }
	 
	    }
	    
	    
}
