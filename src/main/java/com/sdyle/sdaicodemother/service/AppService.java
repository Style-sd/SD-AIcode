package com.sdyle.sdaicodemother.service;

import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.sdyle.sdaicodemother.model.dto.app.AppQueryRequest;
import com.sdyle.sdaicodemother.model.entity.App;
import com.sdyle.sdaicodemother.model.entity.User;
import com.sdyle.sdaicodemother.model.vo.AppVO;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * 应用 服务层。
 *
 * @author Sdyle
 * @since 2026-03-15
 */
public interface AppService extends IService<App> {


    AppVO getAppVO(App app);

    QueryWrapper getQueryWrapper(AppQueryRequest appQueryRequest);

    List<AppVO> getAppVOList(List<App> appList);

    Flux<String> chatToGenCode(Long appId, String messege, User loginUser);

    String deployApp(Long appId, User loginUser);
}
