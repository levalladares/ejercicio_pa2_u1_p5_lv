package com.uce.edu.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IMatriculaRepository;
import com.uce.edu.repository.IPropietarioRepository;
import com.uce.edu.repository.IVehiculoRepository;
import com.uce.edu.repository.modelo.Matricula;
import com.uce.edu.repository.modelo.Propietario;
import com.uce.edu.repository.modelo.Vehiculo;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

	@Autowired
	private IMatriculaRepository iMatriculaRepository;
	@Autowired
	private IVehiculoRepository iVehiculoRepository;
	@Autowired
	private IPropietarioRepository iPropietarioRepository;

	@Override
	public Matricula buscar(String codigo) {
		// TODO Auto-generated method stub
		return this.iMatriculaRepository.seleccionar(codigo);
	}

	@Override
	public void guardar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.iMatriculaRepository.insertar(matricula);
	}

	@Override
	public void actualizar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.iMatriculaRepository.actualizar(matricula);
	}

	@Override
	public void eliminar(String codigo) {
		// TODO Auto-generated method stub
		this.iMatriculaRepository.eliminar(codigo);

	}

	@Override
	public void matricula(String cedula, String placa) {
		// TODO Auto-generated method stub
		Vehiculo vehi = this.iVehiculoRepository.seleccionar(placa);

		Propietario prop = this.iPropietarioRepository.seleccionar(cedula);

		Matricula matri = new Matricula();
		matri.setPropietario(prop);
		matri.setVehiculo(vehi);
		matri.setFechaMatricula(LocalDate.now());

		if (matri.getVehiculo().getTipo().equals("pesado")) {
			matri.setValorMatricula(matri.getVehiculo().getPrecio().multiply(new BigDecimal(0.25)));
			System.out.println("Matricula sin descuento" + matri);
			if (matri.getValorMatricula().compareTo(new BigDecimal(2200)) > 0) {
				BigDecimal descuento = matri.getValorMatricula().multiply(new BigDecimal(0.05));
				matri.setValorMatricula(matri.getValorMatricula().subtract(descuento));
				this.iMatriculaRepository.actualizar(matri);
				System.out.println("Matricula con descuento" + matri);
			}
		} else {
			matri.setValorMatricula(matri.getVehiculo().getPrecio().multiply(new BigDecimal(0.20)));
			System.out.println("Matricula sin descuento" + matri);
			if (matri.getValorMatricula().compareTo(new BigDecimal(2200)) > 0) {
				BigDecimal descuento = matri.getValorMatricula().multiply(new BigDecimal(0.05));
				matri.setValorMatricula(matri.getValorMatricula().subtract(descuento));
				this.iMatriculaRepository.actualizar(matri);
				System.out.println("Matricula con descuento" + matri);
			}
		}

		this.iMatriculaRepository.insertar(matri);
	}

}
