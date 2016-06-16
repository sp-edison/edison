<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp" %>
<%@ include file="/common/science_platform_events.jspf" %>
<liferay-portlet:resourceURL var="getEditorPortletUrl" escapeXml="false" id="getEditorPortlet" copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL var="getAuthTokenUrl" escapeXml="false" id="getAuthToken" copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL var="getIcebreakerAccessTokenUrl" escapeXml="false" id="getIcebreakerAccessToken" copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL var="getSiteGroupIdUrl" escapeXml="false" id="getSiteGroupId" copyCurrentRenderParameters="false"/>
<script>
var var_save_success_message =  Liferay.Language.get("edison-workflow-save-success-message");
var var_new_workflow_confirm_message = Liferay.Language.get("edison-workflow-new-confirm-message");
var var_remove_workflow_confirm_message = Liferay.Language.get("edison-workflow-remove-confirm-message");
var var_prepare_remove_workflow_message = Liferay.Language.get("edison-workflow-prepare-remove-message");
var var_success_remove_workflow_message = Liferay.Language.get("edison-workflow-success-remove-message");
var var_prepare_copy_workflow_message = Liferay.Language.get("edison-workflow-prepare-copy-message");
var var_success_copy_workflow_message = Liferay.Language.get("edison-workflow-success-copy-message");
var var_validation_required_message = Liferay.Language.get("edison-workflow-validation-required-message");
var var_data_empty_message = Liferay.Language.get("edison-workflow-data-empty-message");
var var_success_run_workflow_message = Liferay.Language.get("edison-workflow-success-run-message");
var var_run_workflow_save_err_message = Liferay.Language.get("edison-workflow-run-save-err-message");
var var_run_workflow_empty_err_message = Liferay.Language.get("edison-workflow-run-empty-err-message");
var var_remove_app_confirm = Liferay.Language.get("edison-workflow-remove-app-confirm");
var var_private_default_editor_message = Liferay.Language.get("edison-workflow-privat-default-editor-message");
var contextPath = '${contextPath}';
</script>
<h1><liferay-ui:message key="edison-simulation-workflow"/></h1>
<div id="science-app" class="wf-container">
  <div class="wftitlebox001">
    <input type="text" name="worfklow-definition-name" id="worfklow-definition-name"/>
    <span>
      <input class="addIp button03" id="wf-new-button" value="<liferay-ui:message key='edison-workflow-create-new'/>" type="button">
      <input class="addIp button03" id="wf-save-button" value="<liferay-ui:message key='edison-button-save'/>" type="button">
      <input class="addIp button03" id="wf-copy-button" value="<liferay-ui:message key='edison-workflow-copy'/>" type="button">
      <input class="addIp button03" id="wf-remove-button" value="<liferay-ui:message key='edison-button-board-delete'/>" type="button">
      <input class="addIp button03" id="wf-run-button" value="<liferay-ui:message key='edison-table-list-header-run'/>" type="button">
    </span>
  </div>
  <div class="lefttabm">
    <ul>
      <li class="on science-app"><liferay-ui:message key="edison-workflow-science-app"/></li>
      <li class="running-workflow"><liferay-ui:message key="edison-workflow-running-workflow"/></li>
      <li class="my-workflow"><liferay-ui:message key="edison-workflow-my-workflow"/></li>
      <li class="public-workflow"><liferay-ui:message key="edison-workflow-open-workflow"/></li>
    </ul>
  </div>
  <div class="leftwrap wrap">
    <div class="lefttreemenu science-app">
      <div class="searchbox">
        <input id="science-app-search" name="science-app-search" type="text" size="40" value="" autocomplete="off" placeholder="<liferay-ui:message key='edison-workflow-science-app-filter'/>"/>
        <input type="button" id="keyWordB">
      </div>
      <div class="lefttreemenu1 wf-jstree" id="app-list">
      </div>
    </div>
  </div>
  <div class="alert"></div>
  <div class="rightwrap">
    <div id="wf-workflow-canvas" class="apparea wf-drop jsplumb-drag-select" >
    </div>
  </div>
</div>

<div id="running-workflow" class="wf-container hidden">
  <div class="wftitlebox001">
    <h2 class="workflow-name-h2"></h2>
    <span>
    </span>
  </div>
  <div class="lefttabm">
    <ul>
      <li class="on science-app"><liferay-ui:message key="edison-workflow-science-app"/></li>
      <li class="running-workflow"><liferay-ui:message key="edison-workflow-running-workflow"/></li>
      <li class="my-workflow"><liferay-ui:message key="edison-workflow-my-workflow"/></li>
      <li class="public-workflow"><liferay-ui:message key="edison-workflow-open-workflow"/></li>
    </ul>
  </div>
  <div class="wfconwrap wrap" style="display: none;">
    <div class="lefttablemenu" >
      <div class="searchbox">
        <input id="search-running-workflow-name" name="search-running-workflow-name" type="text" size="40" value="" autocomplete="off" placeholder="<liferay-ui:message key='edison-workflow-workflow-instance-name-filter'/>"/>
        <input id="search-running-workflow-name-large-btn" type="button">
      </div>
      <div class="tabletopwf">
        <select id="_edisonscienceAppstore_WAR_edisonappstoreportlet_linePerPage" name="_edisonscienceAppstore_WAR_edisonappstoreportlet_linePerPage"
          class="selectview">
            <option value="10">10<liferay-ui:message key="edison-search-views"/></option>
            <option value="20">20<liferay-ui:message key="edison-search-views"/></option>
            <option value="30">30<liferay-ui:message key="edison-search-views"/></option>
            <option value="40">40<liferay-ui:message key="edison-search-views"/></option>
        </select>
      </div>
      <div class="slideclosearrow">
        <a class="wf-slide-toggle" href="#slide-close"><img src="${contextPath}/images/Workflow/slideclose_arrow.png" width="30" height="48"></a>
      </div>
      <div style="height:37px;"></div>
      <div>
        <div class="tablemf_list borderno">
          <table>
            <colgroup>
              <col width="20%">
              <col width="20%">
              <col width="15%">
              <col width="15%">
              <col width="15%">
              <col width="15%"> </colgroup>
            <thead>
              <tr>
                <th scope="col"><liferay-ui:message key="edison-workflow-instance-name"/></th>
                <th scope="col"><liferay-ui:message key="edison-workflow-definition"/></th>
                <th scope="col"><liferay-ui:message key="edison-table-list-header-run"/>ID</th>
                <th scope="col"><liferay-ui:message key="edison-workflow-running-status"/></th>
                <th scope="col"><liferay-ui:message key="edison-workflow-running-start-date"/></th>
                <th scope="col"><liferay-ui:message key="edison-workflow-running-end-date"/></th>
              </tr>
            </thead>
            <tbody class="workflow-list-tbody">
              <tr class="bgcolor">
                <td class="pdleft20">running work flow1</td>
                <td class="pdleft20"><liferay-ui:message key="edison-workflow-my-workflow-definition"/> 1</td>
                <td class="TC">admin</td>
                <td class="TC">Done</td>
                <td class="TC">2016.02.17 10:22</td>
                <td class="TC">2016.02.17 11:22</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
      <div id="running-workflow-paging"  class="paging">
      </div>
    </div>
  </div>
  
  <div class="leftwrap wrap">
    <div class="lefttreemenu running-workflow">
      <div class="searchbox">
        <input id="search-running-workflow-name-small" name="search-running-workflow-name" type="text" size="40" value="" autocomplete="off" placeholder="<liferay-ui:message key='edison-workflow-workflow-instance-name-filter'/>"/>
        <input type="button" id="search-running-workflow-name-small-btn">
      </div>
      <div class="openslidearrow">
        <a class="wf-slide-toggle" href="#slide-open"><img src="${contextPath}/images/Workflow/slideopen_arrow.png" width="32" height="51"></a>
      </div>
      <div class="lefttreemenu1 wf-jstree" id="workflow-instance-list">
        <%-- <ul>
          <li><a href="#"><liferay-ui:message key="edison-workflow-my-running-workflow"/></a>
            <ul>
              <li><a href="#"><liferay-ui:message key="edison-workflow-my-workflow-definition"/> 1</a>
                <ul>
                  <li> <a href="#">Running Workflow2 </a></li>
                </ul>
              </li>
            </ul>
          </li>
        </ul> --%>
      </div>
    </div>
  </div>
  <div class="alert"></div>
  <div class="rightwrap">
    <div id="running-workflow-canvas" class="right apparea" >
    </div>
  </div>
  <div id="running-workflow-log">
    <div class="tablemf_list borderno">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <colgroup>
              <col width="*%">
              <col width="15%">
              <col width="25%">
              <col width="25%">
              <!-- <col width="*"> --> 
          </colgroup>
          <thead>
              <tr>
                  <th scope="col"><liferay-ui:message key="edison-virtuallab-app-name"/></th>
                  <th scope="col"><liferay-ui:message key="edison-table-list-header-status"/></th>
                  <th scope="col"><liferay-ui:message key="edison-workflow-running-start-date"/></th>
                  <th scope="col"><liferay-ui:message key="edison-workflow-running-end-date"/></th>
                  <!-- <th scope="col">실행결과</th> -->
              </tr>
          </thead>
          <tbody id="running-workflow-log-tbody">
            <tr class="bgcolor"><td class="TC" colspan="4"><liferay-ui:message key="edison-workflow-data-empty-message"/></td></tr>
          </tbody>
      </table>
    </div>
  </div>
</div>

<div id="my-workflow" class="wf-container hidden">
  <div class="wftitlebox001">
    <h2 id="my-workflow-name" class="workflow-name-h2"></h2>
    <span>
      <input class="addIp button03" id="wf-modify-button" value="<liferay-ui:message key='edison-workflow-edit'/>" type="button"/>
      <input class="addIp button03" id="wf-my-copy-button" value="<liferay-ui:message key='edison-workflow-copy'/>" type="button">
    </span>
  </div>
  <div class="lefttabm">
    <ul>
      <li class="science-app"><liferay-ui:message key="edison-workflow-science-app"/></li>
      <li class="running-workflow"><liferay-ui:message key="edison-workflow-running-workflow"/></li>
      <li class="my-workflow"><liferay-ui:message key="edison-workflow-my-workflow"/></li>
      <li class="public-workflow"><liferay-ui:message key="edison-workflow-open-workflow"/></li>
    </ul>
  </div>
  <div class="wfconwrap wrap" style="display: none;">
    <div class="lefttablemenu" >
      <div class="searchbox">
        <input id="search-my-workflow-name-large" name="search-my-workflow-name" type="text" size="40" value="" autocomplete="off" placeholder="<liferay-ui:message key='edison-workflow-workflow-name-filter'/>"/>
        <input id="search-my-workflow-name-large-btn" type="button">
      </div>
      <div class="tabletopwf">
        <select id="my-workflow-line-per-page" name="my-workflow-line-per-page"
          class="selectview">
            <option value="10">10<liferay-ui:message key="edison-search-views"/></option>
            <option value="20">20<liferay-ui:message key="edison-search-views"/></option>
            <option value="30">30<liferay-ui:message key="edison-search-views"/></option>
            <option value="40">40<liferay-ui:message key="edison-search-views"/></option>
        </select>
      </div>
      <div class="slideclosearrow">
        <a class="wf-slide-toggle" href="#slide-close"><img src="${contextPath}/images/Workflow/slideclose_arrow.png" width="30" height="48"></a>
      </div>
      <div style="height:37px;"></div>
      <div>
        <div class="tablemf_list borderno">
          <table>
            <colgroup>
              <col width="20%">
              <col width="20%">
              <col width="15%">
              <col width="15%">
              <col width="15%">
              <col width="15%"> 
            </colgroup>
            <thead>
              <tr>
                <th scope="col"><liferay-ui:message key="edison-workflow-name"/></th>
                <th scope="col"><liferay-ui:message key="edison-simulation-execute-simulation-description"/></th>
                <th scope="col"><liferay-ui:message key="edison-virtuallab-owner"/></th>
                <th scope="col">Copied from</th>
                <th scope="col"><liferay-ui:message key="edison-workflow-create-date"/></th>
                <th scope="col"><liferay-ui:message key="edison-workflow-public-status"/></th>
              </tr>
            </thead>
            <tbody id="my-workflow-tbody" class="workflow-list-tbody">
            </tbody>
          </table>
        </div>
      </div>
      <div id="my-workflow-paging" class="paging">
      </div>
    </div>
  </div>
  <div class="leftwrap wrap">
    <div class="leftlistbox my-workflow">
      <div class="searchbox">
        <input id="search-my-workflow-name-small" name="search-my-workflow-name" type="text" size="40" value="" autocomplete="off" placeholder="<liferay-ui:message key='edison-workflow-workflow-name-filter'/>"/>
        <input type="button" id="search-my-workflow-name-small-btn">
      </div>
      <div class="openslidearrow">
        <a class="wf-slide-toggle" href="#"><img src="${contextPath}/images/Workflow/slideopen_arrow.png" width="32" height="51"></a>
      </div>
      <div class="listboxtopsp" >
        <div class="workflow-list-div" id="my-workflow-div">
        </div>
      </div>
    </div>
  </div>
  <div class="alert"></div>
  <div class="rightwrap">
    <div id="my-workflow-canvas" class="right apparea">
    </div>
  </div>
</div>

<div id="public-workflow" class="wf-container hidden">
  <div class="wftitlebox001">
    <h2 id="public-workflow-name" class="workflow-name-h2"></h2>
    <span>
      <input class="addIp button03" id="wf-public-copy-button" value="<liferay-ui:message key='edison-workflow-copy'/>" type="button">
    </span>
  </div>
  <div class="lefttabm">
    <ul>
      <li class="science-app"><liferay-ui:message key="edison-workflow-science-app"/></li>
      <li class="running-workflow"><liferay-ui:message key="edison-workflow-running-workflow"/></li>
      <li class="my-workflow"><liferay-ui:message key="edison-workflow-my-workflow"/></li>
      <li class="public-workflow"><liferay-ui:message key="edison-workflow-open-workflow"/></li>
    </ul>
  </div>
  <div class="wfconwrap wrap" style="display: none;">
    <div class="lefttablemenu" >
      <div class="searchbox">
        <input id="search-public-workflow-name-large" name="search-public-workflow-name" type="text" size="40" value="" autocomplete="off" placeholder="<liferay-ui:message key='edison-workflow-workflow-name-filter'/>"/>
        <input id="search-public-workflow-name-large-btn" type="button">
      </div>
      <div class="tabletopwf">
        <select id="public-workflow-line-per-page" name="public-workflow-line-per-page"
          class="selectview">
            <option value="10">10<liferay-ui:message key="edison-search-views"/></option>
            <option value="20">20<liferay-ui:message key="edison-search-views"/></option>
            <option value="30">30<liferay-ui:message key="edison-search-views"/></option>
            <option value="40">40<liferay-ui:message key="edison-search-views"/></option>
        </select>
      </div>
      <div class="slideclosearrow">
        <a class="wf-slide-toggle" href="#slide-close"><img src="${contextPath}/images/Workflow/slideclose_arrow.png" width="30" height="48"></a>
      </div>
      <div style="height:37px;"></div>
      <div>
        <div class="tablemf_list borderno">
          <table>
            <colgroup>
              <col width="20%">
              <col width="20%">
              <col width="15%">
              <col width="15%">
              <col width="15%">
              <col width="15%"> 
            </colgroup>
            <thead>
              <tr>
                <th scope="col"><liferay-ui:message key="edison-workflow-name"/></th>
                <th scope="col"><liferay-ui:message key="edison-simulation-execute-simulation-description"/></th>
                <th scope="col"><liferay-ui:message key="edison-virtuallab-owner"/></th>
                <th scope="col">Copied from</th>
                <th scope="col"><liferay-ui:message key="edison-workflow-create-date"/></th>
                <th scope="col"><liferay-ui:message key="edison-workflow-public-status"/></th>
              </tr>
            </thead>
            <tbody id="public-workflow-tbody" class="workflow-list-tbody">
            </tbody>
          </table>
        </div>
      </div>
      <div id="public-workflow-paging" class="paging">
      </div>
    </div>
  </div>
  <div class="leftwrap wrap">
    <div class="leftlistbox public-workflow">
      <div class="searchbox">
        <input id="search-public-workflow-name-small" name="search-public-workflow-name" type="text" size="40" value="" autocomplete="off" placeholder="<liferay-ui:message key='edison-workflow-workflow-name-filter'/>"/>
        <input type="button" id="search-public-workflow-name-small-btn">
      </div>
      <div class="openslidearrow">
        <a class="wf-slide-toggle" href="#"><img src="${contextPath}/images/Workflow/slideopen_arrow.png" width="32" height="51"></a>
      </div>
      <div class="listboxtopsp">
        <div class="workflow-list-div" id="public-workflow-div">
        </div>
      </div>
    </div>
  </div>
  <div class="alert"></div>
  <div class="rightwrap">
    <div id="public-workflow-canvas" class="right apparea" >
    </div>
  </div>
</div>
<div id="workflow-instance-dialog" style="display:none; background-color:white; padding:0px;" class="newWindow">
  <div class="newWheader" id="workflow-instance-dialog-title">
    <div class="newWtitlebox"><img src="<%=renderRequest.getContextPath()%>/images/title_newWindow.png" width="34" height="34">
      <div class="newWtitle">Workflow Instance Name</div>
    </div>
    <div class="newWclose" style="cursor: pointer;">
      <img  id="workflow-instance-dialog-close-btn" src="<%=renderRequest.getContextPath()%>/images/btn_closeWindow.png" width="21" height="21">
    </div>
  </div>
  <div id="workflow-instance-dialog-cont" style="padding: 30px;" class="newWcont01">
    <p><liferay-ui:message key="edison-workflow-running-instance-name-message"/>.</p>
    <input id="workflow-instance-name-input" type="text" name="workflow-instance-name" style="width: 85%;" />
    <input id="workflow-instance-run" class="button03" style="float: right;"  type="button" name="save" value="Run"/>
  </div>
</div>
<script>
  var isNotLoaded = true;
  var wfPortletGlobalData = wfPortletGlobalData ? wfPortletGlobalData : {wfElements : {}};
  function getEditorPortletUrl(portletId){
    var url = "<%=getEditorPortletUrl%>";
    return synchronousAjaxHelper.post(url, {"<portlet:namespace/>portletId" : portletId})["portletURL"];
  }
  function getAuthToken(portletId){
    var url = "<%=getAuthTokenUrl%>";
    return synchronousAjaxHelper.post(url, {"<portlet:namespace/>portletId" : portletId});
  }
  function getIcebreakerAccessToken(){
    var url = "<%=getIcebreakerAccessTokenUrl%>";
    return synchronousAjaxHelper.post(url, {});
  }
  function getSiteGroupId(){
    var url = "<%=getSiteGroupIdUrl%>";
    return synchronousAjaxHelper.post(url, {})["groupId"];
  }

  //function openEditorWindow(portletId, portletTitle, taskId jsplumb, portName, token( pp_auth ), plid( 화면 plid )){
  function popEditorWindow(editor, port, jsPlumbWindowId){
    var portletTitle = editor["title"];
    var portletId = editor["exeFileName"];
    var portType = editor["editorType"];
    var portName = port.getName();
    var portTypeId = port.getPortTypeId();
    var endPointId = jsPlumbWindowId + "|" + port.getName();
    var taskId = jsPlumbWindowId;
  	var authToken = getAuthToken(portletId);
  	var plid = authToken["plid"];
  	var token = authToken["authToken"];
  	var portData;
  	/* if(wfPortletGlobalData["wfElements"][jsPlumbWindowId]){
  	  portData = wfPortletGlobalData["wfElements"][jsPlumbWindowId][portName];
  	} */
    portData = portData ? portData : "";
  	
  	AUI().use("liferay-portlet-url", function(a) {
    	var renderURL = Liferay.PortletURL.createRenderURL();
  	  	renderURL.setPortletId(portletId);
  	  	renderURL.setPlid(plid);
      	renderURL.setParameter("taskId", taskId);
      	renderURL.setParameter("portName", portName);
      	renderURL.setParameter("portletTitle", portletTitle);
      	renderURL.setParameter("token", token);
      	renderURL.setParameter("portTypeId", portTypeId);
      	
    	if(portType == "Inputdeck") {
          renderURL.setParameter("width", 900);
          renderURL.setParameter("height", 600);
    	} else {
          renderURL.setParameter("width", 400);
          renderURL.setParameter("height", 230);
    	}
        renderURL.setParameter("portData", portData);
    	openWindow(renderURL, endPointId);
  	});
  }

  function openWindow(renderURL, endPointId){
  	var dialogId = endPointId;
	renderURL.setName("Popup");
  	renderURL.setWindowState("pop_up"); 
  	renderURL.setParameter("dialogId", dialogId);
 	renderURL.setParameter("workflowType", "workflow");
  	 	
 	var url = renderURL.toString();
  	Liferay.Util.openWindow({
  		dialog: {
  			cache: false,
          	destroyOnClose: true,
  			centered: true,
  			modal: true,
  			resizable: false,
  			width:renderURL.params.width, 
  			height:renderURL.params.height
  		},
  		id: dialogId ,
  		title: renderURL.params.portletTitle,
  		uri : url+ '&p_p_auth='+ renderURL.params.token
  	});
  }
  
  Liferay.provide(
  	window,
  	'fetchResult',
     	function( taskId, portName, value ){
  		var content = {
  				taskId : taskId,
  				portName : portName,
  				value: value
  		};
  		
  		var payload = new SciencePlatformEvent(
  				"stringPort",
  				SciencePlatformEvents.TYPE_BROADCAST,
  				'<portlet:namespace/>',
  				'',
  				content);
  		
  		Liferay.fire(SciencePlatformEvents.IPC_EVENT_CONTENT_BROADCAST, payload);
     	},
  	['aui-base','liferay-util-window','aui-dialog-iframe-deprecated','liferay-util-window']
  );
  		
  Liferay.provide(
  	window,
  	'closePopup',
     	function(popupId) {
         	var popupDialog = Liferay.Util.Window.getById(popupId);
            popupDialog.destroy();
     	},
  	['aui-base','aui-dialog','aui-dialog-iframe','liferay-util-window']
  );
  
  Liferay.on(SciencePlatformEvents.IPC_EVENT_CONTENT_BROADCAST, function(event){
  	var json = event.getEventData();
  	var jsonData = JSON.stringify(json);
  	
  	consoleLog.debug(event);
  	consoleLog.debug(json);
  	
  	if(wfPortletGlobalData["wfElements"][json["taskId"]]){
      wfPortletGlobalData["wfElements"][json["taskId"]][json["portName"]] = json["value"];
    }else{
      var portJson = {};
      portJson[json["portName"]] = json["value"];
      wfPortletGlobalData["wfElements"][json["taskId"]] = portJson;
    }
  	
  	consoleLog.debug(wfPortletGlobalData);
  	
  	/* $('#<portlet:namespace/>' + json["portName"]).val(json["value"]);
  	if(typeof json["value"] != 'undefined' && json["value"] != "") {
  		$('#<portlet:namespace/>' + json["portName"] + '_info').text("SUCCESS").css("color", "green");
  	} else {
  		$('#<portlet:namespace/>' + json["portName"] + '_info').text("FAIL").css("color", "red");
  	}
  	$('#<portlet:namespace/>' + json["portName"] + '_info_btn').show(); */
  });
  	
  function addScienceAppData(endPointId, arrData) {
    var inputJson = $.parseJSON(JSON.stringify(arrData[0]));
    console.log(endPointId, inputJson);
    
    if(typeof endPointId === 'string'){
      var portName = endPointId.substr(endPointId.lastIndexOf("|")+1);
      var elementId = endPointId.substr(0, (endPointId.lastIndexOf("|")));
      if(wfPortletGlobalData["wfElements"][elementId]){
        wfPortletGlobalData["wfElements"][elementId][portName] = inputJson;
      }else{
        var portJson = {};
        portJson[portName] = inputJson;
        wfPortletGlobalData["wfElements"][elementId] = portJson;
      }
    }
  }
</script>