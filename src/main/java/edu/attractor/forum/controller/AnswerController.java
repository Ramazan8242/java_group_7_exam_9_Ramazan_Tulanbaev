package edu.attractor.forum.controller;

import edu.attractor.forum.model.Answer;
import edu.attractor.forum.model.Subject;
import edu.attractor.forum.model.User;
import edu.attractor.forum.repository.AnswerRepository;
import edu.attractor.forum.repository.SubjectRepository;
import edu.attractor.forum.service.AnswerService;
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
import java.util.Optional;

@Controller
@RequestMapping
@AllArgsConstructor
public class AnswerController {
    private final AnswerService answerService;
    private final UserService userService;
    private final AnswerRepository answerRepository;
    private final SubjectRepository subjectRepository;
    private final ModelMapper mapper = new ModelMapper();

    @GetMapping("/addAnswer")
    public String index(Model model, @PageableDefault(value = 15) Pageable pageable,Integer id) {
       Page<Answer> places = this.answerService.getAnswer(pageable).map(place -> mapper.map(place, Answer.class));
        Subject subject =  answerService.getById(id);
        model.addAttribute("answers",places.getContent());
        model.addAttribute("subject", subject);
        model.addAttribute("answer", subject);
        return "answer";
    }

    @PostMapping("/addAnswer")
    private String addSubject(Answer answer, Principal principal,Integer id) {
        LocalDate localDate = LocalDate.now();
        User user = userService.getByEmail(principal.getName());
//        Subject subject = subjectRepository.getById(id);
        Answer answer1 = new Answer(user, answer.getText(), localDate);
        answerRepository.save(answer1);
        return "redirect:/addAnswer";
    }
}
