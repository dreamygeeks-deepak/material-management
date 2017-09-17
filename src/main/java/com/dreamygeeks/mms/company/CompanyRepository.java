package com.dreamygeeks.mms.company;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by deepak_shingan on 9/17/2017.
 */
@Repository
public interface CompanyRepository extends PagingAndSortingRepository<Company, Long> {
    List<Company> findAllByOrderByIdAsc();
}
