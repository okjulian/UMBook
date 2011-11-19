package com.umbook.server.domain;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import com.umbook.server.domain.Usuario;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooEntity
public class Amistad {

    @ManyToOne
    private Usuario usuario_1;

    @ManyToOne
    private Usuario usuario_2;
}
