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
package org.eclipse.emf.ecp.view.model.vaadin;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.ui.view.ECPRendererException;
import org.eclipse.emf.ecp.view.model.internal.vaadin.ECPFVaadinViewRendererImpl;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.model.VView;

public interface ECPFVaadinViewRenderer {

	ECPFVaadinViewRenderer INSTANCE = new ECPFVaadinViewRendererImpl();

	ECPVaadinView render(EObject domainObject) throws ECPRendererException;

	ECPVaadinView render(EObject domainObject, VView viewModel) throws ECPRendererException;

	ECPVaadinView render(ViewModelContext viewModelContext) throws ECPRendererException;

}
