package com.demo;

public class Layout {
    private int best_dribbling_grade;
    private int best_shooting_grade;
    private String best_dribbler;
    private String best_shooter;

    // getters
    public int getBestDRIGrade() { return this.best_dribbling_grade; }
    public int getBestSHOGrade() { return this.best_shooting_grade; }
    public String getBestDribbler() { return this.best_dribbler; }
    public String getBestShooter() { return this.best_shooter; }

    // setters
    public void setBestDRIGrade(int best_dribbling_grade) { this.best_dribbling_grade = best_dribbling_grade; }
    public void setBestSHOGrade(int best_shooting_grade) { this.best_shooting_grade = best_shooting_grade; }
    public void setBestDribbler(String best_dribbler) { this.best_dribbler = best_dribbler; }
    public void setBestShooter(String best_shooter) { this.best_shooter = best_shooter; }
}
