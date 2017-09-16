package com.dreamygeeks.mms.material;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created by deepak_shingan on 9/13/2017.
 */
@Repository
public interface MaterialRepository extends PagingAndSortingRepository<Material, Long>{

    String FIND_MATERIAL_NAMES = "SELECT id, name FROM Material";

    List<Material> findByName(@Param("name") String name);

    @Query(value = FIND_MATERIAL_NAMES, nativeQuery = true)
    public Set<Object[]> findMaterialNames();

}
