package com.ruoyi.business.service;

import com.ruoyi.business.domain.vo.PayQrCodeVO;

public interface IPayService {
    /**
     * 生成支付二维码
     * @param trxamt
     * @param payType
     * @return
     */
    PayQrCodeVO generatePayQrCode(Long trxamt, String payType);

    /**
     * 查询支付状态
     * @param randomstr
     * @return
     */
    boolean queryPayStatus(String randomstr);
}
