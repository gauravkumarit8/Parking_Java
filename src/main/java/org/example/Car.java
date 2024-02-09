package org.example;

public class Car {
    private String registrationNo;
    private String colour;

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Car(){

    }
    public Car(String registrationNo, String colour) {
        this.registrationNo = registrationNo;
        this.colour = colour;
    }
}
