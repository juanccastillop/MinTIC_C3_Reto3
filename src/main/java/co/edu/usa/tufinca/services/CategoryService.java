package co.edu.usa.tufinca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.tufinca.entities.Category;
import co.edu.usa.tufinca.repository.CategoryRepository;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }
    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }

    public Category save(Category cat){
        
        if(cat.getId()==null){
            return categoryRepository.save(cat);
        }
        else{
            Optional<Category> cataux=categoryRepository.getCategory(cat.getId());
            if(cataux.isEmpty()){
                return categoryRepository.save(cat);
            }
            else{
                return cat;
            }
        }

    }
}
