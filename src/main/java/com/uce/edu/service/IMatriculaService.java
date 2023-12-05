package com.uce.edu.service;

import com.uce.edu.repository.modelo.Matricula;

public interface IMatriculaService {

	public Matricula buscar(String codigo);

	public void guardar(Matricula matricula);

	public void actualizar(Matricula matricula);

	public void eliminar(String codigo);

	public void matricula(String cedula, String placa);

}
