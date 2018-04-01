(function ($) {
    var ms = {
        init: function (obj, args) {
            return (function () {
                ms.fillHtml(obj, args);
                ms.bindEvent(obj, args);
            })();
        },
        //填充html
        fillHtml: function (obj, args) {
            return (function () {
                var layerHtml = "";
                if (args.Shade == true) {
                    layerHtml += '<div class="share_layer_shade"></div>';
                }
                layerHtml += '<div class="share_layer_box" id="layer_' + args.Content + '">';
                layerHtml += '<h3><b class="text">' + args.Title + '</b><a class="close"></a></h3>';
                layerHtml+='<div style="font-size: 18px; padding-bottom:10px;;"> 请选择美甲类型: </div>'
                layerHtml += '<div class="danxuan" type="inpit/assembly" formname="leixing" style="margin-left: 15px">'+"<div class=\"li\" checkbox=\"\" index=\"0\">\n" +
                    "\t\t\t\t\t\t\t<div name=\"type\" value=\"造型\" style='font-size: 15px'>\n" +
                    "\t\t\t\t\t\t\t\t<h2>造型</h2>\n" +
                    "\t\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\t\t<div name=\"type\" value=\"蔻丹\" style='font-size: 15px'>\n" +
                    "\t\t\t\t\t\t\t\t<h2>蔻丹</h2>\n" +
                    "\t\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\t\t<div name=\"type\" value=\"仓鼠\" style='font-size: 15px'>\n" +
                    "\t\t\t\t\t\t\t\t<h2>光疗甲油胶（本甲）</h2>\n" +
                    "\t\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\t\t<div name=\"type\" value=\"猫头鹰\" style='font-size: 15px'> \n" +
                    "\t\t\t\t\t\t\t\t<h2>琉璃甲和法拉利</h2>\n" +
                    "\t\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\t\t<div name=\"type\" value=\"猫头鹰\" style='font-size: 15px'>\n" +
                    "\t\t\t\t\t\t\t\t<h2>延长光甲</h2>\n" +
                    "\t\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\t</div>"
                // layerHtml += '<li title="分享到新浪微博"><a class="share-xl-weiBo">分享到QQ空间</a><span></span></li>';

                layerHtml += '</div></div>';
                var bod = $('body')
                // $($.parseHTML(bod, document, true)).prepend(layerHtml);
                $($.parseHTML(layerHtml, document, true)).appendTo("body");



            })();
        },
        //绑定事件
        bindEvent: function (obj, args) {
            return (function () {
                var $shareLayerBox = $('.share_layer_box');
                var $shareLayerShade = $('.share_layer_shade');
                var $ShareLi = $('#Share li');

                if (args.Event == "unload") {
                    $('#layer_' + args.Content).animate({
                        opacity: 'show',
                        marginTop: '-80%'
                    }, "fast", function () {
                        $($shareLayerShade).show();
                    });
                } else {
                    $(obj).on(args.Event, function () {
                        $('#layer_' + args.Content).animate({
                            opacity: 'show',
                            marginTop: '40px',
                            bottom:'+=100px'
                        }, "fast", function () {
                            $($shareLayerShade).show();
                        });
                    });
                }


                $($ShareLi).each(function () {
                    $(this).hover(function () {
                        $(this).find('a').animate({marginTop: 2}, 'easeInOutExpo');
                        $(this).find('span').animate({opacity: 0.2}, 'easeInOutExpo');
                    }, function () {
                        $(this).find('a').animate({marginTop: 12}, 'easeInOutExpo');
                        $(this).find('span').animate({opacity: 1}, 'easeInOutExpo');
                    });
                });

                $('.share_layer_box .close').on('click', function () {
                    $($shareLayerBox).animate({
                        opacity: 'hide',
                        marginTop: '-30%'
                    }, "fast","swing", function () {
                        $($shareLayerShade).hide();
                    });
                });

                var share_url = encodeURIComponent(location.href);
                var share_title = encodeURIComponent(document.title);

                //qq空间
                $($ShareLi).find('a.share-qq').on('click', function () {
                    window.open("http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?url=" + share_url + "&title=" + share_title, "newwindow");
                });

                //新浪微博
                $($ShareLi).find('a.share-xl-weiBo').on('click', function () {
                    var param = {
                        url: share_url,
                        title: share_title,
                        rnd: new Date().valueOf()
                    };
                    var temp = [];
                    for (var p in param) {
                        temp.push(p + '=' + encodeURIComponent(param[p] || ''))
                    }
                    window.open('http://v.t.sina.com.cn/share/share.php?' + temp.join('&'));
                });

                //人人
                $($ShareLi).find('a.share-people').on('click', function () {
                    window.open('http://widget.renren.com/dialog/share?resourceUrl=' + share_url + '&title=' + share_title + '&images=' + '', 'newwindow');
                });

                //腾讯微博
                $($ShareLi).find('a.share-tx-weiBo').on('click', function () {
                    window.open('http://share.v.t.qq.com/index.php?c=share&a=index&title=' + share_title + '&url=' + share_url + '', 'newwindow');
                });

                // 微信
                $('.share-code').mouseover(function () {
                    $('#layerWxcode').addClass('js-show-up');
                    $('#xtag').attr('src', 'http://sc.chinaz.com/Files/pic/indexpic/newjiaoben4.jpg');
                }).mouseout(function () {
                    $('#layerWxcode').toggleClass('js-show-up');
                });
            })();
        }
    };
    $.fn.shareConfig = function (options) {
        var args = $.extend({
            Shade: true,
            Event: "click",
            Content: "Share",
            Title: "分享"
        }, options);
        ms.init(this, args);
    };



})(jQuery);
