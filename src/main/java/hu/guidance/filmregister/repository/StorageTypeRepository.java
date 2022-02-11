package hu.guidance.filmregister.repository;

import hu.guidance.filmregister.model.StorageType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageTypeRepository extends JpaRepository<StorageType, Long> {
}
