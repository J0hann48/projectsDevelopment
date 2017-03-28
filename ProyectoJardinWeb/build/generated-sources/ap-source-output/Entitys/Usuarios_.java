package Entitys;

import Entitys.Padresfamilia;
import Entitys.Persona;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-03-20T21:20:11")
@StaticMetamodel(Usuarios.class)
public class Usuarios_ { 

    public static volatile SingularAttribute<Usuarios, Persona> personaidentificacion;
    public static volatile SingularAttribute<Usuarios, String> estado;
    public static volatile SingularAttribute<Usuarios, String> mail;
    public static volatile ListAttribute<Usuarios, Padresfamilia> padresfamiliaList;
    public static volatile SingularAttribute<Usuarios, String> contrasena;
    public static volatile SingularAttribute<Usuarios, String> telefono;
    public static volatile SingularAttribute<Usuarios, Integer> idusuario;

}