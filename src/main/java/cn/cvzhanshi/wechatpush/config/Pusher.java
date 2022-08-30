package cn.cvzhanshi.wechatpush.config;


import cn.cvzhanshi.wechatpush.entity.Weather;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author cVzhanshi
 * @create 2022-08-04 21:09
 */
public class Pusher {

    public static void main(String[] args) {
        push();
    }
    private static String appId = "xx";
    private static String secret = "xx";



    public static void push(){
        //1，配置
        WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
        wxStorage.setAppId(appId);
        wxStorage.setSecret(secret);
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxStorage);
        //2,推送消息
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser("xx")
                .templateId("xx")
                .build();
        //3,如果是正式版发送模版消息，这里需要配置你的信息
        Weather weather = WeatherUtils.getWeather();
        Map<String, String> map = CaiHongPiUtils.getEnsentence();
        templateMessage.addData(new WxMpTemplateData("riQi",weather.getDate() + "  "+ weather.getWeek(),"#00BFFF"));
        templateMessage.addData(new WxMpTemplateData("tianQi",weather.getText_now(),"#00FFFF"));
        templateMessage.addData(new WxMpTemplateData("feelsLike",weather.getFeels_like(),"#00FFFF"));
        templateMessage.addData(new WxMpTemplateData("low",weather.getLow() + "","#173177"));
        templateMessage.addData(new WxMpTemplateData("temp",weather.getTemp() + "","#EE212D"));
        templateMessage.addData(new WxMpTemplateData("high",weather.getHigh()+ "","#FF6347" ));
        templateMessage.addData(new WxMpTemplateData("windClass",weather.getWind_class()+ "","#42B857" ));
        templateMessage.addData(new WxMpTemplateData("windDir",weather.getWind_dir()+ "","#B95EA3" ));
        templateMessage.addData(new WxMpTemplateData("caiHongPi",CaiHongPiUtils.getCaiHongPi(),"#FF69B4"));
        templateMessage.addData(new WxMpTemplateData("zaoAn",CaiHongPiUtils.getZaoAn(),"#FF69B4"));
//        templateMessage.addData(new WxMpTemplateData("Pyqwenan",CaiHongPiUtils.getPyqwenan(),"#FF69B4"));
//        templateMessage.addData(new WxMpTemplateData("WanAn",CaiHongPiUtils.getWanAn(),"#FF69B4"));
//        templateMessage.addData(new WxMpTemplateData("lianai",JiNianRiUtils.getLianAi()+"","#FF1493"));
        templateMessage.addData(new WxMpTemplateData("birthday",JiNianRiUtils.getBirthday_Hui()+"","#FFA500"));
        templateMessage.addData(new WxMpTemplateData("en",map.get("en") +"","#C71585"));
        templateMessage.addData(new WxMpTemplateData("zh",map.get("zh") +"","#C71585"));
        String remk = "❤";

        if(JiNianRiUtils.getBirthday_Hui()  == 0){
            remk = "愿日光给你镀上成熟，月华增添你的纯真，愿你永远生活在自己的热爱中，生日快乐！";
        }
        templateMessage.addData(new WxMpTemplateData("beizhu",remk,"#FF0000"));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (Long.valueOf(simpleDateFormat.format(new Date())) % 2 == 0){
            Map<String, String> qingShi = CaiHongPiUtils.getQingShi();
            templateMessage.addData(new WxMpTemplateData("content",qingShi.get("content") +"","#C71585"));
            templateMessage.addData(new WxMpTemplateData("source",qingShi.get("source") +"","#C71585"));
            templateMessage.addData(new WxMpTemplateData("author",qingShi.get("author") +"","#C71585"));
        }else {
            Map<String, String> zmsc = CaiHongPiUtils.getZmsc();
            templateMessage.addData(new WxMpTemplateData("content",zmsc.get("content") +"","#C71585"));
            templateMessage.addData(new WxMpTemplateData("source",zmsc.get("source") +"","#C71585"));
        }

        try {
            System.out.println(templateMessage.toJson());
            System.out.println(wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage));
        } catch (Exception e) {
            System.out.println("推送失败：" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void pushevening(){
        //1，配置
        WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
        wxStorage.setAppId(appId);
        wxStorage.setSecret(secret);
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxStorage);
        //2,推送消息
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser("xx")
                .templateId("xx")
                .build();
        //3,如果是正式版发送模版消息，这里需要配置你的信息
        Weather weather = WeatherUtils.getWeather();
        Map<String, String> map = CaiHongPiUtils.getEnsentence();
        templateMessage.addData(new WxMpTemplateData("riQi",weather.getDate() + "  "+ weather.getWeek(),"#00BFFF"));
//        templateMessage.addData(new WxMpTemplateData("tianQi",weather.getText_now(),"#00FFFF"));
        templateMessage.addData(new WxMpTemplateData("tianQiNight",weather.getText_night(),"#00FFFF"));
        templateMessage.addData(new WxMpTemplateData("feelsLike",weather.getFeels_like(),"#00FFFF"));
        templateMessage.addData(new WxMpTemplateData("low",weather.getLow() + "","#173177"));
        templateMessage.addData(new WxMpTemplateData("temp",weather.getTemp() + "","#EE212D"));
        templateMessage.addData(new WxMpTemplateData("high",weather.getHigh()+ "","#FF6347" ));
        templateMessage.addData(new WxMpTemplateData("windClass",weather.getWind_class()+ "","#42B857" ));
        templateMessage.addData(new WxMpTemplateData("windDir",weather.getWind_dir()+ "","#B95EA3" ));
        templateMessage.addData(new WxMpTemplateData("caiHongPi",CaiHongPiUtils.getCaiHongPi(),"#FF69B4"));
        templateMessage.addData(new WxMpTemplateData("Pyqwenan",CaiHongPiUtils.getPyqwenan(),"#FF69B4"));
        templateMessage.addData(new WxMpTemplateData("wanAn",CaiHongPiUtils.getWanAn(),"#FF69B4"));
        templateMessage.addData(new WxMpTemplateData("birthday",JiNianRiUtils.getBirthday_Hui()+"","#FFA500"));
        String remk = "❤";

        if(JiNianRiUtils.getBirthday_Hui()  == 0){
            remk = "以后的每一天都要快乐哟！";
        }
        templateMessage.addData(new WxMpTemplateData("beizhu",remk,"#FF0000"));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        if (Long.valueOf(simpleDateFormat.format(new Date())) % 2 == 0){
            Map<String, String> qingShi = CaiHongPiUtils.getQingShi();
            templateMessage.addData(new WxMpTemplateData("content",qingShi.get("content") +"","#C71585"));
            templateMessage.addData(new WxMpTemplateData("source",qingShi.get("source") +"","#C71585"));
            templateMessage.addData(new WxMpTemplateData("author",qingShi.get("author") +"","#C71585"));
        }else {
            Map<String, String> zmsc = CaiHongPiUtils.getZmsc();
            templateMessage.addData(new WxMpTemplateData("content",zmsc.get("content") +"","#C71585"));
            templateMessage.addData(new WxMpTemplateData("source",zmsc.get("source") +"","#C71585"));
        }

        try {
            System.out.println(templateMessage.toJson());
            System.out.println(wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage));
        } catch (Exception e) {
            System.out.println("推送失败：" + e.getMessage());
            e.printStackTrace();
        }
    }
}
