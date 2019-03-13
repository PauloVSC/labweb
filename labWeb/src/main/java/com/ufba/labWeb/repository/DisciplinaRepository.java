package com.ufba.labWeb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ufba.bean.Disciplina;

public interface DisciplinaRepository extends MongoRepository<Disciplina, String> {
	Iterable<Disciplina> findByProfessor(String professor);
}
