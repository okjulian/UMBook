package com.umbook.web;

import com.umbook.server.domain.Notificacion;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "notificacions", formBackingObject = Notificacion.class)
@RequestMapping("/notificacions")
@Controller
public class NotificacionController {
}
