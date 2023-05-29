package com.soraluz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soraluz.model.bd.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
	Rol findByNomrol(String nomrol);
}
