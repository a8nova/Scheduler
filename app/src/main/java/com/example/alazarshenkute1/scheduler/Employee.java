//
// Alazar Shenkute
// 7/30/15
//
package com.example.alazarshenkute1.scheduler;

import android.util.Log;

public class Employee {
    private long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;
    private int isSupervisor;


    public Employee() {
    }

    public Employee( long id, String firstName, String lastName,
                    String phoneNumber, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getIsSupervisor()
    {
        return isSupervisor;
    }
    public void setIsSupervisor( int isSupervisor )
    {
        this.isSupervisor = isSupervisor;
    }
    public long getId() {
        return id;
    }

    public void setId( long id ) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName ) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail( String email )
    {
        this.email = email;
    }
    public String getPassword()
    {
        return password;
    }

    public void setPassword( String password )
    {
        this.password = password;
    }

    /***** FOR TESTING */
    public void print()
    {
        Log.v("Employe", this.firstName );
        Log.v("Employe", this.lastName );
        Log.v("Employe", this.email );
    }
}
