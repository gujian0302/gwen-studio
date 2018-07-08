package com.gwen.style.service;

import com.gwen.style.entity.StyleDO;
import com.gwen.style.repository.IStyleRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.function.Function;

public class BlockingStyleRepository {
    private IStyleRepository styleRepository;

    public BlockingStyleRepository(IStyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    @Transactional
    public Long save(StyleSaveDTO saveDTO) {
        StyleDO styleDO = StyleDO.builder()
                .name(saveDTO.getName())
                .ordinate(saveDTO.getOrdinate())
                .build();

        return styleRepository.saveAndFlush(styleDO).getId();
    }

    @Transactional
    public void update(StyleUpdateDTO updateDTO) {
        Function<StyleDO,StyleDO> mapFunction = styleDO -> {
            styleDO.setName(updateDTO.getName());
            styleDO.setOrdinate(updateDTO.getOrdinate());
            return styleDO;
        };

        styleRepository.findById(updateDTO.getId()).map(mapFunction).map(this.styleRepository::save);
    }

    @Transactional
    public void remove(Long id) {
        styleRepository.deleteById(id);
    }

    public List<StyleDO> listAll() {
        return styleRepository.findAll();
    }

}
