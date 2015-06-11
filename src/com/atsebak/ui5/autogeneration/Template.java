package com.atsebak.ui5.autogeneration;


import freemarker.template.Configuration;
import lombok.Builder;

import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;


@Builder
public class Template {
    private Map<String, Object> data;
    private Class<?> classContext;
    private String name;

    @Override
    public String toString() {
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(classContext, "/");
        try {
            freemarker.template.Template template = configuration.getTemplate(name);
            Writer writer = new StringWriter();
            template.process(data, writer);
            return writer.toString();

        } catch (Exception e) {

        }
        return "";
    }

}
