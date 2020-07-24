package com.gtao.demo.config.second;

import com.gtao.demo.config.AbstractBaseMapperScannerConfigure;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
@MapperScan(basePackages = {GtaoMapperScannerConfigurer.DEMO_PACKAGE}, sqlSessionFactoryRef = "gtaoSqlSessionFactory")
public class GtaoMapperScannerConfigurer extends AbstractBaseMapperScannerConfigure {


    static final String DEMO_PACKAGE = "com.gtao.demo.second.mapper";

    @Bean(name = "gtaoSqlSessionFactory")
    public SqlSessionFactory gtaoSqlSessionFactory(@Qualifier("gtaoDataSource") DataSource gtaoDataSource)
            throws Exception {
        return getSqlSessionFactory(gtaoDataSource);
    }

    static final String DEMO_MAPPER_LOCATION = "classpath*:com/gtao/demo/second/mapper/*.xml";

    @Override
    protected List<String> getMapperLocationsConfig() {
        List<String> mapperLocations = new ArrayList();
        mapperLocations.add(GtaoMapperScannerConfigurer.DEMO_MAPPER_LOCATION);
        return mapperLocations;
    }


}
