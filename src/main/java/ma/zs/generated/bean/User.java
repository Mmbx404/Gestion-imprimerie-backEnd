package ma.zs.generated.bean;

import javax.persistence.ManyToOne;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class User {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;

     private String lastname ;
     private String password ;
     private String email ;
     private String name ;

     @OneToMany(mappedBy = "user")
     private List<Commande> commandes ;

     public User(){
       super();
     }

     public Long getId(){
          return this.id;
     }
     public void setId(Long id){
          this.id = id;
     }
     public String getEmail(){
          return this.email;
     }
     public void setEmail(String email){
          this.email = email;
     }
     public String getName(){
          return this.name;
     }
     public void setName(String name){
          this.name = name;
     }
     public String getLastname(){
          return this.lastname;
     }
     public void setLastname(String lastname){
          this.lastname = lastname;
     }
     public String getPassword(){
          return this.password;
     }
     public void setPassword(String password){
          this.password = password;
     }
     public List<Commande> getCommandes(){
          return this.commandes;
     }
     public void setCommandes(List<Commande> commandes){
          this.commandes = commandes;
     }



}

