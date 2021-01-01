package ma.zs.generated.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import ma.zs.generated.bean.Menu;
import ma.zs.generated.dao.MenuDao;
import ma.zs.generated.service.facade.MenuService;

import ma.zs.generated.ws.rest.provided.vo.MenuVo;
import ma.zs.generated.service.util.*;
@Service
public class MenuServiceImpl implements MenuService {

   @Autowired
   private MenuDao menuDao;
   

   @Autowired 
   private EntityManager entityManager; 

	@Override
	public List<Menu> findAll(){
		return menuDao.findAll();
	}	
	@Override
	public Menu findByReference(String reference){
		if( reference==null)
		  return null;
		return menuDao.findByReference(reference);
	}

   

	@Override
	@Transactional
	public int deleteByReference(String  reference) {
		return menuDao.deleteByReference(reference);	 
	}

	@Override
	public Menu findById(Long id){
		 if(id==null)
		  return null;
		return menuDao.getOne(id);
	}
    
	@Transactional
   public void deleteById(Long id){
           menuDao.deleteById(id);
   }
	@Override	
	public Menu save (Menu menu){
			Menu foundedMenu = findByReference(menu.getReference());
	       if(foundedMenu!=null)
	          return null;  

	    Menu savedMenu = menuDao.save(menu);
	   return savedMenu;
	}

    @Override
    public List<Menu> save(List<Menu> menus){
		List<Menu> list = new ArrayList<Menu>();
		for(Menu menu: menus){
		        list.add(save(menu));	
		}
		return list;
	}


   @Override
   public Menu update(Menu menu){
     
    
		  Menu foundedMenu = findById(menu.getId()); 
		       if(foundedMenu==null)
	          return null;	  
	  
	   return  menuDao.save(menu);
     
     }
    
	@Override
	@Transactional
	public int delete(Menu menu){

	        if(menu.getReference()==null)
			  return -1;
		
			Menu foundedMenu = findByReference(menu.getReference());
	       if(foundedMenu==null)
	          return -1;  
	   menuDao.delete(foundedMenu);
	   return 1;
	}


	public List<Menu> findByCriteria(MenuVo menuVo){
      String query = "SELECT o FROM Menu o where 1=1 ";
		 	 query += SearchUtil.addConstraint( "o", "quantiteStock","=",menuVo.getQuantiteStock());
			 query += SearchUtil.addConstraint( "o", "typePapier","LIKE",menuVo.getTypePapier());

		 	 query += SearchUtil.addConstraint( "o", "hauteur","=",menuVo.getHauteur());
		 	 query += SearchUtil.addConstraint( "o", "largeur","=",menuVo.getLargeur());
			 query += SearchUtil.addConstraint( "o", "reference","LIKE",menuVo.getReference());

		 	 query += SearchUtil.addConstraint( "o", "prixUnitaire","=",menuVo.getPrixUnitaire());
		 	 query += SearchUtil.addConstraint( "o", "nombrePages","=",menuVo.getNombrePages());
	  query += SearchUtil.addConstraintMinMax("o","quantiteStock",menuVo.getQuantiteStockMin(),menuVo.getQuantiteStockMax());
	  query += SearchUtil.addConstraintMinMax("o","hauteur",menuVo.getHauteurMin(),menuVo.getHauteurMax());
	  query += SearchUtil.addConstraintMinMax("o","largeur",menuVo.getLargeurMin(),menuVo.getLargeurMax());
	  query += SearchUtil.addConstraintMinMax("o","prixUnitaire",menuVo.getPrixUnitaireMin(),menuVo.getPrixUnitaireMax());
	  query += SearchUtil.addConstraintMinMax("o","nombrePages",menuVo.getNombrePagesMin(),menuVo.getNombrePagesMax());
	 return entityManager.createQuery(query).getResultList();
	}
	
 
}
