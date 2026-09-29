package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/test-hello")
    public String helloWorld() {
        return "Hello World! Tui chạy được rồi nè!";
    }

    // Nâng cấp 1: Nhận tham số động từ đường dẫn URL
    @GetMapping("/chao")
    public String chao(@RequestParam(defaultValue = "người lạ") String ten) {
        return "Xin chào " + ten + ", tính năng truyền tham số đã hoạt động!";
    }

    // Nâng cấp 2: Trả về dữ liệu dạng JSON
    @GetMapping("/api/thong-tin")
    public Map<String, Object> layThongTin() {
        Map<String, Object> data = new HashMap<>();
        data.put("duAn", "Demo Web");
        data.put("trangThai", "Đang chạy mượt mà");
        data.put("nguoiPhatTrien", "Nguyễn Hoàng Lập");
        data.put("phienBan", "1.0");
        return data;
    }
}