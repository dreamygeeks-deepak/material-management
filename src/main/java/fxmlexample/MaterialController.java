package fxmlexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by deepak_shingan on 9/14/2017.
 */
@Component
public class MaterialController {

    @Autowired
    MaterialRepository materialRepository;


    public MaterialController() {
        System.out.println("Inside material controller");
    }

    public void save(Material material){
        System.out.println("Saving");
        materialRepository.save(material);
        System.out.println("Saved");

    }
}
