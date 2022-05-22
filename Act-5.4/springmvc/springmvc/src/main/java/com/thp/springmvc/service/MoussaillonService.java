package com.thp.springmvc.service;

import com.thp.springmvc.entity.Moussaillon;
import com.thp.springmvc.repository.MoussaillonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoussaillonService {
    @Autowired
    MoussaillonRepository moussaillonRepository;

    public Moussaillon[] findAllMoussaillons() {
        return moussaillonRepository.findAll();
    }
}
