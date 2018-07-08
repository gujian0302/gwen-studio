package com.gwen.style.config;

import com.gwen.style.repository.IStyleImageRepository;
import com.gwen.style.repository.IStyleRepository;
import com.gwen.style.service.BlockingStyleImageRepository;
import com.gwen.style.service.BlockingStyleRepository;
import com.gwen.style.service.StyleImageService;
import com.gwen.style.service.StyleService;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.gwen.style"})
@EntityScan({"com.gwen.style.entity"})
public class StyleConfiguration {

    @Bean
    public BlockingStyleRepository blockingStyleRepository(IStyleRepository iStyleRepository){
        return new BlockingStyleRepository(iStyleRepository);
    }

    @Bean
    public StyleService styleService(BlockingStyleRepository blockingStyleRepository){
        return new StyleService(blockingStyleRepository);
    }

    @Bean
    public BlockingStyleImageRepository blockingStyleImageRepository(IStyleImageRepository iStyleImageRepository){
        return new BlockingStyleImageRepository(iStyleImageRepository);
    }

    @Bean
    public StyleImageService styleImageService(BlockingStyleImageRepository blockingStyleImageRepository){
        return new StyleImageService(blockingStyleImageRepository);
    }
}
