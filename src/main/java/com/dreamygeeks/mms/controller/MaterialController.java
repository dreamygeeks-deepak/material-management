package com.dreamygeeks.mms.controller;

import com.dreamygeeks.mms.model.MaterialRepository;
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
}
