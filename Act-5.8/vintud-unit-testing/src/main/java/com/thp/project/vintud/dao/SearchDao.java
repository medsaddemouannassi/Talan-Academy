package com.thp.project.vintud.dao;

import com.thp.project.vintud.entity.impl.Search;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchDao extends JpaRepository<Search, Integer> {

}
