package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserService;


@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ModelAndView printallUsers(Model model) {
        model.addAttribute("listUsers", userService.getAllUsers());
        return new ModelAndView("all-users");
    }

    @GetMapping("/addNewUser")
    public ModelAndView addNewUser(Model model) {
        model.addAttribute("user", new User());
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

    @PostMapping("/edit/{id}")
    public ModelAndView viewEditUserForm(@ModelAttribute("user") User user) {
       userService.edit(user);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteUser(@PathVariable(name = "id") int id) {
        userService.delete(id);
        return new ModelAndView("redirect:/");
    }

}