package com.ykh.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.google.common.collect.Lists;
import com.maxc.rest.common.Constants;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.number.NumberFormatAnnotationFormatterFactory;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.handler.SimpleServletHandlerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by ant_shake_tree on 15/7/18.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.ykh.web")
public class WebConfig extends WebMvcConfigurationSupport {
    /**
     * 描述 : <注册消息资源处理器>. <br>
     * <p>
     * <使用方法说明>
     * </p>
     *
     * @return
     */
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("config.messages.messages");

        return messageSource;
    }

    /**
     * 描述 : <注册试图处理器>. <br>
     * <p>
     * <使用方法说明>
     * </p>
     *
     * @return
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    /**
     * 描述 : <注册servlet适配器>. <br>
     * <p>
     * <只需要在自定义的servlet上用@Controller("映射路径")标注即可>
     * </p>
     *
     * @return
     */
    @Bean
    public HandlerAdapter servletHandlerAdapter() {
        return new SimpleServletHandlerAdapter();
    }

    /**
     * 描述 : <本地化拦截器>. <br>
     * <p>
     * <使用方法说明>
     * </p>
     *
     * @return
     */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        return new LocaleChangeInterceptor();
    }

    /**
     * 描述 : <基于cookie的本地化资源处理器>. <br>
     * <p>
     * <使用方法说明>
     * </p>
     *
     * @return
     */
    @Bean(name = "localeResolver")
    public CookieLocaleResolver cookieLocaleResolver() {
        return new CookieLocaleResolver();
    }


    /**
     * 描述 : <RequestMappingHandlerMapping需要显示声明，否则不能注册自定义的拦截器>. <br>
     * <p>
     * <这个比较奇怪,理论上应该是不需要的>
     * </p>
     *
     * @return
     */
    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {

        return super.requestMappingHandlerMapping();
    }


    /**
     * 描述 : <添加拦截器>. <br>
     * <p>
     * <使用方法说明>
     * </p>
     *
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
        // registry.addInterceptor(initializingInterceptor());
    }

    /**
     * 描述 : <HandlerMapping需要显示声明，否则不能注册资源访问处理器>. <br>
     * <p>
     * <这个比较奇怪,理论上应该是不需要的>
     * </p>
     *
     * @return
     */
    @Bean
    public HandlerMapping resourceHandlerMapping() {
        return super.resourceHandlerMapping();
    }


    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

//    /**
//     * 描述 : <文件上传处理器>. <br>
//     *<p>
//     <使用方法说明>
//     </p>
//     * @return
//     */
//    @Bean(name="multipartResolver")
//    public CommonsMultipartResolver commonsMultipartResolver(){
//        return new CommonsMultipartResolver();
//    }


    /**
     * 描述 : <RequestMappingHandlerAdapter需要显示声明，否则不能注册通用属性编辑器>. <br>
     * <p>
     * <这个比较奇怪,理论上应该是不需要的>
     * </p>
     *
     * @return
     */
    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {

        List<HttpMessageConverter<?>> a = getMessageConverters();
        a.clear();
        a.add(fastJsonHttpMessageConverter());

//        super.requestMappingHandlerAdapter().getMessageConverters().add(fastJsonHttpMessageConverter());
        return super.requestMappingHandlerAdapter();
    }

    @Bean
    public FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        fastJsonHttpMessageConverter.setCharset(Charset.forName("UTF-8"));
        List<MediaType> mediaTypeList = Lists.newArrayList();
        MediaType mediatype = MediaType.APPLICATION_JSON;
        mediaTypeList.add(mediatype);
        fastJsonHttpMessageConverter.setSupportedMediaTypes(mediaTypeList);
        return fastJsonHttpMessageConverter;
    }

    @Bean
    public FormattingConversionService mvcConversionService() {

        // Use the DefaultFormattingConversionService but do not register defaults
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService(false);

        // Ensure @NumberFormat is still supported
        conversionService.addFormatterForFieldAnnotation(new NumberFormatAnnotationFormatterFactory());

        // Register date conversion with a specific global format
        DateFormatterRegistrar registrar = new DateFormatterRegistrar();
        registrar.setFormatter(new DateFormatter(Constants.DATE_FORMAT_HOURE_MINUTE_SENCOND));

        registrar.registerFormatters(conversionService);
        return conversionService;
    }


}
