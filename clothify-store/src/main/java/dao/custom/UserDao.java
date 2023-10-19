package dao.custom;

import dao.CrudDao;
import dto.UserDto;
import entity.UserEntity;

public interface UserDao extends CrudDao<UserDto,String> {

    UserEntity findUser(String userName, String password);
}
