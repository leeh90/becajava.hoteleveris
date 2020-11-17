package br.hoteleveris.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.hoteleveris.app.model.ComodidadeQuarto;

@Repository
public interface ComodidadeQuartoRepository extends JpaRepository<ComodidadeQuarto,Long> {
	
}
