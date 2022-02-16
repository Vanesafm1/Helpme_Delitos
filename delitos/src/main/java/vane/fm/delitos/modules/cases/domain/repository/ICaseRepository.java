package vane.fm.delitos.modules.cases.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vane.fm.delitos.modules.cases.domain.model.Case;

public interface ICaseRepository  extends JpaRepository <Case, Long> {}
