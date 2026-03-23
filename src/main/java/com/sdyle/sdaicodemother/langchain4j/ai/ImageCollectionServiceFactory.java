package com.sdyle.sdaicodemother.langchain4j.ai;

import com.sdyle.sdaicodemother.langchain4j.tools.ImageSearchTool;
import com.sdyle.sdaicodemother.langchain4j.tools.MermaidDiagramTool;
import com.sdyle.sdaicodemother.langchain4j.tools.UndrawIllustrationTool;
import com.sdyle.sdaicodemother.utils.SpringContextUtil;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ImageCollectionServiceFactory {

    @Resource
    private ImageSearchTool imageSearchTool;

    @Resource
    private UndrawIllustrationTool undrawIllustrationTool;

    @Resource
    private MermaidDiagramTool mermaidDiagramTool;


    /**
     * 创建图片收集 AI 服务
     */
    public ImageCollectionService createImageCollectionService() {
        ChatModel chatModel = SpringContextUtil.getBean("openAiChatModel", ChatModel.class);
        return AiServices.builder(ImageCollectionService.class)
                .chatModel(chatModel)
                .tools(
                        imageSearchTool,
                        undrawIllustrationTool,
                        mermaidDiagramTool
                )
                .build();
    }

    /**
     * 默认提供一个 Bean
     */
    @Bean
    public ImageCollectionService imageCollectionService() {
        return createImageCollectionService();
    }
}
