package ma.zs.generated.service.facade;

import java.util.List;
import ma.zs.generated.bean.Flyer;
import ma.zs.generated.ws.rest.provided.vo.FlyerVo;

public interface FlyerService {

        /**

     * find all Flyer in database 
     * @return List<Flyer> , If database is empty return  null.
     */
	List<Flyer> findAll();
	   
	/**

     * find Flyer from database by reference (reference)
     * @param reference - reference of Flyer 
     * @return the founded Flyer , If no Flyer were
     *         found in database return  null.
     */
	Flyer findByReference(String reference);

    /**
     * find Flyer from database by id (id)
     * @param id - id of Flyer 
     * @return the founded  Flyer , If no Flyer were
     *         found in database return  null.
     */
	Flyer findById(Long id);
     
     /**
     * delete Flyer from database
     * @param id - id of Flyer to be deleted
     * 
     */
	void deleteById(Long id);

    /**
     * save Flyer in database
     * @param flyer - Flyer to be saved 
     * @return the saved Flyer, If the Flyer can't be saved return null.
     */
	Flyer save(Flyer flyer);

	/**
     * save list Flyer in database
     * @param flyers - list of Flyer to be saved 
     * @return the saved Flyer list
     */
	List<Flyer> save(List<Flyer> flyers);
    
     /**
     * update Flyer in database
     * @param flyer - Flyer to be updated
     * @return the updated Flyer, If the Flyer can't be updated return null.
     */
    Flyer update(Flyer flyer);
    
       /**
     * delete Flyer from database
     * @param flyer - Flyer to be deleted
     * @return 1 if Flyer deleted successfully, If the Flyer can't be deleted return negative int
     */
	int delete(Flyer flyer);


    
        /**
     * delete Flyer from database by reference (reference)
     * 
     * @param reference - reference of Flyer to be deleted
     * @return 1 if Flyer deleted successfully
     */
	int deleteByReference(String reference);

     
	/**
     * search for Flyer in by some criteria
     * @return the searhed list Flyer 
     */
	List<Flyer> findByCriteria( FlyerVo flyerVo);
}