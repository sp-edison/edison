package org.kisti.edison.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kisti.edison.model.EdisonExpando;
import org.kisti.edison.model.EdisonRoleConstants;
import org.kisti.edison.model.IcebreakerVcToken;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.EdisonUserUtil;
import org.kisti.edison.util.RequestUtil;
import org.kisti.edison.util.TokenProviderUtil;
import org.kisti.edison.util.VCRegisterUtil;
import org.kisti.edison.wfapi.custom.MyFileIcebreakerUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.AuthTokenUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;

@Controller
@RequestMapping("VIEW")
public class WorkflowPortlet{
	
	private static Log log = LogFactory.getLog(WorkflowPortlet.class);
	
  @RequestMapping
  public String view(RenderRequest request, RenderResponse response, ModelMap model)
      throws SystemException, IOException, PortalException, SQLException, ParseException{
    log.debug("view rendering");
    
//    ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
//    long groupId = PortalUtil.getScopeGroupId(request);
//    User user = themeDisplay.getUser();
//    log.info("groupId " + groupId);
//    
//    String icebreakerUrl = (String) GroupLocalServiceUtil.getGroup(groupId).getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL);
//    IcebreakerVcToken vcToken = SimulationLocalServiceUtil.getOrCreateToken(groupId, user);
//    
//    log.info("icebreakerUrl " + icebreakerUrl);
//    log.info("token " + vcToken.getVcToken());
    return "workflow/view";
  }
  
  @ResourceMapping(value="getEditorPortlet")
  public void getEditorPortletUrl(ResourceRequest request, ResourceResponse response) throws IOException{
    ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
    log.info(request.getParameter("portletId"));
    String portletId = GetterUtil.getString(request.getParameter("portletId"));
    log.info(portletId);
    String portletURL = PortletURLFactoryUtil
        .create(request, portletId, themeDisplay.getPlid(), PortletRequest.RENDER_PHASE)
        .toString();
    
    JSONObject obj = JSONFactoryUtil.createJSONObject();
    obj.put("portletURL", portletURL);
    response.setContentType("application/json; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.write(obj.toString());
  }
  
  @ResourceMapping(value="getAuthToken")
  public void getAuthToken(ResourceRequest request, ResourceResponse response) throws IOException{
    ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
    String portletId = GetterUtil.getString(request.getParameter("portletId"));
    String authToken = AuthTokenUtil.getToken(PortalUtil.getHttpServletRequest(request), themeDisplay.getPlid(), portletId);
    
    JSONObject obj = JSONFactoryUtil.createJSONObject();
    obj.put("authToken", authToken);
    obj.put("plid", themeDisplay.getPlid());
    response.setContentType("application/json; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.write(obj.toString());
  }
	
  
  @ResourceMapping(value="getSiteGroupId")
  public void getSiteGroupId(ResourceRequest request, ResourceResponse response) throws IOException, PortalException, SystemException{
    long groupId = PortalUtil.getScopeGroupId(request);
    JSONObject obj = JSONFactoryUtil.createJSONObject();
    obj.put("groupId", groupId);
    response.setContentType("application/json; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.write(obj.toString());
  }
  
  @SuppressWarnings("unchecked")
  @ResourceMapping(value="getIcebreakerAccessToken")
  public void getIcebreakerAccessToken(ResourceRequest request, ResourceResponse response) throws IOException, NumberFormatException, PortalException, SystemException, ParseException{
    Map<String, Object> param = RequestUtil.getParameterMap(request);
    
    long groupId = Long.parseLong(CustomUtil.strNull(param.get("groupId"), String.valueOf(PortalUtil.getScopeGroupId(request))));
    IcebreakerVcToken icebreakerVcToken = new IcebreakerVcToken();
    
    Group thisGroup = GroupLocalServiceUtil.getGroup(groupId);    
    String userScreenName = "";
    String userPassword = "";
    
    ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
    User user = themeDisplay.getUser();
    String universityField = (String)user.getExpandoBridge().getAttribute(EdisonExpando.USER_UNIVERSITY);
    String virtualLabId = (String)user.getExpandoBridge().getAttribute(EdisonExpando.USER_LAB_ID);
    String classId = (String)user.getExpandoBridge().getAttribute(EdisonExpando.USER_CLASS_ID);
    String majorField = (String)user.getExpandoBridge().getAttribute(EdisonExpando.USER_MAJOR);
    
    if(thisGroup.getParentGroupId() == 0){ //포탈
      String visitSite = themeDisplay.getUser().getExpandoBridge().getAttribute(EdisonExpando.USER_VISIT_SITE).toString();
      List<Group> groupList = GroupLocalServiceUtil.getGroups(themeDisplay.getCompanyId(), thisGroup.getGroupId(), true);//하위 그룹 리스트
      
      for(Group group : groupList){
        if(visitSite.equals(group.getName())){
          groupId = group.getGroupId();
          thisGroup = GroupLocalServiceUtil.getGroup(groupId);
          break;
        }
      }
    }
    
    if(EdisonUserUtil.isRegularRole(user, EdisonRoleConstants.ADMINISTRATOR) || EdisonUserUtil.isSiteRole(user, groupId, EdisonRoleConstants.SITE_ADMINISTRATOR)){
      userScreenName = (String)thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_ADMIN_ID);
      userPassword = (String)thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_ADMIN_PWD);
    }else{
      userScreenName = String.valueOf(user.getScreenName());
      userPassword = user.getPassword();
    }
    
    if(VCRegisterUtil.isVcInfo(groupId, userScreenName) == 200){  
      if(user.getExpandoBridge().hasAttribute(EdisonExpando.USER_VC_TOKEN + String.valueOf(groupId))){
        
        icebreakerVcToken.setVcToken(CustomUtil.strNull(user.getExpandoBridge().getAttribute(EdisonExpando.USER_VC_TOKEN + String.valueOf(groupId))));        
        icebreakerVcToken.setVcTokenExpired(CustomUtil.strNull(user.getExpandoBridge().getAttribute(EdisonExpando.USER_VC_TOKEN_EXPIRED + String.valueOf(groupId)), "0"));
  
        if(Integer.parseInt(icebreakerVcToken.getVcTokenExpired()) <= Integer.parseInt(CustomUtil.dateToStringFormat(new Date(), "yyyyMMdd"))){
          //시간이 지난 토큰인 경우 새로운 토큰 발행 및 커스텀 필드 저장       
          icebreakerVcToken = TokenProviderUtil.getVcToken(groupId, userScreenName, userPassword);
    
          //Icebreaker에 회원정보는 있으나 로그인 되지 않는 경우 비밀번호 변경으로 인한것으로 판단하여 비밀번호 update후에 다시 로그인하여 토큰을 요청 합니다. 
          if(icebreakerVcToken.getResultCode() != 200){
            int updateResult = VCRegisterUtil.VCUpdate(groupId, userScreenName, userPassword, user.getEmailAddress());
            if(updateResult==200){
              icebreakerVcToken = TokenProviderUtil.getVcToken(groupId, userScreenName, userPassword);
            }
          }
          
          if(icebreakerVcToken.getResultCode() == 200){
            icebreakerVcToken.setVcToken(icebreakerVcToken.getVcToken());         
            icebreakerVcToken.setVcTokenExpired(icebreakerVcToken.getVcTokenExpired());
            
            user.getExpandoBridge().setAttribute(EdisonExpando.USER_VC_TOKEN + String.valueOf(groupId), icebreakerVcToken.getVcToken());
            user.getExpandoBridge().setAttribute(EdisonExpando.USER_VC_TOKEN_EXPIRED + String.valueOf(groupId), icebreakerVcToken.getVcTokenExpired());
          }else{
            log.debug("Icebreaker getOrCreateToken Error !!");
          }
        }else{
          //icebreaker 계정은 있으나 포털에 expando가 없는 경우 expando 추가 생성
          icebreakerVcToken = MyFileIcebreakerUtil.createExpandoUserVctoken(user, groupId, userScreenName, userPassword);
        }
      }
    }else{ // Icebreaker 계정이 없는경우
      //icebreaker 계정도 없는 경우 생성
      int resultRegist = VCRegisterUtil.VCRegist(groupId, userScreenName, userPassword, user.getEmailAddress(), user.getFirstName(), universityField, virtualLabId, classId, majorField);
      if (resultRegist == 201) {
        //icebreaker 가입이 성공한 경우 신규 토큰 발행 및 커스텀 필드 추가
        icebreakerVcToken = MyFileIcebreakerUtil.createExpandoUserVctoken(user, groupId, userScreenName, userPassword);
      }
    }

    String icebreakerUrl = CustomUtil.strNull(thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL));
    JSONObject obj = JSONFactoryUtil.createJSONObject();
    obj.put("icebreakerUrl", icebreakerUrl);
    obj.put("icebreakerVcToken", icebreakerVcToken.getVcToken());
    obj.put("groupId", groupId);
    response.setContentType("application/json; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.write(obj.toString());
  }
  
	@RenderMapping(params = "myRender=solverRender")
	public String solverRender(RenderRequest request, RenderResponse response, ModelMap model){
		return "appmanager/view";
	}
	
	@RenderMapping(params = "myaction=portNameAdd")
	public String portNameAdd(RenderRequest request, ModelMap model){
	  return "appmanager/port_name_add";
	}
	
	@RenderMapping(params = "myaction=portSearch")
	public String portSearch(RenderRequest request, ModelMap model){
	  return "appmanager/port_search";
	}
	
	@ActionMapping(value="appAction")
	public void appAction(ActionRequest request, ActionResponse response, Model model) throws Exception{
	  // TODO : Servlet Action
	}
	
	@ResourceMapping(value="ajaxEvent")
	public void portTypeSearch(ResourceRequest request, ResourceResponse response){
	  // TODO : Ajax event
	}
	
	
	
}
