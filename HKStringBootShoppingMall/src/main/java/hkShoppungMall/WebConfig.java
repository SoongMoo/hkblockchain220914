package hkShoppungMall;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// html이나 jsp문서 그리고 이미지파일인 경우 view밑에 있는 파일을 불러 올때 404오류가 나는 것을 방지
		registry.addResourceHandler("/**")
				.addResourceLocations("/view/")
				.setCachePeriod(14400);
	}
	  @Bean
	    public InteceptorConfig inteceptorConfig() {
	        return new InteceptorConfig();
	    }
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		
		//List<String> list = new ArrayList<String>();
		//list.add("/static/**/*");
		//list.add("/register/**/*");
		//list.add("/help/**/*");
		//list.add("/login/**/*");
		//list.add("/corner/**/*");
		//String [] list = {"/static/**/*","/register/**/*","/help/**/*","/login/**/*","/corner/**/*" };
		//registry.addInterceptor(inteceptorConfig())
		//				.addPathPatterns("/*")
		//				.excludePathPatterns(list);
	}

}
