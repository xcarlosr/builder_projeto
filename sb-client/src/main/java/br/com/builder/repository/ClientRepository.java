package br.com.builder.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.builder.exceptions.ObjectNotFoundException;
import br.com.builder.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
	
	@Query(value = "FROM Client c "
			+ "WHERE "
			+ "c.nome like %:value% OR "
			+ "c.email like %:value% OR "
			+ "c.idade like %:value% ")
	public Optional<Page<Client>> findByParameter(@Param("value") String value, Pageable pageable) throws ObjectNotFoundException;

	@Query(value = "SELECT * FROM CLIENT where data_cadastro BETWEEN :data1 and :data2 ", nativeQuery = true)
	public Optional<Page<Client>> findByDataCadastro(@Param("data1") String data1, @Param("data2") String data2, Pageable pageable) throws ObjectNotFoundException;

}
