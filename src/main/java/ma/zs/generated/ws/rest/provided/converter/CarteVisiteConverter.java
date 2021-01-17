package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

  
import ma.zs.generated.bean.CarteVisite; 
import ma.zs.generated.ws.rest.provided.vo.CarteVisiteVo;

@Component 
public class CarteVisiteConverter extends AbstractConverter<CarteVisite,CarteVisiteVo>{ 
	

	public  CarteVisiteConverter(){
		init(true);
	}

	@Override 
 	public CarteVisite toItem(CarteVisiteVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	CarteVisite item = new CarteVisite();
			 if(StringUtil.isNotEmpty(vo.getPrixUnitaire()))
                  item.setPrixUnitaire(NumberUtil.toBigDecimal(vo.getPrixUnitaire()));
			 if(StringUtil.isNotEmpty(vo.getTypePapier()))
                  item.setTypePapier(vo.getTypePapier());
			 if(StringUtil.isNotEmpty(vo.getPlastifier()))
                  item.setPlastifier(NumberUtil.toBoolean(vo.getPlastifier()));
			 if(StringUtil.isNotEmpty(vo.getQuantiteStock()))
                  item.setQuantiteStock(NumberUtil.toLong(vo.getQuantiteStock()));
			 if(StringUtil.isNotEmpty(vo.getHauteur()))
                  item.setHauteur(NumberUtil.toLong(vo.getHauteur()));
			 if(StringUtil.isNotEmpty(vo.getReference()))
                  item.setReference(vo.getReference());
			 if(StringUtil.isNotEmpty(vo.getLargeur()))
                  item.setLargeur(NumberUtil.toLong(vo.getLargeur()));
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));
			 item.setContent(vo.getContent());


		return item;
 		}
 	}

 	 @Override 
 	public CarteVisiteVo toVo(CarteVisite item) {
 		if (item == null) {
    		return null;
      	} else {
			CarteVisiteVo vo = new CarteVisiteVo();

			 if(item.getPrixUnitaire()!=null)
				vo.setPrixUnitaire(NumberUtil.toString(item.getPrixUnitaire()));
			if(StringUtil.isNotEmpty(item.getTypePapier()))
				vo.setTypePapier(item.getTypePapier());
			
			if(item.isPlastifier()!=null)
				vo.setPlastifier(NumberUtil.toString(item.isPlastifier()));
			 if(item.getQuantiteStock()!=null)
				vo.setQuantiteStock(NumberUtil.toString(item.getQuantiteStock()));
			 if(item.getHauteur()!=null)
				vo.setHauteur(NumberUtil.toString(item.getHauteur()));
			if(StringUtil.isNotEmpty(item.getReference()))
				vo.setReference(item.getReference());
			
			 if(item.getLargeur()!=null)
				vo.setLargeur(NumberUtil.toString(item.getLargeur()));
			 if(item.getId()!=null)
				vo.setId(NumberUtil.toString(item.getId()));
			 vo.setContent(item.getContent());
 			return vo;
 
 		}
 	}
	public void init(Boolean value) { 
	}


	

	
	
}