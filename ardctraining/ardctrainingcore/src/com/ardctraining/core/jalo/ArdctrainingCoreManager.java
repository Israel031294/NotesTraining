/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.ardctraining.core.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import com.ardctraining.core.constants.ArdctrainingCoreConstants;
import com.ardctraining.core.setup.CoreSystemSetup;


/**
 * Do not use, please use {@link CoreSystemSetup} instead.
 * 
 */
public class ArdctrainingCoreManager extends GeneratedArdctrainingCoreManager
{
	public static final ArdctrainingCoreManager getInstance()
	{
		final ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (ArdctrainingCoreManager) em.getExtension(ArdctrainingCoreConstants.EXTENSIONNAME);
	}
}
