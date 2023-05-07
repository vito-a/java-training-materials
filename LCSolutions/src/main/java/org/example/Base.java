package org.example;

class Child extends Base {
    int x = 20;
    Child()  {
        System.out.println("Child constr");
        show();           }
    void  show() {
        System.out.println("Child Show " + x +"  ");       }
}
class Base{
    int x = 10;
    Base() {
        System.out.println("Base constr");
        show();          }
    void show() {   System.out.println ("Base Show " + x + "  ");      }
}
