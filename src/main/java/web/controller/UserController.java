package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserService;

import java.util.List;


@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ModelAndView printallUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("listUsers", users);
        return new ModelAndView("all-users");
    }

    @GetMapping("/addNewUser")
    public ModelAndView addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return new ModelAndView("user-info");
    }

    @PostMapping(value = "/saveUser")
    public ModelAndView saveUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/updateUser/{id}")
    public ModelAndView editUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.find(id));
        return new ModelAndView("update-user");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView viewEditUserForm(@PathVariable(name = "id") int id) {
        ModelAndView modelAndView = new ModelAndView("update");
        User user = userService.find(id);
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public ModelAndView deleteUser(@PathVariable(name = "id") int id) {
        userService.delete(id);
        return new ModelAndView("redirect:/");
    }
}

















//    @PatchMapping("/edit/{id}")
//    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
//        userService.update(id, user);
//        return "redirect:/";
//    }