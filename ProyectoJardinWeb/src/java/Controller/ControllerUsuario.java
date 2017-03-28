/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entitys.Persona;
import Entitys.Usuarios;
import Facade.PersonaFacade;
import Facade.UsuariosFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author Johann48
 */
@Named(value = "controllerUsuario")
@SessionScoped
public class ControllerUsuario implements Serializable {

    @EJB
    UsuariosFacade facadeusuario;
    @EJB
    PersonaFacade facadepersona;
    
    private Persona persona;
    private Usuarios usuario;
    private List<Usuarios> listausuarios;
    /**
     * Creates a new instance of ControllerUsuario
     */
    public ControllerUsuario() {
    }
    @PostConstruct
    public void init(){
        usuario = new Usuarios();
        persona = new Persona();
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public List<Usuarios> getListausuarios() {
        return listausuarios;
    }

    public void setListausuarios(List<Usuarios> listausuarios) {
        this.listausuarios = listausuarios;
    }
    public String crearUsuarios(){
        usuario.setPersonaidentificacion(facadepersona.find(persona.getIdentificacion()));
        facadeusuario.create(usuario);
        usuario = new Usuarios();
        return "listarUsuarios";
    }
    public List<Usuarios> consultarUsuarios(){
        this.listausuarios = facadeusuario.findAll();
        return listausuarios;
    }
    public String actualizarUsuarios(){
        usuario.setPersonaidentificacion(facadepersona.find(persona.getIdentificacion()));
        facadeusuario.edit(usuario);
        usuario = new Usuarios();
        return "listarUsuarios";
    }
    public String actualizarUsuarios(Usuarios usuario){
        this.usuario = usuario;
        return "editarUsuarios";
    }
    public void eliminarUsuario(Usuarios usuario){
        facadeusuario.remove(usuario);
    }
    public String login(){
        Usuarios user = new Usuarios();
        user = facadeusuario.loginUsuario(usuario);
        String redireccion;
        if (user != null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("autorizacion", user);
            usuario = (Usuarios)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("autorizacion");
            redireccion = "Paginas/Inicio";
        }else{
            redireccion = "Index";
        }
        return redireccion;
    }
    public String logOut(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "Index";
    }
}
