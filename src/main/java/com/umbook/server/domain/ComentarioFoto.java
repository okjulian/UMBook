package com.umbook.server.domain;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import com.umbook.server.domain.Foto;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooEntity(finders = { "findComentarioFotoesByFoto" })
public class ComentarioFoto extends Comentario {

    @ManyToOne
    private Foto foto;
}
