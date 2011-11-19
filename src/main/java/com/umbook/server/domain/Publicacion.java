package com.umbook.server.domain;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import com.umbook.server.domain.Usuario;
import javax.persistence.ManyToOne;

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
}
