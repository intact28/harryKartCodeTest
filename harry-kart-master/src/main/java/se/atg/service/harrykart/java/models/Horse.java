package se.atg.service.harrykart.java.models;

import java.util.ArrayList;
import java.util.List;

public class Horse {
    private String name;
    private int baseSpeed;
    private List<Integer> powerUps;
    private int lane;
    private int totalTime;
    private int currentSpeed;
    private boolean disqualified = false;

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public boolean isDisqualified() {
        return disqualified;
    }

    public void setDisqualified(boolean disqualified) {
        this.disqualified = disqualified;
    }

    public Horse() {
        powerUps = new ArrayList<>();
    }

    public Horse(String name, int baseSpeed, int lane) {
        this.name = name;
        this.baseSpeed = baseSpeed;
        this.lane = lane;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBaseSpeed() {
        return baseSpeed;
    }

    public void setBaseSpeed(int baseSpeed) {
        this.baseSpeed = baseSpeed;
    }

    public int getTotalTime(){
        return totalTime;
    }

    public void setTotalTime(int totalTime){
        this.totalTime = totalTime;
    }

    public int getLane() {
        return lane;
    }

    public void setLane(int lane) {
        this.lane = lane;
    }

    public List<Integer> getPowerUps() {
        return powerUps;
    }

    public void setPowerUps(List<Integer> powerUps) {
        this.powerUps = powerUps;
    }
}
