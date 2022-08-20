/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Harun Serkan Metin
 */
public class ticket {
    private String pnr;
    private String seat_num;
    private String flight_id;
    private String airplane_id;
    private String airport_id;
    private String airport_name;
    private String pass_ssn;

    public ticket(String pnr, String seat_num, String flight_id, String airplane_id, String airport_id, String airport_name, String pass_ssn) {
        this.pnr = pnr;
        this.seat_num = seat_num;
        this.flight_id = flight_id;
        this.airplane_id = airplane_id;
        this.airport_id = airport_id;
        this.airport_name = airport_name;
        this.pass_ssn = pass_ssn;
    }

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public String getSeat_num() {
        return seat_num;
    }

    public void setSeat_num(String seat_num) {
        this.seat_num = seat_num;
    }

    public String getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(String flight_id) {
        this.flight_id = flight_id;
    }

    public String getAirplane_id() {
        return airplane_id;
    }

    public void setAirplane_id(String airplane_id) {
        this.airplane_id = airplane_id;
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

    public String getPass_ssn() {
        return pass_ssn;
    }

    public void setPass_ssn(String pass_ssn) {
        this.pass_ssn = pass_ssn;
    }
    
    
}
