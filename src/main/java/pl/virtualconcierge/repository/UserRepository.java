package pl.virtualconcierge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.virtualconcierge.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);

	User findById(Long userId);

}
