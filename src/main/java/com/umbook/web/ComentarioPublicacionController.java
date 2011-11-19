package com.umbook.web;

import com.umbook.server.domain.ComentarioPublicacion;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "comentariopublicacions", formBackingObject = ComentarioPublicacion.class)
@RequestMapping("/comentariopublicacions")
@Controller
public class ComentarioPublicacionController {
}
