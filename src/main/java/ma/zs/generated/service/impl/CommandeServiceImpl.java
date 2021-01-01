package ma.zs.generated.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import ma.zs.generated.bean.Commande;
import ma.zs.generated.bean.User;
import ma.zs.generated.bean.Produit;
import ma.zs.generated.dao.CommandeDao;
import ma.zs.generated.service.facade.CommandeService;
import ma.zs.generated.service.facade.UserService;   
import ma.zs.generated.service.facade.ProduitService;   

import ma.zs.generated.ws.rest.provided.vo.CommandeVo;
import ma.zs.generated.service.util.*;
@Service
public class CommandeServiceImpl implements CommandeService {

   @Autowired
   private CommandeDao commandeDao;
   
    @Autowired
    private UserService userService ;
    @Autowired
    private ProduitService produitService ;

   @Autowired 
   private EntityManager entityManager; 

	@Override
	public List<Commande> findAll(){
		return commandeDao.findAll();
	}	
	@Override
	public List<Commande> findByUserEmail(String email){
		return commandeDao.findByUserEmail(email);
	}
	@Override
	@Transactional
    public int deleteByUserEmail(String email){
		return commandeDao.deleteByUserEmail(email);
	}
	
     @Override
    public List<Commande> findByUserId(Long id){
		return commandeDao.findByUserId(id);

	}
	   @Override
	   @Transactional
    public int deleteByUserId(Long id){
		return commandeDao.deleteByUserId(id);

	}
     		
	@Override
	public Commande findByReference(String reference){
		if( reference==null)
		  return null;
		return commandeDao.findByReference(reference);
	}

   

	@Override
	@Transactional
	public int deleteByReference(String  reference) {
		return commandeDao.deleteByReference(reference);	 
	}

	@Override
	public Commande findById(Long id){
		 if(id==null)
		  return null;
		return commandeDao.getOne(id);
	}
    
	@Transactional
   public void deleteById(Long id){
           commandeDao.deleteById(id);
   }
	@Override	
	public Commande save (Commande commande){
			Commande foundedCommande = findByReference(commande.getReference());
	       if(foundedCommande!=null)
	          return null;  
	    
	          if(commande.getUser()!=null){
				    User user = userService.findByEmail(commande.getUser().getEmail());
				  if(user == null)
				  commande.setUser(userService.save(commande.getUser()));
				  else
				  commande.setUser(user);
			  }

	    Commande savedCommande = commandeDao.save(commande);
               if(ListUtil.isNotEmpty(commande.getProduits())){
		  savedCommande.setProduits(produitService.save(prepareProduits(savedCommande,commande.getProduits())));
		 }
	   return savedCommande;
	}

    @Override
    public List<Commande> save(List<Commande> commandes){
		List<Commande> list = new ArrayList<Commande>();
		for(Commande commande: commandes){
		        list.add(save(commande));	
		}
		return list;
	}

     private List<Produit> prepareProduits(Commande commande,List<Produit> produits){
		    for(Produit produit:produits ){
                  produit.setCommande(commande); 
			}
			return produits;
	  }

   @Override
   public Commande update(Commande commande){
     
    
		  Commande foundedCommande = findById(commande.getId()); 
		       if(foundedCommande==null)
	          return null;	  
	  
	   return  commandeDao.save(commande);
     
     }
    
	@Override
	@Transactional
	public int delete(Commande commande){

	        if(commande.getReference()==null)
			  return -1;
		
			Commande foundedCommande = findByReference(commande.getReference());
	       if(foundedCommande==null)
	          return -1;  
	   commandeDao.delete(foundedCommande);
	   return 1;
	}


	public List<Commande> findByCriteria(CommandeVo commandeVo){
      String query = "SELECT o FROM Commande o where 1=1 ";
			 query += SearchUtil.addConstraint( "o", "etat","LIKE",commandeVo.getEtat());

		 	 query += SearchUtil.addConstraint( "o", "prixTotal","=",commandeVo.getPrixTotal());
		 	 query += SearchUtil.addConstraint( "o", "id","=",commandeVo.getId());
			 query += SearchUtil.addConstraint( "o", "reference","LIKE",commandeVo.getReference());

	  query += SearchUtil.addConstraintDate( "o", "dateAchat","=",commandeVo.getDateAchat());
	  query += SearchUtil.addConstraintMinMax("o","prixTotal",commandeVo.getPrixTotalMin(),commandeVo.getPrixTotalMax());
	  query += SearchUtil.addConstraintMinMaxDate("o","dateAchat",commandeVo.getDateAchatMin(),commandeVo.getDateAchatMax());
   if(commandeVo.getUserVo()!=null){
     query += SearchUtil.addConstraint( "o", "user.id","=",commandeVo.getUserVo().getId());
     query += SearchUtil.addConstraint( "o", "user.email","LIKE",commandeVo.getUserVo().getEmail());
   }
   
	 return entityManager.createQuery(query).getResultList();
	}
	
 
}
