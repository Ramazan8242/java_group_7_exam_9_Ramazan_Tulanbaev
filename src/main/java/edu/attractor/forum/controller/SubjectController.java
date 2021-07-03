package edu.attractor.forum.controller;

import edu.attractor.forum.model.Subject;
import edu.attractor.forum.repository.SubjectRepository;
import edu.attractor.forum.service.SubjectService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
@AllArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;
    private final SubjectRepository subjectRepository;
    private final ModelMapper mapper = new ModelMapper();

    @GetMapping("/")
    public String index(Model model, @PageableDefault(value = 1) Pageable pageable) {
        final Page<Subject> places = this.subjectService.getSubjects(pageable).map(place -> mapper.map(place, Subject.class));
        model.addAttribute("subjects", places.getContent());
        model.addAttribute("subj", places.getPageable());
        return "index";
    }
}