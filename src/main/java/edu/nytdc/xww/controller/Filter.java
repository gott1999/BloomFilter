package edu.nytdc.xww.controller;

import edu.nytdc.xww.bloomFilter.GiveRandom;
import edu.nytdc.xww.bloomFilter.SimpleFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Filter {
    private SimpleFilter filter;

    @RequestMapping(value = "/bloomFilter", method = RequestMethod.POST)
    public ModelAndView init(@RequestParam("size") int size) {
        ModelAndView modelAndView = new ModelAndView("success");
        // limit the size of bitmap
        if (filter == null) {
            filter = size > 0 && size < 30 ? new SimpleFilter(size, new int[0]) : new SimpleFilter(15, new int[0]);
            modelAndView.addObject("message", "init success!");
        } else {
            modelAndView.addObject("message", "init fail!");
        }
        return modelAndView;
    }

    /**
     * add word
     *
     * @param word word
     * @return success page
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView addWords(@RequestParam("word") String word) {
        filter.add(word);
        ModelAndView modelAndView = new ModelAndView("success");
        modelAndView.addObject("message", "\"" + word + "\" is add");
        return modelAndView;
    }

    /**
     * random add some words
     *
     * @param random number
     * @return success page
     */
    @RequestMapping(value = "randomAddWords", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView randomAddWords(@RequestParam("random") int random) {
        randomAdd(random);
        ModelAndView modelAndView = new ModelAndView("success");
        modelAndView.addObject("message", random + " words is add");
        return modelAndView;
    }

    /**
     * check word
     *
     * @param word word
     * @return is exist?
     */
    @RequestMapping(value = "contains", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView contains(@RequestParam("word") String word) {
        ModelAndView modelAndView = new ModelAndView("success");
        modelAndView.addObject("message", "\"" + word + "\" exist? " + filter.contains(word));
        return modelAndView;
    }

    /**
     * give a rate of crash
     *
     * @param length Sampling
     * @return rate
     */
    @RequestMapping(value = "SamplingCheck", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView SamplingCheck(@RequestParam("length") int length) {
        ModelAndView modelAndView = new ModelAndView("success");
        modelAndView.addObject("message", randomCheck(length));
        return modelAndView;
    }

    /**
     * random add some String
     *
     * @param random number
     */
    public void randomAdd(int random) {
        for (int i = 0; i < random; i++) {
            filter.add(GiveRandom.randomString());
        }
    }

    /**
     * give a rate of clash
     *
     * @param length Sampling
     * @return rate
     */
    public String randomCheck(int length) {
        int ErrorCount = 0;
        for (int i = 0; i < 10000; i++) {
            if (filter.contains(GiveRandom.randomString(length))) {
                ErrorCount++;
            }
        }
        return "The rate of crash is around: " + ((ErrorCount * 1.0 / 10000) * 100) + "%";
    }

}
