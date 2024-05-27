package org.example.Base;

public class testAuthor {
    public static void main(String[] args) {
        author a1 = new author("Сергей", "skyrimwell@gmail.com", 'М');

        System.out.println("Имя: " + a1.getName() + " | email: " + a1.getEmail() + " | пол: " + a1.getGender());
        a1.setEmail("gorodnov.s.a@mirea.ru");
        System.out.println(a1);
    }
}