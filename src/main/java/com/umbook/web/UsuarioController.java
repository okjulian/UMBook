package com.umbook.web;

import com.umbook.server.domain.Usuario;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "usuarios", formBackingObject = Usuario.class)
@RequestMapping("/usuarios")
@Controller
public class UsuarioController {
}
