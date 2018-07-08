package com.gwen.style.service;


import com.gwen.style.entity.StyleImageDO;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class StyleImageService implements IStyleImage {

    private BlockingStyleImageRepository blockingStyleImageRepository;

    public StyleImageService(BlockingStyleImageRepository blockingStyleImageRepository) {
        this.blockingStyleImageRepository = blockingStyleImageRepository;
    }

    @Override
    public Flux<StyleImageDO> listAll(Mono<Pageable> pageable) {
        return pageable.publishOn(Schedulers.elastic()).flatMapIterable((page)-> blockingStyleImageRepository.findAll(page));
    }

    @Override
    public Mono<Long> save(Mono<StyleImageSaveDto> mono) {
        return mono.publishOn(Schedulers.elastic()).map(blockingStyleImageRepository::save);
    }

    @Override
    public Mono<Void> delete(Mono<Long> id) {
        return id.publishOn(Schedulers.elastic()).doOnNext(blockingStyleImageRepository::deleteById).then();
    }
}
