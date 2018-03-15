package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.Category;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * ICategoryService
 *
 * @author lijc
 * @date 2018/3/14 14:53
 */
public interface ICategoryService {
    /**
     * 添加类别
     *
     * @param categoryName 类别名称
     * @param parentId     父级菜单ID
     * @return
     */
    ServerResponse addCategory(String categoryName, Integer parentId);

    /**
     * 修改类别名称
     *
     * @param categoryName 新的类别名称
     * @param categoryId   类别id
     * @return
     */
    ServerResponse updateCategory(String categoryName, Integer categoryId);

    /**
     * 获取指定节点的子节点
     *
     * @param categoryId 节点ID
     * @return
     */
    ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId);


    /**
     * 获取节点及子节点的id
     *
     * @param categoryId 节点ID
     * @return
     */
    ServerResponse selectCategoryAndChildrenById(Integer categoryId);
}
