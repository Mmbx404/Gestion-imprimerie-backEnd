package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

  
import ma.zs.generated.bean.Flyer; 
import ma.zs.generated.ws.rest.provided.vo.FlyerVo;

@Component 
public class FlyerConverter extends AbstractConverter<Flyer,FlyerVo>{ 
	

	public  FlyerConverter(){
		init(true);
	}

	@Override 
 	public Flyer toItem(FlyerVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	Flyer item = new Flyer();
			 if(StringUtil.isNotEmpty(vo.getQuantiteStock()))
                  item.setQuantiteStock(NumberUtil.toLong(vo.getQuantiteStock()));
			 if(StringUtil.isNotEmpty(vo.getLargeur()))
                  item.setLargeur(NumberUtil.toLong(vo.getLargeur()));
			 if(StringUtil.isNotEmpty(vo.getReference()))
                  item.setReference(vo.getReference());
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));
			 if(StringUtil.isNotEmpty(vo.getTypePapier()))
                  item.setTypePapier(vo.getTypePapier());
			 if(StringUtil.isNotEmpty(vo.getPrixUnitaire()))
                  item.setPrixUnitaire(NumberUtil.toBigDecimal(vo.getPrixUnitaire()));
			 if(StringUtil.isNotEmpty(vo.getHauteur()))
                  item.setHauteur(NumberUtil.toLong(vo.getHauteur()));


		return item;
 		}
 	}

 	 @Override 
 	public FlyerVo toVo(Flyer item) {
 		if (item == null) {
    		return null;
      	} else {
			FlyerVo vo = new FlyerVo();

			 if(item.getQuantiteStock()!=null)
				vo.setQuantiteStock(NumberUtil.toString(item.getQuantiteStock()));
			 if(item.getLargeur()!=null)
				vo.setLargeur(NumberUtil.toString(item.getLargeur()));
			if(StringUtil.isNotEmpty(item.getReference()))
				vo.setReference(item.getReference());
			
			 if(item.getId()!=null)
				vo.setId(NumberUtil.toString(item.getId()));
			if(StringUtil.isNotEmpty(item.getTypePapier()))
				vo.setTypePapier(item.getTypePapier());
			
			 if(item.getPrixUnitaire()!=null)
				vo.setPrixUnitaire(NumberUtil.toString(item.getPrixUnitaire()));
			 if(item.getHauteur()!=null)
				vo.setHauteur(NumberUtil.toString(item.getHauteur()));

 			return vo;
 
 		}
 	}
	public void init(Boolean value) { 
	}


	

	
	
}