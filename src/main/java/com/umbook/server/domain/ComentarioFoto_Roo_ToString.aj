// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.umbook.server.domain;

import java.lang.String;

privileged aspect ComentarioFoto_Roo_ToString {
    
    public String ComentarioFoto.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Contenido: ").append(getContenido()).append(", ");
        sb.append("Emisor: ").append(getEmisor()).append(", ");
        sb.append("Foto: ").append(getFoto()).append(", ");
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Version: ").append(getVersion());
        return sb.toString();
    }
    
}
