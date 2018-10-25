package entity;

public class CinemaRoomEntity implements CinemaRoom {

    long id;
    int totalRow;
    int totalCol;

    public CinemaRoomEntity(int id, int totalRow, int totalCol) {
        this.id = id;
        this.totalRow = totalRow;
        this.totalCol = totalCol;
    }
    @Override
    public int totalRow() {
        return totalRow;
    }

    @Override
    public int totalCol() {
        return totalCol;
    }
}
