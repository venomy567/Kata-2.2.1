package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

// Добавление юзеров и машин в таблицу
//      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      Car car1 = new Car("model1", 1);
////      user1.setCar(car1);
////      userService.add(user1);
//
//      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
//      user2.setCar(car1);
//      userService.add(user2);

//      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
//      Car car3 = new Car("model2", 2);
//      user3.setCar(car3);
//      userService.add(user3);


      //Возвращает лист из юзер у которых есть совпадение по модели и серии
      List<User> usersByCar = userService.getUserByCar(car1);
      for (User user : usersByCar) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Id_Car = " + user.getCar());
         System.out.println();
      }

      context.close();
   }
}
