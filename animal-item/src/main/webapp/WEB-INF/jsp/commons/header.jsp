<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="/js/base-v1.js" charset="utf-8"></script>
<!--shortcut start-->
<jsp:include page="shortcut.jsp" />
<!--shortcut end-->
<div id="o-header-2013">
	<div class="w" id="header-2013">
		<div id="logo-2013" class="ld"><a href="/" hidefocus="true" clstag="homepage|keycount|home2013|02a"><b></b><img src="/images/cat3.jpg" width="270" height="60" alt="流浪动物"></a></div>
		<!--logo end-->
		<div id="search-2013">
			<div class="i-search ld">
				<ul id="shelper" class="hide">
				</ul>
				<div class="form">
					<input type="text" class="text" accesskey="s" id="key" autocomplete="off" onkeydown="javascript:if(event.keyCode==13) search('key');">
					<input type="button" value="搜索" class="button" onclick="javascript:window.location.href='http://localhost:8083/search.html?q=' + encodeURIComponent(document.getElementById('key').value);return false;" clstag="homepage|keycount|home2013|03a">
				</div>
			</div>
			<div id="hotwords" clstag="homepage|keycount|home2013|03b"></div>
		</div>
		<!--search end-->
		<div id="my360buy-2013">
			<dl>
				<dt class="ld"><s></s><a href="http://localhost:8084/user/showLogin" clstag="homepage|keycount|home2012|04a">我的爱心</a><b></b></dt>
				<dd>
					<div class="loading-style1"><b></b>加载中，请稍候...</div>
				</dd>
			</dl>
		</div>
		<!--my360buy end-->
		<div id="settleup-2013" clstag="homepage|keycount|home2013|05a">
			<dl>
				<dt class="ld"><s></s><span class="shopping"><span id="shopping-amount"></span></span><a href="http://localhost:8085/cart/cart.html" id="settleup-url">查看我想收养</a> <b></b> </dt>
<!-- 				<dd>
					<div class="prompt">
						<div class="loading-style1"><b></b>加载中，请稍候...</div>
					</div>
				</dd>
 -->			</dl>
		</div>
		<!--settleup end-->
	</div>
	<!--header end-->
	<div class="w">
		<div id="nav-2013">
			<div id="categorys-2013" class="categorys-2014">
				<div class="mt ld">
					<h2><a href="http://www.jd.com/allSort.aspx" clstag="homepage|keycount|home2013|06a">全部流浪动物分类<b></b></a></h2>
				</div>
				<div id="_JD_ALLSORT" class="mc">
					<div class="item fore1">
						<span data-split="1"><h3>
								<a href="/products/1.html">狗类</a>
							</h3>
							<s></s></span>
					</div>
					<div class="item fore2">
						<span data-split="1"><h3>
								<a href="/products/74.html">猫类</a>
							</h3>
							<s></s></span>
					</div>
					
					<div class="extra">
						<a {if="" pageconfig.ishome}clstag="homepage|keycount|home2013|0614a"
							{="" if}="" href="http://www.jd.com/allSort.aspx">全部流浪动物分类</a>
					</div>
				</div>
			</div>
			<div id="treasure" clstag="homepage|keycount|home2013|08a"></div>
				<ul id="navitems-2013">
					<li class="fore1" id="nav-home" clstag="homepage|keycount|home2013|07a"><a href="/">首页</a></li>
					<li class="fore2" id="nav-fashion" clstag="homepage|keycount|home2013|07b"><a href="http://www.baidu.com/">土狗</a></li>
					<li class="fore3" id="nav-chaoshi" clstag="homepage|keycount|home2013|07c"><a href="http://www.baidu.com/">泰迪</a></li>
					<li class="fore4" id="nav-tuan" clstag="homepage|keycount|home2013|07d"><a href="http://www.baidu.com/" target="_blank">哈士奇</a></li>
					<li class="fore5" id="nav-auction" clstag="homepage|keycount|home2013|07e"><a href="http://www.baidu.com/">白猫</a></li>
					<li class="fore6" id="nav-shan" clstag="homepage|keycount|home2013|07f"><a href="http://www.baidu.com/" target="_blank">黑猫</a></li>
					<li class="fore7" id="nav-jinrong" clstag="homepage|keycount|home2013|07g1"><a href="http://www.baidu.com/" target="_blank">折耳猫</a></li>
				</ul>
		</div>
	</div>
</div>
<script type="text/javascript">
(function(){if(pageConfig.navId){var object=document.getElementById("nav-"+pageConfig.navId);if(object)object.className+=" curr";}})();
</script>