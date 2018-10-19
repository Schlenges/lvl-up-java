package lvlup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import lvlup.domain.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
