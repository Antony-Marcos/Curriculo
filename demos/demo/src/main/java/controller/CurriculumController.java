package controller;
import model.Curriculum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.CurriculumRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/curriculum")
public class CurriculumController {

    @Autowired
    private CurriculumRepository curriculumRepository;

    @GetMapping
    public ResponseEntity<List<Curriculum>> getAllCurriculum() {
        List<Curriculum> curriculumList = curriculumRepository.findAll();
        return new ResponseEntity<>(curriculumList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curriculum> getCurriculumById(@PathVariable UUID id) {
        Optional<Curriculum> curriculum = curriculumRepository.findById(id);
        if (curriculum.isPresent()) {
            return new ResponseEntity<>(curriculum.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Curriculum> createCurriculum(@RequestBody Curriculum newCurriculum) {
        Curriculum createdCurriculum = curriculumRepository.save(newCurriculum);
        return new ResponseEntity<>(createdCurriculum, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurriculum(@PathVariable UUID id) {
        curriculumRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

