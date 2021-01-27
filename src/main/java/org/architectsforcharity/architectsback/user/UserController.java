package org.architectsforcharity.architectsback.user;

import org.architectsforcharity.architectsback.candidate.Candidate;
import org.architectsforcharity.architectsback.candidate.CandidateRepository;
import org.architectsforcharity.architectsback.mentor.Mentor;
import org.architectsforcharity.architectsback.mentor.MentorRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:4200")
@RestController
public class UserController {
    private MentorRepository mentorRepository;
    private CandidateRepository candidateRepository;
    private UserRepository userRepository;

    public UserController(MentorRepository mentorRepository, CandidateRepository candidateRepository, UserRepository userRepository) {
        this.mentorRepository = mentorRepository;
        this.candidateRepository = candidateRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public LoggedUserDto login() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        String username = authentication.getName();
        String role = authentication.getAuthorities()
                .stream()
                .findFirst()
                .orElseThrow()
                .getAuthority();
        return new LoggedUserDto(username, role);
    }

    @PostMapping("/candidateuser")
    public CandidateUserDto addCandidateAndUser(@RequestBody CandidateUserDto candidateUserDto) {
        User user = new User(candidateUserDto.getUsername(), candidateUserDto.getPassword(), "ROLE_USER", candidateUserDto.getPrimaryEmail(), candidateUserDto.getSecondaryEmail());
        Candidate candidate = new Candidate(candidateUserDto.getFirstName(), candidateUserDto.getLastName(), candidateUserDto.getPhoneNr(), user);
        userRepository.save(user);
        candidateRepository.save(candidate);
        return candidateUserDto;
    }

    @PostMapping("/mentoruser")
    public MentorUserDto addMentorAndUser(@RequestBody MentorUserDto mentorUserDto) {
        User user = new User(mentorUserDto.getUsername(), mentorUserDto.getPassword(), "ROLE_USER", mentorUserDto.getPrimaryEmail(), mentorUserDto.getSecondaryEmail());
        Mentor mentor = new Mentor(mentorUserDto.getFirstName(), mentorUserDto.getLastName(), mentorUserDto.getPhoneNr(), user);
        userRepository.save(user);
        mentorRepository.save(mentor);
        return mentorUserDto;
    }
}

