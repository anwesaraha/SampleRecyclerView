package com.example.anwesa_pc.samplerecyclerview;

/**
 * Created by ANWESA-PC on 19-11-2017.
 */

public class StudentPojo {
    private String name;
    private String roll;

    public StudentPojo(String name, String roll){
        this.name = name;
        this.roll = roll;
    }
    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
