package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IVehiculoRepository;
import com.uce.edu.repository.modelo.Vehiculo;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

	@Autowired
	IVehiculoRepository iVehiculoRepository;
	
	@Override
	public Vehiculo buscar(String placa) {
		// TODO Auto-generated method stub
		return this.iVehiculoRepository.seleccionar(placa);
	}

	@Override
	public void guardar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.iVehiculoRepository.insertar(vehiculo);
	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.iVehiculoRepository.actualizar(vehiculo);
	}

	@Override
	public void eliminar(String placa) {
		// TODO Auto-generated method stub
		this.iVehiculoRepository.eliminar(placa);
		
	}

}
