$(function() {
	getlist();
	/*获取店铺列表*/
	function getlist(e) {
		$.ajax({
			url : "/shopadmin/getshoplist",
			type : "get",
			dataType : "json",
			success : function(data) {
				if (data.success) {
					handleList(data.shopList);
					handleUser(data.user);
				}
			}
		});
	}
	/*显示名字*/
	function handleUser(data) {
		$('#user-name').text(data.name);
	}
	/*获取每个店铺列表的信息并逐行显示*/
	function handleList(data) {
		var html = '';
		data.map(function(item, index) {
			html += '<div class="row row-shop"><div class="col-40">'
					+ item.shopName + '</div><div class="col-40">'
					+ shopStatus(item.enableStatus)
					+ '</div><div class="col-20">'
					+ goShop(item.enableStatus, item.shopId) + '</div></div>';

		});
		$('.shop-wrap').html(html);
	}

	function shopStatus(status) {
		if (status == 0) {
			return '审核中';
		} else if (status == -1) {
			return '店铺非法';
		} else if (status == 1) {
			return '审核通过';
		}
	}
	/*方便进入店铺的管理页面里面去*/
	function goShop(status, id) {
		if (status == 1) {
			return '<a href="/shopadmin/shopmanagement?shopId=' + id
					+ '">进入</a>';
		} else {
			return '';
		}
	}
});