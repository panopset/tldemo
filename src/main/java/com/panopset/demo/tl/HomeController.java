package com.panopset.demo.tl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    FooDAO fooDAO;

    /**
     * Handle http request.
     *
     * @param model
     *            Model.
     * @param request
     *            Request.
     * @return index.
     */
    @RequestMapping(method = RequestMethod.GET)
    public String handleRequest(Model model, HttpServletRequest request) {
        model.addAttribute("fooList", fooDAO.getFeaturedFoos());
        return "index";
    }
}
