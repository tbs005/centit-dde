<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<div class="pageContent">

	<form id="defSourceDataFrom" class="defSourceDataFrom"
		onsubmit="return navTabSearch(this)"
		action="${pageContext.request.contextPath}/dde/mapinfoDetail!addAndsaveMapinfoDatails.do?&s_type=init&s_method=updateSourceColumnSentence"
		method="post">
		
		<input type="hidden" name="s_goalTableName" value="${param['s_goalTableName']}"/>
		<input type="hidden" name="s_goaldatabaseName" value="${param['s_goaldatabaseName']}"/>
		<input type="hidden" name="s_mapinfoId" value="${param['s_mapinfoId']}"/>
		<div class="pageFormContent" layoutH="58">

			<div class="unit">
				<label>数据库连接：</label>
				<select class="combox" name="s_sourcedatabaseName" ref="tableNames"
						refUrl="${pageContext.request.contextPath }/dde/mapinfoDetail!database.do?databaseName={value}">
						<option value="all">请选择数据库</option>
				    <c:forEach var="database" items="${DATABASE}">
      				  <option value="${database}" <c:if test="${database eq param.s_sourcedatabaseName }">selected="selected"</c:if> >${database}</option>
      			   </c:forEach>
				</select>
			</div>
			<div class="unit">
				<label>表名：</label>
				<input name="s_soueceTableName" size="20"  value="${param['s_soueceTableName']}" type="text" Class="required  soueceTableName" />
				
				
				<label style="width:60px">请选择:</label>
				<select class="combox table" name="s_soueceTableName1" id="tableNames">
     				  <option value="all" >请选择表名</option>
     				<c:if test="${not empty tables }">
	     			   <c:forEach var="table" items="${tables}">
	      				  <option value="${table[0]}" <c:if test="${table[0] eq param.s_soueceTableName }">selected="selected"</c:if> >${table[0]}</option>
	      			   </c:forEach>
     				</c:if>
				</select>
			</div>
	 
			<div class="unit">
				<label>查询语句：</label>
				<textarea name="s_querySql" cols="44" rows="5" >${SQL}</textarea>
				<input type="hidden" name="s_querySqlsource" value="${SQL}"/>
			</div>
				
		</div>

		<div class="formBar">
			<ul>
				<li>
					<div class="buttonActive">
						<div class="buttonContent">
							<button type="button" onclick="submitMapInfo();">提交</button>
						</div>
					</div>
				</li>

				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="button" class="close">取消</button>
						</div>
					</div></li>
			</ul>
		</div>
	</form>
</div>

<script type="text/javascript">
	  function submitMapInfo(){
		  //debugger;
		  var mapinfoName = $("#mapinfoName").val();
		  var isRepeat = $(".isRepeat:checked").val();
		  var mapinfoDesc = $("#mapinfoDesc").val();
		  var tableOperate = $("#tableOperate").val();
		  var recordOperate = $(".recordOperate:checked").val();
			
		  var mapinfoNameElement = DWZ.frag["INPUTHIDDEN"]
			.replaceAll('{name}', 'mapinfoName')
			.replaceAll('{value}', mapinfoName);
		  var isRepeatElement = DWZ.frag["INPUTHIDDEN"]
			.replaceAll('{name}', 'isRepeat')
			.replaceAll('{value}', isRepeat);
		  var mapinfoDescElement = DWZ.frag["INPUTHIDDEN"]
			.replaceAll('{name}', 'mapinfoDesc')
			.replaceAll('{value}', mapinfoDesc);
		  var tableOperateElement = DWZ.frag["INPUTHIDDEN"]
			.replaceAll('{name}', 'tableOperate')
			.replaceAll('{value}', tableOperate);
		  var recordOperateElement = DWZ.frag["INPUTHIDDEN"]
			.replaceAll('{name}', 'recordOperate')
			.replaceAll('{value}', recordOperate);
			
		  $("#defSourceDataFrom").append(mapinfoNameElement);
		  $("#defSourceDataFrom").append(isRepeatElement);
		  $("#defSourceDataFrom").append(mapinfoDescElement);
	      $("#defSourceDataFrom").append(tableOperateElement);
		  $("#defSourceDataFrom").append(recordOperateElement);
		  $("#defSourceDataFrom").submit();
		  $.pdialog.close($.pdialog.getCurrent());
	  }
	  $('.table', $.pdialog.getCurrent()).change(function(event){
		  $(".datasource").val($(this).val());
		  $(".soueceTableName").val($(this).val());
		  $("#defSourceDataFrom").attr("action","${pageContext.request.contextPath}/dde/mapinfoDetail!addAndsaveMapinfoDatails.do?s_type=reinitsource&s_method=updateSourceColumnSentence");
		  		  
	  });
	  
</script>