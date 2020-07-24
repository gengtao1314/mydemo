package com.gtao.demo.config.first;

import com.gtao.demo.config.AbstractBaseMapperScannerConfigure;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品中心mapper文件扫描器
 * @author liwensihan
 * @date 2020/05/28
 */
@Log4j2
@Configuration
@MapperScan(basePackages = {DemoMapperScannerConfigurer.DEMO_PACKAGE}, sqlSessionFactoryRef = "demoSqlSessionFactory")
public class DemoMapperScannerConfigurer extends AbstractBaseMapperScannerConfigure {


    static final String DEMO_PACKAGE = "com.gtao.demo.first.mapper";

    @Primary
    @Bean(name = "demoSqlSessionFactory")
    public SqlSessionFactory demoSqlSessionFactory(@Qualifier("demoDataSource") DataSource goodsCenterDataSource)
            throws Exception {
        return getSqlSessionFactory(goodsCenterDataSource);
    }

    static final String DEMO_MAPPER_LOCATION = "classpath*:com/gtao/demo/first/mapper/*.xml";

    @Override
    protected List<String> getMapperLocationsConfig() {
        List<String> mapperLocations = new ArrayList();
        mapperLocations.add(DemoMapperScannerConfigurer.DEMO_MAPPER_LOCATION);
        return mapperLocations;
    }


}
