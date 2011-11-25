package com.umbook.web;

import com.umbook.server.domain.Amistad;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "amistads", formBackingObject = Amistad.class, update=false)
@RequestMapping("/amistads")
@Controller
public class AmistadController {
}
