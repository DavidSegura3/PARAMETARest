package com.parameta.restapi.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.parameta.restapi.models.entity.Empleado;

public interface IEmpleadoDao extends CrudRepository<Empleado, Long> 
{

}
