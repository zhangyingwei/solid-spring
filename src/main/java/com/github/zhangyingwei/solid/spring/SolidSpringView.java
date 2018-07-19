package com.github.zhangyingwei.solid.spring;

import com.github.zhangyingwei.solid.template.Template;
import org.springframework.web.servlet.view.AbstractUrlBasedView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class SolidSpringView extends AbstractUrlBasedView {

    private Template template;

    public SolidSpringView(Template template) {
        this.template = template;
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            this.template.bind(entry.getKey(), entry.getValue());
        }
        httpServletResponse.setContentType(template.getContentType());
        httpServletResponse.getWriter().write(this.template.render());
        httpServletResponse.getWriter().close();
    }
}
