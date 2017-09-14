package com.dreamygeeks.mms.model;

import com.dreamygeeks.mms.model.Material;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by deepak_shingan on 9/13/2017.
 */
@Repository
public interface MaterialRepository extends PagingAndSortingRepository<Material, Long>{
    List<Material> findByName(@Param("name") String name);

}
