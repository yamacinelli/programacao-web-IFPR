package yamacinelli.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import yamacinelli.core.entity.Commit;
import yamacinelli.core.service.CommitService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/commit")
public class CommitController {

    @Autowired
    private CommitService commitService;

    @PostMapping
    public void save(@RequestBody Commit commit) {
        this.commitService.save(commit);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        this.commitService.delete(id);
    }

    @GetMapping
    public List<Commit> findAll() {
        return this.commitService.findAll();
    }
}
