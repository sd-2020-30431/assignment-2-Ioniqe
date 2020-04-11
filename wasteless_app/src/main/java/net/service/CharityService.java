package net.service;

import net.model.Charity;
import net.repository.CharityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharityService {
    @Autowired
    private CharityRepository charityRepository;

    public List<Charity> listAll() {
        return charityRepository.findAll();
    }
}
