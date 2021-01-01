package ma.zs.generated.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import ma.zs.generated.bean.Agenda;
import ma.zs.generated.dao.AgendaDao;
import ma.zs.generated.service.facade.AgendaService;

import ma.zs.generated.ws.rest.provided.vo.AgendaVo;
import ma.zs.generated.service.util.*;
@Service
public class AgendaServiceImpl implements AgendaService {

   @Autowired
   private AgendaDao agendaDao;
   

   @Autowired 
   private EntityManager entityManager; 

	@Override
	public List<Agenda> findAll(){
		return agendaDao.findAll();
	}	
	@Override
	public Agenda findByReference(String reference){
		if( reference==null)
		  return null;
		return agendaDao.findByReference(reference);
	}

   

	@Override
	@Transactional
	public int deleteByReference(String  reference) {
		return agendaDao.deleteByReference(reference);	 
	}

	@Override
	public Agenda findById(Long id){
		 if(id==null)
		  return null;
		return agendaDao.getOne(id);
	}
    
	@Transactional
   public void deleteById(Long id){
           agendaDao.deleteById(id);
   }
	@Override	
	public Agenda save (Agenda agenda){
			Agenda foundedAgenda = findByReference(agenda.getReference());
	       if(foundedAgenda!=null)
	          return null;  

	    Agenda savedAgenda = agendaDao.save(agenda);
	   return savedAgenda;
	}

    @Override
    public List<Agenda> save(List<Agenda> agendas){
		List<Agenda> list = new ArrayList<Agenda>();
		for(Agenda agenda: agendas){
		        list.add(save(agenda));	
		}
		return list;
	}


   @Override
   public Agenda update(Agenda agenda){
     
    
		  Agenda foundedAgenda = findById(agenda.getId()); 
		       if(foundedAgenda==null)
	          return null;	  
	  
	   return  agendaDao.save(agenda);
     
     }
    
	@Override
	@Transactional
	public int delete(Agenda agenda){

	        if(agenda.getReference()==null)
			  return -1;
		
			Agenda foundedAgenda = findByReference(agenda.getReference());
	       if(foundedAgenda==null)
	          return -1;  
	   agendaDao.delete(foundedAgenda);
	   return 1;
	}


	public List<Agenda> findByCriteria(AgendaVo agendaVo){
      String query = "SELECT o FROM Agenda o where 1=1 ";
			 query += SearchUtil.addConstraint( "o", "typePapier","LIKE",agendaVo.getTypePapier());

		 	 query += SearchUtil.addConstraint( "o", "prixUnitaire","=",agendaVo.getPrixUnitaire());
		 	 query += SearchUtil.addConstraint( "o", "fileOuNon","=",agendaVo.getFileOuNon());
		 	 query += SearchUtil.addConstraint( "o", "quantiteStock","=",agendaVo.getQuantiteStock());
			 query += SearchUtil.addConstraint( "o", "reference","LIKE",agendaVo.getReference());

		 	 query += SearchUtil.addConstraint( "o", "hauteur","=",agendaVo.getHauteur());
		 	 query += SearchUtil.addConstraint( "o", "id","=",agendaVo.getId());
		 	 query += SearchUtil.addConstraint( "o", "largeur","=",agendaVo.getLargeur());
	  query += SearchUtil.addConstraintMinMax("o","prixUnitaire",agendaVo.getPrixUnitaireMin(),agendaVo.getPrixUnitaireMax());
	  query += SearchUtil.addConstraintMinMax("o","quantiteStock",agendaVo.getQuantiteStockMin(),agendaVo.getQuantiteStockMax());
	  query += SearchUtil.addConstraintMinMax("o","hauteur",agendaVo.getHauteurMin(),agendaVo.getHauteurMax());
	  query += SearchUtil.addConstraintMinMax("o","largeur",agendaVo.getLargeurMin(),agendaVo.getLargeurMax());
	 return entityManager.createQuery(query).getResultList();
	}
	
 
}
