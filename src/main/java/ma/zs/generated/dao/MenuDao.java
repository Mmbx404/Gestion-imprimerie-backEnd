package ma.zs.generated.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import ma.zs.generated.bean.Menu;


@Repository
public interface MenuDao extends JpaRepository<Menu,Long> {

	Menu findByReference(String reference);
       int deleteByReference(String reference);


}