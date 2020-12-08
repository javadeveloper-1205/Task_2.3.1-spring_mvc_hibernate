package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.User;
import web.service.UserService;

import java.util.List;


@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String allUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allListUsers", allUsers);
        return "all-users";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user-info";
    }
}

//@RequestMapping("/index")
//    public String printUsers(Map<String, Object> map) {
//        User user = new User();
//        map.put("user", user);
//        return "user";
//    }
//    @RequestMapping(value = "/user.do", method = RequestMethod.POST)
//    public String doActions(@ModelAttribute User user, BindingResult result, @RequestParam String action, Map<String, Object> map) {
//        User userResult = new User();
//        switch (action.toLowerCase()) {
//            case "add":
//                userService.add(user);
//                userResult = user;
//                break;
//            case "update":
//                userService.update(user);
//                userResult = user;
//                break;
//            case "delete":
//               userService.delete(user.getUserId());
//                userResult = new User();
//                break;
//            case "search":
//                User searchedUser = userService.read(user.getUserId());
//                userResult = searchedUser != null ? searchedUser : new User();
//                break;
//        }
//        map.put("user", userResult);
//        map.put("userList", userService.read(int ));
//        return "user";
//    }

