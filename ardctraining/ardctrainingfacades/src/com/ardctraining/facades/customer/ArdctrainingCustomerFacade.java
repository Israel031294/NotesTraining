package com.ardctraining.facades.customer;

import com.ardctraining.facades.customer.data.JobRoleData;
import de.hybris.platform.commercefacades.customer.CustomerFacade;

import java.util.List;


//NOTA: primero se crea el DTO O POJO EN ardctrainingfacades-beans.xml
//EXTENDER LA FUNCIONALIDAD DE UN BEAN DEL ESTANDAR, conj esto aseguramos que la interfaZ va heredar los metodos
public interface ArdctrainingCustomerFacade extends CustomerFacade {
    /*facade convierte los models en DTO para llevarlos al controler y de ahi a la vista*/
    /**
     * gets all job roles
     * @return
     */
    List<JobRoleData> getJobRoles();
}
