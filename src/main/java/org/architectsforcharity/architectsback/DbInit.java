package org.architectsforcharity.architectsback;

import org.architectsforcharity.architectsback.candidate.Candidate;
import org.architectsforcharity.architectsback.candidate.CandidateRepository;
import org.architectsforcharity.architectsback.exam.Exam;
import org.architectsforcharity.architectsback.exam.ExamRepository;
import org.architectsforcharity.architectsback.mentor.Mentor;
import org.architectsforcharity.architectsback.mentor.MentorRepository;
import org.architectsforcharity.architectsback.user.User;
import org.architectsforcharity.architectsback.user.UserRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Component
public class DbInit {
    private final ExamRepository examRepository;
    private final CandidateRepository candidateRepository;
    private final MentorRepository mentorRepository;
    private final UserRepository userRepository;

    public DbInit(ExamRepository examRepository, CandidateRepository candidateRepository, MentorRepository mentorRepository, UserRepository userRepository) {
        this.examRepository = examRepository;
        this.candidateRepository = candidateRepository;
        this.mentorRepository = mentorRepository;
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void onInit() {
        User user1 = new User("aa12", "asdsad", "ROLE_USER", "adam.abacki@example.com", "adam@backup.pl");
        User user2 = new User("BB321", "asdsad", "ROLE_USER", "barbara.babacka@example.com", "barbara@backup.pl");
        User user3 = new User("zzz123", "asdsad", "ROLE_USER", "cezary.cabacki@example.com", "cezart@backup.pl");
        User user4 = new User("Men1", "asdsad", "ROLE_USER", "mentor.abacki@example.com", "mentor@backup.pl");
        User user5 = new User("Men2", "asdsad", "ROLE_USER", "mentor.babacka@example.com", "mentor@backup.pl");
        User user6 = new User("Men3", "asdsad", "ROLE_USER", "mentor.cabacki@example.com", "mentor@backup.pl");
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);
        userRepository.save(user6);

        Candidate candidate1 = new Candidate("Adam", "Abacki", "(+48) 123456789", user1);
        Candidate candidate2 = new Candidate("Barbara", "Babacka", "(+48) 223456789", user2);
        Candidate candidate3 = new Candidate("Cezary", "Cabacki", "(+48) 323456789", user3);
        candidateRepository.save(candidate1);
        candidateRepository.save(candidate2);
        candidateRepository.save(candidate3);

        Mentor mentor1 = new Mentor("MentorA", "Deus", "(+48) 423456789", user4);
        Mentor mentor2 = new Mentor("MentorB", "Eus", "(+48) 523456789", user5);
        Mentor mentor3 = new Mentor("MentorC", "Feus", "(+48) 623456789", user6);
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
        exam3.setExamTime(LocalDateTime.of(2021, 2, 23, 17, 20, 0));
        exam3.setExamTimeConfirmed(true);

        examRepository.save(exam1);
        examRepository.save(exam2);
        examRepository.save(exam3);
    }
}
