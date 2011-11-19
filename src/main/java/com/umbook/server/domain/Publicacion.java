package com.umbook.server.domain;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import com.umbook.server.domain.Usuario;
import javax.persistence.ManyToOne;
import java.util.Set;
import com.umbook.server.domain.ComentarioPublicacion;
import java.util.HashSet;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

@RooJavaBean
@RooToString
@RooEntity
public class Publicacion {

    @NotNull
    private String contenido;

    @ManyToOne
    private Usuario emisor;

    @ManyToOne
    private Usuario receptor;

    private Boolean leida;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "publicacion")
    private Set<ComentarioPublicacion> comentarios = new HashSet<ComentarioPublicacion>();
}
