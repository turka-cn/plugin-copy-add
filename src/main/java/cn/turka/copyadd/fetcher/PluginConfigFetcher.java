package cn.turka.copyadd.fetcher;

import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import run.halo.app.plugin.SettingFetcher;

import cn.turka.copyadd.BasicConfig;

/**
 * 获取插件配置内容
 *
 * @author Turka
 * @date 2023/5/23 10:41
 */

@Component
public class PluginConfigFetcher {

    private final SettingFetcher settingFetcher;

    public PluginConfigFetcher(SettingFetcher settingFetcher) {
        this.settingFetcher = settingFetcher;
    }

    public BasicConfig fetch() {

        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode configJsonNode = settingFetcher.get("basic");

        return objectMapper.convertValue(configJsonNode, BasicConfig.class);
    }
}
