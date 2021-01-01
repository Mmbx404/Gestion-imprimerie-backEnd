package ma.zs.generated.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import ma.zs.generated.bean.Commande;


@Repository
public interface CommandeDao extends JpaRepository<Commande,Long> {

	Commande findByReference(String reference);
       int deleteByReference(String reference);

       List<Commande> findByUserEmail(String email);
       int deleteByUserEmail(String email);       
       List<Commande> findByUserId(Long id);
       int deleteByUserId(Long id);

}