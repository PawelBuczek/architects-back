package org.architectsforcharity.architectsback.exam;

import org.architectsforcharity.architectsback.mentor.Mentor;
import org.architectsforcharity.architectsback.mentor.MentorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/exam")
public class ExamController {
    ExamRepository examRepository;
    MentorRepository mentorRepository;

    public ExamController(ExamRepository examRepository, MentorRepository mentorRepository) {
        this.examRepository = examRepository;
        this.mentorRepository = mentorRepository;
    }

    @GetMapping
    public List<Exam> getAll() {
        return examRepository.findAll();
    }

    @PostMapping
    public Exam add(@RequestBody Exam exam) {
        return examRepository.save(exam);
    }

    @GetMapping("/{id}")
    public Exam getById(@PathVariable long id) {
        return examRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        examRepository.deleteById(id);
    }

    @DeleteMapping("/{id}/mentors/{mentorId}")
    public void removeOtherMentor(@PathVariable long id, @PathVariable long mentorId) {
        Optional<Exam> exam = examRepository.findById(id);
        Optional<Mentor> mentor = mentorRepository.findById(mentorId);
        if (exam.isPresent() && mentor.isPresent()) {
            exam.get().removeOtherMentor(mentor.get());
            examRepository.save(exam.get());
        }
    }
}
