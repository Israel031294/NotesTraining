/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.ardctraining.fulfilmentprocess.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import com.ardctraining.fulfilmentprocess.constants.ArdctrainingFulfilmentProcessConstants;

public class ArdctrainingFulfilmentProcessManager extends GeneratedArdctrainingFulfilmentProcessManager
{
	public static final ArdctrainingFulfilmentProcessManager getInstance()
	{
		ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (ArdctrainingFulfilmentProcessManager) em.getExtension(ArdctrainingFulfilmentProcessConstants.EXTENSIONNAME);
	}
	
}
