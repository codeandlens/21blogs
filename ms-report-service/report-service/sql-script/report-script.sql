--BRANCH;
INSERT INTO BRANCH (ID, BRANCH_CODE, BRANCH_NAME_TH, BRANCH_NAME_EN, BRANCH_ADDRESS, BRANCH_TEL, LINK_MAP, MAP_PHOTO, BRANCH_PHOTO,START_OFFICE_HOUR ,END_OFFICE_HOUR ,TIME_ZONE, LAST_MODIFIED_DATE ) VALUES(1, 'Phraeksa.1', 'สาขาแพรกษา', 'Phraeksa', '998/110-111 ตลาดสดเจเอสพี ถนนแพรกษา ตำบลแพรกษา อำเภอเมือง สมุทรปราการ 10280', '0632359094', 'https://g.page/Emmaclinicthailland?share', null, null,'10:00','19:00','ASIA/BANGKOK', CURRENT_DATE);
INSERT INTO BRANCH (ID, BRANCH_CODE, BRANCH_NAME_TH, BRANCH_NAME_EN, BRANCH_ADDRESS, BRANCH_TEL, LINK_MAP, MAP_PHOTO, BRANCH_PHOTO,START_OFFICE_HOUR ,END_OFFICE_HOUR ,TIME_ZONE, LAST_MODIFIED_DATE) VALUES(2, 'Asoke.2', 'สาขาอโศก', 'Asoke', '299/10 อาคารสุขุมวิทลิฟวิ่งทาวน์ ถนนสุขุมวิท21 แขวงคลองเตยเเหนือ เขตวัฒนา กรุงเทพมหานคร 10110', '0957462823', 'https://g.page/EmmaclinicAsoke?share', null, null,'10:00','19:00','ASIA/BANGKOK', CURRENT_DATE);
INSERT INTO BRANCH (ID, BRANCH_CODE, BRANCH_NAME_TH, BRANCH_NAME_EN, BRANCH_ADDRESS, BRANCH_TEL, LINK_MAP, MAP_PHOTO, BRANCH_PHOTO,START_OFFICE_HOUR ,END_OFFICE_HOUR ,TIME_ZONE, LAST_MODIFIED_DATE) VALUES(3, 'Rama 2.3', 'สาขาพระราม 2', 'Rama 2', '129/328-329 ถนนบางขุนเทียน แขวงแสมดำ เขตบางขุนเทียน กรุงเทพมหานคร 10150', '0641922823', 'https://g.page/emma-clinic-rama2?share', null, null,'10:00','19:00','ASIA/BANGKOK', CURRENT_DATE);
INSERT INTO BRANCH (ID, BRANCH_CODE, BRANCH_NAME_TH, BRANCH_NAME_EN, BRANCH_ADDRESS, BRANCH_TEL, LINK_MAP, MAP_PHOTO, BRANCH_PHOTO,START_OFFICE_HOUR ,END_OFFICE_HOUR ,TIME_ZONE, LAST_MODIFIED_DATE) VALUES(4, 'Sukhumvit.4', 'สาขาสุขุมวิท', 'Sukhumvit', '903-905 ถ.สุขุมวิท แขวงคลองตันเหนือ เขตวัฒนา กรุงเทพฯ 10110', '0802592599', 'https://goo.gl/maps/DCpZMyqhEuo4MKpL8', null, null,'10:00','19:00','ASIA/BANGKOK', CURRENT_DATE);
INSERT INTO BRANCH (ID, BRANCH_CODE, BRANCH_NAME_TH, BRANCH_NAME_EN, BRANCH_ADDRESS, BRANCH_TEL, LINK_MAP, MAP_PHOTO, BRANCH_PHOTO,START_OFFICE_HOUR ,END_OFFICE_HOUR ,TIME_ZONE, LAST_MODIFIED_DATE) VALUES(5, 'Ladprao.5', 'สาขาลาดพร้าว', 'Ladprao', '2993 ถนนลาดพร้าว แขวงคลองจั่น เขตบางกระปิ กรุงเทพมหานคร 10240', '0885594466', 'https://goo.gl/maps/g1EA3PTUzxs1a2ocA', null, null,'10:00','19:00','ASIA/BANGKOK', CURRENT_DATE);
INSERT INTO BRANCH (ID, BRANCH_CODE, BRANCH_NAME_TH, BRANCH_NAME_EN, BRANCH_ADDRESS, BRANCH_TEL, LINK_MAP, MAP_PHOTO, BRANCH_PHOTO,START_OFFICE_HOUR ,END_OFFICE_HOUR ,TIME_ZONE, LAST_MODIFIED_DATE ) VALUES(6, 'Chonburi.6', 'สาขาชลบุรี', 'Chonburi', '76/8 หมู่ที่ 3 ถนนสุขุมวิท ตำบลเสม็ด อ.เมืองชลบุรี จ.ชลบุรี 20000', null, 'https://goo.gl/maps/RUCyNMpTrq4pa4tX7', null, null,'10:00','19:00','ASIA/BANGKOK', CURRENT_DATE);


--APPOINTMENT;
INSERT INTO APPOINTMENT (ID, APPOINTMENT_TYPE, APPOINTMENT_TYPE_NAME_EN, APPOINTMENT_TYPE_NAME_TH, BOOKING_TYPE, CONTINUOUS_FLAG, MEDICAL_LICENSE, MIN_DAY, SERVICE_CLASS, WARRANTY_PERIOD_DAY, NEED_PAYMENT, LAST_MODIFIED_DATE)
VALUES (1, 'PROCEDURE_NOSE', 'NOSE SURGERY', 'ศัลยกรรมจมูก', 'PROCEDURE', 'Y', 'SURGERY', 0, 'GSG', 365, 'Y', CURRENT_DATE);
INSERT INTO APPOINTMENT (ID, APPOINTMENT_TYPE, APPOINTMENT_TYPE_NAME_EN, APPOINTMENT_TYPE_NAME_TH, BOOKING_TYPE, CONTINUOUS_FLAG, MEDICAL_LICENSE, MIN_DAY, SERVICE_CLASS, WARRANTY_PERIOD_DAY, NEED_PAYMENT, LAST_MODIFIED_DATE)
VALUES (2, 'PROCEDURE_CHIN', 'CHIN SURGERY', 'ศัลยกรรมคาง', 'PROCEDURE', 'Y', 'SURGERY', 0, 'GSG', 365, 'Y', CURRENT_DATE);
INSERT INTO APPOINTMENT (ID, APPOINTMENT_TYPE, APPOINTMENT_TYPE_NAME_EN, APPOINTMENT_TYPE_NAME_TH, BOOKING_TYPE, CONTINUOUS_FLAG, MEDICAL_LICENSE, MIN_DAY, SERVICE_CLASS, WARRANTY_PERIOD_DAY, NEED_PAYMENT, LAST_MODIFIED_DATE)
VALUES (3, 'FIXING_NOSE', 'NOSE FIXING', 'งานแก้ไขจมูก', 'PROCEDURE', 'Y', 'SURGERY', 0, 'GSG', 365,	'Y', CURRENT_DATE);
INSERT INTO APPOINTMENT (ID, APPOINTMENT_TYPE, APPOINTMENT_TYPE_NAME_EN, APPOINTMENT_TYPE_NAME_TH, BOOKING_TYPE, CONTINUOUS_FLAG, MEDICAL_LICENSE, MIN_DAY, SERVICE_CLASS, WARRANTY_PERIOD_DAY, NEED_PAYMENT, LAST_MODIFIED_DATE)
VALUES (4, 'FIXING_CHIN', 'CHIN FIXING', 'งานแก้ไขคาง', 'PROCEDURE', 'Y', 'SURGERY', 0, 'GSG', 365, 'Y', CURRENT_DATE);
INSERT INTO APPOINTMENT (ID, APPOINTMENT_TYPE, APPOINTMENT_TYPE_NAME_EN, APPOINTMENT_TYPE_NAME_TH, BOOKING_TYPE, CONTINUOUS_FLAG, MEDICAL_LICENSE, MIN_DAY, SERVICE_CLASS, WARRANTY_PERIOD_DAY, NEED_PAYMENT, LAST_MODIFIED_DATE)
VALUES (5, 'SKINCARE', 'SKINCARE', 'งานผิว', 'SKINCARE', 'N', 'SKIN', 0, 'GSK', 0, 'Y', CURRENT_DATE);
INSERT INTO APPOINTMENT (ID, APPOINTMENT_TYPE, APPOINTMENT_TYPE_NAME_EN, APPOINTMENT_TYPE_NAME_TH, BOOKING_TYPE, CONTINUOUS_FLAG, MEDICAL_LICENSE, MIN_DAY, SERVICE_CLASS, WARRANTY_PERIOD_DAY, NEED_PAYMENT, LAST_MODIFIED_DATE)
VALUES (6, 'CONSULT', 'CONSULT',  'ปรึกษา', 'CONSULT', 'N', 'CONFER' ,0,	'GDO', 0, 'N', CURRENT_DATE);
INSERT INTO APPOINTMENT (ID, APPOINTMENT_TYPE, APPOINTMENT_TYPE_NAME_EN, APPOINTMENT_TYPE_NAME_TH, BOOKING_TYPE, CONTINUOUS_FLAG, MEDICAL_LICENSE, MIN_DAY, SERVICE_CLASS, WARRANTY_PERIOD_DAY, NEED_PAYMENT, LAST_MODIFIED_DATE)
VALUES (7, 'FOLLOWUP', 'FOLLOW UP', 'นัดติดตาม', 'CONTINUOUS', 'N', 'SURGERY', 29,	'GDO', 0, 'N', CURRENT_DATE);
INSERT INTO APPOINTMENT (ID, APPOINTMENT_TYPE, APPOINTMENT_TYPE_NAME_EN, APPOINTMENT_TYPE_NAME_TH, BOOKING_TYPE, CONTINUOUS_FLAG, MEDICAL_LICENSE, MIN_DAY, SERVICE_CLASS, WARRANTY_PERIOD_DAY, NEED_PAYMENT, LAST_MODIFIED_DATE)
VALUES (8, 'STITCH_OFF', 'STITCH OFF', 'นัดตัดไหม', 'CONTINUOUS', 'N', 'SURGERY',	13, 'GOO', 0, 'N', CURRENT_DATE);
INSERT INTO APPOINTMENT (ID, APPOINTMENT_TYPE, APPOINTMENT_TYPE_NAME_EN, APPOINTMENT_TYPE_NAME_TH, BOOKING_TYPE, CONTINUOUS_FLAG, MEDICAL_LICENSE, MIN_DAY, SERVICE_CLASS, WARRANTY_PERIOD_DAY, NEED_PAYMENT, LAST_MODIFIED_DATE)
VALUES (9, 'WARRANTY_NOSE', 'WARRANTY NOSE', 'นัดแก้ไขจมูกในระยะประกัน', 'CONTINUOUS', 'Y', 'SURGERY', 29,	'GSG', 0, 'N', CURRENT_DATE);
INSERT INTO APPOINTMENT (ID, APPOINTMENT_TYPE, APPOINTMENT_TYPE_NAME_EN, APPOINTMENT_TYPE_NAME_TH, BOOKING_TYPE, CONTINUOUS_FLAG, MEDICAL_LICENSE, MIN_DAY, SERVICE_CLASS, WARRANTY_PERIOD_DAY, NEED_PAYMENT, LAST_MODIFIED_DATE)
VALUES (10, 'WARRANTY_CHIN', 'WARRANTY CHIN', 'นัดแก้ไขคางในระยะประกัน', 'CONTINUOUS', 'Y', 'SURGERY', 29, 'GSG', 0,	'N', CURRENT_DATE);

--MEDICAL_LICENSE;
INSERT INTO MEDICAL_LICENSE (ID, LICENSE, MEDICAL_LICENSE_NAME_TH, MEDICAL_LICENSE_NAME_EN, LAST_MODIFIED_DATE)
VALUES (1, 'SKIN', 'ผิว', 'SKIN_LICENSE', CURRENT_DATE);
INSERT INTO MEDICAL_LICENSE (ID, LICENSE, MEDICAL_LICENSE_NAME_TH, MEDICAL_LICENSE_NAME_EN, LAST_MODIFIED_DATE)
VALUES (2, 'SURGERY', 'งานเสริม', 'SURGERY_LICENSE', CURRENT_DATE);
INSERT INTO MEDICAL_LICENSE (ID, LICENSE, MEDICAL_LICENSE_NAME_TH, MEDICAL_LICENSE_NAME_EN, LAST_MODIFIED_DATE)
VALUES (3, 'CONFER', 'ปรึกษา', 'CONFER_LICENSE', CURRENT_DATE);


--DOCTOR;
INSERT INTO DOCTOR (ID, MEDICAL_LICENSE, CODE, DESCRIPTION, FIRST_NAME_EN, FIRST_NAME_TH, GENDER, LAST_NAME_EN,
LAST_NAME_TH, NICK_NAME, MEDICAL_LICENSE_NO, DOCTOR_SEQ, GENERAL_DOCTOR_OPERATION_EFFORT,
GENERAL_SKINCAR_EFFORT, GENERAL_SURGICAL_EFFORT, LAST_MODIFIED_DATE)
VALUES (1, 'SURGERY,CONFER', 'NassaratK.1', null, 'DR. NASSARAT', 'ณัศรัตน์',	'แพทย์หญิง', 'KULKIATPRASERT', 'กุลเกียรติประเสริฐ', 'คุณหมอ น้ำ', 'ว.44871', 1, 15, null, 60, CURRENT_DATE);
INSERT INTO DOCTOR (ID, MEDICAL_LICENSE, CODE, DESCRIPTION, FIRST_NAME_EN, FIRST_NAME_TH, GENDER, LAST_NAME_EN,
LAST_NAME_TH, NICK_NAME, MEDICAL_LICENSE_NO, DOCTOR_SEQ, GENERAL_DOCTOR_OPERATION_EFFORT,
GENERAL_SKINCAR_EFFORT, GENERAL_SURGICAL_EFFORT, LAST_MODIFIED_DATE)
VALUES (2, 'SURGERY,CONFER', 'AnanJ.2', null, 'DR. ANAN', 'อนันต์', 'นายแพทย์', 'JUNGSUWATTANANON', 'จึงสุวัฒนานนท์', 'คุณหมอ หนึ่ง', 'ว.43586', 2, 15, null, 60, CURRENT_DATE);
INSERT INTO DOCTOR (ID, MEDICAL_LICENSE, CODE, DESCRIPTION, FIRST_NAME_EN, FIRST_NAME_TH, GENDER, LAST_NAME_EN,
LAST_NAME_TH, NICK_NAME, MEDICAL_LICENSE_NO, DOCTOR_SEQ, GENERAL_DOCTOR_OPERATION_EFFORT,
GENERAL_SKINCAR_EFFORT, GENERAL_SURGICAL_EFFORT, LAST_MODIFIED_DATE)
VALUES (3, 'SURGERY,CONFER', 'KajornponK.3', null, 'DR. KAJORNPON', 'ขจรพล', 'นายแพทย์', 'KAJORN', 'ขจร', 'คุณหมอ พล', 'ว.45136', 3, 15, null, 60, CURRENT_DATE);
INSERT INTO DOCTOR (ID, MEDICAL_LICENSE, CODE, DESCRIPTION, FIRST_NAME_EN, FIRST_NAME_TH, GENDER, LAST_NAME_EN,
LAST_NAME_TH, NICK_NAME, MEDICAL_LICENSE_NO, DOCTOR_SEQ, GENERAL_DOCTOR_OPERATION_EFFORT,
GENERAL_SKINCAR_EFFORT, GENERAL_SURGICAL_EFFORT, LAST_MODIFIED_DATE)
VALUES (4, 'SURGERY,CONFER', 'KantinanS.4', null, 'DR. KANTINAN', 'กันตินันท์', 'แพทย์หญิง', 'SRISUWAN', 'ศรีสุวรรณ์', 'คุณหมอ เฟิร์น', 'ว.49709', 4, 15, null, 60, CURRENT_DATE);
INSERT INTO DOCTOR (ID, MEDICAL_LICENSE, CODE, DESCRIPTION, FIRST_NAME_EN, FIRST_NAME_TH, GENDER, LAST_NAME_EN,
LAST_NAME_TH, NICK_NAME, MEDICAL_LICENSE_NO, DOCTOR_SEQ, GENERAL_DOCTOR_OPERATION_EFFORT,
GENERAL_SKINCAR_EFFORT, GENERAL_SURGICAL_EFFORT, LAST_MODIFIED_DATE)
VALUES (5, 'SURGERY,CONFER', 'AmnatR.5', null, 'DR. AMNAT', 'อำนาจ', 'นายแพทย์', 'RATTANAWIPAPONG', 'รัตนวิภาพงศ์', 'คุณหมอ บิ๊ก', 'ว.50170', 5, 15, null, 60, CURRENT_DATE);
INSERT INTO DOCTOR (ID, MEDICAL_LICENSE, CODE, DESCRIPTION, FIRST_NAME_EN, FIRST_NAME_TH, GENDER, LAST_NAME_EN,
LAST_NAME_TH, NICK_NAME, MEDICAL_LICENSE_NO, DOCTOR_SEQ, GENERAL_DOCTOR_OPERATION_EFFORT,
GENERAL_SKINCAR_EFFORT, GENERAL_SURGICAL_EFFORT, LAST_MODIFIED_DATE)
VALUES (6, 'SURGERY,CONFER', 'NiparatS.6', null, 'DR. NIPARAT', 'นิภารัตน์', 'แพทย์หญิง', 'SRIPAI', 'ศรีไพร', 'คุณหมอ ปุ๊กปิ๊ก', 'ว.44682', 6,  15, null, 60, CURRENT_DATE);
INSERT INTO DOCTOR (ID, MEDICAL_LICENSE, CODE, DESCRIPTION, FIRST_NAME_EN, FIRST_NAME_TH, GENDER, LAST_NAME_EN,
LAST_NAME_TH, NICK_NAME, MEDICAL_LICENSE_NO, DOCTOR_SEQ, GENERAL_DOCTOR_OPERATION_EFFORT,
GENERAL_SKINCAR_EFFORT, GENERAL_SURGICAL_EFFORT, LAST_MODIFIED_DATE)
VALUES (7, 'SKIN,CONFER', 'KanokpornP.7', null, 'DR. KANOKPORN', 'กนกพร', 'แพทย์หญิง', 'POTISUWUN', 'โพธิสุวรรณ', 'คุณหมอ ออย', 'ว.35594', 10, 15, 60, null, CURRENT_DATE);
INSERT INTO DOCTOR (ID, MEDICAL_LICENSE, CODE, DESCRIPTION, FIRST_NAME_EN, FIRST_NAME_TH, GENDER, LAST_NAME_EN,
LAST_NAME_TH, NICK_NAME, MEDICAL_LICENSE_NO, DOCTOR_SEQ, GENERAL_DOCTOR_OPERATION_EFFORT,
GENERAL_SKINCAR_EFFORT, GENERAL_SURGICAL_EFFORT, LAST_MODIFIED_DATE)
VALUES (8, 'SKIN,CONFER', 'WoradejC.8', null, 'DR. WORADEJ', 'วรเดช', 'นายแพทย์', 'CHOKSANTANA', 'โชคสันธนา', 'คุณหมอ เปา', 'ว.57875', 12, 15, 60, null, CURRENT_DATE);
INSERT INTO DOCTOR (ID, MEDICAL_LICENSE, CODE, DESCRIPTION, FIRST_NAME_EN, FIRST_NAME_TH, GENDER, LAST_NAME_EN,
LAST_NAME_TH, NICK_NAME, MEDICAL_LICENSE_NO, DOCTOR_SEQ, GENERAL_DOCTOR_OPERATION_EFFORT,
GENERAL_SKINCAR_EFFORT, GENERAL_SURGICAL_EFFORT, LAST_MODIFIED_DATE)
VALUES (9, 'SKIN,CONFER', 'NaphawanC.9', null, 'DR. NAPHAWAN', 'นภาวรรณ', 'แพทย์หญิง', 'CHAVALAKUL', 'ชวาลากุล', 'คุณหมอ โฟม', 'ว.45505', 11, 15, 60, null, CURRENT_DATE);
INSERT INTO DOCTOR (ID, MEDICAL_LICENSE, CODE, DESCRIPTION, FIRST_NAME_EN, FIRST_NAME_TH, GENDER, LAST_NAME_EN,
LAST_NAME_TH, NICK_NAME, MEDICAL_LICENSE_NO, DOCTOR_SEQ, GENERAL_DOCTOR_OPERATION_EFFORT,
GENERAL_SKINCAR_EFFORT, GENERAL_SURGICAL_EFFORT, LAST_MODIFIED_DATE)
VALUES (10, 'SURGERY,CONFER', 'KanokpornP.10', null, 'DR. KRIT', 'กฤษฏิ์', 'นายแพทย์', 'CHANGJAROEN', 'แฉ่งเจริญ', 'คุณหมอ ตั้ม', 'ว.49904', 7, 15, null, 60, CURRENT_DATE);
INSERT INTO DOCTOR (ID, MEDICAL_LICENSE, CODE, DESCRIPTION, FIRST_NAME_EN, FIRST_NAME_TH, GENDER, LAST_NAME_EN,
LAST_NAME_TH, NICK_NAME, MEDICAL_LICENSE_NO, DOCTOR_SEQ, GENERAL_DOCTOR_OPERATION_EFFORT,
GENERAL_SKINCAR_EFFORT, GENERAL_SURGICAL_EFFORT, LAST_MODIFIED_DATE)
VALUES (11, 'SURGERY,CONFER', 'NarintornS.11', null, 'DR. NARINTORN', 'นรินธร', 'แพทย์หญิง', 'SAKSIYAYUTHANA', 'ศักดิ์ศรียุทธนา', 'คุณหมอ กิ๊ฟ', 'ว.XXXXX', 8, 15, null, 180, CURRENT_DATE);
INSERT INTO DOCTOR (ID, MEDICAL_LICENSE, CODE, DESCRIPTION, FIRST_NAME_EN, FIRST_NAME_TH, GENDER, LAST_NAME_EN,
LAST_NAME_TH, NICK_NAME, MEDICAL_LICENSE_NO, DOCTOR_SEQ, GENERAL_DOCTOR_OPERATION_EFFORT,
GENERAL_SKINCAR_EFFORT, GENERAL_SURGICAL_EFFORT, LAST_MODIFIED_DATE)
VALUES (12, 'SURGERY,CONFER', 'VeerakanS.12', null, 'DR. VEERAKAN', 'วีรกานต์', 'นายแพทย์', 'SATHITNIRAMAI', 'สถิตนิรามัย', 'คุณหมอ วี', 'ว.XXXXX', 9, 15, null, 180, CURRENT_DATE);



INSERT INTO USER (USERID, FULL_NAME, FULL_NAME_EN, USERNAME, ROLE_NAME, LAST_MODIFIED_DATE, PASSWORD) 
VALUES (1, 'ขนิษฐา สมบูรณ์ (แอน)', 'KanitthaS', 'KANITTHA SOMBOON', 'ADMIN', CURRENT_DATE, 'h4RuY22tH64mQhua0oTXj9aOPLLykaUixQuKjEJWWxo=');
INSERT INTO USER (USERID, FULL_NAME, USERNAME, ROLE_NAME, LAST_MODIFIED_DATE, PASSWORD) 
VALUES (2, 'อาภาจรีย์ จั่นยาว (การ์ตูน)', 'ArpajareeJ', 'ARPAJAREE JANYAW', 'ADMIN', CURRENT_DATE, 'xS29XF7xPEcaIJA90LjdIXvO7kyHFcH4W8XXk5fOXkc=');
INSERT INTO USER (USERID, FULL_NAME, USERNAME, ROLE_NAME, LAST_MODIFIED_DATE, PASSWORD) 
VALUES (3, 'มุขสุดา กนกเฉลิมพรรณ (บิว)', 'MooksudaK', 'MOOKSUDA KANOKCHALERMPHAN', 'ADMIN', CURRENT_DATE, 'LIGWPSBbg4mQ8hChi7pZ8QGPLikiWTEDDv1lEKKgODE=');
INSERT INTO USER (USERID, FULL_NAME, USERNAME, ROLE_NAME, LAST_MODIFIED_DATE, PASSWORD) 
VALUES (4, 'กรกนก พันธ์รัมย์ (มายด์)', 'KornkanokP',  'KORNKANOK PHANRUM', 'ADMIN', CURRENT_DATE, 'uroL3TAgHV0E8Meh0n7ybisMgZuW8BUZ51uJAGbZQmk=');
INSERT INTO USER (USERID, FULL_NAME, USERNAME, ROLE_NAME, LAST_MODIFIED_DATE, PASSWORD) 
VALUES (5, 'กุลจิรา เมืองกุดเรือ (เต้ย)', 'KunchiraM', 'KUNCHIRA MUEANGKUTRUEA', 'ADMIN', CURRENT_DATE, 'bplI4wodJgIuK/5w2uKugWR7DGCgmqjoGI037aRRXkA=');
INSERT INTO USER (USERID, FULL_NAME, USERNAME, ROLE_NAME, LAST_MODIFIED_DATE, PASSWORD) 
VALUES (6, 'ปริยวดี คำแหง (ซิน)', 'PiyawadeeK', 'PIYAWADEE KUMHANG', 'ADMIN', CURRENT_DATE, 'JeIhdWV46NLH8doS1haMPYM/vi0z16xYfXZ0yq3KzYs=');
INSERT INTO USER (USERID, FULL_NAME, USERNAME, ROLE_NAME, LAST_MODIFIED_DATE, PASSWORD) 
VALUES (7, 'ปรดา โพธิ์เจริญ (บีบิว)', 'PoradaP', 'PORADA PHOCHAROEN', 'ADMIN', CURRENT_DATE, 'B0aHxT3mvwc+SAXntohjL+MKYBnNi0WNs+M/fwTTWaE=');
INSERT INTO USER (USERID, FULL_NAME, USERNAME, ROLE_NAME, LAST_MODIFIED_DATE, PASSWORD) 
VALUES (8, 'กัลยกร ถุนนอก (นุ่น)', 'KanyakornT', 'KANYAKORN THOONNOK', 'ADMIN', CURRENT_DATE, 'Y8q+7TBs6vSrSgW7IdWMJl4UwUKwqhBphp35Cv+L7cs=');
INSERT INTO USER (USERID, FULL_NAME, USERNAME, ROLE_NAME, LAST_MODIFIED_DATE, PASSWORD) 
VALUES (9, 'วชิราภรณ์ เอี่ยวลับ (เตย)', 'WachirapronA', 'WACHIRAPRON AEUWLUB', 'ADMIN', CURRENT_DATE, 'YwVKeNYJjaRBL3mc5URJV+jL62p1JaAo+ymdAYetEuc=');
INSERT INTO USER (USERID, FULL_NAME, USERNAME, ROLE_NAME, LAST_MODIFIED_DATE, PASSWORD) 
VALUES (10, 'ดวงฤดี เปรมชื่น (นุ๊ก)', 'DuangrudiP', 'DUANGRUDI PREMCHUN', 'ADMIN', CURRENT_DATE, 'wZ+Cs6zj/AptLleo5Xb9UrzGAV43hptoSptGzyvH2FY=');
INSERT INTO USER (USERID, FULL_NAME, USERNAME, ROLE_NAME, LAST_MODIFIED_DATE, PASSWORD) 
VALUES (11, 'ศักรินทร์ จงจริยเลิศ (ปอนด์)', 'SakkarinJ', 'SAKKARIN JONGJARIYALERD', 'ADMIN', CURRENT_DATE, 'DZJxAOixol7p9yw66kUxFLmW0nSMiNzkIrFQzoHKK+g=');
INSERT INTO USER (USERID, FULL_NAME, USERNAME, ROLE_NAME, LAST_MODIFIED_DATE, PASSWORD) 
VALUES (12, 'วรรณี พุทธเกษร (ใหม่)', 'WanneeP', 'WANNEE PUTTAKAYSORN', 'ADMIN', CURRENT_DATE, '+NuLCVPnl/y+puRVHsXIUqlsW0W4yC+ZZxNWjkzpy2w=');
INSERT INTO USER (USERID, FULL_NAME, USERNAME, ROLE_NAME, LAST_MODIFIED_DATE, PASSWORD) 
VALUES (13, 'กุสุมา สุ่มสมิง (กวาง)', 'KusumaS', 'KUSUMA SUMSAMING', 'ADMIN', CURRENT_DATE, '44IKrbb48UQ/xyH4ed/dzu0VOBkdxR5YY0cEoOL1vKI=');
INSERT INTO USER (USERID, FULL_NAME, USERNAME, ROLE_NAME, LAST_MODIFIED_DATE, PASSWORD) 
VALUES (14, 'โสรยา จันทร์เต็มดวง (เดียร์)', 'SorayaJ', 'SORAYA JANTAMDUANG', 'ADMIN', CURRENT_DATE, '1ROHP9m3W8NB6F3mpexcsLpfvVcDUsxnXeOszYcc5mc=');
INSERT INTO USER (USERID, FULL_NAME, USERNAME, ROLE_NAME, LAST_MODIFIED_DATE, PASSWORD) 
VALUES (15, 'ศิญาลี ประเสริฐสังข์ (ดรีม)', 'SiyaleeP', 'SIYALEE PRASERTSANG', 'ADMIN', CURRENT_DATE, 'vl4gvachDbJ1f4ofKsAbvHbrsKEUhM+1dUvaD/ZS91U=');
INSERT INTO USER (USERID, FULL_NAME, USERNAME, ROLE_NAME, LAST_MODIFIED_DATE, PASSWORD) 
VALUES (16, 'พญ. ณัศรัตน์ กุลเกียรติประเสริฐ (หมอน้ำ)', 'NassaratK', 'NASSARAT KULKIATPRASERT', 'REPORT', CURRENT_DATE, 'yGJcFuZHi/gP5G40Ez94FZY12yabkGNuhgzNMZxtZgk=');
INSERT INTO USER (USERID, FULL_NAME, USERNAME, ROLE_NAME, LAST_MODIFIED_DATE, PASSWORD) 
VALUES (17, 'นพ. อนันต์ จึงสุวัฒนานนท์ (หมอหนึ่ง)', 'AnanJ', 'ANAN JUNGSUWATTANANON', 'REPORT', CURRENT_DATE, 'NJiee9NgIjF6yEbbKMSIRNhJkIvB+NzygXqwxOnX0ls=');
INSERT INTO USER (USERID, FULL_NAME, USERNAME, ROLE_NAME, LAST_MODIFIED_DATE, PASSWORD) 
VALUES (18, 'กิติภา สุ่มสมิง (กีต้าร์)', 'KittipaS', 'KITTIPA SUMSAMING', 'REPORT', CURRENT_DATE, '0+pIZHVgF/KVVVQ/sHRlpTDxeOCogGF+Xb6fnhKEoXE=');
INSERT INTO USER (USERID, FULL_NAME, USERNAME, ROLE_NAME, LAST_MODIFIED_DATE, PASSWORD) 
VALUES (19, 'หนึ่งฤทัย งามบุญสวัสดิ์ (หนึ่ง)', 'NuengrutaiN', 'NUENGRUTAI NGAMBOONSAWAT', 'REPORT', CURRENT_DATE, 'n/0oPDvA72mCwGctueXoIH5av5dggdQRSk1rldXk0xk=');
INSERT INTO USER (USERID, FULL_NAME, USERNAME, ROLE_NAME, LAST_MODIFIED_DATE, PASSWORD) 
VALUES (20, 'ชัยฤกษ์ งามบุญสวัสดิ์ (เจมส์)', 'ChairuekN', 'CHAIRUEK NGAMBOONSAWAT', 'REPORT', CURRENT_DATE, 'kJokhr7Dv482JRk4csWsHQiDSf5y48tD4Y1fuUFAMSI=');
INSERT INTO USER (USERID, FULL_NAME, USERNAME, ROLE_NAME, LAST_MODIFIED_DATE, PASSWORD) 
VALUES (21, 'ผู้ดูแลระบบ', 'AdminBS', 'ADMIN BUSTLESOFT', 'ADMIN', CURRENT_DATE, '4eYjIAnU3leRb1856GWPSGWVlx4XdxLOZG2Ft060/qA=');
INSERT INTO USER (USERID, FULL_NAME, USERNAME, ROLE_NAME, LAST_MODIFIED_DATE, PASSWORD) 
VALUES (22, 'ผู้ดูละระบบ', 'ReportBS', 'REPORT BUSTLESOFT', 'REPORT', CURRENT_DATE, '4eYjIAnU3leRb1856GWPSGWVlx4XdxLOZG2Ft060/qA=');




