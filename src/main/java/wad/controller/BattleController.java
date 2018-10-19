package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wad.domain.Battle;
import wad.domain.Skill;
import wad.repository.BattleRepository;
import wad.repository.SkillRepository;

import javax.transaction.Transactional;

@Controller
public class BattleController {

    @Autowired
    private BattleRepository battleRepository;
    @Autowired
    private SkillRepository skillRepository;

    // Create a new battle (and assign it to skill)
    @RequestMapping(value="/battles", method=RequestMethod.POST)
    // @Transactional
    public String createBattle(@RequestParam Long skillId, @RequestParam String description, @RequestParam int xp){
        Battle battle = new Battle();
        battle.setDescription(description);
        battle.setXp(xp);
        // assign
        Skill skill = skillRepository.findOne(skillId);
        battle.setSkill(skill);
        battleRepository.save(battle);

        skill.getBattles().add(battle);
        skillRepository.save(skill);

        return "redirect:/skills/" + skillId.toString();
    }

    // Edit an existing battle

    // Delete a battle
        // references

    // Update xp
    @RequestMapping(value="/skills/{skillId}", method=RequestMethod.POST)
    public String update(@PathVariable Long skillId, @RequestParam int xp){
        Skill skill = skillRepository.findOne(skillId);
        skill.setCurr_xp(skill.getCurr_xp() + xp);
        skillRepository.save(skill);
        return "redirect:/skills/" + skillId.toString();
    }

    // Get the battles edit form
    @RequestMapping(value="/skills/{skillId}/addBattle", method=RequestMethod.GET)
    public String battleEditForm(Model model, @PathVariable Long skillId){
        model.addAttribute("skillId", skillId);
        return "editBattle";
    }

}