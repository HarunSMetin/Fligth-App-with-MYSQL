

/**
 *
 * @author Harun Serkan Metin
 */
public class seat {
    private String seat_num;
    private int is_booked;
    private String airplane_id;

    public seat(String seat_num, int is_booked, String airplane_id) {
        this.seat_num = seat_num;
        this.is_booked = is_booked;
        this.airplane_id = airplane_id;
    }

    public String getSeat_num() {
        return seat_num;
    }

    public void setSeat_num(String seat_num) {
        this.seat_num = seat_num;
    }

    public int getIs_booked() {
        return is_booked;
    }

    public void setIs_booked(int is_booked) {
        this.is_booked = is_booked;
    }

    public String getAirplane_id() {
        return airplane_id;
    }

    public void setAirplane_id(String airplane_id) {
        this.airplane_id = airplane_id;
    }

}
