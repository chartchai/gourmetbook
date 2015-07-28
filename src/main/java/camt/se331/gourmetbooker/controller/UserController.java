package camt.se331.gourmetbooker.controller;

/**
 * Created by Punjasin on 26/7/2558.
 */
import camt.se331.gourmetbooker.entity.User;
import camt.se331.gourmetbooker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


/**
 * Created by P-OniSawa on 14/5/2558.
 */
@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "user", method = RequestMethod.POST)
    public
    @ResponseBody
    User add(@RequestBody User user, BindingResult bindingResult) {
        return userService.addUser(user);
    }
}