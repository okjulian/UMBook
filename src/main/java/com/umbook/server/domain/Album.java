package com.umbook.server.domain;

import org.apache.commons.beanutils.converters.StringArrayConverter;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import java.util.Set;
import com.umbook.server.domain.Foto;
import java.util.HashSet;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import com.umbook.server.domain.ComentarioAlbum;
import com.umbook.server.domain.Usuario;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooEntity
public class Album {

    @NotNull
    private String nombre;

    private String descripcion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "album")
    private Set<Foto> fotos = new HashSet<Foto>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "album")
    private Set<ComentarioAlbum> comentarios = new HashSet<ComentarioAlbum>();

    @ManyToOne
    private Usuario usuario;
}
