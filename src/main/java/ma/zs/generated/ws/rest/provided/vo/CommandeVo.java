package  ma.zs.generated.ws.rest.provided.vo;

import java.util.List;
import java.util.Date;
import java.math.BigDecimal;   

public class CommandeVo {

     private String etat ;
   
     private String prixTotal ;
   
     private String id ;
   
     private String reference ;
   
     private String dateAchat ;
   

	private UserVo userVo ;

     private List<ProduitVo> produitsVo ;

     private String prixTotalMax ;
     private String prixTotalMin ;
     private String dateAchatMax ;
     private String dateAchatMin ;

 public CommandeVo(){
       super();
     }


     public String getEtat(){
          return this.etat;
     }
      public void setEtat(String etat){
          this.etat = etat;
     }


     public String getPrixTotal(){
          return this.prixTotal;
     }
      public void setPrixTotal(String prixTotal){
          this.prixTotal = prixTotal;
     }


     public String getId(){
          return this.id;
     }
      public void setId(String id){
          this.id = id;
     }


     public String getReference(){
          return this.reference;
     }
      public void setReference(String reference){
          this.reference = reference;
     }


     public String getDateAchat(){
          return this.dateAchat;
     }
      public void setDateAchat(String dateAchat){
          this.dateAchat = dateAchat;
     }



      public String getPrixTotalMax(){
          return this.prixTotalMax;
     }
     
      public String getPrixTotalMin(){
          return this.prixTotalMin;
     }

     public void setPrixTotalMax(String prixTotalMax){
          this.prixTotalMax = prixTotalMax;
     }

     public void setPrixTotalMin(String prixTotalMin){
          this.prixTotalMin = prixTotalMin;
     }
     
     
     

      public String getDateAchatMax(){
          return this.dateAchatMax;
     }
     
      public String getDateAchatMin(){
          return this.dateAchatMin;
     }

     public void setDateAchatMax(String dateAchatMax){
          this.dateAchatMax = dateAchatMax;
     }

     public void setDateAchatMin(String dateAchatMin){
          this.dateAchatMin = dateAchatMin;
     }
     
     

      public UserVo getUserVo(){
          return this.userVo;
     }
       
     public void setUserVo(UserVo userVo){
          this.userVo = userVo;
     }
   

      public List<ProduitVo> getProduitsVo(){
          return this.produitsVo;
     }
       
     public void setProduitsVo(List<ProduitVo> produitsVo){
          this.produitsVo = produitsVo;
     }



}