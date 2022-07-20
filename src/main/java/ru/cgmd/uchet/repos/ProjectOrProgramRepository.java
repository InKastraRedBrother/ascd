package ru.cgmd.uchet.repos;

import ru.cgmd.uchet.domain.ProjectOrProgram;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectOrProgramRepository extends JpaRepository<ProjectOrProgram, Long> {

}