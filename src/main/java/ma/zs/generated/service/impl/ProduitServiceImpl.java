package ma.zs.generated.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import ma.zs.generated.bean.Produit;
import ma.zs.generated.bean.Commande;
import ma.zs.generated.dao.ProduitDao;
import ma.zs.generated.service.facade.ProduitService;
import ma.zs.generated.service.facade.CommandeService;   

import ma.zs.generated.ws.rest.provided.vo.ProduitVo;
import ma.zs.generated.service.util.*;
@Service
public class ProduitServiceImpl implements ProduitService {

   @Autowired
   private ProduitDao produitDao;
   
    @Autowired
    private CommandeService commandeService ;

   @Autowired 
   private EntityManager entityManager; 

	@Override
	public List<Produit> findAll(){
		return produitDao.findAll();
	}	
	@Override
	public List<Produit> findByCommandeReference(String reference){
		return produitDao.findByCommandeReference(reference);
	}
	@Override
	@Transactional
    public int deleteByCommandeReference(String reference){
		return produitDao.deleteByCommandeReference(reference);
	}
	
     @Override
    public List<Produit> findByCommandeId(Long id){
		return produitDao.findByCommandeId(id);

	}
	   @Override
	   @Transactional
    public int deleteByCommandeId(Long id){
		return produitDao.deleteByCommandeId(id);

	}
     		
	@Override
	public Produit findByReference(String reference){
		if( reference==null)
		  return null;
		return produitDao.findByReference(reference);
	}

   

	@Override
	@Transactional
	public int deleteByReference(String  reference) {
		return produitDao.deleteByReference(reference);	 
	}

	@Override
	public Produit findById(Long id){
		 if(id==null)
		  return null;
		return produitDao.getOne(id);
	}
    
	@Transactional
   public void deleteById(Long id){
           produitDao.deleteById(id);
   }
	@Override	
	public Produit save (Produit produit){
			Produit foundedProduit = findByReference(produit.getReference());
	       if(foundedProduit!=null)
	          return null;  
	    
	          if(produit.getCommande()!=null){
				    Commande commande = commandeService.findByReference(produit.getCommande().getReference());
				  if(commande == null)
				  produit.setCommande(commandeService.save(produit.getCommande()));
				  else
				  produit.setCommande(commande);
			  }

	    Produit savedProduit = produitDao.save(produit);
	   return savedProduit;
	}

    @Override
    public List<Produit> save(List<Produit> produits){
		List<Produit> list = new ArrayList<Produit>();
		for(Produit produit: produits){
		        list.add(save(produit));	
		}
		return list;
	}


   @Override
   public Produit update(Produit produit){
     
    
		  Produit foundedProduit = findById(produit.getId()); 
		       if(foundedProduit==null)
	          return null;	  
	  
	   return  produitDao.save(produit);
     
     }
    
	@Override
	@Transactional
	public int delete(Produit produit){

	        if(produit.getReference()==null)
			  return -1;
		
			Produit foundedProduit = findByReference(produit.getReference());
	       if(foundedProduit==null)
	          return -1;  
	   produitDao.delete(foundedProduit);
	   return 1;
	}


	public List<Produit> findByCriteria(ProduitVo produitVo){
      String query = "SELECT o FROM Produit o where 1=1 ";
		 	 query += SearchUtil.addConstraint( "o", "prixUnitaire","=",produitVo.getPrixUnitaire());
			 query += SearchUtil.addConstraint( "o", "typePapier","LIKE",produitVo.getTypePapier());

		 	 query += SearchUtil.addConstraint( "o", "largeur","=",produitVo.getLargeur());
		 	 query += SearchUtil.addConstraint( "o", "quantiteStock","=",produitVo.getQuantiteStock());
		 	 query += SearchUtil.addConstraint( "o", "hauteur","=",produitVo.getHauteur());
			 query += SearchUtil.addConstraint( "o", "reference","LIKE",produitVo.getReference());

		 	 query += SearchUtil.addConstraint( "o", "id","=",produitVo.getId());
	  query += SearchUtil.addConstraintMinMax("o","prixUnitaire",produitVo.getPrixUnitaireMin(),produitVo.getPrixUnitaireMax());
	  query += SearchUtil.addConstraintMinMax("o","largeur",produitVo.getLargeurMin(),produitVo.getLargeurMax());
	  query += SearchUtil.addConstraintMinMax("o","quantiteStock",produitVo.getQuantiteStockMin(),produitVo.getQuantiteStockMax());
	  query += SearchUtil.addConstraintMinMax("o","hauteur",produitVo.getHauteurMin(),produitVo.getHauteurMax());
   if(produitVo.getCommandeVo()!=null){
     query += SearchUtil.addConstraint( "o", "commande.id","=",produitVo.getCommandeVo().getId());
     query += SearchUtil.addConstraint( "o", "commande.reference","LIKE",produitVo.getCommandeVo().getReference());
   }
   
	 return entityManager.createQuery(query).getResultList();
	}
	
 
}
