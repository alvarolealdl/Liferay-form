create table AmfRegistration_Registration (
	amfRegistrationId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	firstName VARCHAR(50) null,
	lastName VARCHAR(50) null,
	emailAddress VARCHAR(255) null,
	gender VARCHAR(75) null,
	birthday DATE null,
	password_ VARCHAR(75) null,
	homePhone VARCHAR(75) null,
	mobilePhone VARCHAR(75) null,
	address1 VARCHAR(75) null,
	address2 VARCHAR(75) null,
	city VARCHAR(75) null,
	state_ VARCHAR(75) null,
	zipCode LONG,
	securityAnswer VARCHAR(75) null
);

create table Registration_Login (
	loginId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	emailAddress VARCHAR(75) null,
	password_ VARCHAR(75) null
);

create table Registration_Registration (
	amfRegistrationId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	firstName VARCHAR(50) null,
	lastName VARCHAR(255) null,
	emailAddress VARCHAR(50) null,
	male BOOLEAN,
	birthday DATE null,
	password_ VARCHAR(75) null,
	homePhone VARCHAR(75) null,
	mobilePhone VARCHAR(75) null,
	address1 VARCHAR(255) null,
	address2 VARCHAR(255) null,
	city VARCHAR(255) null,
	state_ VARCHAR(75) null,
	zipCode LONG,
	securityAnswer VARCHAR(255) null
);

create table Registration_RegistrationEvent (
	registrationEventId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	eventType VARCHAR(75) null,
	ipAddress VARCHAR(75) null
);