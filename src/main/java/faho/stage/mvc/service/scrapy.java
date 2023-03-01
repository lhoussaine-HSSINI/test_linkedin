package faho.stage.mvc.service;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class scrapy {
    public  List getpage() throws IOException {
        List<String> list=new ArrayList<String>();
        Connection.Response response = Jsoup
                .connect("https://www.linkedin.com/jobs/search/?currentJobId=3474773440&f_F=it&f_I=6%2C4%2C41%2C96&f_T=9%2C14642%2C15687%2C23347%2C10%2C25170%2C122%2C3172%2C11889%2C346%2C10738%2C25201&f_TPR=r86400&geoId=102787409&location=Morocco&refresh=true&sortBy=R")
                .method(Connection.Method.GET)
                .execute();

        Document responseDocument = response.parse();
        System.out.println(responseDocument);
        Document doc= Jsoup.connect("https://www.linkedin.com/jobs/search/?currentJobId=3474773440&f_F=it&f_I=6%2C4%2C41%2C96&f_T=9%2C14642%2C15687%2C23347%2C10%2C25170%2C122%2C3172%2C11889%2C346%2C10738%2C25201&f_TPR=r86400&geoId=102787409&location=Morocco&refresh=true&sortBy=R")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36 Edg/110.0.1587.57")
                .get();

        Elements elements = responseDocument.getElementsByClass("base-card relative w-full hover:no-underline focus:no-underline base-card--link base-search-card base-search-card--link job-search-card");

        int i=1;
        for(Element x:elements) {
            System.out.println(i);
            String link=x.getElementsByClass("base-card__full-link absolute top-0 right-0 bottom-0 left-0 p-0 z-[2]").attr("href");

            if(link.isEmpty())
                link=x.getElementsByClass("base-card relative w-full hover:no-underline focus:no-underline base-card--link base-search-card base-search-card--link job-search-card").attr("href");

            System.out.println(link);
            list.add(link);
            System.out.println("===========================================================================================================================================>>\n");
            i+=1;
        }
        return list;
    }

    public String getpage_inded() throws IOException {

        Document doc=Jsoup.connect("https://ma.indeed.com/jobs?q=stage+web&fromage=1")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36 Edg/110.0.1587.57")
                .get();
        return doc.html();
    }
}
