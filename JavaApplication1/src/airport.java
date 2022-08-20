/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Harun Serkan Metin
 */
public class airport {

    private String airport_id;
    private String airport_name;
    private String airport_loc;

    public airport(String airport_id, String airport_name, String airport_loc) {
        this.airport_id = airport_id;
        this.airport_name = airport_name;
        this.airport_loc = airport_loc;
    }

    public String getAirport_id() {
        return airport_id;
    }

    public void setAirport_id(String airport_id) {
        this.airport_id = airport_id;
    }

    public String getAirport_name() {
        return airport_name;
    }

    public void setAirport_name(String airport_name) {
        this.airport_name = airport_name;
    }

    public String getAirport_loc() {
        return airport_loc;
    }

    public void setAirport_loc(String airport_loc) {
        this.airport_loc = airport_loc;
    }

}
