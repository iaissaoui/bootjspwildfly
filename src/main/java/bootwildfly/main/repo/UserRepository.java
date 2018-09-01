package bootwildfly.main.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bootwildfly.main.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByLnStartsWithIgnoreCase(String ln);

}
