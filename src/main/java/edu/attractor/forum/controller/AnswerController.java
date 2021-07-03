package edu.attractor.forum.controller;

import edu.attractor.forum.model.Answer;
import edu.attractor.forum.model.Subject;
import edu.attractor.forum.repository.SubjectRepository;
import edu.attractor.forum.service.AnswerService;
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
public class AnswerController {
    private final AnswerService answerService;
    private final SubjectRepository subjectRepository;
    private final SubjectService subjectService;
    private final ModelMapper mapper = new ModelMapper();

    @GetMapping("/addAnswer")
    public String index(Model model, @PageableDefault(value = 15) Pageable pageable,Integer id) {
//       Page<Answer> places = this.answerService.getAnswer(pageable).map(place -> mapper.map(place, Answer.class));
        Subject subject =  answerService.getById(id);
        model.addAttribute("subject", subject);
        model.addAttribute("answer", subject);
        return "answer";
    }
}
