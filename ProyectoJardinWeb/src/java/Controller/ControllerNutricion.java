/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entitys.Alumnos;
import Entitys.Crecimientodesarrollo;
import Entitys.Nutricionalumnos;
import Facade.AlumnosFacade;
import Facade.CrecimientodesarrolloFacade;
import Facade.NutricionalumnosFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Johann48
 */
@Named(value = "controllerNutricion")
@SessionScoped
public class ControllerNutricion implements Serializable {

    @EJB
    NutricionalumnosFacade facadenutricion;
    @EJB
    AlumnosFacade facadealumnos;
    @EJB
    CrecimientodesarrolloFacade facadecrecimiento;
    
    private Nutricionalumnos nutricion;
    private Alumnos alumno;
    private Crecimientodesarrollo crecimiento;
    private List<Nutricionalumnos> listaNutricion;
    
    /**
     * Creates a new instance of ControllerNutricion
     */
    public ControllerNutricion() {
    }
    @PostConstruct
    public void init(){
        nutricion = new Nutricionalumnos();
        alumno = new Alumnos();
        crecimiento = new Crecimientodesarrollo();
    }

    public Nutricionalumnos getNutricion() {
        return nutricion;
    }

    public void setNutricion(Nutricionalumnos nutricion) {
        this.nutricion = nutricion;
    }

    public Alumnos getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumnos alumno) {
        this.alumno = alumno;
    }

    public Crecimientodesarrollo getCrecimiento() {
        return crecimiento;
    }

    public void setCrecimiento(Crecimientodesarrollo crecimiento) {
        this.crecimiento = crecimiento;
    }

    public List<Nutricionalumnos> getListaNutricion() {
        return listaNutricion;
    }

    public void setListaNutricion(List<Nutricionalumnos> listaNutricion) {
        this.listaNutricion = listaNutricion;
    }
    public String ingresarNutricionalumno(){
        nutricion.setAlumnosidentificacion(facadealumnos.find(alumno.getIdalumno()));
        nutricion.setIdcrecimientodesarrollo(facadecrecimiento.find(crecimiento.getIdCrecimientoDesarrollo()));
        facadenutricion.create(nutricion);
        nutricion = new Nutricionalumnos();  
        return "listarNutricionalumnos";
    }
    public List<Nutricionalumnos> consultarNutricionalumnos(){
        this.listaNutricion = facadenutricion.findAll();
        return listaNutricion;
    }
    public String actualizarNutricionalumno(Nutricionalumnos nutricion){
        this.nutricion = nutricion;
        return "editarNutricionalumnos";
    }
    public String actualizarNutricionalumno(){
        nutricion.setAlumnosidentificacion(facadealumnos.find(alumno.getIdalumno()));
        nutricion.setIdcrecimientodesarrollo(facadecrecimiento.find(crecimiento.getIdCrecimientoDesarrollo()));
        facadenutricion.edit(nutricion);
        return "listarNutricionalumnos";
    }
    public void eliminarNutricionalumno(Nutricionalumnos nutricion){
        facadenutricion.remove(nutricion);
    }
}
