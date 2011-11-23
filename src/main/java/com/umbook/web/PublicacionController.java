package com.umbook.web;

import com.umbook.server.domain.Publicacion;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "publicacions", formBackingObject = Publicacion.class)
@RequestMapping("/publicacions")
@Controller
public class PublicacionController {
}
