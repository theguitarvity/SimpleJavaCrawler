import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class SpiderLeg {
	private static final String USER_AGENT ="Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
	private List<String> links = new LinkedList<String>();
	private Document htmlDocument;
	public boolean crawl(String url){
		try{
			Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
			Document htmlDocument = connection.get();
			this.htmlDocument = htmlDocument;
			if(connection.response().statusCode()==200)
				System.out.println("\n**Visitando** Recebendo web page via " + url);
			if(!connection.response().contentType().contains("text/html")){
				System.out.println("**Falha** Recebido algum outro documento que nao � html");
                return false;
			}
			Elements linksOnPage = htmlDocument.select("a[href]");
            System.out.println("Found (" + linksOnPage.size() + ") links");
            for(Element link : linksOnPage)
            {
                this.links.add(link.absUrl("href"));
            }
            return true;
			
		}
		catch(IOException ioe){
			System.out.println("Error in out HTTP request"+ioe);
			return false;
		}
	}
	public boolean searchForWord(String searchWord){
		if(this.htmlDocument == null){
			System.out.println("ERROR! chamada crawl() antes da analise de desempenho do documento");
            return false;
		}
		System.out.println("Buscando pela palavra chave " + searchWord + "...");
        String bodyText = this.htmlDocument.body().text();
        return bodyText.toLowerCase().contains(searchWord.toLowerCase());
	}
	public List<String> getLists(){
		return this.links;
	}
}
