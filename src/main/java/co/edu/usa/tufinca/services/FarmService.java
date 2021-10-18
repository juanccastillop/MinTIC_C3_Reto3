package co.edu.usa.tufinca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.tufinca.entities.Farm;
import co.edu.usa.tufinca.repository.FarmRepository;

@Service
public class FarmService {
    
    @Autowired
    private FarmRepository farmRepository;

    public List<Farm> getAll(){
        return farmRepository.getAll();
    }

    public Optional<Farm> getFarm(int id){
        return farmRepository.getFarm(id);
    }

    public Farm save(Farm f){
        
        if(f.getId()==null){
            return farmRepository.save(f);
        }
        else{
            Optional<Farm> farmaux=farmRepository.getFarm(f.getId());
            if(farmaux.isEmpty()){
                return farmRepository.save(f);
            }
            else{
                return f;
            }
        }

    }
}
