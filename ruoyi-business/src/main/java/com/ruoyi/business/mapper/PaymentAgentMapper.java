package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.PaymentAgent;
import org.apache.ibatis.annotations.Param;

/**
 * 代缴学费Mapper接口
 * 
 * @author tangJM.
 * @date 2024-12-18
 */
public interface PaymentAgentMapper 
{
    /**
     * 查询代缴学费
     * 
     * @param id 代缴学费主键
     * @return 代缴学费
     */
    public PaymentAgent selectPaymentAgentById(Long id);

    /**
     * 查询代缴学费列表
     * 
     * @param paymentAgent 代缴学费
     * @return 代缴学费集合
     */
    public List<PaymentAgent> selectPaymentAgentList(PaymentAgent paymentAgent);

    /**
     * 新增代缴学费
     * 
     * @param paymentAgent 代缴学费
     * @return 结果
     */
    public int insertPaymentAgent(PaymentAgent paymentAgent);

    /**
     * 修改代缴学费
     * 
     * @param paymentAgent 代缴学费
     * @return 结果
     */
    public int updatePaymentAgent(PaymentAgent paymentAgent);

    /**
     * 删除代缴学费
     * 
     * @param id 代缴学费主键
     * @return 结果
     */
    public int deletePaymentAgentById(Long id);

    /**
     * 批量删除代缴学费
     * 
     * @param idList 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePaymentAgentByIds(@Param("idList") List<Integer> idList, @Param("updateId") Long updateId, @Param("updateBy") String updateBy);
}
