package ru.cgmd.uchet.repos;

import ru.cgmd.uchet.domain.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long> {
}
