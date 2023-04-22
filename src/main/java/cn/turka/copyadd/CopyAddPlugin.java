package cn.turka.copyadd;

import org.pf4j.PluginWrapper;
import org.springframework.stereotype.Component;
import run.halo.app.plugin.BasePlugin;

/**
 * 插件主文件
 *
 * @author turka
 * @since 2.0.0
 */

@Component
public class CopyAddPlugin extends BasePlugin {

    public CopyAddPlugin(PluginWrapper wrapper) {
        super(wrapper);
    }

    @Override
    public void start() {
    }

    @Override
    public void stop() {
    }
}
