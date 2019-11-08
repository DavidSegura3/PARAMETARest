package com.parameta.restapi.models.services;

import java.util.List;

import com.parameta.restapi.models.entity.Empleado;

public interface IEmpleadoService 
{
	public List<Empleado> findAll();
	public Empleado findById(long id);
}
