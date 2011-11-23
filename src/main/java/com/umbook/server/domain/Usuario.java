package com.umbook.server.domain;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.persistence.Column;
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
import com.umbook.server.domain.Notificacion;
import com.umbook.server.domain.Denuncia;
import com.umbook.shared.domain.EstadosUsuario;
import javax.persistence.EnumType;

@RooJavaBean
@RooToString
@RooEntity(finders = { "findUsuariosByNombre_usuario" })
public class Usuario {

    @NotNull
    private String nombre;

    @NotNull
    @Column(unique = true)
    private String nombre_usuario;

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

    @NotNull
    private String respuesta_secreta;

    @Enumerated
    private Roles rol;

    @Enumerated
    private EstadosUsuario estado;

    private String foto_perfil;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "emisor")
    private Set<Comentario> comentarios = new HashSet<Comentario>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "emisor")
    private Set<Publicacion> publicaciones = new HashSet<Publicacion>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario_1")
    private Set<Amistad> amistad = new HashSet<Amistad>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receptor")
    private Set<Notificacion> notificaciones_recibidas = new HashSet<Notificacion>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receptor")
    private Set<Denuncia> denuncias_recibidas = new HashSet<Denuncia>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "emisor")
    private Set<Denuncia> denuncias_emitidas = new HashSet<Denuncia>();
}
