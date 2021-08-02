/**
 * Method calling, constructors
 */
class Prog {
    void hello(){ //method (no-arg)
        System.out.println("hello");
    }
    void hello(String h){ // parameterised
        System.out.println("HELLO");
    }

    String hello; //variables defined
    int num;
    
    void hello(String hh, int n){ // another parameterised
        hello=hh; //assigning/referencing the defined variables to parameters in the method
        num=n;
        System.out.println(hh + ", " + n);
    }
    
    Prog(){ // constructor
        System.out.println("Empty constructor");
    }   
    Prog(String hello){ //calling the same declared String above, otherwise, error
        this.hello = hello;
        System.out.println("parameterised constructor");
    }
    public static void main(String args[]) {
        Prog p = new Prog(); //instance, Also, calls constructor as it is created
        p.hello(); //calling the method
        p.hello("gg"); // calling another method
        p.hello("aa",7); //calling another method

        Prog pp = new Prog(); // creating another instance with the same class
        pp.hello(); //calling the method, Also, calls constructor as it is created
        
        Prog ppp = new Prog("ha, parameterised constructor"); //creating another instance using parameterised constructor
        System.out.println(ppp.hello); //getting the above generated value
    }
}
/**
 * Inheritence
 */ 
class Color {
    void blue() {
        System.out.println("Blue Color");
    }
    void red() {
        System.out.println("red color");
    }
}
class Iridescent extends Color{
    void white(){
        System.out.println("white color");
    }
    public static void main(String[] args) { //Single-Inheritence
        System.out.println("---IS-A Method overriding---");
        Iridescent i = new Iridescent();
        i.blue(); //inherited object
        i.red(); //inherited object
        i.white(); //current class' object
        System.out.println("---HAS-A Method overriding---");
        Color c = new Color();
        c.blue();
        c.red();
    }
}
class MultiColor extends Iridescent{ //Multi-level Inheritence
    void black(){
        System.out.println("black color");
    }
    public static void main(String[] args) {
        MultiColor m = new MultiColor();
        m.blue();
        m.red();
        m.white();
        m.black();
        //mix
        
        Iridescent ii = new Iridescent();
        ii.blue();
        ii.red();
        ii.white();
        //black,mix
        
        Color cc = new Color();
        cc.blue();
        cc.red();
        //white,black,mix
    }
}
class ColorMix extends Color{ //Hierarichal inheritance
    void mix(){
        System.out.println("mix color");
    }
    public static void main(String[] args) {
        ColorMix cm = new ColorMix();
        cm.blue();
        cm.red();
        cm.mix();
        //white,black
    }
}

/**
 * Abstraction
 * Using Interfaces
 */
interface ColorTest{
    void colorDisplay();
    default void cd(){}
    static void cd1(){}
    private void cd2(){} //private can be declared in v.9
}
interface ColorTest2{
    void colorPrint();
}
class CTest implements ColorTest, ColorTest2{ //Multiple Inheritance can be achieved using Intefaces
    @Override
    public void colorDisplay() {
        System.out.println("displaying color");
    }
    public void colorPrint(){
        System.out.println("printing color");
    }
    public static void main(String[] args) {
        CTest ct = new CTest();
        ct.colorDisplay();
        ct.colorPrint();
    }
}

/**
 * Abstraction
 * Using Abstract class
 */
abstract class Engg{
    abstract void subject();
}
class Electronics extends Engg{
    @Override
    void subject() {
        System.out.println("design");
    }
    //main method can be called in any Sequence
    public static void main(String[] args) {
        // abstract class cant be instantiated (below)
        //Engg engg = new Engg(); 
        Electronics ece = new Electronics();
        ece.subject();
        Electricals eee = new Electricals();
        eee.subject();
    }   
}
class Electricals extends Engg{
    @Override
    void subject() {
        System.out.println("circuit");
    }
    //main method can be called in any Sequence
    public static void main(String[] args) {
        // abstract class cant be instantiated (below)
        //Engg engg = new Engg(); 
        Electronics ece = new Electronics();
        ece.subject();
        Electricals eee = new Electricals();
        eee.subject();
    }   
}

/**
 * Polymorphism
 */
class Poly{
    void form(){
        System.out.println("Empty Form");
    }
    void form(String f){
        System.out.println("form1");
    }
    void form(String f, String ff){
        System.out.println("form2");
    }
    public static void main(String[] args) {
        Poly poly = new Poly();
        poly.form();
        poly.form("f");
        poly.form("a", "ff");
    }
}

/**
 * Abstraction (Overriding)
 */
interface Inter{
    void interIntra();
}
abstract class Intra{ // hidden
    abstract void intraInter();
    void ii(){
        System.out.println("superClass");
    }
}
class Intermediate implements Inter{
    public void interIntra(){}
    void ii(){ // overridden
        System.out.println("subClass");
        // abstract methods cant be invoked (below)
        // super.ii();
    }
    public static void main(String[] args) {
        Intermediate in = new Intermediate();
        in.ii(); // subclass
    }
}

/**
 * Method overriding 1
*/
class Over{
    String show(){
        System.out.println("String show");
        return null;
    }
}
class Ride{
    int show(){
        System.out.println("int show");
        return 12345;
    }
    public static void main(String[] args) {
        Over o = new Over();
        o.show();
        Ride r = new Ride();
        r.show();
    }
}
/**
 * Method overriding 2
*/
abstract class New{
    // abstract void disp();
    void show() throws RuntimeException{
        System.out.println("Throwing super-class exception");
    }
}
class Old extends New{
    // void disp(){}
    void show(){
        System.out.println("throwing sub-class exception");
    }
    public static void main(String[] args) {
        Old old = new Old();
        old.show();
    }
}