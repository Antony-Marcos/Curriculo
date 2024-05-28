package service;


import model.Curriculum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CurriculumRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CurriculumService {

    @Autowired
    private CurriculumRepository curriculumRepository;

    public List<Curriculum> getAllCurriculum() {
        return curriculumRepository.findAll();
    }

    public Optional<Curriculum> getCurriculumById(UUID id) {
        return curriculumRepository.findById(id);
    }

    public Curriculum createCurriculum(Curriculum newCurriculum) {
        return curriculumRepository.save(newCurriculum);
    }

    public void deleteCurriculum(UUID id) {
        curriculumRepository.deleteById(id);
    }
}

