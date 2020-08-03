import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String link;
		get_instagram_follwer test = new get_instagram_follwer();
		System.out.println("Insert instagram name");
		link = scan.next();
		test.update_url(link);
		test.get_follwer();
		
		
		get_img test2 = new get_img();
		test2.update_url(link);
		test2.get_image();
	}

}
