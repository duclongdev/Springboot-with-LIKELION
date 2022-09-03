# Đề bài
Tạo một project spring boot kết hợp MVC + Three Tier gồm các yêu cầu sau:
#### 1. Sử dụng các anntations trong spring boot để tạo mô hình MVC + Three Tier
#### 2 Mô tả chức năng ứng dụng:
    . 1 chức năng trả về danh sách đối tượng dưới dạng template
    . 2 chức năng trả về một đối tượng bằng id dưới dạng Json
##### Gợi ý các bước thực hiện:
    Tạo 2 function tại controller
        . function 1: trả về template(HTML, gợi ý sử dụng   Thymeleaf) 
            + Tại tầng repository: tạo một danh sách đối    tượng thông tin như sau: Id | Tên | Tuổi | Sở   Thích.
                - Tạo >= 5 đối tượng và được lưu vào list.
                - Lưu ý sử dụng data tĩnh, tự tạo bằng tay  ko cần dùng database.
            + Tại tầng service: viết chức năng sắp xếp  giảm dần bởi tuổi từ danh sách dữ liệu lấy từ tầng repository và trả về list sau khi sắp xếp.
            + Tại function 1 trong controller: lấy danh sách dữ liệu đã được xử lí từ tầng service trả   về client bằng template(HTML có danh sách đối  tượng)
            + Tại template HTML: tạo table thể hiện danh    sách đối tượng từ controller
        . function 2: trả về đối tượng dưới dạng Json bằng  Id được truyền vào khi gọi function, sử dụng lại  các tầng service và repository được tạo khi thực  hiện ở function 1
            + Lưu ý: function 2 được tạo trong cùng một controller với function 1
#### 3. Chú ý:
    . Cấu trúc project, tên biến, hàm... đều phải có ý nghĩa, sắp xếp đẹp
    . Vận dụng các annotations trong spring bookhông chỉ giới hạn trong slide bài học
    . Sử dụng Github để push code lên, Gửi linGithub sau khi hoàn thành bài làm, lưu ý đpublic
    . Team đào tạo sẽ tìm ra bài tốt nhất và sớm nhất để làm mẫu cho những bạn chưa xong, lưu là tự làm trước khi tham khảo bài người khác
    . Team đào tạo sẽ hỗ trợ các bạn xem bài và góp ý nếu có vấn đề hoặc để hoàn thiện hơn
