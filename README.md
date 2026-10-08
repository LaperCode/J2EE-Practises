# J2EE-Practises

Repository lưu trữ các bài thực hành, bài tập và dự án của học phần **Chuyên đề J2EE (841468)**.

Nội dung tập trung vào quá trình học và thực hành hệ sinh thái **Spring / Spring Boot**, từ các khái niệm nền tảng của Spring đến xây dựng ứng dụng Web, RESTful API, Swagger/OpenAPI, HATEOAS, Validation, xử lý ngoại lệ, Logging, Lombok, MapStruct, JPA, Hibernate và Spring Data JPA.

Repository được sử dụng như một nơi tổng hợp source code và tiến độ thực hành trong suốt học phần. Các chương, bài tập hoặc đồ án mới có thể được bổ sung trong quá trình học.

---

## Nội dung học tập

### Chapter 1 — Kiến trúc Spring Boot

Tập trung vào Spring Framework, Spring Boot và Spring Project.

Các nội dung chính:

- Spring Framework 6.x
- IoC / DI
- AOP
- Modularity
- Transaction Management
- Bean và Spring Container
- Bean Scope
- `@Autowired` / `@Qualifier`
- `@Value` / `@PropertySource`
- Spring Boot 3.x
- Spring Boot Starter
- Embedded Web Server
- RESTful API cơ bản
- Spring MVC
- Thymeleaf
- CORS
- Tổ chức một Spring Project

#### Các dự án thực hành

**Dự án 1.1** — Tìm hiểu Spring Container với cấu hình Bean bằng Java.

**Dự án 1.2** — Tìm hiểu Bean Scope với Prototype.

**Dự án 1.3** — Tìm hiểu `SCOPE_PROTOTYPE` và `SCOPE_SINGLETON`.

**Dự án 1.4** — Đọc cấu hình từ Java bằng `@Value` và `@PropertySource`.

**Dự án 1.5** — Dependency Injection với `@Autowired` và `@Qualifier`.

**Dự án 1.6** — Xây dựng Custom Bean Scope.

**Dự án 1.7** — Thực hành dự án Spring Boot theo hướng dẫn của Spring, bao gồm RESTful API, kiểm tra dự án và theo dõi vận hành.

**Dự án 1.8** — Làm quen với các tính năng cơ bản của hệ sinh thái Spring, cơ sở dữ liệu quan hệ và bảo mật ứng dụng Web.

**Dự án 1.9** — Xây dựng ứng dụng Web với Spring Boot và Thymeleaf.

**Dự án 1.10** — Xây dựng ứng dụng Web hiển thị CAPTCHA ngẫu nhiên.

**Dự án 1.11** — Xây dựng ứng dụng Web tra cứu điểm thi tốt nghiệp từ dữ liệu Excel.

**Dự án 1.12** — Xây dựng RESTful API cho ứng dụng bên thứ ba tra cứu điểm thi bằng SBD và User-Token.

**Dự án 1.13** — Xây dựng website hiển thị sơ yếu lý lịch (CV).

**Dự án 1.14** — Xây dựng website tiếp nhận thông tin phản hồi về dịch vụ.

---

### Chapter 2 — RESTful API

Tập trung vào thiết kế và xây dựng RESTful API, các phương thức HTTP, JSON, Swagger/OpenAPI và HATEOAS.

Các nội dung chính:

- RESTful API
- `GET`, `POST`, `PUT`, `DELETE`
- CRUD
- Request / Response
- JSON
- Postman
- Swagger UI
- OpenAPI Specification
- SpringDoc OpenAPI
- HATEOAS
- Richardson Maturity Model

#### Các dự án thực hành

**Dự án 2.1** — Xây dựng RESTful API CRUD cho thực thể **bài báo nghiên cứu khoa học**.

**Dự án 2.2** — Xây dựng RESTful API CRUD cho thực thể **nhân viên**.

**Dự án 2.3** — Xây dựng RESTful API CRUD cho thực thể **sơ yếu lý lịch (CV)**, gồm thông tin cá nhân, trình độ văn hóa và kinh nghiệm làm việc.

**Dự án 2.4** — Nâng cấp các RESTful API đã xây dựng bằng Swagger UI / OpenAPI.

**Dự án 2.5** — Tạo dự án theo bài viết `essentialprogramming/spring-boot-openapi`.

**Dự án 2.6** — Xây dựng RESTful API cho hệ thống **bầu chọn / bình bầu**, sau đó tích hợp Swagger để viết phần hướng dẫn sử dụng các endpoint.

**Dự án 2.7** — Xây dựng RESTful API có hỗ trợ tự khám phá API thông qua HATEOAS.

**Dự án 2.8** — Xây dựng RESTful API có hỗ trợ HATEOAS.

**Dự án 2.9** — Nâng cấp các RESTful API đã phát triển bằng cách tích hợp HATEOAS.

**Dự án 2.10** — Thực hành dự án RESTful API theo Spring REST Tutorial.

---

### Chapter 3 — Validate dữ liệu, Enum và Response

Tập trung vào kiểm soát dữ liệu đầu vào và xây dựng response trong Spring Boot.

Các nội dung chính:

- Bean Validation
- `@Valid`
- Ràng buộc dữ liệu
- Enum
- `ResponseEntity`
- HTTP Status Code
- `ApiResponse`
- JSON Response
- Thymeleaf Response

#### Các dự án thực hành

**Dự án 3.1** — Thực hành Validation trong Spring Boot.

**Dự án 3.2** — Thực hành các kỹ thuật kiểm tra dữ liệu trong Spring Boot.

**Dự án 3.3** — Nâng cấp các RESTful API đã phát triển bằng chức năng kiểm tra dữ liệu đầu vào.

**Dự án 3.4** — Xây dựng phiên bản đồ án cuối kỳ có:
- RESTful API
- Swagger / OpenAPI
- Thiết kế thực thể dữ liệu
- Validation
- Lưu dữ liệu tạm bằng Collection
- HATEOAS cho các endpoint quan trọng

**Dự án 3.5** — Hoàn thiện xử lý lỗi và truy cập endpoint không hợp lệ bằng `ApiResponse`.

---

### Chapter 4 — Xử lý ngoại lệ và Logging

Tập trung vào khả năng xử lý lỗi tập trung và theo dõi hoạt động của ứng dụng.

Các nội dung chính:

- `@ControllerAdvice`
- `@RestControllerAdvice`
- `@ExceptionHandler`
- Global Exception Handling
- Custom Exception
- Error Response
- Logging
- SLF4J
- Logback
- Log levels
- File logging

#### Các dự án thực hành

**Dự án 4.1** — Thực hành xử lý ngoại lệ trong Spring Boot.

**Dự án 4.2** — Thực hành Exception Handling với Spring Boot.

**Dự án 4.3** — Thực hành xử lý lỗi cho Spring Boot REST API.

**Dự án 4.4** — Tìm hiểu các best practices khi xử lý lỗi REST API.

**Dự án 4.5** — Xây dựng chức năng gửi email và bổ sung Logging.

**Dự án 4.6** — Thực hành Logging trong Spring Boot.

**Dự án 4.7** — Nâng cấp các RESTful API đã phát triển bằng các chức năng Logging.

**Dự án 4.8** — Tích hợp Logging vào đồ án cuối kỳ để:
- Theo dõi dữ liệu người dùng nhập không đúng
- Theo dõi hệ thống khi vận hành
- Hỗ trợ debug

---

### Chapter 5 — Lombok và MapStruct

Tập trung vào tối ưu mã nguồn và tự động hóa việc chuyển đổi dữ liệu giữa các lớp.

Các nội dung chính:

- Lombok
- Boilerplate Code
- `@Getter`
- `@Setter`
- `@Data`
- `@Builder`
- Constructor Annotations
- Dependency Injection với Lombok
- MapStruct
- Entity / DTO Mapping
- Compile-time Mapping

#### Các dự án thực hành

**Dự án 5.1** — Thực hành Lombok trong Spring Boot.

**Dự án 5.2** — Nâng cấp các RESTful API đã phát triển bằng Lombok.

**Dự án 5.3** — Tích hợp Lombok vào đồ án cuối kỳ.

**Dự án 5.4** — Thực hành MapStruct.

**Dự án 5.5** — Kết hợp MapStruct và Lombok.

**Dự án 5.6** — Thực hành MapStruct với Maven và Lombok.

---

### Chapter 6 — JPA, Hibernate và Spring Data JPA

Tập trung vào việc lưu trữ dữ liệu lâu dài, ORM và thao tác cơ sở dữ liệu bằng Java.

Các nội dung chính:

- JPA
- Hibernate
- ORM
- Entity
- Persistence Context
- Entity Lifecycle
- `EntityManager`
- Spring Data JPA
- Repository
- Query
- DTO Projection
- Transaction
- MySQL
- `@Transactional`
- `LAZY` / `EAGER`
- N+1 Select

#### Các dự án thực hành

**Dự án 6.1** — Thực hành Spring Data JPA DTO Projections.

**Dự án 6.2** — Nâng cấp các RESTful API đã phát triển để lưu trữ dữ liệu lâu dài trên MySQL.

**Dự án 6.3** — Xây dựng REST API với Spring Boot và JPA.

**Dự án 6.4** — Thực hành Spring Boot JPA và Transaction.

**Dự án 6.5** — Dựng, tìm hiểu và trình bày các công nghệ được sử dụng trong Spring Petclinic.

**Dự án 6.6** — Nâng cấp đồ án cuối kỳ với:
- Lưu trữ dữ liệu lâu dài bằng MySQL
- Spring Data JPA Repository
- Transaction cho các chức năng cập nhật cơ sở dữ liệu

---

## Công nghệ sử dụng

- Java
- Spring Framework
- Spring Boot
- Spring MVC
- Spring REST
- Thymeleaf
- RESTful API
- Swagger / OpenAPI
- HATEOAS
- Bean Validation
- Spring JDBC
- Lombok
- MapStruct
- JPA
- Hibernate
- Spring Data JPA
- MySQL
- Maven
- IntelliJ IDEA
- Postman

---

## Mục tiêu của repository

Repository tập trung vào quá trình học và thực hành theo từng giai đoạn:

```text
Spring Framework
        ↓
Spring Boot
        ↓
Spring Web / MVC
        ↓
RESTful API
        ↓
Swagger / OpenAPI
        ↓
HATEOAS
        ↓
Validation / Enum / Response
        ↓
Exception Handling / Logging
        ↓
Lombok / MapStruct
        ↓
JPA / Hibernate / Spring Data JPA
        ↓
Ứng dụng và đồ án
```

Các chapter, bài tập, project cá nhân và đồ án mới có thể tiếp tục được bổ sung vào repository trong quá trình học.

---

## Tài liệu tham khảo

Nội dung thực hành được triển khai dựa trên tài liệu học tập **Chuyên đề J2EE (841468)** và các bài viết, dự án mẫu được đề xuất trong tài liệu.

> Repository được cập nhật liên tục trong quá trình học tập và thực hành.
