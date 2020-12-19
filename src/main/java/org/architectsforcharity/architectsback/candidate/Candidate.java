package org.architectsforcharity.architectsback.candidate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String primaryEmail;
    private String secondaryEmail;
    private String phoneNr;
    private String defaultCharityName;
    private String defaultCharityWebsite;

    public Candidate(String firstName, String lastName, String primaryEmail, String secondaryEmail, String phoneNr, String defaultCharityName, String defaultCharityWebsite) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.primaryEmail = primaryEmail;
        this.secondaryEmail = secondaryEmail;
        this.phoneNr = phoneNr;
        this.defaultCharityName = defaultCharityName;
        this.defaultCharityWebsite = defaultCharityWebsite;
    }

    public Candidate(String firstName, String lastName, String primaryEmail, String secondaryEmail, String phoneNr) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.primaryEmail = primaryEmail;
        this.secondaryEmail = secondaryEmail;
        this.phoneNr = phoneNr;
    }

    public Candidate() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public String getDefaultCharityName() {
        return defaultCharityName;
    }

    public void setDefaultCharityName(String defaultCharityName) {
        this.defaultCharityName = defaultCharityName;
    }

    public String getDefaultCharityWebsite() {
        return defaultCharityWebsite;
    }

    public void setDefaultCharityWebsite(String defaultCharityWebsite) {
        this.defaultCharityWebsite = defaultCharityWebsite;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", primaryEmail='" + primaryEmail + '\'' +
                ", secondaryEmail='" + secondaryEmail + '\'' +
                ", phoneNr='" + phoneNr + '\'' +
                ", defaultCharityName='" + defaultCharityName + '\'' +
                ", defaultCharityWebsite='" + defaultCharityWebsite + '\'' +
                '}';
    }
}
