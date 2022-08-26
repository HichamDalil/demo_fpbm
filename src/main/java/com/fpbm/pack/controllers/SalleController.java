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
    public String viewHomePageSalle(Model model) {
        List<Salle> listsalle = salleService.getAll();
        model.addAttribute("listsalle", listsalle);
        System.out.print("Get / ");
        return "index";
    }
    @GetMapping("/homedep")
    public String viewHomePagedep(Model model) {
        List<Departement> departementList=dep_serv.getAll();
        model.addAttribute("departementList", departementList);
        System.out.print("Get /dep ");
        return "homedepartement";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveSalle(@ModelAttribute("salle") Salle s) {
        salleService.save(s);
        return "redirect:/";
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

   /* @DeleteMapping("/delete/{id}")
    public String deleteSalle(@PathVariable(name = "id") Long id){
        salleService.delete(id);
        return "Deleted Successfully.................";
    }*/
   @RequestMapping("/deleteSalle/{id}")
   public String deletesalle(@PathVariable(name = "id") long id) {
       salleService.delete(id);
       return "redirect:/";
   }

}
