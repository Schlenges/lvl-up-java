package lvlup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lvlup.domain.Skill;
import lvlup.repository.SkillRepository;

import java.util.List;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    public List<Skill> listAll(){
        return skillRepository.findAll();
    }

    public Skill showOne(Long id){
        return skillRepository.findOne(id);
    }

    public void create(String name, int currLvl, int maxLvl){
        Skill skill = new Skill();
        skill.setName(name);
        skill.setCurr_lvl(currLvl);
        skill.setMax_lvl(maxLvl);
        skill.setCurr_xp(0);
        skillRepository.save(skill);
    }

    public void update(Long id, int xp){
        Skill skill = skillRepository.findOne(id);
        int currXp = skill.getCurr_xp() + xp;

        // check for level update
        if(currXp >= 100){
            if(skill.getCurr_lvl() < skill.getMax_lvl()){
                skill.setCurr_lvl(skill.getCurr_lvl() + 1);
                currXp -= 100;
            } else{
                currXp = 100;
                skill.setCurr_lvl(skill.getMax_lvl());
            }
        }

        skill.setCurr_xp(currXp);
        skillRepository.save(skill);
    }
}
