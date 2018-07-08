package com.gwen.style.service;

import com.gwen.style.entity.StyleDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ImportAutoConfiguration(classes =StyleServiceTest.StyleServiceConfiguration.class )
public class BlockingStyleRepositoryTest {

    @Autowired
    private BlockingStyleRepository blockingStyleRepository;


    @Test
    public void save() {
        StyleSaveDTO dto = StyleSaveDTO.builder().name("新中式").ordinate(1).build();
        blockingStyleRepository.save(dto);

        List<StyleDO> lists =  blockingStyleRepository.listAll();

        assertEquals(1, lists.size());
    }
}