CREATE TABLE Shelter (
	id SERIAL PRIMARY KEY,
	contact_id int,
	country varchar(50),
	city varchar(50),
	number_of_beds int,
	security_code int,
	pet_friendly boolean,

	CONSTRAINT fk_contact_id FOREIGN KEY (contact_id) REFERENCES Contact(id)
);