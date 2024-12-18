package com.fps.svmes.repositories.jpaRepo;
import java.util.List;
import com.fps.svmes.models.sql.task_schedule.Dispatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
/**
 * Repository for managing DispatchConfiguration entities.
 */
public interface DispatchRepository extends JpaRepository<Dispatch, Long> {
    List<Dispatch> findByActiveTrue();
}
