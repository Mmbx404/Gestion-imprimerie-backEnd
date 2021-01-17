package ma.zs.generated.bean;

import javax.persistence.ManyToOne;
import java.math.BigDecimal;   
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class CarteVisite extends Produit {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;

     private BigDecimal prixUnitaire ;
     private byte[] content;
     private String typePapier ;
     private Boolean plastifier ;
     private Long quantiteStock ;
     private Long hauteur ;
     private String reference ;
     private Long largeur ;


     public CarteVisite(){
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
    public Boolean isPlastifier(){
          return this.plastifier;
     }
       public void setPlastifier(Boolean plastifier){
          this.plastifier = plastifier;
     }

     public byte[] getContent() {
          return content;
     }

     public void setContent(byte[] content) {
          this.content = content;
     }
}

