package org.example.demo_du_an_1_3;

import org.springframework.stereotype.Component;

/**
 * Scope mặc định của một Spring bean là singleton.
 * Mọi lần lấy bean từ ApplicationContext đều nhận cùng một đối tượng.
 */
@Component
public class SingletonMessageService implements MessageService {
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }
}
