package life.majiang.community.mapper;

import java.util.List;
import life.majiang.community.model.Ad;
import life.majiang.community.model.AdExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface AdMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table AD
     *
     * @mbg.generated Thu Sep 05 06:46:42 CST 2019
     */
    long countByExample(AdExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table AD
     *
     * @mbg.generated Thu Sep 05 06:46:42 CST 2019
     */
    int deleteByExample(AdExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table AD
     *
     * @mbg.generated Thu Sep 05 06:46:42 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table AD
     *
     * @mbg.generated Thu Sep 05 06:46:42 CST 2019
     */
    int insert(Ad record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table AD
     *
     * @mbg.generated Thu Sep 05 06:46:42 CST 2019
     */
    int insertSelective(Ad record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table AD
     *
     * @mbg.generated Thu Sep 05 06:46:42 CST 2019
     */
    List<Ad> selectByExampleWithRowbounds(AdExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table AD
     *
     * @mbg.generated Thu Sep 05 06:46:42 CST 2019
     */
    List<Ad> selectByExample(AdExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table AD
     *
     * @mbg.generated Thu Sep 05 06:46:42 CST 2019
     */
    Ad selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table AD
     *
     * @mbg.generated Thu Sep 05 06:46:42 CST 2019
     */
    int updateByExampleSelective(@Param("record") Ad record, @Param("example") AdExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table AD
     *
     * @mbg.generated Thu Sep 05 06:46:42 CST 2019
     */
    int updateByExample(@Param("record") Ad record, @Param("example") AdExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table AD
     *
     * @mbg.generated Thu Sep 05 06:46:42 CST 2019
     */
    int updateByPrimaryKeySelective(Ad record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table AD
     *
     * @mbg.generated Thu Sep 05 06:46:42 CST 2019
     */
    int updateByPrimaryKey(Ad record);
}