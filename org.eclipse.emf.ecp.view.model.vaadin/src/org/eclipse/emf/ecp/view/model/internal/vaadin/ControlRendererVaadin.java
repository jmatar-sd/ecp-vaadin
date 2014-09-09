/*******************************************************************************
 * Copyright (c) 2014 Dennis Melzer and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Dennis - initial API and implementation
 ******************************************************************************/
package org.eclipse.emf.ecp.view.model.internal.vaadin;

import org.eclipse.emf.ecp.controls.vaadin.ECPControlFactoryVaadin;
import org.eclipse.emf.ecp.edit.spi.ECPControlFactory;
import org.eclipse.emf.ecp.view.model.vaadin.RendererVaadin;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.model.VControl;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

import com.vaadin.ui.Component;

public class ControlRendererVaadin extends RendererVaadin<VControl> {

	@Override
	public Component render(VControl control, ViewModelContext viewContext) {
		BundleContext bundle = FrameworkUtil.getBundle(getClass()).getBundleContext();

		ECPControlFactory factory = bundle.getService(bundle.getServiceReference(ECPControlFactory.class));

		ECPControlFactoryVaadin createControl = factory.createControl(ECPControlFactoryVaadin.class,
				control.getDomainModelReference());
		createControl.init(viewContext, control);
		Component component = createControl.render(control);
		setCaption(control, component);
		return component;
	}
}
