package org.example.controller;

import org.example.model.DiemThi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

// [Câu a] @RestController khai báo controller REST; dữ liệu trả về sẽ được Spring chuyển thành JSON.
@RestController
@RequestMapping("/api/v1")
public class TraCuuDiemController {

    private final String SECRET_TOKEN = "123456";
    private Map<String, DiemThi> data;

    public TraCuuDiemController() {
        data = new HashMap<>();
        // Nạp sẵn dữ liệu giả lập để test
        data.put("3123410194", new DiemThi("3123410194", 9.0, 6.5, 9.5));
        data.put("3123410180", new DiemThi("3123410180", 10.0, 6.0, 7.5));
    }

    // [Câu b] Endpoint GET /api/v1/scores nhận đầu vào gồm SBD (?sbd=...) và header User-Token.
    @GetMapping("/scores")
    public ResponseEntity<Object> getScore(
            @RequestParam("sbd") String sbd,
            @RequestHeader("User-Token") String userToken) {

        // [Câu c] Chỉ chấp nhận User-Token hợp lệ trước khi cho phép tra cứu điểm.
        if (!SECRET_TOKEN.equals(userToken)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Sai Token! Bạn không có quyền truy cập."));
        }

        // [Câu c] Tra cứu SBD và trả đối tượng DiemThi; Spring tự tuần tự hóa đối tượng này thành JSON.
        DiemThi ketQua = data.get(sbd);
        if (ketQua != null) {
            return ResponseEntity.ok(ketQua); // Trả về JSON điểm thi
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Không tìm thấy thí sinh với SBD: " + sbd));
        }
    }
}
