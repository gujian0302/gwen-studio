package com.gwen.style.controller;

import com.gwen.style.entity.StyleImageDO;
import com.gwen.style.service.IStyleImage;
import com.gwen.style.service.StyleImageSaveDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/style-image/")
public class StyleImageController {

    private IStyleImage iStyleImage;

    public StyleImageController(IStyleImage iStyleImage) {
        this.iStyleImage = iStyleImage;
    }

    @GetMapping(value = "/list")
    public Flux<StyleImageDO> listAll(@RequestParam Integer page,@RequestParam Integer size) {
        return iStyleImage.listAll(Mono.just(PageRequest.of(page,size,Sort.Direction.DESC,"createdDate")));
    }

    @PostMapping(value = "save")
    public Mono<Long> save(Mono<StyleImageSaveDto> mono) {
        return iStyleImage.save(mono);
    }

    @DeleteMapping(value = "delete")
    public Mono<Void> delete(Mono<Long> id) {
        return iStyleImage.delete(id);
    }
}
