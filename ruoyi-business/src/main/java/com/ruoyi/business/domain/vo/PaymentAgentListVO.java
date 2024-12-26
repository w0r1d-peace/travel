package com.ruoyi.business.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class PaymentAgentListVO {

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 付款状态 1.待付款 2.已付款 3.失败
     */
    private Integer paymentStatus;

    /**
     * 手机号码
     */
    private String phonenumber;
}
