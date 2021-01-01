package ma.zs.generated.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import ma.zs.generated.bean.Flyer;


@Repository
public interface FlyerDao extends JpaRepository<Flyer,Long> {

	Flyer findByReference(String reference);
       int deleteByReference(String reference);


}