package com.dreamygeeks.mms.model;

import com.dreamygeeks.mms.model.Material;
import com.dreamygeeks.mms.model.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

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
