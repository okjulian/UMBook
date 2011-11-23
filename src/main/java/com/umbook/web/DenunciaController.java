package com.umbook.web;

import com.umbook.server.domain.Denuncia;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "denuncias", formBackingObject = Denuncia.class)
@RequestMapping("/denuncias")
@Controller
public class DenunciaController {
}
