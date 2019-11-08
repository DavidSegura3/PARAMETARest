package com.parameta.restapi.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.parameta.restapi.models.dao.IEmpleadoDao;
import com.parameta.restapi.models.entity.Empleado;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService 
{

	@Autowired
	private IEmpleadoDao empleadoDao; 
	
	@Override
	@Transactional(readOnly = true)
	public List<Empleado> findAll() 
	{
		return (List<Empleado>) empleadoDao.findAll();
	}
	
	@Override
	public Empleado findById(long id)
	{
		Empleado empleado = empleadoDao.findById(id).get();
		return empleado;
	}
	
}
