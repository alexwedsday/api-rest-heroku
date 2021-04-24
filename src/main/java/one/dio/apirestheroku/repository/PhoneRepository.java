package one.dio.apirestheroku.repository;

import one.dio.apirestheroku.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long > {
}
