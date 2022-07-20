package ru.cgmd.uchet.repos;

import ru.cgmd.uchet.domain.InformationProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationProductRepository extends JpaRepository<InformationProduct, Long> {
}
