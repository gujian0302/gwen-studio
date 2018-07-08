package com.gwen.style.controller;

import com.gwen.style.entity.StyleDO;
import com.gwen.style.service.IStyle;
import com.gwen.style.service.StyleSaveDTO;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/style")
public class StyleController {

    private IStyle iStyle;

    public StyleController(IStyle iStyle) {
        this.iStyle = iStyle;
    }

    @GetMapping(value = "/list-all")
    public Flux<StyleDO> listAll() {
        return iStyle.listAll();
    }

    @PostMapping(value = "/save")
    public Mono<Long> save(Mono<StyleSaveDTO> styleDTO) {
        return iStyle.save(styleDTO);
    }

    @DeleteMapping(value = "/delete")
    public Mono<Void> delete(Mono<Long> id) {
        return iStyle.delete(id);
    }
}
