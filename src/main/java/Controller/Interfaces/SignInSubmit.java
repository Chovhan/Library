package Controller.Interfaces;

public interface SignInSubmit {

    public byte[] getSalt();

    public String saltPasswords(String string, byte[] bytes);
}