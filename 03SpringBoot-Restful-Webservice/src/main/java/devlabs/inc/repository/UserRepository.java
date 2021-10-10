package devlabs.inc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import devlabs.inc.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
