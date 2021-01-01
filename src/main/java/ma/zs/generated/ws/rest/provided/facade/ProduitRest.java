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
import ma.zs.generated.bean.Produit; 
import ma.zs.generated.service.facade.ProduitService;
import ma.zs.generated.ws.rest.provided.converter.ProduitConverter;
import ma.zs.generated.ws.rest.provided.vo.ProduitVo;

@Api("Manages produit services")
@RestController
@RequestMapping("generated/produit")
public class ProduitRest {

	@Autowired 
	private ProduitService produitService;
	
	@Autowired 
	private ProduitConverter produitConverter ;

    @ApiOperation("Saves the specified produit")
	@PostMapping("/")
	public ProduitVo save(@RequestBody ProduitVo produitVo){
		Produit produit= produitConverter.toItem(produitVo);
	  produit=	produitService.save(produit);
		return produitConverter.toVo(produit);
	}

    @ApiOperation("Delete the specified produit")
	@DeleteMapping("/")
	public int delete(@RequestBody ProduitVo produitVo){
		Produit produit = produitConverter.toItem(produitVo);
		return produitService.delete(produit);
	}

	@ApiOperation("Updates the specified produit")
	@PutMapping("/")
	public ProduitVo update(@RequestBody ProduitVo produitVo){
		Produit produit= produitConverter.toItem(produitVo);
	  produit=	produitService.update(produit);
		return produitConverter.toVo(produit);
	}

	@ApiOperation("Finds a list of all produits")
	@GetMapping("/")
	public List<ProduitVo> findAll(){
		return produitConverter.toVo(produitService.findAll());
	}
    
	@ApiOperation("Finds a produit by id")
	@GetMapping("/id/{id}")
	public ProduitVo findById(@PathVariable Long id){
		return  produitConverter.toVo(produitService.findById(id));
	}
	@ApiOperation("Deletes a produit by id")
	@DeleteMapping("/id/{id}")
	public void deleteById(@PathVariable Long id){
		 produitService.deleteById(id);
	}

	@ApiOperation("Finds a  produit by reference")
    @GetMapping("/reference/{reference}")
	public ProduitVo findByReference(@PathVariable String reference){
		return  produitConverter.toVo(produitService.findByReference(reference));
	}
	@ApiOperation("Deletes a  produit by reference")
    @DeleteMapping("/reference/{reference}")
	public int deleteByReference(@PathVariable String reference){
		return  produitService.deleteByReference(reference);
	}
	


    @ApiOperation("Finds a produit by reference of commande")
	@GetMapping("/commande/reference/{reference}")
	public List<ProduitVo> findByCommandeReference(@PathVariable String reference){
		return produitConverter.toVo(produitService.findByCommandeReference(reference));
	}
	
	@ApiOperation("Deletes a produit by reference of commande")
	@DeleteMapping("/commande/reference/{reference}")
	public int deleteByCommandeReference(@PathVariable String reference){
		return produitService.deleteByCommandeReference(reference);
	}
	
	@ApiOperation("Finds produit by id of commande")
	@GetMapping("/commande/id/{id}")
	public List<ProduitVo> findByCommandeId(@PathVariable Long id){
		return produitConverter.toVo(produitService.findByCommandeId(id));
	}
	@ApiOperation("Deletes produit by id of commande")
	@DeleteMapping("/commande/id/{id}")
	public int deleteByCommandeId(@PathVariable Long id){
		return produitService.deleteByCommandeId(id);
	}
     	
   
    @ApiOperation("Search produit by a specific criterion")
    @PostMapping("/search")
	public List<ProduitVo> findByCriteria(@RequestBody ProduitVo produitVo){
       return produitConverter.toVo(produitService.findByCriteria(produitVo));
	}	
	public ProduitConverter getProduitConverter(){
		return produitConverter;
	}
 
	public void setProduitConverter(ProduitConverter produitConverter){
		this.produitConverter=produitConverter;
	}

	public ProduitService getProduitService(){
		return produitService;
	}
	public void setProduitService( ProduitService produitService){
	 	this.produitService=produitService;
	}
	

}