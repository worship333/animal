<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<meta http-equiv="pragma" content="no-cache" />
    <meta http-equiv="cache-control" content="no-cache" />
    <meta http-equiv="expires" content="0" /> 
    <meta name="format-detection" content="telephone=no" />  
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" /> 
    <meta name="format-detection" content="telephone=no" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>流浪动物之家</title>
	<!--结算页面样式-->	
	<link rel="stylesheet" type="text/css" href="/css/base.css" media="all" />
    <link type="text/css" rel="stylesheet"  href="/css/order-commons.css" source="widget"/>	
	<script type="text/javascript" src="/js/jquery-1.6.4.js"></script>
	<script type="text/javascript" src="/js/base.js"></script>	
	<script type="text/javascript" src="/js/order.common.js"></script>
	<script type="text/javascript" src="/js/jquery.checkout.js"></script>
</head>	<body id="mainframe">
<jsp:include page="commons/shortcut.jsp" />
<!--shortcut end-->

<div class="w w1 header clearfix">
    <div id="logo"><a href="/"><img src="/images/ego-logo.gif" alt="流浪动物之家"></a></div>
</div>

<form id="orderForm" class="hide" action="http://localhost:8086/order/create.html" method="post">
		<input type="hidden" name="paymentType" value="1"/>
		<c:forEach items="${cartList }" var="cart" varStatus="status">
			<c:set var="totalPrice"  value="${ totalPrice + (cart.price * cart.num)}"/>
			<input type="hidden" name="orderItems[${status.index}].itemId" value="${cart.id}"/>
			<input type="hidden" name="orderItems[${status.index}].num" value="${cart.num }"/>
			<input type="hidden" name="orderItems[${status.index}].price" value="${cart.price}"/>
			<input type="hidden" name="orderItems[${status.index}].totalFee" value="${cart.price * cart.num}"/>
			<input type="hidden" name="orderItems[${status.index}].title" value="${cart.title}"/>
			<input type="hidden" name="orderItems[${status.index}].picPath" value="${cart.images[0]}"/>
		</c:forEach>
		<input type="hidden" name="payment" value="<fmt:formatNumber groupingUsed="false" maxFractionDigits="2" minFractionDigits="2" value="${totalPrice/100 }"/>"/>
		<input type="hidden" name="orderShipping.receiverName" value="smallming"/>
		<input type="hidden" name="orderShipping.receiverMobile" value="15891588888"/>
		<input type="hidden" name="orderShipping.receiverState" value="北京"/>
		<input type="hidden" name="orderShipping.receiverCity" value="北京"/>
		<input type="hidden" name="orderShipping.receiverDistrict" value="昌平区"/>
		<input type="hidden" name="orderShipping.receiverAddress" value="西三旗 xxxxxxxxx"/>
</form>

<!-- main -->
<div id="container">
	<div id="content" class="w">
		<div class="m">
			<div class="mc">
				<div class="checkout-steps">
<!--  /widget/consignee-step/consignee-step.tpl -->

<div class="step-cont">
	<div class="consignee-list" id="consignee-list1">
		<a href="#none" id="prev" class="prev arrow-btns"></a>
		<a href="#none" id="next" class="next arrow-btns"></a>
		<div id="consignee1" class="list-cont ui-switchable-body">
            <div id="consignee-ret"></div>
   			<ul class="ui-switchable-panel-main" id="consignee-list">
				<!---->
				<li class="ui-switchable-panel" id="consignee_index_137617472"
					selected="selected" style="cursor: pointer;">
					<div class="consignee-item item-selected"
						consigneeId="137617472" id="consignee_index_div_137617472">
						<b></b>
						<div class="user-name">
							<div class="fl">
								<strong limit="4">smallming</strong>&nbsp;&nbsp;收
							</div>
							<div class="fr">158****8888</div>
							<div class="clr"></div>
						</div>
					</div>
				</li>
				<!---->
			</ul>
		</div>
	</div>
</div>
<!--/ /widget/consignee-step/consignee-step.tpl -->
	
<!--/ /widget/shopping-list/shopping-list.tpl -->
<div id="shipAndSkuInfo">
  <div id="payShipAndSkuInfo">
    <div class="step-tit">
	<h3>支付方式</h3>
</div>

<!--/ /widget/payment-step/payment-step.tpl -->
<div class="step-tit">
	<div class="extra-r">
					<a href="/cart/show.html" id="cartRetureUrl" class="return-edit ftx-05">返回修改购物车</a>
			</div>
</div>
<div class="step-cont" id="skuPayAndShipment-cont">
	<!--添加流浪动物清单  -->
<div class="shopping-lists" id="shopping-lists"> 
<div class="shopping-list ABTest">
	<div class="goods-list">
     <!--配送方式-->
    <h4 class="vendor_name_h" id="0">机构：流浪动物之家</h4>		         
    <div class="goods-suit goods-last">
	 <c:forEach items="${cartList }" var="cart">
		<div class="goods-item goods-item-extra">

			<div class="p-img">
				<a target="_blank" href="/item/${cart.id}.html">
					<img src="${cart.images[0]}" alt="">
				</a>
			</div>
			<div class="goods-msg">
				<div class="p-name">
					<a href="/item/${cart.id}.html" target="_blank">
						${cart.title } 
					</a>
				</div>
			</div>
			<div class="clr"></div>
		</div>
	</c:forEach>
	</div>                   
</div>
<!--goods-list 结束-->
<div class="dis-modes">
	<!--配送方式-->
	<div class="mode-item mode-tab">
		<h4>
			配送方式：（<a id="jd-goods-item" class="ftx-05 alink"
				href="#none">对应流浪动物</a>）
		</h4>
		<div class="mode-tab-nav">
			<ul>
				<li class="mode-tab-item " id="jd_shipment_item"
					onclick="doSwithTab('pay')"><span
					id="jdShip-span-tip" class="m-txt">流浪动物<i
						class='qmark-icon qmark-tip'
						data-tips='可以自己到我们的流浪动物机构来取'></i></span><b></b></li>
			</ul>
		</div>
	</div>
</div>
<!--dis-modes 结束-->
<div class="clr"></div>

</div>	
				
</div>
</div>  
</div>
</div>			
<!--  /widget/invoice-step/invoice-step.tpl -->

	</div>
</div>
<!--/ /widget/order-summary/order-summary.tpl -->
					
<!--  /widget/checkout-floatbar/checkout-floatbar.tpl -->
<div class="trade-foot">
  <div id="checkout-floatbar" class="group">
    <div class="ui-ceilinglamp checkout-buttons">
      <div class="sticky-placeholder hide" style="display: none;">
      </div>
      <div class="sticky-wrap">
      	
        <span id="submit_message" style="display:none" class="submit-error" ></span>
		  	<div class="submit-check-info" id="submit_check_info_message" style="display:none"></div>
    	</div>
    </div>
  </div>
  
        </div>
      </div>
    </div>

  </div>
</div>

<!-- /main -->
	<jsp:include page="commons/footer.jsp" />
	</body>
</html>