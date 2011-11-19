package com.umbook.server.domain;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import java.util.Set;
import com.umbook.server.domain.ComentarioFoto;
import java.util.HashSet;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import com.umbook.server.domain.Album;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooEntity
public class Foto {

    private String descripcion;

    private String ubicacion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foto")
    private Set<ComentarioFoto> comentarios = new HashSet<ComentarioFoto>();

    @ManyToOne
    private Album album;
}
