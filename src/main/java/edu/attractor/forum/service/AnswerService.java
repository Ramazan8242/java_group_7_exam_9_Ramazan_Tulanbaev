package edu.attractor.forum.service;

import edu.attractor.forum.model.Answer;
import edu.attractor.forum.model.Subject;
import edu.attractor.forum.repository.AnswerRepository;
import edu.attractor.forum.repository.SubjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final SubjectRepository subjectRepository;

    public Page<Answer> getAnswer(Pageable pageable) { return this.answerRepository.findAll(pageable); }
    public Subject getById(Integer id){
        return subjectRepository.getById(id);
    }
}
