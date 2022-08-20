/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Harun Serkan Metin
 */
public class crew {
  private String crew_id;
   private String airplane_id;

    public crew(String crew_id, String airplane_id) {
        this.crew_id = crew_id;
        this.airplane_id = airplane_id;
    }

    public String getCrew_id() {
        return crew_id;
    }

    public void setCrew_id(String crew_id) {
        this.crew_id = crew_id;
    }

    public String getAirplane_id() {
        return airplane_id;
    }

    public void setAirplane_id(String airplane_id) {
        this.airplane_id = airplane_id;
    }
  
}
