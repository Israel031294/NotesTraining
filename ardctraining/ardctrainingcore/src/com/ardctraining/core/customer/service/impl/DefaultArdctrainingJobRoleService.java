package com.ardctraining.core.customer.service.impl;

import com.ardctraining.core.customer.dao.ArdctrainingJobRoleDao;
import com.ardctraining.core.customer.service.ArdctrainingJobRoleService;
import com.ardctraining.core.model.JobRoleModel;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.util.ServicesUtil;

import java.util.List;
import java.util.Optional;

public class DefaultArdctrainingJobRoleService implements ArdctrainingJobRoleService {
    /*
    hay que inyectar la dependecia como el service invoca  al DAO
    se inyecta por la interface no por la implementacion
     */
    private ArdctrainingJobRoleDao ardctrainingJobRoleDao;
    @Override
    public List<JobRoleModel> findAll() {
        //siempre acceder desde debe ser desde el metodo get
        return getArdctrainingJobRoleDao().findAll();
    }

    @Override
    public JobRoleModel findByCode(final String code) {
        //servicesutil valida nulos, usa el objeto y el msj a arrojar
        //en el FACADE cacha las exepciones en services no
        ServicesUtil.validateParameterNotNull(code, "code cannot be null");
        // recuperamos el optional de jobrolemodel
        final Optional<JobRoleModel> result = getArdctrainingJobRoleDao().findByCode(code);

        if (result.isEmpty()) {
            //exepcion de hybris, string. formas es mas optimp a concatenar con +
            throw new UnknownIdentifierException(String.format("unable to find job role with code %s", code));
        }
        //el get del optional regresa el obj en si n este caso el jobrolemodel
        return result.get();
    }
    //getter y setter de los beans que vamos a inyectar
    //HAY QUE ESPECIFICAR EL BEAN DEL SERVICE EN SPRING.XML

    public ArdctrainingJobRoleDao getArdctrainingJobRoleDao() {
        return ardctrainingJobRoleDao;
    }

    public void setArdctrainingJobRoleDao(ArdctrainingJobRoleDao ardctrainingJobRoleDao) {
        this.ardctrainingJobRoleDao = ardctrainingJobRoleDao;
    }
}
