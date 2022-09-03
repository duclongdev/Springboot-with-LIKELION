# Đề bài
### Tạo project sử dụng JPA + H2 DB (Có sử dụng Lombok)
#### 1. Tạo 2 entity Department và Employee
    - Department gồm: departmentId | dept_name | description |employees
    - Employee gồm: employeeId | name | birthDate | gender |departmentId
    - Sử dụng annotation để thể hiện quan hệ 1 - n giữa Departmentvà Employee
#### 2. Tạo RESTful API cho 2 entity với các chức năng CURD, lưu ý thể hiện đủ 3 tầng
    - Thực hiện gọi function tạo data cho Department trước để có khóa id tạo cho Employee
    - Khi thực hiện gọi function tạo data cho Employee dùng id củaDepartment được truyền vào từ client
#### 3. Tại controller Department tạo 1 function có thể get một Department theo id và chứa tất cả các Employee có khóa quan hệ tương ứng
#### 4. Tại controller Employee tạo 1 function có thể get tất cả các Employee và chứa Department với khóa ngoại tương ứng (có thể là departmentId hoặc object Department)
#### 5. Gọi 1 function xóa Department và xóa các Employee có khóa tương ứng
#### Chú ý:
    . Cấu trúc project, tên biến, hàm... đều phải có ý nghĩa, sắpxếp đẹp
    . Vận dụng các annotations trong spring boot không chỉ giớihạn trong slide bài học
    . Sử dụng Github để push code lên, Gửi link Github sau khihoàn thành bài làm, lưu ý để public
    . Team đào tạo sẽ tìm ra bài tốt nhất và sớm nhất để làm mẫucho những bạn chưa xong, lưu ý là tự làm trước khi tham khảobài người khác
    . Team đào tạo sẽ hỗ trợ các bạn xem bài và góp ý nếu có vấnđề hoặc để hoàn thiện hơn
