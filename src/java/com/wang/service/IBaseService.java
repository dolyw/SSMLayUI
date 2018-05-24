package com.wang.service;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import java.util.List;

/**
 * @Desc
 * @Author wang926454
 * @Date 2018/5/24 10:02
 */
public interface IBaseService<T> {

    // Select
    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     * @param record
     * @return
     */
    List<T> select(T record);

    /**
     * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     * @param key
     * @return
     */
    T selectByPrimaryKey(Object key);

    /**
     * 查询全部结果，select(null)方法能达到同样的效果
     * @return
     */
    List<T> selectAll();

    /**
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     * @param record
     * @return
     */
    T selectOne(T record);

    /**
     * 根据实体中的属性查询总数，查询条件使用等号
     * @param record
     * @return
     */
    int selectCount(T record);

    // Insert
    /**
     *保存一个实体，null的属性也会保存，不会使用数据库默认值
     * @param record
     * @return
     */
    int insert(T record);

    /**
     * 保存一个实体，null的属性不会保存，会使用数据库默认值
     * @param record
     * @return
     */
    int insertSelective(T record);

    // Update
    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(T record);

    /**
     * 根据主键更新属性不为null的值
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(T record);

    // Delete
    /**
     * 根据实体属性作为条件进行删除，查询条件使用等号
     * @param record
     * @return
     */
    int delete(T record);

    /**
     * 根据主键字段进行删除，方法参数必须包含完整的主键属性
     * @param key
     * @return
     */
    int deleteByPrimaryKey(Object key);

    // Example
    /**
     * 根据Example条件进行查询，这个查询支持通过Example类指定查询列，通过selectProperties方法指定查询列
     * @param example
     * @return
     */
    List<T> selectByExample(Object example);

    /**
     * 根据Example条件进行查询总数
     * @param example
     * @return
     */
    int selectCountByExample(Object example);

    /**
     * 根据Example条件更新实体record包含的全部属性，null值会被更新
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") T record, @Param("example") Object example);

    /**
     * 根据Example条件更新实体record包含的不是null的属性值
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") T record, @Param("example") Object example);

    /**
     * 根据Example条件删除数据
     * @param example
     * @return
     */
    int deleteByExample(Object example);

    // RowBounds
    /**
     * 根据实体属性和RowBounds进行分页查询
     * @param record
     * @param rowBounds
     * @return
     */
    List<T> selectByRowBounds(T record, RowBounds rowBounds);

    /**
     * 根据example条件和RowBounds进行分页查询
     * @param example
     * @param rowBounds
     * @return
     */
    List<T> selectByExampleAndRowBounds(Object example, RowBounds rowBounds);
}