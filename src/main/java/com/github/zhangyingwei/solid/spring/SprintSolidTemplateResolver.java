package com.github.zhangyingwei.solid.spring;

import com.github.zhangyingwei.solid.template.TemplateResolver;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractCachingViewResolver;

import java.util.Locale;

public class SprintSolidTemplateResolver extends AbstractCachingViewResolver implements Ordered {

    private TemplateResolver templateResolver;

    public SprintSolidTemplateResolver(TemplateResolver templateResolver) {
        this.templateResolver = templateResolver;
    }

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    protected View loadView(String viewName, Locale locale) throws Exception {
        return new SolidSpringView(this.templateResolver.resolve(viewName));
    }
}
