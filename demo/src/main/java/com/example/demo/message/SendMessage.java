package com.example.demo.message;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.util.Random;

/**
 * @ClassName: SendMessage
 * @Description: TODO 继承Job接口，使用Quartz定时任务框架
 * @Author: Yanglei
 * @Date: 2020/5/28 14:42
 * @Version: V1.0
 */
public class SendMessage implements Job {
    Logger logger = LoggerFactory.getLogger(SendMessage.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("---进入短信发送执行方法---");
        // 短信应用 SDK AppID
        int appid = 1400375420;
        // 短信应用 SDK AppKey
        String appkey = "f61052fc268c1071dcc6f4443d6f904f";
        // 需要发送短信的手机号码
        String[] phoneNumbers = {"18942226681"};
        // 短信模板 ID，需要在短信应用中申请
        int templateId = 618625;
        // 签名
        String smsSign = "seeyourface";
        try {
            String[] params = getRandom();
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumbers[0],
                    templateId, params, smsSign, "", "");
            System.out.println(result);
        } catch (HTTPException e) {
            // HTTP 响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // JSON 解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络 IO 错误
            e.printStackTrace();
        }
    }

    /**
    * @Description TODO 获取四位随机数字验证码
    * @Date 12:43 2020/5/31
    * @Param
    * @return
    */
    private static String[] getRandom(){
        String[] array = new String[1];
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < 4; i++){
            int ran = new Random().nextInt(10);
            sb.append(String.valueOf(ran));
        }
        array[0] = sb.toString();
        return array;
    }
}
