package Laba8;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;

import org.json.simple.parser.JSONParser;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class t1 {
    void t_1_1(){
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Корневой элемент
            Document doc = dBuilder.newDocument();
            Element rootElement = doc.createElement("library");
            doc.appendChild(rootElement);

            // Элемент книги
            Element book = doc.createElement("book");
            rootElement.appendChild(book);

            Element title = doc.createElement("title");
            title.appendChild(doc.createTextNode("Идиот"));
            book.appendChild(title);

            Element author = doc.createElement("author");
            author.appendChild(doc.createTextNode("Федор Михайлович Достоевский"));
            book.appendChild(author);

            Element year = doc.createElement("year");
            year.appendChild(doc.createTextNode("1869"));
            book.appendChild(year);

            // Вторая книга
            Element book2 = doc.createElement("book");
            rootElement.appendChild(book2);

            Element title2 = doc.createElement("title");
            title2.appendChild(doc.createTextNode("Мастер и Маргарита"));
            book2.appendChild(title2);

            Element author2 = doc.createElement("author");
            author2.appendChild(doc.createTextNode("Михаил Афанасьевич Булгаков"));
            book2.appendChild(author2);

            Element year2 = doc.createElement("year");
            year2.appendChild(doc.createTextNode("1967"));
            book2.appendChild(year2);

            // Третья книга
            Element book3 = doc.createElement("book");
            rootElement.appendChild(book3);

            Element title3 = doc.createElement("title");
            title3.appendChild(doc.createTextNode("Братья Карамазовы"));
            book3.appendChild(title3);

            Element author3 = doc.createElement("author");
            author3.appendChild(doc.createTextNode("Федор Михайлович Достоевский"));
            book3.appendChild(author3);

            Element year3 = doc.createElement("year");
            year3.appendChild(doc.createTextNode("1880"));
            book3.appendChild(year3);

            // Запись XML-файла
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);

            StreamResult result = new StreamResult(new java.io.File("src/main/resources/example.xml"));
            transformer.transform(source, result);

            System.out.println("Файл успешно создан!");
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

    void t_1_2(){
        try {
            File inputFile = new File("src/Lab8/Examples/Example1/example.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            System.out.println("Корневой элемент: " + doc.getDocumentElement().getNodeName());

            NodeList nodeList = doc.getElementsByTagName("book");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                System.out.println("\nТекущий элемент: " + node.getNodeName());

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Название книги: " +
                            element.getElementsByTagName("title").item(0).getTextContent());
                    System.out.println("Автор: " +
                            element.getElementsByTagName("author").item(0).getTextContent());
                    System.out.println("Год издания: " +
                            element.getElementsByTagName("year").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void t_2_1(){
        JSONObject library = new JSONObject();
        JSONArray books = new JSONArray();

        JSONObject book1 = new JSONObject();
        book1.put("title", "Война и мир");
        book1.put("author", "Лев Толстой");
        book1.put("year", 1869);

        JSONObject book2 = new JSONObject();
        book2.put("title", "Мастер и Маргарита");
        book2.put("author", "Михаил Булгаков");
        book2.put("year", 1967);

        books.add(book1);
        books.add(book2);

        library.put("books", books);

        try (FileWriter file = new FileWriter("src/Lab8/Examples/Example2/example-json.json")) {
            file.write(library.toJSONString());
            System.out.println("Json файл успешно создан!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void t_2_2(){
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("src/Lab8/Examples/Example2/example-json.json"));

            JSONObject jsonObject = (JSONObject) obj;
            System.out.println("Корневой элемент: " + jsonObject.keySet().iterator().next());

            JSONArray jsonArray = (JSONArray) jsonObject.get("books");

            for (Object o : jsonArray) {
                JSONObject book = (JSONObject) o;
                System.out.println("\nТекущий элемент: book");
                System.out.println("Название книги: " + book.get("title"));
                System.out.println("Автор: " + book.get("author"));
                System.out.println("Год издания: " + book.get("year"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void t_3_1(){
        String url = "https://itlearn.ru/first-steps";
        try {
            org.jsoup.nodes.Document doc = Jsoup.connect(url).get();
            Elements links = doc.select("a[href]");
            for (org.jsoup.nodes.Element link : links) {
                System.out.println(link.attr("abs:href"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void t_3_2(){
        try {
            // Получение HTML-кода страницы
            org.jsoup.nodes.Document doc = Jsoup.connect("http://fat.urfu.ru/index.html").get();

            // Извлекаем список новостей
            Elements newsParent = doc
                    .select("body > table > tbody > tr > td > div > table > "
                            + "tbody > tr:nth-child(5) > td:nth-child(3) > table > tbody > "
                            + "tr > td:nth-child(1)");

            // Вывод последних 10 новостей в консоль
            for (int i = 3; i < 20; i++) {
                if ((i % 2) == 0) {
                    List<org.jsoup.nodes.Node> nodes = newsParent.get(0).childNodes();
                    System.out.println("Тема: " +
                            ((org.jsoup.nodes.Element) nodes.get(i))
                                    .getElementsByClass("blocktitle")
                                    .get(0).childNodes().get(0));

                    System.out.println("Дата : " +
                            ((org.jsoup.nodes.Element) nodes.get(i))
                                    .getElementsByClass("blockdate")
                                    .get(0).childNodes().get(0));

                    System.out.println();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void t_4_1() throws IOException {
        // Создаём новую книгу Excel
        XSSFWorkbook workbook = new XSSFWorkbook();

        // Создаём новый лист в книге
        XSSFSheet sheet = workbook.createSheet("Товары");

        // Заполняем данные в ячейки
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Название");
        headerRow.createCell(1).setCellValue("Характеристики");
        headerRow.createCell(2).setCellValue("Стоимость");

        Row dataRow1 = sheet.createRow(1);
        dataRow1.createCell(0).setCellValue("Книга");
        dataRow1.createCell(1).setCellValue("Жанр: фантастика, Автор: Иванов И.И.");
        dataRow1.createCell(2).setCellValue(500.0);

        Row dataRow2 = sheet.createRow(2);
        dataRow2.createCell(0).setCellValue("Компьютер");
        dataRow2.createCell(1).setCellValue("Процессор: Intel Core i5, Оперативная память: 8ГБ");
        dataRow2.createCell(2).setCellValue(25000.0);

        // Записываем книгу Excel в файл
        String filePath = "src/Lab8/Examples/Example4/example3.xlsx";
        FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

        System.out.println("Данные записаны в файл: " + filePath);
    }

    void t_4_2() throws IOException {
        // Открываем файл Excel для чтения
        String filePath = "src/Lab8/Examples/Example4/example3.xlsx";
        FileInputStream inputStream = new FileInputStream(filePath);

        // Создаём экземпляр книги Excel из файла
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

        // Получаем лист из книги по его имени
        XSSFSheet sheet = workbook.getSheet("Товары");

        // Перебираем строки и ячейки листа
        for (Row row : sheet) {
            for (Cell cell : row) {
                // Выводим значение ячейки на экран
                System.out.print(cell.toString() + "\t");
            }
            System.out.println();
        }

        // Закрываем файл и освобождаем ресурсы
        workbook.close();
        inputStream.close();
    }
}
