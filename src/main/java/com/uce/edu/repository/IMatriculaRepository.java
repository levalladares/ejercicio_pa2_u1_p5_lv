package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Matricula;

public interface IMatriculaRepository {

	public Matricula seleccionar(String codigo);

	public void insertar(Matricula matricula);

	public void actualizar(Matricula matricula);

	public void eliminar(String codigo);
	

}
