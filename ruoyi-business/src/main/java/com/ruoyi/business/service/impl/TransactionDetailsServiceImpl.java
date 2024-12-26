package com.ruoyi.business.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.TransactionDetailsMapper;
import com.ruoyi.business.domain.TransactionDetails;
import com.ruoyi.business.service.ITransactionDetailsService;

/**
 * 交易明细Service业务层处理
 * 
 * @author tangJM.
 * @date 2024-12-26
 */
@Service
public class TransactionDetailsServiceImpl implements ITransactionDetailsService 
{
    @Autowired
    private TransactionDetailsMapper transactionDetailsMapper;

    /**
     * 查询交易明细
     * 
     * @param id 交易明细主键
     * @return 交易明细
     */
    @Override
    public TransactionDetails selectTransactionDetailsById(Long id)
    {
        return transactionDetailsMapper.selectTransactionDetailsById(id);
    }

    /**
     * 查询交易明细列表
     * 
     * @param transactionDetails 交易明细
     * @return 交易明细
     */
    @Override
    public List<TransactionDetails> selectTransactionDetailsList(TransactionDetails transactionDetails)
    {
        return transactionDetailsMapper.selectTransactionDetailsList(transactionDetails);
    }

    /**
     * 新增交易明细
     * 
     * @param transactionDetails 交易明细
     * @return 结果
     */
    @Override
    public int insertTransactionDetails(TransactionDetails transactionDetails)
    {
        return transactionDetailsMapper.insertTransactionDetails(transactionDetails);
    }

    /**
     * 修改交易明细
     * 
     * @param transactionDetails 交易明细
     * @return 结果
     */
    @Override
    public int updateTransactionDetails(TransactionDetails transactionDetails)
    {
        return transactionDetailsMapper.updateTransactionDetails(transactionDetails);
    }

    /**
     * 批量删除交易明细
     * 
     * @param ids 需要删除的交易明细主键
     * @return 结果
     */
    @Override
    public int deleteTransactionDetailsByIds(Long[] ids)
    {
        return transactionDetailsMapper.deleteTransactionDetailsByIds(ids);
    }

    /**
     * 删除交易明细信息
     * 
     * @param id 交易明细主键
     * @return 结果
     */
    @Override
    public int deleteTransactionDetailsById(Long id)
    {
        return transactionDetailsMapper.deleteTransactionDetailsById(id);
    }

    /**
     * 保存交易明细
     * @param params
     * @return
     */
    @Override
    public void saveTransactionDetails(Map<String, String> params) {
        TransactionDetails transactionDetails = new TransactionDetails();
        BeanUtils.copyProperties(params, transactionDetails);
        transactionDetailsMapper.insertTransactionDetails(transactionDetails);
    }
}
