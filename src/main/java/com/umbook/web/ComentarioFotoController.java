package com.umbook.web;

import com.umbook.server.domain.ComentarioFoto;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "comentariofotoes", formBackingObject = ComentarioFoto.class)
@RequestMapping("/comentariofotoes")
@Controller
public class ComentarioFotoController {
}
