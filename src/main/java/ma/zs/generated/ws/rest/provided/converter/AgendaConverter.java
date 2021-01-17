package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

  
import ma.zs.generated.bean.Agenda; 
import ma.zs.generated.ws.rest.provided.vo.AgendaVo;

@Component 
public class AgendaConverter extends AbstractConverter<Agenda,AgendaVo>{ 
	

	public  AgendaConverter(){
		init(true);
	}

	@Override 
 	public Agenda toItem(AgendaVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	Agenda item = new Agenda();
			 if(StringUtil.isNotEmpty(vo.getTypePapier()))
                  item.setTypePapier(vo.getTypePapier());
			 if(StringUtil.isNotEmpty(vo.getPrixUnitaire()))
                  item.setPrixUnitaire(NumberUtil.toBigDecimal(vo.getPrixUnitaire()));
			 if(StringUtil.isNotEmpty(vo.getFileOuNon()))
                  item.setFileOuNon(NumberUtil.toBoolean(vo.getFileOuNon()));
			 if(StringUtil.isNotEmpty(vo.getQuantiteStock()))
                  item.setQuantiteStock(NumberUtil.toLong(vo.getQuantiteStock()));
			 if(StringUtil.isNotEmpty(vo.getReference()))
                  item.setReference(vo.getReference());
			 if(StringUtil.isNotEmpty(vo.getHauteur()))
                  item.setHauteur(NumberUtil.toLong(vo.getHauteur()));
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));
			 if(StringUtil.isNotEmpty(vo.getLargeur()))
                  item.setLargeur(NumberUtil.toLong(vo.getLargeur()));
			 item.setContent(vo.getContent());
		return item;
 		}
 	}

 	 @Override 
 	public AgendaVo toVo(Agenda item) {
 		if (item == null) {
    		return null;
      	} else {
			AgendaVo vo = new AgendaVo();

			if(StringUtil.isNotEmpty(item.getTypePapier()))
				vo.setTypePapier(item.getTypePapier());
			
			 if(item.getPrixUnitaire()!=null)
				vo.setPrixUnitaire(NumberUtil.toString(item.getPrixUnitaire()));
			if(item.isFileOuNon()!=null)
				vo.setFileOuNon(NumberUtil.toString(item.isFileOuNon()));
			 if(item.getQuantiteStock()!=null)
				vo.setQuantiteStock(NumberUtil.toString(item.getQuantiteStock()));
			if(StringUtil.isNotEmpty(item.getReference()))
				vo.setReference(item.getReference());
			
			 if(item.getHauteur()!=null)
				vo.setHauteur(NumberUtil.toString(item.getHauteur()));
			 if(item.getId()!=null)
				vo.setId(NumberUtil.toString(item.getId()));
			 if(item.getLargeur()!=null)
				vo.setLargeur(NumberUtil.toString(item.getLargeur()));
			 vo.setContent(item.getContent());
 			return vo;
 
 		}
 	}
	public void init(Boolean value) { 
	}


	

	
	
}