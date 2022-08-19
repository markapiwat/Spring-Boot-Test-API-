# SSO 

git repository for pccth sso api 

สิ่งที่ต้องใช้ในการพัฒนา 

Java 11 or above
Postgres 14.4.1

ขั้นตอนการติดตั้ง

1. ดาวน์โหลดและติดตั้ง OpenJDK11 หรือ เวอร์ชั่นที่สูงกว่า
2. ดาวน์โหลดและติดตั้ง postgreSQL ลิ้งค์ดาวน์โหลด : (https://www.postgresqltutorial.com/postgresql-getting-started/install-postgresql/)
3. เปิด SQL Shell tool และ ล็อคอินเข้าสู่ฐานข้อมูลในข้อ 2
4. ป้อนคำสั่งและดำเนินการตั้งต่อไปนี้ 
    4.1. สร้างฐานข้อมูลในชื่อ "ssotest" ถ้าหากไม่มี 
    4.2. สร้างผู้ใช้ในชื่อ "ssodev" และ ตั้งรหัสเป็น "sso2022ok"  
    4.3. ทำการให้สิทธิ์ทุกอย่างในการจัดการฐานข้อมูลกับผู้ใข้ "ssodev" ด้วย คำสั่ง grant all privileges on database ssotest to ssodev;
5. โคลนโปรเจคจาก main branch
6. เปิดโปรเจคใน IDE และ แก้ไข dependencies ทุกตัวให้ใช้ได้ 
7. เท่านี้โปรเจคพร้อมที่จะรันได้แล้ว 
 
การรันและการทดสอบ 
1. เมื่อรันโปรเจค สคริป SQL จะทำการสร้างตารางที่ต้องการ ถ้าหากยังไม่มีตารางที่ต้องการ
2. เข้าไปที่ http://localhost:8080/swagger-ui/index.html 
3. หน้าเว็บไซต์จะแสดงตามรูป 
![image](https://user-images.githubusercontent.com/111260577/185652871-ada09367-dcd8-418e-a671-b2e809636f79.png)



