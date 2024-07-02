package dio.spring_api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dio.spring_api.model.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Integer>{

}
