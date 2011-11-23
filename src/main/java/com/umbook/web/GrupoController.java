package com.umbook.web;

import com.umbook.server.domain.Grupo;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "grupoes", formBackingObject = Grupo.class)
@RequestMapping("/grupoes")
@Controller
public class GrupoController {
}
