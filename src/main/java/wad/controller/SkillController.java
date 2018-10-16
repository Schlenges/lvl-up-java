package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wad.domain.Skill;
import wad.repository.SkillRepository;

@Controller
public class SkillController {

    @Autowired
    private SkillRepository skillRepository;

    @RequestMapping(value="/skills", method= RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("skills", skillRepository.findAll());
        return "skills";
    }

    @RequestMapping(value="/skills/{skillId}", method=RequestMethod.GET)
    public String show(Model model, @PathVariable Long skillId){
        model.addAttribute("skill", skillRepository.findOne(skillId));
        return "skill";
    }

    @RequestMapping(value="/skills", method=RequestMethod.POST)
    public String create(@RequestParam String name, @RequestParam int currLvl, @RequestParam int maxLvl, @RequestParam int currXp){
        Skill skill = new Skill();
        skill.setName(name);
        skill.setCurr_lvl(currLvl);
        skill.setMax_lvl(maxLvl);
        skill.setCurr_xp(currXp);
        skillRepository.save(skill);
        return "redirect:/skills";
    }

    @RequestMapping(value="/editSkill", method=RequestMethod.GET)
    public String editForm(){
        return "editSkills";
    }

    // get / return skills
    // get /skills/id return skill
}
