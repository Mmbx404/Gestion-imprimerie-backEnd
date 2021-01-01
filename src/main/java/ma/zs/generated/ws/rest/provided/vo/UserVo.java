package  ma.zs.generated.ws.rest.provided.vo;

import java.util.List;

public class UserVo {

     private String lastname ;
   
     private String password ;
   
     private String id ;
   
     private String email ;
   
     private String name ;
   


     private List<CommandeVo> commandesVo ;


 public UserVo(){
       super();
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


     public String getId(){
          return this.id;
     }
      public void setId(String id){
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


     


      public List<CommandeVo> getCommandesVo(){
          return this.commandesVo;
     }
       
     public void setCommandesVo(List<CommandeVo> commandesVo){
          this.commandesVo = commandesVo;
     }



}