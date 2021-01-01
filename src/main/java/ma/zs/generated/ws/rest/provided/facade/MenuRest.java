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
import ma.zs.generated.bean.Menu; 
import ma.zs.generated.service.facade.MenuService;
import ma.zs.generated.ws.rest.provided.converter.MenuConverter;
import ma.zs.generated.ws.rest.provided.vo.MenuVo;

@Api("Manages menu services")
@RestController
@RequestMapping("generated/menu")
public class MenuRest {

	@Autowired 
	private MenuService menuService;
	
	@Autowired 
	private MenuConverter menuConverter ;

    @ApiOperation("Saves the specified menu")
	@PostMapping("/")
	public MenuVo save(@RequestBody MenuVo menuVo){
		Menu menu= menuConverter.toItem(menuVo);
	  menu=	menuService.save(menu);
		return menuConverter.toVo(menu);
	}

    @ApiOperation("Delete the specified menu")
	@DeleteMapping("/")
	public int delete(@RequestBody MenuVo menuVo){
		Menu menu = menuConverter.toItem(menuVo);
		return menuService.delete(menu);
	}

	@ApiOperation("Updates the specified menu")
	@PutMapping("/")
	public MenuVo update(@RequestBody MenuVo menuVo){
		Menu menu= menuConverter.toItem(menuVo);
	  menu=	menuService.update(menu);
		return menuConverter.toVo(menu);
	}

	@ApiOperation("Finds a list of all menus")
	@GetMapping("/")
	public List<MenuVo> findAll(){
		return menuConverter.toVo(menuService.findAll());
	}
    
	@ApiOperation("Finds a menu by id")
	@GetMapping("/id/{id}")
	public MenuVo findById(@PathVariable Long id){
		return  menuConverter.toVo(menuService.findById(id));
	}
	@ApiOperation("Deletes a menu by id")
	@DeleteMapping("/id/{id}")
	public void deleteById(@PathVariable Long id){
		 menuService.deleteById(id);
	}

	@ApiOperation("Finds a  menu by reference")
    @GetMapping("/reference/{reference}")
	public MenuVo findByReference(@PathVariable String reference){
		return  menuConverter.toVo(menuService.findByReference(reference));
	}
	@ApiOperation("Deletes a  menu by reference")
    @DeleteMapping("/reference/{reference}")
	public int deleteByReference(@PathVariable String reference){
		return  menuService.deleteByReference(reference);
	}
	


   
    @ApiOperation("Search menu by a specific criterion")
    @PostMapping("/search")
	public List<MenuVo> findByCriteria(@RequestBody MenuVo menuVo){
       return menuConverter.toVo(menuService.findByCriteria(menuVo));
	}	
	public MenuConverter getMenuConverter(){
		return menuConverter;
	}
 
	public void setMenuConverter(MenuConverter menuConverter){
		this.menuConverter=menuConverter;
	}

	public MenuService getMenuService(){
		return menuService;
	}
	public void setMenuService( MenuService menuService){
	 	this.menuService=menuService;
	}
	

}