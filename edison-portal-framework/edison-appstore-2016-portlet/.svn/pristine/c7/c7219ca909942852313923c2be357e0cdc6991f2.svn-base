package org.kisti.edison.science.portlet.mainSearchApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kisti.edison.model.EdisonExpando;
import org.kisti.edison.model.EdisonFileConstants;
import org.kisti.edison.model.EdisonMessageConstants;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.EdisonFileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;

@Controller
@RequestMapping("VIEW")
public class mainSearchAppController {
	
	private static Log log = LogFactory.getLog(mainSearchAppController.class);

	@RequestMapping//default
	public String view(RenderRequest request, RenderResponse response, ModelMap model) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long companyId = themeDisplay.getCompanyId();
		
		long parentGroupId = 0;
		
		String portalYn = request.getPreferences().getValue("portalYn", "");
		
		try {
			parentGroupId = GroupLocalServiceUtil.getGroup(PortalUtil.getScopeGroupId(request)).getParentGroupId();
			List<com.liferay.portal.model.Group> parentGroupList = GroupLocalServiceUtil.getGroups(companyId, 0, true);
			
			//하위 사이트 존재 여부
			boolean isChildrenSite = false;
			if(GroupLocalServiceUtil.getGroups(companyId, PortalUtil.getScopeGroupId(request), true).size()>0){
				isChildrenSite = true;
			}
			
			
			//if(parentGroupId == 0 && isChildrenSite) {
			if(portalYn.equals("Y")){//포탈이면
				Group parentGroup = null;
				for(Group group:parentGroupList){
					if(StringUtil.toUpperCase(group.getName()).equals("GUEST")){
						parentGroup = group;
						break;
					}
				}
				List<Group> groupList = CustomUtil.getGroupIdASC(GroupLocalServiceUtil.getGroups(companyId, parentGroup.getGroupId(), true));
				model.addAttribute("groupList", groupList);
			} else { //포탈이 아닌 경우
				
				String groupName = themeDisplay.getScopeGroup().getName();
				
				if(groupName != null){
				}else{
					groupName = CustomUtil.strNull(themeDisplay.getScopeGroup().getExpandoBridge().getAttribute("siteName"));
				}
				model.addAttribute("groupName", groupName);
			}
			
			//simulationUrl Create
			if(themeDisplay.isSignedIn()){
				long simulationPlid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), "edisonbestsimulation_WAR_edisonsimulationportlet");
				PortletURL simulationUrl = PortletURLFactoryUtil.create(request,"edisonbestsimulation_WAR_edisonsimulationportlet", simulationPlid, PortletRequest.RENDER_PHASE);
				simulationUrl.setWindowState(LiferayWindowState.MAXIMIZED);
				
				model.addAttribute("simulationURL", simulationUrl);
			}
			

			//projectDownload Create
			long projectDownloadPlid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), "edisonprojectdownload_WAR_edisonproject2016portlet");
			PortletURL projectDwnURL = PortletURLFactoryUtil.create(request,"edisonprojectdownload_WAR_edisonproject2016portlet", projectDownloadPlid, PortletRequest.RENDER_PHASE);
			projectDwnURL.setWindowState(LiferayWindowState.MAXIMIZED);
			
			model.addAttribute("projectDownloadURL", projectDwnURL);
			
			
			long appStorePlid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), "edisonscienceAppstore_WAR_edisonappstoreportlet");
			PortletURL appStoreUrl = PortletURLFactoryUtil.create(request,"edisonscienceAppstore_WAR_edisonappstoreportlet", appStorePlid, PortletRequest.RENDER_PHASE);
			appStoreUrl.setWindowState(LiferayWindowState.MAXIMIZED);
			model.addAttribute("appStoreURL", appStoreUrl);
			
			long appstorePlid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), false, "edisonscienceAppstore_WAR_edisonappstoreportlet");
			
			model.addAttribute("appstorePlid", appstorePlid);
			
			// parentGroupId가 0이면 포털 0이 아니면 분야 사이트
			//if(parentGroupId == 0 && isChildrenSite) { 
			if(portalYn.equals("Y")){
				return "mainSearchApp/view";
			} else {
				return "mainSearchApp/site_view";
			}
			
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
			
			return "mainSearchApp/view";
		}
	}
	
	@ResourceMapping(value="bestSolverList")
	public void getBestSolverList(ResourceRequest request, ResourceResponse response)  throws PortalException, SystemException, MalformedURLException, IOException, SQLException{
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		long companyId = themeDisplay.getCompanyId();
		long userId = PortalUtil.getUserId(request);
		long parentGroupId = GroupLocalServiceUtil.getGroup(PortalUtil.getScopeGroupId(request)).getParentGroupId();

		List<Map<String, Object>> bestSolverList = new ArrayList<Map<String, Object>>();
		
		if(parentGroupId == 0) {
			//하위 사이트 존재 여부
			boolean isChildrenSite = false;
			if(GroupLocalServiceUtil.getGroups(companyId, PortalUtil.getScopeGroupId(request), true).size()>0){
				isChildrenSite = true;
			}
			
			if(isChildrenSite){
				List<com.liferay.portal.model.Group> parentGroupList = GroupLocalServiceUtil.getGroups(companyId, 0, true);
				Group parentGroup = null;
				for(Group group:parentGroupList){
					if(StringUtil.toUpperCase(group.getName()).equals("GUEST")){
						parentGroup = group;
						break;
					}
				}
				
				long visitGroupId = 0;
				if(themeDisplay.isSignedIn()){	// 로그인 했을 경우에만 실행
					String visitSite = CustomUtil.strNull(themeDisplay.getUser().getExpandoBridge().getAttribute(EdisonExpando.USER_VISIT_SITE).toString(),"");
					List<Group> groupListOrigin = parentGroup.getChildren(true);
					for (Group group : groupListOrigin) {
						if(group.getName().equals(visitSite)) {
							visitGroupId = group.getGroupId();	// 관심 분야의 groupId를 찾는다
						}
					}
				}
				
				if(visitGroupId > 0) {	//관심 분야의 groupId가 0보다 클경우 먼저 넣어준다
					Map<String,Object> params = new HashMap<String, Object>();
					params.put("userId", userId);
					params.put("groupId", visitGroupId);
					params.put("solverStatus", "1901004");
					params.put("recommandation_flag", "true");

//★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
//					List<Map<String, Object>> hotSearchList = SolverLocalServiceUtil.getListRecommenedSolver(params, themeDisplay.getLocale());
					List<Map<String, Object>> hotSearchList = new ArrayList();
//★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
					for(int i=0;i<hotSearchList.size();i++){
						List solverScreenList = EdisonFileUtil.getListEdisonFile(visitGroupId, "solver_icon", String.valueOf(hotSearchList.get(i).get("solverId")), EdisonFileConstants.SCIENCE_APPS);
						hotSearchList.get(i).put("solverScreenList", solverScreenList);
					}
					bestSolverList.addAll(hotSearchList);
				}
				
				List<Group> groupList = CustomUtil.getGroupIdASC(GroupLocalServiceUtil.getGroups(companyId, parentGroup.getGroupId(), true));
				
				for(Group group:groupList){
					if(group.getGroupId() == visitGroupId) {	// 관심분야를 넣은 경우 스킵해준다.
						continue;
					}
					
					Map<String,Object> params = new HashMap<String, Object>();
					params.put("userId", userId);
					params.put("groupId", group.getGroupId());
					params.put("solverStatus", "1901004");
					params.put("recommandation_flag", "true");

//★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
//					List<Map<String, Object>> hotSearchList = SolverLocalServiceUtil.getListRecommenedSolver(params, themeDisplay.getLocale());
					List<Map<String, Object>> hotSearchList = new ArrayList();
//★★★★★★★★★★★★★★★★★★★★★★★★★★★★★

					for(int i=0;i<hotSearchList.size();i++){
						List solverScreenList = EdisonFileUtil.getListEdisonFile(group.getGroupId(), "solver_icon", String.valueOf(hotSearchList.get(i).get("solverId")), EdisonFileConstants.SCIENCE_APPS);
						hotSearchList.get(i).put("solverScreenList", solverScreenList);
					}
					bestSolverList.addAll(hotSearchList);
				}
			}else{
				Map<String,Object> params = new HashMap<String, Object>();
				params.put("userId", userId);
				params.put("groupId", PortalUtil.getScopeGroupId(request));
				params.put("solverStatus", "1901004");
				params.put("recommandation_flag", "true");
				
//★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
//				List<Map<String, Object>> hotSearchList = SolverLocalServiceUtil.getListRecommenedSolver(params, themeDisplay.getLocale());
				List<Map<String, Object>> hotSearchList = new ArrayList();
//★★★★★★★★★★★★★★★★★★★★★★★★★★★★★

				
				for(int i=0;i<hotSearchList.size();i++){
					List solverScreenList = EdisonFileUtil.getListEdisonFile(PortalUtil.getScopeGroupId(request), "solver_icon", String.valueOf(hotSearchList.get(i).get("solverId")), EdisonFileConstants.SCIENCE_APPS);
					hotSearchList.get(i).put("solverScreenList", solverScreenList);
				}
				bestSolverList.addAll(hotSearchList);
			}
			
			
		} else {
			Group group = themeDisplay.getScopeGroup();
			Map<String,Object> params = new HashMap<String, Object>();
			params.put("userId", userId);
			params.put("groupId", group.getGroupId());
			params.put("solverStatus", "1901004");
			params.put("recommandation_flag", "true");

//★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
//			List<Map<String, Object>> hotSearchList = SolverLocalServiceUtil.getListRecommenedSolver(params, themeDisplay.getLocale());
			List<Map<String, Object>> hotSearchList = new ArrayList();
//★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
			
			for(int i=0;i<hotSearchList.size();i++){
				List solverScreenList = EdisonFileUtil.getListEdisonFile(group.getGroupId(), "solver_icon", String.valueOf(hotSearchList.get(i).get("solverId")), EdisonFileConstants.SCIENCE_APPS);
				hotSearchList.get(i).put("solverScreenList", solverScreenList);
			}
			bestSolverList.addAll(hotSearchList);
		}
		
		JSONObject obj = new JSONObject();
		obj.put("bestSolverList", bestSolverList);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
		
	}
}
