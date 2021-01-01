package ma.zs.generated.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import ma.zs.generated.bean.User;
import ma.zs.generated.bean.Commande;
import ma.zs.generated.dao.UserDao;
import ma.zs.generated.service.facade.UserService;
import ma.zs.generated.service.facade.CommandeService;   

import ma.zs.generated.ws.rest.provided.vo.UserVo;
import ma.zs.generated.service.util.*;
@Service
public class UserServiceImpl implements UserService {

   @Autowired
   private UserDao userDao;
   
    @Autowired
    private CommandeService commandeService ;

   @Autowired 
   private EntityManager entityManager; 

	@Override
	public List<User> findAll(){
		return userDao.findAll();
	}	
	@Override
	public User findByEmail(String email){
		if( email==null)
		  return null;
		return userDao.findByEmail(email);
	}

   

	@Override
	@Transactional
	public int deleteByEmail(String  email) {
		return userDao.deleteByEmail(email);	 
	}

	@Override
	public User findById(Long id){
		 if(id==null)
		  return null;
		return userDao.getOne(id);
	}
    
	@Transactional
   public void deleteById(Long id){
           userDao.deleteById(id);
   }
	@Override	
	public User save (User user){
			User foundedUser = findByEmail(user.getEmail());
	       if(foundedUser!=null)
	          return null;  

	    User savedUser = userDao.save(user);
               if(ListUtil.isNotEmpty(user.getCommandes())){
		  savedUser.setCommandes(commandeService.save(prepareCommandes(savedUser,user.getCommandes())));
		 }
	   return savedUser;
	}

    @Override
    public List<User> save(List<User> users){
		List<User> list = new ArrayList<User>();
		for(User user: users){
		        list.add(save(user));	
		}
		return list;
	}

     private List<Commande> prepareCommandes(User user,List<Commande> commandes){
		    for(Commande commande:commandes ){
                  commande.setUser(user); 
			}
			return commandes;
	  }

   @Override
   public User update(User user){
     
    
		  User foundedUser = findById(user.getId()); 
		       if(foundedUser==null)
	          return null;	  
	  
	   return  userDao.save(user);
     
     }
    
	@Override
	@Transactional
	public int delete(User user){

	        if(user.getEmail()==null)
			  return -1;
		
			User foundedUser = findByEmail(user.getEmail());
	       if(foundedUser==null)
	          return -1;  
	   userDao.delete(foundedUser);
	   return 1;
	}


	public List<User> findByCriteria(UserVo userVo){
      String query = "SELECT o FROM User o where 1=1 ";
			 query += SearchUtil.addConstraint( "o", "lastname","LIKE",userVo.getLastname());

			 query += SearchUtil.addConstraint( "o", "password","LIKE",userVo.getPassword());

		 	 query += SearchUtil.addConstraint( "o", "id","=",userVo.getId());
			 query += SearchUtil.addConstraint( "o", "email","LIKE",userVo.getEmail());

			 query += SearchUtil.addConstraint( "o", "name","LIKE",userVo.getName());

	 return entityManager.createQuery(query).getResultList();
	}
	
 
}
