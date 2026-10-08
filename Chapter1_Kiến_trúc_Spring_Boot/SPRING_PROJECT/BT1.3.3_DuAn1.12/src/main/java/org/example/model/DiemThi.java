package org.example.model;

public class DiemThi {
    private String sbd;
    private double diemToan;
    private double diemVan;
    private double diemAnh;

    public DiemThi(String sbd, double diemToan, double diemVan, double diemAnh) {
        this.sbd = sbd;
        this.diemToan = diemToan;
        this.diemVan = diemVan;
        this.diemAnh = diemAnh;
    }

    // [Câu c] Các getter cung cấp các trường dữ liệu để Spring/Jackson tạo JSON điểm thi.
    public String getSbd() { return sbd; }
    public double getDiemToan() { return diemToan; }
    public double getDiemVan() { return diemVan; }
    public double getDiemAnh() { return diemAnh; }
}
