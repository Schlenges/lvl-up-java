package wad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.Battle;

public interface BattleRepository extends JpaRepository<Battle, Long> {
}
