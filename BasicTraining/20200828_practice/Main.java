public class Main {
  public static void main(String[] args) {
    // Final = niet te veranderen
    // Static = voor alle objecten van de class altijd hetzelfde

    // extends
    // super.method()
    // super() to call parent
    // overwrites
    // ===========================================================


    Member a1 = new Member();
    a1.name = "Han";
    a1.HP = 200;
    a1.maxHP = 200;
    a1.role = "Healer";

    Member a2 = new Member();
    a2.name = "Yi";
    a2.HP = 200;
    a2.maxHP = 350;
    a2.role = "Tank";

    a1.identify();
    a2.identify();

    a1.heal(120, a2);
    a2.identify();


  }
}

// class Ally and class Enemy?
// parent Ally aan some members, parent enemy aan some members.
// class weapon?

class Weapon{
  int WpDmg;
  int WpSpeed;

}

class Member{
  // define fields
  String name;
  int HP;
  int maxHP;
  int speed;
  String role;

  //define methods
  // identifies the member
  void identify(){
    System.out.println(
      "I am " + name + ", I am a " + role
      + " HP: " + String.valueOf(HP) + "/" + String.valueOf(maxHP));
  }

  void damage(int dmg, Member target){
    int newHP = target.HP - dmg;
    if (newHP <= 0){
      target.HP = 0;
    }
  }

  void heal(int healing, Member target){
    int newHP = target.HP + healing;
    if (newHP > target.maxHP){
      target.HP = target.maxHP;
    } else{
      target.HP = newHP;
    }
  }

}


/*
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) {

    Werknemer size = new Werknemer("H", 6);
    System.out.println(size.sectorIt + " " + size.teamSize);
    }
  }


class Bedrijf {
  String bedrijfsnaam;
  String oprichter;
  String sector;
  boolean sectorIt = true;

  Bedrijf(String bedrijfsnaam) {
    this.bedrijfsnaam = bedrijfsnaam;
  }
}

class Functie extends Bedrijf {
  String afdeling;
  int teamSize = 8;

  Functie(String bedrijfsnaam) {
    super(bedrijfsnaam);
  }
}

class Werknemer extends Functie {

  Werknemer(String bedrijfsnaam, int teamSize){
    super(bedrijfsnaam);
    this.teamSize = teamSize;
  }
}






  //final String inDienstTreding;
  //static String bedrijfsnaam;
  //static final String oprichter;


// Final = niet te veranderen
// Static = voor alle objecten van de class altijd hetzelfde

*/
