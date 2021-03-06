<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/12
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>微官网</title>
    <meta name="viewport" content="width=device-width,height=device-height,inital-scale=1.0,maximum-scale=1.0,user-scalable=no;">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="format-detection" content="telephone=no">

    <link href="css/iscroll.css" rel="stylesheet" type="text/css"/>
    <link href="css/cate.css" rel="stylesheet" type="text/css"/>

    <script src="js/iscroll.js" type="text/javascript"></script>
    <script type="text/javascript">
        var myScroll;

        function loaded() {
            myScroll = new iScroll('wrapper', {
                snap: true,
                momentum: false,
                hScrollbar: false,
                onScrollEnd: function() {
                    document.querySelector('#indicator > li.active').className = '';
                    document.querySelector('#indicator > li:nth-child(' + (this.currPageX + 1) + ')').className = 'active';
                }
            });

        }

        document.addEventListener('DOMContentLoaded', loaded, false);
    </script>
</head>
<body id="cate14">

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
    var playbox = (function(){
        //author:eric_wu
        var _playbox = function(){
            var that = this;
            that.box = null;
            that.player = null;
            that.src = null;
            that.on = false;
            //
            that.autoPlayFix = {
                on: true,
                //evtName: ("ontouchstart" in window)?"touchend":"click"
                evtName: ("ontouchstart" in window)?"touchstart":"mouseover"

            }

        }
        _playbox.prototype = {
            init: function(box_ele){
                this.box = "string" === typeof(box_ele)?document.getElementById(box_ele):box_ele;
                this.player = this.box.querySelectorAll("audio")[0];
                this.src = this.player.src;
                this.init = function(){return this;}
                this.autoPlayEvt(true);
                return this;
            },
            play: function(){
                if(this.autoPlayFix.on){
                    this.autoPlayFix.on = false;
                    this.autoPlayEvt(false);
                }
                this.on = !this.on;
                if(true == this.on){
                    this.player.src = this.src;
                    this.player.play();
                }else{
                    this.player.pause();
                    this.player.src = null;
                }
                if("function" == typeof(this.play_fn)){
                    this.play_fn.call(this);
                }
            },
            handleEvent: function(evt){
                this.play();
            },
            autoPlayEvt: function(important){
                if(important || this.autoPlayFix.on){
                    document.body.addEventListener(this.autoPlayFix.evtName, this, false);
                }else{
                    document.body.removeEventListener(this.autoPlayFix.evtName, this, false);
                }
            }
        }
        //
        return new _playbox();
    })();

    playbox.play_fn = function(){
        this.box.className = this.on?"btn_music on":"btn_music";
    }
</script>

<script type="text/javascript">
    $(document).ready(function(){
        playbox.init("playbox");
    });

</script>

<style type="text/css">
    .btn_music{display:inline-block;width:35px;height:35px;background:url('images/play.png') no-repeat center center;background-size:100% auto;position:absolute;z-index:100;left:15px;top:20px;}
    .btn_music.on{background-image: url("images/stop.png");}
</style>

<span id="playbox" class="btn_music" onclick="playbox.init(this).play();"><audio id="audio" loop src="images/4.mp3"></audio></span>

<div class="banner">
    <div id="wrapper">
        <div id="scroller">
            <ul id="thelist">
                <li style="background-image:url('images/2.jpg');background-attachment: inherit;background-repeat:no-repeat;background-size:cover;-moz-background-size:cover;-webkit-background-size:cover; background-position: center center ">
                </li><li style="background-image:url('images/1.jpg');background-attachment: inherit;background-repeat:no-repeat;background-size:cover;-moz-background-size:cover;-webkit-background-size:cover; background-position: center center ">
            </li><li style="background-image:url('images/9.jpg');background-attachment: inherit;background-repeat:no-repeat;background-size:cover;-moz-background-size:cover;-webkit-background-size:cover; background-position: center center ">
            </li><li style="background-image:url('images/8.jpg');background-attachment: inherit;background-repeat:no-repeat;background-size:cover;-moz-background-size:cover;-webkit-background-size:cover; background-position: center center ">
            </li><li style="background-image:url('images/7.jpg');background-attachment: inherit;background-repeat:no-repeat;background-size:cover;-moz-background-size:cover;-webkit-background-size:cover; background-position: center center ">
            </li>					</ul>
        </div>
    </div>


    <div class="clr">
    </div>
</div>

<div class="mainmenu">
    <ul>
        <li>
            <div class="menubtn">
                <a href="/">
                    关于我们						</a>
            </div>
        </li><li>
        <div class="menubtn">
            <a href="/">
                新闻中心						</a>
        </div>
    </li><li>
        <div class="menubtn">
            <a href="/">
                产品展示						</a>
        </div>
    </li><li>
        <div class="menubtn">
            <a href="/">
                成功案例						</a>
        </div>
    </li><li>
        <div class="menubtn">
            <a href="/">
                下载中心						</a>
        </div>
    </li><li>
        <div class="menubtn">
            <a href="/">
                人才招聘						</a>
        </div>
    </li><li>
        <div class="menubtn">
            <a href="/">
                联系我们						</a>
        </div>
    </li><li>
        <div class="menubtn">
            <a href="/">
                在线留言						</a>
        </div>
    </li>
        <div id="insert2">
        </div>
        <div class="clr">
        </div>
    </ul>
</div>

<script type="text/javascript">
    var count = document.getElementById("thelist").getElementsByTagName("li").length;

    for(i=0;i<count;i++){
        document.getElementById("thelist").getElementsByTagName("li").item(i).style.width = document.documentElement.clientWidth+"px";
        document.getElementById("thelist").getElementsByTagName("li").item(i).style.height = document.documentElement.clientHeight+"px";
    }
    document.getElementById("scroller").style.cssText = " width:"+document.documentElement.clientWidth*count+"px";

    setInterval(function(){
        myScroll.scrollToPage('next', 0,400,count);
    },3500 );

    window.onresize = function(){
        for(i=0;i<count;i++){
            document.getElementById("thelist").getElementsByTagName("li").item(i).style.width = document.documentElement.clientWidth+"px";
            document.getElementById("thelist").getElementsByTagName("li").item(i).style.height = document.documentElement.clientHeight+"px";
            //document.getElementById("thelist").getElementsByTagName("img").item(i).style.width = document.documentElement.clientWidth+"px";
            //document.getElementById("thelist").getElementsByTagName("img").item(i).style.height = document.documentElement.clientHeight+"px";
        }
        document.getElementById("scroller").style.cssText = " width:"+document.documentElement.clientWidth*count+"px";
    }
</script>

<div class="copyright">Copyright © Ray All rights reserved.</div>

<style type="text/css">
    body{margin-bottom:60px !important;}
    ul, li{list-style:none;margin:0;padding:0 }

    .top_bar{position:fixed;bottom:0;left:0px;z-index:900;-webkit-tap-highlight-color:rgba(0, 0, 0, 0);font-family:Helvetica, Tahoma, Arial, Microsoft YaHei, sans-serif;}
    .plug-menu{-webkit-appearance:button;display:inline-block;width:36px;height:36px;border-radius:36px;position:absolute;bottom:17px;left:17px;z-index:999;box-shadow:0 0 0 4px #FFFFFF, 0 2px 5px 4px rgba(0, 0, 0, 0.25);background-color:#B70000;-webkit-transition:-webkit-transform 200ms;-webkit-transform:rotate(1deg);color:#fff;background-image:url('images/plug.png');background-repeat:no-repeat;-webkit-background-size:80% auto;background-size:80% auto;background-position:center center;}
    .plug-menu:before{font-size:20px;margin:9px 0 0 9px;}
    .plug-menu:checked{-webkit-transform:rotate(135deg);}
    .top_menu{margin-left:-45px;}
    .top_menu>li{min-width:86px;padding:0 10px;height:32px;border-radius:32px;box-shadow:0 0 0 3px #FFFFFF, 0 2px 5px 3px rgba(0, 0, 0, 0.25);background:#B70000;margin-bottom:23px;margin-left:23px;z-index:900;transition:all 200ms ease-out;-webkit-transition:all 200ms ease-out;}
    .top_menu>li:last-child{margin-bottom:80px;}
    .top_menu>li a{color:#fff;font-size:20px;display:block;height:100%;line-height:33px;text-indent:26px;text-decoration:none;position:relative;font-size:16px;text-overflow:ellipsis;white-space:nowrap;overflow:hidden;}
    .top_menu>li a img{display:block;width:24px;height:24px;text-indent:-999px;position:absolute;top:50%;left:10px;margin-top:-13px;margin-left:-12px;}
    .top_menu>li.on:nth-of-type(1){
        -webkit-transform:translate(45px, 0) rotate(0deg);
        transition:all 700ms ease-out;
        -webkit-transition:all 700ms ease-out;
    }
    .top_menu>li.on:nth-of-type(2){
        -webkit-transform:translate(45px, 0) rotate(0deg);
        transition:all 600ms ease-out;
        -webkit-transition:all 600ms ease-out;
    }
    .top_menu>li.on:nth-of-type(3){
        -webkit-transform:translate(45px, 0) rotate(0deg);
        transition:all 500ms ease-out;
        -webkit-transition:all 500ms ease-out;
    }
    .top_menu>li.on:nth-of-type(4){
        -webkit-transform:translate(45px, 0) rotate(0deg);
        transition:all 400ms ease-out;
        -webkit-transition:all 400ms ease-out;
    }
    .top_menu>li.on:nth-of-type(5){
        -webkit-transform:translate(45px, 0) rotate(0deg);
        transition:all 300ms ease-out;
        -webkit-transition:all 300ms ease-out;
    }
    .top_menu>li.on:nth-of-type(6){
        -webkit-transform:translate(45px, 0) rotate(0deg);
        transition:all 200ms ease-out;
        -webkit-transition:all 200ms ease-out;
    }
    .top_menu>li.out:nth-of-type(1){
        -webkit-transform:translate(45px, 280px) rotate(0deg);
        transition:all 600ms ease-out;
        -webkit-transition:all 600ms ease-out;
    }
    .top_menu>li.out:nth-of-type(2){
        -webkit-transform:translate(45px, 235px) rotate(0deg);
        transition:all 500ms ease-out;
        -webkit-transition:all 500ms ease-out;
    }
    .top_menu>li.out:nth-of-type(3){
        -webkit-transform:translate(45px, 190px) rotate(0deg);
        transition:all 400ms ease-out;
        -webkit-transition:all 400ms ease-out;
    }
    .top_menu>li.out:nth-of-type(4){
        -webkit-transform:translate(45px, 145px) rotate(0deg);
        transition:all 300ms ease-out;
        -webkit-transition:all 300ms ease-out;
    }
    .top_menu>li.out:nth-of-type(5){
        -webkit-transform:translate(45px, 100px) rotate(0deg);
        transition:all 200ms ease-out;
        -webkit-transition:all 200ms ease-out;
    }
    .top_menu>li.out:nth-of-type(6){
        -webkit-transform:translate(45px, 55px) rotate(0deg);
        transition:all 100ms ease-out;
        -webkit-transition:all 100ms ease-out;
    }
    .top_menu>li.out{width:20px;height:20px;min-width:20px;border-radius:20px;padding:0;opacity:0;}
    .top_menu>li.out a{display:none;}
</style>

<div class="top_bar" style="-webkit-transform:translate3d(0,0,0)">
    <nav>
        <ul id="top_menu" class="top_menu">
            <input type="checkbox" id="plug-btn" class="plug-menu themeStyle" style="background-color:#FF0000;background-image:url('images/plug.png');border:0px;">
            <li class="themeStyle out" style="background:#FF0000"> <a href="/?wecha_id="><img src="images/plugmenu6.png"><label>首页</label></a></li>
            <li class="themeStyle out" style="background:#FF0000"> <a href="javascript:void(0)"><img src="images/plugmenu5.png"><label>分享</label></a></li>
            <li class="themeStyle out" style="background:#FF0000"> <a href="tel:13888888888"><img src="images/plugmenu1.png"><label>拨号</label></a></li>
            <li class="themeStyle out" style="background:#FF0000"> <a href="javascript:void(0)"><img src="images/plugmenu8.png"><label>短信</label></a></li>
        </ul>
    </nav>
</div>

<script type="text/javascript">
    $(function(){
        $(".plug-menu").click(function(){
            var li = $(this).parents('ul').find('li');
            if(li.attr("class") == "themeStyle on"){
                li.removeClass("themeStyle on");
                li.addClass("themeStyle out");
            }else{
                li.removeClass("themeStyle out");
                li.addClass("themeStyle on");
            }
        });
    });
</script>

</body>
</html>
