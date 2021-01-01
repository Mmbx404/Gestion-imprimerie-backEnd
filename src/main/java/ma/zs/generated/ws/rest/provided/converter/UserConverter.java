package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

  
import ma.zs.generated.bean.User; 
import ma.zs.generated.ws.rest.provided.vo.UserVo;

@Component 
public class UserConverter extends AbstractConverter<User,UserVo>{ 
	
	   @Autowired
         private CommandeConverter commandeConverter ;
    private Boolean commandes;

	public  UserConverter(){
		init(true);
	}

	@Override 
 	public User toItem(UserVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	User item = new User();
			 if(StringUtil.isNotEmpty(vo.getLastname()))
                  item.setLastname(vo.getLastname());
			 if(StringUtil.isNotEmpty(vo.getPassword()))
                  item.setPassword(vo.getPassword());
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));
			 if(StringUtil.isNotEmpty(vo.getEmail()))
                  item.setEmail(vo.getEmail());
			 if(StringUtil.isNotEmpty(vo.getName()))
                  item.setName(vo.getName());

	         if(ListUtil.isNotEmpty(vo.getCommandesVo()) && this.commandes)
                  item.setCommandes(commandeConverter.toItem(vo.getCommandesVo()));



		return item;
 		}
 	}

 	 @Override 
 	public UserVo toVo(User item) {
 		if (item == null) {
    		return null;
      	} else {
			UserVo vo = new UserVo();

			if(StringUtil.isNotEmpty(item.getLastname()))
				vo.setLastname(item.getLastname());
			
			if(StringUtil.isNotEmpty(item.getPassword()))
				vo.setPassword(item.getPassword());
			
			 if(item.getId()!=null)
				vo.setId(NumberUtil.toString(item.getId()));
			if(StringUtil.isNotEmpty(item.getEmail()))
				vo.setEmail(item.getEmail());
			
			if(StringUtil.isNotEmpty(item.getName()))
				vo.setName(item.getName());
			
	         if(ListUtil.isNotEmpty(item.getCommandes()) && this.commandes){
				
				 commandeConverter.init(false);
                vo.setCommandesVo(commandeConverter.toVo(item.getCommandes()));
              	 commandeConverter.init(true);
			 }

 			return vo;
 
 		}
 	}
	public void init(Boolean value) { 
       commandes = value;
	}


	

	
	   public CommandeConverter getCommandeConverter(){
		return this.commandeConverter;
	}  
        public void setCommandeConverter(CommandeConverter commandeConverter ){
		 this.commandeConverter = commandeConverter;
	}  
	
       public Boolean  isCommandes(){
		 return this.commandes ;
	   }
		 public void  setCommandes(Boolean commandes ){
            this.commandes  = commandes ;
		 }
}