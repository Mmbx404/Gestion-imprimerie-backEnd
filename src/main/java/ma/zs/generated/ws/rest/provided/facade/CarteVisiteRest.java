package  ma.zs.generated.ws.rest.provided.facade;

import java.io.IOException;
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
import ma.zs.generated.bean.CarteVisite; 
import ma.zs.generated.service.facade.CarteVisiteService;
import ma.zs.generated.ws.rest.provided.converter.CarteVisiteConverter;
import ma.zs.generated.ws.rest.provided.vo.CarteVisiteVo;
import org.springframework.web.multipart.MultipartFile;

@Api("Manages carteVisite services")
@RestController
@RequestMapping("generated/carteVisite")
public class CarteVisiteRest {

	@Autowired 
	private CarteVisiteService carteVisiteService;
	
	@Autowired 
	private CarteVisiteConverter carteVisiteConverter ;

    @ApiOperation("Saves the specified carteVisite")
	@PostMapping("/")
	public CarteVisiteVo save(@RequestBody CarteVisiteVo carteVisiteVo){
		CarteVisite carteVisite= carteVisiteConverter.toItem(carteVisiteVo);
	  carteVisite=	carteVisiteService.save(carteVisite);
		return carteVisiteConverter.toVo(carteVisite);
	}

    @ApiOperation("Delete the specified carteVisite")
	@DeleteMapping("/")
	public int delete(@RequestBody CarteVisiteVo carteVisiteVo){
		CarteVisite carteVisite = carteVisiteConverter.toItem(carteVisiteVo);
		return carteVisiteService.delete(carteVisite);
	}

	@ApiOperation("Updates the specified carteVisite")
	@PutMapping("/update/")
	public CarteVisiteVo update(@RequestBody CarteVisiteVo carteVisiteVo){
		CarteVisite carteVisite= carteVisiteConverter.toItem(carteVisiteVo);
	  carteVisite=	carteVisiteService.update(carteVisite);
		return carteVisiteConverter.toVo(carteVisite);
	}

	@ApiOperation("Finds a list of all carteVisites")
	@GetMapping("/")
	public List<CarteVisiteVo> findAll(){
		return carteVisiteConverter.toVo(carteVisiteService.findAll());
	}
    
	@ApiOperation("Finds a carteVisite by id")
	@GetMapping("/id/{id}")
	public CarteVisiteVo findById(@PathVariable Long id){
		return  carteVisiteConverter.toVo(carteVisiteService.findById(id));
	}
	@ApiOperation("Deletes a carteVisite by id")
	@DeleteMapping("/id/{id}")
	public void deleteById(@PathVariable Long id){
		 carteVisiteService.deleteById(id);
	}

	@ApiOperation("Finds a  carteVisite by reference")
    @GetMapping("/reference/{reference}")
	public CarteVisiteVo findByReference(@PathVariable String reference){
		return  carteVisiteConverter.toVo(carteVisiteService.findByReference(reference));
	}
	@ApiOperation("Deletes a  carteVisite by reference")
    @DeleteMapping("/reference/{reference}")
	public int deleteByReference(@PathVariable String reference){
		return  carteVisiteService.deleteByReference(reference);
	}
	


   
    @ApiOperation("Search carteVisite by a specific criterion")
    @PostMapping("/search")
	public List<CarteVisiteVo> findByCriteria(@RequestBody CarteVisiteVo carteVisiteVo){
       return carteVisiteConverter.toVo(carteVisiteService.findByCriteria(carteVisiteVo));
	}

	@PostMapping("/upload/{reference}")
	public int uploadContent(@RequestBody MultipartFile file,@PathVariable String reference) throws IOException {
    	return this.carteVisiteService.uploadContent(file,reference);
	}
	public CarteVisiteConverter getCarteVisiteConverter(){
		return carteVisiteConverter;
	}
 
	public void setCarteVisiteConverter(CarteVisiteConverter carteVisiteConverter){
		this.carteVisiteConverter=carteVisiteConverter;
	}

	public CarteVisiteService getCarteVisiteService(){
		return carteVisiteService;
	}
	public void setCarteVisiteService( CarteVisiteService carteVisiteService){
	 	this.carteVisiteService=carteVisiteService;
	}
	

}