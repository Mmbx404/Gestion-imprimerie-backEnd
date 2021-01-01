package ma.zs.generated.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import ma.zs.generated.bean.Flyer;
import ma.zs.generated.dao.FlyerDao;
import ma.zs.generated.service.facade.FlyerService;

import ma.zs.generated.ws.rest.provided.vo.FlyerVo;
import ma.zs.generated.service.util.*;
@Service
public class FlyerServiceImpl implements FlyerService {

   @Autowired
   private FlyerDao flyerDao;
   

   @Autowired 
   private EntityManager entityManager; 

	@Override
	public List<Flyer> findAll(){
		return flyerDao.findAll();
	}	
	@Override
	public Flyer findByReference(String reference){
		if( reference==null)
		  return null;
		return flyerDao.findByReference(reference);
	}

   

	@Override
	@Transactional
	public int deleteByReference(String  reference) {
		return flyerDao.deleteByReference(reference);	 
	}

	@Override
	public Flyer findById(Long id){
		 if(id==null)
		  return null;
		return flyerDao.getOne(id);
	}
    
	@Transactional
   public void deleteById(Long id){
           flyerDao.deleteById(id);
   }
	@Override	
	public Flyer save (Flyer flyer){
			Flyer foundedFlyer = findByReference(flyer.getReference());
	       if(foundedFlyer!=null)
	          return null;  

	    Flyer savedFlyer = flyerDao.save(flyer);
	   return savedFlyer;
	}

    @Override
    public List<Flyer> save(List<Flyer> flyers){
		List<Flyer> list = new ArrayList<Flyer>();
		for(Flyer flyer: flyers){
		        list.add(save(flyer));	
		}
		return list;
	}


   @Override
   public Flyer update(Flyer flyer){
     
    
		  Flyer foundedFlyer = findById(flyer.getId()); 
		       if(foundedFlyer==null)
	          return null;	  
	  
	   return  flyerDao.save(flyer);
     
     }
    
	@Override
	@Transactional
	public int delete(Flyer flyer){

	        if(flyer.getReference()==null)
			  return -1;
		
			Flyer foundedFlyer = findByReference(flyer.getReference());
	       if(foundedFlyer==null)
	          return -1;  
	   flyerDao.delete(foundedFlyer);
	   return 1;
	}


	public List<Flyer> findByCriteria(FlyerVo flyerVo){
      String query = "SELECT o FROM Flyer o where 1=1 ";
		 	 query += SearchUtil.addConstraint( "o", "quantiteStock","=",flyerVo.getQuantiteStock());
		 	 query += SearchUtil.addConstraint( "o", "largeur","=",flyerVo.getLargeur());
			 query += SearchUtil.addConstraint( "o", "reference","LIKE",flyerVo.getReference());

		 	 query += SearchUtil.addConstraint( "o", "id","=",flyerVo.getId());
			 query += SearchUtil.addConstraint( "o", "typePapier","LIKE",flyerVo.getTypePapier());

		 	 query += SearchUtil.addConstraint( "o", "prixUnitaire","=",flyerVo.getPrixUnitaire());
		 	 query += SearchUtil.addConstraint( "o", "hauteur","=",flyerVo.getHauteur());
	  query += SearchUtil.addConstraintMinMax("o","quantiteStock",flyerVo.getQuantiteStockMin(),flyerVo.getQuantiteStockMax());
	  query += SearchUtil.addConstraintMinMax("o","largeur",flyerVo.getLargeurMin(),flyerVo.getLargeurMax());
	  query += SearchUtil.addConstraintMinMax("o","prixUnitaire",flyerVo.getPrixUnitaireMin(),flyerVo.getPrixUnitaireMax());
	  query += SearchUtil.addConstraintMinMax("o","hauteur",flyerVo.getHauteurMin(),flyerVo.getHauteurMax());
	 return entityManager.createQuery(query).getResultList();
	}
	
 
}
