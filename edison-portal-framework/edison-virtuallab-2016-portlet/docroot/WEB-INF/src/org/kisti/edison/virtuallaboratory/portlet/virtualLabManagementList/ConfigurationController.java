package org.kisti.edison.virtuallaboratory.portlet.virtualLabManagementList;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;

public class ConfigurationController extends DefaultConfigurationAction {

	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)	throws Exception {
		super.processAction(portletConfig, actionRequest, actionResponse);
//		PortletPreferences prefs = actionRequest.getPreferences();
//
//		prefs.setValue("preference code", actionRequest.getParameter("preference code"));
//		prefs.store();
	}
	
}
