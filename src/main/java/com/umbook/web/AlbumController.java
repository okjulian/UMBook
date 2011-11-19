package com.umbook.web;

import com.umbook.server.domain.Album;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "albums", formBackingObject = Album.class)
@RequestMapping("/albums")
@Controller
public class AlbumController {
}
