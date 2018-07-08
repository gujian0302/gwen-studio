package com.gwen.style.repository;

import com.gwen.style.entity.StyleImageDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStyleImageRepository extends JpaRepository<StyleImageDO,Long> {
}
