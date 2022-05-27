package com.thp.project.vintud.dao;

import com.thp.project.vintud.entity.impl.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteDao extends JpaRepository<Favorite, Integer> {
}
