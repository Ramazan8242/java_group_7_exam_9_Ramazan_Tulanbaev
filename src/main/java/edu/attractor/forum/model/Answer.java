package edu.attractor.forum.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Optional;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Table(name="answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Subject subject;

    @ManyToOne
    private User user;

    private String text;

    private LocalDate localDate;

    public Answer(User user, String text, LocalDate localDate) {
        this.user = user;
        this.text = text;
        this.localDate = localDate;
    }
}
