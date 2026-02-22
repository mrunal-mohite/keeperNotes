package com.keeper.demo.repo;

import java.util.List;
import com.keeper.demo.entity.KeeperEntity;
import com.keeper.demo.entity.KeeperNoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeeperNoteRepo extends JpaRepository<KeeperNoteEntity, Long> {
    List<KeeperNoteEntity> findByUser(KeeperEntity user);
}
