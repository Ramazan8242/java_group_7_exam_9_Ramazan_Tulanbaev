package edu.attractor.forum.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Table(name="subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    @Size(min = 1, max = 128)
    @Column(length = 128)
    private String events;

    private LocalDate localDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Subject(@NotBlank @Size(min = 1, max = 128) String events, LocalDate localDate, User user) {
        this.events = events;
        this.localDate = localDate;
        this.user = user;
    }

    public Subject(@NotBlank @Size(min = 1, max = 128) String events, LocalDate localDate) {
        this.events = events;
        this.localDate = localDate;
    }
}
