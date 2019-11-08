package com.parameta.restapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parameta.restapi.models.entity.Empleado;
import com.parameta.restapi.models.services.IEmpleadoService;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("/restapi")
public class EmpleadoRestController 
{
	@Autowired
	private IEmpleadoService empleadoService;
	
	@GetMapping("/empleados")
	public List<Empleado> listaEmpleados()
	{
		return empleadoService.findAll();
	}
	
	/** 
	 * Petición para obtener un empleado por ID.
	 * @param id Id del empleado a buscar.
	 * @return Retorna un mensaje y un código HttpStatus dependiendo la respuesta.
	 * @throws DataAccessException/Exception En caso de que falle consultando un empleado,
	 * bien sea por la conexión de la bd o el servidor.
	 * @author David Segura - 7/11/2019.
	 */
	@GetMapping("/empleado/{id}")
	public ResponseEntity<?> buscarEmpleadoId(@PathVariable long id)
	{
		Empleado empleado = null;
		JSONObject respuesta = new JSONObject();
		
		try
		{
			empleado = empleadoService.findById(id);
			if(empleado == null)
			{
				respuesta.put("respuesta", "El empleado " + id + " no existe en la base de datos.\n");
				return new ResponseEntity<JSONObject>(respuesta, HttpStatus.NOT_FOUND);
			}
			else
			{
				return new ResponseEntity<Empleado>(empleado, HttpStatus.OK);
			}
			
		}
		catch(DataAccessException e)
		{
			respuesta.put("error", "Error en la base de datos.\n");
			respuesta.put("causa", e.getMessage() + "\n" + e.getMostSpecificCause());
			respuesta.put("acción", "Por favor valide los datos de la base de datos y vuelva a intentarlo.\n");
			return new ResponseEntity<JSONObject>(respuesta, HttpStatus.CONFLICT);
		}
		catch(Exception e)
		{
			respuesta.put("error", "Problemas con servidor.\n");
			respuesta.put("causa", e.getMessage() + "\n" + e.getCause());
			respuesta.put("acción", "Por favor contactase con el administrador del recurso.\n");
			return new ResponseEntity<JSONObject>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
