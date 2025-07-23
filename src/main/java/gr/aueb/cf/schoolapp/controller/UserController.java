package gr.aueb.cf.schoolapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/school")
@RequiredArgsConstructor
public class UserController {

   // private UserService userService; TBD
  //  private final UserInsertValidator userValidator;

    public String getUserForm(Model model) {

    }
}
