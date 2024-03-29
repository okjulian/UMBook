// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.umbook.web;

import com.umbook.server.domain.ComentarioPublicacion;
import com.umbook.server.domain.Publicacion;
import java.lang.String;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

privileged aspect ComentarioPublicacionController_Roo_Controller_Finder {
    
    @RequestMapping(params = { "find=ByPublicacion", "form" }, method = RequestMethod.GET)
    public String ComentarioPublicacionController.findComentarioPublicacionsByPublicacionForm(Model uiModel) {
        uiModel.addAttribute("publicacions", Publicacion.findAllPublicacions());
        return "comentariopublicacions/findComentarioPublicacionsByPublicacion";
    }
    
    @RequestMapping(params = "find=ByPublicacion", method = RequestMethod.GET)
    public String ComentarioPublicacionController.findComentarioPublicacionsByPublicacion(@RequestParam("publicacion") Publicacion publicacion, Model uiModel) {
        uiModel.addAttribute("comentariopublicacions", ComentarioPublicacion.findComentarioPublicacionsByPublicacion(publicacion).getResultList());
        return "comentariopublicacions/list";
    }
    
}
