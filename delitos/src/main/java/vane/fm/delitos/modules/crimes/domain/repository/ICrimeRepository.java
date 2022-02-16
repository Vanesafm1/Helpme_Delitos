package vane.fm.delitos.modules.crimes.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vane.fm.delitos.modules.crimes.domain.model.Crime;

public interface ICrimeRepository extends JpaRepository<Crime, Long>{}
