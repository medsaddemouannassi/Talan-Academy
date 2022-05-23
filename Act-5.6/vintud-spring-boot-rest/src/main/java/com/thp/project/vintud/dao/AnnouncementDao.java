package com.thp.project.vintud.dao;

import com.thp.project.vintud.entity.impl.AnnouncementImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnouncementDao extends JpaRepository<AnnouncementImpl, Integer> {

}
