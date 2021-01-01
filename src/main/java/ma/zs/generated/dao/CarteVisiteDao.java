package ma.zs.generated.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import ma.zs.generated.bean.CarteVisite;


@Repository
public interface CarteVisiteDao extends JpaRepository<CarteVisite,Long> {

	CarteVisite findByReference(String reference);
       int deleteByReference(String reference);


}