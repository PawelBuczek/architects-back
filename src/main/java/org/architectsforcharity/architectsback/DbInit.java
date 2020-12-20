package org.architectsforcharity.architectsback;

import org.architectsforcharity.architectsback.candidate.Candidate;
import org.architectsforcharity.architectsback.candidate.CandidateRepository;
import org.architectsforcharity.architectsback.exam.Exam;
import org.architectsforcharity.architectsback.exam.ExamRepository;
import org.architectsforcharity.architectsback.mentor.Mentor;
import org.architectsforcharity.architectsback.mentor.MentorRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Component
public class DbInit {
    private final ExamRepository examRepository;
    private final CandidateRepository candidateRepository;
    private final MentorRepository mentorRepository;

    public DbInit(ExamRepository examRepository, CandidateRepository candidateRepository, MentorRepository mentorRepository) {
        this.examRepository = examRepository;
        this.candidateRepository = candidateRepository;
        this.mentorRepository = mentorRepository;
    }

    @PostConstruct
    public void onInit() {
        Candidate candidate1 = new Candidate("Adam", "Abacki", "adam.abacki@example.com", "adam@backup.pl", "(+48) 123456789");
        Candidate candidate2 = new Candidate("Barbara", "Babacka", "barbara.babacka@example.com", "barbara@backup.pl", "(+48) 223456789");
        Candidate candidate3 = new Candidate("Cezary", "Cabacki", "cezary.cabacki@example.com", "cezart@backup.pl", "(+48) 323456789");
        candidateRepository.save(candidate1);
        candidateRepository.save(candidate2);
        candidateRepository.save(candidate3);

        Mentor mentor1 = new Mentor("MentorA", "Deus", "mentor.abacki@example.com", "mentor@backup.pl", "(+48) 423456789");
        Mentor mentor2 = new Mentor("MentorB", "Eus", "mentor.babacka@example.com", "mentor@backup.pl", "(+48) 523456789");
        Mentor mentor3 = new Mentor("MentorC", "Feus", "mentor.cabacki@example.com", "mentor@backup.pl", "(+48) 623456789");
        mentorRepository.save(mentor1);
        mentorRepository.save(mentor2);
        mentorRepository.save(mentor3);

        Exam exam1 = new Exam(candidate1);
        Exam exam2 = new Exam(candidate2);
        Exam exam3 = new Exam(candidate3);

        exam2.setPrimaryMentor(mentor1);
        exam2.addOtherMentor(mentor2);

        exam3.addOtherMentor(mentor1);
        exam3.addOtherMentor(mentor2);
        exam3.addUsefulLink("www.google.com");
        exam3.setExamTime(LocalDateTime.of(2021,2,23,17,20,0));
        exam3.setExamTimeConfirmed(true);

        examRepository.save(exam1);
        examRepository.save(exam2);
        examRepository.save(exam3);
    }
}
