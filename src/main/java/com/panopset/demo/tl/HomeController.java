
package com.panopset.demo.tl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.panopset.demo.data.FooSampleData;
import com.panopset.demo.data.hibernate.Foo;
import com.panopset.demo.data.repo.FooRepository;

/**
 * MVC Controller.
 * @author Karl Dinwiddie
 *
 */
@Controller
@RequestMapping("/")
public final class HomeController {

    /**
    * Foo database access object.
    */
    @Autowired
    private FooRepository fooRepo;

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
    public String handleRequest(final Model model,
            final HttpServletRequest request) {
        model.addAttribute("fooList", getCachedFoos());
        return "index";
    }

    /**
     * Cache the data locally for this example.  Wouldn't do this typically, in
     * real life you would call readFoos to populate the fooList attribute.
     * @return The featured foos.
     */
    private List<Foo> getCachedFoos() {
        if (ff == null) {
            ff = readFoos();
            if (ff.isEmpty()) {
                for (Foo foo : new FooSampleData().getArray()) {
                    fooRepo.save(foo);
                }
                ff = readFoos();
            }
        }
        return ff;
    }

    /**
     * @return List of Foo Objects read from the data repository.
     */
    private List<Foo> readFoos() {
        ArrayList<Foo> foos = new ArrayList<Foo>();
        for (Foo foo : fooRepo.findAll()) {
            foos.add(foo);
        }
        return foos;
    }

    /**
     * Featured foos.
     */
    private List<Foo> ff;
}
