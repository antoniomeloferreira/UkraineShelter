CREATE DATABASE UkrainShelter;

CREATE TABLE Contact (
	id SERIAL PRIMARY KEY,
	number int,
	contact_type varchar (20)
);

CREATE TABLE Shelter (
	id SERIAL PRIMARY KEY,
	contact_id int,
	country varchar(50),
	city varchar(50),
	number_of_beds int,
	security_code int,
	is_pet_friendly bit,

	CONSTRAINT fk_contact_id FOREIGN KEY (contact_id) REFERENCES Contact(id)
);