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
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.Transient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;
import java.lang.Integer;
import java.lang.Long;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Version;
import org.springframework.transaction.annotation.Transactional;

@RooJavaBean
@RooToString
@RooEntity(finders = { "findFotoesByAlbum" })
public class Foto {

	@NotNull
	@Size(max = 30)
	private java.lang.String nombre;
	
	@NotNull
	@Size(max = 500)
    private java.lang.String descripcion;

    private java.lang.String nombre_archivo;
    
    @NotNull
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] contenido;
    
    private java.lang.String tipo_contenido;
    
    private java.lang.Long tamano;
    
    @Transient
    @Size(max = 100)
    private String url;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foto")
    private Set<ComentarioFoto> comentarios = new HashSet<ComentarioFoto>();

    @ManyToOne
    private Album album;
    
    public String getTipo_contenido() {
        return this.tipo_contenido;
    }
	
	    
    public byte[] getContenido() {
        return this.contenido;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getNombre_archivo() {
        return this.nombre_archivo;
    }
    
    public void setNombre_archivo(String nombre_archivo) {
        this.nombre_archivo = nombre_archivo;
    }
    
    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }
    
    public void setTipo_contenido(String tipo_contenido) {
        this.tipo_contenido = tipo_contenido;
    }
    
    public Long getTamano() {
        return this.tamano;
    }
    
    public void setTamano(Long tamano) {
        this.tamano = tamano;
    }
    
    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    public Set<ComentarioFoto> getComentarios() {
        return this.comentarios;
    }
    
    public void setComentarios(Set<ComentarioFoto> comentarios) {
        this.comentarios = comentarios;
    }
    
    public Album getAlbum() {
        return this.album;
    }
    
    public void setAlbum(Album album) {
        this.album = album;
    }
    
    @PersistenceContext
    transient EntityManager entityManager;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @Version
    @Column(name = "version")
    private Integer version;
    
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Integer getVersion() {
        return this.version;
    }
    
    public void setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Foto attached = findFoto(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Foto merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Foto merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static final EntityManager entityManager() {
        EntityManager em = new Foto().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long countFotoes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Foto o", Long.class).getSingleResult();
    }
    
    public static List<Foto> findAllFotoes() {
        return entityManager().createQuery("SELECT o FROM Foto o", Foto.class).getResultList();
    }
    
    public static Foto findFoto(Long id) {
        if (id == null) return null;
        return entityManager().find(Foto.class, id);
    }
    
    public static List<Foto> findFotoEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Foto o", Foto.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
}
