package com.gwen.style.controller;

import com.gwen.style.entity.StyleImageDO;
import com.gwen.style.service.StyleImageSaveDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureWebTestClient
public class StyleImageControllerTest {

    @Autowired
    private WebTestClient webTestClient;


    @Test
    public void testSave(){
        StyleImageSaveDto dto = new StyleImageSaveDto();
        dto.setStyleId(1l);
        dto.setUrl("https://www.baidu.com");
        this.webTestClient.post()
                .uri("/style-image/save")
                .body(Mono.just(dto), StyleImageSaveDto.class)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void testPage(){
        this.webTestClient.get()
                .uri("/style-image/list?page=1&size=1")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(StyleImageDO.class).hasSize(1)
                .contains(StyleImageDO.builder().id(2l).styleId(1l).url("https://www.baidu.com")
                        .createdDate(LocalDateTime.of(2018,7,4,0,0,0,0))
                        .build());
    }
}

