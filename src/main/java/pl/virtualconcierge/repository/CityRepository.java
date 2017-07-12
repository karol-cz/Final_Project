package pl.virtualconcierge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.virtualconcierge.model.City;

public interface CityRepository extends JpaRepository<City, Long>{

}
