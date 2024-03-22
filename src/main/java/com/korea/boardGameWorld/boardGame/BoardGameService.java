package com.korea.boardGameWorld.boardGame;

import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardGameService {

    private final BoardGameRepository boardGameRepository;

    public void gogo(int page) {
        crawlingList(page);
    }

    private void crawlingList(int page) {

        String URL = "https://www.koreaboardgames.com/shop/big_section.php?page=" + page + "&cno1=1001";

        try {
            Document doc = Jsoup.connect(URL).get();
//            System.out.println(doc);
            Elements elements = doc.select("div.info");
            for (Element element : elements) {
                BoardGame boardGame = new BoardGame();

                String title = element.select("a").text();
                System.out.println(title);
//                boardGame.setTitle(title);

                String href = element.select("a").attr("href");
                System.out.println(href);
//                boardGame.setHref(href);

                String wonPrice = element.select("p.sell").text();
                String price = wonPrice.substring(0, wonPrice.length() - 1);
                System.out.println(price);
//                boardGame.setPrice(price);
//                boardGameRepository.save(boardGame);
            }
        } catch (Exception e) {
            System.out.println("fuck_off");
        }
    }
}
