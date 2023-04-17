package yamacinelli.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yamacinelli.core.entity.Commit;

public interface CommitRepository extends JpaRepository<Commit, Integer> {

}
