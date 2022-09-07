
# Homeworks week 3 part 2
## Đề bài
### [1. Cấu hình ứng dụng với các thuộc tính sau](#1-cấu-hình-ứng-dụng-với-các-thuộc-tính)
- `port`: 9081
- Đường dẫn ứng dụng: likelion
- Tạo một pattern logging: pattern có thể tự chọn
- Cài đặt level của loggin là `trace`
### 2. Tạo 2 dto chứa các thuộc tính sau và sử dụng các annotation thực hiện validation
- `EmployeeDto` gồm:
  + employeeId
  + name: không được rỗng, độ dài từ 10 đến 50 kí tự
  + birthDate
  + gender
  + email: không được rỗng và đúng với format gmail
- `DepartmentDto` gồm:
  + departmentId
  + deptName: không được rỗng, độ dài từ 10 đến 50 kí tự
  + description: không được rỗng
- Tạo api để test valid `employeeDto`
- Tạo api để test valid departmentDto. Lưu ý phải valid được các thuộc tính trong `List<employeeDto>`
- ### 3. Tạo hai service tương ứng với hai dto tại (3). Mỗi service tạo một method tương ứng với dto
- `EmployeeDto` **getEmployeeDto**(`EmployeeDto` employeeDto): xử lí trả về dto là đối số truyền vào
- `DepartmentDto` **getDepartmentDto**(`DepartmentDto` departmentDto): xử lí trả về dto là đối số truyền vào
- Mỗi service tạo một `Logger` và logging đối số truyền vào khi gọi method
- Ứng dụng AOP để logging như sau
  + logging trước và sau khi gọi method **getDepartmentDto**: nội dụng logging tùy chọn
  + logging sau khi gọi method **getEmployeeDto** không thành công: nội dụng logging tùy chọn
## Bài làm
### 1. Cấu hình ứng dụng với các thuộc tính
#### 1, 2. Port: 9081 + Đường dẫn ứng dụng: likelion
![My image](/home/long/Pictures/Screenshots/Screenshot from 2022-09-08 00-44-21.png)
#### 3. Tạo một pattern logging: pattern có thể tự chọn
```properties
logging.pattern.console=%d{yyyy-MM-dd HH:mm:ss.SSS} %5p 18737 --- [%t] %-40.40logger{39} : %m%n%wEx
```
##### Kết quả
![img.png](img.png)
### 3. Cài đặt level của loggin là trace 
```properties
logging.level.root=TRACE
```
#### Kết quả
![img_1.png](img_1.png)
## 2. Tạo 2 dto chứa các thuộc tính sau và sử dụng các annotation thực hiện validation
#### 1. EmployeeDto
```java
@Data
public class EmployeeDto {
    private Long employee_id;
    @NotBlank(message = "{validation.not_blank}")
    @Size(min = 20, message = "{validation.employee.name.size.too_short}")
    @Size(max = 50, message = "validation")
    private String employeeName;
    private Date birthDate;
    private boolean gender;
    @Email(message = "{validation.employee.email}")
    private String email;
}
```
#### 2. DepartmentDto
```java
@Data
public class DepartmentDto {
    Long departmentId;
    @NotBlank(message = "{validation.not_blank}")
    @Size(min = 20, message = "{validation.department.name.size.too_short}")
    @Size(max = 50, message = "{validation.department.name.size.too_long}")
    String depName;
    @NotBlank(message = "{validation.not_blank}")
    String description;
    @Valid
    List<EmployeeDto> employeeDtoList;
}
```
#### 3. Tạo api để test valid `employeeDto`
 - url: `POST` - http://localhost:9081/likelion/api/emp/testValid 
 - TEST:
   - Để trống employeeName:
     - RequestBody 
 ```json
{
    "employee_id": 1,
    "employeeName": "",
    "birthDate": null,
    "gender": 1,
    "email": "duclong@gm.com"
}
```
- Response: 
```json
{
    "employeeName": "Filed not be blank"
}
```
- Tên dưới 20 ký tự:
  - RequestBody
```json
{
    "employee_id": 1,
    "employeeName": "long",
    "birthDate": null,
    "gender": 1,
    "email": "duclong@gm.com"
}
```
- Response: 
```json
{
    "employeeName": "Employee name must be greater than 20 character"
}
```
- Tên lớn hơn 50 ký tự:
  - RequestBody
```json
{
  "employee_id": 1,
  "employeeName": "In software engineering, a design pattern is a general repeatable solution to a commonly occurring problem in software design",
  "birthDate": null,
  "gender": 1,
  "email": "duclong@gm.com"
}
```
- Response:
```json
{
  "employeeName": "Employee name must be less than 50 character"
}
```
- Email không hợp lệ:
  - RequestBody
```json
{
  "employee_id": 1,
  "employeeName": "Nguyen Duc Long",
  "birthDate": null,
  "gender": 1,
  "email": "duclongcom"
}
```
- Response:
```json
{
  "email": "Invalid email!!"
}
```
#### 4. Tạo api để test valid departmentDto. Lưu ý phải valid được các thuộc tính trong `List<employeeDto>`
- url: `POST` - http://localhost:9081/likelion/api/dep/testValid
- TEST:
  - Để trống departmentName:
    - RequestBody
 ```json
{
  "departmentId": 1,
  "depName": "",
  "description": "ho tro sinh vien",
  "employeeDtoList": [
    {
      "employee_id": 1,
      "employeeName": "duc long nguyen",
      "birthDate": null,
      "gender": 1,
      "email": "nguyen@gm.com"
    },
    {
      "employee_id": 2,
      "employeeName": "Nguyen Duc Long",
      "birthDate": null,
      "gender": 1,
      "email": "long@gm.côm"
    }
  ]
}
```
- Response:
```json
{
  "depName": "Filed not blank"
}
```
- Tên dưới 20 ký tự:
  - RequestBody
```json
{
  "departmentId": 1,
  "depName": "CTSV",
  "description": "ho tro sinh vien",
  "employeeDtoList": [
    {
      "employee_id": 1,
      "employeeName": "duc long nguyen",
      "birthDate": null,
      "gender": 1,
      "email": "nguyen@gm.com"
    },
    {
      "employee_id": 2,
      "employeeName": "Nguyen Duc Long",
      "birthDate": null,
      "gender": 1,
      "email": "long@gm.côm"
    }
  ]
}
```
- Response:
```json
{
  "depName": "Department name must be greater than 20 character"
}
```
- Tên lớn hơn 50 ký tự:
  - RequestBody
```json
{
  "departmentId": 1,
  "depName": "In software engineering, a design pattern is a general repeatable solution to a commonly occurring problem in software design",
  "description": "ho tro sinh vien",
  "employeeDtoList": [
    {
      "employee_id": 1,
      "employeeName": "duc long nguyen",
      "birthDate": null,
      "gender": 1,
      "email": "nguyen@gm.com"
    },
    {
      "employee_id": 2,
      "employeeName": "Nguyen Duc Long",
      "birthDate": null,
      "gender": 1,
      "email": "long@gm.côm"
    }
  ]
}
```
- Response:
```json
{
  "depName": "Department name must be less than 50 character"
}
```
- Valid các thuộc tính trong `List<employeeDto>`
  - RequestBody:
```json
{
    "departmentId": 1,
    "depName": "cong tac sinh vien",
    "description": "ho tro sinh vien",
    "employeeDtoList": [
        {
            "employee_id": 1,
            "employeeName": "duc",
            "birthDate": null,
            "gender": 1,
            "email": "nguyen@gm.com"
        },
        {
            "employee_id": 2,
            "employeeName": "Nguyen Duc Long",
            "birthDate": null,
            "gender": 1,
            "email": "long"
        }
    ]
}
```
- Response
```json
{
    "employeeDtoList[0].employeeName": "Employee name must be greater than 10 character",
    "employeeDtoList[1].email": "Invalid email!!"
}
```
