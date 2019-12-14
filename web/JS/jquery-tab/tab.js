function addTab(title, url, tab_id){
	var sameIdExitFlg = false;
	var sameTitleExitFlg = false;
	var index = 0;
	if(tab_id != undefined &&  tab_id != ""){
		var tabsObj = $('#tabs').tabs('tabs');
		for(i=0; i < tabsObj.length; i++ ){
			var id = tabsObj[i].panel('options').id;
			if( id != undefined &&  id != ""){
				if(id == tab_id ){
					sameIdExitFlg = true;
					index = $('#tabs').tabs('getTabIndex',tabsObj[i]);
				}
			}
		}
	}else{
		sameTitleExitFlg = $('#tabs').tabs('exists', title);
	}
	
	if (sameIdExitFlg || sameTitleExitFlg){
		if(sameIdExitFlg){
			$('#tabs').tabs('select', index);//选中
		}else{
			$('#tabs').tabs('select', title);//选中
		}
		//刷新
		/*
		var currTab = $('#tabs').tabs('getSelected');
		var url = $(currTab.panel('options').content).attr('src');
		if(url != undefined && currTab.panel('options').title != 'Home') {
			$('#tabs').tabs('update',{
				tab:currTab,
				options:{
					content:createFrame(url)
				}
			})
		}
		*/
	} else {
		var content = createFrame(url);
		if(tab_id != undefined &&  tab_id != ""){
			$('#tabs').tabs('add',{
				title:title,
				content:content,
				closable:true,
				id:tab_id
			});
		}else{
			$('#tabs').tabs('add',{
				title:title,
				content:content,
				closable:true
			});
		}
	}
	tabClose();
}

//不传入参数时，默认关闭当前tab
function closeTab(tab_id){
	if(tab_id == undefined || undefined == "" ){
		var currTab = $('#tabs').tabs('getSelected');
		var index = $('#tabs').tabs('getTabIndex',currTab);
		if(index != 0){
			$('#tabs').tabs('close',index);
		}
	}else{
		var tabsObj = $('#tabs').tabs('tabs');
		for(i=0; i < tabsObj.length; i++ ){
			var id = tabsObj[i].panel('options').id;
			if( id != undefined &&  id != ""){
				if(id == tab_id){
					var index = $('#tabs').tabs('getTabIndex',tabsObj[i]);
					if(index != 0){
						$('#tabs').tabs('close',index);
					}
					break;
				}
			}
		}
	}
	
	tabClose();
}

//不传入参数时，默认刷新当前tab
function refreshTab(tab_id){
	var exitFlg = false;
	var tabsObj = $('#tabs').tabs('tabs');
	var refreshTabObj;
	var index = 0;
	for(i=0; i < tabsObj.length; i++ ){
		var id = tabsObj[i].panel('options').id;
		if( id != undefined &&  id != ""){
			if(id == tab_id ){
				exitFlg = true;
				refreshTabObj = tabsObj[i];
			}
		}
	}
	
	//id不存在时，寻找title
	if(!exitFlg){
		if($('#tabs').tabs('exists', tab_id)){
			exitFlg = true;
			for(i=0; i < tabsObj.length; i++ ){
				var title = tabsObj[i].panel('options').title;
				if( title == tab_id){
					exitFlg = true;
					refreshTabObj = tabsObj[i];
					break;
				}
			}
		}
	}
	//刷新
	if(exitFlg){
		if(tab_id != "Home"){
			var url = $(refreshTabObj.panel('options').content).attr('src');
			if(url != undefined) {
				$('#tabs').tabs('update',{
					tab:refreshTabObj,
					options:{
						content:createFrame(url)
					}
				})
			}
		}else{
			var frm = refreshTabObj.find('iframe');
			var url = $(frm).attr("src");
			$(frm).attr("src",url);
		}
		
	}
}

function createFrame(url) {
	var s = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
	return s;
}
		
function tabClose() {
	/*双击关闭TAB选项卡*/
	$(".tabs-inner").dblclick(function(){
		var index = $(".tabs-inner").index(this);
		if (index != 0) {
			$('#tabs').tabs('close',index);
		}
	});
	/*为选项卡绑定右键*/
	$(".tabs-inner").bind('contextmenu',function(e){
		$('#mm').menu('show', {
			left: e.pageX,
			top: e.pageY
		});

		var subtitleindex =$(".tabs-inner").index(this);
		if(subtitleindex != 0){
			$('#mm').data("currtab",subtitleindex);
		}
		$('#tabs').tabs('select',subtitleindex);
		return false;
	});
}		
//绑定右键菜单事件
function tabCloseEven() {
	//刷新
	$('#mm-tabupdate').click(function(){
		var currTab = $('#tabs').tabs('getSelected');
		var url = $(currTab.panel('options').content).attr('src');
		if(url != undefined && currTab.panel('options').title != 'Home') {
			$('#tabs').tabs('update',{
				tab:currTab,
				options:{
					content:createFrame(url)
				}
			})
		}
	});
	//关闭当前
	$('#mm-tabclose').click(function(){
		var currtab_title = $('#mm').data("currtab");
		if(currtab_title != '0'){
			$('#tabs').tabs('close',currtab_title);
		}
	});
	//全部关闭
	$('#mm-tabcloseall').click(function(){
		$('.tabs-inner span').each(function(i,n){
			var t = $(n).text();
			if(t != 'Home') {
				$('#tabs').tabs('close',t);
			}
		});
	});
	//关闭除当前之外的TAB
	$('#mm-tabcloseother').click(function(){
		var prevall = $('.tabs-selected').prevAll();
		var nextall = $('.tabs-selected').nextAll();		
		if(prevall.length>0){
			prevall.each(function(i,n){
				var t=$('a:eq(0)',$(n));
				var index = $(".tabs-inner").index(t);
				if(index != 0) {
					$('#tabs').tabs('close',index);
				}
			});
		}
		if(nextall.length>0) {
			nextall.each(function(i,n){
				var t=$('a:eq(0)',$(n));
				var index = $(".tabs-inner").index(t);
				if(index != 0) {
					$('#tabs').tabs('close',index);
				}
			});
		}
		return false;
	});
	//关闭当前右侧的TAB
	$('#mm-tabcloseright').click(function(){
		var nextall = $('.tabs-selected').nextAll();
		if(nextall.length==0){
			//msgShow('系统提示','后边没有啦~~','error');
			alert('后边没有啦~~');
			return false;
		}
		nextall.each(function(i,n){
			var t=$('a:eq(0) span',$(n)).text();
			$('#tabs').tabs('close',t);
		});
		return false;
	});
	//关闭当前左侧的TAB
	$('#mm-tabcloseleft').click(function(){
		var prevall = $('.tabs-selected').prevAll();
		if(prevall.length==0){
			alert('到头了，前边没有啦~~');
			return false;
		}
		prevall.each(function(i,n){
			var t=$('a:eq(0) span',$(n)).text();
			$('#tabs').tabs('close',t);
		});
		return false;
	});

	//退出
	$("#mm-exit").click(function(){
		$('#mm').menu('hide');
	})
}

$(function() {
	tabCloseEven();
	/*
	$('.cs-navi-tab').click(function() {
		var $this = $(this);
		var href = $this.attr('src');
		var title = $this.text();
		addTab(title, href);
	});
	*/
});