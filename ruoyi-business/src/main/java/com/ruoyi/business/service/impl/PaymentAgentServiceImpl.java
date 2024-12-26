package com.ruoyi.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.business.domain.vo.PaymentAgentListVO;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.PaymentAgentMapper;
import com.ruoyi.business.domain.PaymentAgent;
import com.ruoyi.business.service.IPaymentAgentService;

import static com.ruoyi.common.utils.SecurityUtils.getLoginUser;

/**
 * 代缴学费Service业务层处理
 * 
 * @author tangJM.
 * @date 2024-12-18
 */
@Service
public class PaymentAgentServiceImpl implements IPaymentAgentService 
{
    @Autowired
    private PaymentAgentMapper paymentAgentMapper;

    /**
     * 查询代缴学费
     * 
     * @param id 代缴学费主键
     * @return 代缴学费
     */
    @Override
    public PaymentAgent selectPaymentAgentById(Long id)
    {
        return paymentAgentMapper.selectPaymentAgentById(id);
    }

    /**
     * 查询代缴学费列表
     * 
     * @param createId 代缴学费
     * @return 代缴学费
     */
    @Override
    public List<PaymentAgentListVO> selectPaymentAgentList(Long createId)
    {
        return paymentAgentMapper.selectPaymentAgentList2(createId);
    }

    /**
     * 新增代缴学费
     * 
     * @param paymentAgent 代缴学费
     * @return 结果
     */
    @Override
    public Long insertPaymentAgent(PaymentAgent paymentAgent)
    {
        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        paymentAgent.setPaymentStatus(1);
        paymentAgent.setCreateId(user.getUserId());
        paymentAgent.setCreateBy(user.getUserName());
        paymentAgent.setCreateTime(DateUtils.getNowDate());
        paymentAgentMapper.insertPaymentAgent(paymentAgent);
        return paymentAgent.getId();
    }

    /**
     * 修改代缴学费
     * 
     * @param paymentAgent 代缴学费
     * @return 结果
     */
    @Override
    public int updatePaymentAgent(PaymentAgent paymentAgent)
    {
        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        paymentAgent.setPaymentStatus(2);
        paymentAgent.setUpdateId(user.getUserId());
        paymentAgent.setUpdateBy(user.getUserName());
        paymentAgent.setUpdateTime(DateUtils.getNowDate());
        return paymentAgentMapper.updatePaymentAgent(paymentAgent);
    }

    /**
     * 批量删除代缴学费
     * 
     * @param ids 需要删除的代缴学费主键
     * @return 结果
     */
    @Override
    public int deletePaymentAgentByIds(List<Integer> ids)
    {
        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long userId = user.getUserId();
        String userName = user.getUserName();
        return paymentAgentMapper.deletePaymentAgentByIds(ids, userId, userName);
    }

    /**
     * 删除代缴学费信息
     * 
     * @param id 代缴学费主键
     * @return 结果
     */
    @Override
    public int deletePaymentAgentById(Long id)
    {
        return paymentAgentMapper.deletePaymentAgentById(id);
    }

}
