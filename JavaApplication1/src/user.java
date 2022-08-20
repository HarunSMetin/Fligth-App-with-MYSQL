/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Harun Serkan Metin
 */
public class user {
    private String user_ssn;
    private String user_password;
    private String user_mail;
    private String user_tel;
    private String user_adress;
    private String fname;
    private String lname;
    private int acceslevel;
    private String user_birthdate;
    private String user_age;
    
    public user(String user_ssn, String user_password, String user_mail
            , String user_tel, String user_adress, String fname, 
            String lname, int acceslevel, String user_birthdate,
            String user_age) {
        this.user_ssn = user_ssn;
        this.user_password = user_password;
        this.user_mail = user_mail;
        this.user_tel = user_tel;
        this.user_adress = user_adress;
        this.fname = fname;
        this.lname = lname;
        this.acceslevel = acceslevel;
        this.user_birthdate = user_birthdate;
        this.user_age = user_age;
    }

    public String getUser_ssn() {
        return user_ssn;
    }

    public void setUser_ssn(String user_ssn) {
        this.user_ssn = user_ssn;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_mail() {
        return user_mail;
    }

    public void setUser_mail(String user_mail) {
        this.user_mail = user_mail;
    }

    public String getUser_tel() {
        return user_tel;
    }

    public void setUser_tel(String user_tel) {
        this.user_tel = user_tel;
    }

    public String getUser_adress() {
        return user_adress;
    }

    public void setUser_adress(String user_adress) {
        this.user_adress = user_adress;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getAcceslevel() {
        return acceslevel;
    }

    public void setAcceslevel(int acceslevel) {
        this.acceslevel = acceslevel;
    }

    public String getUser_birthdate() {
        return user_birthdate;
    }

    public void setUser_birthdate(String user_birthdate) {
        this.user_birthdate = user_birthdate;
    }

    public String getUser_age() {
        return user_age;
    }

    public void setUser_age(String user_age) {
        this.user_age = user_age;
    }
   
    
}
