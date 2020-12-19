package org.architectsforcharity.architectsback.mentor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/mentor")
public class MentorController {
    MentorRepository mentorRepository;

    public MentorController(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    @GetMapping
    public List<Mentor> getAll() {
        return mentorRepository.findAll();
    }
    @PostMapping
    public Mentor add(@RequestBody Mentor mentor) {
        return mentorRepository.save(mentor);
    }

    @GetMapping("/{id}")
    public Mentor getById(@PathVariable long id) {
        return mentorRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        mentorRepository.deleteById(id);
    }
}
