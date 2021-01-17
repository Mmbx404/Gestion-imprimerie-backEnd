package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

  
import ma.zs.generated.bean.Produit; 
import ma.zs.generated.ws.rest.provided.vo.ProduitVo;

@Component 
public class ProduitConverter extends AbstractConverter<Produit,ProduitVo>{ 
	
	   @Autowired
         private CommandeConverter commandeConverter ;
    private Boolean commande;

	public  ProduitConverter(){
		init(true);
	}

	@Override 
 	public Produit toItem(ProduitVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	Produit item = new Produit();
			 if(StringUtil.isNotEmpty(vo.getPrixUnitaire()))
                  item.setPrixUnitaire(NumberUtil.toBigDecimal(vo.getPrixUnitaire()));
			 if(StringUtil.isNotEmpty(vo.getTypePapier()))
                  item.setTypePapier(vo.getTypePapier());
			 if(StringUtil.isNotEmpty(vo.getLargeur()))
                  item.setLargeur(NumberUtil.toLong(vo.getLargeur()));
			 if(StringUtil.isNotEmpty(vo.getQuantiteStock()))
                  item.setQuantiteStock(NumberUtil.toLong(vo.getQuantiteStock()));
			 if(StringUtil.isNotEmpty(vo.getHauteur()))
                  item.setHauteur(NumberUtil.toLong(vo.getHauteur()));
			 if(StringUtil.isNotEmpty(vo.getReference()))
                  item.setReference(vo.getReference());
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));
             if(vo.getCommandeVo()!=null && this.commande)
			     item.setCommande(commandeConverter.toItem(vo.getCommandeVo())) ;
             item.setContent(vo.getContent());

		return item;
 		}
 	}

 	 @Override 
 	public ProduitVo toVo(Produit item) {
 		if (item == null) {
    		return null;
      	} else {
			ProduitVo vo = new ProduitVo();

			 if(item.getPrixUnitaire()!=null)
				vo.setPrixUnitaire(NumberUtil.toString(item.getPrixUnitaire()));
			if(StringUtil.isNotEmpty(item.getTypePapier()))
				vo.setTypePapier(item.getTypePapier());
			
			 if(item.getLargeur()!=null)
				vo.setLargeur(NumberUtil.toString(item.getLargeur()));
			 if(item.getQuantiteStock()!=null)
				vo.setQuantiteStock(NumberUtil.toString(item.getQuantiteStock()));
			 if(item.getHauteur()!=null)
				vo.setHauteur(NumberUtil.toString(item.getHauteur()));
			if(StringUtil.isNotEmpty(item.getReference()))
				vo.setReference(item.getReference());
			
			 if(item.getId()!=null)
				vo.setId(NumberUtil.toString(item.getId()));
            if(item.getCommande()!=null && this.commande) {
				   vo.setCommandeVo(commandeConverter.toVo(item.getCommande())) ;
			   }
            vo.setContent(item.getContent());
 			return vo;
 
 		}
 	}
	public void init(Boolean value) { 
       commande = value;
	}


	

	
	   public CommandeConverter getCommandeConverter(){
		return this.commandeConverter;
	}  
        public void setCommandeConverter(CommandeConverter commandeConverter ){
		 this.commandeConverter = commandeConverter;
	}  
	
	 public boolean  isCommande(){
		  return this.commande;
	 }
	 public void  setCommande(boolean commande){
		   this.commande = commande;
	 }
}