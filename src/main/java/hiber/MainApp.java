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


      Car car1 = new Car("model1", 1);
      User user1 = new User("User5", "Lastname5", "user5@mail.ru", car1);
      user1.setCar(car1);
      userService.add(user1);

      Car car2 = new Car("model2", 2);
      User user2 = new User("User2", "Lastname2", "user2@mail.ru", car2);
      user2.setCar(car2);
      userService.add(user2);

      Car car3 = new Car("model3", 3);
      User user3 = new User("User3", "Lastname3", "user3@mail.ru", car3);
      user3.setCar(car3);
      userService.add(user3);

      userService.addCar(new Car("gaga", 5));


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
