package com.uce.edu;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Propietario;
import com.uce.edu.repository.modelo.Vehiculo;
import com.uce.edu.service.IMatriculaService;
import com.uce.edu.service.IPropietarioService;
import com.uce.edu.service.IVehiculoService;

@SpringBootApplication
public class EjercicioPa2U1P5LvApplication implements CommandLineRunner {

	@Autowired
	private IMatriculaService iMatriculaService;
	@Autowired
	private IVehiculoService iVehiculoService;
	@Autowired
	private IPropietarioService iPropietarioService;
	
	public static void main(String[] args) {
		SpringApplication.run(EjercicioPa2U1P5LvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setMarca("Chevrolet");
		vehiculo.setTipo("liviano");
		vehiculo.setPlaca("PCC-12");
		vehiculo.setPrecio(new BigDecimal(15000));
		this.iVehiculoService.guardar(vehiculo);
		System.out.println(vehiculo);
		
		Propietario propietario= new Propietario();
		propietario.setApellido("Valladares");
		propietario.setNombre("Luis");
		propietario.setCedula("178454");
		propietario.setGenero("masculino");
		this.iPropietarioService.guardar(propietario);
		System.out.println(propietario);
		//actualizar2 atributos
		propietario.setNombre("Ernesto");
		propietario.setApellido("Bastidas");
		this.iPropietarioService.actualizar(propietario);
		System.out.println(propietario);
		this.iMatriculaService.matricula("178454", "PCC-12");
		
	}

}
