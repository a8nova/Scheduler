//
// Alazar Shenkute
// 7/30/15
// daily schedule of an Employee
package com.example.alazarshenkute1.scheduler;

public class Schedule {
    private long id;            // id in database
    private String day;         // thursday
    private String startShift;  // 9:00am
    private String endShift;    // 5:30pm
    private String date;        // 7/30/15

    public Schedule( long id, String day, String startShift, String endShift, String date )
    {
        this.id = id;
        this.day = day;
        this.startShift = startShift;
        this.endShift = endShift;
        this.date = date;
    }

    public void setId( long id ){
        this.id = id;
    }
    public long getId(){
        return id;
    }
    public void setDay( String day ){
        this.day = day;
    }
    public String getDay(){
        return day;
    }
    public void setStartShift( String startShift ){
        this.startShift = startShift;
    }
    public String getStartShift(){
        return startShift;
    }
    public void setEndShift( String endShift ){
        this.endShift = endShift;
    }
    public String getEndShift(){
        return endShift;
    }
    public void setDate( String date ){
        this.date = date;
    }
    public String getDate(){
        return date;
    }
}
