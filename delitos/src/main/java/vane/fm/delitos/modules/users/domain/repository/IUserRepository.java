package vane.fm.delitos.modules.users.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vane.fm.delitos.modules.users.domain.model.User;

public interface IUserRepository extends JpaRepository<User, Long> {}
