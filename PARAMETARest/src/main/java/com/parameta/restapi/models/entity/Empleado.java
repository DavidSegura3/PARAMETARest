package com.parameta.restapi.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="empleado")
public class Empleado implements Serializable
{
	
	/**
	 * 
	*/
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nombres;
	private String apellidos;
	
	@Column(name="tipo_documento")
	private String tipoDocumento;
	
	@Column(name="numero_documento")
	private String numeroDocumento;
	
	@Column(name="fecha_nacimiento")
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	
	@Column(name="fecha_vinculacion_compania")
	@Temporal(TemporalType.DATE)
	private Date fechaVinculacionCompania;
	
	private String cargo;
	private double salario;
	
	public Long getId() 
	{
		return id;
	}
	
	public void setId(long id) 
	{
		this.id = id;
	}
	
	public String getNombres() 
	{
		return nombres;
	}
	
	public void setNombres(String nombres) 
	{
		this.nombres = nombres;
	}
	
	public String getApellidos() 
	{
		return apellidos;
	}
	
	public void setApellidos(String apellidos) 
	{
		this.apellidos = apellidos;
	}
	
	public String getTipoDocumento() 
	{
		return tipoDocumento;
	}
	
	public void setTipoDocumento(String tipoDocumento) 
	{
		this.tipoDocumento = tipoDocumento;
	}
	
	public String getNumeroDocumento() 
	{
		return numeroDocumento;
	}
	
	public void setNumeroDocumento(String numeroDocumento) 
	{
		this.numeroDocumento = numeroDocumento;
	}
	
	public Date getFechaNacimiento() 
	{
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(Date fechaNacimiento) 
	{
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Date getFechaVinculacionCompania() 
	{
		return fechaVinculacionCompania;
	}
	
	public void setFechaVinculacionCompania(Date fechaVinculacionCompania) 
	{
		this.fechaVinculacionCompania = fechaVinculacionCompania;
	}
	
	public String getCargo() 
	{
		return cargo;
	}
	
	public void setCargo(String cargo) 
	{
		this.cargo = cargo;
	}
	
	public double getSalario() 
	{
		return salario;
	}
	
	public void setSalario(double salario) 
	{
		this.salario = salario;
	}
}