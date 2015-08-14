//
// Alazar Shenkute
// 7/30/15
//
package com.example.alazarshenkute1.scheduler;

public class Employee {
    private long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Employee() {
    }

    public Employee( long id, String firstName, String lastName,
                    String phoneNumber ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
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

    public void setLastName(String mLastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String mPhoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
