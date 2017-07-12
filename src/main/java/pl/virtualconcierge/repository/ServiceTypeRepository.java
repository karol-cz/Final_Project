package pl.virtualconcierge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.virtualconcierge.model.ServiceType;

public interface ServiceTypeRepository extends JpaRepository<ServiceType, Long>{

}
