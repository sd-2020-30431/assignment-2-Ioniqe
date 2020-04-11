package net.repository;

import net.model.Lists;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ListRepository extends JpaRepository<Lists, Long> {
//    List<Lists> findListsByName(String name);
    List<Lists> findAllByUserId(Long userId);
    Optional<Lists> findById(Long id);
    List<Lists> findAllByUser_Username(String username);

}
