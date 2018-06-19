package com.beheresoft.security.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Aladi
 */
@Controller
@RequestMapping("/protected")
public class ProtectedController {

    @RequestMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("index");
    }

}
