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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.ui.view.ECPRendererException;
import org.eclipse.emf.ecp.view.model.vaadin.ECPFVaadinViewRenderer;
import org.eclipse.emf.ecp.view.model.vaadin.ECPVaadinView;
import org.eclipse.emf.ecp.view.model.vaadin.VaadinRendererFactory;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContextFactory;
import org.eclipse.emf.ecp.view.spi.model.VView;
import org.eclipse.emf.ecp.view.spi.provider.ViewProviderHelper;

import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class ECPFVaadinViewRendererImpl implements ECPFVaadinViewRenderer {

	@Override
	public ECPVaadinView render(EObject domainObject) throws ECPRendererException {
		return render(domainObject, ViewProviderHelper.getView(domainObject));
	}

	@Override
	public ECPVaadinView render(EObject domainObject, VView viewModel) throws ECPRendererException {
		final ViewModelContext viewContext = ViewModelContextFactory.INSTANCE.createViewModelContext(viewModel,
				domainObject);
		return render(viewContext);
	}

	@Override
	public ECPVaadinView render(ViewModelContext viewModelContext) throws ECPRendererException {
		Component resultSet = VaadinRendererFactory.INSTANCE.render(viewModelContext.getViewModel(), viewModelContext);
		if (resultSet == null) {
			Label label = new Label();
			label.setCaption("Rendering went wrong!");
			VerticalLayout verticalLayout = new VerticalLayout(new com.vaadin.ui.Label());
			return new ECPVaadinViewImpl(verticalLayout, viewModelContext);
		}
		return new ECPVaadinViewImpl(resultSet, viewModelContext);
	}

}
