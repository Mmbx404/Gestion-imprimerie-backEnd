package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

  
import ma.zs.generated.bean.Menu; 
import ma.zs.generated.ws.rest.provided.vo.MenuVo;

@Component 
public class MenuConverter extends AbstractConverter<Menu,MenuVo>{ 
	

	public  MenuConverter(){
		init(true);
	}

	@Override 
 	public Menu toItem(MenuVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	Menu item = new Menu();
			 if(StringUtil.isNotEmpty(vo.getQuantiteStock()))
                  item.setQuantiteStock(NumberUtil.toLong(vo.getQuantiteStock()));
			 if(StringUtil.isNotEmpty(vo.getTypePapier()))
                  item.setTypePapier(vo.getTypePapier());
			 if(StringUtil.isNotEmpty(vo.getHauteur()))
                  item.setHauteur(NumberUtil.toLong(vo.getHauteur()));
			 if(StringUtil.isNotEmpty(vo.getLargeur()))
                  item.setLargeur(NumberUtil.toLong(vo.getLargeur()));
			 if(StringUtil.isNotEmpty(vo.getReference()))
                  item.setReference(vo.getReference());
			 if(StringUtil.isNotEmpty(vo.getPrixUnitaire()))
                  item.setPrixUnitaire(NumberUtil.toBigDecimal(vo.getPrixUnitaire()));
			 if(StringUtil.isNotEmpty(vo.getNombrePages()))
                  item.setNombrePages(NumberUtil.toLong(vo.getNombrePages()));


		return item;
 		}
 	}

 	 @Override 
 	public MenuVo toVo(Menu item) {
 		if (item == null) {
    		return null;
      	} else {
			MenuVo vo = new MenuVo();

			 if(item.getQuantiteStock()!=null)
				vo.setQuantiteStock(NumberUtil.toString(item.getQuantiteStock()));
			if(StringUtil.isNotEmpty(item.getTypePapier()))
				vo.setTypePapier(item.getTypePapier());
			
			 if(item.getHauteur()!=null)
				vo.setHauteur(NumberUtil.toString(item.getHauteur()));
			 if(item.getLargeur()!=null)
				vo.setLargeur(NumberUtil.toString(item.getLargeur()));
			if(StringUtil.isNotEmpty(item.getReference()))
				vo.setReference(item.getReference());
			
			 if(item.getPrixUnitaire()!=null)
				vo.setPrixUnitaire(NumberUtil.toString(item.getPrixUnitaire()));
			 if(item.getNombrePages()!=null)
				vo.setNombrePages(NumberUtil.toString(item.getNombrePages()));

 			return vo;
 
 		}
 	}
	public void init(Boolean value) { 
	}


	

	
	
}