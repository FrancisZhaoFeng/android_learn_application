package constant;

import android.os.Environment;


/**************************************************************************
 * @说明: 常量类
 * @作者: 手机端技术支持组
 * @时间: 2015-05-26
 *************************************************************************/
public class Constant {

    /**
     * Activity界面
     */
    public class Activity {
        /***
         * 桌面
         ***/
        public static final String LAUNCHER = "com.android.launcher3/com.android.launcher3.Launcher";
        /***
         * 浏览器界面
         ***/
        public static final String WEB = "com.android.browser/com.android.browser.BrowserActivity";
        /***
         * 新建信息界面
         ***/
        public static final String COMPOSE_MESSAGE = "com.android.mms/com.android.mms.ui.ComposeMessageActivity";
        /***
         * 邮件登陆界面
         ***/
        public static final String EMAIL_LOGIN = "com.android.email/com.android.email.activity.setup.AccountSetupBasics";
        /***
         * Flyme5邮件登陆界面
         ***/
        public static final String EMAIL_LOGIN_Flyme5 = "com.android.email/com.android.email.activity.setup.AccountSetupSelectActivity";
        /***
         * 新建邮件界面
         ***/
        public static final String NEW_EMAIL = "com.android.email/com.android.email.activity.MessageCompose";
        // /***邮件列表界面***/
        // public static final String EMAIL = "com.android.email/com.android.email.activity.EmailActivity";
        /***
         * 邮件列表界面
         ***/
        public static final String EMAIL = "com.android.email/com.android.email.activity.MessageListActivity";
        /***
         * 微信登陆界面
         ***/
        public static final String WEIXIN_LOGIN = "com.tencent.mm/com.tencent.mm.ui.transmit.SelectConversationUI";
        /***
         * 新建微信界面
         ***/
        public static final String NEW_WEIXIN = "com.tencent.mm/com.tencent.mm.ui.account.SimpleLoginUI";
        /***
         * 初次进入微信界面
         ***/
        public static final String WEIXIN_INITIAL_STRING = "com.tencent.mm/com.tencent.mm.ui.LauncherUI";
        /***
         * 分享蓝牙界面
         ***/
        public static final String BT_SHARE = "com.android.settings/com.android.settings.bluetooth.DevicePickerActivity";
        /***
         * 信息列表界面
         ***/
        public static final String CONVERSATION_LIST = "com.android.mms/com.android.mms.ui.ConversationList";
        /***
         * 文件管理器界面
         ***/
        public static final String FILE_MANAGER = "com.meizu.filemanager/com.meizu.flyme.filemanager.activity.FileManagerActivity";
        /***
         * 文件管理器界面
         ***/
        public static final String FILE_HOME = "com.meizu.filemanager/com.meizu.flyme.filemanager.activity.HomeActivity";
        /***
         * 拨号盘界面
         ***/
        public static final String DIALTACTS = "com.android.dialer/com.android.dialer.DialtactsActivity";
        /***
         * 联系人选择账户界面
         ***/
        public static final String CONTACT_EDITOR_ACCOUNT_CHANGED = "com.android.dialer/com.android.contacts.common.activities.ContactEditorAccountsChangedActivity";
        /***
         * 联系人编辑界面
         ***/
        public static final String CONTACT_EDITOR = "com.android.dialer/com.android.contacts.common.activities.ContactEditorActivity";
        /***
         * 添加联系人界面
         ***/
        public static final String CONTACT_SELECTION = "com.android.dialer/com.android.contacts.common.activities.ContactSelectionActivity";
        /***
         * 相机界面
         ***/
        public static final String CAMERA = "com.meizu.media.camera/com.meizu.media.camera.CameraLauncher";
        /***
         * 编辑联系人进入相机
         ***/
        public static final String CAMERAINCONTACT = "com.meizu.media.camera/com.meizu.media.camera.CameraActivity";
        /***
         * 设置界面
         ***/
        public static final String SET = "com.android.settings/com.android.settings.Settings";
        /***
         * 视频开启
         ***/
        public static final String VIDEO_START = "com.meizu.media.video/com.meizu.media.video.VideoMainActivity";
        /***
         * 视频界面
         ***/
        public static final String VIDEO = "com.meizu.media.video/com.meizu.media.video.player.ui.VideoWindowActivity";
        /***
         * flyme账号设置界面
         ***/
        public static final String ACCOUNT_CENTER = "com.meizu.account/com.meizu.account.activity.AccountCenterActivity";
        /***
         * 音乐界面
         ***/
        public static final String MUSIC = "com.meizu.media.music/com.meizu.media.music.MusicActivity";
        /***
         * 文档管理多选择界面
         ***/
        public static final String MULTICHOICE = "com.meizu.filemanager/com.meizu.filemanager.choosefile.MultiChoiceActivity";
        /***
         * flyme数据同步界面
         ***/
        public static final String SYNC_SWITCHER = "com.meizu.mzsyncservice/com.meizu.sync.ui.activity.SyncSwitcherActivity";
        /***
         * 图库界面
         ***/
        public static final String GALLERY = "com.meizu.media.gallery/com.meizu.media.gallery.GalleryActivity";
        /***
         * 图库裁剪图片界面
         ***/
        public static final String GALLERY_CUTINTO = "com.meizu.media.gallery/com.meizu.media.gallery.crop.CropImage";
        /***
         * 图库中二维码入口
         ***/
        public static final String GALLERY_BAECODE = "com.meizu.media.gallery/com.meizu.media.gallery.barcode.BarcodeActivity";
        /***
         * 图库中编辑图片界面
         ***/
        public static final String GALLERY_EDITPIC = "com.meizu.media.gallery/com.meizu.media.gallery.filtershow.FilterShowActivity";
        /***
         * 图库中添加标注界面
         ***/
        public static final String GALLERY_MARK = "com.meizu.media.gallery/com.meizu.media.gallery.doodle.PhotoMarkerActivity";
        /***
         * 图库中旋转图片界面
         ***/
        public static final String GLLERY_REVERT = "com.meizu.media.gallery/com.meizu.media.gallery.rotate.PhotoRotateStraighten";
        /***
         * 图库中人脸入口界面
         ***/
        public static final String GALLERY_FACE = "com.meizu.media.gallery/com.meizu.media.gallery.facebeauty.FaceBeauty";
        /***
         * 分享界面
         ***/
        public static final String SHARE = "android/com.android.internal.app.ChooserActivity";
        /***
         * 新建微博界面
         ***/
        public static final String NEW_WEIBO = "com.sina.weibo/com.sina.weibo.EditActivity";
        /***
         * 登录微博界面
         ***/
        public static final String LOGIN_WEIBO = "com.sina.weibo/com.sina.weibo.SwitchUser";
        /***
         * 云相册传输管理界面
         ***/
        public static final String CLOUDALBUM_MANAGEMENT = "com.meizu.media.gallery/com.meizu.media.gallery.cloud.ui.TransManagementActivity";
        /***
         * 云相册备份设置界面
         ***/
        public static final String CLOUDALBUM_AUTOMATIC = "com.meizu.media.gallery/com.meizu.media.gallery.AlbumManagerActivity";
        /***
         * 便签界面
         ***/
        public static final String NOTES = "com.meizu.notepaper/com.meizu.flyme.notepaper.NoteEditActivity";
        /***
         * 86便签界面
         ***/
        public static final String FLYMENOTES = "com.meizu.flyme.notepaper/com.meizu.flyme.notepaper.NoteEditActivity";
        /***
         * 信息拦截记录界面
         ***/
        public static final String BLOCKMESSAGE = "com.meizu.blockservice/com.meizu.blockService.BlockMessageListActivity";
        /***
         * 信息用户黑名单界面
         ***/
        public static final String BLACKLIST = "com.meizu.blockservice/com.meizu.blockService.BlackListActivity";
        /***
         * 信息设置界面
         ***/
        public static final String MESSAGE_SETTINGS = "com.android.mms/com.android.mms.ui.MessagingPreferenceActivity";
        /***
         * 高德地图界面
         ***/
        public static final String MINIMAP = "com.autonavi.minimap/com.autonavi.minimap.MapActivity";
        /***
         * 日历界面
         ***/
        public static final String CALENDAR = "com.android.calendar/com.meizu.flyme.calendar.AllInOneActivity";
        /***
         * 联系人详情界面
         ***/
        public static final String CONTACTADETAIL = "com.android.dialer/com.android.contacts.common.activities.ContactDetailActivity";
        /***
         * 通话设置界面
         ***/
        public static final String PHONE_SETTINGS = "com.android.phone/com.meizu.phone.MzCallFeaturesSetting";
        /***
         * 拨打电话界面
         ***/
        public static final String INCALL = "com.android.dialer/com.android.incallui.InCallActivity";
        /***
         * flyme5.0拨打电话界面
         ***/
        public static final String INCALUIL = "com.android.incallui/com.android.incallui.InCallActivity";
        /***
         * 通话记录详情界面
         ***/
        public static final String CALLDETAIL = "com.android.dialer/com.meizu.activities.CallDetailActivity";
        /***
         * 便签界面
         ***/
        public static final String NOTEPAGER = "com.meizu.notepaper/com.meizu.flyme.notepaper.NotePaperActivity";
        /***
         * flyme5.0便签界面
         ***/
        public static final String APP_NOTEPAGER = "com.meizu.notepaper/com.meizu.flyme.notepaper.app.NotePaperActivity";
        /***
         * 简易模式设置界面
         ***/
        public static final String EASYSETTINGS = "com.meizu.flyme.easylauncher/com.meizu.easymode.setting.SettingActivity";
        /***
         * 简易模式电话界面
         ***/
        public static final String EASYPHONE = "com.meizu.flyme.easylauncher/com.meizu.easymode.easydialer.MainActivity";
        /***
         * 简易模式信息界面
         ***/
        public static final String EASYMMS = "com.meizu.flyme.easylauncher/com.meizu.easymode.easymms.ConversationListActivity";
        /***
         * 简易模式桌面界面
         ***/
        public static final String EASYLAUNCHER = "com.meizu.flyme.easylauncher/com.android.launcher3.Launcher";
        /***
         * 画板界面
         ***/
        public static final String PAINTER = "com.meizu.media.painter/com.meizu.media.painter.PainterMainActivity";
        /***
         * 录音机界面
         ***/
        public static final String RECORD = "com.android.soundrecorder/com.android.soundrecorder.MzRecorderActivity";
        /***
         * 留言录音界面
         ***/
        public static final String MESSAGERECORD = "com.android.soundrecorder/com.android.soundrecorder.MessageRecordActivity";
        /***
         * 录音列表界面
         ***/
        public static final String CALLRECORD = "com.android.soundrecorder/com.android.soundrecorder.CallRecordActivity";
        /***
         * M86录音列表界面
         ***/
        public static final String FILLCALLRECORD = "com.android.soundrecorder/com.android.soundrecorder.FileListActivity";
        /***
         * flyme5.0录音列表界面
         ***/
        public static final String CALLRECORDLIST = "com.meizu.callsetting/com.meizu.callsetting.soundrecorder.CallRecordListActivity";
        /***
         * 安全中心界面
         ***/
        public static final String SAFE = "com.meizu.safe/.SecurityCenterActivity";
        /***
         * GO联系人
         ***/
        public static final String GOCONTACT = "com.jbapps.contactpro/com.jbapps.contactpro.ui.ContactListLaunch";
        /***
         * GO短信
         ***/
        public static final String GOMESSAGE = "com.jb.gosms/com.jb.gosms.ui.mainscreen.GoSmsMainActivity";
        /***
         * 下载界面
         ***/
        public static final String DOWNLOAD = "com.android.providers.downloads.ui/com.android.providers.downloads.ui.DownloadActivity";
        /***
         * 地图界面
         ***/
        public static final String GETLOCATION = "com.android.mms/com.android.mms.location.amap.GetLocationActivity";
        /***
         * google地图界面
         ***/
        public static final String GOOGLEGETLOCATION = "com.android.mms/com.android.mms.location.google.GetLocationActivity";
        /***
         * 应用中心界面
         ***/
        public static final String APPMAINTAB = "com.meizu.mstore/com.meizu.flyme.appcenter.activitys.AppMainTabActivity";
        /***
         * 打开Play商店界面
         ***/
        public static final String ASSETBROWSER = "com.android.vending/com.android.vending.AssetBrowserActivity";
        /***
         * 信息黑名单从通话记录添加页面
         ***/
        public static final String CALLLOGSELECTION = "com.android.dialer/com.meizu.activities.CallLogSelectionActivity";
        /***
         * 信息黑名单从信息添加页面
         ***/
        public static final String SELECTCONVERSATION = "com.android.mms/com.android.mms.ui.SelectConversationList";
        /***
         * 信息骚扰拦截页面
         ***/
        public static final String BLOCKPREFERENCE = "com.meizu.blockservice/com.meizu.blockService.BlockPreference";
        /***
         * 送达报告页面
         ***/
        public static final String SIMSELECTIONPREFEERENCE = "com.android.mms/com.android.mms.ui.SimSelectionPreferenceActivity";
        /***
         * 登录flyme帐号界面
         ***/
        public static final String LOGINFLYME = "com.meizu.account/com.meizu.account.partner.taobao.TaobaoLoginToBindActivity";
        /***
         * 下载管理主界面
         ***/
        public static final String DOWN = "com.android.providers.downloads.ui/com.android.providers.downloads.ui.DownloadActivity";
        /***
         * 第三方supervpn软件界面
         ***/
        public static final String SUPERVPN = "com.jrzheng.supervpnfree/com.jrzheng.supervpn.view.MainActivity";
        /***
         * 安全中心界面
         ***/
        public static final String SECURITYCENTER = "com.aliyun.SecurityCenter/com.aliyun.SecurityCenter.ui.SecurityCenterActivity";
        /***
         * 闹钟主界面
         ***/
        public static final String ALARM = "com.android.alarmclock/com.meizu.flyme.alarmclock.AlarmClock";
        /***
         * permissiontester界面
         ***/
        public static final String PERMISSIONTESTER = "com.lbe.permissiontester/.MainActivity";
        /***
         * 阿里云安全中心界面
         ***/
        public static final String YUNOS_SAFE = "com.aliyun.SecurityCenter/com.aliyun.SecurityCenter.ui.SecurityCenterActivity";
        /***
         * 阿里云安全中心界面
         ***/
        public static final String YUNOSSAFETYCENTER = "com.aliyun.SecurityCenter/com.aliyun.SecurityCenter.ui.SecurityCenterActivity";
        /***
         * 地图界面
         ***/
        public static final String NEWMAP = "com.autonavi.minimap/com.autonavi.map.activity.NewMapActivity";
        /***
         * 生活应用界面
         ***/
        public static final String LIFE = "com.meizu.media.life/com.meizu.media.life.ui.activity.HomeActivity";
        /***
         * 通话录音列表
         ***/
        public static final String SOUNDRECORDER_CALL = "com.android.soundrecorder/com.android.soundrecorder.CallRecordActivity";
        /***
         * 账户和联系人管理界面
         ***/
        public static final String CONTACTSPREFERENCE = "com.android.dialer/com.android.contacts.common.preference.ContactsPreferenceActivity";
        /***
         * 前缀IP设置界面
         ***/
        public static final String PONEMESELECTSIMCARD = "com.android.phone/com.meizu.phone.MzSelectSimCardActivity";
        /***
         * 通话录音设置页面
         ***/
        public static final String AUTORECORD = "com.android.phone/com.meizu.phone.AutoRecordActivity";
        /***
         * flyme5.0联系人详情页面
         ***/
        public static final String QUICKCONTACT = "com.android.dialer/com.android.contacts.quickcontact.QuickContactActivity";
    }

    /***
     * 服务器IP
     ***/
    public static final String SERVER_DN = "atp.meizu.com/";

    public static final String getPackName(String pack) {
        return pack.split("/")[0];

    }

    /***
     * 等待时间
     ***/
    public static final int TIME_OUT = 10 * 1000;
    /***
     * 外置SD卡路径
     ***/
    public static final String SDCARD_PATH_ONE = "/storage/sdcard1";
    /***
     * 内置SdCard卡路径
     ***/
    public static final String SDCARD_PATH = Environment.getExternalStorageDirectory().getPath();

    /**
     * 机型
     *
     * @author zhanrunda
     */
    public static final String MACHINE_TYPE_M88 = "M88";
    public static final String MACHINE_TYPE_M85 = "M85";
    public static final String MACHINE_TYPE_M81 = "M81";
    public static final String MACHINE_TYPE_M79 = "M79";
    public static final String MACHINE_TYPE_M71 = "M71";
    public static final String MACHINE_TYPE_M71C = "M71C";
    public static final String MACHINE_TYPE_MX4_PRO = "M76";
    public static final String MACHINE_TYPE_MX4 = "M75";
    public static final String MACHINE_TYPE_MX3 = "M06X";
    public static final String MACHINE_TYPE_MX2 = "M04X";
    public static final String MACHINE_TYPE_M81C = "M81C";
    public static final String MACHINE_TYPE_M86 = "M86";
    public static final String MACHINE_TYPE_M88C = "M88C";
    public static final String MACHINE_TYPE_MA01C = "MA01C";


    /*** 多语言用到 ***/
    /***
     * 分享Activity
     ***/
    public static final String SHARE = "android/com.android.internal.app.MzChooserActivity";
    /***
     * 来电白名单Activity
     ***/
    public static final String WHITELISTPREFERENCE_ACTIVITY = "com.android.dialer/com.meizu.contacts.WhiteListPreferenceActivity";
    /***
     * 驾驶辅助功能中选择蓝牙设备Activity
     ***/
    public static final String DEVICEPICKER_ACTIVITY = "com.android.settings/com.android.settings.bluetooth.DevicePickerActivity";
    /***
     * ADDPATHActivity
     ***/
    public static final String ADDPATH = "com.meizu.media.video/com.meizu.media.video.local.LocalVideoSelectFolderActivity";
    public static final String FLYME_ACTIVITY = null;

    /**
     * 浏览器模块ID和文本常量
     *
     * @author zhanrunda
     */
    public class Web {
        /**
         * 文本
         */
        public static final String TEXT_SETTING = "设置";
        public static final String TEXT_BOOKMARK = "书签";
        public static final String TEXT_LIGHT_APP = "轻应用";
        public static final String TEXT_CONFIRM = "确定";
        public static final String TEXT_HOME_PAGE = "主页";
        public static final String TEXT_ALLOW = "允许";
        public static final String TEXT_HISTORY = "历史记录";
        public static final String TEXT_DEFAULT_CONTENT = "默认目录";
        public static final String TEXT_NEW_CONTENT = "新建目录";
        public static final String TEXT_FINISHED = "完成";
        public static final String TEXT_CLEAR_HISTORY = "清空历史记录";
        public static final String TEXT_NO_HISTORY = "没有历史记录";
        public static final String TEXT_ALERT_WINDOW = "阻止弹出式窗口";
        public static final String TEXT_LOCATION = "启用位置信息功能";
        public static final String TEXT_SETTING_HOME_PAGE = "设置主页";
        public static final String TEXT_CLEAR_COOKIE = "清除Cookie和数据";
        public static final String TEXT_ADD_BOOKMARK = "添加";
        public static final String TEXT_OPEN_NEW_WINDOW = "新窗口打开";
        public static final String TEXT_OPEN_BACK = "后台打开";
        public static final String TEXT_REMOVE = "移除";
        public static final String TEXT_SHARE = "分享";
        public static final String TEXT_MORE_SETTING = "更多";
        public static final String TEXT_RESTORE = "还原设置";
        public static final String TEXT_LANDSCAPE = "横屏浏览";
        public static final String TEXT_NAVIGATION = "导航页";
        public static final String TEXT_RECIEVE_COOKIE = "接受Cookie和数据";
        public static final String TEXT_GLMS = "概览模式打开网页";
        public static final String TEXT_SECURITY_ALARM = "显示安全警告";
        public static final String TEXT_PREVENT_FOLLOWING = "阻止网站跟踪";
        public static final String TEXT_WEB_SETTING = "网站设置";
        public static final String TEXT_LOAD_PIC = "加载图片";
        public static final String TEXT_JAVASCRIPT = "JavaScript";
        public static final String TEXT_MX = "MX";
        public static final String TEXT_PRELOADING = "搜索结果预加载";
        public static final String TEXT_ONLY_WIFI = "仅wifi网络下";
        public static final String TEXT_ONLY_WLAN = "仅WLAN网络下";
        public static final String TEXT_ONLY_WLAN_CN = "仅无线网络下";
        public static final String TEXT_NEVER = "从不";
        public static final String TEXT_FOREVER = "始终";
        public static final String TEXT_EMAIL = "邮件";
        public static final String TEXT_MESSAGE = "新信息";
        public static final String TEXT_BLUE_TOOTH = "蓝牙";
        public static final String TEXT_CURRENT_PAGE = "使用当前页";
        public static final String TEXT_CUSTOM = "自定义";
        public static final String TEXT_HOTNEWS = "热门";
        public static final String TEXT_CANCEL = "取消";
        public static final String TEXT_HIDE_MODE = "隐身浏览";
        public static final String TEXT_NO_BOOKMARK = "没有书签";
        public static final String TEXT_CALL = "拨打";
        public static final String TEXT_SEND_MESSAGE = "发信息";
        public static final String TEXT_ADD_NEW_CONTACT = "加至新联系人";
        public static final String TEXT_ADD_CONTACT = "加至已有联系人";
        public static final String TEXT_COPY = "复制";
        public static final String TEXT_NEW_EMAIL = "新邮件";
        public static final String TEXT_QIDIAN = "http://m.qidian.com/";

        /***
         * 配置
         ***/
        public static final String FILE = "WebTestCase";
        public static final int WEB_WAIT_TIME = 3 * 1000;
        /***
         * 网址
         ***/
        public static final String PAGE_BAIDU = "www.baidu.com";
        public static final String PAGE_MEIZU = "www.meizu.com";
        public static final String PAGE_RESOURCE = "172.16.11.218:8088";
        public static final String PAGE_CONTACT = "www.meizu.com/contact.html";
        public static final String PAGE_READER_MODE = "http://club.eladies.sina.com.cn/thread-5853261-1-1.html";
        public static final String PAGE_QIDIAN = "www.qidian.com";
        public static final String PAGE_M_MEIZU = "http://m.meizu.com/";
        public static final String PAGE_QQ = "http://WWW.QQ.COM/";
        public static final String PAGE_TOOOPEN = "http://WWW.TOOOPEN.COM/";
        public static final String PAGE_IMAGE = "http://172.16.11.218:8088/res/jpg.jpg";
        public static final String PAGE_SINA_CONTACT = "www.sina.com.cn/contactus.html";
        public static final String PAGE_SINA = "www.sina.com.cn";
        public static final String PAGE_READER = "www.ifanr.com/news/477556";
        public static final String PAGE_READER2 = "http://news.xinhuanet.com/politics/2015-01/03/c_1113857022.htm";
        public static final String PAGE_12306 = "http://www.12306.cn/mormhweb/";

        /**
         * ID
         */
        /***
         * 多窗口按钮ID
         ***/
        public static final String ID_SHOW_SCROLLBAR = "com.android.browser:id/show_scrollbar";
        /***
         * 开启菜单栏ID
         ***/
        public static final String ID_MENU = "com.android.browser:id/menu_more";
        /***
         * 浏览器HOME键
         ***/
        public static final String ID_BOOKMARK = "com.android.browser:id/show_bookmark";
        /***
         * 主页最常访问图标ID
         ***/
        public static final String ID_IMAGE = "com.android.browser:id/image";
        /***
         * 开启多窗口按钮里面的窗口数量ID
         ***/
        public static final String ID_WINDOW_NUM = "com.android.browser:id/window_num";
        /***
         * 历史记录列表复选框ID
         ***/
        public static final String ID_CHECKBOX = "android:id/checkbox";
        /***
         * 历史记录新窗口打开按钮ID
         ***/
        public static final String ID_OPEN = "com.android.browser:id/open";
        /***
         * 下载提示框确认按钮ID
         ***/
        public static final String ID_BUTTON1 = "android:id/button1";
        /***
         * 点击删除书签弹出框ID
         ***/
        public static final String ID_TITLE = "android:id/title";
        /***
         * 长按BACK键或者HOME键后，弹出键盘下面的搜索引擎列表按钮ID
         ***/
        public static final String ID_SHOW_SEARCH_ENGINE = "com.android.browser:id/show_search_engine";
        /***
         * 历史记录清空按钮ID
         ***/
        public static final String ID_CLEAR = "com.android.browser:id/clear";
        /***
         * 历史记录标题ID
         ***/
        public static final String ID_TITILE = "com.android.browser:id/title";
        /***
         * 退出阅读模式ID
         ***/
        public static final String ID_READER_BACK = "com.android.browser:id/reader_back";
        /***
         * 进入阅读模式ID
         ***/
        public static final String ID_BT_READER = "com.android.browser:id/bt_reader";
        /***
         * 多窗口界面的小窗口ID
         ***/
        public static final String ID_SCREENSHOT = "com.android.browser:id/screenshot";
        /***
         * 添加轻应用按钮ID
         ***/
        public static final String ID_FAVICON = "com.android.browser:id/favicon";
        /***
         * 主页BAR栏新增窗口按钮ID
         ***/
        public static final String ID_NEW_PAGE = "com.android.browser:id/new_page";
        /***
         * 5.0主页搜索引擎输入框ID
         ***/
        public static final String ID_SEARCH_FRAME = "com.android.browser:id/search_frame";
        /***  ***/
        public static final String ID_BUTTON2 = "com.android.browser:id/button2";
        /***  ***/
        public static final String ID_ICON = "com.android.browser:id/icon";
        /***  ***/
        public static final String ID_TEXT1 = "com.android.browser:id/text1";
        /***
         * 网页内容点击电话弹出框，各个选项ID
         ***/
        public static final String ID_ALERT_TITLE = "android:id/alertTitle";
        /***
         * 隐身浏览地址栏小眼睛ID
         ***/
        public static final String ID_INCOGNITO_ICON = "com.android.browser:id/incognito_icon";
        /***
         * 轻应用列表添加按钮ID
         ***/
        public static final String ID_ADD_TEXT = "com.android.browser:id/add_text";
        /***
         * 轻应用列表搜索轻应用按钮ID
         ***/
        public static final String ID_LIGHTAPP_SEARCH = "com.android.browser:id/lightapp_search";
        /***
         * 编辑书签按钮ID
         ***/
        public static final String ID_EDIT = "com.android.browser:id/edit";
        /***
         * 删除书签按钮ID
         ***/
        public static final String ID_DELETE = "com.android.browser:id/delete";
        /***
         * 设置界面第一层开关ID
         ***/
        public static final String ID_SWITCH_BUTTON = "com.android.browser:id/switch_button";
        /***
         * 长按默认目录，出现的新建目录ID
         ***/
        public static final String ID_SUB_DETAIL = "com.android.browser:id/sub_detail";
        /***
         * 新建目录编辑框ID
         ***/
        public static final String ID_ANDROID_EDIT = "android:id/edit";
        /***
         * 书签界面各个书签目录ID
         ***/
        public static final String ID_DETAIL = "com.android.browser:id/detail";
        /***
         * 删除书签目录弹出的删除框
         ***/
        public static final String ID_ANDROID_TEXT1 = "android:id/text1";
        /***
         * 历史记录总数ID
         ***/
        public static final String ID_COUNT = "com.android.browser:id/count";
        /***
         * 添加书签界面，目录栏ID
         ***/
        public static final String ID_FOLDER = "com.android.browser:id/folder";
        /***
         * 5.0设置二级界面开关ID
         ***/
        public static final String ID_SWITCH_WIDGET = "com.android.browser:id/switchWidget";
        /***
         * 4.0设置二级界面开关ID
         ***/
        public static final String ID_ANDROID_SSWITCH_WIDGET = "android:id/switchWidget";
        /***  ***/
        public static final String ID_CHECK_BOX = "android:id/checkbox";
        /***  ***/
        public static final String ID_ACTION_BAR = "android:id/action_bar";
        /***  ***/
        public static final String ID_TEXT = "com.android.browser:id/text";

        public static final String ID_BTRREF = "com.android.browser:id/bt_refresh";

        public static final String ID_REFRESH = "com.android.browser:id/refresh";

        public static final String ID_URL = "com.android.browser:id/url";
    }

    /**
     * 信息模块ID和文本常量
     *
     * @author
     */
    public class Message {
        /**
         * 文本
         */
        public static final String MORE_OPTION_TEXT = "更多选项";
        public static final String IS_SENDING_TEXT = "正在发送";
        public static final String INTERCEPT_NUMBER_TEXT = "拦截此号码";
        public static final String HARASSMENT_INTERCEPTION_TEXT = "骚扰拦截";
        public static final String INTERCEPT_REMINDER_TEXT = "拦截提醒";
        public static final String INTERCEPT_RECORD_TEXT = "拦截记录";
        public static final String SURE_TEXT = "确定";
        public static final String QUICK_REPLY_TEXT = "快速回复";
        public static final String TAB_PERSON_TEXT = "个人";
        public static final String TAB_NOTICE_TEXT = "通知";

        /**
         * ID
         */
        /***
         * 第一次点击电话/信息时弹出开启flyme通讯提示框的下次不再提醒
         ***/
        public static final String ID_DELETE_LOCKED = "com.android.mms:id/delete_locked";
        /***
         * 第一次点击电话/信息时弹出开启flyme通讯提示框的取消按钮
         ***/
        public static final String ID_BUTTON2 = "android:id/button2";
        /***
         * 信息个人列表
         ***/
        public static final String ID_TAB_PERSON_TITLE = "com.android.mms:id/tab_person_title";
        /***
         * 信息通知列表
         ***/
        public static final String ID_TAB_NOTICE_TITLE = "com.android.mms:id/tab_notice_title";
        /***
         * 信息收藏列表
         ***/
        public static final String ID_TAB_FAVORITE_TITLE = "com.android.mms:id/tab_favorite_title";
        /***
         * 信息列表短信
         ***/
        public static final String ID_TEXT1 = "android:id/text1";
        /***
         * 短信输入框
         ***/
        public static final String ID_EMBEDDED_TEXT_EDITOR = "com.android.mms:id/embedded_text_editor";
        /***
         * 信息会话页面的短信
         ***/
        public static final String ID_TEXT_VIEW = "com.android.mms:id/text_view";
        /***
         * 信息列表选中短信后显示的删除按钮
         ***/
        public static final String ID_DELETE = "com.android.mms:id/delete";
        /***
         * 信息列表没有信息
         ***/
        public static final String ID_EMPTY_TITLE = "com.android.mms:id/empty_title";
        /***
         * 双卡短信sim卡标识
         ***/
        public static final String ID_MSG_STATUS_SIM = "com.android.mms:id/msg_status_sim";
        /***
         * 收件人文本框
         ***/
        public static final String ID_MZ_RECIPIENT_EDIT = "flyme:id/mz_recipient_edit";
        /***
         * 信息列表联系人图像
         ***/
        public static final String ID_AVATAR = "com.android.mms:id/avatar";
        /***
         * 联系人详情页面信息图标
         ***/
        public static final String ID_SECONDARY_ACTION_BUTTON = "com.android.dialer:id/secondary_action_button";
        /***
         * 信息列表标为已读按钮
         ***/
        public static final String ID_UNFILTRATE = "com.android.mms:id/unfiltrate";
        /***
         * 信息列表全部标记为已读
         ***/
        public static final String ID_MARK_ALL_AS_READ = "com.android.mms:id/mark_all_as_read";
        /***
         * 信息列表短信选中按钮
         ***/
        public static final String ID_CHECKBOX = "android:id/checkbox";
        /***
         * 信息置顶按钮
         ***/
        public static final String ID_TOP = "com.android.mms:id/top";
        /***
         * 信息置顶标识
         ***/
        public static final String ID_TOPICON = "com.android.mms:id/topIcon";
        /***
         * 删除黑名单按钮
         ***/
        public static final String ID_ADDRESS_DELETE = "com.meizu.blockservice:id/address_delete";
        /***
         * 信息列表加入黑名单按钮
         ***/
        public static final String ID_SPAM = "com.android.mms:id/spam";
        /***
         * 弹框的确定按钮
         ***/
        public static final String ID_BUTTON1 = "android:id/button1";
        /***
         * fylme5.0新建信息页面右边添加联系人按钮
         ***/
        public static final String ID_MZ_RECIPIENT_ADD_BTN_5 = "flyme:id/mz_recipient_add_btn";
        /***
         * fylme4.0新建信息页面右边添加联系人按钮
         ***/
        public static final String ID_MZ_RECIPIENT_ADD_BTN_4 = "android:id/mz_recipient_add_btn";
        /***
         * 联系人页面添加按钮
         ***/
        public static final String ID_MENU_MULTIPLE_PICKER = "com.android.dialer:id/menu_multiple_picker";
        /***
         * 信息列表点击删除按钮后弹出的删除框id
         ***/
        public static final String ID_TITLE = "android:id/title";
        /***
         * 信息列表点击删除按钮后 可能会弹出确认删除的对话框
         ***/
        public static final String ID_TOPPANEL = "android:id/topPanel";
        /***
         * 信息会话页面收藏的id
         ***/
        public static final String ID_FAVORITE_VIEW = "com.android.mms:id/favorite_view";
        /***
         * 信息会话页面彩信主题的id
         ***/
        public static final String ID_SUBJECT_VIEW = "com.android.mms:id/subject_view";
        /***
         * 收藏列表取消收藏按钮
         ***/
        public static final String ID_UNFAVORITE = "com.android.mms:id/unfavorite";
        /***
         * 新建信息页面底栏附件按钮
         ***/
        public static final String ID_ATTACHMENT_GROUP = "com.android.mms:id/attachment_group";
        /***
         * 附件类型选择页面id
         ***/
        public static final String ID_ICON = "com.android.mms:id/icon";
        /***
         * 联系人附件按钮
         ***/
        public static final String ID_CHOOSE_INFO_TYPE = "com.android.dialer:id/choose_info_type";
        /***
         * 点击联系人附件按钮弹出框页面id
         ***/
        public static final String ID_TEXT_ONE = "android:id/text1";
        /***
         * 快速回复页面选项id
         ***/
        public static final String ID_PHRASE_ITEM = "com.android.mms:id/phrase_item";
        /***
         * 信息设置页面下一级连接id
         ***/
        public static final String ID_ARROW = "com.android.mms:id/arrow";
        /***
         * 信息黑名单页面添加按钮
         ***/
        public static final String ID_ADDRESS_ADD = "com.meizu.blockservice:id/address_add";
        /***
         * 信息弹框标题
         ***/
        public static final String ID_ALERTITLE = "android:id/alertTitle";
        /***
         * 快速回复4条信息id
         ***/
        public static final String ID_PHRASE_EDITTEXT = "com.android.mms:id/phrase_edittext";
        /***
         * 智能拦截开关id
         ***/
        public static final String ID_PSWITCHWIDGET = "com.meizu.blockservice:id/switchWidget";
        /***
         * 信息拦截记录中的还原按钮id
         ***/
        public static final String ID_BLOCK_MESSAGE_RESTORE = "com.meizu.blockservice:id/block_message_restore";
        /***
         * 信息列表左边未读信息标识id
         ***/
        public static final String ID_STATUICON = "com.android.mms:id/statuIcon";
        /***
         * 信息发送按钮
         ***/
        public static final String ID_SEND_MSG = "com.android.mms:id/send_msg";
        /***
         * 信息设置页面开关按钮id
         ***/
        public static final String ID_SWITCHWIDGET = "com.android.mms:id/switchWidget";
        /***
         * 信息会话页面彩信附件id
         ***/
        public static final String ID_IMAGE_VIEW = "com.android.mms:id/image_view";
        /***
         * 联系人名字id
         ***/
        public static final String ID_CLIV_NAME_TEXTVIEW = "com.android.dialer:id/cliv_name_textview";
        /***
         * 信息会话页面群发信息后显示的">"id
         ***/
        public static final String ID_GROUD_DELIVER = "com.android.mms:id/groud_deliver";
        /***
         * 设置页面右上角title ID
         ***/
        public static final String ID_ACTION_BAR_TITLE = "android:id/action_bar_title";
        /***
         * 设置页面的">"符号id
         ***/
        public static final String ID_SETTING_ARROW = "com.android.settings:id/arrow";
        /***
         * 设置页面右上角title ID
         ***/
        public static final String ID_MSG_SIM_IV = "com.android.mms:id/msg_sim_iv";
        /***
         * 信息会话页面，点击联系人弹出的下拉菜单中的id
         ***/
        public static final String ID_TEXT2 = "android:id/text2";
        /***
         * 转发信息按钮id
         ***/
        public static final String ID_FORWARD = "com.android.mms:id/forward";
        /***
         * 转发彩信主题id
         ***/
        public static final String ID_SUBJECT = "com.android.mms:id/subject";
        /***
         * 短信列表显示id
         ***/
        public static final String ID_MESSSAGE = "com.android.mms:id/conversation_list_item";
        /***
         * 短信列表未读id
         ***/
        public static final String ID_BG = "com.android.mms:id/bg";
        /***
         * 全选
         ***/
        public static final String ID_SELECTALL = "com.android.mms:id/mz_action_multi_choice_select_all_item";

    }

    /**
     * 联系人模块ID和文本常量
     *
     * @author chenli
     */
    public class Contact {
        /**
         * 文本
         */
        public static final String TEXT_SUBMIT_BUTTON = "确定";
        public static final String TEXT_SAVE_BUTTON = "保存";
        public static final String TEXT_DONE_BUTTON = "完成";
        public static final String TEXT_MORE_OPTIONS = "更多选项";
        public static final String TEXT_ALLOW_BUTTON = "允许";

        /**
         * ID
         */
        /***
         * 添加其他项目
         ***/
        public static final String ID_ADD_MORE = "com.android.dialer:id/button_add_field";
        /***
         * 弹出菜单选择框中的选项，不同机型描述不一样
         ***/
        public static final String ID_TEXT_ONE = "android:id/text1";
        /***
         * 弹出菜单选择框中的选项
         ***/
        public static final String ID_DIALER_ONE = "com.android.dialer:id/text1";
        /***
         * 导入联系人按钮
         ***/
        public static final String ID_IMPORT_CONTACTS = "com.android.dialer:id/welcome_import_contacts";
        /***
         * 多语言案例中使用，查看文本选择框
         ***/
        public static final String ID_DIALER_CONTENT = "com.android.dialer:id/content";
        /***
         * 群组列表项
         ***/
        public static final String ID_DIALER_CONTAINER = "com.android.dialer:id/group_list_item_container";
        /***
         * 新建群组
         ***/
        public static final String ID_DIALER_ADD_GROUP = "com.android.dialer:id/group_list_item_add";
        /***
         * 群组编辑模式
         ***/
        public static final String ID_DIALER_EDIT_MODE = "com.android.dialer:id/edit_mode_label";
        /***
         * 群组删除按钮
         ***/
        public static final String ID_DIALER_HANDLE = "com.android.dialer:id/handle";
        /***
         * 完成按钮
         ***/
        public static final String ID_DIALER_MENU_DONE = "com.android.dialer:id/menu_done";
        /***
         * 新建或编辑联系人界面的联系人头像
         ***/
        public static final String ID_DIALER_PHOTO_FRAME = "com.android.dialer:id/photo_frame";
        /***
         * 弹出菜单框中的选项
         ***/
        public static final String ID_TITLE = "android:id/title";
        /***
         * "确定"按钮
         ***/
        public static final String ID_BUTTON_ONE = "android:id/button1";
        /***
         * "取消"按钮
         ***/
        public static final String ID_BUTTON_TWO = "android:id/button2";
        /***
         * 群组列表项
         ***/
        public static final String ID_DIALER_LABEL = "com.android.dialer:id/label";
        /***
         * 默认打开方式按钮，不同机型描述不一样
         ***/
        public static final String ID_FLYME_ALWAYS = "flyme:id/mz_alwaysUse";
        /***
         * 默认打开方式按钮
         ***/
        public static final String ID_ANDROID_ALWAYS = "android:id/mz_alwaysUse";
        /***
         * 注册按钮
         ***/
        public static final String ID_LINK_REGISTER = "com.meizu.account:id/linkRegister";
        /***
         * 勾选按钮
         ***/
        public static final String ID_CHECKBOX = "android:id/checkbox";
        /***
         * 导入vcard按钮
         ***/
        public static final String ID_DIALER_IMPORT = "com.android.dialer:id/menu_import_vcard";
        /***
         * 删除vcard按钮
         ***/
        public static final String ID_DIALER_DELETE = "com.android.dialer:id/menu_delete_vcard";
        /***
         * 联系人管理项，不同机型描述不一样
         ***/
        public static final String ID_DIALER_LAYOUT_TEXT = "com.android.dialer:id/preference_text_layout";
        /***
         * 联系人管理项
         ***/
        public static final String ID_ANDROID_LAYOUT_TEXT = "android:id/preference_text_layout";
        /***
         * 联系人详情界面中信息项
         ***/
        public static final String ID_DIALER_ACTION_VIEW = "com.android.dialer:id/primary_action_view";
        /***
         * 编辑头像，选择界面中的相机一栏
         ***/
        public static final String ID_TOP_TAB_CAMERA_TITLE = "com.meizu.media.gallery:id/top_tab_camera_title";
        /***
         * 选择照片
         ***/
        public static final String ID_THUMBNAIL = "com.meizu.media.gallery:id/thumbnail";
        /***
         * 弹出的警告框
         ***/
        public static final String ID_ALERT_TITLE = "android:id/alertTitle";
        /***
         * 双卡案例拨号时弹出的列表项，不同机型描述不一样
         ***/
        public static final String ID_SUBINFO = "com.android.phone:id/subinfo";
        /***
         * 双卡案例拨号时弹出的列表项
         ***/
        public static final String ID_DIALER_TEXT = "com.android.dialer:id/text";
        /***
         * 多选列表界面选择的数目显示按钮
         ***/
        public static final String ID_SELECTED_COUNT = "com.android.dialer:id/selectedCount";
        /***
         * 联系人搜索结果列表界面，联系人姓名
         ***/
        public static final String ID_CLIV_NAME_TEXTVIEW = "com.android.dialer:id/cliv_name_textview";
        /***
         * 联系人搜索结果列表界面，联系人电话号码
         ***/
        public static final String ID_CLIV_DATA_VIEW = "com.android.dialer:id/cliv_data_view";
        /***
         * 界面中的滑动开关
         ***/
        public static final String ID_SWICH_WIDGET = "com.android.settings:id/switchWidget";
        /***
         * 联系人列表标题文字
         ***/
        public static final String ID_ACTION_BAR_TITLE = "android:id/action_bar_title";

    }

    /**
     * 本地视频模块ID和文本常量
     *
     * @author kuanghaibo
     */
    public class Video {
        /**
         * 文本
         */
        public static final String TEXT_VIDEO = "视频";
        public static final String TEXT_MORE_OPTIONS = "更多选项";
        public static final String TEXT_ALLOW = "允许";

        /**
         * ID
         */
        /***
         * 个人中心
         ***/
        public static final String ID_MENU_PERSONAL_CENTER = "com.meizu.media.video:id/menu_personal_center";
        /***
         * 视频、收藏、历史（按index来区分，id是一样的）
         ***/
        public static final String ID_SEARCH_RE_CHANNELNAME = "com.meizu.media.video:id/search_resulttype_channelname";
        /***
         * 展开视频按钮
         ***/
        public static final String ID_EXPAND_ICON = "com.meizu.media.video:id/expand_icon";
        /***
         * 选中视频后出现的删除按钮
         ***/
        public static final String ID_ACTION_DELETE = "com.meizu.media.video:id/action_delete";
        /***
         * 选中视频后出现的复制按钮
         ***/
        public static final String ID_ACTION_COPY = "com.meizu.media.video:id/action_copy";
        /***
         * 选中视频后出现的分享按钮
         ***/
        public static final String ID_ACTION_SHARE = "com.meizu.media.video:id/action_share";
        /***
         * 选中视频后出现的移动按钮
         ***/
        public static final String ID_ACTION_MOVE = "com.meizu.media.video:id/action_move";
        /***
         * 选中视频后点复制后移动等按钮出现的添加文件夹按钮
         ***/
        public static final String ID_ACTION_ADD_FOLDER = "com.meizu.media.video:id/action_add_folder";
        /***
         * 播放视频后的悬浮播放按钮
         ***/
        public static final String ID_SWITCH_FLOAT_WINDOW = "com.meizu.media.video:id/switch_float_window";
        /***
         * 播放视频后的进度条(包含了时间的)
         ***/
        public static final String ID_PLAYER_BOTTOM_SEEKBAR_LAYOUT = "com.meizu.media.video:id/player_bottom_seekbar_layout";
        /***
         * 多处用到，如点击删除时出现的弹框，或者是播放视频后点击选择播放模式（单曲播放、单曲循环）、用index区分
         ***/
        public static final String ID_TITLE = "android:id/title";
        /***
         * 展开后选中按钮
         ***/
        public static final String ID_CHECKBOK = "android:id/checkbox";
        /***
         * 播放后的整个界面范围
         ***/
        public static final String ID_ROOT_CONTROLL = "com.meizu.media.video:id/root_controll";
        /***
         * 当前播放到什么时间（进度条前面的时间）
         ***/
        public static final String ID_ALREADY_PLAYINGTIME = "com.meizu.media.video:id/already_playingtime";
        /***
         * 当前播放到什么时间（进度条前面的时间））（隐藏控件划动平时出现的）
         ***/
        public static final String ID_GESTURE_PLAYTIME = "com.meizu.media.video:id/gesture_playtime";
        /***
         * 视频总时长（进度条后面的时间）
         ***/
        public static final String ID_REMAIN_PLAYINGTIME = "com.meizu.media.video:id/remain_playingtime";
        /***
         * 移动或复制视频到某文件夹时的确定按钮（视频界面内操作）
         ***/
        public static final String ID_ACTION_COPY_MOVE_CONFIRM = "com.meizu.media.video:id/action_copy_move_confirm";
        /***
         * 点击展开后整个视频范围
         ***/
        public static final String ID_ITEM_LAYOUT = "com.meizu.media.video:id/video_cover";
        /***
         * 获取不到点击展开后整个视频范围时使用这个值
         ***/
        public static final String ID_NO_ITEM_LAYOUT = "com.meizu.media.video:id/video_list_item";
        /***
         * 弹出是否允许弹框时的确定按钮
         ***/
        public static final String ID_BUTTON = "android:id/button1";
        /***
         * 同一个文件夹里有多少视频时，播放时候出现的选集按钮
         ***/
        public static final String ID_EXPAND_LIST = "com.meizu.media.video:id/expand_list";
        /***
         * 同一个文件夹里有多少视频时，横屏播放时候出现的选集按钮
         ***/
        public static final String ID_HORIZONTAL_EXPAND_LIST = "com.meizu.media.video:id/horizontal_expand_list";
        /***
         * 点击选集按钮后选项的不同视频的画面界面
         ***/
        public static final String ID_IMAGE_DRAWABLE = "com.meizu.media.video:id/image_drawable";
        /***
         * 播放视频时有显示控件时的视频名称标题(左上角)
         ***/
        public static final String ID_ACTION_BAR_TITLE = "android:id/action_bar_title";
        /***
         * 暂停
         ***/
        public static final String ID_PAUSE = "com.meizu.media.video:id/pause";
        /***
         * 加载视频中
         ***/
        public static final String ID_LOADING_LAYOUT = "com.meizu.media.video:id/loading_layout";
        /***
         * 保存至SD卡id
         ***/
        public static final String ID_PRIORITY_CHECK = "com.meizu.media.video:id/priority_check";

        /*** 多语言专用 ***/
        /***
         * 选中视频点击复制按钮后，选中复制至哪个文件夹
         ***/
        public static final String ID_GROUP_NAME_COUNT = "com.meizu.media.video:id/group_name_count";
        /***
         * 进入视频后的管理视频目录
         ***/
        public static final String ID_ADD_FOLDER_VIEW = "com.meizu.media.video:id/add_folder_view";
        /***
         * 点击管理视频目录后出现的选择要显示的目录
         ***/
        public static final String ID_LOCAL_ADD_FOLDER_TITLE = "com.meizu.media.video:id/local_video_add_folder_title";
        /***
         * 点击新建文件夹后出现的
         ***/
        public static final String ID_TOP_PANEL = "android:id/topPanel";
        /***
         * 进度条
         ***/
        public static final String ID_VIDEO_CONTROLLER_PRO_LAYOUT = "com.meizu.media.video:id/video_controller_progress_layout";
        /***
         * 分享方式图标
         ***/
        public static final String ID_ICON = "android:id/icon";
        /***
         * 没有视频
         ***/
        public static final String ID_MEDIA_EMPTY_BUTTOM = "com.meizu.media.video:id/media_empty_buttom";
        /***
         * 勾选图标
         ***/
        public static final String ID_RADIO = "android:id/radio";

    }

    /**
     * 在线视频模块ID和文本常量
     *
     * @author zhangyouxuan
     */
    public class VideoOnline {
        /**
         * ID
         */
        /***
         * 视频列表的视频名称
         ***/
        public static final String ID_TITLE_CONTENT = "com.meizu.media.video:id/template_item_content_title_content";
        /***
         * 视频列表的视频图片
         ***/
        public static final String ID_TEMPLATE_ITEM_IMAGE = "com.meizu.media.video:id/template_item_image";
        /***
         * 电视剧下载界面选集图标
         ***/
        public static final String ID_EPISODES_TV_ITEM = "com.meizu.media.video:id/chanelprogramdetail_episodes_tv_item";
        /***
         * 电视剧下载界面选集按钮,下载过后会变成不可点击
         ***/
        public static final String ID_EPISODES_TV_BUTTON = "com.meizu.media.video:id/chanelprogramdetail_episodes_tv_item_button";
        /***
         * 视频详情界面下载图标
         ***/
        public static final String ID_MENU_DOWNLOAD = "com.meizu.media.video:id/menu_download";
        /***
         * 视频小窗口播放时的时间信息
         ***/
        public static final String ID_MINI_PLAYTIME_INFO = "com.meizu.media.video:id/mini_playtime_info";
        /***
         * 视频已播放时间
         ***/
        public static final String ID_ALREADY_PLAYINGTIME = "com.meizu.media.video:id/already_playingtime";
        /***
         * 详情界面-更多选项-自动播放
         ***/
        public static final String ID_VIDEO_PLAYER_COVER_BTN = "com.meizu.media.video:id/video_player_cover_btn";
        /***
         * 详情界面收藏五星图标
         ***/
        public static final String ID_MENU_FAVORITE = "com.meizu.media.video:id/menu_favorite";
        /***
         * 下载界面电视剧名称
         ***/
        public static final String ID_EPISODES_VARIETY_CONTENT_TITLE = "com.meizu.media.video:id/chanelprogramdetail_episodes_variety_item_content_title";
        /***
         * 滑动开关
         ***/
        public static final String ID_VIDEO_SWITCHWIDGET = "com.meizu.media.video:id/switchWidget";
        /***
         * 勾选
         ***/
        public static final String ID_CHECKBOX = "android:id/checkbox";
        /***
         * 个人中心登陆
         ***/
        public static final String ID_TITLE = "com.meizu.media.video:id/title";
        /***
         * 全屏播放界面视频名称
         ***/
        public static final String ID_ACTION_BAR_TITLE = "android:id/action_bar_title";
        /***
         * 播放历史列表视频图标
         ***/
        public static final String ID_PLAYHISTORY_ICON = "com.meizu.media.video:id/playhistory_icon";
        /***
         * 播放历史视频名称
         ***/
        public static final String ID_VIDEO_TITLE = "com.meizu.media.video:id/video_title";
        /***
         * 播放历史进度
         ***/
        public static final String ID_VIDEO_POSITION = "com.meizu.media.video:id/video_positon";
        /***
         * 搜索历史
         ***/
        public static final String ID_HISTORY_TEXT = "com.meizu.media.video:id/history_text";
        /***
         * 个人中心已缓存图标
         ***/
        public static final String ID_ICON = "com.meizu.media.video:id/icon";
        /***
         * 个人中心正在缓存视频图标
         ***/
        public static final String ID_VIDEO_COVER = "com.meizu.media.video:id/video_cover";
        /***
         * 缓存视频名称
         ***/
        public static final String ID_VIDEO_NAME = "com.meizu.media.video:id/video_name";
        /***
         * 文件夹左侧分类图标
         ***/
        public static final String ID_ITEM_ICON_VIEW = "com.meizu.filemanager:id/item_icon_view";
        /***
         * 文件夹中的文件，或者选择全部删除的右上角按键
         ***/
        public static final String ID_TEXT_ONE = "android:id/text1";
        /***
         * 个人中心-视频/收藏/历史
         ***/
        public static final String ID_CHANNEL_NAME = "com.meizu.media.video:id/search_m_bResulttype_channelname";
        /***
         * 小窗口播放界面暂停按钮
         ***/
        public static final String ID_MINI_PLAY_PAUSE_BTN = "com.meizu.media.video:id/mini_play_pause_btn";
        /***
         * 全屏播放界面开启悬浮窗按钮
         ***/
        public static final String ID_SWITCH_FLOATWINDOW = "com.meizu.media.video:id/switch_floatwindow";
        /***
         * 小窗口播放控件框
         ***/
        public static final String ID_MINI_CONTROLLER_BTN_LAYOUT = "com.meizu.media.video:id/mini_controller_btn_layout";
        /***
         * 个人中心一个收藏列表项的外框
         ***/
        public static final String ID_CHANEL_DETAIL_WHOLE = "com.meizu.media.video:id/chanelDetailWhole";
        /***
         * 推荐界面-热点/排行榜等分类图标
         ***/
        public static final String ID_CATEGORY_IMAGE = "com.meizu.media.video:id/category_image";
        /***
         * 全屏播放界面选集图标
         ***/
        public static final String ID_HORIZONTAL_EXPAND_LIST = "com.meizu.media.video:id/horizontal_expand_list";
        /***
         * 小窗口进度条
         ***/
        public static final String ID_MINI_SEEKBAR = "com.meizu.media.video:id/mini_seekbar";
        /***
         * 视频来源菜单的“视频源”
         ***/
        public static final String ID_RADIO = "com.meizu.media.video:id/radio";
        /***
         * 个人中心视频界面，"缓存中"/"已缓存"分组
         ***/
        public static final String ID_GROUP_NAME = "com.meizu.media.video:id/group_name";
        /***
         * "缓存中"/"已缓存"分组合上状态
         ***/
        public static final String ID_CHILD_COUNT = "com.meizu.media.video:id/child_count";
        /***
         * 一个缓存视频的外框
         ***/
        public static final String ID_ITEM_LAYOUT = "com.meizu.media.video:id/item_layout";
        /***
         * 设置界面滑动开关
         ***/
        public static final String ID_SETTING_SWITCHWIDGET = "com.android.settings:id/switchWidget";
        /***
         * 搜索视频时，自动联想
         ***/
        public static final String ID_LABEL_TEXT_ONE = "com.meizu.media.video:id/labelText1";
        /***
         * 视频个人中心，右上角登陆flyme账号的">"入口
         ***/
        public static final String ID_ARROW_RIGHT = "com.meizu.media.video:id/arrow_right";
        /***
         * 输入flyme账号框
         ***/
        public static final String ID_EDTACCOUNT = "com.meizu.account:id/edtAccount";
        /***
         * 输入flyme密码框
         ***/
        public static final String ID_EDTPWD = "com.meizu.account:id/edtPwd";
        /***
         * 登陆flyme按钮
         ***/
        public static final String ID_BTNLOGIN = "com.meizu.account:id/btnLogin";
        /***
         * 专题栏详情的视频描述
         ***/
        public static final String ID_SUBJECT_DESCRIPTION = "com.meizu.media.video:id/subject_content_item_description";
        /***
         * 一个专题详情的视频标题
         ***/
        public static final String ID_SUBJECT_HEAD_CONTENT = "com.meizu.media.video:id/subject_head_item_content";
        /***
         * 视频详情界面的详情描述
         ***/
        public static final String ID_DETAIL_INTRODUCTION = "com.meizu.media.video:id/chanelprogramdetail_introduction";
        /***
         * "确定"按钮
         ***/
        public static final String ID_BUTTON_ONE = "android:id/button1";
        /***
         * 全屏播放界面暂停播放按钮
         ***/
        public static final String ID_PAUSE = "com.meizu.media.video:id/pause";
        /***
         * 普通删除图标
         ***/
        public static final String ID_ACTION_DELETE = "com.meizu.media.video:id/action_delete";
        /***
         * 确认"删除"控件
         ***/
        public static final String ID_DELETE_TITLE = "android:id/title";
        /***
         * 下载界面进入码率选择
         ***/
        public static final String ID_ACTION_RATE = "com.meizu.media.video:id/action_rate";
        /***
         * 搜索结果列表的一条结果记录的对应的图片
         ***/
        public static final String ID_SEARCH_CONTENT_IMAGE = "com.meizu.media.video:id/searchContentAlbumContentImage";
        /***
         * 小窗口切换至全屏播放按钮
         ***/
        public static final String ID_MINI_SWITCH_BTN = "com.meizu.media.video:id/mini_switch_btn";
        /***
         * 视频详情界面右上角来源图标
         ***/
        public static final String ID_PLAY_SOURCE = "com.meizu.media.video:id/switch_playsource";
        /***
         * 下载视频标题
         ***/
        public static final String ID_DOWNLOAD_NAME = "com.meizu.media.video:id/download_name";
        /***
         * 全屏播放界面进度条
         ***/
        public static final String ID_PLAYER_BOTTOM_SEEKBAR_LAYOUT = "com.meizu.media.video:id/player_bottom_seekbar_layout";
        /***
         * 选座购票列表购票按钮
         ***/
        public static final String ID_TEMPLATE_ITEM_CONTENT_BUY = "com.meizu.media.video:id/template_item_content_buy";
        /***
         * 详情界面购票按钮
         ***/
        public static final String ID_CHANELPROGRAMDETAIL_BUTTON = "com.meizu.media.video:id/chanelProgramDetail_button";
        /***
         * 筛选信息
         ***/
        public static final String ID_FILTER_INFO = "com.meizu.media.video:id/filter_info";
        /***
         * 筛选项目
         ***/
        public static final String ID_NAME = "com.meizu.media.video:id/name";
    }

    /**
     * @author zhaoguofeng
     * @本地音乐ID和文本常量
     */
    public static class Music {
        /***
         * 存储盘路劲
         ***/
        public static final String MUSIC_MD = SDCARD_PATH + "/";
        /***
         * SD卡路劲
         ***/
        public static final String MUSIC_SD = SDCARD_PATH_ONE + "/";
        /***
         * 存储盘路劲，音乐目录
         ***/
        public static final String MUSIC_MD_MUSIC = SDCARD_PATH + "/Music/";
        /***
         * SD卡路劲，音乐目录
         ***/
        public static final String MUSIC_SD_MUSIC = SDCARD_PATH_ONE + "/Music/";
        /***
         * 存储盘路劲，音乐资源
         ***/
        public static final String MUSIC_MD_RES = SDCARD_PATH + "/AutoTest/res/MusicTestCase/";

        /**
         * 文本
         */
        /***
         * 本地音乐
         ***/
        public static final String TEXT_GERENZHONGXIN = "个人中心";
        public static final String TEXT_SONG1 = "song1";
        public static final String TEXT_SONG2 = "song2";
        public static final String TEXT_SONG3 = "song3";
        public static final String TEXT_SONG4 = "song4";
        public static final String TEXT_ADGY = "爱的供养";
        public static final String TEXT_YDSAKYCL = "有多少爱可以重来";
        public static final String TEXT_ZHUI = "zhui";
        public static final String TEXT_BOFANG = "播放";
        public static final String TEXT_CHONGMINGMING = "重命名";
        public static final String TEXT_SHANCHU = "删除";
        public static final String TEXT_QUEDING = "确定";
        public static final String TEXT_DJTJGE = "点击添加歌曲";
        public static final String TEXT_TESTINGS = "testings";
        public static final String TEXT_WODEZUIAI = "我的最爱";
        public static final String TEXT_NEW_MENU = "新建歌单";
        public static final String TEXT_DOWNLOAD = "下载";
        public static final String TEXT_DOWNLOADED = "已下载";
        public static final String TEXT_MY_SONG_MENU = "我的歌单";
        public static final String TEXT_ADD_TO = "添加至";
        public static final String TEXT_FINISH = "完成";
        public static final String TEXT_ACCOUNT_CENTER = "个人中心";
        public static final String TEXT_TOUCH_LOGIN = "点击登录";
        public static final String TEXT_ACCOUNT = "账户";
        public static final String TEXT_LOGIN = "登陆";
        public static final String TEXT_MUSIC = "音乐";
        public static final String TEXT_FOLDER = "文件夹";
        public static final String TEXT_WBFJL = "无播放记录";
        public static final String TEXT_ENABLE = "允许";
        public static final String TEXT_SAVE = "保存";
        public static final String BACK = "BACK";
        public static final String TEXT_BFLB = "播放列表";
        public static final String TEXT_NEW_BUILD_MUSICMENU = "添加至";
        public static final String TEXT_YRXX = "艺人信息";
        public static final String TEXT_YRZL = "艺人资料";
        public static final String TEXT_DETAILS = "详情";
        public static final String TEXT_ALBUM_DETAILS = "专辑详情";
        public static final String TEXT_QUANXUAN = "全选";
        public static final String TEXT_QUANBUXUAN = "全不选";
        public static final String TEXT_QUXIAO = "取消";
        public static final String TEXT_DHS = "Dirac HD Sound";
        public static final String TEXT_JUNHENGQI = "均衡器";
        public static final String TEXT_FENXIANG = "分享";
        public static final String TEXT_BIANJIGEDAN = "编辑歌单";
        public static final String TEXT_SHANCHUGEDAN = "删除歌单";
        public static final String TEXT_FABUGEDAN = "发布歌单";
        public static final String TEXT_QUXIAOFABU = "取消发布";
        public static final String TEXT_DJXZXSYY = "点击寻找相似音乐";
        /***
         * 在线音乐
         ***/
        public static final String TEXT_TUIJIAN = "推荐";
        public static final String TEXT_SHOUYE = "首页";
        public static final String TEXT_MEIRITUIJIAN = "每日推荐";
        public static final String TEXT_ZHUANTI = "专题";
        public static final String TEXT_GEQU = "歌曲";
        public static final String TEXT_YIREN = "艺人";
        public static final String TEXT_YRFL = "艺人分类";
        public static final String TEXT_ZHUANJI = "专辑";
        public static final String TEXT_GEDAN = "歌单";
        public static final String TEXT_PEIHANGBANG = "排行榜";
        public static final String TEXT_ZUIXINFAHANG = "最新发行";
        public static final String TEXT_YUEKU = "乐库";
        public static final String TEXT_WODEYINYUE = "我的音乐";
        public static final String TEXT_CAINIXIHUAN = "猜你喜欢";
        public static final String TEXT_XIAMICAINIXIHUAN = "虾米猜你喜欢";
        public static final String TEXT_DIANTAI = "电台";
        public static final String TEXT_QUANBUDIANTAI = "全部电台";
        public static final String TEXT_GONGGO0NG = "公共";
        public static final String TEXT_FENGGE = "风格";
        public static final String TEXT_TESHE = "特色";
        public static final String TEXT_MEIYOUGEQU = "没有歌曲";
        public static final String TEXT_JIXU = "继续";
        public static final String TEXT_ZANTINGXIAZAI = "暂停下载";
        public static final String TEXT_BUZAISHEBEISHANG = "不在设备上";
        public static final String TEXT_ZHENGZAIXIAZAI = "正在下载";
        public static final String TEXT_FENXIANGZHI = "分享至";
        public static final String TEXT_JIANJIE = "简介";
        /***
         * 全局
         ***/
        public static final String TEXT_1 = "1";
        public static final String O_PACKAGE = "com.meizu.media.music";
    }

    /**
     * @author zhaoguofeng
     * @flyme4的音乐appID和文本常量
     */
    public class MusicFlyme4 extends Music {
        /**
         * ID
         */

        /*** 本地音乐界面 ***/
        /***
         * shift+alt+j 个人中心tab
         ***/
        public static final String ID_ACCOUNT_TAB = "com.meizu.media.music:id/account_tab";
        /***
         * 搜索tab
         ***/
        public static final String ID_SEARCH_TAB = "com.meizu.media.music:id/search_tab";
        /***
         * 歌单管理tab
         ***/
        public static final String ID_CLASSIFY_TAB = "com.meizu.media.music:id/classify_tab";
        /***
         * 在线页面tab
         ***/
        public static final String ID_HOME_TAB = "com.meizu.media.music:id/home_tab";
        /***
         * 设置，均衡器按钮id
         ***/
        public static final String ID_EQ_SWITCH = "com.android.musicfx:id/eq_switch";
        /***
         * 设置，HD Sound按钮id
         ***/
        public static final String ID_DIRAC_SWITCH = "com.android.musicfx:id/dirac_switch";
        /***
         * 个人中心，我的歌单，封面id
         ***/
        public static final String ID_PLAYGRID_COVER = "com.meizu.media.music:id/playgrid_cover";
        /***
         * 个人中心，我的歌单，封面播放id
         ***/
        public static final String ID_PLAYGRID_IV = "com.meizu.media.music:id/playgrid_iv";
        /***
         * 个人中心，我的歌单,长按后我的歌单后产生,垃圾桶按钮id
         ***/
        public static final String ID_ACTION_DELETE_PLAYLIST = "com.meizu.media.music:id/action_delete_playlist";
        /***
         * 进入我的歌单后，编辑按钮id
         ***/
        public static final String ID_BUTTON_EDIT = "com.meizu.media.music:id/button_edit";
        /***
         * 我的歌单，进入编辑歌单，删除歌曲按钮id
         ***/
        public static final String ID_DELETE_PLAYLIST = "com.meizu.media.music:id/delete_playlist";
        /***
         * 我的歌单，进入编辑歌单，点击删除歌曲，提示删除歌曲数目id
         ***/
        public static final String ID_CHECK = "com.meizu.media.music:id/check";
        /***
         * 我的最爱 我的歌单 播放列表界面，选择歌曲后，删除按钮id
         ***/
        public static final String ID_ACTION_DELETE_FROM_PLAYLIST = "com.meizu.media.music:id/action_delete_from_playlist";

        /***
         * button1是确定按钮，button2是取消按钮
         ***/
        public static final String ID_ANDROID_BUTTON1 = "android:id/button1";
        /***
         * 进入本地音乐id（该ID显示歌曲数目）
         ***/
        public static final String ID_ALL_NUM = "com.meizu.media.music:id/all_num";
        /***
         * 进入最近播放id（该ID显示歌曲数目）
         ***/
        public static final String ID_RECENTLY_NUM = "com.meizu.media.music:id/recently_num";
        /***
         * 进入最近添加id（该ID显示歌曲数目）
         ***/
        public static final String ID_ADDED_NUM = "com.meizu.media.music:id/added_num";
        /***
         * 进入下载管理id（该ID显示歌曲数目）
         ***/
        public static final String ID_CATEGORY_NUM = "com.meizu.media.music:id/category_num";
        /***
         * 快速播放封面id，本地音乐
         ***/
        public static final String ID_ALL_IMAGE = "com.meizu.media.music:id/all_image";
        /***
         * 快速播放封面id，最近播放
         ***/
        public static final String ID_RECENTLY_IMAGE = "com.meizu.media.music:id/recently_image";
        /***
         * 快速播放封面id，最近添加
         ***/
        public static final String ID_ADDED_IMAGE = "com.meizu.media.music:id/added_image";
        /***
         * 快速播放封面id，下载管理
         ***/
        public static final String ID_DOWNLOAD_IMAGE = "com.meizu.media.music:id/download_image";
        /***
         * miniplay播放，点击后进入播放歌曲界面
         ***/
        public static final String ID_ARTIST_TEXT = "com.meizu.media.music:id/artist_text";
        /***
         * miniplay播放，心形按钮，添加到我的最爱
         ***/
        public static final String ID_ADD_TO_FAVORITE = "com.meizu.media.music:id/add_to_favorite";
        /***
         * 正在播放界面，歌曲名称id，通常用于获取歌曲名称所用
         ***/
        public static final String ID_MUSIC_TITLE = "com.meizu.media.music:id/music_title";
        /***
         * 正在播放界面，进入歌曲列表界面的按钮id
         ***/
        public static final String ID_MENU_SHOW_PLAYLIST = "com.meizu.media.music:id/menu_show_playlist";
        /***
         * 正在播放界面，进入 菜单 界面的按钮id
         ***/
        public static final String ID_MENU_MORE = "com.meizu.media.music:id/menu_more";
        /***
         * 正在播放界面，播放模式id
         ***/
        public static final String ID_MENU_PLAY_MODE = "com.meizu.media.music:id/menu_play_mode";
        /***
         * 正在播放界面，歌曲的播放时间id
         ***/
        public static final String ID_TIME_CURRENT = "com.meizu.media.music:id/time_current";
        /***
         * 正在播放界面，添加歌曲到歌单按钮id（即+按钮）
         ***/
        public static final String ID_MENU_ADD_TO_PLAYLIST = "com.meizu.media.music:id/menu_add_to_playlist";
        /***
         * 正在播放界面，歌曲收藏按钮
         ***/
        public static final String ID_FAVOURITE_MARK = "com.meizu.media.music:id/favourite_mark";
        /***
         * 正在播放界面，定时播放时间按钮id
         ***/
        public static final String ID_TIMER_TEXT = "com.meizu.media.music:id/timer_text";
        /***
         * 正在播放界面，上一首歌曲按钮
         ***/
        public static final String ID_IMAGER_PREV = "com.meizu.media.music:id/image_prev";
        /***
         * 正在播放界面，下一首歌曲按钮
         ***/
        public static final String ID_IMAGER_NEXT = "com.meizu.media.music:id/image_next";
        /***
         * 正在播放界面，播放按钮id
         ***/
        public static final String ID_PLAY_STATE = "com.meizu.media.music:id/play_state";
        /***
         * 正在播放界面，播放按钮id
         ***/
        public static final String ID_PLAYING_STATE = "com.meizu.media.music:id/playing_state";
        /***
         * 正在播放界面，长按封面后生成图片按钮id
         ***/
        public static final String ID_MENU_CREATE_PIC = "com.meizu.media.music:id/menu_create_pic";
        /***
         * 正在播放界面，进入编辑封面，歌词界面,的按钮界面
         ***/
        public static final String ID_IMAGER_EDIT_INFO = "com.meizu.media.music:id/image_edit_info";
        /***
         * 正在播放界面，进入编辑封面，点击编辑封面按钮
         ***/
        public static final String ID_IMAGER_EDIT_COVER = "com.meizu.media.music:id/image_edit_cover";
        /***
         * 正在播放界面，编辑封面界面
         ***/
        public static final String ID_THUMB_IMAGE = "com.meizu.media.music:id/thumb_image";
        /***
         * 正在播放界面，编辑歌词界面
         ***/
        public static final String ID_ITEM_LRC_SONG_NAME = "com.meizu.media.music:id/item_lrc_song_name";
        /***
         * 正在播放界面，点击+后，出现的歌单id
         ***/
        public static final String ID_ANDROID_TEXT1 = "android:id/text1";

        /***
         * 下载界面，选择歌曲后，删除按钮id
         ***/
        public static final String ID_ACTION_DELETE_FILE = "com.meizu.media.music:id/action_delete_file";
        /***
         * 下载界面，选择歌曲，点击删除按钮后，确认删除title的按钮id
         ***/
        public static final String ID_ANDROID_TITLE = "android:id/title";
        /***
         * 下载界面，选择歌曲后，暂停下载id
         ***/
        public static final String ID_ACTION_PAUSE_DOWNLOAD = "com.meizu.media.music:id/action_pause_download";
        /***
         * 下载界面，选择歌曲后，开始下载id
         ***/
        public static final String ID_ACTION_START_DOWNLOAD = "com.meizu.media.music:id/action_start_download";
        /***
         * 内存卡设置按钮id（是否将歌曲存储在内存卡中）
         ***/
        public static final String ID_DISK_SWITCH = "com.meizu.media.music:id/disk_switch";
        /***
         * 不同音乐版本，小三角
         ***/
        public static final String ID_POPUP_BUTTON_ARROW = "com.meizu.media.music:id/popup_button_arrow";
        /***
         * 编辑歌单界面，发布按钮id
         ***/
        public static final String ID_BUTTON_SHARE = "com.meizu.media.music:id/button_share";

        /*** 在线音乐界面 ***/
        /***
         * 在线音乐，进入具体歌曲列表界面，此id是包含一首歌曲所有信息的id
         ***/
        public static final String ID_LAYOUTCENTER = "com.meizu.media.music:id/layoutcenter";
        /***
         * 进入专题后的封面id，或艺人中专辑的封面id
         ***/
        public static final String ID_MEDIA_FOREGROUND_IMAGE = "com.meizu.media.music:id/media_foreground_image";
        /***
         * 点击排行榜或艺人后，包含一类歌曲的id
         ***/
        public static final String ID_DISCRIPTION = "com.meizu.media.music:id/discription";
        /***
         * 选择歌曲的小点id
         ***/
        public static final String ID_ANDROID_CHECHBOX = "android:id/checkbox";
        /***
         * 进入在线歌曲后具体的界面，中的播放按钮id
         ***/
        public static final String ID_BUTTON_PLAYER = "com.meizu.media.music:id/button_player";
        /***
         * 在线音乐，进入电台
         ***/
        public static final String ID_PLAYLIST_COVER = "com.meizu.media.music:id/playlist_cover";
        /***
         * 在线歌曲界面（存在封面），选择歌曲后，下载按钮id
         ***/
        public static final String ID_ACTION_DOWNLOAD = "com.meizu.media.music:id/action_download";
        /***
         * 在线歌曲界面（存在封面），歌曲名称的id
         ***/
        public static final String ID_TITLE = "com.meizu.media.music:id/title";
        /***
         * 在线歌曲界面（存在封面）,该在线音乐的名称（即最顶端的名称）
         ***/
        public static final String ID_TITLE_TEXT = "com.meizu.media.music:id/title_text";
        /***
         * 在线歌曲界面（存在封面）,选择歌曲后，添加歌曲到歌单按钮id
         ***/
        public static final String ID_ACTION_ADD_TO_PLAYLIST = "com.meizu.media.music:id/action_add_to_playlist";
        /***
         * 在线歌曲界面（存在封面），详情，更多，按钮id
         ***/
        public static final String ID_MORE_DETAIL = "com.meizu.media.music:id/more_detail";
        /***
         * 在线歌曲界面（存在封面），收藏按钮id
         ***/
        public static final String ID_BUTTON_COLLECT = "com.meizu.media.music:id/button_collect";
        /***
         * 点击排行榜后，封面中的的播放按钮id
         ***/
        public static final String ID_PLAY = "com.meizu.media.music:id/play";
        /***
         * 艺人，专辑，封面名称的id
         ***/
        public static final String ID_NAME = "com.meizu.media.music:id/name";
        /***
         * 电台，封面，播放按钮id
         ***/
        public static final String ID_ICON = "com.meizu.media.music:id/icon";
        /***
         * 电台，点击+进入频道管理，打钩按钮id
         ***/
        public static final String ID_CHANNEL_CHECKBOX = "com.meizu.media.music:id/channel_checkbox";
        /***
         * 搜索界面，输入信息按钮id
         ***/
        public static final String ID_QUERY_TEXT = "com.meizu.media.music:id/query_text";
        /***
         * 搜索界面，输入信息框，打叉图标（输入框中有信息时才存在）
         ***/
        public static final String ID_CANCEL = "com.meizu.media.music:id/cancel";
        /***
         * 搜索界面，热词id
         ***/
        public static final String ID_HOT_SEARCH_ITEM_TITLE = "com.meizu.media.music:id/hot_search_item_title";

        /*** 登录退出flyme账号 ***/
        /***
         * flyme登录界面，输入 账号 id
         ***/
        public static final String ID_EDTACCOUNT = "com.meizu.account:id/edtAccount";
        /***
         * flyme登录界面，输入 密码 id
         ***/
        public static final String ID_EDTPWD = "com.meizu.account:id/edtPwd";
        /***
         * flyme登录后，是否跳过绑定淘宝账号id
         ***/
        public static final String ID_SKIP = "com.meizu.account:id/skip";
        /***
         * flyme登录后，显示账号信息，账号余额id
         ***/
        public static final String ID_ACCOUNT_CREDIT = "com.meizu.media.music:id/account_credit";
        /***
         * 进入设置应用后，图标的按钮id
         ***/
        public static final String ID_ICON_PANEL = "com.android.settings:id/icon_panel";
        /***
         * 设置应用，账号信息，封面图标按钮id
         ***/
        public static final String ID_IMAGE = "com.android.settings:id/image";
        /***
         * 设置应用，账号，点击后进入个人中心界面
         ***/
        public static final String ID_PROFILEOPTION = "com.meizu.account:id/profileOption";
        /***
         * 设置应用，账号信息，点击封面图标，第一次进入会出现是否同步选择界面
         ***/
        public static final String ID_OPTIONCHECKBOX = "com.meizu.account:id/optionCheckBox";

    }

    /**
     * 画板模块ID和文本常量
     *
     * @author FanLong
     */
    public class Paint {
        /**
         * 文本
         */
        /***
         * 显示图片数量
         ***/
        public static final String PAINT_NUM = "com.meizu.media.painter:id/pager_background";
        /***
         * 新建画板按钮
         ***/
        public static final String PAINT_NEW = "com.meizu.media.painter:id/action_create";
        /***
         * 填充图案
         ***/
        public static final String PAINT_FILL = "com.meizu.media.painter:id/action_texture";
        /***
         * 裁剪
         ***/
        public static final String CUT = "com.meizu.media.painter:id/action_cut";
        /***
         * 点击图片
         ***/
        public static final String SHADE = "com.meizu.media.painter:id/shade";

    }

    /**
     * 设置模块ID和文本常量
     *
     * @author lizhengui
     */
    public class Setting {
        /**
         * 文本
         */
        /***
         * TEXT 设置
         ***/
        public static final String ID_TEXT_SETTING = "设置";
        /***
         * TEXT 全部
         ***/
        public static final String ID_TEXT_ALL = "全部";
        /***
         * TEXT 清除数据
         ***/
        public static final String ID_TEXT_CLEAR_DATA = "清除数据";
        /***
         * TEXT 更改密码
         ***/
        public static final String ID_TEXT_CHANGE_PSW = "更改密码";
        /***
         * TEXT 主题
         ***/
        public static final String ID_TEXT_THEME = "主题";
        /***
         * TEXT 便携式热点
         ***/
        public static final String ID_TEXT_HOTSPOT = "便携式热点";
        /***
         * TEXT NFC
         ***/
        public static final String ID_TEXT_NFC = "NFC";
        /***
         * TEXT 语言和时间
         ***/
        public static final String ID_TEXT_LANGUANGTIME = "语言和时间";
        /***
         * TEXT 语言
         ***/
        public static final String ID_TEXT_LANGUAGE = "语言";
        /***
         * TEXT 系统和键盘
         ***/
        public static final String ID_TEXT_SYSTEM = "系统和键盘";
        /***
         * TEXT 应用管理
         ***/
        public static final String ID_TEXT_APPLICATION = "应用管理";
        /***
         * TEXT 屏幕密码
         ***/
        public static final String ID_TEXT_SCREENPSW = "屏幕密码";
        /***
         * TEXT 文档锁定区
         ***/
        public static final String ID_TEXT_FILELOCK = "文档锁定区";
        /***
         * TEXT 应用加密
         ***/
        public static final String ID_TEXT_APPLOCK = "应用加密";

        /**
         * ID
         */
        /***
         * 设置侧栏ID
         ***/
        public static final String ID_ICON = "com.android.settings:id/icon";
        /***
         * 开关
         ***/
        public static final String ID_SWITCH_WIDGET = "com.android.settings:id/switchWidget";
        /***
         * 简单密码框
         ***/
        public static final String ID_SIMPLE = "flyme:id/keyPad";
        /***
         * 复杂密码框
         ***/
        public static final String ID_COMPLEX = "flyme:id/keypadRoot";
        public static final String ID_COMPLEX_FLYME5 = "flyme:id/password_edit";
        /***
         * 标题头
         ***/
        public static final String ID_HEADLINE = "android:id/action_bar_title";
        /***
         * 进入账户
         ***/
        public static final String ID_ENTER = "com.android.settings:id/enter";
        /***
         * 账号输入框
         ***/
        public static final String ID_EDTACCOUT = "com.meizu.account:id/edtAccount";
        /***
         * 密码输入框
         ***/
        public static final String ID_EDTPED = "com.meizu.account:id/edtPwd";
        /***
         * 登录账户完成按钮
         ***/
        public static final String ID_BTNLOGIN = "com.meizu.account:id/btnLogin";
        /***
         * 账户信息同步
         ***/
        public static final String ID_OPTIONCHECKBOX = "com.meizu.account:id/optionCheckBox";
        /***
         * 清空密码按键
         ***/
        public static final String ID_TEXT_BUTTON = "flyme:id/text_button";
        /***
         * 输入第二遍密码
         ***/
        public static final String ID_FINISH = "com.android.settings:id/finish";
        /***
         * 文档侧栏按钮
         ***/
        public static final String ID_FILE_ICON = "com.meizu.filemanager:id/item_icon_view";
        /***
         * 弹框右边按钮
         ***/
        public static final String ID_BUTTON1 = "android:id/button1";
        /***
         * 时区搜索
         ***/
        public static final String ID_SEARCH_TEXT = "com.android.settings:id/search_text";
        /***
         * 应用管理-全部的Id
         ***/
        public static final String ID_SCROLL1 = "com.android.settings:id/scroll1";
        /***
         * 应用管理-缓存进程的Id
         ***/
        public static final String ID_SCROLL3 = "com.android.settings:id/scroll3";
        /***
         * YUNOS 法律信息
         ***/
        public static final String ID_PARENTPANEL = "android:id/parentPanel";
        /***
         * ALLOW 允许框的允许按钮
         ***/
        public static final String ID_ALLOW = "android:id/button1";
        /***
         * 搜索
         ***/
        public static final String ID_SEARCH = "com.android.settings:id/search";
        /***
         * 搜索框
         ***/
        public static final String ID_SEARCH_EDIT = "com.android.settings:id/mc_search_edit";
        /***
         * 搜索框-清除输入
         ***/
        public static final String ID_SEARCH_CLEAR = "com.android.settings:id/mc_search_icon_input_clear";
        /***
         * 搜索框-清除历史
         ***/
        public static final String ID_SEARCH_CLEAR_HISTORY = "com.android.settings:id/clear_history_button";
        /***
         * 搜索框-搜索记录为空
         ***/
        public static final String ID_SEARCH_NO_HISTORY = "com.android.settings:id/no_search_history";

        /***
         * 应用管理-正在运行的ID
         ***/
        public static final String ID_RUNING = "com.android.settings:id/runningText";
        /***
         * 应用管理-缓存进程的ID
         ***/
        public static final String ID_CACHED = "com.android.settings:id/cachedText";
        /***
         * 个性化 -已试用的ID
         ***/
        public static final String ID_USED = "com.meizu.customizecenter:id/name";

    }

    /**
     * 安全中心模块ID和文本常量
     *
     * @author lizhengui
     */
    public class Safe {
        /**
         * ID
         */
        /***
         * 流量管理设置Id
         ***/
        public static final String ID_GPRS_SET = "com.meizu.safe:id/toSetup_ImageView";
        /***
         * 下拉框，展开图标开关
         ***/
        public static final String ID_EXPAND_WIDGETS = "com.android.systemui:id/expand_widgets_button";
        /***
         * 省电模式，剩余时间中小时ID
         ***/
        public static final String ID_SUB_HOUR = "com.meizu.safe:id/tv_sub_hour";
        /***
         * 权限管理APP开关ID
         ***/
        public static final String ID_APPINFO_CHOOSE = "com.meizu.safe:id/secapp_appinfo_choose";
        /***
         * 拨打电话界面联系人
         ***/
        public static final String ID_DIALER_NAME = "com.android.dialer:id/name";
        /***
         * 挂断电话
         ***/
        public static final String ID_ENDBUTTON = "com.android.dialer:id/endButton";
        /***
         * 权限管理搜索APP输入框
         ***/
        public static final String ID_ET_SEARCH = "com.meizu.safe:id/et_search";
        /***
         * 流量管理
         ***/
        public static final String ID_FLOW_MANAGE_TITLE = "com.meizu.safe:id/flow_manage_title";
        /***
         * 流量监控
         ***/
        public static final String ID_SRAFFIC_SWITCH = "com.meizu.safe:id/traffic_switch";
        /***
         * 流量使用预警
         ***/
        public static final String ID_WARNING_SEEKBAR = "com.meizu.safe:id/warningSeekBar";
        /***
         * 病毒查杀中心图标
         ***/
        public static final String ID_PROGRESS = "com.meizu.safe:id/progress";
        /***
         * 病毒查杀设置
         ***/
        public static final String ID_SB_SETTINGS = "com.meizu.safe:id/ic_sb_settings";
        /***
         * 安全中心开关
         ***/
        public static final String ID_SWITCHWIDGET = "com.meizu.safe:id/switchWidget";
        /***
         * 大文件管理
         ***/
        public static final String ID_LARGE_FILE_MAGEGE = "com.meizu.safe:id/large_file_manage_icon_mark";
        /***
         * 大文件管理文字
         ***/
        public static final String ID_LARGE_FILE_TEXT = "com.meizu.safe:id/large_file_manage_title";
        /***
         * 病毒文件删除按钮
         ***/
        public static final String ID_ACTION_DELETE = "com.android.packageinstaller:id/action_delete";
        /***
         * 病毒个体
         ***/
        public static final String ID_VIRUS_GUIDE = "com.meizu.safe:id/virus_guide";
        /***
         * 卸载病毒
         ***/
        public static final String ID_UNINSTALL_VIRUS = "com.meizu.safe:id/uninstall_virus";
        /***
         * 大文件总数
         ***/
        public static final String ID_FILE_TOTAL_NUM = "com.meizu.safe:id/file_total_num";
        /***
         * 选中大文件按钮1
         ***/
        public static final String ID_NOTIFICATION_SWITCH = "android:id/notification_switch";
        /***
         * 选中大文件按钮2
         ***/
        public static final String ID_CHECKBOX = "android:id/checkbox";
        /***
         * 垃圾清理设置ID
         ***/
        public static final String ID_SETTINGS = "com.meizu.safe:id/settings";
        /***
         * 垃圾清理-内存加速选择框
         ***/
        public static final String ID_NOTIFICATION = "com.meizu.safe:id/notification_switch";

        /***
         * 垃圾清理
         ***/
        public static final String ID_RUBBISHCLEAN = "com.meizu.safe:id/rubbish_clean_icon";
        /***
         * 垃圾清理 具体清理类别项
         ***/
        public static final String ID_RUBBISHITEM = "com.meizu.safe:id/app_name";
        /***
         * 大文件管理
         ***/
        public static final String ID_LARGE_FILE = "com.meizu.safe:id/large_file_manage_panel";
        /***
         * 应用清理
         ***/
        public static final String ID_APP_CLEAN = "com.meizu.safe:id/app_clean_panel";
        /***
         * 流量管理
         ***/
        public static final String ID_FLOW_MANAGE = "com.meizu.safe:id/flow_manage_panel";
        /***
         * 病毒查杀
         ***/
        public static final String ID_VIRUS_CLEAN = "com.meizu.safe:id/virus_clean_panel";
        /***
         * 权限管理
         ***/
        public static final String ID_PERMISION_MANAGE = "com.meizu.safe:id/permision_manage_panel";
        /***
         * 省电模式
         ***/
        public static final String ID_POWER_MANAGE = "com.meizu.safe:id/power_mode_panel";
        /***
         * 应用清理 不常用应用总数
         ***/
        public static final String ID_APP_CLEAN_NUM = "com.meizu.safe:id/app_num";
        /***
         * 权限管理-自启动
         ***/
        public static final String ID_PERMISION_TITLE = "com.meizu.safe:id/tv_title";
        /***
         * 病毒查杀-完成
         ***/
        public static final String ID_VIRUS_CLEAN_DONE = "com.meizu.safe:id/action_settings";
        /***
         * 流量管理 -向运营商校验
         ***/
        public static final String ID_FLOW_CHEAK = "com.meizu.safe:id/correct_traffic_by_carry_summary";
        /***
         * 右上角删除图标
         ***/
        public static final String ID_SELECT_ALL = "android:id/text1";
        /***
         * id/widget_frame
         ***/
        public static final String ID_WIDGET_FRAME = "android:id/widget_frame";
        /***
         * 列表项右方箭头
         ***/
        public static final String ID_ARROW = "com.meizu.safe:id/arrow";
        /***
         * preference
         ***/
        public static final String ID_PREFERENCE = "com.meizu.safe:id/preference_text_layout";
        /***
         * 白名单添加按钮
         ***/
        public static final String ID_ADD_TRUST = "com.meizu.safe:id/btn_add_trust_apps";

    }

    /**
     * 阿里云安全中心ID和文本常量
     *
     * @author lizhengui
     */
    public class YunOSSafe {
        /**
         * ID
         */
        /***
         * 垃圾清理
         ***/
        public static final String ID_RUBBISHCLEAN = "com.meizu.safe:id/rubbish_clean_icon";
        /***
         * 垃圾清理 具体清理类别项
         */
        public static final String ID_RUBBISHITEM = "com.meizu.safe:id/app_name";
        /***
         * 大文件管理
         ***/
        public static final String ID_LARGE_FILE = "com.meizu.safe:id/large_file_manage_panel";
        /***
         * 应用清理
         ***/
        public static final String ID_APP_CLEAN = "com.meizu.safe:id/app_clean_panel";
        /***
         * 流量管理
         ***/
        public static final String ID_FLOW_MANAGE = "com.meizu.safe:id/flow_manage_panel";
        /***
         * 病毒查杀
         ***/
        public static final String ID_VIRUS_CLEAN = "com.meizu.safe:id/virus_clean_panel";
        /***
         * 权限管理
         ***/
        public static final String ID_PERMISION_MANAGE = "com.meizu.safe:id/permision_manage_panel";
        /***
         * 省电模式
         ***/
        public static final String ID_POWER_MANAGE = "com.meizu.safe:id/power_mode_panel";
        /***
         * 应用清理 不常用应用总数
         ***/
        public static final String ID_APP_CLEAN_NUM = "com.meizu.safe:id/app_num";
        /***
         * 权限管理-自启动
         ***/
        public static final String ID_PERMISION_TITLE = "com.meizu.safe:id/tv_title";
        /***
         * 病毒查杀-完成
         ***/
        public static final String ID_VIRUS_CLEAN_DONE = "com.meizu.safe:id/action_settings";
        /***
         * 流量管理 -向运营商校验
         ***/
        public static final String ID_FLOW_CHEAK = "com.meizu.safe:id/correct_traffic_by_carry_summary";
        /***
         * 右上角删除图标
         ***/
        public static final String ID_SELECT_ALL = "android:id/text1";
        /***
         * id/widget_frame
         ***/
        public static final String ID_WIDGET_FRAME = "android:id/widget_frame";
        /***
         * 列表项右方箭头
         ***/
        public static final String ID_ARROW = "com.meizu.safe:id/arrow";
        /***
         * preference
         ***/
        public static final String ID_PREFERENCE = "com.meizu.safe:id/preference_text_layout";
        /***
         * 白名单添加按钮
         ***/
        public static final String ID_ADD_TRUST = "com.meizu.safe:id/btn_add_trust_apps";
        /***
         * 应用白名单
         ***/
        public static final String ID_IGNORE_LIST = "com.aliyun.SecurityCenter:id/ignore_list_image";
        /***
         * 应用名单
         ***/
        public static final String ID_APPNAME = "com.aliyun.SecurityCenter:id/app_name";
        /***
         * 自启动管理
         ***/
        public static final String ID_BOOT_OPTIMIZATION = "com.aliyun.SecurityCenter:id/boot_optimization_image";
        /***
         * 病毒扫描
         ***/
        public static final String ID_MALWARESCAN = "com.aliyun.SecurityCenter:id/malwareScan";
        /***
         * 流量监控主屏
         ***/
        public static final String ID_GPRS_SCREEN = "com.aliyun.SecurityCenter:id/imageView12";
        /***
         * 流量套餐设置
         ***/
        public static final String ID_HW_ACTION_BAR_TITLE = "com.aliyun.SecurityCenter:id/hw_action_bar_title";
        /***
         * 本月已用输入框
         ***/
        public static final String ID_MONTH_USE = "com.aliyun.SecurityCenter:id/month_used";
        /***
         * 流量监控标题
         ***/
        public static final String ID_DATA_USAGE_TITLE = "com.aliyun.SecurityCenter:id/data_usage_title";
        /***
         * 流量套餐设置图标
         ***/
        public static final String ID_IMAGEVIEW3 = "com.aliyun.SecurityCenter:id/imageView3";
        /***
         * 流量剩余不足10%提醒
         ***/
        public static final String ID_WARN = "com.aliyun.SecurityCenter:id/warn";
        /***
         * 弹框信息
         ***/
        public static final String ID_MESSAGE = "android:id/message";
        /***
         * 相机录像
         ***/
        public static final String ID_RECORD_VIDEO_BTN = "com.meizu.media.camera:id/record_video_btn";
        /***
         * 号码
         ***/
        public static final String ID_PHONE_NUM = "com.aliyun.SecurityCenter:id/phone_num";
        /***
         * 备注
         ***/
        public static final String ID_COMMENT = "com.aliyun.SecurityCenter:id/comment";
        /***
         * 设置界面文本
         ***/
        public static final String ID_HW_TEXT = "com.aliyun.SecurityCenter:id/hw_text";
        /***
         * 拦截界面设置按钮
         ***/
        public static final String ID_TOGGLE = "com.aliyun.SecurityCenter:id/toggle";
        /***
         * 开启短信关键字拦截
         ***/
        public static final String ID_SWITCH_VIEW = "com.aliyun.SecurityCenter:id/switch_view";
        /***
         * 垃圾拦截设置-清理时间-增加
         ***/
        public static final String ID_INCREMENT = "android:id/increment";
        /***
         * 垃圾清理设置
         ***/
        public static final String ID_TRASH_CLEAR_SETTINGS = "com.aliyun.SecurityCenter:id/trash_clean_settings_icon";
        /***
         * 上下午
         ***/
        public static final String ID_AMPM = "android:id/amPm";
        /***
         * 点击优化
         ***/
        public static final String ID_HEALTH_CHECK = "com.aliyun.SecurityCenter:id/health_check_btn";

    }

    /**
     * 电话模块ID和文本常量
     *
     * @author zhangziqian
     */
    public class PhoneCall {
        /**
         * 文本
         */
        public static final String TEXT_CALL = "拨打";
        public static final String TEXT_SIMCALL = "卡1拨打";
        public static final String TEXT_RING_UP = "挂断";
        public static final String TEXT_ENSURE = "确定";

        /**
         * ID
         */
        /***
         * 添加联系人加号
         ***/
        public static final String ID_ADDCONTACT_BUTTON = "com.android.dialer:id/addContactButton";
        /***
         * 电话退格键
         ***/
        public static final String ID_DELETE_BUTTON = "com.android.dialer:id/deleteButton";
        /***
         * 电话挂断键
         ***/
        public static final String ID_END_BUTTON = "com.android.dialer:id/endButton";
        /***
         * 添加为联系人选择框标题
         ***/
        public static final String ID_ALERTITLE = "android:id/alertTitle";
        /***
         * 设置指纹与安全中的屏幕密码开关
         ***/
        public static final String ID_SETTINGS_SWITCHWIDGET = "com.android.settings:id/switchWidget";
        /***
         * 来电等待开关
         ***/
        public static final String ID_PHONE_SWITCHWIDGET = "com.android.phone:id/switchWidget";
        /***
         * 电话键盘
         ***/
        public static final String ID_DIALPADBUTTON = "com.android.dialer:id/dialpadButton";
        /***
         * 简易模式电话键盘
         ***/
        public static final String ID_EASYDIALPADBUTTON = "com.android.dialer:id/simpleDialpadButton";
        /***
         * 简易模式电话删除键
         ***/
        public static final String ID_DELETEBTN = "com.meizu.flyme.easylauncher:id/deleteBtn";
        /***
         * 简易模式电话扬声器
         ***/
        public static final String ID_AUDIOBUTTON = "com.android.dialer:id/audioButton";
        /***
         * 简易模式电话联系人姓名
         ***/
        public static final String ID_ID_NAME = "com.android.dialer:id/name";
        /***
         * 简易模式电话所属地区
         ***/
        public static final String ID_PHONELOCATION = "com.android.dialer:id/phoneLocation";
        /***
         * 拨号联想名
         ***/
        public static final String ID_NAME_TEXT = "com.android.dialer:id/name_text";

        /***
         * 来电等待开启按钮(电信版)
         ***/
        public static final String ID_PHONE_ENABLE = "com.android.phone:id/enable";

        /***
         * flyme5.0 拨打按钮
         ***/
        public static final String ID_FLOATING_BUTTON = "com.android.dialer:id/dialpad_floating_action_button";
        /***
         * flyme5.0 电话键盘
         ***/
        public static final String ID_DIALPAD_BUTTON = "com.android.incallui:id/dialpadButton";
        /***
         * flyme5.0 通话录音开关
         ***/
        public static final String ID_SWITCHWIDGET = "com.android.phone:id/switchWidget";

    }

    /**
     * PLMN模块ID和文本常量
     *
     * @author zhangziqian
     */
    public class PLMN {
        /**
         * ID
         */
        /***
         * 设置左侧栏标题
         ***/
        public static final String ID_ICON_PANEL = "com.android.settings:id/icon_panel";
        /***
         * 设置中的双卡与网络列表
         ***/
        public static final String ID_TEXT_LAYOUT = "com.android.settings:id/preference_text_layout";
        /***
         * 设置中的双卡名称
         ***/
        public static final String ID_IDTITLE = "android:id/title";
        /***
         * 设置中的双卡号码和网络模式
         ***/
        public static final String ID_SUMMARY = "android:id/summary";
        /***
         * 控件的text属性
         ***/
        public static final String ID_TEXT = "text";
        /***
         * 设置中移动数据开关
         ***/
        public static final String ID_SWITCHWIDGET = "com.android.settings:id/switchWidget";
        /***
         * 设置中移动数据卡1，卡2的选择框
         ***/
        public static final String ID_CHECKBOX = "android:id/checkbox";
        /***
         * APN选择按钮
         ***/
        public static final String ID_RADIOBUTTON = "com.android.settings:id/apn_radiobutton";
        /***
         * 返回键
         ***/
        public static final String ID_BACK = "BACK";
        /***
         * 2G,3G,4G网络模式
         ***/
        public static final String ID_TEXT1 = "com.android.settings:id/text1";
        /***
         * 网络模式下显示的2G,3G,4G
         ***/
        public static final String ID_DESCRIPTION = "com.android.systemui:id/description";
        /***
         * 等待时间
         ***/
        public static final int WAIT_TIMES = 1000;
    }

    /**
     * 通话记录模块ID和文本常量
     *
     * @author zhangziqian
     */
    public class CallLog {
        /**
         * 文本
         */
        public static final String TEXT_ENSURE = "确定";
        public static final String TEXT_SELECT = "呼叫选择";

        /**
         * ID
         */
        /***
         * 右上角删除图标或者SIM卡联系人的名称
         ***/
        public static final String ID_TEXT1 = "android:id/text1";
        /***
         * 删除确认键或者双卡选项
         ***/
        public static final String ID_TITLE = "android:id/title";
        /***
         * 呼出电话图标
         ***/
        public static final String ID_CALL_TYPE = "com.android.dialer:id/call_log_list_item_view_call_type";
        /***
         * 挂断电话键
         ***/
        public static final String ID_ENDBUTTON = "com.android.dialer:id/endButton";
        /***
         * 无卡拨打电话，出现无法连接移动网络的确定键
         ***/
        public static final String ID_BUTTON1 = "android:id/button1";
        /***
         * 分享联系人
         ***/
        public static final String ID_ALERTTITLE = "android:id/alertTitle";
        /***
         * 通话记录中的快捷图片
         ***/
        public static final String ID_PHOTO = "com.android.dialer:id/photo";
        /***
         * 通话记录中的电话名称
         ***/
        public static final String ID_NAME_TEXTVIEW = "com.android.dialer:id/cliv_name_textview";
        /***
         * 通话记录列表的号码名称
         ***/
        public static final String ID_NAME = "com.android.dialer:id/name";
        /***
         * 通话记录列表中的号码
         ***/
        public static final String ID_NUMBER = "com.android.dialer:id/phone_number";
        /***
         * 限制陌生人来电图标
         ***/
        public static final String ID_RIGHT_ICON = "com.android.dialer:id/action_bar_right_icon";
        /***
         * 限制来电开关
         ***/
        public static final String ID_SWITCHWIDGET = "com.meizu.blockservice:id/switchWidget";
        /***
         * 标记号码
         ***/
        public static final String ID_REMARK = "remark";
        /***
         * 简易模式通话记录联系人
         ***/
        public static final String ID_NAMETV = "com.meizu.flyme.easylauncher:id/nameTv";

    }

    /**
     * BeforeStarting模块ID和文本常量
     *
     * @author gouzhenzhen
     */
    public class BS {
        /**
         * ID
         */
        /***
         * 设置界面，“个性化”左边的小图标，点击展开左栏
         ***/
        public static final String ID_UP = "android:id/up";
        /***
         * 关于手机界面，IMEI的id
         ***/
        public static final String ID_DEVICEIDONE = "com.android.settings:id/deviceIdOne";
        /***
         * “开启Flyme通讯”弹框中，“下次不再提醒”的id
         ***/
        public static final String ID_DELETE_LOCKED = "com.android.dialer:id/delete_locked";
        /***
         * "确定"id
         ***/
        public static final String ID_BUTTON1 = "android:id/button1";
        /***
         * 通知栏界面，显示文本的id
         ***/
        public static final String ID_DESCRIPTION = "com.android.systemui:id/description";
        /***
         * 通知栏界面，显示点下三角后文字的id
         ***/
        public static final String ID_NAME = "com.android.systemui:id/name";

    }

    /**
     * 蓝牙模块ID和文本常量
     *
     * @author gouzhenzhen
     */
    public class BT {
        /**
         * 文本
         */
        public static final String TEXT_BLUETOOTH = "蓝牙";
        public static final String TEXT_DISCOVERABLE = "可被发现";

        /**
         * ID
         */
        /***
         * 通知栏图标
         ***/
        public static final String ID_NOTICE_ICON = "com.android.systemui:id/icon";
        /***
         * 设置左栏图标
         ***/
        public static final String ID_ICON = "com.android.settings:id/icon";
        /***
         * 蓝牙界面，“蓝牙”开关
         ***/
        public static final String ID_SWITCHWIDGET = "com.android.settings:id/switchWidget";
        /***
         * “开启蓝牙可被发现”弹框，“取消”按键
         ***/
        public static final String ID_BUTTON2 = "android:id/button2";
        /***
         * “开启蓝牙可被发现”弹框，“开启”按键
         ***/
        public static final String ID_BUTTON1 = "android:id/button1";
        /***
         * 蓝牙界面“可被发现”开关
         ***/
        public static final String ID_CHECKBOX = "android:id/checkbox";

    }

    /**
     * 情景模式模块ID和文本常量
     *
     * @author gouzhenzhen
     */
    public class Contextual {
        /**
         * 文本
         */
        public static final String TEXT_MANUALLY_ENABLE = "手动启用";
        public static final String TEXT_NODISTURB_OPENED = "免打扰已开启";
        public static final String TEXT_AUTOPLAY_MUSIC = "自动播放音乐";
        public static final String TEXT_DRIVER_ASSISTANCE = "驾驶辅助";
        public static final String TEXT_CONFIRM = "确定";
    }

    /**
     * 标题栏和通知栏模块ID和文本常量
     *
     * @author gouzhenzhen
     */
    public class TitleAndNoticeBar {
        /**
         * ID
         */
        /***
         * 下载界面“新建任务”控件
         ***/
        public static final String ID_NEW_TASK = "com.android.providers.downloads.ui:id/new_task";
        /***
         * 标题栏扩展按键
         ***/
        public static final String ID_EXPAND_WIDGETS_BUTTON = "com.android.systemui:id/expand_widgets_button";
    }

    /**
     * 兼容性模块ID和文本常量
     *
     * @author gouzhenzhen
     */
    public class Compatibility {
        /**
         * 文本
         */
        public static final String TEXT_ALLOW = "允许";
        public static final String TEXT_ENTER_MARKET = "进入市场";
        public static final String TEXT_PASS = "跳过";
        public static final String TEXT_INSTALL = "安装";
        public static final String TEXT_OPEN = "打开";
        public static final String TEXT_START_INSTALL = "开始安装";
        public static final String TEXT_INSTALLED = "已安装";
        public static final String TEXT_EXISTING = "现有";
        public static final String TEXT_UNABLE_LOGIN = "无法登陆";
        public static final String TEXT_RETRY = "重试";
        public static final String TEXT_ACCEPT = "接受";
        public static final String TEXT_RELATED_APPLICATION = "关联的应用";
        public static final String TEXT_APPLICATION_MANAGEMENT = "应用管理";
        public static final String TEXT_UNINSTALL = "卸载";
        public static final String TEXT_CONFIRM = "确定";
        public static final String TEXT_INATALLED = "已安装";

        /**
         * ID
         */
        /***
         * 登陆Play商店，输入账号id
         ***/
        public static final String ID_USERNAME_EDIT = "com.google.android.gsf.login:id/username_edit";
        /***
         * 登陆Play商店，账号密码id
         ***/
        public static final String ID_PASSWORD_EDIT = "com.google.android.gsf.login:id/password_edit";
        /***
         * 登陆Play界面/Google 服务界面，“右指向箭头”图标
         ***/
        public static final String ID_NEXT_BUTTON = "com.google.android.gsf.login:id/next_button";
        /***
         * 登陆Play界面，点击“右指向箭头”图标后出现的弹框
         ***/
        public static final String ID_SIGN_IN_AGREEMENT = "com.google.android.gsf.login:id/sign_in_agreement";

        /***
         * Play商店界面，“更多”id
         ***/
        public static final String ID_HEADER_MORE = "com.android.vending:id/header_more";
        /***
         * Play商店界面，最上面的搜索框
         ***/
        public static final String ID_SEARCH_BUTTON = "com.android.vending:id/search_button";
        /***
         * 登陆Play界面,“接受”按钮
         ***/
        public static final String ID_POSITIVE_BUTTON = "com.android.vending:id/positive_button";
        /***
         * Google界面，Google搜索框
         ***/
        public static final String ID_TEXT_CONTAINER = "com.google.android.googlequicksearchbox:id/text_container";
        /***
         * Google界面，输入“baidu”后，下面一栏中“搜索”图标
         ***/
        public static final String ID_CORPUS_ICON = "com.google.android.googlequicksearchbox:id/corpus_icon";

        /***
         * 已安装界面的第一个应用
         ***/
        public static final String ID_MIDDLELAYOUT = "com.meizu.mstore:id/middleLayout";
        /***
         * 已安装界面的删除图标
         ***/
        public static final String ID_MENU_DELETE = "com.meizu.mstore:id/menu_delete";

    }

    /**
     * 拨号盘模块ID和文本常量
     *
     * @author Fengweijie
     */
    public class DialPad {
        /**
         * 文本
         */
        public static final String TEXT_DIALPAD = "拨号盘";

        /**
         * ID
         */
        /***
         * 弹出允许框
         */
        public static final String ID_DELETE_LOCKED = "com.android.mms:id/delete_locked";
        /***
         * 允许框的取消按钮
         ****/
        public static final String ID_CANNEL_BUTTON = "android:id/button2";
        /***
         * 键盘的"*"号键
         ***/
        public static final String ID_DIALPAD_STAR = "com.android.dialer:id/dialpadStar";
        /***
         * 键盘的"*"号键
         ***/
        public static final String FM5_ID_DIALPAD_STAR = "com.android.dialer:id/star";
        /***
         * 键盘的"#"号键
         ***/
        public static final String ID_DIALPAD_POUND = "com.android.dialer:id/pound";
        /***
         * 键盘的"0"号键
         ***/
        public static final String ID_DIALPAD_ZERO = "com.android.dialer:id/zero";
        /***
         * 键盘的数字输入框
         ***/
        public static final String ID_DIALPAD_DIGITS = "com.android.dialer:id/digits";
        /***
         * 联系人界面的联系人名或拨号盘输入数字搜索出来的条目
         ***/
        public static final String ID_DIALPAD_CONTACTS_NAME = "com.android.dialer:id/cliv_name_textview";
        /***
         * 联系人界面的联系人名或拨号盘输入数字搜索出来的号码
         ***/
        public static final String ID_DIALPAD_CONTACTS_NUMBER = "com.android.dialer:id/cliv_data_view";
        /***
         * 联系人详细信息界面的信息图标
         ***/
        public static final String ID_DIALPAD_CONTACTS_DETAIL_MSG = "com.android.dialer:id/secondary_action_button";
        /***
         * 联系人详细信息界面的编辑按钮
         ***/
        public static final String FM5_ID_DIALPAD_CONTACTS_DETAIL_MSG = "com.android.dialer:id/menu_edit";
        /***
         * 联系人编辑界面的人像框
         ***/
        public static final String ID_DIALPAD_CONTACTS_EDIT_PHOTO = "com.android.dialer:id/photo_frame";
        /***
         * 联系人编辑界面的选择照片
         ***/
        public static final String FM5_ID_DIALPAD_CONTACTS_EDIT_PHOTO = "com.android.dialer:id/photo";
        /***
         * 联系人编辑界面的人像框点击后弹出的选择图库框
         ***/
        public static final String ID_DIALPAD_CONTACTS_EDIT_PHOTO_THUMBNAIL = "com.meizu.media.gallery:id/thumbnail";
        /***
         * 联系人编辑界面的人像框点击后弹出的选择图片
         ***/
        public static final String FM5_ID_DIALPAD_CONTACTS_EDIT_PHOTO_THUMBNAIL = "com.meizu.media.gallery:id/thumbnail_check_box";
        /***
         * 完成按钮
         ***/
        public static final String ID_DIALPAD_CONTACTS_PHOTO_FINISH = "com.meizu.media.gallery:id/action_get_multi_confirm";
        /***
         * 保存按钮
         ***/
        public static final String ID_DIALPAD_CONTACTS_PHOTO_SAVE = "com.meizu.media.gallery:id/action_crop_save";
        public static final String FM5_ID_DIALPAD_CONTACTS_PHOTO_SAVE = "com.meizu.media.gallery:id/action_crop_save_tv";
        /***
         * 第二个完成按钮
         ***/
        public static final String ID_DIALPAD_CONTACTS_PHOTO_DONE = "com.android.dialer:id/menu_done";
        public static final String FM5_ID_DIALPAD_CONTACTS_PHOTO_DONE = "com.android.dialer:id/btn_done";
        /***
         * 键盘"1"数字键
         ***/
        public static final String ID_DIALPAD_NUMBER_ONE = "com.android.dialer:id/one";
        /***
         * 拨号盘输入数字搜索出来的条目(部分机型)
         ***/
        public static final String ID_DIALPAD_NAMETEXT = "com.android.dialer:id/name_text";
        /***
         * 拨号盘删除输入按键
         ***/
        public static final String ID_DIALPAD_DELETE_BUTTON = "com.android.dialer:id/deleteButton";
        /***
         * 查找拔号盘
         ***/
        public static final String ID_DIALPAD_DIALPADDIGITS = "com.android.dialer:id/dialpaddigits";
        public static final String FM5_ID_DIALPAD_DIALPADDIGITS = "com.android.dialer:id/digits";
        /***
         * 结束通话按键
         ***/
        public static final String ID_DIALPAD_ENDBUTTON = "com.android.dialer:id/endButton";
        public static final String FM5_ID_DIALPAD_ENDBUTTON = "com.android.incallui:id/endButton";
        /***
         * 拨号按键
         ***/
        public static final String ID_DIALPAD_DIALBUTTON = "com.android.dialer:id/dialButton";
        public static final String FM5_ID_DIALPAD_DIALBUTTON = "com.android.dialer:id/dialpad_floating_action_button";
        public static final String FM5_ID_DIALPAD_DIALBUTTON_NEW = "com.android.dialer:id/floating_action_button";
        /***
         * 拨号按键1
         ***/
        public static final String ID_DIALPAD_DIALBUTTON1 = "com.android.dialer:id/dialButton1";
        public static final String FM5_ID_DIALPAD_DIALBUTTON1 = "com.android.dialer:id/dialpad_floating_action_button_1";
        /***
         * 拨号盘界面的添加联系人按键
         ***/
        public static final String ID_DIALPAD_ADDCONTACT = "com.android.dialer:id/addContactButton";
        /***
         * 弹出框标题
         ***/
        public static final String ID_DIALPAD_ACTIONBAR_TITLE = "android:id/action_bar_title";
        /***
         * 编辑联系人完成按键
         ***/
        public static final String ID_DIALPAD_MENU_DONE = "com.android.dialer:id/menu_done";
        /***
         * 简易模式删除按键
         ***/
        public static final String ID_DIALPAD_EASY_DELETEBTN = "com.meizu.flyme.easylauncher:id/deleteBtn";
        /***
         * 简易模式按键1
         ***/
        public static final String ID_DIALPAD_EASY_BTN_ONE = "com.meizu.flyme.easylauncher:id/one";
        /***
         * 简易模式按键0
         ***/
        public static final String ID_DIALPAD_EASY_BTN_ZERO = "com.meizu.flyme.easylauncher:id/zero";
        /***
         * 简易模式联系人名称
         ***/
        public static final String ID_DIALPAD_EASY_CONTACTS_NAME = "com.meizu.flyme.easylauncher:id/contactsNameTv";
        /***
         * 简易模式联系人电话
         ***/
        public static final String ID_DIALPAD_EASY_CONTACTS_NUM = "com.meizu.flyme.easylauncher:id/contactsNumTv";
        /***
         * 简易模式联系人地址
         ***/
        public static final String ID_DIALPAD_EASY_CONTACTS_ADDRESS = "com.meizu.flyme.easylauncher:id/geoDescriptionTv";
        /***
         * 简易模式拨号输入框内容
         ***/
        public static final String ID_DIALPAD_EASY_DIAPAD_NUM = "com.meizu.flyme.easylauncher:id/contactsNumTv";
        /***
         * 简易模式按键0
         ***/
        public static final String ID_DIALPAD_EASY_DIAPAD_ZERO = "com.meizu.flyme.easylauncher:id/zero";
        /***
         * 输入姓名完成或取消
         ***/
        public static final String ID_DIALPAD_EASY_CONTACTS_NAME_ETX = "com.meizu.flyme.easylauncher:id/contactsNameEtx";
        /***
         * 显示卡1标识的拨号按钮
         ***/
        public static final String ID_DIALPAD_SIM1 = "com.android.dialer:id/dialButtonSim1";
        public static final String FM5_ID_DIALPAD_SIM1 = "com.android.dialer:id/dialpad_floating_action_button_1";
        /***
         * 显示卡2标识的拨号按钮
         ***/
        public static final String ID_DIALPAD_SIM2 = "com.android.dialer:id/dialButtonSim2";
        public static final String FM5_ID_DIALPAD_SIM2 = "com.android.dialer:id/dialpad_floating_action_button_2";
        /***
         * 拨号按钮2
         ***/
        public static final String ID_DIALPAD_DIALBUTTON2 = "com.android.dialer:id/dialButton2";
        /***
         * 拨号按钮2
         ***/
        public static final String ID_DIALPAD_QUICK_CONTACT = "com.android.dialer:id/quick_contact";
        /***
         * 界面中的滑动开关
         ***/
        public static final String ID_SWICH_WIDGET = "com.android.settings:id/switchWidget";

        /**
         * 配置
         */
        public static final String FILE = "DialPadTestCase";

    }

    /**
     * 通话设置模块ID和文本常量
     *
     * @author Fengweijie
     */
    public class PhoneSet {
        /**
         * ID
         */
        /***
         * 键盘"2"数字键
         ***/
        public static final String ID_DIALPAD_NUMBER_TWO = "com.android.dialer:id/two";
    }

    /**
     * 图库模块的ID与文本常量
     *
     * @author Wangdenan
     */
    public class Gallery {
        /**
         * ID
         */
        /***
         * 图片缩略图ID
         ***/
        public static final String ID_PICTRUE_THUMBNAIL = "com.meizu.media.gallery:id/thumbnail";
        /***
         * 文件夹或分享图标选项ID
         ***/
        public static final String ID_TEXT1 = "android:id/text1";
        /***
         * 选中文件的checkBoxID
         ***/
        public static final String ID_CHECKBOX = "android:id/checkbox";
        /***
         * 图库中点击删除的删除选项ID
         ***/
        public static final String ID_TITLE = "android:id/title";
        /***
         * 图片缩略图ID
         ***/
        public static final String ID_THUMBNAIL_ITEM_CONTENT = "com.meizu.media.gallery:id/thumbnail_item_content";
        /***
         * 图片缩略图的所属月份ID
         ***/
        public static final String ID_THUMBNAIL_GROUP_MONTH = "com.meizu.media.gallery:id/thumbnail_group_month";
        /***
         * 光场，美颜或连拍入口ID
         ***/
        public static final String ID_ENTRANCE_ICON = "com.meizu.media.gallery:id/entrance_icon";
        /***
         * 连拍入口内的照片小图ID
         ***/
        public static final String ID_ITEM = "com.meizu.media.gallery:id/item";
        /***
         * 图片信息ID
         ***/
        public static final String ID_INFO_BTN = "com.meizu.media.gallery:id/info_btn";
        /***
         * 文件夹列表ID
         ***/
        public static final String ID_FOLDER_LIST_ITEM = "com.meizu.media.gallery:id/folder_list_item";
        /***
         * 分享图片按钮ID
         ***/
        public static final String ID_ACTION_SHARE = "com.meizu.media.gallery:id/action_share";
        /***
         * 9 删除图片按钮ID
         ***/
        public static final String ID_ACTION_DELETE = "com.meizu.media.gallery:id/action_delete";
        /***
         * 图片排序按钮ID
         ***/
        public static final String ID_ACTION_SORT_LOCATION = "com.meizu.media.gallery:id/action_sort_by_location";
        /***
         * 图片播放按钮ID
         ***/
        public static final String ID_ACTION_SLIDESHOW = "com.meizu.media.gallery:id/action_slideshow";
        /***
         * 图片播放暂停ID
         ***/
        public static final String ID_ACTION_SLIDESHOW_PAUSE = "com.meizu.media.gallery:id/slideshow_pause_resume";
        /***
         * 图库文件添加ID
         ***/
        public static final String ID_ACTION_ADD_SET = "com.meizu.media.gallery:id/action_add_set";
        /***
         * 图库文件路径ID
         ***/
        public static final String ID_ALBUM_PATH = "com.meizu.media.gallery:id/album_path";
        /***
         * 云相册上传按钮ID
         ***/
        public static final String ID_ACTION_CLOUD_UPLOAD = "com.meizu.media.gallery:id/action_cloud_upload";
    }

    /**
     * 应用加密模块的ID与文本常量
     *
     * @author Wangdenan
     */
    public class ApplicationEncryption {
        /**
         * ID
         */
        /***
         * flyme4.0设置安全页面应用加密的箭头ID
         ***/
        public static final String ID_FLYME_ARROW = "flyme:id/arrow";
        /***
         * flyme4.5设置安全页面应用加密的箭头ID
         ***/
        public static final String ID_ANDROID_ARROW = "android:id/arrow";
        /***
         * 开启应用加密的switch按钮ID
         ***/
        public static final String ID_LOCK_SWITCH = "com.android.settings:id/lock_switch";
        /***
         * 应用加密选项的checkboxID
         ***/
        public static final String ID_APP_LOCK_SWITCH = "com.android.settings:id/applock_switch";
        /***
         * flyme4.0加密键盘ID
         ***/
        public static final String ID_FLYME_KEY_PAD = "flyme:id/keyPad";
        /***
         * flyme4.5加密键盘ID
         ***/
        public static final String ID_ANDROID_KEY_PAD = "android:id/keyPad";
        /***
         * 信息添加附件按钮ID
         ***/
        public static final String ID_ACTION_COMPOSE_NEW = "com.android.mms:id/action_compose_new";
        /***
         * 信息中图片ID
         ***/
        public static final String ID_IMAGE_CONTENT = "com.android.mms:id/image_content";
        /***
         * 文档左上角列出所有按钮ID
         ***/
        public static final String ID_UP = "android:id/up";
        /***
         * 选中文件的checkboxID
         ***/
        public static final String ID_CHECKBOX = "android:id/checkbox";
        /***
         * 分享文件的按钮ID
         ***/
        public static final String ID_MENU_SHARE = "com.meizu.filemanager:id/menu_share";
        /***
         * flyme4.0复杂密码输入框ID
         ***/
        public static final String ID_FLYME_PASSWORD_EDIT = "flyme:id/password_edit";
        /***
         * flyme4.5复杂密码输入框ID
         ***/
        public static final String ID_ANDROID_PASSWORD_EDIT = "android:id/password_edit";
        /***
         * 设置左上角列出所有按钮ID
         ***/
        public static final String ID_ACTION_BAR_TITLE = "android:id/action_bar_title";
        /***
         * 5.0flyme账户左边图标ID
         ***/
        public static final String ID_AVATAR = "com.meizu.account:id/avatar";
        /***
         * 4.0登录后的flyme图标ID
         ***/
        public static final String ID_FLYME_LOGO = "com.meizu.account:id/flymeLogo";
        /***
         * 锁屏时的加密键盘ID
         ***/
        public static final String ID_LOCAK_PATTERN = "com.android.keyguard:id/lockPattern";
        /***
         * 安全中心的分数ID
         ***/
        public static final String ID_BTN_HEALTH_CHECK = "com.meizu.safe:id/btn_health_check";
        /***
         * 啊里安全中心的分数ID
         ***/
        public static final String ID_PROGRESS_TEXT = "com.aliyun.SecurityCenter:id/progress_text";
        /***
         * 信息调用相机拍照选择图片的完成按钮
         ***/
        public static final String ID_BTN_DONE = "com.meizu.media.camera:id/btn_done";
        /***
         * 拨打电话时的键盘按钮ID
         ***/
        public static final String ID_DIAL_BUTTON = "com.android.dialer:id/dialButton";
        public static final String ID_DIAL_BUTTON1 = "com.android.dialer:id/dialButton1";
        /***
         * 信息中音乐附件图标
         ***/
        public static final String ID_IMAGE_VIEW = "com.android.mms:id/image_view";

    }

    /**
     * 相机模块的ID与文本常量
     *
     * @author Wangdenan
     */
    public class Camera {
        /**
         * ID
         */
        /***
         * 相机拍照按钮ID
         ***/
        public static final String ID_SHUTTER_BTN = "com.meizu.media.camera:id/shutter_btn";
        /***
         * 相机查看照片ID
         ***/
        public static final String ID_THUMBNAIL_BTN = "com.meizu.media.camera:id/thumbnail_btn";
        /***
         * 相机菜单按钮ID
         ***/
        public static final String ID_MENU_CONTROL = "com.meizu.media.camera:id/menu_control";
        /***
         * 相机设置-定位服务ID
         ***/
        public static final String ID_GPS_SWITCHER = "com.meizu.media.camera:id/mz_setting_gps_switcher";
        /***
         * 相机选择模式按钮ID
         ***/
        public static final String ID_CURRENT_MODE = "com.meizu.media.camera:id/current_mode";
        /***
         * 相机中EV值选项ID
         ***/
        public static final String ID_HINT_EXPOSURE = "com.meizu.media.camera:id/hint_exposure";
        /***
         * 相机中快门速度ID
         ***/
        public static final String ID_HINT_SHUTTER_SPEED = "com.meizu.media.camera:id/hint_shutter_speed";
        /***
         * 相机中滤镜ID
         ***/
        public static final String ID_FILTER_CONTROL = "com.meizu.media.camera:id/filter_control";
        /***
         * 相机中滤镜选项ID
         ***/
        public static final String ID_MZ_FILTER_GALLERY = "com.meizu.media.camera:id/mz_filter_gallery";
        /***
         * 相机中切换前后置摄像头ID
         ***/
        public static final String ID_SWITCH_CAMERA_CONTROL = "com.meizu.media.camera:id/switch_camera_control";
        /***
         * 相机中开关水平仪ID
         ***/
        public static final String ID_SETTING_LEVEL_SWITCHER = "com.meizu.media.camera:id/mz_setting_level_switcher";
        /***
         * 相机中开关网格线ID
         ***/
        public static final String ID_MZ_SETTING_MESHLINE_SWITCHER = "com.meizu.media.camera:id/mz_setting_meshline_switcher";
        /***
         * 相机中闪光灯ID
         ***/
        public static final String ID_FLASHLIGHT_CONTROL = "com.meizu.media.camera:id/flashlight_control";
        /***
         * 相机中进入图库中的删除按钮ID
         ***/
        public static final String ID_ACTION_DELETE = "com.meizu.media.gallery:id/action_delete";
        /***
         * 相机中返回键按钮ID
         ***/
        public static final String ID_BACK_CONTROL = "com.meizu.media.camera:id/back_control";

    }

    /**
     * 下载模块的ID与文本常量
     *
     * @author zhouying
     */
    public class DownLoad {
        /**
         * 文本
         */
        public static final String TEXT_DOWNLOADING = "下载中";
        public static final String TEXT_DOWNLOADED = "已下载";
        public static final String TEXT_NO_HISTORY = "没有下载记录";
        public static final String TEXT_SETTING = "设置";
        public static final String TEXT_DOWNLOAD_CONTENT = "下载目录";
        public static final String TEXT_PICTURE = "图片";
        public static final String TEXT_CONFIRM = "确定";
        public static final String TEXT_DOWNLOAD_URL = "下载链接";
        public static final String TEXT_ARROW = "允许";
        public static final String TEXT_CLEAR_DOWNLOADED_HISTORY = "清空已下载记录";
        public static final String TEXT_CLEAR_HISTORY = "清空下载记录";
        public static final String TEXT_DELETE = "删除";
        public static final String TEXT_NEVER = "永不";
        public static final String TEXT_PAUSE_ALL = "全部暂停";
        public static final String TEXT_START_ALL = "全部开始";
        public static final String TEXT_PAUSE = "暂停下载";
        public static final String TEXT_WAIT_RECONN = "等待重新连接 ..";
        public static final String TEXT_30MRA = "30Mra.rar";
        public static final int WAIT_TIME = 3 * 1000;
        public static final String FILE = "DLoadTestCase";
        public static final String DOWNLOAD_PATH = "mnt/sdcard/DownLoad/";
        public static final String DOWNLOAD_PICTURE_PATH = "mnt/sdcard/DownLoad/Photo/";
        public static final String DOWNLOAD_VIDEO_PATH = "mnt/sdcard/DownLoad/Video/";
        public static final String DOWNLOAD_MUSIC_PATH = "mnt/sdcard/DownLoad/MUSIC/";
        public static final String URL_APK = "http://172.16.11.218:8088/res/APK.apk";
        public static final String URL_VIDEO = "http://172.16.11.218:8088/res/3gp.3gp";
        public static final String URL_VIDEO_71C = "http://42.96.171.2/download.jsp?dir=video&name=3GP.3gp";
        public static final String URL_MUSIC = "http://172.16.11.218:8088/res/amr.amr";
        public static final String URL_PHOTO = "http://172.16.11.218:8088/res/tif.tif";
        public static final String URL_5MRA = "http://172.16.11.218:8088/progress/zxa/5Mra.rar";
        public static final String URL_10MRA = "http://172.16.11.218:8088/progress/zxa/10Mra.rar";
        public static final String URL_30MRA = "http://172.16.11.218:8088/progress/zxa/30Mra.rar";
        public static final String URL_100MRA = "http://172.16.11.218:8088/progress/zxa/100Mra.rar";
        public static final String URL_UPDATE_BIN = "http://download.meizu.com/Firmware/Flyme/MX2/3.7.5/cn/20140729121355/62b69de4/update.bin";
        public static final String URL_UPDATE_ZIP = "http://download.meizu.com/Firmware/Flyme/MX5/4.5.2.2/cn/20150706151932/47239e53/update.zip";

        /**
         * ID
         */
        /***
         * 开启菜单栏ID
         ***/
        public static final String ID_MORE = "com.android.providers.downloads.ui:id/more";
        /***
         * 文档主界面文件夹标题ID
         ***/
        public static final String ID_DOC_TEXT1 = "android:id/text1";
        /***
         * 开启仅Wlan连接时下载开关ID
         ***/
        public static final String ID_SWITCH_BUTTON = "com.android.providers.downloads:id/switch_button";
        /***
         * 下载记录右边的勾选框ID
         ***/
        public static final String ID_ANDROID_CHECK_BOX = "android:id/checkbox";
        /***
         * 点击勾选框后出现的删除按钮ID
         ***/
        public static final String ID_DELETE_SELECTED = "com.android.providers.downloads.ui:id/delete_selected";
        /***
         * 删除记录弹出框小标题ID
         ***/
        public static final String ID_TITLE = "com.android.providers.downloads.ui:id/title";
        /***
         * 下载中，删除记录框ID
         ***/
        public static final String ID_ANDROID_TITLE = "android:id/title";
        /***
         * 下载中界面，下载记录图标ID
         ***/
        public static final String ID_DOWNLOAD_ICON = "com.android.providers.downloads.ui:id/download_icon";
        /***
         * 下载中界面，下载你记录标题ID
         ***/
        public static final String ID_DOWNLOAD_TITLE = "com.android.providers.downloads.ui:id/download_title";
        /***
         * 删除弹出框，单选框ID
         ***/
        public static final String ID_CHECKBOX = "com.android.providers.downloads.ui:id/checkbox";
        /***
         * 下载中界面，下载进度ID
         ***/
        public static final String ID_DOWNLOAD_TIME = "com.android.providers.downloads.ui:id/download_time";
        /***
         * 下载中界面，下载状态ID
         ***/
        public static final String ID_DOWNLOAD_STATUS = "com.android.providers.downloads.ui:id/download_status";
        /***
         * 下载中界面，文件大小ID
         ***/
        public static final String ID_DOWNLOAD_SIZE = "com.android.providers.downloads.ui:id/download_size";
        /***
         * 下载提示框的确定按钮ID
         ***/
        public static final String ID_BUTTON1 = "android:id/button1";
        /***
         * 浏览器界面多窗口按钮
         ***/
        public static final String ID_WINDOW_NUM = "com.android.browser:id/window_num";
        /***
         * 返回
         ***/
        public static final String ID_BACK = "BACK";
        /***
         * 下载界面新建任务按钮
         ***/
        public static final String ID_NEW_TASK = "com.android.providers.downloads.ui:id/new_task";
        /***
         * 通知栏下载开启暂停按钮
         ***/
        public static final String ID_PROGRESS = "flyme:id/progress";
        /***
         * M79通知栏下载暂停按钮
         ***/
        public static final String ID_79PROGRESS = "android:id/progress";
        /***
         * 下载界面MD5按钮
         ***/
        public static final String ID_MD5 = "com.android.providers.downloads.ui:id/md5";
        /***
         * 下载界面已下载文件完整路径
         ***/
        public static final String ID_COMPLETE_PATH = "com.android.providers.downloads.ui:id/complete_path";
        /***
         * 默认打开方式
         ***/
        public static final String ID_ALWAYS_USE = "flyme:id/mz_alwaysUse";
        /***
         * 下载界面音乐、视频图标
         ***/
        public static final String ID_ICON = "android:id/icon";

    }

    /**
     * 邮件模块的ID与文本常量
     *
     * @author HuangFangying
     */
    public class Email {
        /**
         * ID
         */
        /***
         * 等待时间
         ***/
        public static final int TIME_OUT = 10 * 1000;
        /***
         * android4.0邮件列表设置ID
         ***/
        public static final String ID_SETTING = "com.android.email:id/settings";
        /***
         * android5.0邮件列表更多ID
         ***/
        public static final String ID_MORE = "com.android.email:id/more";
        /***
         * android5.0邮件列表设置ID
         ***/
        public static final String ID_TITLE_SETTING = "android:id/title";
        /***
         * android5.0箭头">"图标ID
         ***/
        public static final String ID_ARROW = "com.android.email:id/arrow";
        /***
         * android4.0箭头">"图标ID
         ***/
        public static final String ID_ARROW_4 = "android:id/arrow";
        /***
         * 删除图标ID
         ***/
        public static final String ID_DELETE = "com.android.email:id/delete";
        /***
         * 删除文字ID
         ***/
        public static final String ID_DELETE_TEXT = "android:id/title";
        /***
         * 复选框ID
         ***/
        public static final String ID_CHECKBOX = "android:id/checkbox";
        /***
         * 新建邮件ID
         ***/
        public static final String ID_NEWEMAIL = "com.android.email:id/compose";
        /***
         * 选择所有项
         ***/
        public static final String ID_GETALLTEXT = "android:id/text1";
        /***
         * 新建邮件界面附件ID
         ***/
        public static final String ID_ATTACHMENT = "com.android.email:id/attachment_name";
        /***
         * 邮件列表界面附件ID
         ***/
        public static final String ID_EMAILLISTATTACHMENT = "com.android.email:id/attachment";
        /***
         * 对话式布局邮件详情界面附件ID
         ***/
        public static final String ID_LAYOUTATTACH = "com.android.email:id/attachment_button";
        /***
         * 确定ID
         ***/
        public static final String ID_CONFIRM = "android:id/button1";
        /***
         * 添加星标ID
         ***/
        public static final String ID_ADDSTAR = "com.android.email:id/add_star";
        /***
         * 移除星标ID
         ***/
        public static final String ID_REMOVESTAR = "com.android.email:id/remove_star";
        /***
         * 邮件点开设置后的界面开关ID
         ***/
        public static final String ID_SWITCHWIDGET = "com.android.email:id/switchWidget";
        /***
         * 点开有主题邮件详情，表明是第几封邮件的下标
         ***/
        public static final String ID_INDEX = "com.android.email:id/index";
        /***
         * 收件人文本框ID
         ***/
        public static final String ID_RECIPIENT_EDIT = "com.android.email:id/mz_recipient_edit";
        /***
         * 发送邮件ID
         ***/
        public static final String ID_SEND = "com.android.email:id/send";
        /***
         * 主题文本框ID
         ***/
        public static final String ID_SUBJECT = "com.android.email:id/subject";
        /***
         * 收件箱列表左上角打开邮箱列表ID
         ***/
        public static final String ID_UP = "android:id/up";
        /***
         * 收件箱列表主题ID
         ***/
        public static final String ID_DISPLAYNAME = "com.android.email:id/display_name";
        /***
         * 添加账户ID
         ***/
        public static final String ID_ADDACCOUNT = "com.android.email:id/account_email";
        /***
         * 添加账户保存ID
         ***/
        public static final String ID_SAVE = "com.android.email:id/save";
        /***
         * 刷新邮件界面ID
         ***/
        public static final String ID_REFRESH = "com.android.email:id/refresh";
        /***
         * 删除邮件附件ID
         ***/
        public static final String ID_REMMOVEATTACH = "com.android.email:id/remove_attachment";
        /***
         * 邮件主题名称ID
         ***/
        public static final String ID_BARTITLE = "android:id/action_bar_title";
        /***
         * 通知栏打开数据流量选项的三角图标ID
         ***/
        public static final String ID_LISTARROW = "com.android.systemui:id/description_arrow";
        /***
         * 新建邮件，添加图片ID
         ***/
        public static final String ID_ADDIMAGE = "com.android.email:id/add_image";
        /***
         * 新建邮件，添加拍照的附件ID
         ***/
        public static final String ID_TAKTPHOTO = "com.meizu.media.gallery:id/take_photo_content";
        /***
         * 新建邮件，添加图片--最新ID
         ***/
        public static final String ID_NEWTITLE = "com.meizu.media.gallery:id/top_tab_new_title";
        /***
         * 新建邮件，添加图片--照片ID
         ***/
        public static final String ID_CAMERA = "com.meizu.media.gallery:id/top_tab_camera_title";
        /***
         * 新建邮件，添加图片--图库ID
         ***/
        public static final String ID_GALLERY = "com.meizu.media.gallery:id/top_tab_gallery_title";
        /***
         * 新建邮件，选择附件ID
         ***/
        public static final String ID_ATTACH = "com.android.email:id/add_attachment";
        /***
         * 文本ID
         ***/
        public static final String ID_TEXT = "com.android.email:id/text1";
        /***
         * 搜索ID
         ***/
        public static final String ID_SEARCH = "com.android.email:id/search";
    }

    /**
     * Flyme5 邮件模块的ID与文本常量
     *
     * @author HuangFangying
     */
    public class Flyme5Email {
        /**
         * ID
         */
        /***
         * 邮件列表展开左侧ID
         ***/
        public static final String ID_OPENLEFT = "com.android.email:id/mz_toolbar_nav_button";
        /***
         * 左侧列表账户ID
         ***/
        public static final String ID_LEFTACCOUNT = "com.android.email:id/accountName";
        /***
         * 邮件设置ID
         ***/
        public static final String ID_SETTING = "com.android.email:id/setting";
        /***
         * 邮件列表邮件标题ID
         ***/
        public static final String ID_EMAILTITLE = "com.android.email:id/title";
        public static final String ID_EMAILMessage = "com.android.email:id/message_item_ex";

    }

    /**
     * 日历模块ID与文本常量
     *
     * @author zhangyouxuan
     */
    public class Calendar {
        /**
         * ID
         */
        /***
         * 新建事件
         ***/
        public static final String ID_NEW_EVENT = "com.android.calendar:id/new_event";
        /***
         * 事件标题
         ***/
        public static final String ID_EVENT_TITLE = "com.android.calendar:id/title";
        /***
         * 修改时间
         ***/
        public static final String ID_START_TIME = "com.android.calendar:id/start_time";
        /***
         * 完成新事件添加
         ***/
        public static final String ID_ACTION_DONE = "com.android.calendar:id/action_done";
        /***
         * 确定按钮
         ***/
        public static final String ID_SURE_BTN = "android:id/button1";
        /***
         * 删除事件按钮
         ***/
        public static final String ID_INFO_ACTION_DELETE = "com.android.calendar:id/info_action_delete";
        /***
         * 事件名称
         ***/
        public static final String ID_EVENT_NAME = "com.android.calendar:id/event_name";
        /***
         * 新事件标题
         ***/
        public static final String TEXT_NEW_EVENT = "010";

    }

    /**
     * 时钟模块ID与文本常量
     *
     * @author zhangyouxuan
     */
    public class AlarmClock {
        /**
         * ID
         */
        /***
         * 闹钟列表的一个闹钟
         ***/
        public static final String ID_TIME_DISPLAY = "com.android.alarmclock:id/timeDisplay";
        /***
         * 删除闹钟按钮
         ***/
        public static final String ID_DELETE_BTN = "com.android.alarmclock:id/delete_btn";
        /***
         * 确定删除按钮
         ***/
        public static final String ID_SURE_BTN = "android:id/button1";
        /***
         * 添加闹钟
         ***/
        public static final String ID_ADD_ALARM_NEW_TEXT = "com.android.alarmclock:id/add_alarm_new_text";
        /***
         * 重复周期
         ***/
        public static final String ID_CHOOSER_TEXT = "com.android.alarmclock:id/chooser_text";
        /***
         * 确定保存闹钟按钮
         ***/
        public static final String ID_MENU_SAVE = "com.android.alarmclock:id/menu_save";
        /***
         * 没有闹钟
         ***/
        public static final String ID_ALARM_EMPTY = "com.android.alarmclock:id/no_alarm_empty";
    }

    /**
     * WLAN模块 ID和文本常量
     *
     * @author lisi
     */
    public class WLAN {
        /**
         * 文本
         */
        public static final String TEXT_WLAN_OPEN_WLAN = "开启";
        public static final String TEXT_WLAN_CONFIRM = "确定";
        public static final String TEXT_WLAN_CANCEL = "取消";
        public static final String TEXT_WLAN_NO_LONGER_DISPLAY = "不再显示";
        public static final String TEXT_WLAN_WIRELESS_LAN = "无线局域网";
        public static final String TEXT_WLAN = "WLAN";
        public static final String TEXT_WLAN_MORE = "更多";
        public static final String TEXT_WLAN_ADD_NETWORK = "添加网络";
        public static final String TEXT_WLAN_OPEN = "开放";
        public static final String TEXT_WLAN_SAFETY = "安全性";
        public static final String TEXT_WLAN_CONNECTED = "已连接";
        public static final String TEXT_DUAL_CARDS_AND_NETWORK = "双卡和网络";
        public static final String TEXT_WLAN_STATIC_IP = "静态IP";
        public static final String TEXT_WLAN_SAVE = "保存";
        public static final String TEXT_WLAN_ADVANCED = "高级";
        public static final String TEXT_WLAN_NETWORK_NOTIFICATION = "网络通知";
        public static final String TEXT_WLAN_CONNECT = "连接";
        public static final String TEXT_WLAN_CONNECTING = "正在连接...";
        public static final String TEXT_WLAN_PEER_DEVICE = "对等设备";
        public static final String TEXT_WLAN_WLAN_DIRECT = "WLAN Direct";
        public static final String TEXT_WLAN_PROXY_SETTINGS = "代理设置";
        public static final String TEXT_WLAN_PROXY_SERVER = "代理服务器";
        public static final String TEXT_PORTABLE_HOTSPOT = "便携式热点";
        public static final String TEXT_USB_SHARED_NETWORK = "USB 共享网络";
        public static final String TEXT_PORTABLE_WLAN_HOTSPOT = "便携式 WLAN 热点";
        public static final String TEXT_WPA_PSK = "WPA PSK";
        public static final String TEXT_WLAN_PERMIT = "允许";
        public static final String TEXT_WLAN_PROXY = "115.238.225.26";
        public static final String TEXT_WLAN_PORT = "80";

        /**
         * ID
         */
        /***
         * WLAN界面，网络栏出现的wifi图标
         ***/
        public static final String ID_WIFI_ICON = "com.android.settings:id/signal";
        /***
         * WLAN，开关按钮
         ***/
        public static final String ID_WLAN_SWITCHWIDGET = "com.android.settings:id/switchWidget";
        /***
         * WLAN界面，阿里云固件，提示是否要打开数据业务
         ***/
        public static final String ID_WLAN_REMINDER = "com.android.settings:id/reminder";
        /***
         * WLAN界面，阿里云固件，提示是否要打开WLAN权限
         ***/
        public static final String ID_WLAN_PERMIT = "com.aliyun.mobile.permission:id/hw_pop_layout";
        /***
         * WLAN界面，阿里云固件，是否要WLAN权限，允许
         ***/
        public static final String ID_WLAN_PERMIT_PERMISSION = "android:id/button1";
        /***
         * WLAN界面，WLAN大标题
         ***/
        public static final String ID_WLAN_TITLE = "android:id/action_bar_title";
        /***
         * WLAN，文本编辑框
         ***/
        public static final String ID_WLAN_EDIT_TEXT = "android:id/edit";
        /***
         * 下拉通知栏，wifi信号图标
         ***/
        public static final String ID_WLAN_SIGNAL_ICON = "com.android.systemui:id/wifi_combo";
        /***
         * 下拉通知栏，清除所有通知按钮
         ***/
        public static final String ID_WLAN_CLAEAR_ALL_BUTTON = "com.android.systemui:id/clear_all_button";
        /***
         * WLAN，便携式热点界面，勾选框
         ***/
        public static final String ID_WLAN_PORTABLE_HOTSPOT_CHECKBOX = "android:id/checkbox";

    }

    /**
     * YunOS输入法模块 ID和文本常量
     *
     * @author lisi
     */
    public class YunOSInput {
        /**
         * 文本
         */
        public static final String TEXT_CHOICE_INPUT = "选择输入法";
        public static final String TEXT_INPUT_SETTING = "YunOS输入法设置";
        public static final String TEXT_GENERNAL_INPUT_SERRING = "常规输入设置";
        public static final String TEXT_IDENTIFY_INTERVAL = "识别间隔";
        public static final String TEXT_SECONDS = "0.25秒";
        public static final String TEXT_HANDWRITE_THICKNESS = "笔迹粗细";
        public static final String TEXT_FINE = "细";
        public static final String TEXT_HANDWRITE_COLOR = "笔迹颜色";
        public static final String TEXT_ROSE_PINK = "蔷薇粉";
        public static final String TEXT_BUZZWORD_AUTO_UPDATE = "流行词汇自动更新";
        public static final String TEXT_CELL_THESAURUS = "细胞词库";
        public static final String TEXT_SYSTEM_KEYBOARD = "系统键盘";
        public static final String TEXT_LANGUAGE_TIME = "语言和时间";
        public static final String TEXT_THESAURUS_MANAGEMENT = "词库管理";

        /**
         * ID
         */
        /***
         * 信息界面，写信息图标
         ***/
        public static final String ID_WRITEMMS = "com.android.mms:id/action_compose_new";
        /***
         * YunOS输入法，id/text2
         ***/
        public static final String ID_TEXT2 = "android:id/text2";
        /***
         * YunOS输入法，id/button1
         ***/
        public static final String ID_BUTTON1 = "android:id/button1";
        /***
         * YunOS输入法，开始使用
         ***/
        public static final String ID_START_USE = "com.aliyun.mobile.ime:id/start_to_use";
        /***
         * YunOS输入法，checkbox ID
         ***/
        public static final String ID_CHECKBOX = "android:id/checkbox";
        /***
         * YunOS输入法，输入法设置Button ID
         ***/
        public static final String ID_INPUTSET_BUTTON = "com.aliyun.mobile.ime:id/toggle_btn";

    }
}

