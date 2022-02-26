CREATE TABLE Shelter (
	id int GENERATED ALWAYS AS IDENTITY,
	contact_id int,
	country varchar(50),
	city varchar(50),
	number_of_beds int,
	security_code int
);;