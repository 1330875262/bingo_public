package com.sakura.sakuraapicommon.model.vo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sakura.sakuraapicommon.model.entity.InterfaceInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.sakura.sakuraapicommon.model.entity.Post;

/**
 * 帖子视图
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PostVO extends Post {
    /**
     * 是否已点赞
     */
    private Boolean hasThumb;

    private static final long serialVersionUID = 1L;
}