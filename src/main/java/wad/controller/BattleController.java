package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.repository.BattleRepository;
import wad.repository.SkillRepository;

@Controller
public class BattleController {

    @Autowired
    private BattleRepository battleRepository;
    @Autowired
    private SkillRepository skillRepository;

    @RequestMapping(value="/battles", method= RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("skills", skillRepository.findAll());
        return "battles";
    }
}
