package com.gwen.style.service;

import com.gwen.style.entity.StyleImageDO;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface IStyleImage {
    Flux<StyleImageDO> listAll(Mono<Pageable> pageable);

    Mono<Long> save(Mono<StyleImageSaveDto> mono);

    Mono<Void> delete(Mono<Long> id);
}
