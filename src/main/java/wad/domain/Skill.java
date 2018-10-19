package wad.domain;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="Skills")
public class Skill extends AbstractPersistable<Long> {

    private String name;
    private int curr_lvl;
    private int max_lvl;
    private int curr_xp;
    @OneToMany
    private List<Battle> battles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurr_lvl() {
        return curr_lvl;
    }

    public void setCurr_lvl(int curr_lvl) {
        this.curr_lvl = curr_lvl;
    }

    public int getMax_lvl() {
        return max_lvl;
    }

    public void setMax_lvl(int max_lvl) {
        this.max_lvl = max_lvl;
    }

    public int getCurr_xp() {
        return curr_xp;
    }

    public void setCurr_xp(int curr_xp) {
        this.curr_xp = curr_xp;
    }

    public List<Battle> getBattles() {
        return battles;
    }

    public void setBattles(List<Battle> battles) {
        this.battles = battles;
    }
}
