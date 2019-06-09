package terai.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * TeraiMapper.
 * @author terai. 2019/06/10.
 */
@Mapper
public interface TeraiMapper {
    /**
     * exec drop schema query.
     * @param query exec sql.
     * @return resultCode result.
     */
	int dropSchema(@Param("schema") String schema);
    /**
     * exec create table query.
     * @param query exec sql.
     * @return resultCode result.
     */
    int createTable(@Param("query") String query);
    /**
     * exec insert const query.
     * @param query exec sql.
     * @return resultCode result.
     */
    int insertConst(@Param("query") String query);
}
