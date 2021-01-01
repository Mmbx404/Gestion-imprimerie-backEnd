package ma.zs.generated.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import ma.zs.generated.bean.Produit;


@Repository
public interface ProduitDao extends JpaRepository<Produit,Long> {

	Produit findByReference(String reference);
       int deleteByReference(String reference);

       List<Produit> findByCommandeReference(String reference);
       int deleteByCommandeReference(String reference);       
       List<Produit> findByCommandeId(Long id);
       int deleteByCommandeId(Long id);

}