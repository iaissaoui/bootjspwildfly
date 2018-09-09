package bootwildfly.main.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bootwildfly.main.model.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {

	List<AppUser> findByLnStartsWithIgnoreCase(String ln); 

}
 