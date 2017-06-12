import java.util.Scanner;

public class SpiderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url, palavraChave;
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite a Url que você quer buscar:");
		url = 
		Spider spider = new Spider();
        spider.search("http://www.bytegod.com.br/", "bytegod");
	}

}
