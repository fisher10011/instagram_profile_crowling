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
	    
	    //WebDriver
	    private WebDriver driver;
	    private WebElement element;
	    //Properties
	    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	    public static final String WEB_DRIVER_PATH = "chromedriver.exe";
	    
	    //크롤링 할 URL
	    private String base_url;
	    public get_img() {
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
	    
	 
	    public void get_image() {
	        try {
	            //get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
	        	int waittime=10;
	            driver.get(base_url);
	            
	            //System.out.println(driver.getPageSource());
	            Document doc = Jsoup.parse(driver.getPageSource());
	            // HTML 문서의 타이틀 추출하기
	    		Elements linksOnPage = doc.select(".v1Nh3.kIKUG._bz0w"); //클래스..
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