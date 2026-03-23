package com.sdyle.sdaicodemother.langchain4j.ai;

import com.sdyle.sdaicodemother.utils.SpringContextUtil;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class CodeQualityCheckServiceFactory {

    /**
     * 创建代码质量检查 AI 服务
     */
    public CodeQualityCheckService createCodeQualityCheckService() {
        ChatModel chatModel = SpringContextUtil.getBean("openAiChatModel", ChatModel.class);
        return AiServices.builder(CodeQualityCheckService.class)
                .chatModel(chatModel)
                .build();
    }

    /**
     * 默认提供一个 Bean
     */
    @Bean
    public CodeQualityCheckService codeQualityCheckService() {
        return createCodeQualityCheckService();
    }
}
