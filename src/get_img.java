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

public class get_img {
	    
	    private WebDriver driver;
	    private WebElement element;
	    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	    public static final String WEB_DRIVER_PATH = "chromedriver.exe";
	    
	
	    private String base_url;
	    public get_img() {
	        super();
	        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
	        driver = new ChromeDriver();
	        base_url = "https://www.instagram.com/";
	    }
	    
		   void update_url(String url)
		   {
			   base_url += url;
			   base_url +="/";
		   }
	    
	 
	    public void get_image() {
	        try {
	        	int waittime=10;
	            driver.get(base_url);
	            
	            Document doc = Jsoup.parse(driver.getPageSource());
	    		Elements linksOnPage = doc.select(".v1Nh3.kIKUG._bz0w"); //클래스
				 for (Element page : linksOnPage) {
					Element img = page.select("img").first();
					String imgtag = img.outerHtml();
					int num = imgtag.indexOf("src=\"");
					String result = imgtag.substring(num,(imgtag.substring(num).indexOf("\" style")+num));
					result = result.replace("amp;", "").substring(5);
					System.out.println(result);
				 }
	    
	        } catch (Exception e) {
	            
	            e.printStackTrace();
	        
	        } finally {
	        	driver.close();
		        driver.quit();
	        }
	 
	    }
}
