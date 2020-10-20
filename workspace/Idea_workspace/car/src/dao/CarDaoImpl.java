package dao;

import entity.Car;
import utils.DbUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDaoImpl implements ICarDao {

    //返回所有的车辆信息
    public List<Car> queryAllCar() {
        String sql = "select * from  carport order by cname";
        return returnCars(DbUtils.query(sql, null));
    }

    //按租金倒序
    public List<Car> queryAllCarByRentDesc() {
        String sql = "select * from  carport order by crent desc";
        return returnCars(DbUtils.query(sql, null));
    }

    //按租金升序
    public List<Car> queryAllCarByRentAsc() {
        String sql = "select * from  carport order by crent ";
        return returnCars(DbUtils.query(sql, null));
    }


    //从ResultSet中返回List
    public List<Car> returnCars(ResultSet rs) {
        List<Car> cars = new ArrayList<>();
        try {
            while (rs.next()) {
                int cid = rs.getInt("cid");
                String cimg = rs.getString("cimg");
                String cinfo = rs.getString("cinfo");
                String cname = rs.getString("cname");
                double crent = rs.getDouble("crent");
                cars.add(new Car(cid, cimg, cinfo, cname, crent));
            }
            return cars;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DbUtils.close();
        }
        return null;
    }


    //从ResultSet中返回car
    public Car returnCar(ResultSet rs) {
        try {
            if (rs.next()) {
                return new Car(rs.getInt("cid"),rs.getString("cimg"),rs.getString("cinfo"),rs.getString("cname"),rs.getDouble("crent"));
            }else{
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DbUtils.close();
        }
        return null;
    }


    //模糊查询
    public List<Car> fuzzyQueryByCar(String name) {
        String sql = "select * from carport where cname like ?";
        String str = "%" + name + "%";
        Object[] objects = {str};
        return returnCars(DbUtils.query(sql, objects));
    }

    //根据车辆id 返回 car
    public Car queryCarById(String id) {
        String sql = "select * from carport where cid = ?";
        Object[] objects = {id};
        return  returnCar(DbUtils.query(sql,objects));
    }

    //根据分页 返回car
    public List<Car> queryCarByLimit(int page,int limit) {
        String sql = "select * from carport limit ?,?";
        Object[] obs = {page,limit};
        return returnCars(DbUtils.query(sql, obs));
    }

}
