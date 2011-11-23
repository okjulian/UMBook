package com.umbook.web;

import com.umbook.server.domain.Solicitud;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "solicituds", formBackingObject = Solicitud.class)
@RequestMapping("/solicituds")
@Controller
public class SolicitudController {
}
