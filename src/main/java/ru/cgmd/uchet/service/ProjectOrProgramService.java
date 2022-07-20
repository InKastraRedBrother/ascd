package ru.cgmd.uchet.service;

import ru.cgmd.uchet.domain.ProjectOrProgram;
import ru.cgmd.uchet.repos.ProjectOrProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProjectOrProgramService {
    @Autowired
    private ProjectOrProgramRepository projectOrProgramRepository;

    public List<ProjectOrProgram> listAll() {
        return projectOrProgramRepository.findAll();
    }

    public void save(ProjectOrProgram projectOrProgram) {
        projectOrProgramRepository.save(projectOrProgram);
    }

    public ProjectOrProgram get(long idProjectOrProgram) {
        return projectOrProgramRepository.findById(idProjectOrProgram).get();
    }

    public void delete(long idProjectOrProgram) {
        projectOrProgramRepository.deleteById(idProjectOrProgram);
    }
}