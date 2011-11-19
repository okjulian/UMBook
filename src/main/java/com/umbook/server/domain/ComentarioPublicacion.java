package com.umbook.server.domain;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import com.umbook.server.domain.Publicacion;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooEntity
public class ComentarioPublicacion extends Comentario {

    @ManyToOne
    private Publicacion publicacion;
}
