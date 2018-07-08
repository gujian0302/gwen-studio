package com.gwen.style.controller;

import com.gwen.style.entity.StyleDO;
import com.gwen.style.service.StyleSaveDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWebTestClient
@Slf4j
public class StyleControllerTest {

    @Autowired
    private WebTestClient testClient;

    @Test
    public void load(){
    }


    @Test
    public void testStyleList(){
        testClient.get().uri("/style/list-all")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(StyleDO.class).hasSize(3);
    }

    @Test
    public void testSaveStyle(){
        testClient.post().uri("/style/save")
                .body(Mono.just(StyleSaveDTO.builder().name("新中式").ordinate(1).build()), StyleSaveDTO.class)
                .exchange().expectStatus().isOk()
                .expectBody(Long.class).isEqualTo(1l);

    }
}
