package pl.virtualconcierge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.virtualconcierge.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
