package ma.zs.generated.service.facade;

import java.io.IOException;
import java.util.List;
import ma.zs.generated.bean.Agenda;
import ma.zs.generated.ws.rest.provided.vo.AgendaVo;
import org.springframework.web.multipart.MultipartFile;

public interface AgendaService {

        /**

     * find all Agenda in database 
     * @return List<Agenda> , If database is empty return  null.
     */
	List<Agenda> findAll();
	   
	/**

     * find Agenda from database by reference (reference)
     * @param reference - reference of Agenda 
     * @return the founded Agenda , If no Agenda were
     *         found in database return  null.
     */
	Agenda findByReference(String reference);

    /**
     * find Agenda from database by id (id)
     * @param id - id of Agenda 
     * @return the founded  Agenda , If no Agenda were
     *         found in database return  null.
     */
	Agenda findById(Long id);
     
     /**
     * delete Agenda from database
     * @param id - id of Agenda to be deleted
     * 
     */
	void deleteById(Long id);

    /**
     * save Agenda in database
     * @param agenda - Agenda to be saved 
     * @return the saved Agenda, If the Agenda can't be saved return null.
     */
	Agenda save(Agenda agenda);

	/**
     * save list Agenda in database
     * @param agendas - list of Agenda to be saved 
     * @return the saved Agenda list
     */
	List<Agenda> save(List<Agenda> agendas);
    
     /**
     * update Agenda in database
     * @param agenda - Agenda to be updated
     * @return the updated Agenda, If the Agenda can't be updated return null.
     */
    Agenda update(Agenda agenda);
    
       /**
     * delete Agenda from database
     * @param agenda - Agenda to be deleted
     * @return 1 if Agenda deleted successfully, If the Agenda can't be deleted return negative int
     */
	int delete(Agenda agenda);


    
        /**
     * delete Agenda from database by reference (reference)
     * 
     * @param reference - reference of Agenda to be deleted
     * @return 1 if Agenda deleted successfully
     */
	int deleteByReference(String reference);

     
	/**
     * search for Agenda in by some criteria
     * @return the searhed list Agenda 
     */
	List<Agenda> findByCriteria( AgendaVo agendaVo);

	int uploadContent(MultipartFile file, String reference) throws IOException;
}