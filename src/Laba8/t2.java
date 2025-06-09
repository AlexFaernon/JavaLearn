package Laba8;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Scanner;

public class t2 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String filePath = "songs.xml";

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить песню");
            System.out.println("2. Поиск песен");
            System.out.println("3. Удалить песню");
            System.out.println("4. Выход");
            System.out.print("Выберите действие: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addSong(filePath);
                    break;
                case 2:
                    searchSongs(filePath);
                    break;
                case 3:
                    deleteSong(filePath);
                    break;
                case 4:
                    System.out.println("Выход.");
                    return;
                default:
                    System.out.println("Неверный ввод!");
            }
        }
    }

    public static void addSong(String filePath) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите название песни: ");
        String title = scanner.nextLine();

        System.out.print("Введите исполнителя: ");
        String artist = scanner.nextLine();

        System.out.print("Введите год выпуска: ");
        String year = scanner.nextLine();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc;

        File file = new File(filePath);
        if (file.exists()) {
            doc = builder.parse(file);
        } else {
            doc = builder.newDocument();
            Element root = doc.createElement("songs");
            doc.appendChild(root);
        }

        Element newSong = doc.createElement("song");

        Element titleElement = doc.createElement("title");
        titleElement.setTextContent(title);

        Element artistElement = doc.createElement("artist");
        artistElement.setTextContent(artist);

        Element yearElement = doc.createElement("year");
        yearElement.setTextContent(year);

        newSong.appendChild(titleElement);
        newSong.appendChild(artistElement);
        newSong.appendChild(yearElement);

        doc.getDocumentElement().appendChild(newSong);

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(filePath));
        transformer.transform(source, result);

        System.out.println("Песня успешно добавлена!");
    }

    public static void searchSongs(String filePath) throws Exception {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("Файл не найден.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите исполнителя (оставьте пустым, если не нужно): ");
        String artistInput = scanner.nextLine().trim();

        System.out.print("Введите год выпуска (оставьте пустым, если не нужно): ");
        String yearInput = scanner.nextLine().trim();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(file);

        NodeList songList = doc.getElementsByTagName("song");
        boolean found = false;

        System.out.println("\nНайденные песни:");
        for (int i = 0; i < songList.getLength(); i++) {
            Node songNode = songList.item(i);
            if (songNode.getNodeType() == Node.ELEMENT_NODE) {
                Element songElement = (Element) songNode;
                String artist = songElement.getElementsByTagName("artist").item(0).getTextContent();
                String year = songElement.getElementsByTagName("year").item(0).getTextContent();

                boolean match = true;
                if (!artistInput.isEmpty() && !artist.equalsIgnoreCase(artistInput)) {
                    match = false;
                }
                if (!yearInput.isEmpty() && !year.equals(yearInput)) {
                    match = false;
                }

                if (match) {
                    String title = songElement.getElementsByTagName("title").item(0).getTextContent();
                    System.out.println("Название: " + title + ", Исполнитель: " + artist + ", Год: " + year);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("Нет песен, удовлетворяющих критериям поиска.");
        }
    }

    public static void deleteSong(String filePath) throws Exception {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("Файл не найден.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите название песни для удаления: ");
        String titleInput = scanner.nextLine().trim();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(file);

        NodeList songList = doc.getElementsByTagName("song");
        boolean found = false;

        for (int i = 0; i < songList.getLength(); i++) {
            Element songElement = (Element) songList.item(i);
            String title = songElement.getElementsByTagName("title").item(0).getTextContent();

            if (title.equalsIgnoreCase(titleInput)) {
                Node parent = songElement.getParentNode();
                parent.removeChild(songElement);
                found = true;
                break;
            }
        }

        if (found) {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);

            System.out.println("Песня успешно удалена!");
        } else {
            System.out.println("Песня с таким названием не найдена.");
        }
    }
}
