package Laba8;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Scanner;

public class t3 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String filePath = "songs.json";

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
        int year = Integer.parseInt(scanner.nextLine());

        JSONParser parser = new JSONParser();
        JSONObject root;
        JSONArray songs;

        try (FileReader reader = new FileReader(filePath)) {
            root = (JSONObject) parser.parse(reader);
            songs = (JSONArray) root.get("songs");
        } catch (Exception e) {
            root = new JSONObject();
            songs = new JSONArray();
            root.put("songs", songs);
        }

        JSONObject newSong = new JSONObject();
        newSong.put("title", title);
        newSong.put("artist", artist);
        newSong.put("year", year);

        songs.add(newSong);

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(root.toJSONString());
            writer.flush();
        }

        System.out.println("Песня успешно добавлена!");
    }

    public static void searchSongs(String filePath) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите исполнителя для поиска: ");
        String artistInput = scanner.nextLine();

        JSONParser parser = new JSONParser();
        JSONObject root = (JSONObject) parser.parse(new FileReader(filePath));
        JSONArray songs = (JSONArray) root.get("songs");

        songs.stream()
                .filter(song -> song instanceof JSONObject)
                .filter(song -> artistInput.equalsIgnoreCase((String) ((JSONObject)song).get("artist")))
                .forEach(song -> {
                    System.out.println("\nНазвание: " + ((JSONObject)song).get("title"));
                    System.out.println("Исполнитель: " + ((JSONObject)song).get("artist"));
                    System.out.println("Год: " + ((JSONObject)song).get("year"));
                });
    }

    public static void deleteSong(String filePath) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите название песни для удаления: ");
        String titleInput = scanner.nextLine();

        JSONParser parser = new JSONParser();
        JSONObject root = (JSONObject) parser.parse(new FileReader(filePath));
        JSONArray songs = (JSONArray) root.get("songs");

        Iterator iterator = songs.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            JSONObject song = (JSONObject) iterator.next();
            if (titleInput.equalsIgnoreCase((String) song.get("title"))) {
                iterator.remove();
                found = true;
                break;
            }
        }

        if (found) {
            try (FileWriter writer = new FileWriter(filePath)) {
                writer.write(root.toJSONString());
                writer.flush();
            }
            System.out.println("Песня успешно удалена!");
        } else {
            System.out.println("Песня с таким названием не найдена.");
        }
    }
}
