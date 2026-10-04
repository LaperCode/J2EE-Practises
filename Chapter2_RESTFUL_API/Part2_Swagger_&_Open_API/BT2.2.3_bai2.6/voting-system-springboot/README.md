# Voting System - Spring Boot REST API + Swagger

Bài Dự án 2.6: xây dựng RESTful API cho hệ thống bình chọn nhà hàng ăn trưa, không có frontend.

## 1. Chức năng

- Có 2 loại tài khoản: `ADMIN` và `USER`.
- ADMIN CRUD nhà hàng.
- ADMIN CRUD món ăn; mỗi món có ngày, tên, giá và nhà hàng.
- USER xem nhà hàng + menu của ngày.
- USER tìm nhà hàng theo tên.
- Mỗi user chỉ có 1 vote/ngày.
- Có thể đổi vote trước 11:00.
- Sau 11:00 vote của ngày đó bị khóa.
- Swagger UI để xem và gọi trực tiếp các endpoint.

## 2. Công nghệ

- Java 17
- Spring Boot 3.5.16
- Spring Web
- Spring Data JPA / Hibernate
- Spring Security - HTTP Basic Authentication
- HSQLDB
- springdoc-openapi / Swagger UI
- Maven

## 3. Chạy project

Yêu cầu Java 17+ và Maven 3.9+.

```bash
mvn spring-boot:run
```

Hoặc chạy class `VotingSystemApplication` trong IntelliJ IDEA.

API chạy tại `http://localhost:8080`.
Swagger UI:

`http://localhost:8080/swagger-ui.html`

OpenAPI JSON:

`http://localhost:8080/v3/api-docs`

## 4. Tài khoản mẫu

| Role | Username | Password |
|---|---|---|
| ADMIN | admin@gmail.com | admin |
| USER | user@gmail.com | 12345678 |
| USER | herbert@gmail.com | herbert |

## 5. API chính

### Admin - Restaurants

- `GET /api/admin/restaurants`
- `GET /api/admin/restaurants/{id}`
- `POST /api/admin/restaurants`
- `PUT /api/admin/restaurants/{id}`
- `DELETE /api/admin/restaurants/{id}`

### Admin - Dishes

- `GET /api/admin/dishes`
- `GET /api/admin/dishes/{id}`
- `POST /api/admin/dishes`
- `PUT /api/admin/dishes/{id}`
- `DELETE /api/admin/dishes/{id}`

### User - Restaurants

- `GET /api/restaurants/dishes?date=2026-10-04`
- `GET /api/restaurants/searchByTitle?title=Local&date=2026-10-04`

### User - Votes

- `GET /api/vote?date=2026-10-04`
- `GET /api/vote/history`
- `POST /api/vote/{restaurantId}`

## 6. Curl test

### ADMIN - lấy danh sách nhà hàng

```bash
curl -u admin@gmail.com:admin http://localhost:8080/api/admin/restaurants
```

### ADMIN - tạo nhà hàng

```bash
curl -u admin@gmail.com:admin -X POST \
  http://localhost:8080/api/admin/restaurants \
  -H "Content-Type: application/json" \
  -d '{"title":"Tiget","location":"3A Lenina Street"}'
```

### ADMIN - tạo món ăn

```bash
curl -u admin@gmail.com:admin -X POST \
  http://localhost:8080/api/admin/dishes \
  -H "Content-Type: application/json" \
  -d '{"date":"2026-10-04","name":"Shrimp & vegetables","price":60000,"restaurantId":1}'
```

### USER - xem menu hôm nay

```bash
curl -u user@gmail.com:12345678 \
  "http://localhost:8080/api/restaurants/dishes?date=2026-10-04"
```

### USER - vote nhà hàng id 1

```bash
curl -u user@gmail.com:12345678 -X POST \
  http://localhost:8080/api/vote/1
```

### USER - xem vote của mình trong ngày

```bash
curl -u user@gmail.com:12345678 \
  "http://localhost:8080/api/vote?date=2026-10-04"
```

### USER - xem lịch sử vote

```bash
curl -u user@gmail.com:12345678 \
  http://localhost:8080/api/vote/history
```

## 7. Luật nghiệp vụ

Khi user vote lần đầu trong ngày, hệ thống tạo bản ghi `Vote`.

Nếu user vote lần 2 trong cùng ngày:

- trước 11:00: cập nhật nhà hàng đã chọn;
- từ 11:00 trở đi: trả về lỗi và không cho đổi vote.

Database còn có unique constraint trên `(user_id, vote_date)` để đảm bảo một user không có 2 vote trong cùng một ngày.
