package entity;

public class CinemaRoomEntity implements CinemaRoom {

    long id;
    String nameRoom;
    int totalRow;
    int totalCol;

    public CinemaRoomEntity(String nameRoom, int totalRow, int totalCol) {
        this.nameRoom = nameRoom;
        this.totalRow = totalRow;
        this.totalCol = totalCol;
    }
    public CinemaRoomEntity(String nameRoom) {
        this.nameRoom=nameRoom;
    }
    @Override
    public String nameRoom() { return nameRoom; }

    @Override
    public int totalRow() {
        return totalRow;
    }

    @Override
    public int totalCol() {
        return totalCol;
    }
}
