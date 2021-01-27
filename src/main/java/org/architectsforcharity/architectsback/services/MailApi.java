package org.architectsforcharity.architectsback.services;

import org.architectsforcharity.architectsback.user.User;
import org.architectsforcharity.architectsback.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/mailer")
public class MailApi {
    UserRepository userRepository;
    private final MailService mailService;

    @Autowired
    public MailApi(MailService mailService, UserRepository userRepository) {
        this.mailService = mailService;
        this.userRepository=userRepository;
    }

    @GetMapping("/RemindPassword/{email}")
    public String sendMail(@PathVariable String email) throws MessagingException {
        TokenGenerator tokenGenerator = new TokenGenerator();
        String token = tokenGenerator.generate();
        User user = userRepository.findByPrimaryEmail(email).orElse(null);
        assert user != null;
        user.setToken(token);
        userRepository.save(user);

        mailService.sendMail(user.getPrimaryEmail(),
                "Przypomnienie hasla dla: " + user.getUsername(),
                "<b>Twoja rola to: </b>" + user.getRole()  +"<br><b>Twoj kod zmiany hasła to: </b>" + user.getToken(), true);
        return "wysłano";
    }
    @PostMapping("/RemindPassword")
    public PasswordTokenDto resetPassword(@RequestBody PasswordTokenDto passwordTokenDTO) {
        User user = userRepository.findByToken(passwordTokenDTO.getToken()).orElse(null);
        assert user != null;
        user.setPassword(passwordTokenDTO.getPassword());
        user.setToken(null);
        userRepository.save(user);
        return passwordTokenDTO;
    }
}
