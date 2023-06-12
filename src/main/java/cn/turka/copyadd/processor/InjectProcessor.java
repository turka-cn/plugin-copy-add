package cn.turka.copyadd.processor;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import run.halo.app.theme.dialect.TemplateHeadProcessor;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IModel;
import org.thymeleaf.processor.element.IElementModelStructureHandler;
import org.thymeleaf.model.IModelFactory;

import cn.turka.copyadd.Util;
import cn.turka.copyadd.BasicConfig;
import cn.turka.copyadd.fetcher.PluginConfigFetcher;

/**
 * 页面注入
 *
 * @author Turka
 * @date 2023/4/21 17:05
 */

@Component
public class InjectProcessor implements TemplateHeadProcessor {

    private final PluginConfigFetcher pluginConfigFetcher;

    public InjectProcessor(PluginConfigFetcher pluginConfigFetcher) {
        this.pluginConfigFetcher = pluginConfigFetcher;
    }

    @Override
    public Mono<Void> process(ITemplateContext context,
                              IModel model,
                              IElementModelStructureHandler handler) {

        BasicConfig basicConfig = pluginConfigFetcher.fetch();

        if (basicConfig.getContentPageOnly() && !Util.isContentPage(context)) {
            return Mono.empty();
        }

        final IModelFactory modelFactory = context.getModelFactory();

        final CharSequence scriptText = ContentProcessor.scriptProcess(
            basicConfig.getCopyAddContent(),
            basicConfig.getDivideType(),
            basicConfig.getCopyMinLength());

        model.add(modelFactory.createText(scriptText));

        return Mono.empty();
    }
}
