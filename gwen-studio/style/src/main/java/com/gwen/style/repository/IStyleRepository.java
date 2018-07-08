package com.gwen.style.repository;

import com.gwen.style.entity.StyleDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStyleRepository extends JpaRepository<StyleDO,Long> {
}
