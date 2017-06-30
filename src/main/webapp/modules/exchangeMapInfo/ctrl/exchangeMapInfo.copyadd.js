define(function(require) {
	var Config = require('config');
	var Core = require('core/core');
	var Page = require('core/page');
	var ExchangeMapInfoAdd = require('./exchangeMapInfo.add');
	var ExchangeMapInfoDetailAdd = require('../ctrl/exchangeMapInfoDetail.add');
	var ExchangeMapInfoDetailRemove = require('../ctrl/exchangeMapInfoDetail.remove');
	var ExchangeMapInfoDetailAdd2 = require('../ctrl/exchangeMapInfoDetail.add2');
	var ExchangeMapInfoDetailRemove2 = require('../ctrl/exchangeMapInfoDetail.remove2');

	var ExchangeMapInfoEdit = Page.extend(function() {
		var _self = this;

		this.injecte([
			new ExchangeMapInfoAdd('exchangeMapInfo_add'),
			new ExchangeMapInfoDetailAdd('source_detail_add'),
			new ExchangeMapInfoDetailRemove('source_detail_remove'),
			new ExchangeMapInfoDetailAdd2('dest_detail_add'),
			new ExchangeMapInfoDetailRemove2('dest_detail_remove'),
		]);

		// @override
		this.load = function(panel, data) {
			var form = panel.find('form');
			Core.ajax(Config.ContextPath+'service/exchangemapinfo/copy/'+data.mapinfoId, {
				type: 'json',
				method: 'get'
//					.then()是Promise规范规定的异步调用方法    得到数据后，调用form的load方法将数据显示在表单中
			}).then(function(data) {
				_self.data = data;

				form.form('load', data)
					.form('disableValidation')
					.form('readonly', 'mapinfoId')
					.form('focus');

				var sourceTable = panel.find('table.tab1');
				sourceTable.cdatagrid({
					controller:_self,
					editable: true,
					data:data.mapinfoDetails,
					dragSelection: true,
					onLoadSuccess:function(){
						$(this).datagrid('enableDnd');
					}
				});
				var destTable = panel.find('table.dest');
				destTable.cdatagrid({
					controller:_self,
					editable: true,
					data:data.mapinfoDetails,
					dragSelection: true,
					onLoadSuccess:function(){
						$(this).datagrid('enableDnd');
					}
				});


				var tab2table = panel.find('table.tab2');
				tab2table.cdatagrid({
					controller:_self,
					editable: true,
					data:data.mapinfoTriggers
				});
			});
			onchange();
		};


		this.submit = function(panel, data,closeCallback) {
			var form = panel.find('form');
			var formData = form.form('value');
			$.extend(data,formData);
			var isValid = form.form('validate');
			if (isValid) {
				var mapinfoDetails = panel.find('table.tab1').datagrid("getData").rows;
				data.mapinfoDetails = mapinfoDetails;
				Core.ajax(Config.ContextPath + 'service/exchangemapinfo/save/' + data.mapinfoId, {
					data: data,
					method: 'put'
				}).then(function() {
					closeCallback();
				});
			}
			return false;
		};

		// @override
		this.onClose = function(table) {
			table.datagrid('reload');
		};
	});






	this.dlgAddDb = function(change){
		var sourceDatabaseName = $('#sourceDatabaseName').val();
		$('#dlgAddDbLeft').dialog({
			title:'数据库编辑',
			resizable: true,
			modal: true,
		});
		$('#dlgAddDbLeft').dialog("open");
		Core.ajax(Config.ContextPath+'service/platform/listDb', {
			method: 'get',
			data: {
				_method: 'get'
			}
		}).then(function(data) {
			var orgValue;
			var orgNameValue;
			var dataList;
			dataList = [];
			$.each(data,function(index,item){
				orgValue = data[index].databaseCode;
				orgNameValue = data[index].databaseName;
				dataList.push({"value": orgValue,"text":orgNameValue});
			});
			$('#txt_sourceDatabaseName').combobox('select',sourceDatabaseName);
			$("#txt_sourceDatabaseName").combobox("loadData",dataList);
		});
//		 sql
		var querySql=$('#querySql').val();
		$("#txt_querySql").textbox("setValue", querySql);
//		 表
		var table = $('#sourceTablename').val();
		$("#txt_sourceTablename").textbox("setValue", table);
//		 select
	};


	this.onchange = function (){
		if(document.getElementById('txt_sourceDatabaseName')){
			$('#txt_sourceDatabaseName').combobox({
				onChange: function (newValue, oldValue) {
					Core.ajax(Config.ContextPath+'service/platform/listTable/'+newValue, {
						method: 'get',
						data: {
							_method: 'get'
						}
					}).then(function(data) {
						var orgValue;
						var orgNameValue;
						var TabledataList;
						TabledataList = [];
						$.each(data,function(index,item){
							orgValue = data[index].tableName;
							orgNameValue = data[index].tableName;
							TabledataList.push({"value": orgValue,"text":orgNameValue});
						});
						$("#txt_sourceTablename").combobox("loadData",TabledataList);
					});
				}
			});
		}

		if(document.getElementById('txt_sourceTablename')){
			$('#txt_sourceTablename').combobox({
				onChange: function (newValue, oldValue) {
					$("#txt_sourceCodename").combobox('clear');
					var databaseCode = $('#txt_sourceDatabaseName').combobox('getValue');
					Core.ajax(Config.ContextPath+'service/platform/generateSQL/'+databaseCode+'/'+newValue, {
						method: 'get',
						data: {
							_method: 'get'
						}
					}).then(function(data) {

						$("#txt_querySql").textbox("setValue", data);
					});
				}
			});
		}
	}


	this.saveDbLeft = function(){


		var txt_querySql = $('#txt_querySql').val();
		var text_Table = $("#txt_sourceTablename").combobox('getValue');
		var value_sourceCodename = $("#txt_sourceCodename").combobox('getValue');

//		 var sql="select" ;
//		 var table = $("#exchangeContent1").datagrid("getRows");
//		 for(var i=0;i<table.length;i++){
//			 if(i!=table.length-1){
//				 sql = sql +" "+ table[i].sourceFieldName+",";
//			 }else{
//				 sql = sql +" "+ table[i].sourceFieldName;
//			 }
//		 }
////		 sql
//		 sql = sql + " FORM "+text_Table;
//		 $("#querySql").val(sql);
////		 select
//		 var txt_sourceDatabaseName =  $('#txt_sourceDatabaseName').combobox('getValue');
//		 $("#sourceDatabaseName").textbox("setValue", txt_sourceDatabaseName);
		$('#dlgAddDbLeft').dialog("close");
	};
	this.closeDbLeft = function(){
		$('#dlgAddDbLeft').dialog("close");
	};



	return ExchangeMapInfoEdit;
});