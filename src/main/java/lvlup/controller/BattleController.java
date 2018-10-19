package lvlup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import lvlup.service.BattleService;

@Controller
public class BattleController {

    @Autowired
    private BattleService battleService;

    // Create a new battle
    @RequestMapping(value="/battles", method=RequestMethod.POST)
    public String createBattle(@RequestParam Long skillId, @RequestParam String description, @RequestParam int xp){
        battleService.create(skillId, description, xp);
        return "redirect:/skills/" + skillId.toString();
    }

    // Edit an existing battle

    // Delete a battle
        // references

    // Get the battles edit form
    @RequestMapping(value="/skills/{skillId}/addBattle", method=RequestMethod.GET)
    public String battleEditForm(Model model, @PathVariable Long skillId){
        model.addAttribute("skillId", skillId);
        return "editBattle";
    }

}