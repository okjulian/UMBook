package com.umbook.web;

import com.umbook.server.domain.Foto;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.OutputStream;
import java.io.ByteArrayInputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

@RooWebScaffold(path = "fotoes", formBackingObject = Foto.class, update=false)
@RequestMapping("/fotoes")
@Controller
public class FotoController {
	private static final Log log = LogFactory.getLog(FotoController.class);
	
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws ServletException {
		binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
	}
	@RequestMapping(value="savefoto",  method = RequestMethod.POST)
    public String crearfoto(@Valid Foto foto,
    					 	BindingResult result, 
    					 	Model model,
    					 	@RequestParam("contenido") MultipartFile content,
    					 	HttpServletRequest request) {
    	
		
    	foto.setTipo_contenido(content.getContentType());
    	foto.setNombre_archivo(content.getOriginalFilename());
    	foto.setTamano(content.getSize());

    	//document.se content.getSize()
    	log.debug("Foto: ");
    	log.debug("Nombre: "+content.getOriginalFilename());
    	log.debug("Descripcion: "+foto.getDescripcion());
    	log.debug("Archivo: " +content.getName());
    	log.debug("Tipo: "+content.getContentType());
    	log.debug("Tamano: "+content.getSize());
        if (result.hasErrors()) {
            model.addAttribute("foto", foto);
            return "fotoes/create";
        }
        foto.persist();
        
        return "redirect:/fotoes?page=1&size=10" + encodeUrlPathSegment(foto.getId().toString(), request);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id, Model model) {
    	Foto foto = Foto.findFoto(id);
    	foto.setUrl("http://localhost:8080/umbook/fotoes/mostrarfoto/"+id);
        model.addAttribute("foto", Foto.findFoto(id));
        model.addAttribute("itemId", id);
        return "fotoes/show";
    }

  
    @RequestMapping(value = "/mostrarfoto/{id}", method = RequestMethod.GET)
    public String mostrarfoto(	@PathVariable("id") Long id,
    						HttpServletResponse response,
    						Model model) {
    	
    	Foto foto = Foto.findFoto(id);
    	

        try {
            response.setHeader("Content-Disposition", "inline;filename=\"" +foto.getNombre_archivo()+ "\"");

            OutputStream out = response.getOutputStream();
            response.setContentType(foto.getTipo_contenido());
            IOUtils.copy(new ByteArrayInputStream(foto.getContenido()), out);
            out.flush();
         
 
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model model) {
    	Foto foto= Foto.findFoto(id);
    	foto.setUrl("http://localhost:8080/umbook/fotoes/mostrarfoto/"+id);
        model.addAttribute("foto", foto);
        return "fotoes/update";
    }
}
