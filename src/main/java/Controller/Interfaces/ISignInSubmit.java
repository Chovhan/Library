package Controller.Interfaces;

public interface ISignInSubmit {

    public byte[] getSalt();

    public String saltPasswords(String string, byte[] bytes);
}