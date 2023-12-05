package com.uce.edu.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class Matricula {
	private String codigo; //PARA PODER HACER LOS METODOS ACTUALIZAR Y ELIMINAR
	private LocalDate fechaMatricula;
	private BigDecimal valorMatricula;
	private Propietario propietario;
	private Vehiculo vehiculo;

	@Override
	public String toString() {
		return "Matricula [fechaMatricula=" + fechaMatricula + ", valorMatricula=" + valorMatricula + ", propietario="
				+ propietario + ", vehiculo=" + vehiculo + "]";
	}

	// GET Y SET
	public LocalDate getFechaMatricula() {
		return fechaMatricula;
	}

	public void setFechaMatricula(LocalDate fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}

	public BigDecimal getValorMatricula() {
		return valorMatricula;
	}

	public void setValorMatricula(BigDecimal valorMatricula) {
		this.valorMatricula = valorMatricula;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
