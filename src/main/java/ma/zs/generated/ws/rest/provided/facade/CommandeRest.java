package  ma.zs.generated.ws.rest.provided.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.zs.generated.bean.Commande; 
import ma.zs.generated.service.facade.CommandeService;
import ma.zs.generated.ws.rest.provided.converter.CommandeConverter;
import ma.zs.generated.ws.rest.provided.vo.CommandeVo;

@Api("Manages commande services")
@RestController
@RequestMapping("generated/commande")
public class CommandeRest {

	@Autowired 
	private CommandeService commandeService;
	
	@Autowired 
	private CommandeConverter commandeConverter ;

    @ApiOperation("Saves the specified commande")
	@PostMapping("/")
	public CommandeVo save(@RequestBody CommandeVo commandeVo){
    	commandeConverter.setProduits(true);
		Commande commande= commandeConverter.toItem(commandeVo);
	  commande=	commandeService.save(commande);
		return commandeConverter.toVo(commande);
	}

    @ApiOperation("Delete the specified commande")
	@DeleteMapping("/")
	public int delete(@RequestBody CommandeVo commandeVo){
		Commande commande = commandeConverter.toItem(commandeVo);
		return commandeService.delete(commande);
	}

	@ApiOperation("Updates the specified commande")
	@PutMapping("/")
	public CommandeVo update(@RequestBody CommandeVo commandeVo){
		Commande commande= commandeConverter.toItem(commandeVo);
	  commande=	commandeService.update(commande);
		return commandeConverter.toVo(commande);
	}

	@ApiOperation("Finds a list of all commandes")
	@GetMapping("/")
	public List<CommandeVo> findAll(){
		commandeConverter.setProduits(true);
    	return commandeConverter.toVo(commandeService.findAll());
	}
    
	@ApiOperation("Finds a commande by id")
	@GetMapping("/id/{id}")
	public CommandeVo findById(@PathVariable Long id){
		return  commandeConverter.toVo(commandeService.findById(id));
	}
	@ApiOperation("Deletes a commande by id")
	@DeleteMapping("/id/{id}")
	public void deleteById(@PathVariable Long id){
		 commandeService.deleteById(id);
	}

	@ApiOperation("Finds a  commande by reference")
    @GetMapping("/reference/{reference}")
	public CommandeVo findByReference(@PathVariable String reference){
		return  commandeConverter.toVo(commandeService.findByReference(reference));
	}
	@ApiOperation("Deletes a  commande by reference")
    @DeleteMapping("/reference/{reference}")
	public int deleteByReference(@PathVariable String reference){
		return  commandeService.deleteByReference(reference);
	}
	


    @ApiOperation("Finds a commande by email of user")
	@GetMapping("/user/email/{email}")
	public List<CommandeVo> findByUserEmail(@PathVariable String email){
		return commandeConverter.toVo(commandeService.findByUserEmail(email));
	}
	
	@ApiOperation("Deletes a commande by email of user")
	@DeleteMapping("/user/email/{email}")
	public int deleteByUserEmail(@PathVariable String email){
		return commandeService.deleteByUserEmail(email);
	}
	
	@ApiOperation("Finds commande by id of user")
	@GetMapping("/user/id/{id}")
	public List<CommandeVo> findByUserId(@PathVariable Long id){
		return commandeConverter.toVo(commandeService.findByUserId(id));
	}
	@ApiOperation("Deletes commande by id of user")
	@DeleteMapping("/user/id/{id}")
	public int deleteByUserId(@PathVariable Long id){
		return commandeService.deleteByUserId(id);
	}
     	
   
    @ApiOperation("Search commande by a specific criterion")
    @PostMapping("/search")
	public List<CommandeVo> findByCriteria(@RequestBody CommandeVo commandeVo){
       return commandeConverter.toVo(commandeService.findByCriteria(commandeVo));
	}	
	public CommandeConverter getCommandeConverter(){
		return commandeConverter;
	}
 
	public void setCommandeConverter(CommandeConverter commandeConverter){
		this.commandeConverter=commandeConverter;
	}

	public CommandeService getCommandeService(){
		return commandeService;
	}
	public void setCommandeService( CommandeService commandeService){
	 	this.commandeService=commandeService;
	}
	

}