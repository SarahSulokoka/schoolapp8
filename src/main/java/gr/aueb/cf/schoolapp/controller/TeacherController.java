package gr.aueb.cf.schoolapp.controller;

import gr.aueb.cf.schoolapp.dto.TeacherInsertDTO;
import gr.aueb.cf.schoolapp.model.Teacher;
import gr.aueb.cf.schoolapp.repository.RegionRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/school/teachers")
//@RequiredArgsConstructor dep injection, no constructor needed
public class TeacherController {

    private final RegionRepository regionRepository;


    @Autowired
    public TeacherController(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @GetMapping("/insert")
    public String getTeacherForm(Model model) {
        model.addAttribute(("teacherInsertDTO"),  new TeacherInsertDTO());
        model.addAttribute("regions" , regionRepository.findAll(Sort.by("name")));
        return "teacher-form";


    }

    public String saveTEacher(@Valid @ModelAttribute("teacherInsertDTO") TeacherInsertDTO teacherInsertDTO,
                              BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {

        Teacher savedTeacher;

        if (bindingResult.hasErrors()) {
            model.addAttribute("regions", regionRepository.findAll(Sort.by("name")));
        }

        try
        {

        } catch () {

        }
    }
}
