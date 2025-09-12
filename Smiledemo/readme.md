# Bài tập BONUS 1 HSF302-FALL2025

# Thông tin sinh viên
- **Họ và tên:** Hà Vũ Long
- **Mã sinh viên:** HE186065
- **Lớp:** SE1955

# Thông tin cơ sở dữ liệu

Dự án này sử dụng cơ sở dữ liệu Microsoft SQL Server cho JPA/Hibernate.

## Cấu hình cơ sở dữ liệu
- **Tên cơ sở dữ liệu:** tutorial
- **JDBC URL:** `jdbc:sqlserver://localhost:1433;databaseName=tutorial;encrypt=true;trustServerCertificate=true;`
- **Tên đăng nhập:** sa
- **Mật khẩu:** 12
- **Driver:** com.microsoft.sqlserver.jdbc.SQLServerDriver

## Lưu ý
- Đảm bảo cơ sở dữ liệu `tutorial` đã tồn tại trên SQL Server của bạn.
- Người dùng `sa` phải có quyền truy cập vào cơ sở dữ liệu `tutorial`.
- Kết nối sử dụng chế độ mã hóa và tin cậy chứng chỉ máy chủ.
- Bạn có thể thay đổi tên đăng nhập và mật khẩu trong file `src/main/resources/META-INF/persistence.xml` nếu cần.
