<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>


<script>
	var url = navTab._getTab('dygxmx_add').attr('url',"${contextPath }/dde/mapinfoDetail!addAndsaveMapinfoDatails.do?s_mapinfoId=${s_mapinfoId}&s_type=initfirst&noInitfirst=true");
</script>

<div id="div_mapinfo_detail_form_add" class="pageFormContent dde" style="min-width:928px; width:98%; height:171px; ">
  <div style="float:left">
	<dl class="nowrap">
		<dt>左（数据源）定义：</dt>
		<dd>
			<input id="txt_source_database_name" name="s_sourceDatabaseName" type="text" size="10"
				   value="${s_sourcedatabaseName }" readonly="readonly"/>
			<input name="s_soueceTableName" type="text" size="25"
				class="datasource" value="${s_soueceTableName }" /> <a
				class="btnLook"
				href="${pageContext.request.contextPath }/dde/mapinfoDetail!defSourceData_add.do?s_soueceTableName=${s_soueceTableName }&s_goalTableName=${s_goalTableName}&s_sourcedatabaseName=${s_sourcedatabaseName}&s_goaldatabaseName=${s_goaldatabaseName}&s_mapinfoId=${s_mapinfoId}"
				target="dialog" rel="defSourceAndGoalData" mask="true" title="定义数据源"><span>定义数据源</span>
			</a>
		</dd>
	</dl>

	<dl class="nowrap">
		<dt>右（数据目标）定义：</dt>
		<dd>
			<input name="s_goalDatabaseName" type="text" size="10"
				   value="${s_goaldatabaseName }" readonly="readonly"/>
			<input name="s_goalTableName" type="text" size="25" class="datadest"
				value="${s_goalTableName}" /> <a class="btnLook"
				href="${pageContext.request.contextPath }/dde/mapinfoDetail!defGoalData_add.do?s_goalTableName=${s_goalTableName}&s_soueceTableName=${s_soueceTableName }&s_sourcedatabaseName=${s_sourcedatabaseName}&s_goaldatabaseName=${s_goaldatabaseName}&s_mapinfoId=${s_mapinfoId}"
				target="dialog" rel="defSourceAndGoalData" mask="true"
				title="定义数据目标"><span>定义数据目标</span> </a>
		</dd>
	</dl>
	
	<dl class="nowrap">
				<dt>交换名称：</dt>
				<dd>
				<input type="text" name="mapinfoName" value="${mapinfoName}" size="40" id="mapinfoName"/>
				</dd>
	</dl>
	
	<dl class="nowrap">
				<dt>交换说明：</dt>
				<dd>
				<textarea rows="3" cols="33" name="mapinfoDesc" id="mapinfoDesc">${mapinfoDesc }</textarea>
				</dd>
	</dl>
  </div>
  <div style="float:left">
  
    
    <fieldset style="width:500px;">
      <legend>记录操作</legend>
     <dl class="nowrap">
				<dd>
				<input type="radio" name="recordOperate" value="1" class="recordOperate" <c:if test="${(recordOperate ne '2') or (recordOperate ne '3')}">checked=true</c:if> />插入（insert）<br/>
				<input type="radio" name="recordOperate" value="2" class="recordOperate" <c:if test="${recordOperate eq '2'}">checked=true</c:if>/>更新（update）<br/>
				<input type="radio" name="recordOperate" value="3" class="recordOperate" <c:if test="${recordOperate eq '3'}">checked=true</c:if>/>合并（merge）
				</dd>
	</dl>
   </fieldset>
    <dl class="nowrap" style="display: inline;">
				<dt>是否重复执行：</dt>
				<dd>
				<input type="radio" name="isRepeat" value="1" class="isRepeat" <c:if test="${isRepeat ne '0'}">checked=true</c:if> />是
				<input type="radio" name="isRepeat" value="0" class="isRepeat" <c:if test="${isRepeat eq '0'}">checked=true</c:if>/>否
				</dd>
	</dl>
  </div>
  
   
  	
</div>

<div class="pageContent" style="min-width:928px; width:100%;">
	<div class="tabs tabsExtra">
		<div class="tabsHeader">
			<div class="tabsHeaderContent">
				<ul>
					<li><a
						href="${pageContext.request.contextPath}/dde/mapinfoDetail!addAndsaveMapinfoDatails.do?s_soueceTableName=${s_soueceTableName}&s_goalTableName=${s_goalTableName}&s_mapinfoId=${s_mapinfoId}&s_type=initinner&s_sourcedatabaseName=${s_sourcedatabaseName}&s_goaldatabaseName=${s_goaldatabaseName}"
						target="ajax" rel="jbsxBox_add"><span>对应关系</span></a></li>
					<li><a
						href="${pageContext.request.contextPath }/dde/mapinfoTrigger!list_add.do?s_mapinfoId=${s_mapinfoId}"
						target="ajax" rel="jbsxBox_add"><span>触发器</span></a></li>
				</ul>
			</div>
		</div>
		<div class="tabsContentAjax">
			<div class="unitBox" id="jbsxBox_add">
				<%@ include file="/page/dde/mapInfo4Details_add.jsp"%>
			</div>
		</div>
		<div class="tabsFooter">
			<div class="tabsFooterContent"></div>
		</div>
	</div>
</div>

