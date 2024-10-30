package com.oracle.empleadosoke.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "empleados")
public class Empleado {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "nombre", length = 50, nullable = false)
  private String nombre;

  @Column(name = "puesto", length = 50, nullable = false)
  private String puesto;

  @Column(name = "salario", nullable = false)
  private Double salario;

  // Getters y Setters
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getPuesto() {
    return puesto;
  }

  public void setPuesto(String puesto) {
    this.puesto = puesto;
  }

  public Double getSalario() {
    return salario;
  }

  public void setSalario(Double salario) {
    this.salario = salario;
  }
}