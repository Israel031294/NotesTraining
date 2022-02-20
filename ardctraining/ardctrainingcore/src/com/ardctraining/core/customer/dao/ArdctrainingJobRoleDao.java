package com.ardctraining.core.customer.dao;

import com.ardctraining.core.model.JobRoleModel;

import java.util.List;
import java.util.Optional;

public interface ArdctrainingJobRoleDao {

    /*
    return a list, a generic jobRole model
     */
    List<JobRoleModel> findAll();
    /*
    optional for validating nulls not sing ==
     */
    Optional <JobRoleModel> findByCode(String code);


}

