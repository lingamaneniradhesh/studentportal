use sportal;

create table ADDRESS (
	ID int not null auto_increment,
	ADDR_LN1 varchar(50) not null,
	ADDR_LN2 varchar(50),
	CITY varchar(50),
	STATE varchar(50) not null,
	COUNTRY varchar(50) not null,
	POSTAL_CODE varchar(10) not null,
	ADDR_TYPE varchar(20) not null,
	STUDENT_ID int not null references STUDENT(ID),
	TEACHER_ID int not null references TEACHER(ID),
	CREATED_DATE date,
	CREATED_BY varchar(50) default 'system',
	MODIFIED_DATE timestamp default now(),
	MODIFIED_BY varchar(50) default 'system',
	primary key (ID),
	unique key (ADDR_TYPE, STUDENT_ID)
);

create table ANNOUNCEMENT (
	ID int not null auto_increment,
	TITLE varchar(50) not null,
	DESCRIPTION varchar(200) not null,
	FROM_DATE date not null,
	TO_DATE date,
	CREATED_DATE date,
	CREATED_BY varchar(50) default 'system',
	MODIFIED_DATE timestamp default now(),
	MODIFIED_BY varchar(50) default 'system',
	primary key (ID),
	unique key (TITLE, FROM_DATE)
);

create table CERTIFICATION (
	ID int not null auto_increment,
	CERTIFICATION_NAME varchar(20) not null,
	STUDENT_ID int not null references STUDENT(ID),
	CREATED_DATE date,
	CREATED_BY varchar(50) default 'system',
	MODIFIED_DATE timestamp default now(),
	MODIFIED_BY varchar(50) default 'system',
	primary key (CERTIFICATION_NAME, STUDENT_ID)
);

create table CONTACT (
	ID int not null auto_increment,
	FIRST_NAME varchar(50) not null,
	LAST_NAME varchar(50) not null,
	EMAIL varchar(50) not null,
	PHONE_NUMBER varchar(20) not null,
	CONTACT_DATE_TIME datetime not null,
	DESCRIPTION varchar(200) not null,
	RESOLUTION_STATUS varchar(20) not null,
	RESOLUTION varchar(200) not null,
	CREATED_DATE date,
	CREATED_BY varchar(50) default 'system',
	MODIFIED_DATE timestamp default now(),
	MODIFIED_BY varchar(50) default 'system',
	primary key (ID)
);

create table COURSE (
	ID int not null auto_increment,
	COURSE_NAME varchar(50) not null,
	DESCRIPTION varchar(200) not null,
	FEE double(10),
	CREATED_DATE date,
	CREATED_BY varchar(50) default 'system',
	MODIFIED_DATE timestamp default now(),
	MODIFIED_BY varchar(50) default 'system',
	primary key (ID),
	unique key (COURSE_NAME)
);

create table GREETING (
	ID int not null auto_increment,
	MESSAGE varchar(50) not null,
	FROM_DATE date not null,
	TO_DATE date,
	CREATED_DATE date,
	CREATED_BY varchar(50) default 'system',
	MODIFIED_DATE timestamp default now(),
	MODIFIED_BY varchar(50) default 'system',
	primary key (ID),
	unique key (MESSAGE, FROM_DATE)
);

create table HOBBY (
	ID int not null auto_increment,
	HOBBY_NAME varchar(50) not null,
	STUDENT_ID int not null references STUDENT(ID),
	CREATED_DATE date,
	CREATED_BY varchar(50) default 'system',
	MODIFIED_DATE timestamp default now(),
	MODIFIED_BY varchar(50) default 'system',
	primary key (ID),
	unique key (HOBBY_NAME, STUDENT_ID)
);

create table USER (
	ID int not null auto_increment,
	USER_NAME varchar(50) not null,
	PASSWORD varchar(100) not null,
	IS_ENABLED TINYINT(1) default true,
	STUDENT_ID int not null references STUDENT(ID),
	ROLE_ID int not null references ROLE(ID),
	CREATED_DATE date,
	CREATED_BY varchar(50) default 'system',
	MODIFIED_DATE timestamp default now(),
	MODIFIED_BY varchar(50) default 'system',
	primary key (ID),
	unique key (USER_NAME)
);

create table PHONE (
	ID int not null auto_increment,
	MOBILE_NUMBER varchar(20) not null,
	HOME_NUMBER varchar(20) null,
	OFFICE_NUMBER varchar(20) null,
	STUDENT_ID int not null references STUDENT(ID),
	CREATED_DATE date,
	CREATED_BY varchar(50) default 'system',
	MODIFIED_DATE timestamp default now(),
	MODIFIED_BY varchar(50) default 'system',
	primary key (ID),
	unique key (MOBILE_NUMBER)
);

create table QUALIFICATION (
	ID int not null auto_increment,
	QUALIFICATION_NAME varchar(20) not null,
	STUDENT_ID int not null references STUDENT(ID),
	CREATED_DATE date,
	CREATED_BY varchar(50) default 'system',
	MODIFIED_DATE timestamp default now(),
	MODIFIED_BY varchar(50) default 'system',
	primary key (ID),
	unique key (QUALIFICATION_NAME, STUDENT_ID)
);

create table ROLE (
	ID int not null auto_increment,
	ROLE_NAME varchar(50) not null,
	CREATED_DATE date,
	CREATED_BY varchar(50) default 'system',
	MODIFIED_DATE timestamp default now(),
	MODIFIED_BY varchar(50) default 'system',
	primary key (ID),
	unique key (ROLE_NAME)
);

create table SCHOOL (
	ID int not null auto_increment,
	SCHOOL_NAME varchar(50) not null,
	ESTABLISHED_DATE date not null,
	CREATED_DATE date,
	CREATED_BY varchar(50) default 'system',
	MODIFIED_DATE timestamp default now(),
	MODIFIED_BY varchar(50) default 'system',
	primary key (ID),
	unique key (SCHOOL_NAME)
);

create table STUDENT (
	ID int not null auto_increment,
	FIRST_NAME varchar(50) not null,
	MIDDLE_NAME varchar(50),
	LAST_NAME varchar(50) not null,
	EMAIL varchar(50) not null,
	DATE_OF_BIRTH date not null,
	DATE_OF_JOINING date not null,
	DATE_LEFT date,
	CREATED_DATE date,
	CREATED_BY varchar(50) default 'system',
	MODIFIED_DATE timestamp default now(),
	MODIFIED_BY varchar(50) default 'system',
	primary key (ID)
);

create table TEACHER (
	ID int not null auto_increment,
	FIRST_NAME varchar(50) not null,
	MIDDLE_NAME varchar(50) not null,
	LAST_NAME varchar(50) not null,
	EMAIL varchar(50) not null,
	DATE_OF_BIRTH date not null,
	DATE_OF_JOINING date not null,
	DATE_LEFT date,
	CREATED_DATE date,
	CREATED_BY varchar(50) default 'system',
	MODIFIED_DATE timestamp default now(),
	MODIFIED_BY varchar(50) default 'system',
	primary key (ID)
);

create table TIME_IN_OUT (
	ID int not null auto_increment,
	IO_DATE date not null,
	IN_TIME time not null,
	OUT_TIME time,
	STUDENT_ID int not null references STUDENT(ID),
	CREATED_DATE date,
	CREATED_BY varchar(50) default 'system',
	MODIFIED_DATE timestamp default now(),
	MODIFIED_BY varchar(50) default 'system',
	primary key (ID),
	unique key (IO_DATE, STUDENT_ID)
);

create table TIMESHEET (
	ID int not null auto_increment,
	TS_DATE date not null,
	HRS int not null,
	MINS int not null,
	TASK varchar(50) not null,
	STUDENT_ID int not null references STUDENT(ID),
	CREATED_DATE date,
	CREATED_BY varchar(50) default 'system',
	MODIFIED_DATE timestamp default now(),
	MODIFIED_BY varchar(50) default 'system',
	primary key (ID),
	unique key (TS_DATE, TASK)
);

create table VACATION (
	ID int not null auto_increment,
	FROM_DATE date not null,
	TO_DATE date not null,
	LEAVE_TYPE varchar(50) not null,
	STUDENT_ID int not null references STUDENT(ID),
	CREATED_DATE date,
	CREATED_BY varchar(50) default 'system',
	MODIFIED_DATE timestamp default now(),
	MODIFIED_BY varchar(50) default 'system',
	primary key (ID),
	unique key (FROM_DATE, STUDENT_ID)
);

create table STUDENT_TEACHER (
	STUDENT_ID int not null references STUDENT(ID),
	TEACHER_ID int not null references TEACHER(ID),
	primary key (STUDENT_ID, TEACHER_ID)
);
