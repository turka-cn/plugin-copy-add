package cn.turka.copyadd.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import run.halo.app.plugin.SettingFetcher;

import run.halo.app.theme.dialect.TemplateHeadProcessor;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IModel;
import org.thymeleaf.processor.element.IElementModelStructureHandler;
import org.thymeleaf.model.IModelFactory;

import cn.turka.copyadd.BasicConfig;

/**
 * 页面注入
 *
 * @author Turka
 * @date 2023/4/21 17:05
 */

@Component
@Slf4j
public class InjectProcessor implements TemplateHeadProcessor {

    private final SettingFetcher settingFetcher;

    public InjectProcessor(SettingFetcher settingFetcher) {
        this.settingFetcher = settingFetcher;
    }

    @Override
    public Mono<Void> process(ITemplateContext context,
                              IModel model,
                              IElementModelStructureHandler handler) {
        return settingFetcher.fetch("basic", BasicConfig.class)
            .map(config -> {
                ContentProcessor contentProcessor = new ContentProcessor();

                final IModelFactory modelFactory = context.getModelFactory();

                final CharSequence scriptText = contentProcessor.scriptProcess(
                    config.getCopyAddContent(),
                    config.getDivideType(),
                    config.getCopyMinLength());

                model.add(modelFactory.createText(scriptText));

                return Mono.empty();
            })
            .orElse(Mono.empty())
            .then();
    }
}
