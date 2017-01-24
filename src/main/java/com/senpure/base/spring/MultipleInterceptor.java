package com.senpure.base.spring;

import com.senpure.base.result.ResultMap;
import com.senpure.base.util.Download;
import com.senpure.base.util.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Locale;
import java.util.Map;

@Component
public class MultipleInterceptor extends InterceptorSupport {


    // private PropertyFilter filter= new HibernateFastJsonFilter();
@Autowired
    private LocaleResolver localeResolver;

    public LocaleResolver getLocaleResolver() {
        return localeResolver;
    }


    public void setLocaleResolver(LocaleResolver localeResolver) {
        this.localeResolver = localeResolver;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

        // jsp
        // modelAndView.addAllObjects(JSON.toJSONString(MenuUtil.getMenuContext(request)));

        log.debug(modelAndView);
        if (modelAndView != null) {
            Map<String, Object> model = modelAndView.getModel();
            ResultMap result = (ResultMap) model.get("action.result");
            if (result != null) {
                if (Http.isAjaxRequest(request)) {

                    Http.returnJson(response, result.toJson());
                    modelAndView.clear();
                    //modelAndView = null;
                    return;

                } else {
                    // 下载文件
                    if (result.isSuccess() && result.getFile() != null) {
                        File file = result.getFile();
                        Download.execute(response, file, result.getFileName(), result.isDelete());
                        //modelAndView.setViewName(null);
                        modelAndView.clear();
                        //modelAndView = null;
                        return;
                    }

                    // 处理页面视图，将result转换成一级字段
                    model.remove("action.result");
                    modelAndView.addAllObjects(result);


                }
            }
            //log.debug("http state"+response.getStatus());
            //加入菜单......
            String view = modelAndView.getViewName();

            if (view.contains("redirect")) {
                log.debug("重定向请求，不必加入菜单项");
                return;
            }

           // String menuJosn = MenuUtil.getMenu(request);
            String menuJosn;
//			//log.debug("menuJson:\n" + menuJosn);
//
//			log.debug("view:"+modelAndView.getViewName());
          //  modelAndView.addObject("menuJosn", menuJosn);
//			Map<String, Object> context = new HashMap<>();
//			Menu home = new Menu();
//			context.put("menuRoot", new ArrayList<Menu>());
//			context.put("menuHome", home);
            // modelAndView.addAllObjects(context);
            Locale locale = localeResolver.resolveLocale(request);
            String viewLocale = locale.getLanguage() + "-" + locale.getCountry();

            modelAndView.addObject("viewLocale", viewLocale);
            // ajax 返回json

        } else {
            log.debug("modelAndView is null");
        }

        super.postHandle(request, response, handler, modelAndView);
    }


}
