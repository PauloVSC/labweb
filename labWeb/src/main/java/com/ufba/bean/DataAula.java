package com.ufba.bean;

import java.util.Date;
import java.util.List;

public class DataAula {

	private Date timestamp;
	private String disciplina;
	private List<AlunoAula> alunos;
	
	
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	public List<AlunoAula> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<AlunoAula> alunos) {
		this.alunos = alunos;
	}
	
}
