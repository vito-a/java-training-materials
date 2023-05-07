package org.example;

public class DogsClones {
    public void showDogsClones () {
        int[] a = {1,2,3};
        int[] b = a.clone();

        System.out.println(a == b ? "Same Instance":"Different Instance");
        Dog[] myDogs = new Dog[4];

        myDogs[0] = new Dog("Wolf");
        myDogs[1] = new Dog("Pepper");
        myDogs[2] = new Dog("Bullet");
        myDogs[3] = new Dog("Sadie");

        // then clone dog...
        Dog[] myDogsClone = myDogs.clone();

        // the arrays refer to the same elements...
        System.out.println(myDogs[0] == myDogsClone[0] ? "Same":"Different");
        System.out.println(myDogs[1] == myDogsClone[1] ? "Same":"Different");
        System.out.println(myDogs[2] == myDogsClone[2] ? "Same":"Different");
        System.out.println(myDogs[3] == myDogsClone[3] ? "Same":"Different");
        //Outputs Same (4 Times)

        // This means if we modify an object accessed through the cloned array, the changes will be reflected when we access the same object in the source array, since they point to the same reference.
        myDogsClone[0].setName("Ruff");
        System.out.println(myDogs[0].getName());
        //Outputs Ruff

        // However, changes to the array itself will only affect that array.
        myDogsClone[1] = new Dog("Spot");
        System.out.println(myDogsClone[1].getName());
        System.out.println(myDogs[1].getName());
        //Outputs Spot
        //        Pepper
    }
}
