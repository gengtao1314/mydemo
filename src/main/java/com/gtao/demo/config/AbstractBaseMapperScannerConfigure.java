package com.gtao.demo.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.github.pagehelper.PageInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * mapper文件扫描器抽象类
 *
 * @author liwensihan
 * @date 2020/05/28
 */
@Slf4j
public abstract class AbstractBaseMapperScannerConfigure {

    @Autowired
    Interceptor[] interceptors;

    /**
     * pageHelper分页插件
     * 
     * @return
     */
    @Bean
    public PageInterceptor addPageInterceptor() {
        PageInterceptor interceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "mysql");
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("params", "count=countSql");
        properties.setProperty("pageSizeZero", "true");
        // 在把特殊配置放进去，由于close-conn 利用上面方式时，属性名就是 close-conn 而不是 closeConn，所以需要额外的一步
        interceptor.setProperties(properties);
        return interceptor;
    }

    /**
     * mybatis-plus分页插件
     * 
     * @return
     */
    @Bean
    public PaginationInterceptor setPaginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }

    protected SqlSessionFactory getSqlSessionFactory(DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean sessionFactory = new MybatisSqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);

        sessionFactory.setPlugins(interceptors);
        // 配置填充器
        sessionFactory.setMapperLocations(getMapperLocations());
       // sessionFactory.setTypeAliasesPackage("com.dffl.goods.query.adapter.dto");
        try {
            sessionFactory.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
            return sessionFactory.getObject();
        } catch (Exception e) {
            log.error("entity转换驼峰命名失败", e);
        }
        return sessionFactory.getObject();
    }

    protected abstract List<String> getMapperLocationsConfig();

    protected Resource[] getMapperLocations() throws IOException {
        List<Resource> resourcesList = new ArrayList<>();
        List<String> mapperLocations = getMapperLocationsConfig();
        for (String location : mapperLocations) {
            Resource[] resources = new PathMatchingResourcePatternResolver().getResources(location);
            resourcesList.addAll(Arrays.asList(resources));
        }
        System.out.println("-----------load xml---------" + resourcesList.toString());
        return resourcesList.toArray(new Resource[resourcesList.size()]);
    }

}
