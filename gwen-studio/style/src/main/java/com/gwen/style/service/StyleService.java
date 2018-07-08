package com.gwen.style.service;

import com.gwen.style.entity.StyleDO;
import org.springframework.beans.factory.InitializingBean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.*;

public class StyleService implements IStyle, InitializingBean {

    List<StyleDO> styles = new ArrayList<>();

    private BlockingStyleRepository blockingStyleRepository;

    public StyleService(BlockingStyleRepository blockingStyleRepository) {
        this.blockingStyleRepository = blockingStyleRepository;
    }

    @Override
    public Flux<StyleDO> listAll() {
        return Flux.just(styles.toArray(new StyleDO[styles.size()]));
    }

    @Override
    public Mono<Void> update(Mono<StyleUpdateDTO> styleDTO) {
        return styleDTO.publishOn(Schedulers.elastic())
                .doOnNext(blockingStyleRepository::update).then();
    }

    @Override
    public Mono<Long> save(Mono<StyleSaveDTO> styleDTO) {
        return styleDTO.publishOn(Schedulers.elastic())
                .map(blockingStyleRepository::save);
    }

    @Override
    public Mono<Void> delete(Mono<Long> id) {
        return id.publishOn(Schedulers.elastic())
                .doOnNext(blockingStyleRepository::remove).then();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        styles = blockingStyleRepository.listAll();
        Collections.sort(styles, Comparator.comparing(StyleDO::getOrdinate));
    }
}
