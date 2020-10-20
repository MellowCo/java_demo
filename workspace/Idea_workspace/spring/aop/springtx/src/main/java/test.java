import config.SpringConfig;
import dao.impl.PersonDoaImpl2;
import entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class test {
    public static void main(String[] args) {
        // ApplicationContext ac = new ClassPathXmlApplicationContext("springConfig.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        PersonDoaImpl2 personDao = ac.getBean("personDao", PersonDoaImpl2.class);


        personDao.queryPerson();
        personDao.addPerson(new Person(4,"bob",12));
        personDao.queryPerson();
        personDao.queryPersonById(2);
        personDao.updatePerson(new Person(4,"op",15));
        personDao.queryPersonById(4);
    }
}
