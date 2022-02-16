package vane.fm.delitos.modules.users.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vane.fm.delitos.modules.users.domain.model.Role;

public interface IRoleRepository extends JpaRepository<Role, Long> { }
