package engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class MyController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String onIndex() {
        return "fillingForm";
    }

    @RequestMapping(value = "/form/add", method = RequestMethod.POST)
    public String page1(Model model, @RequestParam(required = false) String name,
                        @RequestParam(required = false) String ageStr) {
        int age = 0;
        System.out.println(name + " " + ageStr);
        if(name != null && isInteger(ageStr) != null) {
            userService.add(new User(name, age));
        }

        model.addAttribute("users", userService.users());
        return "showUsers";
    }


    private Integer isInteger(String s) {
        int age;
        try {
            age = Integer.parseInt(s);
        } catch(NumberFormatException | NullPointerException e) {
            System.out.println("lol");
            return null;
        }
        return age;
    }
}
