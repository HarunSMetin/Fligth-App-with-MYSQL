/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Harun Serkan Metin
 */
public class Flight {
    private String flight_id;
    private String plane_gate;    
    private String departure_date;    
    private String departure_time;
    private String where_from;
    private String where_to;    
    private String airport_id;    
    private String airport_name;
    private String airplane_id;

    public Flight(String flight_id, String plane_gate, String departure_date, String departure_time, String where_from, String where_to, String airport_id, String airport_name, String airplane_id) {
        this.flight_id = flight_id;
        this.plane_gate = plane_gate;
        this.departure_date = departure_date;
        this.departure_time = departure_time;
        this.where_from = where_from;
        this.where_to = where_to;
        this.airport_id = airport_id;
        this.airport_name = airport_name;
        this.airplane_id = airplane_id;
    }

    public String getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(String flight_id) {
        this.flight_id = flight_id;
    }

    public String getPlane_gate() {
        return plane_gate;
    }

    public void setPlane_gate(String plane_gate) {
        this.plane_gate = plane_gate;
    }

    public String getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(String departure_date) {
        this.departure_date = departure_date;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public String getWhere_from() {
        return where_from;
    }

    public void setWhere_from(String where_from) {
        this.where_from = where_from;
    }

    public String getWhere_to() {
        return where_to;
    }

    public void setWhere_to(String where_to) {
        this.where_to = where_to;
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

    public String getAirplane_id() {
        return airplane_id;
    }

    public void setAirplane_id(String airplane_id) {
        this.airplane_id = airplane_id;
    }
    
}
