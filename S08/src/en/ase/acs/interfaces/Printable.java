package en.ase.acs.interfaces;

@FunctionalInterface
//this ensures that you can not add another method inside this interface
public interface Printable {
    public String log(String message);
}


