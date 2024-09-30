package lk.ijse.gdse.aad67.notecollector.dao;


import lk.ijse.gdse.aad67.notecollector.entity.impl.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<UserEntity, String> {
}
