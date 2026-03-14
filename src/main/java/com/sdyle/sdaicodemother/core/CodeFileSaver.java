package com.sdyle.sdaicodemother.core;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.sdyle.sdaicodemother.ai.model.HtmlCodeResult;
import com.sdyle.sdaicodemother.ai.model.MultiFileCodeResult;
import com.sdyle.sdaicodemother.model.enums.CodeGenTypeEnum;

import java.io.File;
import java.nio.charset.StandardCharsets;

public class CodeFileSaver {

    private static final String File_SAVE_ROOT_DIR = System.getProperty("user.dir") + "/tmp/code_output";


    //拼接文件路径 + 文件名 + 文件内容
    public static File saveHtmlCodeResult(HtmlCodeResult htmlCodeResult){
        String baseDirPath = buildUniqueDir(CodeGenTypeEnum.HTML.getValue());
        writeToFile(baseDirPath, "index.html", htmlCodeResult.getHtmlCode());
        return new File(baseDirPath);
    }

    public static File saveMultiFileCodeResult(MultiFileCodeResult multiFileCodeResult){
        String baseDirPath = buildUniqueDir(CodeGenTypeEnum.MULTI_FILE.getValue());
        writeToFile(baseDirPath, "index.html", multiFileCodeResult.getHtmlCode());
        writeToFile(baseDirPath, "style.css", multiFileCodeResult.getCssCode());
        writeToFile(baseDirPath, "script.js", multiFileCodeResult.getJsCode());
        return new File(baseDirPath);

    }

    private static void writeToFile(String baseDirPath, String s, String htmlCode) {
        String filePath = baseDirPath + "/" + s;
        FileUtil.writeString(htmlCode, filePath, StandardCharsets.UTF_8);
    }

    private static String buildUniqueDir(String value) {
        String uniqueDirName = StrUtil.format("{}_{}", value, IdUtil.getSnowflakeNextIdStr());
        String dirPath = File_SAVE_ROOT_DIR + "/" + uniqueDirName;

        FileUtil.mkdir(dirPath);
        return dirPath;
    }


}
