package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wad.service.SkillService;

@Controller
public class SkillController {

    @Autowired
    private SkillService skillService;

    // List all skills
    @RequestMapping(value="/skills", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("skills", skillService.listAll());
        return "skills";
    }

    // Show one individual skill
    @RequestMapping(value="/skills/{skillId}", method=RequestMethod.GET)
    public String show(Model model, @PathVariable Long skillId){
        model.addAttribute("skill", skillService.showOne(skillId));
        return "battles";
    }

    // Create a new skill
    @RequestMapping(value="/skills", method=RequestMethod.POST)
    public String create(@RequestParam String name, @RequestParam int currLvl, @RequestParam int maxLvl){
        skillService.create(name, currLvl, maxLvl);
        return "redirect:/skills";
    }

    // Update skill xp
    @RequestMapping(value="/skills/{skillId}", method=RequestMethod.POST)
    public String update(@PathVariable Long skillId, @RequestParam int xp){
        skillService.update(skillId, xp);
        return "redirect:/skills/" + skillId.toString();
    }

    // Edit an existing skill

    // Delete a skill

    // Get the skill edit form
    @RequestMapping(value="/addSkill", method=RequestMethod.GET)
    public String editForm(){
        return "editSkills";
    }
}
