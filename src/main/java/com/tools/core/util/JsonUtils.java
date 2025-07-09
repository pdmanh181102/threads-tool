package com.tools.core.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

    // Hàm tĩnh để lưu đối tượng thành file JSON
    // public static void saveToJson(Object obj, String fileName) {
    // ObjectMapper objectMapper = new ObjectMapper();
    // try {
    // // Lưu vào file trong thư mục gốc của dự án
    // File file = new File(fileName);
    // objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, obj);
    // System.out.println("Đã lưu file JSON tại: " + file.getAbsolutePath());
    // } catch (IOException e) {
    // System.err.println("Lỗi khi ghi file JSON: " + e.getMessage());
    // }
    // }

    public static void saveToJson(Object obj) {
        ObjectMapper objectMapper = new ObjectMapper();

        // Lấy ngày và giờ hiện tại
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();

        String dateStr = currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String timeStr = currentTime.format(DateTimeFormatter.ofPattern("HH-mm-ss"));

        // Tạo thư mục output/yyyy-MM-dd nếu chưa tồn tại
        String directoryPath = "output" + File.separator + dateStr;
        try {
            Files.createDirectories(Paths.get(directoryPath));
        } catch (IOException e) {
            System.err.println("Không thể tạo thư mục: " + e.getMessage());
            return;
        }

        // Tạo file json có tên là HH-mm-ss.json
        String filePath = directoryPath + File.separator + timeStr + ".json";

        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), obj);
            System.out.println("Đã lưu file JSON tại: " + filePath);
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi file JSON: " + e.getMessage());
        }
    }

    public static void saveToJson(Object obj, String username) {
        ObjectMapper objectMapper = new ObjectMapper();

        // Lấy ngày và giờ hiện tại
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();

        String dateStr = currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String timeStr = currentTime.format(DateTimeFormatter.ofPattern("HH-mm-ss"));

        // Tạo thư mục output/yyyy-MM-dd nếu chưa tồn tại
        String directoryPath = "output" + File.separator + dateStr + File.separator + username;
        try {
            Files.createDirectories(Paths.get(directoryPath));
        } catch (IOException e) {
            System.err.println("Không thể tạo thư mục: " + e.getMessage());
            return;
        }

        // Tạo file json có tên là HH-mm-ss.json
        String filePath = directoryPath + File.separator + timeStr + ".json";

        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), obj);
            System.out.println("Đã lưu file JSON tại: " + filePath);
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi file JSON: " + e.getMessage());
        }
    }
}
