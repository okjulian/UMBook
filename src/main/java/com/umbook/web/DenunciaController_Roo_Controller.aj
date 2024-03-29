// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.umbook.web;

import com.umbook.server.domain.Denuncia;
import com.umbook.server.domain.Usuario;
import java.io.UnsupportedEncodingException;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect DenunciaController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST)
    public String DenunciaController.create(@Valid Denuncia denuncia, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("denuncia", denuncia);
            return "denuncias/create";
        }
        uiModel.asMap().clear();
        denuncia.persist();
        return "redirect:/denuncias/" + encodeUrlPathSegment(denuncia.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String DenunciaController.createForm(Model uiModel) {
        uiModel.addAttribute("denuncia", new Denuncia());
        return "denuncias/create";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String DenunciaController.show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("denuncia", Denuncia.findDenuncia(id));
        uiModel.addAttribute("itemId", id);
        return "denuncias/show";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String DenunciaController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            uiModel.addAttribute("denuncias", Denuncia.findDenunciaEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) Denuncia.countDenuncias() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("denuncias", Denuncia.findAllDenuncias());
        }
        return "denuncias/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String DenunciaController.update(@Valid Denuncia denuncia, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("denuncia", denuncia);
            return "denuncias/update";
        }
        uiModel.asMap().clear();
        denuncia.merge();
        return "redirect:/denuncias/" + encodeUrlPathSegment(denuncia.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String DenunciaController.updateForm(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("denuncia", Denuncia.findDenuncia(id));
        return "denuncias/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String DenunciaController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Denuncia.findDenuncia(id).remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/denuncias";
    }
    
    @ModelAttribute("denuncias")
    public Collection<Denuncia> DenunciaController.populateDenuncias() {
        return Denuncia.findAllDenuncias();
    }
    
    @ModelAttribute("usuarios")
    public Collection<Usuario> DenunciaController.populateUsuarios() {
        return Usuario.findAllUsuarios();
    }
    
    String DenunciaController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        }
        catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
    
}
