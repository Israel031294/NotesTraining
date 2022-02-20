package com.ardctraining.facades.customer.impl;

import com.ardctraining.core.customer.service.ArdctrainingJobRoleService;
import com.ardctraining.core.model.JobRoleModel;
import com.ardctraining.facades.customer.ArdctrainingCustomerFacade;
import com.ardctraining.facades.customer.data.JobRoleData;
import de.hybris.platform.commercefacades.customer.impl.DefaultCustomerFacade;
import de.hybris.platform.commercefacades.user.data.RegisterData;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import java.util.List;
import org.apache.log4j.Logger;

import java.util.List;
/*vamos a extrender del bean ya especifiacdo e implementar la interfaz
 implementar el nuevo metodo*/
public class DefaultArdctrainingCustomerFacade extends DefaultCustomerFacade implements ArdctrainingCustomerFacade {

//INYECTAR LA DEPENDENCIA, el service inyecta DAO Y el facade inyecta services
    private ArdctrainingJobRoleService ardctrainingJobRoleService;
    //se inyecta el converter por la interfaz despues de definirlo en el facades-spring.xml
    //el nombre debe ser el ALIAS del bean del converter (jobRoleConverter)
    private Converter<JobRoleModel, JobRoleData> jobRoleConverter;

    private static final Logger LOG = Logger.getLogger(DefaultArdctrainingCustomerFacade.class);

    @Override
    public List<JobRoleData> getJobRoles() {
        //invocar metodo que regresa todos los jobRoleModels desde el service
        final List<JobRoleModel> jobRoles = getArdctrainingJobRoleService().findAll();
        //no se regresan models, se necesitan datas de los pojos
        //crear populator para poblar los datac on la info de los models en la carpeta populator
        //crear un converter que invoque el populator para hacer la conversion

        //convertall, convierte una lista de la clase source y regresa una lista de la clase target

        return getJobRoleConverter().convertAll(jobRoles);
    }

    @Override
    protected void setCommonPropertiesForRegister(final RegisterData registerData, final CustomerModel customerModel) {
        super.setCommonPropertiesForRegister(registerData, customerModel);

        customerModel.setCompany(registerData.getCompany());

        try {
           final JobRoleModel jobRole = getArdctrainingJobRoleService().findByCode(registerData.getJobRole());

            customerModel.setJobRole(jobRole);
        } catch(final UnknownIdentifierException ex) {
            LOG.error(ex.getMessage(), ex);
        }
    }

    public ArdctrainingJobRoleService getArdctrainingJobRoleService() {
        return ardctrainingJobRoleService;
    }

    public void setArdctrainingJobRoleService(ArdctrainingJobRoleService ardctrainingJobRoleService) {
        this.ardctrainingJobRoleService = ardctrainingJobRoleService;
    }

    public Converter<JobRoleModel, JobRoleData> getJobRoleConverter() {
        return jobRoleConverter;
    }

    public void setJobRoleConverter(Converter<JobRoleModel, JobRoleData> jobRoleConverter) {
        this.jobRoleConverter = jobRoleConverter;
    }
}
