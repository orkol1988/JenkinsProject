package com.example.demo;

public class ReportsDTO {

    public int ID;
    public String License_plate;
    public int Driver_ID;
    public int Speed;

    public ReportsDTO() {

    }

    public ReportsDTO(int ID, String license_plate, int driver_ID, int speed) {
        this.ID = ID;
        License_plate = license_plate;
        Driver_ID = driver_ID;
        Speed = speed;
    }

    @Override
    public String toString() {
        return "ReportsDTO{" +
                "ID=" + ID +
                ", License_plate='" + License_plate + '\'' +
                ", Driver_ID=" + Driver_ID +
                ", Speed=" + Speed +
                '}';
    }
}
