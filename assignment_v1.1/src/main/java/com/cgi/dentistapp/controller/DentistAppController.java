package com.cgi.dentistapp.controller;

import com.cgi.dentistapp.dto.DentistVisitDTO;
import com.cgi.dentistapp.entity.DentistVisitEntity;
import com.cgi.dentistapp.service.DentistVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class DentistAppController extends WebMvcConfigurerAdapter {

    @Autowired
    private DentistVisitService dentistVisitService = new DentistVisitService();

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/")
    public String showRegisterForm(DentistVisitDTO dentistVisitDTO) {
        return "form";
    }

    @PostMapping("/")
    public String postRegisterForm(@Valid DentistVisitDTO dentistVisitDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        if (TimeCheck(Long.valueOf("0"), dentistVisitDTO.getDentistName(), dentistVisitDTO.getVisitTime())) {
            dentistVisitService.addVisit(dentistVisitDTO.getDentistName(), dentistVisitDTO.getVisitTime());
            return "redirect:/results";
        } else {
            throw new IllegalStateException("Sellel kellaajal juba toimub visiit!");
        }
    }

    @RequestMapping(value="/results", method=RequestMethod.GET)
    public String allVisits(Model model) {
        List<DentistVisitEntity> allVisits = dentistVisitService.getDentistVisits();
        model.addAttribute("registrations", allVisits);
        return "results";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        DentistVisitEntity dentistVisitEntity = dentistVisitService.getDentistVisitById(id);
        model.addAttribute("registration", dentistVisitEntity);
        return "update";
    }

    @RequestMapping(path = {"/update", "/update/{id}"}, method = RequestMethod.POST)
    public String updateVisitById(Model model, @PathVariable("id") Long id, @Valid DentistVisitDTO dentistVisitDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "update";
        }
        if (TimeCheck(id, dentistVisitDTO.getDentistName(), dentistVisitDTO.getVisitTime())) {
            dentistVisitService.updateVisit(id, dentistVisitDTO.getDentistName(), dentistVisitDTO.getVisitTime());
            return "redirect:/results";
        } else {
            throw new IllegalStateException("Sellel kellaajal juba toimub visiit!");
        }
    }

    @RequestMapping(path = "/delete/{id}", method=RequestMethod.GET)
    public String deleteVisitById(Model model, @PathVariable("id") Long id) {
        dentistVisitService.deleteDentistVisitById(id);
        return "redirect:/results";
    }

    @RequestMapping(value = "/search")
    public String searchPage(Model model, @Param("keyword") String keyword) {
        List<DentistVisitEntity> listVisits = dentistVisitService.listAll(keyword);
        model.addAttribute("listVisits", listVisits);
        model.addAttribute("keyword", keyword);
        return "search";
    }

    @AssertTrue
    public boolean TimeCheck(Long id, String dentistName, LocalDateTime visitTime) {
        List<DentistVisitEntity> allVisits = dentistVisitService.getDentistVisits();
        for (int i = 0; i < allVisits.size(); i++) {
            if (allVisits.get(i).getDentistName().equals(dentistName) && allVisits.get(i).getVisitTime().isBefore(visitTime.plusMinutes(30)) && allVisits.get(i).getVisitTime().isAfter(visitTime.minusMinutes(30))) {
                if (allVisits.get(i).getId() == id) {
                    return true;
                }
                return false;
            }
        }
        return true;
    }

}
