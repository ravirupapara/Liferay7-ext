package com.demo.portlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.demo.constants.UserPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author Ravi
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + UserPortletKeys.User,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class UserPortlet extends MVCPortlet {
	private static final Log _log = LogFactoryUtil.getLog(UserPortlet.class);
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		User user=null;
		try {
			user = UserLocalServiceUtil.getUserByEmailAddress(CompanyThreadLocal.getCompanyId(), "ravi@liferay.com");
		} catch (PortalException e) {
			_log.error("No user exist");
			
		}
		// EXT demo for the delete operation
		if(Validator.isNotNull(user)) {
			_log.info("executing render..."+user.getScreenName());
			try {
				_log.info("deleting..."+user.getScreenName());
				UserLocalServiceUtil.deleteUser(user);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		super.render(renderRequest, renderResponse);
	}
	
}