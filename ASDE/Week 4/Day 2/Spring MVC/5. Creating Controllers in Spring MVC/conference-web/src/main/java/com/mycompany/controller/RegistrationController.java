package com.mycompany.controller;

import java.util.Map;

//import javax.validation.Valid;

import com.mycompany.model.Registration;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

//import com.mycompany.model.Registration;

@Controller
public class RegistrationController {

//	@GetMapping("registration")
//	public String getRegistration(Map<String, Object> model) {
//		return "registration";
//	}

    @GetMapping("registration")
    public String getRegistration(@ModelAttribute("registration") Registration registration) {
        return "registration";
    }


    @PostMapping("registration")
    public String addRegistration(@ModelAttribute("registration")
                                  Registration registration
    ) {

        System.out.println("Registration: " + registration.getName());
        return "redirect:registration";
    }

}
