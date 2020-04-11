package net.service;

import net.model.Lists;
import net.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ListService {

    @Autowired
    private ListRepository listRepository;

    public List<Lists> listAll() {
        return listRepository.findAll();
    }

    public void save(Lists list) {
        listRepository.save(list);
    }

    public void delete(long id) {
        listRepository.deleteById(id);
    }

    public List<Lists> findAllListsOfUser(String name) {
        return listRepository.findAllByUser_Username(name);
    }

    public List<Lists> findListsByUserId(Long userId) {
        return listRepository.findAllByUserId(userId);
    }

    public Optional<Lists> findById(long id) {
        return listRepository.findById(id);
    }
}
