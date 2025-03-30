package cl.ignaciolp;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Disposable;

public class GameTextures implements Disposable {
    private Texture textureMine;
    private Texture textureEmpty;
    private Texture textureOne;
    private Texture texture;

    public GameTextures(){
        texture = new Texture("tapado.png");
        textureMine = new Texture("mina.png");
        textureEmpty = new Texture("hueco.png");
        textureOne = new Texture("1.png");
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

    public Texture GetOne(){
        return textureOne;
    }

    @Override
    public void dispose() {
        texture.dispose();
        textureMine.dispose();
        textureEmpty.dispose();
        textureOne.dispose();
    }
}
