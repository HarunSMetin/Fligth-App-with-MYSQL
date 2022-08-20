

/**
 *
 * @author Harun Serkan Metin
 */
public class airplane {
    private String airplane_id;
    private int seat_count;
    private String airport_id;    

    public airplane(String airplane_id, int seat_count, String airport_id) {
        this.airplane_id = airplane_id;
        this.seat_count = seat_count;
        this.airport_id = airport_id;
    }

    public String getAirplane_id() {
        return airplane_id;
    }

    public void setAirplane_id(String airplane_id) {
        this.airplane_id = airplane_id;
    }

    public int getSeat_count() {
        return seat_count;
    }

    public void setSeat_count(int seat_count) {
        this.seat_count = seat_count;
    }

    public String getAirport_id() {
        return airport_id;
    }

    public void setAirport_id(String airport_id) {
        this.airport_id = airport_id;
    }
}
