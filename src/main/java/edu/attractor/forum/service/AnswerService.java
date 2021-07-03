package edu.attractor.forum.service;

import edu.attractor.forum.model.Answer;
import edu.attractor.forum.repository.AnswerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;

    public Page<Answer> getAnswer(Pageable pageable) {
        return this.answerRepository.findAll(pageable);
    }
}
