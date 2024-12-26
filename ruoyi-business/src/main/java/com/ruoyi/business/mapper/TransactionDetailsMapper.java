package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.TransactionDetails;

/**
 * 交易明细Mapper接口
 * 
 * @author tangJM.
 * @date 2024-12-26
 */
public interface TransactionDetailsMapper 
{
    /**
     * 查询交易明细
     * 
     * @param id 交易明细主键
     * @return 交易明细
     */
    public TransactionDetails selectTransactionDetailsById(Long id);

    /**
     * 查询交易明细列表
     * 
     * @param transactionDetails 交易明细
     * @return 交易明细集合
     */
    public List<TransactionDetails> selectTransactionDetailsList(TransactionDetails transactionDetails);

    /**
     * 新增交易明细
     * 
     * @param transactionDetails 交易明细
     * @return 结果
     */
    public int insertTransactionDetails(TransactionDetails transactionDetails);

    /**
     * 修改交易明细
     * 
     * @param transactionDetails 交易明细
     * @return 结果
     */
    public int updateTransactionDetails(TransactionDetails transactionDetails);

    /**
     * 删除交易明细
     * 
     * @param id 交易明细主键
     * @return 结果
     */
    public int deleteTransactionDetailsById(Long id);

    /**
     * 批量删除交易明细
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTransactionDetailsByIds(Long[] ids);
}
