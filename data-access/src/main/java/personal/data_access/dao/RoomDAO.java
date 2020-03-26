package personal.data_access.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import personal.data_access.model.Room;

@Repository
public interface RoomDAO extends JpaRepository<Room, Long> {
}
