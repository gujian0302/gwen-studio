package com.gwen.style.service;

import com.gwen.style.entity.StyleDO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IStyle {
    Flux<StyleDO> listAll();

    Mono<Void> update(Mono<StyleUpdateDTO> styleDTO);

    Mono<Long> save(Mono<StyleSaveDTO> styleDTO);

    Mono<Void> delete(Mono<Long> id);
}
