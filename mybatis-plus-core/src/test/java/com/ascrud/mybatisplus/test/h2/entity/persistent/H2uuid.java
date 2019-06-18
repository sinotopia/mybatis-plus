/**
 * Copyright (c) 2011-2014, cacotopia (cacotopia@126.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ascrud.mybatisplus.test.h2.entity.persistent;

import java.io.Serializable;

import com.ascrud.mybatisplus.annotations.TableId;
import com.ascrud.mybatisplus.annotations.TableName;
import com.ascrud.mybatisplus.enums.IdType;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 测试 UUID 主键
 * </p>
 *
 * @author hubin
 * @date 2017-06-28
 */
@Data
@Accessors(chain = true)
@TableName("h2uuid")
public class H2uuid implements Serializable {

    // 静态属性会自动忽略
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type = IdType.UUID)
    private String id;

    private String type;

    public H2uuid() {

    }

    public H2uuid(String type) {
        this.type = type;
    }

}
