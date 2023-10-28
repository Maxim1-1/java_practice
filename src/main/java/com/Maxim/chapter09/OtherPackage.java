package com.Maxim.chapter09;

class OtherPackage {
    OtherPackage() {
        com.Maxim.chapter09.Protection pkgObject02 = new com.Maxim.chapter09.Protection();
        System.out.println("Конструктор из другого пакета pkg02");

        //ОШИБКА!!! доступно только для данного класса Protection или пакета pkg01
        //System.out.println("n = " + pkgObject02.n);
        //ОШИБКА!!! доступно только для данного класса Protection
        //System.out.println("n_priv = " + pkgObject02.npriv);
        //ОШИБКА!!! доступно только для данного класса Protection, подкласса Derived или пакета pkg01
        //System.out.println("n_priv = " + pkgObject02.npriv);

        System.out.println("n_publ = " + pkgObject02.n_publ);

    }
}
