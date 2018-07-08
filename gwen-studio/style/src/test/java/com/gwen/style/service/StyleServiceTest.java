package com.gwen.style.service;

import com.gwen.style.repository.IStyleRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class StyleServiceTest {

    @Configuration
    @ComponentScan(basePackages = {"com.gwen.style"})
    @EntityScan({"com.gwen.style.entity"})
    static class StyleServiceConfiguration{

        @Bean
        public BlockingStyleRepository blockingStyleRepository(IStyleRepository iStyleRepository){
            return new BlockingStyleRepository(iStyleRepository);
        }

        @Bean
        public StyleService styleService(BlockingStyleRepository blockingStyleRepository){
            return new StyleService(blockingStyleRepository);
        }
    }

    @Autowired
    private StyleService styleService;

    @Test
    public void listAll() {
        StepVerifier.create(styleService.listAll()).verifyComplete();
    }

    @Test
    public void update() {
    }

    @Test
    public void save() throws Exception {
        Mono<Long> saveMono = styleService.save(Mono.just(StyleSaveDTO.builder().name("新中式").ordinate(1).build()));
        StepVerifier.create(saveMono).expectComplete().verify();


        styleService.afterPropertiesSet();
        StepVerifier.create(styleService.listAll().log())
                .expectNextCount(1)
                .expectComplete().verify();

    }

    @Test
    public void delete() throws Exception {
        Mono<Long> saveMono = styleService.save(Mono.just(StyleSaveDTO.builder().name("欧式").ordinate(2).build()));


        StepVerifier.create(saveMono).expectNext(1l).expectComplete().verify();

        styleService.afterPropertiesSet();
        StepVerifier.create(styleService.listAll().log())
                .expectNextCount(1)
                .expectComplete().verify();

        Mono<Void> deleteMono = styleService.delete(Mono.just(1l));

        styleService.afterPropertiesSet();
        StepVerifier.create(deleteMono)
                .expectComplete().verify();

        Thread.sleep(1000);
        styleService.afterPropertiesSet();
        StepVerifier.create(styleService.listAll().log())
                .expectNextCount(0)
                .expectComplete().verify();
    }
}