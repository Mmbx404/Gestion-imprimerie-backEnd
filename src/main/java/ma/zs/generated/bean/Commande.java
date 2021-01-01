package ma.zs.generated.bean;

import javax.persistence.ManyToOne;
import java.util.List;
import javax.persistence.OneToMany;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;   
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import ma.zs.generated.bean.User;

@Entity
public class Commande {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;

     private String etat ;
     private BigDecimal prixTotal ;
     private String reference ;
     @JsonFormat(pattern="yyyy-MM-dd")
     @Temporal(TemporalType.DATE)
     private Date dateAchat ;

     @ManyToOne
	private User user ;
     @OneToMany(mappedBy = "commande")
     private List<Produit> produits ;

     public Commande(){
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
     public Date getDateAchat(){
          return this.dateAchat;
     }
     public void setDateAchat(Date dateAchat){
          this.dateAchat = dateAchat;
     }
     public BigDecimal getPrixTotal(){
          return this.prixTotal;
     }
     public void setPrixTotal(BigDecimal prixTotal){
          this.prixTotal = prixTotal;
     }
     public String getEtat(){
          return this.etat;
     }
     public void setEtat(String etat){
          this.etat = etat;
     }
     public User getUser(){
          return this.user;
     }
     public void setUser(User user){
          this.user = user;
     }
     public List<Produit> getProduits(){
          return this.produits;
     }
     public void setProduits(List<Produit> produits){
          this.produits = produits;
     }



}

