package entity;

public class CinemaRoomEntity implements CinemaRoom {

    int id;
    int row;
    int col;

    public CinemaRoomEntity(int id, int row, int col) {
        this.id = id;
        this.row = row;
        this.col = col;
    }

    @Override
    public int row() {
        return row;
    }

    @Override
    public int col() {
        return col;
    }
}
