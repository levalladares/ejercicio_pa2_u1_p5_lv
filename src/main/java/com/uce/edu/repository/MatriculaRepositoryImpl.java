package com.uce.edu.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Matricula;

@Repository
public class MatriculaRepositoryImpl implements IMatriculaRepository {

	private static List<Matricula> base = new ArrayList<>();

	@Override
	public Matricula seleccionar(String codigo) {
		// TODO Auto-generated method stub
		for (Matricula matricula : base) {
			if (matricula.getCodigo().equals(codigo)) {
				return matricula;
			}
		}
		return null;
	}

	@Override
	public void insertar(Matricula matricula) {
		// TODO Auto-generated method stub
		base.add(matricula);

	}

	@Override
	public void actualizar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.eliminar(matricula.getCodigo());
		this.insertar(matricula);
	}

	@Override
	public void eliminar(String codigo) {
		// TODO Auto-generated method stub
		Matricula matricula = this.seleccionar(codigo);
		base.remove(matricula);

	}

}
