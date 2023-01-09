package hkShoppungMall;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// html이나 jsp문서 그리고 이미지파일인 경우 view밑에 있는 파일을 불러 올때 404오류가 나는 것을 방지
		registry.addResourceHandler("/**")
				.addResourceLocations("/view/")
				.setCachePeriod(14400);
	}

	@Bean(value = "jsonView")
    public MappingJackson2JsonView jsonView() {
        return new MappingJackson2JsonView();
    }
}
