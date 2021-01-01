package ma.zs.generated.bean;

import javax.persistence.ManyToOne;
import java.math.BigDecimal;   
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Agenda {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;

     private String typePapier ;
     private BigDecimal prixUnitaire ;
     private Boolean fileOuNon ;
     private Long quantiteStock ;
     private String reference ;
     private Long hauteur ;
     private Long largeur ;


     public Agenda(){
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
     public BigDecimal getPrixUnitaire(){
          return this.prixUnitaire;
     }
     public void setPrixUnitaire(BigDecimal prixUnitaire){
          this.prixUnitaire = prixUnitaire;
     }
     public String getTypePapier(){
          return this.typePapier;
     }
     public void setTypePapier(String typePapier){
          this.typePapier = typePapier;
     }
     public Long getQuantiteStock(){
          return this.quantiteStock;
     }
     public void setQuantiteStock(Long quantiteStock){
          this.quantiteStock = quantiteStock;
     }
    public Boolean isFileOuNon(){
          return this.fileOuNon;
     }
       public void setFileOuNon(Boolean fileOuNon){
          this.fileOuNon = fileOuNon;
     }



}

