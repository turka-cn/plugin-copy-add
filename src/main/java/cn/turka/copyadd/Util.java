package cn.turka.copyadd;

import org.thymeleaf.context.ITemplateContext;
import run.halo.app.theme.DefaultTemplateEnum;
import run.halo.app.theme.router.strategy.ModelConst;

/**
 * @author Turka
 * @date 2023/6/12 8:40
 */

public class Util {

    /*
    * 此段代码参考了 plugin-highlightjs 插件的判断页面的写法
    * */

    public static Boolean isContentPage(ITemplateContext context) {

        return DefaultTemplateEnum.POST
                .getValue()
                .equals(context.getVariable(ModelConst.TEMPLATE_ID))
            || DefaultTemplateEnum.SINGLE_PAGE
                .getValue()
                .equals(context.getVariable(ModelConst.TEMPLATE_ID));

    }
}
