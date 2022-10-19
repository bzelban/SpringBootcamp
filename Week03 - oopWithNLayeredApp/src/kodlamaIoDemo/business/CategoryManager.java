package kodlamaIoDemo.business;

import java.util.ArrayList;
import java.util.List;

import kodlamaIoDemo.dataAccess.BasicDao;
import kodlamaIoDemo.entities.Category;
import kodlamaIoDemo.logging.Logger;

public class CategoryManager {

    private BasicDao basicDao;
    private List<Logger> loggers;

    public CategoryManager(BasicDao basicDao, List<Logger> loggers) {
        this.basicDao = basicDao;
        this.loggers = loggers;
    }

    List<Category> categorieList = new ArrayList<>();
    public void add(Category category) throws Exception {

        for (Category category1 : categorieList){
            if (category1.getCategoryName().equals(category.getCategoryName())){
                throw new Exception("cannot repeat the same category");
            }
        }
        categorieList.add(category);
        basicDao.addCategory(category);

        for (Logger logger : loggers){
            logger.log(category.getCategoryName());
        }

    }

}