package umc.spring.web.resolver;

import org.hibernate.query.Page;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import umc.spring.apiPayload.exception.PageValidationException;
import umc.spring.validation.annotation.convertPage;

@Component
public class PageResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(convertPage.class)
                && parameter.getParameterType().equals(Integer.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {

        String pageParam = webRequest.getParameter("page");

        int page;

        try {
            page = Integer.parseInt(pageParam);
        } catch (NumberFormatException e) {
            throw new PageValidationException("page는 숫자여야 합니다.");
        }

        if (page < 1) {
            throw new PageValidationException("page는 1 이상의 값이어야 합니다.");
        }

        return page - 1;  // PageRequest.of(0, 10)과 맞추기 위해 1-based → 0-based 변환
    }
}
