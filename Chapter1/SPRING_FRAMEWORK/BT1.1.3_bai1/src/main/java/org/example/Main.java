package org.example;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Khởi tạo vùng chứa Spring (Context) dựa trên bản vẽ AppConf
        var context = new AnnotationConfigApplicationContext(AppConf.class);

        // Truy vấn Bean GreetingService từ trong vùng chứa ra để sử dụng
        GreetingService service = context.getBean(GreetingService.class);

        // In kết quả ra màn hình
        service.printMessage();

        // Đóng context
        context.close();
    }
}