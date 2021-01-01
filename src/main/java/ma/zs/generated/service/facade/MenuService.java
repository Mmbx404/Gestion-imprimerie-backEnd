package ma.zs.generated.service.facade;

import java.util.List;
import ma.zs.generated.bean.Menu;
import ma.zs.generated.ws.rest.provided.vo.MenuVo;

public interface MenuService {

        /**

     * find all Menu in database 
     * @return List<Menu> , If database is empty return  null.
     */
	List<Menu> findAll();
	   
	/**

     * find Menu from database by reference (reference)
     * @param reference - reference of Menu 
     * @return the founded Menu , If no Menu were
     *         found in database return  null.
     */
	Menu findByReference(String reference);

    /**
     * find Menu from database by id (id)
     * @param id - id of Menu 
     * @return the founded  Menu , If no Menu were
     *         found in database return  null.
     */
	Menu findById(Long id);
     
     /**
     * delete Menu from database
     * @param id - id of Menu to be deleted
     * 
     */
	void deleteById(Long id);

    /**
     * save Menu in database
     * @param menu - Menu to be saved 
     * @return the saved Menu, If the Menu can't be saved return null.
     */
	Menu save(Menu menu);

	/**
     * save list Menu in database
     * @param menus - list of Menu to be saved 
     * @return the saved Menu list
     */
	List<Menu> save(List<Menu> menus);
    
     /**
     * update Menu in database
     * @param menu - Menu to be updated
     * @return the updated Menu, If the Menu can't be updated return null.
     */
    Menu update(Menu menu);
    
       /**
     * delete Menu from database
     * @param menu - Menu to be deleted
     * @return 1 if Menu deleted successfully, If the Menu can't be deleted return negative int
     */
	int delete(Menu menu);


    
        /**
     * delete Menu from database by reference (reference)
     * 
     * @param reference - reference of Menu to be deleted
     * @return 1 if Menu deleted successfully
     */
	int deleteByReference(String reference);

     
	/**
     * search for Menu in by some criteria
     * @return the searhed list Menu 
     */
	List<Menu> findByCriteria( MenuVo menuVo);
}