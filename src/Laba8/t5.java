package Laba8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class t5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Прочитать файл Excel");
            System.out.println("2. Записать новый файл Excel");
            System.out.println("3. Выход");
            System.out.print("Введите номер действия: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    readExcel(scanner);
                    break;
                case "2":
                    writeExcel();
                    break;
                case "3":
                    System.out.println("Завершение работы программы.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        }
    }

    private static void readExcel(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Введите путь к файлу Excel (например, src/Lab8/Examples/Example4/example3.xlsx): ");
                String filePath = scanner.nextLine();

                FileInputStream inputStream = new FileInputStream(filePath);
                XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

                System.out.print("Введите название листа (например, Товары): ");
                String sheetName = scanner.nextLine();
                XSSFSheet sheet = workbook.getSheet(sheetName);

                if (sheet == null) {
                    System.out.println("Ошибка: Лист с именем '" + sheetName + "' не найден.");
                    workbook.close();
                    inputStream.close();
                    continue;
                }

                System.out.println("\nДанные из файла:");
                for (Row row : sheet) {
                    for (Cell cell : row) {
                        System.out.print(cell.toString() + "\t");
                    }
                    System.out.println();
                }

                workbook.close();
                inputStream.close();
                System.out.println("\nЧтение файла завершено успешно.");
                break;

            } catch (IOException e) {
                System.out.println("Ошибка при работе с файлом: " + e.getMessage());
                System.out.println("Проверьте, существует ли файл, и правильный ли у него формат.");
                System.out.print("Хотите попробовать снова? (y/n): ");
                String retry = scanner.nextLine();
                if (!retry.equalsIgnoreCase("y")) {
                    System.out.println("Возврат в главное меню.");
                    break;
                }
            }
        }
    }

    private static void writeExcel() {
        String filePath = "src/Lab8/Examples/Example4/example3.xlsx";

        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            XSSFSheet sheet = workbook.createSheet("Товары");

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

            try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
                workbook.write(outputStream);
                System.out.println("Данные записаны в файл: " + filePath);
            }

        } catch (IOException e) {
            System.out.println("Ошибка при записи данных в файл: " + e.getMessage());
            System.out.println("Проверьте, существует ли указанный путь и есть ли права для записи.");
        }
    }
}
