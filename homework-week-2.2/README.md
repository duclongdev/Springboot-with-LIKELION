# homework-with-LIKELION-w2.2
## Đề bài
![image](https://user-images.githubusercontent.com/108172013/188268037-adac9ec0-7c46-467c-b257-8365eafb0a09.png)

#### Tại Controller Department tạo một fuction có thể get Department và tổng số employee tương ứng dùng -> mybatis:   http://localhost:8080/department/countEmployee/1
```json
//lấy số lượng
{
    "department_id": 1,
    "dept_name": "CTSV",
    "description": "Hỗ trợ sinh viên",
    "count": 3
}
//lấy chi tiết
{
    "department_id": 1,
    "dept_name": "CTSV",
    "description": "Hỗ trợ sinh viên",
    "employees": [
        {
            "employee_id": 2,
            "employ_name": "duc long",
            "birth_date": "2000-03-16T17:00:00.000+00:00",
            "gender": "Nam"
        },
        {
            "employee_id": 3,
            "employ_name": "duc long",
            "birth_date": "2000-03-16T17:00:00.000+00:00",
            "gender": "Nam"
        },
        {
            "employee_id": 5,
            "employ_name": "duc long",
            "birth_date": "2000-03-16T17:00:00.000+00:00",
            "gender": "Nam"
        }
    ]
}
```
#### tại controller Employee tạo một fuction có thể get một Employee và một thông tin object Department tương ứng -> dùng Mybatis http://localhost:8080/department/getById/1
```json
{
    "employee_id": 5,
    "employ_name": "duc long",
    "birth_date": "2000-03-16T17:00:00.000+00:00",
    "gender": "Nam",
    "department_id": 1,
    "dept_name": "CTSV",
    "description": "Hỗ trợ sinh viên"
}
```
#### factory + singleton design pattern 
![image](https://user-images.githubusercontent.com/108172013/187026675-ef36039c-c25a-4d01-a87c-d81a749aed23.png)



