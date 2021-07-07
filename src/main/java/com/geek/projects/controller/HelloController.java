package com.geek.projects.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.util.Date;

/**
 * HelloController
 *
 * @author <a href="mailto:fuchaozh@gmail.com">Charles</a>
 * @since
 */

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public ModelAndView getListaUtentiView(){
        ModelMap model = new ModelMap();
        model.addAttribute("now",DateFormat.getDateTimeInstance().format(new Date()));
        return new ModelAndView("hello", model);
    }
}
