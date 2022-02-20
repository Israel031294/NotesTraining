package com.ardctraining.core.customer.dao.impl;

import com.ardctraining.core.customer.dao.ArdctrainingJobRoleDao;
import com.ardctraining.core.model.JobRoleModel;
import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.apache.commons.collections4.CollectionUtils;

//start with Default+interfaceName and implemente the interface
//defaulgenericdao para hacer queris
public class DefaultArdctrainingJobRoleDao extends DefaultGenericDao<JobRoleModel> implements ArdctrainingJobRoleDao {

//
    public DefaultArdctrainingJobRoleDao() {
    //    eesoecifica a la clase que los reultados seran de ese tipo
        super(JobRoleModel._TYPECODE);
    }

    @Override
    public List<JobRoleModel> findAll() {
        //metodo de la clase defaultgenericdao
        return this.find();
    }

    @Override
    public Optional<JobRoleModel> findByCode(final String code) {
        //opara especificar los parameytros usamos String/obkect al metodo find, cuando solo se manda un elem, podemos usar collections.singleton.map para ahorrar
        //hacer el metodo put etc, key sera el nombre del attr y value el valor, como armar un query
        //tambien hay singletonlist,


        final Map<String,Object> params = Collections.singletonMap(JobRoleModel.CODE,code);
        //esto invoca la busqueda por flexiblesearchqy=uery
        final List<JobRoleModel> result = this.find(params);
        //para validar liistas vacias mejor utilizar la libreria apache
        //buscar  stringutilities, objectutilities, BUSCAR MAS
        if (CollectionUtils.isNotEmpty(result)){
            //regresar el primer resultadonde la busqueda, que debe ser unico por el unique
            return Optional.of(result.get(0));
        }

        return Optional.empty();
    }
    //NO SE UDAN ANOTACIONES, HAY QUE IR AL SPRING.XML
    //CUADRO DE BUSQUUEDA SHIFT 2 VCS PARA BUSCRA ARCHIVOS X NOMBRE ardctrainingcore.xml
}
