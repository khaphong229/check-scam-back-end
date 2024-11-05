# Luồng chạy chi tiết của API

## 1. Khởi động ứng dụng

- Khi ứng dụng khởi chạy, `CheckScammerApplication.java` với annotation `@SpringBootApplication` sẽ khởi động Spring
  Boot.
- Spring Boot sẽ quét tất cả các package con để tìm và khởi tạo các bean được đánh dấu bằng các annotation như
  `@Service`, `@RestController`, `@Repository`.

## 2. Cấu trúc theo mô hình MVC (Model-View-Controller) và Repository pattern

### a. Model (`Scammer.java`)

- Đây là entity class đại diện cho dữ liệu scammer.
- Sử dụng Lombok (`@Data`, `@AllArgsConstructor`, `@NoArgsConstructor`) để tự động tạo getter, setter, constructor.
- `@Document` đánh dấu đây là một collection trong MongoDB.
- Các trường dữ liệu: `id`, `nameScammer`, `phoneScammer`, `backNumber`, v.v.

### b. Repository (`ScammerRepository.java`)

- Interface kế thừa `MongoRepository` để thực hiện các thao tác CRUD với MongoDB.
- Tự động có các phương thức như `save()`, `findById()`, `findAll()`, `delete()`, v.v.

### c. Service Layer

- **`ScammerService.java`**: Interface định nghĩa các phương thức business logic.
- **`ScammerServiceImpl.java`**: Class implement các phương thức của interface.
- Xử lý logic nghiệp vụ và tương tác với Repository.

### d. Controller (`ScammerController.java`)

- Xử lý các HTTP request từ client.
- Định tuyến request đến các phương thức tương ứng.

## 3. Luồng xử lý request

**Ví dụ với một request POST để tạo mới scammer**:

```
Client → POST /scammers → ScammerController → ScammerService → ScammerRepository → MongoDB
```

### Chi tiết từng bước

1. Client gửi POST request với dữ liệu scammer.
2. Request được gửi đến `@PostMapping` trong `ScammerController`.
3. Controller gọi `scammerService.saveScammer(scammer)`.
4. Service xử lý logic (nếu có) và gọi `scammerRepository.save(scammer)`.
5. Repository lưu dữ liệu vào MongoDB.
6. Kết quả được trả về theo chuỗi ngược lại về client.

## 4. Các API endpoint có sẵn

### a. **POST /scammers**

- Tạo mới một scammer.
- Trả về HTTP 201 (CREATED) khi thành công.

### b. **GET /scammers**

- Lấy danh sách tất cả scammer.
- Trả về `List<Scammer>`.

### c. **GET /scammers/{id}**

- Lấy thông tin một scammer theo id.
- Trả về HTTP 200 (OK) với dữ liệu scammer hoặc throw exception nếu không tìm thấy.

### d. **PUT /scammers/{id}**

- Cập nhật thông tin scammer.
- Trả về HTTP 200 (OK) với dữ liệu đã cập nhật.

### e. **DELETE /scammers/{id}**

- Xóa một scammer theo id.
- Trả về HTTP 200 với message thành công.

## 5. Xử lý lỗi

- Các phương thức trong Service layer có xử lý exception cơ bản.
- Nếu không tìm thấy scammer sẽ throw `RuntimeException`.
- Có thể cải thiện bằng cách thêm proper exception handling.

## 6. Dependency Injection

- Sử dụng `@Autowired` để inject các dependency.
- `ScammerController` phụ thuộc vào `ScammerService`.
- `ScammerServiceImpl` phụ thuộc vào `ScammerRepository`.

## Kết luận

Đây là một ứng dụng REST API cơ bản tuân theo các best practice của Spring Boot với:

- Phân tách rõ ràng các layer (Controller, Service, Repository).
- Sử dụng MongoDB làm database.
- Cung cấp đầy đủ các operation CRUD.
- Sử dụng các annotation của Spring để configuration.
- Lombok để giảm boilerplate code.
