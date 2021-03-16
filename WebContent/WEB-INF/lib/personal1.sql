CREATE DATABASE personer1
GO
USE personer1
GO
CREATE TABLE users (
username NVARCHAR(50) PRIMARY KEY,
pass NVARCHAR(50) NOT NULL,
fullname NVARCHAR(50) NOT NULL
)
CREATE TABLE departs(
id NVARCHAR(10) PRIMARY KEY ,
name NVARCHAR(50) NOT NULL
)
 ALTER TABLE dbo.users ADD role BIT 
 CREATE TABLE salarys(
 id NVARCHAR(20) NOT NULL PRIMARY KEY,
 basic_salary float  NOT NULL,
   allowance FLOAT NOT NULL,
  salary_factor float  NOT NULL
 )
 CREATE TABLE staffs(
 id NVARCHAR(10) PRIMARY KEY,
 name NVARCHAR(50) NOT NULL, 
 gender BIT NOT NULL,
 birthday DATE NOT NULL,
 photo NVARCHAR(50),
 email NVARCHAR(50) NOT NULL,
 phone NVARCHAR(50) NOT NULL,
 notes NVARCHAR(500) NULL,
 departid NVARCHAR(10) FOREIGN KEY REFERENCES dbo.departs(id),
 salaryid NVARCHAR(20) FOREIGN KEY REFERENCES dbo.salarys(id)

 )
DROP TABLE dbo.staffs
 SELECT * FROM dbo.staffs
 ALTER TABLE dbo.staffs ADD FOREIGN KEY (id)  REFERENCES salary(id)

 CREATE TABLE records(
 id BIGINT PRIMARY KEY IDENTITY,
 type BIT NOT NULL,
 reason NVARCHAR(200) NOT NULL,
 date DATE NOT NULL,
 staffid NVARCHAR(10) FOREIGN KEY REFERENCES dbo.staffs(id)
 )

 CREATE TABLE dependents(
 id NVARCHAR(20) PRIMARY KEY NOT NULL,
 name NVARCHAR(20) NOT NULL,
 gender BIT NOT NULL,
 birthday DATE NOT NULL,
 relationship NVARCHAR(50) NOT NULL,
 staffid NVARCHAR(10) FOREIGN KEY REFERENCES dbo.staffs(id)

 )
 CREATE TABLE labor_contract(
 id NVARCHAR(20) PRIMARY KEY NOT NULL,
 type_contract NVARCHAR(20),
 from_date DATE,
 to_date  DATE,
 staffid NVARCHAR(10) FOREIGN KEY REFERENCES dbo.staffs(id)
 
 )
 
	
 SELECT * FROM dbo.departs
  SELECT * FROM dbo.records
  SELECT * FROM dbo.users
   SELECT * FROM dbo.departs
      SELECT * FROM dbo.staffs           SELECT * FROM dbo.staffs WHERE name LIKE N'%Đức%'
	       SELECT * FROM dbo.dependents
	  SELECT * FROM dbo.labor_contract
	 DELETE FROM dbo.users
	  INSERT INTO dbo.users
         ( username, pass, fullname,role )
 VALUES  ( N'tunganhle',N'tung123',N'Lê Anh Tùng',1 ),
  ( N'tranthanhnhan',N'nhan123',N'Trần Thanh Nhàn',1 ),
   ( N'hathuthao',N'thao123',N'Hà Thu Thảo',1 ),
     ( N'admin',N'admin',N'admin',0 )
          

		  INSERT INTO dbo.staffs
		          ( id ,
		            name ,
		            gender ,
		            birthday ,
		            photo ,
		            email ,
		            phone ,
		            notes ,
		            departid ,
		            salaryid
		          )
		  VALUES  
		   ( N'PH001' ,N'Lê Quỳnh Anh',0,'12/12/2000' ,NULL,'anh@gmail.com','0987341234',N'Xinh Gái','P001',N'Bậc 2'),
		  ( N'PH002' ,N'Nguyễn An Nhi',0,'10/11/2000' ,NULL,'nhi@gmail.com','0987341222',N'Trắng','P002',N'Bậc 3'),
		  ( N'PH003' ,N'Lê Hạ Thu',0,'11/10/2000' ,NULL,'thu@gmail.com','0987341333',N'Cute','P003',N'Bậc 4')

		  ( N'PH006' ,N'Nguyễn Bá Quang',1,'2/10/2000' ,'face1.jpg','quang@gmail.com','
		  0953652555','Cao','P003',N'Bậc 1'),
		          
		
		  INSERT INTO dbo.labor_contract
		          ( id ,
		            type_contract ,
		            from_date ,
		            to_date ,
		            staffid
		          )
		  VALUES  ( N'HD001' ,N'Có thời hạn','12/12/2019','10/04/2021','PH001' ),
		   ( N'HD002' ,N'Có thời hạn','10/12/2019','08/04/2022','PH002' ),
		    ( N'HD003' ,N'Có thời hạn','11/12/2019','05/05/2021','PH003' ),
		           
		
		  
		          
		          UPDATE staffs SET photo ='face2.jpg' WHERE id='Ph001'

				  INSERT INTO dbo.dependents
				          ( id ,
				            name ,
				            gender ,
				            birthday ,
				            relationship ,
				            staffid
				          )
				  VALUES  ( N'T001' ,N'Nguyễn Văn Đoàn',1,'12/12/1977',N'Bố',N'PH001'),
				  ( N'T002' ,N'Nguyễn Hữu Vân',1,'9/8/1977',N'Bố',N'PH002'),
				  ( N'T003' ,N'Ngô Thu Hường',0,'10/12/1977',N'Mẹ',N'PH003')
				       
				  
				  INSERT INTO dbo.salarys
				          ( id ,
				            basic_salary ,
				            allowance ,
				            salary_factor
				          )
				  VALUES  ( N'Bậc 1' ,5000000,1000000,2.34),
				  ( N'Bậc 2' ,10000000,2000000,2.34),
				  ( N'Bậc 3' ,20000000,4000000,2.34),
				  ( N'Bậc 4' ,30000000,6000000,2.34),
				    ( N'Bậc 5' ,40000000,8000000,2.34),
				           
				          
				  INSERT INTO dbo.departs
				          ( id, name )
				  VALUES  ( N'P001', N'Hành Chính'),
				          ( N'P002', N'IT'),  
						   ( N'P003', N'Giám Đốc')
						
						   INSERT INTO dbo.records
						           ( type, reason, date, staffid )
						   VALUES  ( 1,N'Đẹp Trai','6/6/2000',N'Ph001'),
						   (2,N'Chăm Chỉ','6/4/2020',N'PH002'),
						   (3 ,N'Tích Cực','7/5/2020','PH003')

						   SELECT * FROM dbo.users
						   SELECT * FROM dbo.salarys
						    SELECT * FROM dbo.staffs
						   SELECT * FROM dbo.records
						      SELECT * FROM dbo.departs
							  SELECT * FROM dbo.dependents
							  SELECT * FROM dbo.labor_contract
						   SELECT staffid , SUM(CASE WHEN type=1 THEN 1 ELSE 0 END)  ,SUM(CASE WHEN type=0 THEN 1 ELSE 0 END) FROM dbo.records GROUP BY staffid
						   SELECT COUNT(type),staffid FROM dbo.records  GROUP BY staffid
						SELECT GETDATE()
						   SELECT name,DATEDIFF(DAY,GETDATE(),to_date) FROM dbo.staffs JOIN dbo.labor_contract ON labor_contract.staffid = staffs.id 

						   SELECT ROW_NUMBER() OVER (ORDER BY  SUM(CASE WHEN type=1 THEN 1 ELSE 0 END) -SUM(CASE WHEN type=0 THEN 1 ELSE 0 END) DESC)
						   ,photo,dbo.staffs.name,dbo.departs.name,SUM(CASE WHEN type=1 THEN 1 ELSE 0 END) -SUM(CASE WHEN type=0 THEN 1 ELSE 0 END) 
							FROM dbo.staffs JOIN dbo.departs ON departs.id = staffs.departid JOIN dbo.records ON records.staffid = staffs.id 
							GROUP BY photo,dbo.staffs.name,dbo.departs.name ORDER BY  SUM(CASE WHEN type=1 THEN 1 ELSE 0 END) -SUM(CASE WHEN type=0 THEN 1 ELSE 0 END) DESC
							SELECT * FROM dbo.records
                           SELECT  COUNT(dbo.records.id) FROM records  WHERE staffid ='PH0010'AND type=1
						             
				SELECT dbo.staffs.id,dbo.staffs.name,dbo.staffs.email,dbo.staffs.gender	,
				SUM(basic_salary*salary_factor+allowance) FROM dbo.staffs JOIN dbo.salarys 
				ON salarys.id = staffs.salaryid GROUP BY staffs.id,name,dbo.staffs.email,dbo.staffs.gender

				SELECT * FROM dbo.staffs
				DELETE dbo.staffs WHERE id ='#@#@#@'
				INSERT INTO dbo.users
				        ( username, pass, fullname, role )
				VALUES  ( N'tung@gmail.com','tung123','Le Anh Tung',0)
				INSERT INTO dbo.users
				        ( username, pass, fullname )
				VALUES  ( N'ssas', -- username - nvarchar(50)
				          N'tung123', -- pass - nvarchar(50)
				          N'ttttttttttttttttttttttttttttttttttttttttttttttttt'  -- fullname - nvarchar(50)
				          )
						  DELETE dbo.users WHERE username ='ssas'
						  UPDATE dbo.users set username ='dang@gmail.com'

						  INSERT INTO dbo.records
						          ( type, reason, date, staffid )
						  VALUES  ( 'true', -- type - bit
						            N'tttttttttttttttttttttttttttttttttttttttttttttttttt
				tttttttttttttttttttttttttttttttttttttttttttttttttt
			    tttttttttttttttttttttttttttttttttttttttttttttttttt
				',-- reason - nvarchar(200)
						            '12-12-2000', -- date - date
						            N'PH001'  -- staffid - nvarchar(10)
						            )
									UPDATE dbo.users SET fullname =null WHERE username='dang@gmail.com'
									INSERT dbo.departs 
									        ( id, name )
									VALUES  ( N'P007', -- id - nvarchar(10)
									          N'Nhà Ăn'  -- name - nvarchar(50)
									          )