package com.company.test.controller;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.company.test.model.SysUser;
import com.company.test.service.SysUserService;
import com.company.test.utils.StringUtil;
import com.company.test.utils.VerifyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaochuanzhen
 * @desc 登录controller
 * @since 15:11 2017/9/28
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 跳转到登录界面
     */
    @RequestMapping("/loginPage.action")
    public String loginPage() {
        return "login";
    }

    /**
     * 执行登录
     */
    @ResponseBody
    @RequestMapping("/login.action")
    public Map login(String userName, String password, String verify, HttpServletRequest request) throws Exception {
        Map result = new HashMap();
        result.put("result", "failed");

        //校验用户名
        if(StringUtil.isEmpty(userName)){
            result.put("data","用户名不能为空");
            return result;
        }

        //校验密码
        if(StringUtil.isEmpty(password)){
            result.put("data","密码不能为空");
            return result;
        }

        //校验验证码
        /*if(verify == null || "".equals(verify)){
            result.put("data","验证码不能为空");
            return result;
        }

        String session_verify = (String) request.getSession().getAttribute("verify");
        if(!verify.equals(session_verify)){
            result.put("data","验证码不正确");
            return result;
        }*/

        SysUser user = sysUserService.queryUserByUsernamePassword(userName, password);
        if (user == null) {
            result.put("data","用户名或密码错误");
            return result;
        } else {
            request.getSession().setAttribute("user", user);
            result.put("result", "success");
            return result;
        }
    }

    /**
     * 获取session信息
     */
    @ResponseBody
    @RequestMapping("/getSessionInfo.action")
    public Map getSessionInfo(String key, HttpServletRequest request){
        Map result = new HashMap();
        result.put("result", "failed");
        Object object = request.getSession().getAttribute(key);
        if(object != null){
            result.put("data",object);
            result.put("result", "success");
        }
        return result;
    }

    /**
     * 退出登录
     */
    @RequestMapping("/logout.action")
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "login";
    }

    /**
     * 获取验证码
     */
    @ResponseBody
    @RequestMapping("/getVerify.action")
    public String getVerify(String phoneNum, HttpServletRequest req) {
        String verify = VerifyUtil.getRamdomNum();
        req.getSession().setAttribute("verify", verify);
        // 设置超时时间-可自行调整
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        // 初始化ascClient需要的几个参数
        final String product = "Dysmsapi";// 短信API产品名称（短信产品名固定，无需修改）
        final String domain = "dysmsapi.aliyuncs.com";// 短信API产品域名（接口地址固定，无需修改）
        // 替换成你的AK
        final String accessKeyId = "LTAIKMqvLqiNgeo6";// 你的accessKeyId,参考本文档步骤2
        final String accessKeySecret = "bzk1ELnVZtQAnjfpgtzYNQXV9lJczL";// 你的accessKeySecret，参考本文档步骤2
        // 初始化ascClient,暂时不支持多region
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        try {
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
            IAcsClient acsClient = new DefaultAcsClient(profile);
            // 组装请求对象
            SendSmsRequest request = new SendSmsRequest();
            // 使用post提交
            request.setMethod(MethodType.POST);
            // 必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式
            request.setPhoneNumbers(phoneNum);
            // 必填:短信签名-可在短信控制台中找到
            request.setSignName("赵传真");
            // 必填:短信模板-可在短信控制台中找到
            request.setTemplateCode("SMS_100805050");
            // 可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
            // 友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
            request.setTemplateParam("{\"code\":\"" + verify + "\"}");
            // 可选-上行短信扩展码(无特殊需求用户请忽略此字段)
            // request.setSmsUpExtendCode("90997");
            // 可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
            request.setOutId("yourOutId");
            // 请求失败这里会抛ClientException异常
            SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
            if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
                // TODO 请求成功
                return "短信已发出，请注意查收";
            }
        } catch (ClientException e) {
            e.printStackTrace();
            return "错误码：" + e.getErrMsg();
        }
        return "短信已发出，请注意查收";
    }

}
