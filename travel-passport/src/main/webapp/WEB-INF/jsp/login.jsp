<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script type="text/javascript">var NREUMQ=NREUMQ||[];NREUMQ.push(["mark","firstbyte",new Date().getTime()]);</script>
    <title>用户登录 - 途牛通行证</title>
    <meta name="description" content="途牛旅游网：中国最大的旅游行业在线电子商务网站，为您提供最为周到的旅游服务。途牛旅游网" />
    <meta name="keywords" content="会员登录" />

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/sitev2.css
">
</head>
<body id="index1200" class="index1200">
<!-- common header start -->
<div class="header">
    <div class="header_common">
        <div class="header_inner">
            <div class="site_logo">
                <a href="http://www.tuniu.com">
                    <img height="41" width="150" src="${pageContext.request.contextPath}/picture/logo.png">
                </a>
            </div>
            <div class="site_phone">
                &nbsp;
                <!--
                <a href="http://www.tuniu.com/corp/searchcompany.shtml">
                    <img height="41" width="145" src="picture/tn_phone.png">
                </a>
                -->
            </div>
            <div>
                <noscript>
                    <h1 class="head_notice_tips">您的浏览器禁用了javascript脚本，导致登录功能无法使用，请您先开启以后再使用登录功能。</h1>
                </noscript>
                <p class="head_notice_tips" style="display: none;">
                    您的浏览器禁用了cookie，开启Cookie之后才能登录，
                    <a href='javascript:void(0)' id='howEnableCookie' style="color:rgb(3, 189, 252);">
                        如何开启?
                    </a>
                </p>
            </div>
        </div>
    </div>  </div>
<div id="loginWrap" class="wrap" style="background-image: url('http://m.tuniucdn.com/fb2/t1/G2/M00/A1/A3/Cii-T1f4lhCITSjhAAMhh0OTedQAADJqwM5SCIAAyGf70.jpeg');">
    <div id="content" class="content">
        <div id="cent_link" class="cent_link">
            <a style="display:block;" target="_blank" id="bg_img"></a>
        </div>

        <input type="hidden" id="errLoginType" value="P-N"/>
        <input type="hidden" id="errLoginMsg" value=""/>
        <div id="login-content" class="login-content" style="background-color: #fff;">
            <div id="login-box" class="login-box-inner">
                <ul id="login-tab" class="login-tab">
                    <li id="login-tab-user" class="login-tab-li cur">账户登录<b></b></li>
                    <li id="login-tab-pass" class="login-tab-li">扫码登录<b></b></li>
                </ul>
                <div id="qr-login" class="qr-login login-table hidden">
                    <div class="qr-title">
                        <img class="sweep-img" src="${pageContext.request.contextPath}/picture/sweep.png">
                        扫码登录，更快，更安全
                    </div>
                    <div class="login-tip">
                        <div id="login_error3" class="error login_error"></div>
                    </div>
                    <div class="qr-content">
                        <div class="qr-img-div">
                            <img class="qr-img">
                            <div class="re_btn hidden">点击刷新</div></div>
                        <img src="${pageContext.request.contextPath}/picture/qrtips.png" class="tip-img">
                    </div>
                    <div class="qr-text">打开途牛app扫二维码登录</div>
                    <div class="action-box">
                        <a class="app-btn" style="float:left;">下载途牛app</a>
                        <a href="${pageContext.request.contextPath}/register" class="reg_btn qr-rg-btn">新用户送礼，<span class="reg_type">立即注册  &gt;</span></a>
                    </div>
                </div>
                <div id="account-login" class="account-login">
                    <!-- 途牛会员登录 form start -->
                    <form action="#" method="post" id="loginNormal" onsubmit="return false;">
                        <div class="login-tab-content" id="login-tab-content0">
                            <table class="login-table">
                                <tr>
                                    <td class="login-tip">
                                        <div id="login_error" class="error login_error" style="display: none;"></div>
                                    </td>
                                </tr>
                                <tr id="line_1" class="line_1">
                                    <td>
                                        <!-- 国际 手机号码 区号 -->
                                        <div class="input_div input_div_left J_input_left" style="display: none;">
                                            <input class="J_zoneHid" type="hidden" name="intlCode" value="" />
                                            <div class="zone_val J_zoneVal" data-country="中国" data-zone="0086">中国 0086</div>
                                            <div class="zone_tri J_zoneVal"  data-country="中国" data-zone="0086"></div>
                                            <div class="zones J_Zones" style="display: none;">
                                                <div class="zones_title">
                                                </div>
                                                <div class="zones_tabcont J_zonesTabcont">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="input_div J_input_right">  <!-- 国际登录: .input_div_right -->
                                            <input id="normal_tel" type="text" name="username" autocomplete="off" tabindex="1" class="txt txt-m txt-focus cgrey2 tel" placeholder="用户名"/>
                                        </div>
                                    </td>
                                </tr>
                                <tr id="line_2" class="line_2">
                                    <td>
                                        <div class="input_div">
                                            <input id="normal_pass" type="password" name="password" autocomplete="off" tabindex="2" class="txt txt-m" placeholder="密码"/>
                                        </div>
                                    </td>
                                </tr>
                                <tr class="line_4">
                                    <td class="cgrey2 line2">
                                        <label style="vertical-align:middle;float:left;"><input type="checkbox" class="remember_me" tabindex="4" name="remember_me" id="rememberme2" value="1"  style="vertical-align:middle"/>&nbsp;两周内自动登录</label>
                                        <a href="javascript:void(0)" id="goDynamic" class="search_psw">
                                            <img class="switchTab" src="${pageContext.request.contextPath}/picture/mobile.png">
                                            手机动态密码登录？
                                        </a>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="line2">
                                        <input id="login" type="button" value="登录" name="submit_login" tabindex="5" class="sub" />
                                    </td>
                                </tr>
                                <tr>
                                    <td class="cgrey2 line2">
                                        <a href="/forget/choosenType" style="float:left;" target="_self">忘记密码</a>
                                        <a href="/register" class="reg_btn">新用户送礼，<span class="reg_type">立即注册  &gt;</span></a>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </form>
                    <!-- 途牛会员登录 form end -->
                    <!-- 动态密码登录 form start -->
                    <form action="/login/post" method="post" id="loginTel" onsubmit="return false;">
                        <input type="hidden" name="login_type" value="P-M">
                        <div class="login-tab-content hidden" id="login-tab-content1">
                            <table class="login-table">
                                <tr>
                                    <td class="login-tip">
                                        <div id="login_error3" class="error login_error" style="display: none ;">
                                        </div>
                                    </td>
                                </tr>
                                <tr id="line_8" class="line_8">
                                    <td>
                                        <!-- 变成了 国际 手机号码 + 区号 -->
                                        <div class="input_div input_div_left J_input_left_2">
                                            <input class="J_zoneHid" id="intlCode"  type="hidden" name="intlCode" value="0086" />
                                            <div class="zone_val J_zoneVal_2" data-country="中国" data-zone="0086">中国 0086</div>
                                            <div class="zone_tri J_zoneVal_2"  data-country="中国" data-zone="0086"></div>
                                            <div class="zones J_Zones_2" style="display: none;">
                                                <div class="zones_title">

                                                </div>
                                                <div class="zones_tabcont J_zonesTabcont_2" >
                                                </div>
                                            </div>
                                        </div>
                                        <div class="input_div input_div_right">
                                            <input id="telNum" maxlength="11" type="text" autocomplete="off" tabindex="1" name="username" class="txt txt-m txt-focus cgrey2 tel"  placeholder="手机号码" />
                                        </div>
                                    </td>
                                </tr>
                                <tr id="line_9" class="line_9" style="display: none">
                                    <td>
                                        <div class="input_div">
                                            <input type="text" maxlength="4" style="ime-mode:disabled;" class="txt txt-m" tabindex="2" name="identify_code" id="identify" placeholder="验证码">
                                            <div class="identify_box">
                                                <img width="24" height="24" class="loadingImg" src="${pageContext.request.contextPath}/picture/loading1.gif" />
                                                <a onclick="return false;" title="如验证码无法辨别，点击即可刷新。" href="javascript:void(0);">
                                                    <img align="absmiddle" width="80" height="24" style="display:none;" alt="如验证码无法辨别，点击即可刷新。" class="identify_img" src="" />
                                                </a>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr id="line_10" class="line_10">
                                    <td>
                                        <div class="input_div">
                                            <input type="text"  class="txt txt-s tel" tabindex="3" autocomplete="off" name="password" maxlength=6 placeholder="动态密码"/>
                                            <a href="javascript:;" class="code-len get-code">获取动态密码</a>
                                            <a href="javascript:;" class="code-len send-code"><span>60</span>秒后重新发送</a>
                                            <a href="javascript:;" class="code-len send-code-again">重新发送</a>
                                        </div>
                                    </td>
                                </tr>
                                <tr class="line_4">
                                    <td class="cgrey2 line2">
                                        <label style="vertical-align:middle;float:left"><input type="checkbox" class="remember_me" tabindex="4" name="remember_me" id="rememberme2" value="1"  style="vertical-align:middle;"/>&nbsp;两周内自动登录</label>
                                        <a class="search_psw" href="javascript:void(0)" id="goAccount" >
                                            <img class="switchTab" src="picture/account.png">
                                            账户登录
                                        </a>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="line2">
                                        <input type="button" class="sub" tabindex="5" onclick="" name="submit_login" value="登录" />
                                    </td>
                                </tr>
                                <tr>
                                    <td class="cgrey2 line2">
                                        <a href="/forget/choosenType" style="float:left;" target="_self">忘记密码</a>
                                        <a href="/register" class="reg_btn">新用户送礼，<span class="reg_type">立即注册  &gt;</span></a>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </form>
                    <!-- 动态密码登录 form end -->
                </div>
                <div class="partner-login">
                    <div class="partner-title">其它方式登录</div>
                    <div id="weixin" class="partner-box partner-weixin">
                        <img src="picture/weixinv2.png">
                        <span>微信</span>
                    </div>
                    <a href="/login/partner/tencent">
                        <div class="partner-box partner-qq">
                            <img src="picture/qqv2.png">
                            <span>QQ</span>
                        </div>
                    </a>
                    <a href="/login/partner/sina">
                        <div class="partner-box partner-weibo">
                            <img src="picture/weibov2.png">
                            <span>微博</span>
                        </div>
                    </a>
                    <div class="partner-box partner-card partner-last">
                        <img src="picture/cardv2.png">
                        <span>合作卡</span></div>
                </div>
            </div>
        </div>
        <!--合作卡弹出层start-->
        <div id="login-card-wrap" class="login-pop-wrap login-card-wrap">
            <div class="login-box-inner">
                <ul class="login-tab" id="card-login">
                    <li id="login-tab-card" class="cur">合作卡登录<b></b></li>
                </ul>
                <form action="/login/post" method="post" id="loginMemship" onsubmit="return false;">
                    <input type="hidden" name="login_type" value="P-C">
                    <div class="login-tab-content">
                        <table class="login-table card-table">
                            <tr>
                                <td><a href="javascript:void(0)" id="J-card-help" class="card-help">如何添加合作卡？</a></td>
                            </tr>
                            <tr>
                                <td class="login-tip"><div id="login_error2" class="error login_error" style="display: none ;"></div></td>
                            </tr>
                            <tr id="line_5" class="line_5">
                                <td>
                                    <div class="input_div">
                                        <input type="text" autocomplete="off" tabindex="1" name="username" class="txt txt-m txt-focus cgrey2" style="font-size:13px;" placeholder="会籍卡号" />
                                    </div>
                                </td>
                            </tr>
                            <tr id="line_6" class="line_6">
                                <td>
                                    <div class="input_div">
                                        <input type="password" placeholder="密码" autocomplete="off" tabindex="2" name="password" class="txt txt-m" />
                                    </div>
                                </td>
                            </tr>
                            <tr class="line_4">
                                <td class="cgrey2 line2">
                                    <label style="vertical-align:middle float:left;"><input type="checkbox" class="remember_me" tabindex="4" name="remember_me" id="rememberme2" value="1"  style="vertical-align:middle"/>&nbsp;两周内自动登录</label>
                                    <a class="search_psw" href="javascript:void(0)" id="cardToAccont">
                                        <img class="switchTab" src="picture/account.png">
                                        返回账户登录
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td class="line2">
                                    <input type="button" class="sub" tabindex="5" onclick="" name="submit_login" value="登录" />
                                </td>
                            </tr>
                            <tr>
                                <td class="cgrey2 line2">
                                    <a href="/forget/choosenType" style="float:left;" target="_self">忘记密码</a>
                                    <a href="/register" class="reg_btn">新用户送礼，<span class="reg_type">立即注册  &gt;</span></a>
                                </td>
                            </tr>
                        </table>
                    </div>
                </form>
                <div class="partner-login">
                    <div class="partner-title">其它方式登录</div>
                    <div id="weixin" class="partner-box partner-weixin">
                        <img src="picture/weixinv2.png">
                        <span>微信</span>
                    </div>
                    <a href="/login/partner/tencent">
                        <div class="partner-box partner-qq">
                            <img src="picture/qqv2.png">
                            <span>QQ</span>
                        </div>
                    </a>
                    <a href="/login/partner/sina">
                        <div class="partner-box partner-weibo partner-last">
                            <img src="picture/weibov2.png">
                            <span>微博</span>
                        </div>
                    </a>
                </div>
            </div>
            <!--         <div class="change-btn wx-change-btn"></div> -->
        </div>
        <!--合作卡弹出层end-->
        <!-- start 合作卡添加流程 -->
        <div class="df_hezuokahelp_bg">
            <div class="hezuokahelp_bg"></div>
            <div class="d_hezuokahelp">
                <img class="img_niutou" src="picture/niu.png" />
                <div class="d_helpclose"></div>
                <img class="helpimg_liucheng" src="picture/progress.png">
                <table class="help_table">
                    <tbody>
                    <tr>
                        <td>登录账户，点击首页左上方<br />“账户管理”</td>
                        <td>进入我的途牛会员首页<br />在左侧导航栏底部点击“我的合作卡”</td>
                        <td>在合作卡页面点击添加<br />合作卡</td>
                    </tr>
                    </tbody>
                </table>
                <a class="abtn_helpiknow"></a>
            </div>
        </div>
        <!-- end 合作卡添加流程 -->
        <!-- start app下载弹窗 -->
        <div class="app-mask hidden"></div>
        <div class="app-bgm hidden">
            <div class="app-content">
                <div class="app-title">
                    <span class="">下载</span>
                    <img class="app-close" src="picture/close.png">
                </div>
                <div class="app-tips">
                    扫码下载途牛APP，立享<span class="reg_type">超多优惠！</span>
                </div>
                <div class="app-img">
                    <img src="picture/app_niu.png">
                    <img src="picture/app_down.png" >
                </div>
            </div>
        </div>
        <!-- end app下载弹窗 -->
        <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
        <script type="text/javascript" src="js/layer.min.js"></script>
        <script type="text/javascript" src="js/zonesgroup.js"></script>
        <script type="text/ecmascript" src="js/md5.js"></script>
        <script type="text/javascript" src="js/frms-fingerprint.js"></script>
        <script type="text/javascript" src="js/login_checkv2.js"></script>
        <script type="text/javascript">
            $(function() {
                //判断fab是否崩溃
                var isCrash = 0;
                if(isCrash){
                    ShowCrash();
                }
                function ShowCrash() {
                    $("body").append(	'<div class="TipBoxHackBot">'+
                        '<div class="BackHack"></div>'+
                        '<div class="TipBox">'+
                        '<img class="imgTipBox" src="picture/tipbox.png">'+
                        '</div>'+
                        '</div>');
                    $("body .TipBoxHackBot").fadeIn();
                    $("body .TipBoxHackBot .TipBox").animate({
                        marginTop: '-324px'
                    }, 500);
                }

                $("body").delegate("div.BackHack", "click", function(){
                    $("div.TipBoxHackBot").fadeOut(200);
                    window.setTimeout(function(){
                        $("div.TipBoxHackBot").remove();
                    }, 200);
                });

                $("#codeToNormal").bind("click", function() {
                    $("#login-code-wrap").hide();
                    $("#login-content").show();
                });
                $("#login-code-wrap .login-card-close").click(function() {
                    $("#codeToNormal").trigger("click");
                });
                $("#normalToCode").click(function() {
                    $("#login-code-wrap").show();
                    $("#login-content").hide();
                    changeCodeImg();
                    checkLogin();
                });

                //微信扫码登录
                var url = 'https://open.weixin.qq.com/connect/qrconnect?appid=wxd22498dfe03aa2f5&redirect_uri=' +
                    'http://passport.tuniu.com/partner/weixin&response_type=code&scope=snsapi_login&state=3d6be0a4035d839573b04816624a415e#wechat_redirect';
                //url ='http://passport.tuniu.com/partner/weixin';
                $("#weixin").live("click", function () {
                    window.open(url,'微信登录','left=500,top=300,height=550,width=700')
                })
            });
        </script>
        <script src="js/fta.min.js"></script>
        <script type="text/javascript">
            $("#login").on("click",function () {
                $.post(
                    "./user/login",
                    {
                        username:$("#normal_tel").val(),
                        password:$("#normal_pass").val(),
                    },
                    function (res) {
                        if(res){
                            location.href="./index"
                        }else{
                            alert("用户名或密码错误")
                        }
                    }
                )
                return false;
            })
        </script>
        <script>window.FTA && window.FTA("","会员中心:passport:登录","","/会员中心/passport/登录");</script></div>
</div>
<script type='text/javascript'>
    $.ajax({
        url: '/ajax/getCmsImg',
        success: function (res) {
            var arr
            try {
                arr = eval("(" + res + ")");
            } catch (e) {
                arr = [["http://1.tuniu.com/","https://ssl1.tuniucdn.com/u/mainpic/hycenter/2015/1yuan_1.jpg"],["http://www.tuniu.com/zt/sfcf/","https://img3.tuniucdn.com/site/m2015/images/member/events/sfcf.jpg"],["http://temai.tuniu.com/","https://m.tuniucdn.com/fb2/t1/G2/M00/3F/56/Cii-T1e0DPqIFEsNAASX4HCmiwgAABUAgBhf_EABJf447.jpeg"],["http://www.tuniu.com/tucom/","https://m.tuniucdn.com/fb2/t1/G2/M00/3F/53/Cii-Tle0C4qIIG-HAALyJxscqtYAABT-wMCqQwAAvI_73.jpeg"],["http://www.tuniu.com/niuren/","https://ssl2.tuniucdn.com/u/mainpic/hycenter/2015/niupinzhi.jpg"]];
            }
            $flag = parseInt(Math.random()*arr.length,10);

            $('#loginWrap').css("background-image","url("+arr[$flag][1]+")");
            $('#bg_img').attr('href',arr[$flag][0]);
        }
    });
</script>
<script type='text/javascript'>if(!window.navigator.cookieEnabled){$("#howEnableCookie").parent().show();$("#howEnableCookie").click(function(){$.layer({type:1,title:"如何启动COOKIE",time:0,shadeClose:true,maxHeight:200,page:{html:"<div style='padding:10px'><p style='font-size: 18px;font: 20px/47px 'microsoft yahei';'>1. ie浏览器：点击浏览器<b>“工具”</b>——<b>“internet选项”</b>——<b>“隐私”</b>——将<b>“阻止所有cookie”</b>调低级别——点击<b>“保存”</b>——重启浏览器即可正常登录。<br><br>2. chrome浏览器：点击浏览器<b>“设置”</b>——<b>“显示高级设置”</b>——<b>“隐私设置”</b>——<b>“内容设置”</b>——取消<b>“阻止第三方cookie和网站数据”</b>——选择<b>“允许设置本地数据（推荐）”</b>——点击<b>“完成”</b>——重启浏览器即可正常登录。<br><br>3. 火狐浏览器：点击浏览器<b>“选项”</b>——选择<b>“隐私”</b>——<b>“自定义历史记录设置”</b>，取消<b>“始终使用隐私浏览模式”</b>，勾选<b>“接受来自站点的cookie”</b>——点击<b>“确定”</b>——重启浏览器即可生效。</p></div>"},offset:["200px",""],area:["700px","320px"]})})};</script>
<script type="text/javascript" src="js/in-min.js"></script>
<script type="text/javascript">
    $("#TN-faq").hide();
    $(".offer_service").hide();

    var content = "PC:会员:登录";
    //ga数据准备
    var _gaq = _gaq || [];
    _gaq.push(["_setAllowHash", false]);
    _gaq.push(["_setAllowAnchor", true]);
    _gaq.push(["_addOrganic", "baidu", "wd"]);
    _gaq.push(["_addOrganic", "baidu", "word"]);
    _gaq.push(["_addOrganic", "google", "q"]);
    _gaq.push(["_addOrganic", "118114", "kw"]);
    _gaq.push(["_addOrganic", "bing", "q"]);
    _gaq.push(["_addOrganic", "soso", "w"]);
    _gaq.push(["_addOrganic", "youdao", "q"]);
    _gaq.push(["_addOrganic", "sogou", "query"]);
    _gaq.push(["_addOrganic", "360", "q"]);
    _gaq.push(["_addOrganic", "baidu", "w"]);
    _gaq.push(["_addOrganic", "baidu", "q1"]);
    _gaq.push(["_addOrganic", "baidu", "q2"]);
    _gaq.push(["_addOrganic", "baidu", "q3"]);
    _gaq.push(["_addOrganic", "baidu", "q4"]);
    _gaq.push(["_addOrganic", "baidu", "q5"]);
    _gaq.push(["_addOrganic", "baidu", "q6"]);
    _gaq.push(["_addOrganic", "baidu", "q6"]);
    _gaq.push(["_setDomainName", "tuniu.com"]);
    _gaq.push(["_setAccount", "UA-4782081-5"]);
    _gaq.push(["_trackPageview", content]);
    var tuniuTracker = '';
    var init_page_set_time_out = 0;//页面自动加载标记
    In.add('gaAndTac', {path: '//ssl1.tuniucdn.com/j/20140612/common/tac.mini.js,common/ga.js', type: 'js', charset: 'utf-8'});
    In('gaAndTac', function() {
        tuniuTracker = _tat.getTracker();
        tuniuTracker.setPageName("PC:会员:登录");
        tuniuTracker.addOrganic("360", "q");
        tuniuTracker.addOrganic("baidu", "w");
        tuniuTracker.addOrganic("baidu", "q1");
        tuniuTracker.addOrganic("baidu", "q2");
        tuniuTracker.addOrganic("baidu", "q3");
        tuniuTracker.addOrganic("baidu", "q4");
        tuniuTracker.addOrganic("baidu", "q5");
        tuniuTracker.addOrganic("baidu", "q6");
        tuniuTracker.trackPageView();
        tuniuTracker.enableLinkTracking();
    });
    In.add('TN_common_init', {path: '//ssl.tuniucdn.com/j/2014071517/common/jquery-powerFloat.js,common/lazyloadnew.min.js', type: 'js', charset: 'utf-8'});
    In('TN_common_init', function() {
        //图片异步加载。
        $("img").lazyload({
            effect: "fadeIn",
            failurelimit: 50,
            threshold: 300,
            skip_invisible: false
        });
    });
</script><!--start foot-->
<div id="TN-footer">
    <p id="TN-24">24小时客户服务电话(免长途费)：4007-999-999  途牛呼叫中心位于南京来电将统一显示为 025-86859999</p>
    <p id="TN-links">
        <a href="http://www.tuniu.com/corp/aboutus.shtml" target="_blank" rel="nofollow" onclick="tuniuRecorder.push('33_1_2_1_1_1')">关于我们</a>
        <a href="http://ir.tuniu.com" target="_blank" onclick="tuniuRecorder.push('33_1_2_1_1_2')">Investor Relations</a>
        <a href="http://www.tuniu.com/corp/contactus.shtml" target="_blank" rel="nofollow" onclick="tuniuRecorder.push('33_1_2_1_1_3')">联系我们</a>
        <a href="http://www.tuniu.com/corp/advise.shtml" target="_blank" rel="nofollow" onclick="tuniuRecorder.push('33_1_2_1_1_4')">投诉建议</a>
        <a rel="nofollow" href="http://www.tuniu.com/corp/advertising.shtml" target="_blank" onclick="tuniuRecorder.push('33_1_2_1_1_5')">广告服务</a>
        <a rel="nofollow" href="http://www.tuniu.com/giftcard/" target="_blank" onclick="tuniuRecorder.push('33_1_2_1_1_6')">旅游券</a>
        <a rel="nofollow" href="http://tuniu.zhiye.com/" target="_blank" onclick="tuniuRecorder.push('33_1_2_1_1_7')" style="color:red;">途牛招聘</a>
        <a href="http://www.tuniu.com/corp/privacy.shtml" target="_blank" rel="nofollow" onclick="tuniuRecorder.push('33_1_2_1_1_8')">隐私保护</a>
        <a href="http://www.tuniu.com/corp/duty.shtml" target="_blank" rel="nofollow" onclick="tuniuRecorder.push('33_1_2_1_1_9')">免责声明</a>
        <a rel="nofollow" href="http://www.tuniu.com/corp/zizhi.shtml" target="_blank" onclick="tuniuRecorder.push('33_1_2_1_1_10')">旅游度假资质</a>
        <a rel="nofollow" href="http://www.tuniu.com/merchants/" target="_blank" onclick="tuniuRecorder.push('33_1_2_1_1_11')">供应商合作</a>
        <a href="http://www.tuniu.com/corp/agreement.shtml" target="_blank" rel="nofollow" onclick="tuniuRecorder.push('33_1_2_1_1_12')">用户协议</a>
        <a href="http://www.tuniu.com/corp/sitemap.shtml" target="_blank" onclick="tuniuRecorder.push('33_1_2_1_1_13')">网站地图</a>
        <br />
        <a rel="nofollow" href="http://team.tuniu.com/" target="_blank" onclick="tuniuRecorder.push('33_1_2_1_2_1')">团队博客</a>
        <a rel="nofollow" href="http://union.tuniu.com/" target="_blank" onclick="tuniuRecorder.push('33_1_2_1_2_2')">网站联盟</a>
        <a rel="nofollow" target="_blank" href="http://www.tuniu.com/ueip/index.html" onclick="tuniuRecorder.push('33_1_2_1_2_3')">UEIP</a>
        <a rel="nofollow" href="http://www.tuniu.com/help/" target="_blank" onclick="tuniuRecorder.push('33_1_2_1_2_4')">帮助中心</a>
    </p>
    <!-- #TN-links -->
    <p id="copyright">Copyright &copy; 2006-2014
        <a rel="nofollow" href="http://www.tuniu.com" onclick="tuniuRecorder.push('33_1_5_1_1_1')">途牛旅游网</a>
        <a rel="nofollow" href="http://www.tuniu.com" onclick="tuniuRecorder.push('33_1_5_1_1_2')">Tuniu.com</a> |
        <a target="_blank" href="http://www.tuniu.com/corp/company.shtml" rel="nofollow" onclick="tuniuRecorder.push('33_1_5_1_1_3')">营业执照</a> |
        <a target="_blank" href="http://www.miibeian.gov.cn/" rel="nofollow" onclick="tuniuRecorder.push('33_1_5_1_1_4')">ICP证：苏B2-20130006</a>&nbsp;&nbsp;
        <a target="_blank" href="http://www.tuniu.com" onclick="tuniuRecorder.push('33_1_5_1_1_5')">上海旅游网</a>
    </p>
</div>
<!--end foot-->

<!-- common footer end -->

<!-- pop start -->
<div id="card-box" class="card-box hidden">
    <div id="card-box-inner">
        <a href="javascript:void(0);" id="card-close">x</a>
        <table id="card-table">
            <tr>
                <td>请选择合作商家:</td>
            </tr>
            <tr>
                <td>
                    <select id="sel_membcard_name" name="membcard_name" onchange="change_card_tpl();">
                        <option>请选择合作卡类型</option>
                        <option>建行途牛联名信用卡</option><option>中信途牛联名信用卡（2016.6.3之前发卡）</option><option>江苏银行途牛联名信用卡</option><option>建行途牛龙卡借记卡普卡</option><option>建行途牛龙卡借记卡白金卡</option><option>中信途牛联名信用卡（银联金卡，2016.6.3之后发卡）</option><option>中信途牛联名信用卡（银联白金卡，2016.6.3之后发卡）</option><option>中信VISA途牛联名卡经典版</option><option>中信VISA途牛联名卡中美旅游限量版</option><option>工银途牛牛人信用卡金卡</option><option>工银途牛牛人信用卡普卡</option><option>工银途牛牛人信用卡白金卡</option><option>中行途牛白金联名借记卡</option><option>中行途牛联名卡借记卡普卡</option><option>途牛龙卡金卡</option><option>途牛龙卡白金卡</option>                    </select>
                </td>
            </tr>
            <tr>
                <td id="card_id">请输入您的会籍卡号:</td>
            </tr>
            <tr>
                <td><input type="text" id="txt_membcard_id" name="membcard_id" class="txt txt-mm" /></td>
            </tr>
            <tr>
                <td class="cdyellow f13"><div id="errmsg" name="errmsg"></div></td>
            </tr>
            <tr>
                <td id="register"><input type="image" src="https://ssl1.tuniucdn.com/u/user/2011/img/next.png" onclick="active_membcard();"/></td>
            </tr>
        </table>
    </div>
</div><!-- #card box -->
<!-- pop end -->
</body>
</html>