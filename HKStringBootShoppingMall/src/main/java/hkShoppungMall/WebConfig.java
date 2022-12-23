package hkShoppungMall;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
@Configuration
public class WebConfig implements WebMvcConfigurer{	
	@Autowired
    @Qualifier(value = "loginInterceptor")
    private HandlerInterceptor loginInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		List<String> notLoadList = new ArrayList<String>();
		notLoadList.add("/static/**/*");
		notLoadList.add("/register/**/*");
		notLoadList.add("/help/**/*");
		notLoadList.add("/login/**/*");
		notLoadList.add("/corner/**/*");
		 registry.addInterceptor(loginInterceptor)
		 		 .addPathPatterns("/**")
		 		 .excludePathPatterns(notLoadList);  
		// 로그인 세션이 없어도 되는 주소들을 적어 준다.
	}
	
	// html이나 jsp문서 그리고 이미지파일인 경우 view밑에 있는 파일을 불러 올때 404오류가 나는 것을 방지
	@Override
	public void addResourceHandlers(
			ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**")
                .addResourceLocations("/view/")
                .setCachePeriod(14400);
	}

	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource source= new ResourceBundleMessageSource();
		source.setBasenames("message/error");
		source.setUseCodeAsDefaultMessage(true);
		source.setDefaultEncoding("utf-8");
		return source;
	}

	@Bean(name="jsonView")
    public MappingJackson2JsonView jsonView() {
        return new MappingJackson2JsonView();
    }

	
}



