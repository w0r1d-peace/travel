package com.ruoyi.business.service.impl;

import com.ruoyi.business.domain.PayQrCode;
import com.ruoyi.business.domain.vo.PayQrCodeVO;
import com.ruoyi.business.mapper.PaymentAgentMapper;
import com.ruoyi.business.service.IPayQrCodeService;
import com.ruoyi.business.service.IPayService;
import com.ruoyi.business.util.pay.SybPayService;
import com.ruoyi.common.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class IPayServiceImpl implements IPayService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IPayQrCodeService payQrCodeService;

    @Autowired
    private PaymentAgentMapper paymentAgentMapper;

    /**
     * 生成支付二维码
     * @param trxamt
     * @param payType
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PayQrCodeVO generatePayQrCode(Long id, Long trxamt, String payType) {
        SybPayService service = new SybPayService();
        String reqsn = String.valueOf(System.currentTimeMillis());
        try {
            Map<String, String> map = service.pay(trxamt, reqsn, payType, "", "", "", "","http://113.45.139.88:8081/business/pay/callback","","","","", "", "", "", "", "", "", "","");
            if (!map.get("retcode").equals("SUCCESS")) {
                throw new ServiceException("生成二维码异常，请联系管理员");
            }

            PayQrCode payQrCode = new PayQrCode();
            payQrCode.setAppid(map.get("appid"));
            payQrCode.setCusid(map.get("cusid"));
            payQrCode.setPayinfo(map.get("payinfo"));
            payQrCode.setRandomstr(map.get("randomstr"));
            payQrCode.setReqsn(map.get("reqsn"));
            payQrCode.setRetcode(map.get("retcode"));
            payQrCode.setSign(map.get("sign"));
            payQrCode.setTrxcode(map.get("trxcode"));
            payQrCode.setTrxid(map.get("trxid"));
            payQrCode.setTrxstatus(map.get("trxstatus"));
            payQrCodeService.insertPayQrCode(payQrCode);

            PayQrCodeVO payQrCodeVO = new PayQrCodeVO();
            payQrCodeVO.setPayinfo(map.get("payinfo"));
            payQrCodeVO.setRandomstr(map.get("randomstr"));

            paymentAgentMapper.updateTrxid(id, map.get("trxid"));
            return payQrCodeVO;
        } catch (Exception e) {
            throw new ServiceException("生成二维码异常，请联系管理员");
        }
    }

    /**
     * 查询支付情况
     * @param randomstr
     * @return
     */
    @Override
    public boolean queryPayStatus(String randomstr) {
        PayQrCode payQrCode = payQrCodeService.payQrCodeMapper(randomstr);
        if (payQrCode == null) {
            throw new ServiceException("查询支付情况异常，请联系管理员");
        }

        SybPayService service = new SybPayService();
        try {
            Map<String, String> map = service.query("", payQrCode.getTrxid());
            logger.info(map.toString());
            if (!map.get("retcode").equals("SUCCESS")) {
                throw new ServiceException("查询支付情况异常，请联系管理员");
            }

            String trxstatus =  map.get("trxstatus");
            if (trxstatus.equals("0000")) {
                paymentAgentMapper.updatePaymentStatusByTrxid(payQrCode.getTrxid());
                return true;
            }

        } catch (Exception e) {
            throw new ServiceException("查询支付情况异常，请联系管理员");
        }

        return false;
    }
}
