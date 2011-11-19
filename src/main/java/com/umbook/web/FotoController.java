package com.umbook.web;

import com.umbook.server.domain.Foto;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "fotoes", formBackingObject = Foto.class)
@RequestMapping("/fotoes")
@Controller
public class FotoController {
}
