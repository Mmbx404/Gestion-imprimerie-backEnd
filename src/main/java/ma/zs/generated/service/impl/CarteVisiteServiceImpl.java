package ma.zs.generated.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import ma.zs.generated.bean.CarteVisite;
import ma.zs.generated.dao.CarteVisiteDao;
import ma.zs.generated.service.facade.CarteVisiteService;

import ma.zs.generated.ws.rest.provided.vo.CarteVisiteVo;
import ma.zs.generated.service.util.*;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CarteVisiteServiceImpl implements CarteVisiteService {

   @Autowired
   private CarteVisiteDao carteVisiteDao;
   

   @Autowired 
   private EntityManager entityManager; 

	@Override
	public List<CarteVisite> findAll(){
		return carteVisiteDao.findAll();
	}	
	@Override
	public CarteVisite findByReference(String reference){
		if( reference==null)
		  return null;
		return carteVisiteDao.findByReference(reference);
	}

   

	@Override
	@Transactional
	public int deleteByReference(String  reference) {
		return carteVisiteDao.deleteByReference(reference);	 
	}

	@Override
	public CarteVisite findById(Long id){
		 if(id==null)
		  return null;
		return carteVisiteDao.getOne(id);
	}
    
	@Transactional
   public void deleteById(Long id){
           carteVisiteDao.deleteById(id);
   }
	@Override	
	public CarteVisite save (CarteVisite carteVisite){
			CarteVisite foundedCarteVisite = findByReference(carteVisite.getReference());
	       if(foundedCarteVisite!=null)
	          return null;  

	    CarteVisite savedCarteVisite = carteVisiteDao.save(carteVisite);
	   return savedCarteVisite;
	}

    @Override
    public List<CarteVisite> save(List<CarteVisite> carteVisites){
		List<CarteVisite> list = new ArrayList<CarteVisite>();
		for(CarteVisite carteVisite: carteVisites){
		        list.add(save(carteVisite));	
		}
		return list;
	}


   @Override
   public CarteVisite update(CarteVisite carteVisite){
     
    
		  CarteVisite foundedCarteVisite = findById(carteVisite.getId()); 
		       if(foundedCarteVisite==null)
	          return null;	  
	  
	   return  carteVisiteDao.save(carteVisite);
     
     }
    
	@Override
	@Transactional
	public int delete(CarteVisite carteVisite){

	        if(carteVisite.getReference()==null)
			  return -1;
		
			CarteVisite foundedCarteVisite = findByReference(carteVisite.getReference());
	       if(foundedCarteVisite==null)
	          return -1;  
	   carteVisiteDao.delete(foundedCarteVisite);
	   return 1;
	}


	public List<CarteVisite> findByCriteria(CarteVisiteVo carteVisiteVo){
      String query = "SELECT o FROM CarteVisite o where 1=1 ";
		 	 query += SearchUtil.addConstraint( "o", "prixUnitaire","=",carteVisiteVo.getPrixUnitaire());
			 query += SearchUtil.addConstraint( "o", "typePapier","LIKE",carteVisiteVo.getTypePapier());

		 	 query += SearchUtil.addConstraint( "o", "plastifier","=",carteVisiteVo.getPlastifier());
		 	 query += SearchUtil.addConstraint( "o", "quantiteStock","=",carteVisiteVo.getQuantiteStock());
		 	 query += SearchUtil.addConstraint( "o", "hauteur","=",carteVisiteVo.getHauteur());
			 query += SearchUtil.addConstraint( "o", "reference","LIKE",carteVisiteVo.getReference());

		 	 query += SearchUtil.addConstraint( "o", "largeur","=",carteVisiteVo.getLargeur());
		 	 query += SearchUtil.addConstraint( "o", "id","=",carteVisiteVo.getId());
	  query += SearchUtil.addConstraintMinMax("o","prixUnitaire",carteVisiteVo.getPrixUnitaireMin(),carteVisiteVo.getPrixUnitaireMax());
	  query += SearchUtil.addConstraintMinMax("o","quantiteStock",carteVisiteVo.getQuantiteStockMin(),carteVisiteVo.getQuantiteStockMax());
	  query += SearchUtil.addConstraintMinMax("o","hauteur",carteVisiteVo.getHauteurMin(),carteVisiteVo.getHauteurMax());
	  query += SearchUtil.addConstraintMinMax("o","largeur",carteVisiteVo.getLargeurMin(),carteVisiteVo.getLargeurMax());
	 return entityManager.createQuery(query).getResultList();
	}

	@Override
	public int uploadContent(MultipartFile file, String reference) throws IOException {
		CarteVisite carteVisite = carteVisiteDao.findByReference(reference);
		if (carteVisite != null) {
			carteVisite.setContent(file.getBytes());
			carteVisiteDao.save(carteVisite);
			return 1;
		}
		return -1;
	}


}
