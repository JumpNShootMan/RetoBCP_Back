package pe.upc.bcp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upc.bcp.entity.NotificationCategory;

public interface NotificationCategoryRepository extends JpaRepository<NotificationCategory,Long> {
}
