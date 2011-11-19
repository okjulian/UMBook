package com.umbook.web;

import com.umbook.server.domain.ComentarioAlbum;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "comentarioalbums", formBackingObject = ComentarioAlbum.class)
@RequestMapping("/comentarioalbums")
@Controller
public class ComentarioAlbumController {
}
