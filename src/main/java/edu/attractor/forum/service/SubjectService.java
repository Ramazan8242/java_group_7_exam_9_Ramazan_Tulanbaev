package edu.attractor.forum.service;

import edu.attractor.forum.model.Subject;
import edu.attractor.forum.repository.SubjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SubjectService {
    private final SubjectRepository subjectRepository;

    public Page<Subject> getSubjects(Pageable pageable) {
        return this.subjectRepository.findAll(pageable);
    }

}
