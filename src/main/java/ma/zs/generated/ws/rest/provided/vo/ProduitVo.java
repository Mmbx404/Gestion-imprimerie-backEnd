package  ma.zs.generated.ws.rest.provided.vo;

import java.math.BigDecimal;   

public class ProduitVo {

     private String prixUnitaire ;
   
     private String typePapier ;
   
     private String largeur ;
   
     private String quantiteStock ;
   
     private String hauteur ;
   
     private String reference ;
   
     private String id ;
   

	private CommandeVo commandeVo ;


     private String prixUnitaireMax ;
     private String prixUnitaireMin ;
     private String largeurMax ;
     private String largeurMin ;
     private String quantiteStockMax ;
     private String quantiteStockMin ;
     private String hauteurMax ;
     private String hauteurMin ;

 public ProduitVo(){
       super();
     }


     public String getPrixUnitaire(){
          return this.prixUnitaire;
     }
      public void setPrixUnitaire(String prixUnitaire){
          this.prixUnitaire = prixUnitaire;
     }


     public String getTypePapier(){
          return this.typePapier;
     }
      public void setTypePapier(String typePapier){
          this.typePapier = typePapier;
     }


     public String getLargeur(){
          return this.largeur;
     }
      public void setLargeur(String largeur){
          this.largeur = largeur;
     }


     public String getQuantiteStock(){
          return this.quantiteStock;
     }
      public void setQuantiteStock(String quantiteStock){
          this.quantiteStock = quantiteStock;
     }


     public String getHauteur(){
          return this.hauteur;
     }
      public void setHauteur(String hauteur){
          this.hauteur = hauteur;
     }


     public String getReference(){
          return this.reference;
     }
      public void setReference(String reference){
          this.reference = reference;
     }


     public String getId(){
          return this.id;
     }
      public void setId(String id){
          this.id = id;
     }



      public String getPrixUnitaireMax(){
          return this.prixUnitaireMax;
     }
     
      public String getPrixUnitaireMin(){
          return this.prixUnitaireMin;
     }

     public void setPrixUnitaireMax(String prixUnitaireMax){
          this.prixUnitaireMax = prixUnitaireMax;
     }

     public void setPrixUnitaireMin(String prixUnitaireMin){
          this.prixUnitaireMin = prixUnitaireMin;
     }
     
     

      public String getLargeurMax(){
          return this.largeurMax;
     }
     
      public String getLargeurMin(){
          return this.largeurMin;
     }

     public void setLargeurMax(String largeurMax){
          this.largeurMax = largeurMax;
     }

     public void setLargeurMin(String largeurMin){
          this.largeurMin = largeurMin;
     }
     
     

      public String getQuantiteStockMax(){
          return this.quantiteStockMax;
     }
     
      public String getQuantiteStockMin(){
          return this.quantiteStockMin;
     }

     public void setQuantiteStockMax(String quantiteStockMax){
          this.quantiteStockMax = quantiteStockMax;
     }

     public void setQuantiteStockMin(String quantiteStockMin){
          this.quantiteStockMin = quantiteStockMin;
     }
     
     

      public String getHauteurMax(){
          return this.hauteurMax;
     }
     
      public String getHauteurMin(){
          return this.hauteurMin;
     }

     public void setHauteurMax(String hauteurMax){
          this.hauteurMax = hauteurMax;
     }

     public void setHauteurMin(String hauteurMin){
          this.hauteurMin = hauteurMin;
     }
     
     
     

      public CommandeVo getCommandeVo(){
          return this.commandeVo;
     }
       
     public void setCommandeVo(CommandeVo commandeVo){
          this.commandeVo = commandeVo;
     }
   




}