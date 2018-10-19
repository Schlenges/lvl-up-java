package lvlup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import lvlup.domain.Battle;

public interface BattleRepository extends JpaRepository<Battle, Long> {
}
