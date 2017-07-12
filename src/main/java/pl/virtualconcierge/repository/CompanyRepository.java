package pl.virtualconcierge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.virtualconcierge.model.City;
import pl.virtualconcierge.model.Company;
import pl.virtualconcierge.model.User;

public interface CompanyRepository extends JpaRepository<Company, Long> {
	
	//@Query("select	u	from	User	u	where	u.firstname	=	:firstname	or	u.lastname	=	:lastname")
	//User findByLastnameOrFirstname(@Param("lastname") String lastname, @Param("firstname") String firstname);
	//@Query("select c from Company c where c.name = :name	and	c.type = :type")
	//Company findByNameAndType(@Param("name") String name, @Param("type") String type);
	Company findByNameAndServiceType(String name, String serviceType);
	@Query("SELECT cm FROM Company cm "
			+ "JOIN cm.serviceType sr "
			+ "JOIN cm.address ad "
			+ "JOIN ad.city ci "
			+ "WHERE sr.id = :serviceId "
			+ "AND ci.id = :cityId")
	List<Company> findCompaniesByCityAndService(@Param("serviceId") Long service,
			@Param("cityId") Long city);

	@Query("SELECT DISTINCT city FROM Company company "
		 + "JOIN company.serviceType service "
		 + "JOIN company.address address "
		 + "JOIN address.city city "
		 + "WHERE service.id = :id")
	List<City> findCitiesByService(@Param("id") Long id);
	Company findByEmail(String email);
	Company findById(Long companyId);
}
