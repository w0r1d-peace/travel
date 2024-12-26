package com.ruoyi.business.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 交易明细对象 t_transaction_details
 * 
 * @author tangJM.
 * @date 2024-12-26
 */
public class TransactionDetails extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 商户号，平台分配的商户号 */
    @Excel(name = "商户号，平台分配的商户号")
    private String cusid;

    /** 应用ID，平台分配的APPID */
    @Excel(name = "应用ID，平台分配的APPID")
    private String appid;

    /** 交易单号，平台的交易流水号 */
    @Excel(name = "交易单号，平台的交易流水号")
    private String trxid;

    /** 支付渠道交易单号，如微信支付/支付宝等的交易单号 */
    @Excel(name = "支付渠道交易单号，如微信支付/支付宝等的交易单号")
    private String chnltrxid;

    /** 商户订单号，客户的交易订单号 */
    @Excel(name = "商户订单号，客户的交易订单号")
    private String reqsn;

    /** 交易类型 */
    @Excel(name = "交易类型")
    private String trxcode;

    /** 交易金额，单位为元 */
    @Excel(name = "交易金额，单位为元")
    private BigDecimal trxamt;

    /** 交易状态 */
    @Excel(name = "交易状态")
    private String trxstatus;

    /** 支付平台用户标识，用于支付标识 */
    @Excel(name = "支付平台用户标识，用于支付标识")
    private String acct;

    /** 交易完成时间，格式为yyyyMMddHHmmss */
    @Excel(name = "交易完成时间，格式为yyyyMMddHHmmss")
    private String fintime;

    /** 随机字符串 */
    @Excel(name = "随机字符串")
    private String randomstr;

    /** 错误原因，失败的原因说明 */
    @Excel(name = "错误原因，失败的原因说明")
    private String errmsg;

    /** 渠道子商户号 */
    @Excel(name = "渠道子商户号")
    private String cmid;

    /** 渠道号 */
    @Excel(name = "渠道号")
    private String chnlid;

    /** 原交易金额 */
    @Excel(name = "原交易金额")
    private BigDecimal initamt;

    /** 手续费 */
    @Excel(name = "手续费")
    private BigDecimal fee;

    /** 渠道信息，目前设定云闪付/微信/支付宝的活动参数 */
    @Excel(name = "渠道信息，目前设定云闪付/微信/支付宝的活动参数")
    private String chnldata;

    /** 付款标识 */
    @Excel(name = "付款标识")
    private String accttype;

    /** 所属银行 */
    @Excel(name = "所属银行")
    private String bankcode;

    /** 买家账号 */
    @Excel(name = "买家账号")
    private String logonid;

    /** 签名 */
    @Excel(name = "签名")
    private String sign;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCusid(String cusid) 
    {
        this.cusid = cusid;
    }

    public String getCusid() 
    {
        return cusid;
    }
    public void setAppid(String appid) 
    {
        this.appid = appid;
    }

    public String getAppid() 
    {
        return appid;
    }
    public void setTrxid(String trxid) 
    {
        this.trxid = trxid;
    }

    public String getTrxid() 
    {
        return trxid;
    }
    public void setChnltrxid(String chnltrxid) 
    {
        this.chnltrxid = chnltrxid;
    }

    public String getChnltrxid() 
    {
        return chnltrxid;
    }
    public void setReqsn(String reqsn) 
    {
        this.reqsn = reqsn;
    }

    public String getReqsn() 
    {
        return reqsn;
    }
    public void setTrxcode(String trxcode) 
    {
        this.trxcode = trxcode;
    }

    public String getTrxcode() 
    {
        return trxcode;
    }
    public void setTrxamt(BigDecimal trxamt) 
    {
        this.trxamt = trxamt;
    }

    public BigDecimal getTrxamt() 
    {
        return trxamt;
    }
    public void setTrxstatus(String trxstatus) 
    {
        this.trxstatus = trxstatus;
    }

    public String getTrxstatus() 
    {
        return trxstatus;
    }
    public void setAcct(String acct) 
    {
        this.acct = acct;
    }

    public String getAcct() 
    {
        return acct;
    }
    public void setFintime(String fintime) 
    {
        this.fintime = fintime;
    }

    public String getFintime() 
    {
        return fintime;
    }
    public void setRandomstr(String randomstr) 
    {
        this.randomstr = randomstr;
    }

    public String getRandomstr() 
    {
        return randomstr;
    }
    public void setErrmsg(String errmsg) 
    {
        this.errmsg = errmsg;
    }

    public String getErrmsg() 
    {
        return errmsg;
    }
    public void setCmid(String cmid) 
    {
        this.cmid = cmid;
    }

    public String getCmid() 
    {
        return cmid;
    }
    public void setChnlid(String chnlid) 
    {
        this.chnlid = chnlid;
    }

    public String getChnlid() 
    {
        return chnlid;
    }
    public void setInitamt(BigDecimal initamt) 
    {
        this.initamt = initamt;
    }

    public BigDecimal getInitamt() 
    {
        return initamt;
    }
    public void setFee(BigDecimal fee) 
    {
        this.fee = fee;
    }

    public BigDecimal getFee() 
    {
        return fee;
    }
    public void setChnldata(String chnldata) 
    {
        this.chnldata = chnldata;
    }

    public String getChnldata() 
    {
        return chnldata;
    }
    public void setAccttype(String accttype) 
    {
        this.accttype = accttype;
    }

    public String getAccttype() 
    {
        return accttype;
    }
    public void setBankcode(String bankcode) 
    {
        this.bankcode = bankcode;
    }

    public String getBankcode() 
    {
        return bankcode;
    }
    public void setLogonid(String logonid) 
    {
        this.logonid = logonid;
    }

    public String getLogonid() 
    {
        return logonid;
    }
    public void setSign(String sign) 
    {
        this.sign = sign;
    }

    public String getSign() 
    {
        return sign;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("cusid", getCusid())
            .append("appid", getAppid())
            .append("trxid", getTrxid())
            .append("chnltrxid", getChnltrxid())
            .append("reqsn", getReqsn())
            .append("trxcode", getTrxcode())
            .append("trxamt", getTrxamt())
            .append("trxstatus", getTrxstatus())
            .append("acct", getAcct())
            .append("fintime", getFintime())
            .append("randomstr", getRandomstr())
            .append("errmsg", getErrmsg())
            .append("cmid", getCmid())
            .append("chnlid", getChnlid())
            .append("initamt", getInitamt())
            .append("fee", getFee())
            .append("chnldata", getChnldata())
            .append("accttype", getAccttype())
            .append("bankcode", getBankcode())
            .append("logonid", getLogonid())
            .append("sign", getSign())
            .toString();
    }
}
