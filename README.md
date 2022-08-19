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
4. ขยาย sso-user-controller และ เลือก gettoken
![image](https://user-images.githubusercontent.com/111260577/185653558-80f8fcaa-5ecd-4bd2-93bb-30dd29de52ba.png)
5. กดที่ปุ่ม Try it out จะได้หน้าตาแบบในรูป
![image](https://user-images.githubusercontent.com/111260577/185653918-54024462-fb2f-40ba-aa66-c8017aec1600.png)
6. ให้ใส่ Request แบบ JSON ลงไปในช่อง Request body และจากนั้นให้ กดที่ปุ่ม Execute 
    6.1 ข้อมูลที่ใช้ในการ Request :
        { 
                "ssoType": "SSOData", 
                "systemId": "VATDEDEV", 
                "systemName": "ระบบบันทึกข้อมูลภาษีมูลค่าเพิ่มทดสอบ)", 
                "systemTransactions": "PRIV-010,PRIV-020,PRIV-040,PRIV-050", 
                "systemPrivileges": "0|0|0|0", 
                "systemUserGroup": "GRP-010,GRP-020,GRP-040", 
                "systemLocationGroup": "CliC001", 
                "userId": "WS233999", 
                "userFullName": "ประสาท จันทร์อังคาร ", 
                "userRdOfficeCode": "01000999", 
                "userOfficeCode": "01001139", 
                "clientLocation": "01001139", 
                "locationMachineNumber": "CLI00000718-9999", 
                "tokenId":  "eyJzdWIiOiIxMjM0IiwiYXVkIjpbImFkbWluIl0sImlzcyI6Im1hc29uLm1ldGFtdWcubmV0IiwiZXhwIjoxNTc0NTEyNzY1LCJpYXQiOjE1NjY3MzY3NjUsImp0aSI6ImY3YmZlMzNmLTdiZjctNGViNC04ZTU5LTk5MTc5OWI1ZWI4YSJ9" 
        }
        
7. เมื่อทำการส่ง Request ตามข้อที่ 6 ไปแล้ว api ส่งResponse กลับมาตามรูปด้านล่าง
![image](https://user-images.githubusercontent.com/111260577/185655489-8e013a40-ae7f-4e15-943a-d29917302e77.png)
        
 จบขั้นตอนการรันและการทดสอบ

 



