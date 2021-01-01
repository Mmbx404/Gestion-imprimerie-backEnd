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
import ma.zs.generated.bean.Flyer; 
import ma.zs.generated.service.facade.FlyerService;
import ma.zs.generated.ws.rest.provided.converter.FlyerConverter;
import ma.zs.generated.ws.rest.provided.vo.FlyerVo;

@Api("Manages flyer services")
@RestController
@RequestMapping("generated/flyer")
public class FlyerRest {

	@Autowired 
	private FlyerService flyerService;
	
	@Autowired 
	private FlyerConverter flyerConverter ;

    @ApiOperation("Saves the specified flyer")
	@PostMapping("/")
	public FlyerVo save(@RequestBody FlyerVo flyerVo){
		Flyer flyer= flyerConverter.toItem(flyerVo);
	  flyer=	flyerService.save(flyer);
		return flyerConverter.toVo(flyer);
	}

    @ApiOperation("Delete the specified flyer")
	@DeleteMapping("/")
	public int delete(@RequestBody FlyerVo flyerVo){
		Flyer flyer = flyerConverter.toItem(flyerVo);
		return flyerService.delete(flyer);
	}

	@ApiOperation("Updates the specified flyer")
	@PutMapping("/")
	public FlyerVo update(@RequestBody FlyerVo flyerVo){
		Flyer flyer= flyerConverter.toItem(flyerVo);
	  flyer=	flyerService.update(flyer);
		return flyerConverter.toVo(flyer);
	}

	@ApiOperation("Finds a list of all flyers")
	@GetMapping("/")
	public List<FlyerVo> findAll(){
		return flyerConverter.toVo(flyerService.findAll());
	}
    
	@ApiOperation("Finds a flyer by id")
	@GetMapping("/id/{id}")
	public FlyerVo findById(@PathVariable Long id){
		return  flyerConverter.toVo(flyerService.findById(id));
	}
	@ApiOperation("Deletes a flyer by id")
	@DeleteMapping("/id/{id}")
	public void deleteById(@PathVariable Long id){
		 flyerService.deleteById(id);
	}

	@ApiOperation("Finds a  flyer by reference")
    @GetMapping("/reference/{reference}")
	public FlyerVo findByReference(@PathVariable String reference){
		return  flyerConverter.toVo(flyerService.findByReference(reference));
	}
	@ApiOperation("Deletes a  flyer by reference")
    @DeleteMapping("/reference/{reference}")
	public int deleteByReference(@PathVariable String reference){
		return  flyerService.deleteByReference(reference);
	}
	


   
    @ApiOperation("Search flyer by a specific criterion")
    @PostMapping("/search")
	public List<FlyerVo> findByCriteria(@RequestBody FlyerVo flyerVo){
       return flyerConverter.toVo(flyerService.findByCriteria(flyerVo));
	}	
	public FlyerConverter getFlyerConverter(){
		return flyerConverter;
	}
 
	public void setFlyerConverter(FlyerConverter flyerConverter){
		this.flyerConverter=flyerConverter;
	}

	public FlyerService getFlyerService(){
		return flyerService;
	}
	public void setFlyerService( FlyerService flyerService){
	 	this.flyerService=flyerService;
	}
	

}