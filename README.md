# README.md: Khung Kiểm Thử Tự Động

## Tổng Quan
Kho lưu trữ này chứa khung kiểm thử tự động cho chức năng Tìm kiếm của trang web khách hàng MSB (https://www.msb.com.vn). 
Khung kiểm thử được phát triển bằng Katalon Studio và được thiết kế để thực thi các trường hợp kiểm thử tự động một cách hiệu quả.

---

## Yêu Cầu Trước Khi Bắt Đầu
Trước khi bắt đầu, hãy đảm bảo bạn đã cài đặt các công cụ sau:

1. **Katalon Studio**: Tải xuống và cài đặt từ [Trang chính thức của Katalon](https://www.katalon.com/).
2. **Git**: Để sao chép kho lưu trữ.
3. **Trình Điều Khiển Trình Duyệt**: Đảm bảo WebDriver phù hợp với trình duyệt của bạn (ví dụ: ChromeDriver) đã được cài đặt và cấu hình.
4. **Java Runtime Environment (JRE)**: Cần thiết để chạy Katalon.

---

## Cấu Trúc Khung
Khung được tổ chức như sau:

```
automation-framework/
|-- Profiles/
|   |-- default (Cấu hình môi trường)
|-- Test Cases/
|   |-- search_function/ (Thư mục chứa các trường hợp kiểm thử)
|       |-- TC_01
|       |-- TC_02
|       |-- TC_03
|       |-- TC_04
|-- Object Repository/
|   |-- Home/ (Các phần tử trên trang Home)
|       |-- btn_Logo
|       |-- lbl_SearchResult
|       |-- message_SearchResult
|       |-- txt_SearchBox
|-- Test Suites/
|   |-- SearchFunctionSuite (Test Suite chứa các trường hợp kiểm thử tìm kiếm- > Mình sẽ run tại đây)
|-- Data Files/
|   |-- DataFile/ (Tệp dữ liệu kiểm thử)
|       |-- SearchFunctionData
|       |-- ExcelFile
|-- Checkpoints/ (Kiểm tra dữ liệu nếu cần)
|-- Keywords/
|   |-- common/ (Các hàm hỗ trợ dùng chung)
|   |-- function/ (Các hàm hỗ trợ cho chức năng tìm kiếm)
|       |-- SearchFunctionKeywords.groovy
|-- Test Listeners/ (Lắng nghe sự kiện thực thi kiểm thử)
|-- Reports/ (Báo cáo và nhật ký thực thi)
```

---

## Các Trường Hợp Kiểm Thử Được Tự Động Hóa
Các trường hợp kiểm thử sau đã được tự động hóa:

1. **Tìm kiếm với đầu vào hợp lệ khớp với dữ liệu trong cơ sở dữ liệu**
2. **Tìm kiếm với đầu vào không hợp lệ không khớp với dữ liệu trong cơ sở dữ liệu**
3. **Tìm kiếm với từ khóa chứa khoảng trắng**
4. **Tìm kiếm khi bỏ trống từ khóa**

Các trường hợp này được chọn vì tầm quan trọng của chúng trong việc đảm bảo tính chính xác của chức năng tìm kiếm và sự phù hợp của chúng cho tự động hóa.
Chỗ này em đã viết ra ý tưởng trong sheet Test Strategy

---

## Cài Đặt và Cấu Hình

### Bước 1: Sao Chép Kho Lưu Trữ
```bash
git clone <repository-url>
cd automation-framework
```

### Bước 2: Mở Dự Án Trong Katalon Studio
1. Mở Katalon Studio.
2. Chọn `File > Open Project`.
3. Điều hướng đến thư mục kho lưu trữ đã sao chép và mở tệp dự án.

### Bước 3: Cấu Hình Dữ Liệu Kiểm Thử
- Thay đổi data đầu vào qua file excel nằm trong thư mục Data files/ExcelFile

### Bước 4: Cài Đặt Trình Điều Khiển Trình Duyệt
Đảm bảo WebDriver phù hợp đã được cài đặt và sẵn sàng trong đường dẫn hệ thống của bạn.
---

## Thực Thi Kiểm Thử

### Lựa Chọn 1: Thực Thi Từ Katalon Studio
1. Mở `Test Suite` trong Katalon Studio.
2. Nhấn nút `Run` và chọn trình duyệt mong muốn.
3. 
### Lựa Chọn 2: Tích Hợp Liên Tục (CI)
Tích hợp khung kiểm thử với đường ống CI/CD của bạn để thực thi tự động khi có thay đổi mã nguồn.

---

## Báo Cáo
- Kết quả thực thi kiểm thử được lưu trong thư mục `reports/`.
- Sử dụng các tính năng báo cáo tích hợp của Katalon hoặc tích hợp với các công cụ báo cáo bên thứ ba như Allure để có báo cáo nâng cao.

---

## Bảo Trì
- Cập nhật các lớp Đối tượng Trang nếu giao diện người dùng thay đổi.
- Xem xét và cập nhật dữ liệu kiểm thử định kỳ để đảm bảo tính phù hợp.
- Thường xuyên tối ưu hóa và cải tiến tập lệnh kiểm thử để xử lý các trường hợp biên và cải thiện tính dễ đọc.

---

## Hỗ Trợ
Nếu bạn gặp vấn đề hoặc có thắc mắc, vui lòng liên hệ với tôi hoặc tham khảo tài liệu của Katalon Studio tại [Katalon Docs](https://docs.katalon.com/).
