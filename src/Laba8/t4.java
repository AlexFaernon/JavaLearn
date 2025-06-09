package Laba8;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class t4 {
    public static void main(String[] args) {
        String url = "http://fat.urfu.ru/index.html";
        Document doc = null;
        int maxRetries = 3;
        int attempt = 0;
        boolean success = false;

        while (attempt < maxRetries && !success) {
            try {
                doc = Jsoup.connect(url).get();
                success = true;
            } catch (IOException e) {
                attempt++;
                System.out.println("Ошибка подключения (попытка " + attempt + "). Повтор через 2 секунды...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }

        if (!success) {
            System.out.println("Не удалось подключиться к сайту после " + maxRetries + " попыток.");
            return;
        }

        Elements newsParent = doc.select("body > table > tbody > tr > td > div > table > "
                + "tbody > tr:nth-child(5) > td:nth-child(3) > table > tbody > "
                + "tr > td:nth-child(1)");

        if (newsParent.isEmpty()) {
            System.out.println("Новости не найдены на странице.");
            return;
        }

        try (FileWriter writer = new FileWriter("news.txt")) {
            List<Node> nodes = newsParent.get(0).childNodes();

            for (int i = 3; i < 20; i++) {
                if ((i % 2) == 0 && i < nodes.size()) {
                    Element currentElement = (Element) nodes.get(i);

                    Elements blockTitle = currentElement.getElementsByClass("blocktitle");
                    Elements blockDate = currentElement.getElementsByClass("blockdate");

                    if (!blockTitle.isEmpty() && !blockDate.isEmpty()) {
                        String title = blockTitle.get(0).childNodes().get(0).toString();
                        String date = blockDate.get(0).childNodes().get(0).toString();

                        System.out.println("Тема: " + title);
                        System.out.println("Дата: " + date);
                        System.out.println();

                        writer.write("Тема: " + title + "\n");
                        writer.write("Дата: " + date + "\n\n");
                    }
                }
            }
            System.out.println("Данные успешно записаны в файл news.txt");
        } catch (IOException e) {
            System.out.println("Ошибка при записи данных в файл: " + e.getMessage());
        }
    }
}
