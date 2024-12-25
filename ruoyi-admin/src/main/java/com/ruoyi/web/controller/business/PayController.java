package com.ruoyi.web.controller.business;

import com.ruoyi.business.domain.vo.PayQrCodeVO;
import com.ruoyi.business.service.IPayService;
import com.ruoyi.business.util.PayTypeEnum;
import com.ruoyi.business.util.pay.SybConstants;
import com.ruoyi.business.util.pay.SybUtil;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping("/business/pay")
public class PayController {

    @Autowired
    private IPayService payService;

    /**
     * 生成支付二维码
     */
    @GetMapping("/generatePayQrCode")
    public AjaxResult generatePayQrCode(Long trxamt, String payType) {
        if (trxamt == null) {
            return AjaxResult.error("金额不能为空");
        }
        if (payType == null) {
            return AjaxResult.error("支付类型不能为空");
        }

        if (!PayTypeEnum.existsByCode(payType)) {
            throw new RuntimeException("支付类型不存在");
        }

        PayQrCodeVO payQrCodeVO = payService.generatePayQrCode(trxamt, payType);
        return AjaxResult.success(payQrCodeVO);
    }

    /**
     * 回调
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/callback")
    public AjaxResult callback(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("接收到通知");
        request.setCharacterEncoding("UTF-8");//通知传输的编码为GBK
        response.setCharacterEncoding("UTF-8");
        TreeMap<String,String> params = getParams(request);//动态遍历获取所有收到的参数,此步非常关键,因为收银宝以后可能会加字段,动态获取可以兼容
        try {
            String appkey = "";
            if("RSA".equals(params.get("signtype")))
                appkey = SybConstants.SYB_RSATLPUBKEY;
            else if("SM2".equals(params.get("signtype")))
                appkey = SybConstants.SYB_SM2TLPUBKEY;
            else
                appkey = SybConstants.SYB_MD5_APPKEY;
            boolean isSign = SybUtil.validSign(params, appkey, params.get("signtype"));// 接受到推送通知,首先验签
            System.out.println("验签结果:"+isSign);
            //验签完毕进行业务处理
        } catch (Exception e) {//处理异常
            e.printStackTrace();
        }
        finally{//收到通知,返回success
            response.getOutputStream().write("success".getBytes());
            response.flushBuffer();
        }
        return AjaxResult.success();
    }

    /**
     * 动态遍历获取所有收到的参数,此步非常关键,因为收银宝以后可能会加字段,动态获取可以兼容由于收银宝加字段而引起的签名异常
     * @param request
     * @return
     */
    private TreeMap<String, String> getParams(HttpServletRequest request){
        TreeMap<String, String> map = new TreeMap<String, String>();
        Map reqMap = request.getParameterMap();
        for(Object key:reqMap.keySet()){
            String value = ((String[])reqMap.get(key))[0];
            System.out.println(key+";"+value);
            map.put(key.toString(),value);
        }
        return map;
    }
}
