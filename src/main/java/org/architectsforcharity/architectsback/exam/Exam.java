package org.architectsforcharity.architectsback.exam;

import org.architectsforcharity.architectsback.candidate.Candidate;
import org.architectsforcharity.architectsback.mentor.Mentor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //to be able to show this in Mentor calendar's just in case, calculated in constructor
    private String name;
    @ManyToOne
    private Mentor primaryMentor;
    @ManyToMany
    private List<Mentor> otherMentors = new ArrayList<>();
    @ManyToOne
    private Candidate candidate;
    private LocalDateTime examTime;
    private Boolean examTimeConfirmed = false;
    private Boolean paid = false;
    @ElementCollection
    private List<String> usefulLinks = new ArrayList<>();


    public Exam(Candidate candidate) {
        this.candidate = candidate;
        this.name = candidate.getFirstName().charAt(0) + ". " + candidate.getLastName() + "_exam";
    }

    public Exam() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Mentor getPrimaryMentor() {
        return primaryMentor;
    }

    public void setPrimaryMentor(Mentor primaryMentor) {
        this.primaryMentor = primaryMentor;
    }

    public List<Mentor> getOtherMentors() {
        return otherMentors;
    }

    public void setOtherMentors(List<Mentor> otherMentors) {
        this.otherMentors = otherMentors;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public LocalDateTime getExamTime() {
        return examTime;
    }

    public void setExamTime(LocalDateTime examTime) {
        this.examTime = examTime;
    }

    public Boolean getExamTimeConfirmed() {
        return examTimeConfirmed;
    }

    public void setExamTimeConfirmed(Boolean examTimeConfirmed) {
        this.examTimeConfirmed = examTimeConfirmed;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public List<String> getUsefulLinks() {
        return usefulLinks;
    }

    public void setUsefulLinks(List<String> usefulLinks) {
        this.usefulLinks = usefulLinks;
    }

    public void addOtherMentor(Mentor mentor) {
        this.otherMentors.add(mentor);
    }

    public void removeOtherMentor(Mentor mentor) {
        this.otherMentors.remove(mentor);
    }

    public void addUsefulLink(String link) {
        this.usefulLinks.add(link);
    }

    public void removeUsefulLink(String link) {
        this.usefulLinks.remove(link);
    }


    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", primaryMentor=" + primaryMentor +
                ", otherMentors=" + otherMentors +
                ", candidate=" + candidate +
                ", examTime=" + examTime +
                ", examTimeConfirmed=" + examTimeConfirmed +
                ", paid=" + paid +
                ", usefulLinks=" + usefulLinks +
                '}';
    }
}
