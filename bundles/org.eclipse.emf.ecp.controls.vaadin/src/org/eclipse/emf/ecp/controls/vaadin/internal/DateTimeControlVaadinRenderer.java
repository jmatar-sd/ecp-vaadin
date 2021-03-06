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
package org.eclipse.emf.ecp.controls.vaadin.internal;

import org.eclipse.emf.ecp.controls.vaadin.AbstractVaadinSimpleControlRenderer;

import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.ui.Component;
import com.vaadin.ui.DateField;

/**
 * The Vaadin Renderer for a date value.
 *
 * @author Dennis Melzer
 *
 */
public class DateTimeControlVaadinRenderer extends AbstractVaadinSimpleControlRenderer {

	@Override
	public Component createControl() {
		final DateField dateField = new DateField();
		// TODO Style?
		dateField.setResolution(Resolution.MINUTE);
		return dateField;
	}

	@Override
	protected String getUnsetLabel() {
		return VaadinRendererMessages.DateTimeControlVaadinRenderer_NoDateSetClickToSetDate;
	}

}
