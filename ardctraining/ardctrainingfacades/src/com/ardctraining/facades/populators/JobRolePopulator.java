package com.ardctraining.facades.populators;

import com.ardctraining.core.model.JobRoleModel;
import com.ardctraining.facades.customer.data.JobRoleData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;


//implementar la interface del estandar que se llama populator <source, target>
public class JobRolePopulator implements Populator<JobRoleModel, JobRoleData> {


    //puede llevarc logica en este caso no , posteriormente como toda clase hay que hacer su bean
    //en el archivo facades-spring.xml
    public void populate(final JobRoleModel source, final JobRoleData target) throws ConversionException {
        target.setCode(source.getCode());
        target.setName(source.getDescription());
    }
}