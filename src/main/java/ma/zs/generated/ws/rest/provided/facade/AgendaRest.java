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
import ma.zs.generated.bean.Agenda; 
import ma.zs.generated.service.facade.AgendaService;
import ma.zs.generated.ws.rest.provided.converter.AgendaConverter;
import ma.zs.generated.ws.rest.provided.vo.AgendaVo;

@Api("Manages agenda services")
@RestController
@RequestMapping("generated/agenda")
public class AgendaRest {

	@Autowired 
	private AgendaService agendaService;
	
	@Autowired 
	private AgendaConverter agendaConverter ;

    @ApiOperation("Saves the specified agenda")
	@PostMapping("/")
	public AgendaVo save(@RequestBody AgendaVo agendaVo){
		Agenda agenda= agendaConverter.toItem(agendaVo);
	  agenda=	agendaService.save(agenda);
		return agendaConverter.toVo(agenda);
	}

    @ApiOperation("Delete the specified agenda")
	@DeleteMapping("/")
	public int delete(@RequestBody AgendaVo agendaVo){
		Agenda agenda = agendaConverter.toItem(agendaVo);
		return agendaService.delete(agenda);
	}

	@ApiOperation("Updates the specified agenda")
	@PutMapping("/")
	public AgendaVo update(@RequestBody AgendaVo agendaVo){
		Agenda agenda= agendaConverter.toItem(agendaVo);
	  agenda=	agendaService.update(agenda);
		return agendaConverter.toVo(agenda);
	}

	@ApiOperation("Finds a list of all agendas")
	@GetMapping("/")
	public List<AgendaVo> findAll(){
		return agendaConverter.toVo(agendaService.findAll());
	}
    
	@ApiOperation("Finds a agenda by id")
	@GetMapping("/id/{id}")
	public AgendaVo findById(@PathVariable Long id){
		return  agendaConverter.toVo(agendaService.findById(id));
	}
	@ApiOperation("Deletes a agenda by id")
	@DeleteMapping("/id/{id}")
	public void deleteById(@PathVariable Long id){
		 agendaService.deleteById(id);
	}

	@ApiOperation("Finds a  agenda by reference")
    @GetMapping("/reference/{reference}")
	public AgendaVo findByReference(@PathVariable String reference){
		return  agendaConverter.toVo(agendaService.findByReference(reference));
	}
	@ApiOperation("Deletes a  agenda by reference")
    @DeleteMapping("/reference/{reference}")
	public int deleteByReference(@PathVariable String reference){
		return  agendaService.deleteByReference(reference);
	}
	


   
    @ApiOperation("Search agenda by a specific criterion")
    @PostMapping("/search")
	public List<AgendaVo> findByCriteria(@RequestBody AgendaVo agendaVo){
       return agendaConverter.toVo(agendaService.findByCriteria(agendaVo));
	}	
	public AgendaConverter getAgendaConverter(){
		return agendaConverter;
	}
 
	public void setAgendaConverter(AgendaConverter agendaConverter){
		this.agendaConverter=agendaConverter;
	}

	public AgendaService getAgendaService(){
		return agendaService;
	}
	public void setAgendaService( AgendaService agendaService){
	 	this.agendaService=agendaService;
	}
	

}