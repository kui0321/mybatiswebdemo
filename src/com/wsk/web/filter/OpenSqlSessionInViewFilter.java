package com.wsk.web.filter;

import com.wsk.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@WebFilter("/*")
public class OpenSqlSessionInViewFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try{
            filterChain.doFilter(servletRequest, servletResponse);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            MybatisUtils.closeSqlSession();
        }
    }

    @Override
    public void destroy() {

    }
}
