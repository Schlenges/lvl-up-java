package wad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
