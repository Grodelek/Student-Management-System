package student.person;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RegisterController {
    List<User> userList = new ArrayList<>();

    @GetMapping("/users")
    public String getUsers(Model model){
        model.addAttribute("users", userList);
        return "users";
    }
    @GetMapping("/register")
    public String showUserForm(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute User user){
        userList.add(user);
        return "redirect:/users";
    }



}
