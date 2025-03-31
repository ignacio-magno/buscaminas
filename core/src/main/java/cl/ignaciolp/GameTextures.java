package cl.ignaciolp;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Disposable;

public class GameTextures implements Disposable {
    private Texture textureMine;
    private Texture textureEmpty;
    private Texture textureOne;
    private Texture TextureTwo;
    private Texture TextureThree;
    private Texture TextureFour;
    private Texture TextureFive;
    private Texture TextureSix;
    private Texture TextureSeven;
    private Texture TextureEight;
    private Texture TextureFlag;
    private Texture texture;

    public GameTextures(){
        texture = new Texture("tapado.png");
        textureMine = new Texture("mina.png");
        textureEmpty = new Texture("hueco.png");
        // for one to eight
        textureOne = new Texture("1.png");
        TextureTwo = new Texture("2.png");
        TextureThree = new Texture("3.png");
        TextureFour = new Texture("4.png");
        TextureFive = new Texture("5.png");
        TextureSix = new Texture("6.png");
        TextureSeven = new Texture("7.png");
        TextureEight = new Texture("8.png");

        TextureFlag = new Texture("bandera.png");
    }

    public Texture GetDefault(){
        return texture;
    }

    public Texture GetMine(){
        return textureMine;
    }

    public Texture GetEmpty(){
        return textureEmpty;
    }

    public Texture GetNumber(int number){
        switch (number){
            case 1:
                return textureOne;
            case 2:
                return TextureTwo;
            case 3:
                return TextureThree;
            case 4:
                return TextureFour;
            case 5:
                return TextureFive;
            case 6:
                return TextureSix;
            case 7:
                return TextureSeven;
            case 8:
                return TextureEight;
            default:
                return textureEmpty;
        }
    }

    public Texture GetFlag(){
        return TextureFlag;
    }

    @Override
    public void dispose() {
        texture.dispose();
        textureMine.dispose();
        textureEmpty.dispose();
        textureOne.dispose();
        TextureTwo.dispose();
        TextureThree.dispose();
        TextureFour.dispose();
        TextureFive.dispose();
        TextureSix.dispose();
        TextureSeven.dispose();
        TextureEight.dispose();
        TextureFlag.dispose();
    }
}
