package com.umbook.server.domain;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import com.umbook.shared.domain.Generos;
import javax.persistence.Enumerated;
import com.umbook.shared.domain.Roles;
import java.util.Set;
import com.umbook.server.domain.Comentario;
import java.util.HashSet;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import com.umbook.server.domain.Publicacion;
import com.umbook.server.domain.Amistad;

@RooJavaBean
@RooToString
@RooEntity
public class Usuario {

    @NotNull
    private String nombre;

    @NotNull
    private String apellido;

    @NotNull
    private String correo_electronico;

    @NotNull
    private String contrasena;

    @Enumerated
    private Generos sexo;

    @NotNull
    private String pregunta_secreta;

    @Enumerated
    private Roles rol;

    private Boolean estado;

    private String foto_perfil;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "emisor")
    private Set<Comentario> comentarios = new HashSet<Comentario>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "emisor")
    private Set<Publicacion> publicaciones = new HashSet<Publicacion>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario_1")
    private Set<Amistad> amistad = new HashSet<Amistad>();
}
