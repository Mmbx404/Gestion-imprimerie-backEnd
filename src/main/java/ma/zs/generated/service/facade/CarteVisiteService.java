package ma.zs.generated.service.facade;

import java.util.List;
import ma.zs.generated.bean.CarteVisite;
import ma.zs.generated.ws.rest.provided.vo.CarteVisiteVo;

public interface CarteVisiteService {

        /**

     * find all CarteVisite in database 
     * @return List<CarteVisite> , If database is empty return  null.
     */
	List<CarteVisite> findAll();
	   
	/**

     * find CarteVisite from database by reference (reference)
     * @param reference - reference of CarteVisite 
     * @return the founded CarteVisite , If no CarteVisite were
     *         found in database return  null.
     */
	CarteVisite findByReference(String reference);

    /**
     * find CarteVisite from database by id (id)
     * @param id - id of CarteVisite 
     * @return the founded  CarteVisite , If no CarteVisite were
     *         found in database return  null.
     */
	CarteVisite findById(Long id);
     
     /**
     * delete CarteVisite from database
     * @param id - id of CarteVisite to be deleted
     * 
     */
	void deleteById(Long id);

    /**
     * save CarteVisite in database
     * @param carteVisite - CarteVisite to be saved 
     * @return the saved CarteVisite, If the CarteVisite can't be saved return null.
     */
	CarteVisite save(CarteVisite carteVisite);

	/**
     * save list CarteVisite in database
     * @param carteVisites - list of CarteVisite to be saved 
     * @return the saved CarteVisite list
     */
	List<CarteVisite> save(List<CarteVisite> carteVisites);
    
     /**
     * update CarteVisite in database
     * @param carteVisite - CarteVisite to be updated
     * @return the updated CarteVisite, If the CarteVisite can't be updated return null.
     */
    CarteVisite update(CarteVisite carteVisite);
    
       /**
     * delete CarteVisite from database
     * @param carteVisite - CarteVisite to be deleted
     * @return 1 if CarteVisite deleted successfully, If the CarteVisite can't be deleted return negative int
     */
	int delete(CarteVisite carteVisite);


    
        /**
     * delete CarteVisite from database by reference (reference)
     * 
     * @param reference - reference of CarteVisite to be deleted
     * @return 1 if CarteVisite deleted successfully
     */
	int deleteByReference(String reference);

     
	/**
     * search for CarteVisite in by some criteria
     * @return the searhed list CarteVisite 
     */
	List<CarteVisite> findByCriteria( CarteVisiteVo carteVisiteVo);
}