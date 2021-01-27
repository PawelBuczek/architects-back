package org.architectsforcharity.architectsback.user;

import org.architectsforcharity.architectsback.candidate.CandidateRepository;
import org.architectsforcharity.architectsback.mentor.MentorRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
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

//    @PostMapping("/user")
//    public UserBabysitterDTO addUserWithBabysitter(@Validated @RequestBody UserBabysitterDTO userBabysitterDTO) {
//        SecurityContext securityContext = SecurityContextHolder.getContext();
//        Authentication authentication = securityContext.getAuthentication();
//        String role = authentication.getAuthorities()
//                .stream()
//                .findFirst()
//                .orElseThrow()
//                .getAuthority();
//        User user = new User(userBabysitterDTO.getUsername(), userBabysitterDTO.getPassword(), "ROLE_USER");
//        Babysitter babysitter = new Babysitter(user, userBabysitterDTO.getFirstName(), userBabysitterDTO.getLastName(), userBabysitterDTO.getPhoneNumber(), userBabysitterDTO.getEmail());
//        userRepository.save(user);
//        babysitterRepository.save(babysitter);
//        return userBabysitterDTO;
//    }
}

