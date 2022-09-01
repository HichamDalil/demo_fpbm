package com.fpbm.pack.controllers;
import com.fpbm.pack.entities.Departement;
import com.fpbm.pack.entities.Salle;


import com.fpbm.pack.serviceimpl.DepartementServiceImpl;
import com.fpbm.pack.serviceimpl.SalleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//@RestController
//@RequestMapping("/Salle")
@Controller
public class SalleController {
    @Autowired
    private SalleServiceImpl salleService;
    @Autowired
    private DepartementServiceImpl dep_serv;


    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Salle> listsalle = salleService.getAll();
        model.addAttribute("listsalle", listsalle);
        System.out.print("Get / ");
        return "home";
    }

    @GetMapping("/homedep")
    public String viewHomePagedep(Model model) {
        List<Departement> departementList=dep_serv.getAll();
        model.addAttribute("departementList", departementList);
        System.out.print("Get /homedep ");
        return "homedepartement";
    }
    @GetMapping("/newdep")
    public String addDep(Model model) {
        model.addAttribute("dep", new Departement());
        return "newDepartement";
    }
    @RequestMapping(value = "/savedep", method = RequestMethod.POST)
    public String saveDep(@ModelAttribute("Dep") Departement d) {
        dep_serv.save(d);
        return "redirect:/homedepartement";
    }
    @RequestMapping("/deletedep/{id}")
    public String deletedep(@PathVariable(name = "id") long id) {
        dep_serv.delete(id);
        return "redirect:/homedepartement";
    }
    @RequestMapping("/editdep/{id}")
    public ModelAndView showEditPageDepartement(@PathVariable(name = "id") long id) {
        ModelAndView mav = new ModelAndView("newDep");
        Departement d = dep_serv.getOne(id);
        mav.addObject("dep", d);
        return mav;
    }
    @GetMapping("/homesalle")
    public String viewHomePageSalle(Model model) {
        List<Salle> listsalle = salleService.getAll();
        model.addAttribute("listsalle", listsalle);
        System.out.print("Get / ");
        return "homesalle";
    }
    //****************************************************************
    @GetMapping("/getsalle/{name}")
    public ModelAndView showSalle_findbyname(@PathVariable(name = "name")String name) {
        ModelAndView mav = new ModelAndView("sallebyname");
        Salle listsalle = salleService.getByname(name);
        mav.addObject("salle", listsalle);

        System.out.print("Get /getsalle/{name} ");
        return mav;
    }
    //****************************************************************
    @RequestMapping(value = "/saveSalle", method = RequestMethod.POST)
    public String saveSalle(@ModelAttribute("salle") Salle s) {
        salleService.save(s);
        return "redirect:/saveSalle";
    }
    @GetMapping("/newSalle")
    public String add(Model model) {
        model.addAttribute("salle", new Salle());
        return "newSalle";
    }
    @RequestMapping("/editSalle/{id}")
    public ModelAndView showEditPageSalle(@PathVariable(name = "id") long id) {
        ModelAndView mav = new ModelAndView("newSalle");
        Salle s = salleService.getOne(id);
        mav.addObject("salle", s);
        return mav;

    }


   @RequestMapping("/deleteSalle/{id}")
   public String deletesalle(@PathVariable(name = "id") long id) {
       salleService.delete(id);
       return "redirect:/deleteSalle";
   }

}
