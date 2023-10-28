package com.Maxim.chapter09;



class TestBalance {
    public static void main(String[] args) {
        /* Класс Balance объявлен как puЬlic, поэтому им можно
           воспользоваться и вызвать его конструктор. */
        Balance test = new Balance("J.J.Jaspers", 99.88);
        test.show(); //можно также вызвать метод show()
    }
}
/* ----------------
J.J.Jaspers: $99.88
 */