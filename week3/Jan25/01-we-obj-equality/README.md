# We Do: Object Equality Code-Along

**Starter & Solved Folders:** [01-we-obj-equality](./)

In this exercise, you will learn about the effect that the `equals` and `hashcode` methods have on object equality.

Follow along with the instructor throughout the exercise.

## Instructions

1. Checking deep equality involves telling the program how to measure the equality of two objects.  This means that you need to implement (more technically, override) the `equals` method.

To achieve this, use the IntelliJ IDE to generate the `equals` method:

- Right-click on your class, then select Generate.

- Select the `equals()` and `hashCode()` option.

- Select Next throughout the subsequent windows to generate the `equals` method.

2. Modify the `Dog` object from the starter project to match the following, explaining the code as you go:

    ```java
    public class Dog {

      private int age;
      private String color;
      private String favToy;

      // Getters and setters omitted for brevity

      @Override
      public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          Dog dog = (Dog) o;
          return getAge() == dog.getAge() &&
                  Objects.equals(getColor(), dog.getColor()) &&
                  Objects.equals(getFavToy(), dog.getFavToy());
      }

      @Override
      public int hashCode() {
          return Objects.hash(getColor(), getAge(), getFavToy());
      }

    }
    ```

3. Create the following simple test to demonstrate the effect of `equals` on testing:

    ```java
    public class SampleTest {

      @Test
      public void shouldSayDogsAreEqual() {
          Dog dog1 = new Dog();
          dog1.setAge(3);
          dog1.setColor("Brown");
          dog1.setFavToy("Squeaky");

          Dog dog2 = new Dog();
          dog2.setAge(3);
          dog2.setColor("Brown");
          dog2.setFavToy("Squeaky");

          assertEquals(dog1, dog2);
      }
    }
    ```

4. Run the test with and without the `equals` and `hashcode` methods present in the `Dog` class to demonstrate their effect.

---

© 2022 2U. All Rights Reserved.
