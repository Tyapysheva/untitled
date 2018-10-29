CREATE DATABASE reservation_cinema_place;

CREATE TABLE reservation(

  id INT PRIMARY KEY,
  timed timestamp,
  userd varchar(20),
  sequence_place int unique,
  id_cinema_room int,
  FOREIGN KEY (id_cinema_room) REFERENCES cinema_room(id)
);

CREATE TABLE cinema_room(
  id INT PRIMARY KEY,
  total_row int,
  total_col int
);