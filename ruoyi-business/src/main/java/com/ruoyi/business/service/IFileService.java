package com.ruoyi.business.service;

import com.ruoyi.business.domain.File;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 文件Service接口
 * 
 * @author tangJM.
 * @date 2024-12-12
 */
public interface IFileService 
{
    /**
     * 查询文件
     * 
     * @param id 文件主键
     * @return 文件
     */
    public File selectFileById(Long id);

    /**
     * 查询文件列表
     * 
     * @param file 文件
     * @return 文件集合
     */
    public List<File> selectFileList(File file);

    /**
     * 新增文件
     * 
     * @param file 文件
     * @return 结果
     */
    public int insertFile(File file);

    /**
     * 修改文件
     * 
     * @param file 文件
     * @return 结果
     */
    public int updateFile(File file);

    /**
     * 批量删除文件
     * 
     * @param ids 需要删除的文件主键集合
     * @return 结果
     */
    public int deleteFileByIds(String ids);

    /**
     * 删除文件信息
     * 
     * @param id 文件主键
     * @return 结果
     */
    public int deleteFileById(Long id);

    /**
     *
     * @param files
     * @return
     */
    List<Long> uploadMultiple(MultipartFile[] files);

    /**
     * 根据文件ID获取文件信息
     * @param id
     * @return
     */
    File getById(Long id);
}
