package ma.zs.generated.bean;

import javax.persistence.ManyToOne;
import java.math.BigDecimal;   
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import ma.zs.generated.bean.Commande;

@Entity
public class Produit {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;

     private BigDecimal prixUnitaire ;
     private String typePapier ;
     private Long largeur ;
     private Long quantiteStock ;
     private Long hauteur ;
     private String reference ;

     @ManyToOne
	private Commande commande ;

     public Produit(){
       super();
     }

     public Long getId(){
          return this.id;
     }
     public void setId(Long id){
          this.id = id;
     }
     public String getReference(){
          return this.reference;
     }
     public void setReference(String reference){
          this.reference = reference;
     }
     public Long getHauteur(){
          return this.hauteur;
     }
     public void setHauteur(Long hauteur){
          this.hauteur = hauteur;
     }
     public Long getLargeur(){
          return this.largeur;
     }
     public void setLargeur(Long largeur){
          this.largeur = largeur;
     }
     public String getTypePapier(){
          return this.typePapier;
     }
     public void setTypePapier(String typePapier){
          this.typePapier = typePapier;
     }
     public BigDecimal getPrixUnitaire(){
          return this.prixUnitaire;
     }
     public void setPrixUnitaire(BigDecimal prixUnitaire){
          this.prixUnitaire = prixUnitaire;
     }
     public Long getQuantiteStock(){
          return this.quantiteStock;
     }
     public void setQuantiteStock(Long quantiteStock){
          this.quantiteStock = quantiteStock;
     }
     public Commande getCommande(){
          return this.commande;
     }
     public void setCommande(Commande commande){
          this.commande = commande;
     }



}
