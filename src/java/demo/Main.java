package demo;

import dao.StudentDao;
import domain.Student;
import java.util.List;

/**
 * jdbc连接数据库，并且进行增删改查
 */
public class Main {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();
        studentDao.insert(new Student("Sara","male",13));
        List<Student> list = studentDao.getAll();
        System.out.println("===============================");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("===============================");
        studentDao.update(new Student("Bean","",56));
        studentDao.delete("Sara");
        list = studentDao.getAll();
        System.out.println("===============================");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("===============================");
    }
}
