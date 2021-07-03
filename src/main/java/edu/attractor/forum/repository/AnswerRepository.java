package edu.attractor.forum.repository;

import edu.attractor.forum.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnswerRepository extends JpaRepository<Answer,Integer> {
    Optional<Answer> findById(Integer id);
}
