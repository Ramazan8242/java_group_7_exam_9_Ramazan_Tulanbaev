package edu.attractor.forum.controller;

import edu.attractor.forum.model.Subject;
import edu.attractor.forum.repository.SubjectRepository;
import edu.attractor.forum.service.SubjectService;
import edu.attractor.forum.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.time.LocalDate;


@Controller
@RequestMapping
@AllArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;
    private final SubjectRepository subjectRepository;
    private final UserService userService;
    private final ModelMapper mapper = new ModelMapper();

    @GetMapping("/")
    public String index(Model model, @PageableDefault(value = 2) Pageable pageable) {
        final Page<Subject> places = this.subjectService.getSubjects(pageable).map(place -> mapper.map(place, Subject.class));
        model.addAttribute("subjects", places.getContent());
        model.addAttribute("subj", places.getPageable());
        return "index";
    }

    @GetMapping("/addSubject")
    private String subject(Model model, Principal principal,Subject subject){
        var user = userService.getByEmail(principal.getName());
        model.addAttribute("dtos", user);

        LocalDate date = LocalDate.now();
        Subject subject1 = new Subject(subject.getEvents(),date,subject.getUser());
        model.addAttribute("subject",subject1);
        return "subject";
    }

    @PostMapping("/addSubject")
    private String addSubject(Model model , Subject subject){
        LocalDate date = LocalDate.now();
        Subject subject1 = new Subject(subject.getEvents(),date);
        model.addAttribute(subject1);
        subjectRepository.save(subject1);
        return "redirect:/";
    }
}