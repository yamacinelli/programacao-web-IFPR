package yamacinelli.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yamacinelli.core.entity.Commit;
import yamacinelli.core.repository.CommitRepository;

import java.util.List;

@Service
public class CommitService {

    @Autowired
    private CommitRepository commitRepository;

    public void save(Commit commit) {
        this.commitRepository.save(commit);
    }

    public void delete(Integer id) {
        this.commitRepository.deleteById(id);
    }

    public List<Commit> findAll() {
        return this.commitRepository.findAll();
    }
}