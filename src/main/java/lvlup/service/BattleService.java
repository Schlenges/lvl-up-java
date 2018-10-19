package lvlup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import lvlup.domain.Battle;
import lvlup.domain.Skill;
import lvlup.repository.BattleRepository;
import lvlup.repository.SkillRepository;

import javax.transaction.Transactional;

@Controller
public class BattleService {

    @Autowired
    private BattleRepository battleRepository;
    @Autowired
    private SkillRepository skillRepository;

    @Transactional
    public void create(Long id, String description, int xp){
        Battle battle = new Battle();
        battle.setDescription(description);
        battle.setXp(xp);
        // assign
        Skill skill = skillRepository.findOne(id);
        battle.setSkill(skill);
        battleRepository.save(battle);

        skill.getBattles().add(battle);
        skillRepository.save(skill);
    }
}
