//package ru.kpfu.itis.group907.Economic.Service;
//
//import kpfu.itis.group907.Economic.Dao.Impl.DefaultUserDaoImpl;
//import kpfu.itis.group907.Economic.Service.DefaultUserService;
//import kpfu.itis.group907.Economic.Service.Impl.DefaultUserServiceImpl;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//
//import java.lang.reflect.Field;
//import java.sql.SQLException;
//
//public class DefaultUserServiceTest {
//    private final DefaultUserService defaultUserService = new DefaultUserServiceImpl();
//    private DefaultUserDaoImpl dao;
////    private final static
//
//    @Before
//    public void setup() throws NoSuchFieldException, IllegalAccessException {
//        dao = Mockito.mock(DefaultUserDaoImpl.class);
//        Field daoField = DefaultUserServiceImpl.class.getDeclaredField("dao");
//        daoField.setAccessible(true);//делаем поле public
//
//        daoField.set(defaultUserService, dao);
//
//    }
//
//    @Test
//    public void testGet() throws SQLException {
//        Mockito.when(dao.get("login")).thenReturn(false);
//
//        boolean b = defaultUserService.get("login");
//        Assert.assertEquals(true, b);
//    }
//
//}
