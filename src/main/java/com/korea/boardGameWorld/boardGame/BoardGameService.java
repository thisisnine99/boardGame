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
            System.out.println(doc);
            Elements elements = doc.select("div.info");
            for (Element element : elements) {
                BoardGame boardGame = new BoardGame();
//                boardGame.setHref(element.attr("href"));
//                boardGame.setTitle("text");
                System.out.println("여기================>" + element);
                System.out.println(element.attr("href"));
            }
        } catch (Exception e) {
            System.out.println("fuck_off");
        }
    }
}
