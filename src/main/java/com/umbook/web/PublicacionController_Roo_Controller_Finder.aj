// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.umbook.web;

import com.umbook.server.domain.Publicacion;
import com.umbook.server.domain.Usuario;
import java.lang.String;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

privileged aspect PublicacionController_Roo_Controller_Finder {
    
    @RequestMapping(params = { "find=ByEmisor", "form" }, method = RequestMethod.GET)
    public String PublicacionController.findPublicacionsByEmisorForm(Model uiModel) {
        uiModel.addAttribute("usuarios", Usuario.findAllUsuarios());
        return "publicacions/findPublicacionsByEmisor";
    }
    
    @RequestMapping(params = "find=ByEmisor", method = RequestMethod.GET)
    public String PublicacionController.findPublicacionsByEmisor(@RequestParam("emisor") Usuario emisor, Model uiModel) {
        uiModel.addAttribute("publicacions", Publicacion.findPublicacionsByEmisor(emisor).getResultList());
        return "publicacions/list";
    }
    
    @RequestMapping(params = { "find=ByReceptor", "form" }, method = RequestMethod.GET)
    public String PublicacionController.findPublicacionsByReceptorForm(Model uiModel) {
        uiModel.addAttribute("usuarios", Usuario.findAllUsuarios());
        return "publicacions/findPublicacionsByReceptor";
    }
    
    @RequestMapping(params = "find=ByReceptor", method = RequestMethod.GET)
    public String PublicacionController.findPublicacionsByReceptor(@RequestParam("receptor") Usuario receptor, Model uiModel) {
        uiModel.addAttribute("publicacions", Publicacion.findPublicacionsByReceptor(receptor).getResultList());
        return "publicacions/list";
    }
    
}
