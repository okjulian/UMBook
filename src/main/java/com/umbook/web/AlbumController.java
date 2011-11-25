package com.umbook.web;

import com.umbook.server.domain.Album;
import com.umbook.server.domain.Usuario;
import java.lang.String;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "albums", formBackingObject = Album.class)
@RequestMapping("/albums")
@Controller
public class AlbumController {
}
