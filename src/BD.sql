CREATE DATABASE reservation_cinema_place;

CREATE TABLE reservation(

  id INT PRIMARY KEY,
  timed timestamp,
  userd varchar(20),
  sequence_place int,
  id_cinema_room int,
  FOREIGN KEY (id_cinema_room) REFERENCES cinema_room(id),
      CONSTRAINT UQ_codes UNIQUE
    (
        sequence_place, id_cinema_room
    )
);

CREATE TABLE cinema_room(
  id INT PRIMARY KEY,
  name_room varchar(30) unique,
  total_row int,
  total_col int
);
CREATE VIEW reservation_cinema AS
    SELECT sequence_place, cinema_room.name_room, total_col, total_row
        FROM reservation INNER JOIN cinema_room ON reservation.id_cinema_room=cinema_room.id
         WHERE EXISTS
                      ( SELECT *
                          FROM reservation
                          WHERE sequence_place = 2 );


SELECT * FROM reservation_cinema;
