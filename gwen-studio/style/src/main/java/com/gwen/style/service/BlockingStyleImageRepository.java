package com.gwen.style.service;

import com.gwen.style.entity.StyleImageDO;
import com.gwen.style.repository.IStyleImageRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class BlockingStyleImageRepository {

    private IStyleImageRepository iStyleImageRepository;

    public BlockingStyleImageRepository(IStyleImageRepository iStyleImageRepository) {
        this.iStyleImageRepository = iStyleImageRepository;
    }

    public List<StyleImageDO> findAll(Pageable pageable) {
        return iStyleImageRepository.findAll(pageable).getContent();
    }

    @Transactional
    public Long save(StyleImageSaveDto dto) {
        StyleImageDO styleImageDO = StyleImageDO.builder()
                .styleId(dto.getStyleId())
                .url(dto.getUrl()).build();
        return iStyleImageRepository.save(styleImageDO).getId();
    }

    @Transactional
    public void deleteById(Long aLong) {
        iStyleImageRepository.deleteById(aLong);
    }
}
