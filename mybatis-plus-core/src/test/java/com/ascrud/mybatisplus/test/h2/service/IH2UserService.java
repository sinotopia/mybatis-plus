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
package com.ascrud.mybatisplus.test.h2.service;

import java.util.List;
import java.util.Map;

import com.ascrud.mybatisplus.plugins.Page;
import com.ascrud.mybatisplus.service.IService;
import com.ascrud.mybatisplus.test.h2.entity.persistent.H2User;

/**
 * <p>
 * Service层测试
 * </p>
 *
 * @author hubin
 * @date 2017-01-30
 */
public interface IH2UserService extends IService<H2User> {

    int myInsert(String name, int version);

    int myInsertWithParam(String name, int version);

    int myInsertWithoutParam(String name, int version);

    int myUpdate(Long id, String name);

    List<H2User> queryWithParamInSelectStatememt(Map<String, Object> param);

    Page<H2User> queryWithParamInSelectStatememt4Page(Map<String, Object> param, Page<H2User> page);

    int selectCountWithParamInSelectItems(Map<String, Object> param);

    List<Map> mySelectMaps();
}
