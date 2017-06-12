import java.util.Scanner;

public class SpiderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Spider spider = new Spider();
		String url, word;
		System.out.println("Digite a url completa, algo como http://www.exemple.com");
		url = scan.next();
		System.out.println("Digite a palavra que você quer buscar");
		word = scan.next();
        spider.search(url, word);
	}

}
