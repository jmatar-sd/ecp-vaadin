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
package org.eclipse.emf.ecp.view.core.vaadin;

import org.eclipse.emf.ecp.view.core.vaadin.internal.VaadinRendererFactoryImpl;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.model.VElement;

import com.vaadin.ui.Component;

public interface VaadinRendererFactory {

	VaadinRendererFactory INSTANCE = new VaadinRendererFactoryImpl();

	<T extends VElement> Component render(T renderable, final ViewModelContext viewContext);

	<T extends VElement> AbstractVaadinRenderer<VElement> getVaadinComponentRenderer(T renderable);
}