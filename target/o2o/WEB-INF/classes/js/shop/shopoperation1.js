/*
*
* */
$(function () {
    var shopId = getQueryString('shopId');//获取shopId
    var isEdit = shopId ? true : false;
    var initUrl = '/shopadmin/getshopinitinfo';//获取店铺的分类以及区域信息的
    var registerShopUrl = '/shopadmin/registershop';//获取注册店铺的信息
    var shopInfoUrl = '/shopadmin/getshopbyid?shopId=' + shopId;
    var editShopUrl = '/shopadmin/modifyshop';
    /*在js文件加载时，调用函数方法*/
    if (!isEdit) {
        getShopInitInfo();
    } else {
        getShopInfo(shopId);
    }

    // 通过店铺Id获取店铺信息
    function getShopInfo(shopId) {//根据传入的id获取区域的信息和区域列表的信息
        $.getJSON(shopInfoUrl, function (data) {
            if (data.success) {
                // 若访问成功，则依据后台传递过来的店铺信息为表单元素赋值
                var shop = data.shop;
                $('#shop-name').val(shop.shopName);
                $('#shop-addr').val(shop.shopAddr);
                $('#shop-phone').val(shop.phone);
                $('#shop-desc').val(shop.shopDesc);
                // 给店铺类别选定原先的店铺类别值
                var shopCategory = '<option data-id="'
                    + shop.shopCategory.shopCategoryId + '" selected>'
                    + shop.shopCategory.shopCategoryName + '</option>';
                var tempAreaHtml = '';
                data.areaList.map(function (item, index) {
                    tempAreaHtml += '<option data-id="' + item.areaId + '">'
                        + item.areaName + '</option>';
                });
                $('#shop-category').html(shopCategory);
                $('#shop-category').attr('disabled', 'disabled');
                $('#area').html(tempAreaHtml);
                $("#area option[data-id='" + shop.area.areaId + "']").attr(
                    "selected", "selected");
            }
        });
    }

    function getShopInitInfo() {//获取店铺的基本信息
        $.getJSON(initUrl, function (data) {
            if (data.success) {
                var tempHtml = '';
                var tempAreaHtml = '';
                data.shopCategoryList.map(function (item, index) {
                    tempHtml += '<option data-id="' + item.shopCategoryId + '">' + item.shopCategoryName + '</option>';
                });
                data.areaList.map(function (item, index) {
                    tempAreaHtml += '<option data-id="' + item.areaId + '">' + item.areaName + '</option>>';
                });
                $('#shop-category').html(tempHtml);
                $('#area').html(tempAreaHtml);
            }
        });
    }
    //提交按钮的事件响应，分别对店铺注册和编辑操作做不同的响应
    $('#submit').click(function () {
        //创建shop对象
        var shop = {};
        if (isEdit) {//如果属于编辑则给shopId赋值
            shop.shopId = shopId;
        }
        //获取表单里的数据并填充进对应的店铺属性中
        shop.shopName = $('#shop-name').val();
        shop.shopAddr = $('#shop-addr').val();
        shop.phone = $('#shop-phone').val();
        shop.shopDesc = $('#shop-desc').val();
        //选择选定好的店铺类别
        shop.shopCategory = {
            shopCategoryId: $('#shop-category').find('option').not(function () {
                return !this.selected;
            }).data('id')
        };

        /*接收验证码*/
        var shopImg = $('#shop-img')[0].files[0];
        var formData = new FormData();
        formData.append('shopImg', shopImg);
        formData.append('shopStr', JSON.stringify(shop));
        //获取表单里输入的验证码
        var verifyCodeActual = $('#j_captcha').val();
        if (!verifyCodeActual) {
            $.toast('请输入验证码！');
            return;
        }
        /*如果不为空那么就传入后台*/
        formData.append('verifyCodeActual', verifyCodeActual);
        $.ajax({
            url: (isEdit ? editShopUrl : registerShopUrl),
            type: 'POST',
            data: formData,
            contentType: false,
            processData: false,
            cache: false,
            success: function (data) {
                /*                   alert(data);*/
                if (data.success) {
                    $.toast('提交成功！');
                } else {
                    $.toast('提交失败！' + data.errMsg);
                }
                alert("执行了");
                /*点击验证码图片的时候，注册码会改变*/
                $('#captcha_img').click();
            }
        });
    });
})
