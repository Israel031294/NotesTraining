package com.ardctraining.core.customer.service;

import com.ardctraining.core.model.JobRoleModel;

import java.util.List;


public interface ArdctrainingJobRoleService {

    /*
    SERVICE: valida parametros y es quien tira las exepciones
    copiar los metodos del DAO
     */
    /*
    return a list, a generic jobRole model
     */
    List<JobRoleModel> findAll();
    /*
    en vez de regresar el optional vamos a regressar el obj en si
     */
    JobRoleModel findByCode(String code);
}
