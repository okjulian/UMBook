package com.umbook.server.domain;

import java.util.HashSet;
import java.util.Set;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import com.umbook.server.domain.Usuario;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "publicacion")
    private Set<ComentarioPublicacion> comentarios = new HashSet<ComentarioPublicacion>();

    private Boolean leida;
}
