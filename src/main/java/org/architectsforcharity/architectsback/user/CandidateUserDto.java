package org.architectsforcharity.architectsback.user;

public class CandidateUserDto {
    private String username;
    private String password;
    private String primaryEmail;
    private String secondaryEmail;
    private String firstName;
    private String lastName;
    private String phoneNr;

    public CandidateUserDto() {
    }

    public CandidateUserDto(String username, String password, String primaryEmail, String secondaryEmail, String firstName, String lastName, String phoneNr) {
        this.username = username;
        this.password = password;
        this.primaryEmail = primaryEmail;
        this.secondaryEmail = secondaryEmail;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNr = phoneNr;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrimaryEmail() {
        return primaryEmail;
    }

    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    public String getSecondaryEmail() {
        return secondaryEmail;
    }

    public void setSecondaryEmail(String secondaryEmail) {
        this.secondaryEmail = secondaryEmail;
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

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }
}
