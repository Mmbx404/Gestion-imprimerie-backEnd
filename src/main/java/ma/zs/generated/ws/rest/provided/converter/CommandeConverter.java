package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

  
import ma.zs.generated.bean.Commande; 
import ma.zs.generated.ws.rest.provided.vo.CommandeVo;

@Component 
public class CommandeConverter extends AbstractConverter<Commande,CommandeVo>{ 
	
	   @Autowired
         private UserConverter userConverter ;
	   @Autowired
         private ProduitConverter produitConverter ;
    private Boolean user;
    private Boolean produits;

	public  CommandeConverter(){
		init(true);
	}

	@Override 
 	public Commande toItem(CommandeVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	Commande item = new Commande();
			 if(StringUtil.isNotEmpty(vo.getEtat()))
                  item.setEtat(vo.getEtat());
			 if(StringUtil.isNotEmpty(vo.getPrixTotal()))
                  item.setPrixTotal(NumberUtil.toBigDecimal(vo.getPrixTotal()));
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));
			 if(StringUtil.isNotEmpty(vo.getReference()))
                  item.setReference(vo.getReference());
             if(StringUtil.isNotEmpty(vo.getDateAchat()))
			      item.setDateAchat(DateUtil.parse(vo.getDateAchat()));
             if(vo.getUserVo()!=null && this.user)
			     item.setUser(userConverter.toItem(vo.getUserVo())) ;

	         if(ListUtil.isNotEmpty(vo.getProduitsVo()) && this.produits)
                  item.setProduits(produitConverter.toItem(vo.getProduitsVo()));



		return item;
 		}
 	}

 	 @Override 
 	public CommandeVo toVo(Commande item) {
 		if (item == null) {
    		return null;
      	} else {
			CommandeVo vo = new CommandeVo();

			if(StringUtil.isNotEmpty(item.getEtat()))
				vo.setEtat(item.getEtat());
			
			 if(item.getPrixTotal()!=null)
				vo.setPrixTotal(NumberUtil.toString(item.getPrixTotal()));
			 if(item.getId()!=null)
				vo.setId(NumberUtil.toString(item.getId()));
			if(StringUtil.isNotEmpty(item.getReference()))
				vo.setReference(item.getReference());
			
            if(item.getDateAchat()!=null)
			    vo.setDateAchat(DateUtil.formateDate(item.getDateAchat()));	     
            if(item.getUser()!=null && this.user) {
				   vo.setUserVo(userConverter.toVo(item.getUser())) ;
			   } 
	         if(ListUtil.isNotEmpty(item.getProduits()) && this.produits){
				
				 produitConverter.init(false);
                vo.setProduitsVo(produitConverter.toVo(item.getProduits()));
              	 produitConverter.init(true);
			 }

 			return vo;
 
 		}
 	}
	public void init(Boolean value) { 
       user = value;
       produits = value;
	}


	

	
	   public UserConverter getUserConverter(){
		return this.userConverter;
	}  
        public void setUserConverter(UserConverter userConverter ){
		 this.userConverter = userConverter;
	}  
	   public ProduitConverter getProduitConverter(){
		return this.produitConverter;
	}  
        public void setProduitConverter(ProduitConverter produitConverter ){
		 this.produitConverter = produitConverter;
	}  
	
	 public boolean  isUser(){
		  return this.user;
	 }
	 public void  setUser(boolean user){
		   this.user = user;
	 }
       public Boolean  isProduits(){
		 return this.produits ;
	   }
		 public void  setProduits(Boolean produits ){
            this.produits  = produits ;
		 }
}