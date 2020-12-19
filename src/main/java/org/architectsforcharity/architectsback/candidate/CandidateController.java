package org.architectsforcharity.architectsback.candidate;

import org.architectsforcharity.architectsback.exam.ExamRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/candidate")
public class CandidateController {
    CandidateRepository candidateRepository;
    ExamRepository examRepository;

    public CandidateController(CandidateRepository candidateRepository, ExamRepository examRepository) {
        this.candidateRepository = candidateRepository;
        this.examRepository = examRepository;
    }

    @GetMapping
    public List<Candidate> getAll() {
        return candidateRepository.findAll();
    }
    @PostMapping
    public Candidate add(@RequestBody Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    @GetMapping("/{id}")
    public Candidate getById(@PathVariable long id) {
        return candidateRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        candidateRepository.deleteById(id);
    }
}
