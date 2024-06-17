package student.person;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String getUsers(Model model){
        List<User> userList = userService.getAllUsers();
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
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String getEdit(@RequestParam("id") long id, Model model){
        User user = userService.getUserById(id);
        if(user != null){
            model.addAttribute("user", user);
            return "edit";
        }
        return "redirect:/users";
    }

    @PostMapping("/edit")
    public String updateUser
            (Model model,
            @RequestParam long id,
            @Valid @ModelAttribute User user,
            BindingResult result)
    {
        try{
            User extistingUser = userService.getUserById(id);
            extistingUser.setName(user.getName());
            extistingUser.setSurname(user.getSurname());
            extistingUser.setGpa(user.getGpa());
            extistingUser.setPhone(user.getPhone());
            userService.saveUser(extistingUser);
        }catch (Exception e){
            e.getStackTrace();
        }
        return "redirect:/users";
    }

}
