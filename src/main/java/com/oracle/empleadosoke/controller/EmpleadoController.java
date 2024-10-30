package com.oracle.empleadosoke.controller;


import com.oracle.empleadosoke.model.Empleado;
import com.oracle.empleadosoke.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

  @Autowired
  private EmpleadoRepository empleadoRepository;

  @GetMapping
  public List<Empleado> getAllEmpleados() {
    return empleadoRepository.findAll();
  }

  @PostMapping
  public ResponseEntity<Empleado> createEmpleado(@RequestBody Empleado empleado) {
    Empleado nuevoEmpleado = empleadoRepository.save(empleado);
    return new ResponseEntity<>(nuevoEmpleado, HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Empleado> getEmpleadoById(@PathVariable Integer id) {
    return empleadoRepository.findById(id)
        .map(empleado -> new ResponseEntity<>(empleado, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Empleado> updateEmpleado(@PathVariable Integer id, @RequestBody Empleado empleadoDetalles) {
    return empleadoRepository.findById(id).map(empleado -> {
      empleado.setNombre(empleadoDetalles.getNombre());
      empleado.setPuesto(empleadoDetalles.getPuesto());
      empleado.setSalario(empleadoDetalles.getSalario());
      empleadoRepository.save(empleado);
      return new ResponseEntity<>(empleado, HttpStatus.OK);
    }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteEmpleado(@PathVariable Integer id) {
    if (empleadoRepository.existsById(id)) {
      empleadoRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
