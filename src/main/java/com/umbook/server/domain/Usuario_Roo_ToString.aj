// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.umbook.server.domain;

import java.lang.String;

privileged aspect Usuario_Roo_ToString {
    
    public String Usuario.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Amistad: ").append(getAmistad() == null ? "null" : getAmistad().size()).append(", ");
        sb.append("Apellido: ").append(getApellido()).append(", ");
        sb.append("Comentarios: ").append(getComentarios() == null ? "null" : getComentarios().size()).append(", ");
        sb.append("Contrasena: ").append(getContrasena()).append(", ");
        sb.append("Correo_electronico: ").append(getCorreo_electronico()).append(", ");
        sb.append("Denuncias_emitidas: ").append(getDenuncias_emitidas() == null ? "null" : getDenuncias_emitidas().size()).append(", ");
        sb.append("Denuncias_recibidas: ").append(getDenuncias_recibidas() == null ? "null" : getDenuncias_recibidas().size()).append(", ");
        sb.append("Estado: ").append(getEstado()).append(", ");
        sb.append("Foto_perfil: ").append(getFoto_perfil()).append(", ");
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Nombre: ").append(getNombre()).append(", ");
        sb.append("Nombre_usuario: ").append(getNombre_usuario()).append(", ");
        sb.append("Notificaciones_recibidas: ").append(getNotificaciones_recibidas() == null ? "null" : getNotificaciones_recibidas().size()).append(", ");
        sb.append("Pregunta_secreta: ").append(getPregunta_secreta()).append(", ");
        sb.append("Publicaciones: ").append(getPublicaciones() == null ? "null" : getPublicaciones().size()).append(", ");
        sb.append("Respuesta_secreta: ").append(getRespuesta_secreta()).append(", ");
        sb.append("Rol: ").append(getRol()).append(", ");
        sb.append("Sexo: ").append(getSexo()).append(", ");
        sb.append("Version: ").append(getVersion());
        return sb.toString();
    }
    
}
